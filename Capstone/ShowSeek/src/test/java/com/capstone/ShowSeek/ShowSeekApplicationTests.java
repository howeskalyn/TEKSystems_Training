package com.capstone.ShowSeek;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.FriendDAO;
import com.capstone.ShowSeek.db.dao.Ticket_PurchaseDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Friend;
import com.capstone.ShowSeek.db.entity.User;

@SpringBootTest
class ShowSeekApplicationTests {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	Ticket_PurchaseDAO tpDAO;
	@Autowired
	EventDAO eventDAO;
	@Autowired
	FriendDAO friendDAO;

	@Test
	void findUserByIdTest() {
		User u = userDAO.findUserById(1);
		Assertions.assertTrue(u.getId().equals(1));
		Assertions.assertFalse(u.getId().equals(2));
	}
	
	@Test
	void findEventByEventIdTest() {
		Event e = tpDAO.findEventByEventId(2);
		Assertions.assertTrue(e.getId().equals(2));
		Assertions.assertFalse(e.getId().equals(3));
	}
	
	@Test
	void findByVenueTest () {
		List<Event> es = eventDAO.findByVenue("Capital One Arena");
		Assertions.assertTrue(es.size() > 0);
		Assertions.assertFalse(es.size() > 3);
	}
	
	@Test
	void findAllFriendsTest() {
		List<Friend> friends = friendDAO.findAllFriends();
		Assertions.assertTrue(friends.size() > 0);
		Assertions.assertFalse(friends.size() == 0);
	}
	
}
