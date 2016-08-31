package com.gameservice.state;

import java.io.Serializable;

public abstract class Status implements Serializable {
	
	public static final long serialVersionUID = 2000L;
	

	protected int status;
	protected String message;
	
	public Status(){};
	
	public Status(int statusCode, String message)
	{
		this.status = statusCode;
		this.message = message;
	}
		
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int newStatus)
	{
		status = newStatus;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String newMessage)
	{
		message = newMessage;
	}
	

}
