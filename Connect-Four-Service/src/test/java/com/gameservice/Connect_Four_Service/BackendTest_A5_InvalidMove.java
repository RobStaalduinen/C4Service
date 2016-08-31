package com.gameservice.Connect_Four_Service;

import junit.framework.TestCase;
import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

public class BackendTest_A5_InvalidMove extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus =  (GameStatus) manager.createGameSession();
		
		//Fill single column with tokens
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 1);
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 1);
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 1);
		
		//No room in column, invalid move
		GameStatus placementStatus = (GameStatus) manager.processMove(createStatus.getId(), 1, 1);
		
		assertEquals(placementStatus.getStatus(), StatusCodes.INVALID_MOVE);
		
	}

}
