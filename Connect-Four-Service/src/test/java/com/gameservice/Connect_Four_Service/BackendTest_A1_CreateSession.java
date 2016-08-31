package com.gameservice.Connect_Four_Service;

import com.gameservice.core.ConnectFourService;
import com.gameservice.state.Status;
import com.gameservice.state.StatusCodes;

import junit.framework.TestCase;

public class BackendTest_A1_CreateSession extends TestCase {
	
	public void test() 
	{
		ConnectFourService manager = new ConnectFourService();
		Status createStatus = manager.createGameSession();
		assertEquals(createStatus.getStatus(), StatusCodes.NEW_GAME);
	}

}
