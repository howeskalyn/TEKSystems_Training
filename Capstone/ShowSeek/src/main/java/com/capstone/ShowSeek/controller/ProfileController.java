/*
 * ShowSeek - Controller
 * For profile, adding friends, and user settings pages.
 */

package com.capstone.ShowSeek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.FriendDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Friend;
import com.capstone.ShowSeek.db.entity.User;
import com.capstone.ShowSeek.form.UpdatePasswordForm;

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
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	// ---- HELPER FUNCTIONS ----
	// finding a users friends manually
	public List<User> findUsersFriends() {
		User user = getLoggedInUser();

		List<Friend> allFriends = friendDAO.findAllFriends();
		List<Integer> userFriendIDs = new ArrayList<>();

		for (Friend currentFriend : allFriends) {
			if (currentFriend.getId().equals(user.getId())) {
				userFriendIDs.add(currentFriend.getFriend_id()); // add the friend_id
			}
		}

		List<User> userFriends = new ArrayList<>();
		for (Integer currentID : userFriendIDs) {
			User u = userDAO.findUserById(currentID);
			userFriends.add(u);
		}
		// log.info("USERS FRIENDS " + userFriends.toString());

		return userFriends;
	}

	public User getLoggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName(); // get logged in username -> which is the email in my case
		User user = userDAO.findByEmail(email); // pull from db
		return user;
	}

	// ---- REQUEST MAPPINGS ----

	// User Profile Home Page Display
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profilePage() {
		log.info("/profile page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("profile_home");

		User user = getLoggedInUser();
		response.addObject("user", user);

		List<Event> userEvents = eventDAO.findEventByUserEmail(user.getEmail());
		response.addObject("userEvents", userEvents);

		List<User> userFriends = findUsersFriends();

		response.addObject("userFriends", userFriends);

		return response;
	}

	// just displays the form
	@RequestMapping(value = "/usersearch", method = RequestMethod.GET)
	public ModelAndView allUsers(@RequestParam(required = false) String inputName) {
		log.info("/usersearch page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("user_search");

		// log.info("Input Name: " + inputName);
		response.addObject("inputName", inputName);

		List<User> users = userDAO.findByFirstOrLastName(inputName); // all users

		List<User> userFriends = findUsersFriends();
		userFriends.add(getLoggedInUser()); // add current user to userFriends so it will be excluded on the next line

		users.removeAll(userFriends); // only display users who are not friends with (or ARE) the current user already

		response.addObject("users", users);

		return response;

	}

	@ResponseBody
	@RequestMapping(value = { "/addfriendCall" }, method = RequestMethod.GET)
	public String addfriendCall(@RequestParam String clickedValue) {
		log.info("/addfriendCall page accessed: " + clickedValue);

		Friend newFriend = new Friend();
		User user = getLoggedInUser();

		newFriend.setId(user.getId());
		Integer friendID = Integer.parseInt(clickedValue);
		newFriend.setFriend_id(friendID);
		// log.info("New Friend: " + newFriend.toString());

		friendDAO.save(newFriend);

		return "success from server";
	}

	// User Profile Settings Display
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settings() {
		log.info("/settings GET page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("settings");

		User user = getLoggedInUser();
		response.addObject("user", user);

		return response;
	}

	// actually takes in data from the form
	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public ModelAndView settings(@Valid UpdatePasswordForm form, BindingResult bindingResult) {
		log.info("/settings POST page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("settings");

		User user = getLoggedInUser();
		response.addObject("user", user);

		// data remaining the same
		user.setFirst_name(user.getFirst_name());
		user.setLast_name(user.getLast_name());
		user.setEmail(user.getEmail());
		user.setZip(user.getZip());
		user.setPhone(user.getPhone());

		if (!bindingResult.hasErrors()) {
			String encodedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(encodedPassword);

			response.setViewName("login");

		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		userDAO.save(user); // sends to the db

		return response;
	}

}
