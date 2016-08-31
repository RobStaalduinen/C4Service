package com.gameservice.Connect_Four_Service;

import junit.framework.Test;
import junit.framework.TestSuite;

public class BackendTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(BackendTestSuite.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BackendTest_A1_CreateSession.class);
		suite.addTestSuite(BackendTest_A2_ValidMove.class);
		suite.addTestSuite(BackendTest_A3_ValidMoveLocation.class);
		suite.addTestSuite(BackendTest_A4_InvalidPlayer.class);
		suite.addTestSuite(BackendTest_A5_InvalidMove.class);
		suite.addTestSuite(BackendTest_A6_WinVertical.class);
		suite.addTestSuite(BackendTest_A7_WinHorizontal.class);
		suite.addTestSuite(BackendTest_A8_WinDiagonalUp.class);
		suite.addTestSuite(BackendTest_A9_WinDiagonalDown.class);
		suite.addTestSuite(BackendTest_B1_Draw.class);
		//$JUnit-END$
		return suite;
	}

}
