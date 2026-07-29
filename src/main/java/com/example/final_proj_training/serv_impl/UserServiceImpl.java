package com.example.final_proj_training.serv_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_proj_training.models.User;
import com.example.final_proj_training.repositories.UserRepository;
import com.example.final_proj_training.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository ur;
	
	@Override
	public User insertUser(User us) {
		// TODO Auto-generated method stub
		User createdUser= this.ur.save(us);
		return createdUser;
	}

}
