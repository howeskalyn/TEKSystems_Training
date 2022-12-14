/*
 * ShowSeek - Controller
 * For events, ordered 4 different ways.
 */

package com.capstone.ShowSeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EventsController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EventDAO eventDAO;

	public User getLoggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName(); // get logged in username -> which is the email in my case
		User user = userDAO.findByEmail(email); // pull from db
		return user;
	}

	// Events Page Display (ordered by Date default)
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ModelAndView eventsPage() {
		log.info("/events page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("events_page");

		User user = getLoggedInUser();
		response.addObject("user", user);

		List<Event> events = eventDAO.findEventsOrderByDate();
		response.addObject("events", events);

		return response;
	}

	// Events Page Display (ordered by Price)
	@RequestMapping(value = "/eventsprice", method = RequestMethod.GET)
	public ModelAndView eventsPricePage() {
		log.info("/eventsprice page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("events_page");

		User user = getLoggedInUser();
		response.addObject("user", user);

		List<Event> events = eventDAO.findEventsOrderByPrice();
		response.addObject("events", events);

		return response;
	}

	// Events Page Display (ordered by Artist)
	@RequestMapping(value = "/eventsartist", method = RequestMethod.GET)
	public ModelAndView eventsArtistPage() {
		log.info("/eventsartist page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("events_page");

		User user = getLoggedInUser();
		response.addObject("user", user);

		List<Event> events = eventDAO.findEventsOrderByArtist();
		response.addObject("events", events);

		return response;
	}

	// Events Page Display (ordered by Venue)
	@RequestMapping(value = "/eventsvenue", method = RequestMethod.GET)
	public ModelAndView eventsVenuePage() {
		log.info("/eventsvenue page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("events_page");

		User user = getLoggedInUser();
		response.addObject("user", user);

		List<Event> events = eventDAO.findEventsOrderByVenue();
		response.addObject("events", events);

		return response;
	}

}
