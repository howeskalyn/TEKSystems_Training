package com.capstone.ShowSeek.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	// @Query("select u from User u where u.id = :id")
	public User findUserById(Integer id);

	public User findByEmail(String email);
	
	@Query("select u from User u where u.first_name like %:inputName% or u.last_name like %:inputName%")
	public List<User> findByFirstOrLastName(String inputName);
	
//	@Query(value = "update user u set u.password = :newPass where u.id = :userId", nativeQuery = true)
//	public void updatePassword(String newPass, Integer userId);
}
