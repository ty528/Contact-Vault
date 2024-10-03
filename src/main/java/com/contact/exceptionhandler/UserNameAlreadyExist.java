package com.contact.exceptionhandler;

public class UserNameAlreadyExist extends RuntimeException 
{
	public UserNameAlreadyExist(String message)
	{
		super(message);
	}
}
