package com.capstone.ShowSeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.ShowSeek.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@RequestMapping(value = { "/user/createuser" }, method = RequestMethod.GET)
	public ModelAndView createUser(CreateUserForm form) { // taking in POJO object instead of many RequestParams
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");
		
		log.debug(form.toString());

		return response;
	}

}
