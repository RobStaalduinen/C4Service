package com.gameservice.Connect_Four_Service;

import junit.framework.TestCase;
import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

public class BackendTest_A4_InvalidPlayer extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus =  (GameStatus) manager.createGameSession();
		//Initial move from Player 1
		manager.processMove(createStatus.getId(), 1, 1);
		//Second move from Player 1 - illegal
		GameStatus placementStatus = (GameStatus) manager.processMove(createStatus.getId(), 1, 1);
		
		assertEquals(placementStatus.getStatus(), StatusCodes.INVALID_PLAYER);
	}

}
