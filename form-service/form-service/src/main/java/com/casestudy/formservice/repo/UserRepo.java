package com.casestudy.formservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.formservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
