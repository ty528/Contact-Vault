package com.contact.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.contact.model.UserPrincipal;
import com.contact.model.Users;
import com.contact.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService
{

	@Autowired
	UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Users user = userRepo.findByuserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException(username);
		}
		//System.out.println(user.getPassword()+"\n"+user.getPassword());
		//System.out.println( "hello "+ new JWTService().generateToken(username));
		return new UserPrincipal(user);
	}
}
