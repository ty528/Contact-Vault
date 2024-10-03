package com.contact.exceptionhandler;

public class MobileNumberAlreadyExist extends RuntimeException 
{
	public MobileNumberAlreadyExist(String message)
	{
		super(message);
	}
}
