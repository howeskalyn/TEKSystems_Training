package com.capstone.ShowSeek.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.Friend;

@Repository
public interface FriendDAO extends JpaRepository<Friend, Long> {

	@Query(value = "select * from friend", nativeQuery = true)
	public List<Friend> findAllFriends();

}
