package com.contact.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.contact.exceptionhandler.*;

@ControllerAdvice

public class GlobalException
{
		
		@ExceptionHandler(UserNameAlreadyExist.class)
		public ResponseEntity<?> handleUserNameAlreadyExistException(UserNameAlreadyExist ex)
		{
			return new  ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(EmailAlreadyExist.class)
		public ResponseEntity<?> handleEmailAlreadyExistException(EmailAlreadyExist ex)
		{
			return new  ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(MobileNumberAlreadyExist.class)
		public ResponseEntity<?> handleMobileNumberAlreadyExistException(MobileNumberAlreadyExist ex)
		{
			return new  ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
}
