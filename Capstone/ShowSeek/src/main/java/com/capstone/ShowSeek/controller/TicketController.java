package com.capstone.ShowSeek.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.EventDAO;
import com.capstone.ShowSeek.db.dao.Ticket_PurchaseDAO;
import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.Event;
import com.capstone.ShowSeek.db.entity.Ticket_Purchase;
import com.capstone.ShowSeek.db.entity.User;
import com.capstone.ShowSeek.form.CreateTicketPurchaseForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TicketController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private Ticket_PurchaseDAO ticket_purchaseDAO;

	// just displays the form
	@RequestMapping(value = "/ticketpurchase", method = RequestMethod.GET)
	public ModelAndView ticketPurchasePage() {
		log.info("/ticketpurchase GET page accessed.");

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
		log.info("/ticketpurchase POST page accessed.");

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
		log.info("/completepurchase page accessed.");

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

}
