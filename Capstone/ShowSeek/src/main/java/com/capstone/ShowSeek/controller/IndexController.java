package com.capstone.ShowSeek.controller;

import java.util.List;

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
	private Ticket_PurchaseDAO ticket_purhaseDAO;

	// Testing connection to User Table
	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash(@RequestParam(required = false) String email) {

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		// System.out.println("User Search Email: " + email);
		response.addObject("email", email);

		// pull from the db based on input
		List<User> users = userDAO.findByEmail(email);

		// print to console for checking purposes
		// for (User u : users) {
		// System.out.println(u.getFirst_name() + " " + u.getLast_name());
		// }

		// send found users back to web page
		response.addObject("users", users);
		return response;
	}

//	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
//	public ModelAndView search() {
//		System.out.println("Index Controller SEARCH");
//
//		return null;
//	}

	// Testing connection to Friend Table
	@RequestMapping(value = { "/friend" }, method = RequestMethod.GET)
	public ModelAndView slashFriend(@RequestParam(required = false) Integer id) {
		// System.out.println("Index Controller /FRIEND");

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		System.out.println("Friend Search ID: " + id);
		response.addObject("id", id);

		// pull from the db based on input
		Friend friend = friendDAO.findById(id);

		// print to console for checking purposes
		// System.out.println("User id: " + friend.getUser_id() + " & Friend id: " +
		// friend.getFriend_id());

		// send found users back to web page
		response.addObject("friend", friend);
		return response;
	}

	// Testing connection to Events Table
	@RequestMapping(value = { "/event" }, method = RequestMethod.GET)
	public ModelAndView slashEvent(@RequestParam(required = false) String venue) {
		// System.out.println("Index Controller /EVENT");

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		// System.out.println("Event Search Venue: " + venue);
		response.addObject("venue", venue);

		// pull from the db based on input
		List<Event> events = eventDAO.findByVenue(venue);

		// print to console for checking purposes
		// for (Event e : events) {
		// System.out.println(e.getId() + ": " + e.getArtist() + " " + e.getDate());
		// }

		// send found users back to web page
		response.addObject("events", events);
		return response;
	}

	// Testing connection to Ticket_Purchase Table
	@RequestMapping(value = { "/ticket" }, method = RequestMethod.GET)
	public ModelAndView slashTicket(@RequestParam(required = false) Integer eventID) {
		// System.out.println("Index Controller /TICKET");

		// set up
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp

		// show input from web page
		// System.out.println("Ticket Search eventID: " + eventID);
		response.addObject("eventID", eventID);

		// pull from the db based on input
//		List<Ticket_Purchase> tickets = ticket_purhaseDAO.findByEventId(eventID);

		// print to console for checking purposes
		// for (Ticket_Purchase t : tickets) {
		// System.out.println(t.getId());
		// }

		// send found users back to web page
//		response.addObject("tickets", tickets);
		
		// TEST MAPPING: Return an event through a ticket_purchase
		List<Event> events = ticket_purhaseDAO.findEventByEventId(eventID);
		response.addObject("events", events);
		
		
		
		return response;
	}

}
