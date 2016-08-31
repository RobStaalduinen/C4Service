package com.gameservice.state;


public class GameStatus extends Status {
	
	public static final long serialVersionUID = 2001L;

	protected int id;
	private boolean isComplete = false;
	private String[][] gameBoard;
	private int currentPlayer;


	
	public GameStatus()
	{
		super(StatusCodes.UNINITIALIZED, "Game Not Initialized");
		this.id = 0;
		this.isComplete = false;

	}
	
	
	public GameStatus(int id, String[][] gameBoard,int currentPlayer, int status, String message)
	{
		super(status, message);
		this.id = id;
		this.gameBoard = gameBoard;
		this.currentPlayer = currentPlayer;
		this.isComplete = false;
	}
	
	public GameStatus(int id, String[][] gameBoard, int currentPlayer, int status, String message, boolean isComplete)
	{	
		this(id, gameBoard, currentPlayer, status, message);
		this.isComplete = false;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int newID)
	{
		id = newID;
	}
	
	public boolean isComplete()
	{
		return isComplete;
	}
	
	public String[][] getGameBoard()
	{
		return gameBoard;
	}
	
	public void setGameBoard(String[][] newBoard)
	{
		gameBoard = newBoard;
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void setCurrentPlayer(int newPlayer)
	{
		currentPlayer = newPlayer;
	}
		
}
