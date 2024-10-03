package com.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.contact.exceptionhandler.EmailAlreadyExist;
import com.contact.exceptionhandler.MobileNumberAlreadyExist;

import com.contact.exceptionhandler.UserNameAlreadyExist;
import com.contact.model.Users;
import com.contact.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService
{
	@Autowired
	UserRepo userRepo;
	
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	public Users register(Users user) 
	{
		Users u1=null;
		Users u2=null;
		Users u3=null;
		
		u1=userRepo.findByemail(user.getEmail());
		if(u1!=null)
		{
			throw new EmailAlreadyExist("Email Already Exist");
		}
		
		u2=userRepo.findBymobileNo(user.getMobileNo());
		if(u2!=null)
		{
			throw new MobileNumberAlreadyExist("Mobile Number Already Exist");
		}
		
		u3=userRepo.findByuserName(user.getUserName());
		if(u3!=null)
		{
			throw new UserNameAlreadyExist("User Name Already Exist");
		}
		
		String newPass=encoder.encode(user.getPassword());
		user.setPassword(newPass);
		return  userRepo.save(user);
	}
	public Users getUserName(Users user) 
	{
		
		return userRepo.findByemail(user.getEmail());
	}

	
	
}
