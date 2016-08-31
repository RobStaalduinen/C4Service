package com.gameservice.Connect_Four_Service;

import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

import junit.framework.TestCase;

public class BackendTest_A9_WinDiagonalDown extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus =  (GameStatus) manager.createGameSession();
		
		/*
		 * PATTERN
		 * 
		 * - - - - - - -
		 * - - - - - - -
		 * B - - - - - -
		 * R B - - - - -
		 * B B B R - - -
		 * R R R B R - -
		 * 
		 */
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 1);
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 1);
		
		manager.processMove(createStatus.getId(), 1, 2);
		manager.processMove(createStatus.getId(), 2, 2);
		
		manager.processMove(createStatus.getId(), 1, 3);
		manager.processMove(createStatus.getId(), 2, 3);
		
		manager.processMove(createStatus.getId(), 1, 5);
		manager.processMove(createStatus.getId(), 2, 4);
		
		manager.processMove(createStatus.getId(), 1, 4);
		GameStatus winStatus = (GameStatus) manager.processMove(createStatus.getId(), 2, 2);
		
		assertEquals(winStatus.getStatus(), StatusCodes.PLAYER_TWO_WINS);
		
		
	}

}
