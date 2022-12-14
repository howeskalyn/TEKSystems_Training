/*
 * ShowSeek - Controller
 * For home page.
 */

package com.capstone.ShowSeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	// Home Page Display
	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		log.info("/index page accessed.");

		ModelAndView response = new ModelAndView();
		response.setViewName("home_page"); // jsp file name

		return response;
	}
}
