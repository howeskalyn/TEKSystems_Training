package com.capstone.ShowSeek.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {


	public List<UserRole> findByUserId(Integer userId);
	
}

