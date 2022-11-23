package com.capstone.ShowSeek.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	
	//@Query("select u from User u where u.id = :id")
	public User findUserById(Integer id);
	
	public List<User> findByEmail(String email);
	
}
