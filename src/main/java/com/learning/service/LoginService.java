package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.dto.LoginDto;
import com.learning.entities.User;


@Service
public class LoginService {
	
	@Autowired
	UserService userService;
	
    @Autowired
    BCryptPasswordEncoder encoder;
	
	
	public boolean login(LoginDto loginDto) {
		
		User userToBeLoggeddIn = userService.findByMail(loginDto.getMail());
		
		return checkPassword(loginDto.getPassword(), userToBeLoggeddIn.getPassword());
	}

	
	public boolean checkPassword(String plainPassword, String encodedPassword) {
	    return encoder.matches(plainPassword, encodedPassword);
	}

}
