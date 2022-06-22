package com.blog.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.my.model.User;
import com.blog.my.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int saveUser(User user) {
		try {
			userRepository.save(user);			
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	@Transactional
	public User login(User user) {
		User principal = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		// null 처리 
		
		return principal;
	}
}
