package com.gameservice.core;

import java.io.Serializable;
import java.util.Arrays;

import com.gameservice.data.MoveRecord;


public class ConnectFourBoard  implements Serializable {
	
	public static final long serialVersionUID = 3000L;
	
	public enum GameToken { R, B };
	
	private final String EMPTY_SPACE = "-";
	private final int MAX_COLUMNS = 7;
	private final int MAX_ROWS = 6;
	
	private String[][] board;
	
	private int numPositionsOccupied = 0;
	
	public ConnectFourBoard()
	{
		initializeBoard();
	}
	
	public String[][] getBoard()
	{
		return board;
	}
	
	public boolean isFreeSpaceInColumn(int columnNumber)
	{
		String[] column = board[columnNumber];
		for(int i = 0; i < MAX_ROWS; i++)
		{
			if(column[i].equals(EMPTY_SPACE))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public MoveRecord placeGamePiece(int columnNumber, GameToken token)
	{
		String[] columnArray = board[columnNumber];
		
		int rowNumber = -1;
		for(int i = 0; i < MAX_ROWS; i++)
		{
			if(columnArray[i].equals(EMPTY_SPACE))
			{
				rowNumber = i;
				board[columnNumber][rowNumber] = token.toString();
				numPositionsOccupied++;
				break;
			}
		}
		printGameBoard();
		System.out.println("----------");
		return new MoveRecord(columnNumber, rowNumber, token);
	}
	
	/*
	 * Checks for win condition centered around specified position
	 * 
	 */
	public boolean checkForWin(int column, int row)
	{
		String tokenToCheck = board[column][row];
		if(tokenToCheck == EMPTY_SPACE)
		{
			return false;
		}
		
		//Check Vertical - 3 tokens down from last move
		int numberOfTokens = 1;
		if(row >= 3)
		{
			for(int i = 1; i < 4; i++)
			{
				if(board[column][row - i] == tokenToCheck)
				{
					numberOfTokens++;
				}
				else
				{
					break;
				}
			}
			
			if(numberOfTokens >= 4)
			{
				return true;
			}
		}
		
		
		//Check Horizontal - Check full row across
		numberOfTokens = 0;
		for(int i = 0; i < MAX_COLUMNS; i++)
		{
			if(board[i][row] == tokenToCheck)
			{
				numberOfTokens++;
				if(numberOfTokens == 4)
				{
					return true;
				}
			}
			else
			{
				numberOfTokens = 0;
			}
		}
		
		//Diagonal - Bottom left to Top Right
		
		//Find nearest bottom-left edge
		int nearestEdge = Math.min(column, row);
		int startColumn = column - nearestEdge;
		int startRow = row - nearestEdge;
		
		
		numberOfTokens = 0;
		
		//Check diagonal - cannot exceed height of board
		for(int i = 0; i < MAX_ROWS-1; i++)
		{
			if((startColumn + i) >= MAX_COLUMNS || (startRow + i) >= MAX_ROWS)
			{
				break;
			}
			
			if(board[startColumn + i][startRow + i] == tokenToCheck)
			{
				numberOfTokens++;
				if(numberOfTokens == 4)
				{
					return true;
				}
			}
			else
			{
				numberOfTokens = 0;
			}
		}
		
		//Diagonal - Bottom right to Top Left
		
		//Find nearest bottom-right edge
		nearestEdge = Math.min((MAX_COLUMNS - 1 - column), row);
		startColumn = column + nearestEdge;
		startRow = row - nearestEdge;
		
		
		numberOfTokens = 0;
		
		//Check diagonal - cannot exceed height of board
		for(int i = 0; i < MAX_ROWS-1; i++)
		{
			if((startColumn - i) < 0 || (startRow + i) >= MAX_ROWS)
			{
				break;
			}
			
			if(board[startColumn - i][startRow + i] == tokenToCheck)
			{
				numberOfTokens++;
				if(numberOfTokens == 4)
				{
					return true;
				}
			}
			else
			{
				numberOfTokens = 0;
			}
		}
		return false;
	}
	
	public boolean checkIfDraw()
	{
		if(numPositionsOccupied == (MAX_ROWS * MAX_COLUMNS))
		{
			return true;
		}
		return false;
	}
	
	
	public void printGameBoard()
	{
		for(int i = MAX_ROWS - 1; i >= 0; i--)
		{
			for(int j = 0; j < MAX_COLUMNS; j++)
			{
				System.out.print(board[j][i] + " ");
			}
			System.out.println("");
		}
	}
	
	private void initializeBoard()
	{
		board = new String[MAX_COLUMNS][MAX_ROWS];
		
		//Initialize arrays with empty spaces
		for(String[] column : board)
		{
			Arrays.fill(column, EMPTY_SPACE);
		}
		
		numPositionsOccupied = 0;
	}

}
