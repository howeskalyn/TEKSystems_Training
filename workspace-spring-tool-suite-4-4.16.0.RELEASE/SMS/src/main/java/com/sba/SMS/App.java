package com.sba.SMS;

import java.util.List;

import jpa.dao.CourseService;
import jpa.dao.StudentService;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;


// temporary main used for original method testing

public class App {
//	public static void main(String[] args) {
		
		// ---- Testing StudentService Method ----
		StudentService ss = new StudentService();
		
		// 1
//		List<Student> allStudents = ss.getAllStudents();
//		for (Student s : allStudents) {
//			System.out.println(s.toString());
//		}
		
		// 2
//		Student stud = ss.getStudentByEmail("htaffley6@columbia.edu");
//		System.out.println(stud.toString());
		
		// 3
//		System.out.println(ss.validateStudent("htaffley6@columbia.edu", "xowtOQ")); // TRUE
//		System.out.println(ss.validateStudent("htaffley6@columbia.edu", "hi")); // FALSE
		
		// 4
//		ss.registerStudentToCourse("aiannitti7@is.gd", 10); // student already enrolled
//		ss.registerStudentToCourse("aiannitti7@is.gd", 5); // should enroll the student
		
		// 5
//		
		
		// 1
//		CourseService cs = new CourseService();
//		List<Course> allCourses = cs.getAllCourses();
//		for (Course c : allCourses) {
//			System.out.println(c.toString());
//		}
	
//	}
}