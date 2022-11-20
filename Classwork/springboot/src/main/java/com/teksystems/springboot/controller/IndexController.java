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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@Autowired
	private CourseDAO courseDAO;

	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash(@RequestParam(required = false) String courseName,
			@RequestParam(required = false) String instructorName) {

		// Eric's Code
		ModelAndView response = new ModelAndView();
		response.setViewName("index"); // file name: index.jsp
		response.addObject("name", "Kalyn"); // 'name' is the variable name in the jsp

		System.out.println("Course Search Param: " + courseName);
		System.out.println("Instructor Search Param: " + instructorName);
		response.addObject("courseNameKey", courseName);
		response.addObject("instructorNameKey", instructorName);

		// if (courseName != null && !courseName.equals("")) {
		// List<Course> courses =
		// courseDAO.findByNameContainingIgnoreCaseOrderByNameDesc(courseName);
		List<Course> courses = courseDAO.findByNameOrInstructor(courseName, instructorName);

		for (Course c : courses) {
			System.out.println(c.getName());
		}

		response.addObject("courses", courses);
		// }

		// ----- Search for Course by Name -----
//		List<Course> courses = courseDAO.findByNameContainingIgnoreCaseOrderByNameDesc(search); // returns courses based on search input
//		response.addObject("courses", courses); // variable "courses" is available to jsp page now
//
//		// adds typed value back in the input box
//		response.addObject("search", search);
//
//		// ----- Search for Course by Instructor -----
//		List<Course> icourses = courseDAO.findByInstructorContainingIgnoreCase(instructor);
//		response.addObject("icourses", icourses);
//		response.addObject("instructor", instructor);

		return response;
	}

	
	@RequestMapping(value = {"/course"}, method = RequestMethod.GET)
	public ModelAndView course() {
		// this method is called when /course is in the URL
		log.info("Index controller course request method");
		
		ModelAndView response = new ModelAndView();
		response.setViewName("course");
		
		return response;
	}
	
	@RequestMapping(value = { "/courseSubmit" }, method = RequestMethod.GET)
	public ModelAndView courseSubmit(@RequestParam(required = false) String courseName,
			@RequestParam(required = false) String instructorName) {

		ModelAndView response = new ModelAndView();
		response.setViewName("course");

		log.info("Index controller course submit method");
		log.info("Course Submit : courseName     : " + courseName);
		log.info("Course Submit : instructorName : " + instructorName);

		String errormessage = "";
		boolean error = false;
		if (courseName == null || courseName.equals("")) {
			errormessage = errormessage + "The course name can not be empty";
			error = true;
		}

		if (instructorName == null || instructorName.equals("")) {
			errormessage = errormessage + "The instructor name can not be empty";
			error = true;
		}

		if (error) {
			// there is an error
			log.info(errormessage);
			response.addObject("error", errormessage);
		} else {
			Course course = new Course();
			course.setName(courseName);
			course.setInstructor(instructorName);

			courseDAO.save(course);
		}
		
		return response;
	}
	
}
