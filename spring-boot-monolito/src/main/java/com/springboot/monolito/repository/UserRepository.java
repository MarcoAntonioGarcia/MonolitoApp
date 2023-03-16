package com.springboot.monolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.monolito.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	

}
