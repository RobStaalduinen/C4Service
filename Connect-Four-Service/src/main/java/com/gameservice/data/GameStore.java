package com.gameservice.data;

import java.util.HashMap;

import com.gameservice.core.ConnectFourGame;
import com.gameservice.state.Status;

/*
 * Simple storage system for multiple concurrent connect four games
 * 
 *
 * 
 */
public class GameStore {
	
	private HashMap<Integer, ConnectFourGame> gameMap = new HashMap<Integer, ConnectFourGame>();
	protected int idIndex = 0; //Incrementing ID
		
	public Status createNewGameSession()
	{
		synchronized(gameMap)
		{
			idIndex++;
			ConnectFourGame newGame = new ConnectFourGame(idIndex);
			gameMap.put(idIndex, newGame);
			return newGame.getGameStatus();
		}
	}
	
	public ConnectFourGame getGame(int id)
	{
		if(gameMap.containsKey(id))
		{
			return gameMap.get(id);
		}
		else
		{
			return null;
		}
	}

}
