package com.capstone.ShowSeek.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Friend;

@Repository
public interface FriendDAO extends JpaRepository<Friend, Long> {

	public Friend findById(Integer id);
	
	//public List<Friend> findByUserId(Integer id);

	// return friends from user id
	@Query(value = "select u.first_name, u.last_name from user u\n"
			+ "join friend f on f.friend_id = u.id\n"
			+ "where f.user_id = :id", nativeQuery = true)
	public List<Friend> findFriendsByUserId(@Param("id")Integer id);

}
