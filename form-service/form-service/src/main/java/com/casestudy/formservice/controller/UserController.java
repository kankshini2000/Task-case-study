package com.casestudy.formservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.formservice.entity.User;
import com.casestudy.formservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	private UserService userService;
	
	@PostMapping("/signup")
    public String signup(@RequestBody User loginUser) {
        User user = userService.addUser(loginUser);
        return "User posted with role : " + user.getRole();
    }
	
	@PostMapping("/login")
	public String login(@RequestBody User loginUser ){
		User user = getUserByUsername(loginUser.getUsername());
		if(user.getUsername().equals(loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())) {
			return user.getRole();
		}else {
			return "Invalid";
		}
		
	}
	
	@GetMapping("/getuser/{userName}")
	public User getUserByUsername(@PathVariable String userName) {
		
		return userService.getUser(userName);
		
	}
}
