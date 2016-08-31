package com.gameservice.Connect_Four_Service;

import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

import junit.framework.TestCase;

public class BackendTest_B1_Draw extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus =  (GameStatus) manager.createGameSession();
		
		/*
		 * PATTERN
		 * 
		 * B R B R B R B
		 * B R B R B R R
		 * B R B R B R B
		 * R B R B R B R
		 * R B R B R B B
		 * R B R B R B R
		 * 
		 */
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 2);
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 2);
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 2);
		
		manager.processMove(createStatus.getId(), 1, 2);
		manager.processMove(createStatus.getId(), 2, 1);
		manager.processMove(createStatus.getId(), 1, 2);
		manager.processMove(createStatus.getId(), 2, 1);
		manager.processMove(createStatus.getId(), 1, 2);
		manager.processMove(createStatus.getId(), 2, 1);
		
		
		manager.processMove(createStatus.getId(), 1, 3);
		manager.processMove(createStatus.getId(), 2, 4);
		manager.processMove(createStatus.getId(), 1, 3);
		manager.processMove(createStatus.getId(), 2, 4);
		manager.processMove(createStatus.getId(), 1, 3);
		manager.processMove(createStatus.getId(), 2, 4);

		
		manager.processMove(createStatus.getId(), 1, 4);
		manager.processMove(createStatus.getId(), 2, 3);
		manager.processMove(createStatus.getId(), 1, 4);
		manager.processMove(createStatus.getId(), 2, 3);
		manager.processMove(createStatus.getId(), 1, 4);
		manager.processMove(createStatus.getId(), 2, 3);
		

		
		manager.processMove(createStatus.getId(), 1, 5);
		manager.processMove(createStatus.getId(), 2, 6);
		manager.processMove(createStatus.getId(), 1, 5);
		manager.processMove(createStatus.getId(), 2, 6);
		manager.processMove(createStatus.getId(), 1, 5);
		manager.processMove(createStatus.getId(), 2, 6);
		
		
		manager.processMove(createStatus.getId(), 1, 6);
		manager.processMove(createStatus.getId(), 2, 5);
		manager.processMove(createStatus.getId(), 1, 6);
		manager.processMove(createStatus.getId(), 2, 5);
		manager.processMove(createStatus.getId(), 1, 6);
		manager.processMove(createStatus.getId(), 2, 5);
				
		
		manager.processMove(createStatus.getId(), 1, 7);
		manager.processMove(createStatus.getId(), 2, 7);
		manager.processMove(createStatus.getId(), 1, 7);
		manager.processMove(createStatus.getId(), 2, 7);
		manager.processMove(createStatus.getId(), 1, 7);
		GameStatus drawStatus = (GameStatus) manager.processMove(createStatus.getId(), 2, 7);
		
		assertEquals(drawStatus.getStatus(), StatusCodes.GAME_OVER_DRAW);
		
		
		
	}

}
