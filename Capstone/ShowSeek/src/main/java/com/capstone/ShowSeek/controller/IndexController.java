package com.capstone.ShowSeek.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.FriendDAO;
import com.capstone.ShowSeek.db.dao.Ticket_PurchaseDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Friend;
import com.capstone.ShowSeek.db.entity.Ticket_Purchase;
import com.capstone.ShowSeek.db.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	// Import DAOs for each table
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FriendDAO friendDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private Ticket_PurchaseDAO ticket_purchaseDAO;

	// Home Page Display
	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("home_page"); // jsp file name

		return response;
	}

	// Events Page Display
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ModelAndView eventsPage() {

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("events_page"); // jsp file name

		return response;
	}

	// User Login Page Display
//	@RequestMapping(value = "/profile", method = RequestMethod.GET)
//	public ModelAndView profilePage() {
//
//		// set up
//		ModelAndView response = new ModelAndView();
//		response.setViewName("profile_page"); // jsp file name
//
//		return response;
//	}

	// Testing connection to User Table
	@RequestMapping(value = "/table/test", method = RequestMethod.GET)
	public ModelAndView test(@RequestParam(required = false) String email) {

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		log.info("User Search Email: " + email);
		response.addObject("email", email);

		// pull from the db based on input
		// User user = userDAO.findByEmail(email);

		// send found users back to web page
		// response.addObject("user", user);

		List<Event> userEvents = eventDAO.findEventByUserEmail(email);
		response.addObject("userEvents", userEvents);

		return response;
	}

//	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
//	public ModelAndView search() {
//		log.info("Index Controller SEARCH");
//
//		return null;
//	}

	// Testing connection to Friend Table
	@RequestMapping(value = { "/friend" }, method = RequestMethod.GET)
	public ModelAndView slashFriend(@RequestParam(required = false) Integer id) {
		// log.info("Index Controller /FRIEND");

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		log.info("Friend Search ID: " + id);
		response.addObject("id", id);

		// pull from the db based on input
		Friend friend = friendDAO.findById(id);

		// print to console for checking purposes
		// log.info("User id: " + friend.getUser_id() + " & Friend id: " +
		// friend.getFriend_id());

		// send found users back to web page
		response.addObject("friend", friend);
		return response;
	}

	// Testing connection to Events Table
	@RequestMapping(value = { "/event" }, method = RequestMethod.GET)
	public ModelAndView slashEvent(@RequestParam(required = false) String venue) {
		// log.info("Index Controller /EVENT");

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		// log.info("Event Search Venue: " + venue);
		response.addObject("venue", venue);

		// pull from the db based on input
		List<Event> events = eventDAO.findByVenue(venue);

		// print to console for checking purposes
		// for (Event e : events) {
		// log.info(e.getId() + ": " + e.getArtist() + " " + e.getDate());
		// }

		// send found users back to web page
		response.addObject("events", events);
		return response;
	}

	// Testing connection to Ticket_Purchase Table
	@RequestMapping(value = { "/ticket" }, method = RequestMethod.GET)
	public ModelAndView slashTicket(@RequestParam(required = false) Integer eventID) {
		// log.info("Index Controller /TICKET");

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		// log.info("Ticket Search eventID: " + eventID);
		response.addObject("eventID", eventID);

		// pull from the db based on input
//		List<Ticket_Purchase> tickets = ticket_purhaseDAO.findByEventId(eventID);

		// print to console for checking purposes
		// for (Ticket_Purchase t : tickets) {
		// log.info(t.getId());
		// }

		// send found users back to web page
//		response.addObject("tickets", tickets);

		// TEST MAPPING: Return an event through a ticket_purchase
		Event event2 = ticket_purchaseDAO.findEventByEventId(eventID);
		response.addObject("event2", event2);

		return response;
	}

	// example from class
//	@RequestMapping(value = { "/event/count" }, method = RequestMethod.GET)
//	public ModelAndView eventCount() {
//		ModelAndView response = new ModelAndView();
//		response.setViewName("count_example");
//		
//		List<Map<String, Object>> eventCounts = eventDAO.artistEventCount();
//		for (Map<String, Object> count : eventCounts) {
//			log.info(count.get("artist") + " is performing at " + count.get("cnt") + " event(s)");
//		}
//		
//		response.addObject("eventCounts", eventCounts);
//		return response;
//		
//	}

}
