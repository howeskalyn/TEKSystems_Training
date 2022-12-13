package com.capstone.ShowSeek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.FriendDAO;
import com.capstone.ShowSeek.db.dao.Ticket_PurchaseDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Friend;
import com.capstone.ShowSeek.db.entity.Ticket_Purchase;
import com.capstone.ShowSeek.db.entity.User;
import com.capstone.ShowSeek.form.CreateTicketPurchaseForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProfileController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private Ticket_PurchaseDAO ticket_purchaseDAO;
	@Autowired
	private FriendDAO friendDAO;

	// User Profile Home Page Display
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profilePage() {

		ModelAndView response = new ModelAndView();
		response.setViewName("profile_home"); // jsp file name

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName(); // get logged in username -> which is the email in my case
		User user = userDAO.findByEmail(email); // pull from db
		response.addObject("user", user); // send to jsp

		List<Event> userEvents = eventDAO.findEventByUserEmail(email);
		response.addObject("userEvents", userEvents);

		List<User> userFriends = findUsersFriends();

		response.addObject("userFriends", userFriends);

		return response;
	}

	// just displays the form
	@RequestMapping(value = "/ticketpurchase", method = RequestMethod.GET)
	public ModelAndView ticketPurchasePage() {
		log.info("in GET for ticket purchase");

		ModelAndView response = new ModelAndView();
		response.setViewName("ticket_purchase_page");

		// send all events into jsp
		List<Event> events = eventDAO.findEventsOrderByArtist();
		response.addObject("events", events);

		return response;
	}

	// Ticket Purchase Page
	@RequestMapping(value = "/ticketpurchase", method = RequestMethod.POST)
	public ModelAndView ticketPurchasePage(@Valid CreateTicketPurchaseForm form, BindingResult bindingResult,
			HttpServletRequest request) {
		log.info("in POST for ticket purchase");

		ModelAndView response = new ModelAndView();
		response.setViewName("ticket_purchase_page");

		// send all events into jsp
		List<Event> events = eventDAO.findEventsOrderByArtist();
		response.addObject("events", events);

		for (ObjectError e : bindingResult.getAllErrors()) {
			log.info(e.getObjectName() + " : " + e.getDefaultMessage());
		}

		if (!bindingResult.hasErrors()) {
			Ticket_Purchase purchase = new Ticket_Purchase();

			// find current user
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String email = auth.getName();
			User user = userDAO.findByEmail(email);
			Integer eventID = Integer.parseInt(request.getParameter("eventID")); // parse String parameter as int to add

			log.info("User ID:" + user.getId().toString() + " Quantity:" + form.getQuantity().toString() + " Event ID:"
					+ eventID);

			purchase.setUser_id(user.getId());
			purchase.setQuantity(form.getQuantity()); // take in quantity from form
			purchase.setEvent_id(eventID); // take in event from form

			ticket_purchaseDAO.save(purchase);

			response.setViewName("complete_purchase_page"); // redirect to profile page after purchase

		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		return response;
	}

	// Complete Purchase Page
	@RequestMapping(value = "/completepurchase", method = RequestMethod.GET)
	public ModelAndView completePurchase() {

		ModelAndView response = new ModelAndView();
		response.setViewName("complete_purchase_page");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userDAO.findByEmail(email);
		response.addObject("user", user);

		List<Event> userEvents = eventDAO.findEventByUserEmail(email);
		response.addObject("userEvents", userEvents);

		return response;
	}

	// just displays the form
	@RequestMapping(value = "/usersearch", method = RequestMethod.GET)
	public ModelAndView allUsers(@RequestParam(required = false) String inputName) {

		ModelAndView response = new ModelAndView();
		response.setViewName("user_search");

//		log.info("Input Name: " + inputName);
		response.addObject("inputName", inputName);

		// all users
		List<User> users = userDAO.findByFirstOrLastName(inputName);
		
		List<User> userFriends = findUsersFriends();
		users.removeAll(userFriends); // only display users who are not friends with the current user already
		
		response.addObject("users", users);

		return response;

	}

	@ResponseBody
	@RequestMapping(value = { "/addfriendCall" }, method = RequestMethod.GET)
	public String addfriendCall(@RequestParam String clickedValue) {
		log.info("in ajax call method: " + clickedValue);

		Friend newFriend = new Friend();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userDAO.findByEmail(email);

		newFriend.setId(user.getId());
		Integer friendID = Integer.parseInt(clickedValue);
		newFriend.setFriend_id(friendID);
//		log.info("New Friend: " + newFriend.toString());

		friendDAO.save(newFriend);

		return "success from server";
	}

	// finding a users friends
	public List<User> findUsersFriends() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName(); // get logged in username -> which is the email in my case

		User user = userDAO.findByEmail(email); // pull from db

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

}
