package com.gameservice.data;

import com.gameservice.core.ConnectFourBoard.GameToken;

public class MoveRecord {
	
	public int COLUMN;
	public int ROW;
	public GameToken TOKEN;
	
	public MoveRecord(int column, int row, GameToken token)
	{
		this.COLUMN = column;
		this.ROW = row;
		this.TOKEN = token;
	}

}
