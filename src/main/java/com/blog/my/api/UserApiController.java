package com.blog.my.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.my.dto.ResponseDto;
import com.blog.my.model.Board;
import com.blog.my.model.RollType;
import com.blog.my.model.User;
import com.blog.my.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession httpSession;

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		user.setRole(RollType.USER);
		int status = userService.saveUser(user);
		return new ResponseDto<>(HttpStatus.OK.value(), status);
	}
	
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user){
		User principal = userService.login(user);
		httpSession.setAttribute("principal", principal);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
