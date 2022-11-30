package com.teksystems.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.dao.StudentDAO;
import com.teksystems.springboot.database.entity.Course;
import com.teksystems.springboot.database.entity.Student;

import lombok.extern.slf4j.Slf4j;
//import org.sl4fj.Logger;
//import org.slf4j.LoggerFactory;

@Slf4j
@Controller
public class IndexController {
	
	//private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

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

	@RequestMapping(value = { "/course" }, method = RequestMethod.GET)
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
	
	// this is wrong:
	private String value = "X";
	
	@ResponseBody
	@RequestMapping(value = { "/course/path/{id}" }, method = RequestMethod.GET)
	public Course pathVar(@PathVariable Integer id, HttpSession session) {
		log.info("Incoming path variable = " + id);
		
		Course c = courseDAO.findById(id);
		log.info("this is my course name: " + c.getName());
		
		if (session.getAttribute("key") == null) {
			log.info("key not found in session");
			session.setAttribute("key", "value");
		} else {
			log.info("key is in the session");
		}
		
		return c;
		
	}

	// --------------------------------------
	// ----- Working with Student Table -----
	// --------------------------------------
	@Autowired
	private StudentDAO studentDAO;

	// this method is called when /student is in the URL
	@RequestMapping(value = { "/student" }, method = RequestMethod.GET)
	public ModelAndView student(String first_name) {

		ModelAndView response = new ModelAndView();
		response.setViewName("student"); // file name: student.jsp

		System.out.println("Student Search Param: " + first_name);
		response.addObject("first_name_key", first_name);

		List<Student> students = studentDAO.findByFirst_name(first_name);
		response.addObject("students", students); // variable "courses" is available to jsp page now

		// adds typed value back in the input box
		response.addObject("first_name", first_name);

		return response;
	}

	@RequestMapping(value = { "/studentSubmit" }, method = RequestMethod.GET)
	public ModelAndView studentSubmit(@RequestParam(required = false) String first_name,
			@RequestParam(required = false) String last_name, @RequestParam(required = false) String city,
			@RequestParam(required = false) String state, @RequestParam(required = false) Integer zip) {

		ModelAndView response = new ModelAndView();
		response.setViewName("student");

		log.info("Student Submit - first_name: " + first_name);
		log.info("Student Submit - last_name: " + last_name);
		log.info("Student Submit - city: " + city);
		log.info("Student Submit - state: " + state);
		log.info("Student Submit - zip: " + zip);

		String errormessage = "";
		boolean error = false;
		
		// check all input for null
		if (first_name == null || first_name.equals("")) {
			errormessage = errormessage + "The student first name can not be empty\n";
			error = true;
		}
		if (last_name == null || last_name.equals("")) {
			errormessage = errormessage + "The student last name can not be empty\n";
			error = true;
		}
		if (city == null || city.equals("")) {
			errormessage = errormessage + "The student city can not be empty\n";
			error = true;
		}
		if (state == null || state.equals("")) {
			errormessage = errormessage + "The student state can not be empty\n";
			error = true;
		}
		if (zip == null || zip < 0 ) {
			errormessage = errormessage + "The student zip code is in an incorrect format\n";
			error = true;
		}

		if (error) {
			log.info(errormessage);
			response.addObject("error", errormessage);
		} else {
			Student student = new Student();
			student.setFirst_name(first_name);
			student.setLast_name(last_name);
			student.setCity(city);
			student.setState(state);
			student.setZip(zip);

			studentDAO.save(student);
		}

		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/course/all" }, method = RequestMethod.GET)
	public List<Course> allCourses() {
		log.error("This is an error");
		log.warn("This is a warning");
		log.info("This is info");
		log.debug("This is debug");
		
		List<Course> courses = courseDAO.findAll();
		return courses;
	}
	
}
