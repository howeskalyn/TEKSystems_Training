package com.teksystems.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;

@Controller
public class IndexController {

	@Autowired
	private CourseDAO courseDAO;

	/*
	 * Add an additional search field to the jsp page to search by instructor name.
	 * Put it in the same form that already exists but give the input box a
	 * different name. Create a DAO method to search by instructor name (use like or
	 * contains). Add another param to the controller that will take in instructor
	 * name Add instructor name to the model so you can display again on the page
	 * after submit Query your list of courses and display them below BONUS: make a
	 * single query that can search by course name OR instructor name
	 */

	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash(@RequestParam(required = false) String search,
			@RequestParam(required = false) String instructor) {

		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp
		response.addObject("name", "Kalyn"); // 'name' is the variable name in the jsp

		// ----- Search for Course by Name -----
		System.out.println("Input search: " + search);
		List<Course> courses = courseDAO.findByNameContainingIgnoreCaseOrderByNameDesc(search); // returns courses based on search input
		response.addObject("courses", courses); // variable "courses" is available to jsp page now

		// adds typed value back in the input box
		response.addObject("search", search);

		// ----- Search for Course by Instructor -----
		System.out.println("Input instructor: " + instructor);
		List<Course> icourses = courseDAO.findByInstructorContainingIgnoreCase(instructor);
		response.addObject("icourses", icourses);
		response.addObject("instructor", instructor);
		
		
// 		attempt to use same search bar to find courses
//		System.out.println("Input search: " + search);
//		List<Course> courses = courseDAO.findByNameContainingIgnoreCaseOrderByNameDesc(search); -- this just overwrites it everytime
//		courses = courseDAO.findByInstructorContainingIgnoreCase(search);
//		response.addObject("courses", courses);
//		response.addObject("search", search);

		return response;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView search() {
		System.out.println("Index controller search request");

		return null;
	}

}
