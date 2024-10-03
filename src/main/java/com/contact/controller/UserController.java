package com.contact.controller;

import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Users;
import com.contact.service.JWTService;
import com.contact.service.MyUserDetailsService;
import com.contact.service.UserService;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class UserController
{
	
		@Autowired
		UserService userService;
		
		@Autowired
		MyUserDetailsService service;
		
		@Autowired
		JWTService jwtS;
		
		
		@PostMapping("/register")
		public ResponseEntity<?> register(@RequestBody Users user)
		{
			userService.register(user);
			return new ResponseEntity<String>("Register Success",HttpStatus.CREATED);
		}
		
		@GetMapping("/login")
		public ResponseEntity<String> login(@RequestBody Users user)
		{
			
			Users user1=null;
			user1=userService.getUserName(user);
			if(user1!=null)
			{
				UserDetails userD=service.loadUserByUsername(user1.getUserName());
				return new ResponseEntity<String>(jwtS.generateToken(user.getEmail()),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
			}
		}
		

}
