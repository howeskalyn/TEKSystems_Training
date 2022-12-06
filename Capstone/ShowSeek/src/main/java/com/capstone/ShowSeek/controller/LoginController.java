package com.capstone.ShowSeek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.User;
import com.capstone.ShowSeek.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	// this method is request mapping to show the actual login JSP page.
	// the URL here in the mapping is the same URL configured in spring security .loginPage
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/login_example");
		return response;
	}

	// just displays the form
	@RequestMapping(value = "/user/createuser", method = RequestMethod.GET)
	public ModelAndView createUser() {
		ModelAndView response = new ModelAndView();
//		response.setViewName("login_pages/create_user");
		response.setViewName("createUser_page");

		log.info("This is in the GET method for create user");
		return response;
	}

	// same URL but this has a post RequestMethod
	// actually takes in data from the form
	@RequestMapping(value = "/user/createuser", method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
//		response.setViewName("login_pages/create_user");
		response.setViewName("createUser_page");
		log.info("This is in the POST method for create user");

		log.info(form.toString());

		// logging validation errors on create user page (based on annotations in CreateUserForm)
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.info(e.getObjectName() + " : " + e.getDefaultMessage());
		}
		
		// testing certain bindingResult errors
//		for (ObjectError e : bindingResult.getFieldErrors("firstName")) {
//			log.info(e.getObjectName() + " : " + e.getDefaultMessage());
//		}

		if (!bindingResult.hasErrors()) {
			User user = new User();

			user.setFirst_name(form.getFirstName());
			user.setLast_name(form.getLastName());
			user.setEmail(form.getEmail());
			user.setPassword(form.getPassword());
			user.setZip(form.getZip());
			user.setPhone(form.getPhone());

			userDAO.save(user); // sends to the db
			
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		return response;
	}

}
