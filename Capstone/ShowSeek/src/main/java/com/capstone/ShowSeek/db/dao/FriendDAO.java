package com.capstone.ShowSeek.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.Friend;

@Repository
public interface FriendDAO extends JpaRepository<Friend, Long> {
	
	public Friend findById(Integer id);

}
