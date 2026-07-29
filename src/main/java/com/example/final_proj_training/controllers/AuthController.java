package com.example.final_proj_training.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_proj_training.dtos.LoginCredentials;
import com.example.final_proj_training.dtos.TokenResponse;
import com.example.final_proj_training.jwt.JwtUtils;
import com.example.final_proj_training.models.User;
import com.example.final_proj_training.repositories.UserRepository;
import com.example.final_proj_training.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService us;
	
	@Autowired
	private UserRepository ur;
	
	@PostMapping("/signup")
	public User signup(@ModelAttribute User newUser) {
		//User user= this.ur.save(newUser);
		return this.us.insertUser(newUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> login(@ModelAttribute LoginCredentials credentials){
		//validate if user with creds exists
		User foundUser= this.ur.findByEmail(credentials.getEmail());
		if(foundUser!=null && foundUser.getPassword().equals(credentials.getPassword())) {
			//generate token
			String token= JwtUtils.generateToken(foundUser.getId(), foundUser.getName());
			TokenResponse response=new TokenResponse(token);
			return ResponseEntity.ok(response);
		}
		// if user is valid ->generate token else ->401
		
		
		//throw new RuntimeException("user not found");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
