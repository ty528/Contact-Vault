package com.contact.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>
{
	Users findByemail(String email);
	
	Users findBymobileNo(String mobile);
	
	Users findByuserName(String userName);

	//Users findByuserName(String username);
}
