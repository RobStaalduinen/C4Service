package com.gameservice.core;

import javax.jws.WebService;
import javax.jws.WebParam;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;

import com.gameservice.data.GameStore;
import com.gameservice.data.RedisStore;
import com.gameservice.state.ErrorStatus;
import com.gameservice.state.Status;
import com.gameservice.state.StatusCodes;



@SuppressWarnings("restriction")
@WebService(serviceName = "ConnectFour")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ConnectFourService {
	private GameStore gameStore = initializeStore();
	
	//Ideally would be configurable through application config file
	private final boolean isUsingRedis = false;
	
	@WebMethod(operationName = "createGameSession")
	public Status createGameSession()
	{
		return gameStore.createNewGameSession();
	}
	
	@WebMethod(operationName = "processMove")
	public Status processMove(@WebParam(name="gameId") int gameId, @WebParam(name="player") int player, @WebParam(name="columnNumber") int columnNumber)
	{
		ConnectFourGame currentGame = retrieveGame(gameId);
		if(currentGame == null)
		{
			return getNullStatus();
		}
		synchronized(currentGame)
		{
			return currentGame.processMove(player, columnNumber);
		}
	}
	
	@WebMethod(operationName = "getGameStatus")
	public Status getGameStatus(@WebParam(name="gameId") int gameId)
	{
		ConnectFourGame currentGame = retrieveGame(gameId);
		if(currentGame == null)
		{
			return getNullStatus();
		}
		synchronized(currentGame)
		{
			return currentGame.getGameStatus();
		}
	}
	
	private ConnectFourGame retrieveGame(int id)
	{
		return gameStore.getGame(id);
	}
	
	private Status getNullStatus()
	{
		return new ErrorStatus(StatusCodes.GAME_NOT_FOUND, "Game Not Found");
	}
	
	private GameStore initializeStore()
	{
		if(isUsingRedis)
		{
			return new RedisStore();
		}
		else{
			return new GameStore();
		}
	}

}
