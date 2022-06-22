package com.blog.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.my.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// 아이디와 비밀번호가 있는지 확인하기 위한 자동으로 쿼리를 만들어주는 작업
	User findByUsernameAndPassword(String username, String password);
}
