package com.gameservice.state;

public class ErrorStatus extends Status {
	
	public static final long serialVersionUID = 2002L;
	
	public ErrorStatus(int status, String message)
	{
		super(status, message);
	}

}
