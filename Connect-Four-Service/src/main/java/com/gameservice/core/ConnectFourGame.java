package com.gameservice.core;

import java.io.Serializable;

import com.gameservice.core.ConnectFourBoard.GameToken;
import com.gameservice.data.MoveRecord;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

public class ConnectFourGame implements Serializable {
	
	public static final long serialVersionUID = 1000L;

	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	
	private final GameToken PLAYER_ONE_TOKEN = GameToken.R;
	private final GameToken PLAYER_TWO_TOKEN = GameToken.B;
	
	private int id;
	
	private int currentPlayer = 0;
	private ConnectFourBoard gameBoard;
	
	private GameStatus gameStatus;
	
	public ConnectFourGame(int id){
		this.id = id;
		currentPlayer = PLAYER_ONE;
		gameBoard = new ConnectFourBoard();
		gameStatus = constructGameStatus(StatusCodes.NEW_GAME, "New Game Successfully Started");
	}
	
	public int getID()
	{
		return id;
	}
	
	public GameStatus processMove(int playerNumber, int columnNumber)
	{
		
		if(gameStatus.isComplete())
		{
			return constructGameStatus(gameStatus.getStatus(), "Game already completed.", true);
		}

		if(playerNumber != currentPlayer)
		{
			return constructGameStatus(StatusCodes.INVALID_PLAYER, "It is not Player " + playerNumber + "'s move");
		}
		
		//Hide zero-based indexing from front-end
		columnNumber -= 1;
		
		if(!gameBoard.isFreeSpaceInColumn(columnNumber))
		{
			return constructGameStatus(StatusCodes.INVALID_MOVE, "No Space in Selected Column");
		}
		
		//Space in column is open, move is valid
		MoveRecord move = gameBoard.placeGamePiece(columnNumber, getCurrentPlayerToken());
		
		//Check if Game is over
		if(gameBoard.checkForWin(move.COLUMN, move.ROW))
		{
			if(currentPlayer == PLAYER_ONE)
			{
				return constructGameStatus(StatusCodes.PLAYER_ONE_WINS, "Player One Wins!", true);
			}
			else
			{
				return constructGameStatus(StatusCodes.PLAYER_TWO_WINS, "Player Two Wins!", true);
			}
		}
		
		if(gameBoard.checkIfDraw())
		{
			return constructGameStatus(StatusCodes.GAME_OVER_DRAW, "Out of Moves. Game is a Draw.");
		}
		
		//Move is successful, game not over, switch to player twos turn
		switchTurn();
		
		return constructGameStatus(StatusCodes.SUCCESSFUL_MOVE, "Move Successfully Made");
		
	}
	
	public GameStatus getGameStatus()
	{
		return gameStatus;
	}
	
	public GameStatus constructGameStatus(int status, String message)
	{
		gameStatus = new GameStatus(id, gameBoard.getBoard(), currentPlayer, status, message);
		return gameStatus;
	}
	
	private GameStatus constructGameStatus(int status, String message, boolean isComplete)
	{
		gameStatus = new GameStatus(id, gameBoard.getBoard(), currentPlayer, status, message, isComplete);
		return gameStatus;
	}
	
	
	private void switchTurn()
	{
		if(currentPlayer == PLAYER_ONE)
		{
			currentPlayer = PLAYER_TWO;
		}
		else
		{
			currentPlayer = PLAYER_ONE;
		}
	}
	private GameToken getCurrentPlayerToken()
	{
		if(currentPlayer == PLAYER_ONE)
		{
			return PLAYER_ONE_TOKEN;
		}
		else
		{
			return PLAYER_TWO_TOKEN;
		}
	}
}
