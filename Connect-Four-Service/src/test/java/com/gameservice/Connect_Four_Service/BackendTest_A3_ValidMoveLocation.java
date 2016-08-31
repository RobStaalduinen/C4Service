package com.gameservice.Connect_Four_Service;

import junit.framework.TestCase;

import com.gameservice.core.ConnectFourBoard.GameToken;
import com.gameservice.core.ConnectFourService;
import com.gameservice.state.GameStatus;

public class BackendTest_A3_ValidMoveLocation extends TestCase {
	
	public void test()
	{
		ConnectFourService manager = new ConnectFourService();
		GameStatus createStatus = (GameStatus) manager.createGameSession();
		GameStatus placementStatus = (GameStatus) manager.processMove(createStatus.getId(), 1, 1);
		
		

		assertEquals(placementStatus.getGameBoard()[0][0], GameToken.R.toString());
	}

}
