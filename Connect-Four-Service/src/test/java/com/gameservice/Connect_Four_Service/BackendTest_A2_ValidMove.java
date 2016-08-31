package com.gameservice.Connect_Four_Service;

import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

import junit.framework.TestCase;

public class BackendTest_A2_ValidMove extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus = (GameStatus) manager.createGameSession();
		
		GameStatus moveStatus = (GameStatus) manager.processMove(createStatus.getId(), 1, 1);
		
		assertEquals(moveStatus.getStatus(), StatusCodes.SUCCESSFUL_MOVE);
	}

}
