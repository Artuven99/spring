package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.LoginDto;
import com.learning.service.LoginService;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping
	public ResponseEntity<Boolean> login(@RequestBody LoginDto loginDto){
		return ResponseEntity.ok(loginService.login(loginDto));
	}
}
