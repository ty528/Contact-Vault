package com.contact.exceptionhandler;

public class EmailAlreadyExist extends RuntimeException 
{
		public EmailAlreadyExist(String message)
		{
			super(message);
		}
}
