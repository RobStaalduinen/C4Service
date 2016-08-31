package com.gameservice.Connect_Four_Service;

import junit.framework.TestCase;
import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;
import com.gameservice.state.StatusCodes;

public class BackendTest_A6_WinVertical extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus =  (GameStatus) manager.createGameSession();
		
		/*
		 * PATTERN
		 * 
		 * - - - - - - -
		 * - - - - - - -
		 * R - - - - - -
		 * R B - - - - -
		 * R B - - - - -
		 * R B - - - - -
		 * 
		 */
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 2);
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 2);
		
		manager.processMove(createStatus.getId(), 1, 1);
		manager.processMove(createStatus.getId(), 2, 2);
		
		GameStatus winStatus = (GameStatus) manager.processMove(createStatus.getId(), 1, 1);
		
		assertEquals(winStatus.getStatus(), StatusCodes.PLAYER_ONE_WINS);
		
	}

}
