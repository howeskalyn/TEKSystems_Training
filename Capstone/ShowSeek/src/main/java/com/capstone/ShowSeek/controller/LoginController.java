/*
 * ShowSeek - Controller
 * For login and user creation pages.
 */

package com.capstone.ShowSeek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.dao.UserRoleDAO;
import com.capstone.ShowSeek.db.entity.User;
import com.capstone.ShowSeek.db.entity.UserRole;
import com.capstone.ShowSeek.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	// this method is request mapping to show the actual login JSP page.
	// the URL here in the mapping is the same URL configured in spring security
	// .loginPage
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView login() {
		log.info("/user/login page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("login");

		return response;
	}

	// just displays the form
	@RequestMapping(value = "/user/createuser", method = RequestMethod.GET)
	public ModelAndView createUser() {
		log.info("/user/usercreate GET page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("createUser_page");

		return response;
	}

	// same URL but this has a post RequestMethod
	// actually takes in data from the form
	@RequestMapping(value = "/user/createuser", method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
		log.info("/user/createuser POST page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("createUser_page");

		// log.info(form.toString());

		// logging validation errors
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.info(e.getObjectName() + " : " + e.getDefaultMessage());
		}

		// validate password and confirm password
		if (!form.getPassword().equals(form.getConfirmPassword())) {
			bindingResult.rejectValue("password", "error.user", "Passwords do NOT match");
		}

		if (!bindingResult.hasErrors()) {
			User user = new User();

			user.setFirst_name(form.getFirstName());
			user.setLast_name(form.getLastName());
			user.setEmail(form.getEmail());
			user.setPassword(form.getPassword());
			user.setZip(form.getZip());
			user.setPhone(form.getPhone());

			String encodedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(encodedPassword);

			userDAO.save(user); // sends to the db

			UserRole ur = new UserRole();
			ur.setRoleName("USER");
			ur.setUserId(user.getId());

			userRoleDAO.save(ur);
			response.setViewName("login");

		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);

		}

		return response;
	}

}
