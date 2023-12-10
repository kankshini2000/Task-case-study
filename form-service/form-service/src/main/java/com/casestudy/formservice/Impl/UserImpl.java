package com.casestudy.formservice.Impl;

import org.springframework.stereotype.Service;

import com.casestudy.formservice.entity.User;
import com.casestudy.formservice.repo.UserRepo;
import com.casestudy.formservice.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserImpl  implements UserService{

	private UserRepo userRepo;
	
	@Override
	public User addUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public User getUser(String userName) {
		User savedUser = userRepo.findByUsername(userName);
		
		return savedUser;
	}

}
