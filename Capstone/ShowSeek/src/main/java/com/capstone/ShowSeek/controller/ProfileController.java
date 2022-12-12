package com.capstone.ShowSeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.FriendDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Friend;
import com.capstone.ShowSeek.db.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProfileController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private FriendDAO friendDAO;

	// User Profile Home Page Display
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profilePage() {

		ModelAndView response = new ModelAndView();
		response.setViewName("profile_pages/profile_home"); // jsp file name
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName(); // get logged in username -> which is the email in my case

		User user = userDAO.findByEmail(email); // pull from db
		response.addObject("user", user); // send to jsp
		
		List<Event> userEvents = eventDAO.findEventByUserEmail(email);
		response.addObject("userEvents", userEvents);
	    
		return response;
	}

	// User Profile Events Page Display
//	@RequestMapping(value = "/profileEvents", method = RequestMethod.GET)
//	public ModelAndView profileEvents(@RequestParam(required = false) String email) {
//
//		// set up
//		ModelAndView response = new ModelAndView();
//		response.setViewName("profile_pages/profile_events"); // jsp file name
//
//		// **** TEMPORARY ****
//		log.info("User Search Email: " + email);
//		response.addObject("email", email);
//
//		List<Event> userEvents = eventDAO.findEventByUserEmail(email);
//		response.addObject("userEvents", userEvents);
//		
//		return response;
//
//	}
//
//	// User Profile Friends Page Display
//	@RequestMapping(value = "/profileFriends", method = RequestMethod.GET)
//	public ModelAndView profileFriends(@RequestParam(required = false) Integer userID) {
//
//		// set up
//		ModelAndView response = new ModelAndView();
//		response.setViewName("profile_pages/profile_friends"); // jsp file name
//		
//		// **** TEMPORARY ****
//		log.info("User Search ID: " + userID);
//		response.addObject("userID", userID);
//		
//
//		List<Friend> userFriends = friendDAO.findFriendsByUserId(userID); // ERROR HERE
//		response.addObject("userFriends", userFriends);
//
//
//		return response;
//	}

}
