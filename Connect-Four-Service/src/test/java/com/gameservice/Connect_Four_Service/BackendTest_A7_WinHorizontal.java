package com.gameservice.Connect_Four_Service;

import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

import junit.framework.TestCase;

public class BackendTest_A7_WinHorizontal extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus =  (GameStatus) manager.createGameSession();
		
		/*
		 * PATTERN
		 * 
		 * - - - - - - -
		 * - - - - - - -
		 * - - - - - - -
		 * - - - - - - -
		 * B B B - - - -
		 * R R R R - - -
		 * 
		 */
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 1);
		
		manager.processMove(createStatus.getId(), 1, 2);
		manager.processMove(createStatus.getId(), 2, 2);
		
		manager.processMove(createStatus.getId(), 1, 3);
		manager.processMove(createStatus.getId(), 2, 3);
		
		GameStatus winStatus = (GameStatus) manager.processMove(createStatus.getId(), 1, 4);
		
		System.out.println(winStatus.getStatus());
		
		assertEquals(winStatus.getStatus(), StatusCodes.PLAYER_ONE_WINS);
		
	}

}
