package jpa.dao;

import javax.persistence.TypedQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.Student_Course;

public class StudentService {

	// for colored output to console
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	// reads Student table and returns the data as a List<Student>
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Student s";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> result = query.getResultList();

		// close resources
		tx.commit();
		factory.close();
		session.close();

		return result;
	}

	// takes a Student’s email as a String, parses the student list for a Student
	// with that email, and returns a Student Object
	public Student getStudentByEmail(String sEmail) {

		Student result = new Student();
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Student s where s.sEmail =: studentEmail";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("studentEmail", sEmail);

		result = query.getSingleResult();

		tx.commit();
		factory.close();
		session.close();

		return result;

	}

	// takes two parameters: first is the user email & second is the password from the user input
	// returns whether or not an email was found in index 0 & whether the password was correct in index 1
	public boolean[] validateStudent(String sEmail, String sPassword) {
		boolean[] found = { false, false };

		try {
			Student pulledStudent = getStudentByEmail(sEmail);
			found[0] = true; // email was successfully found

			// verify that sPassword matches password pulled
			if (pulledStudent.getSPass().equals(sPassword)) {
				found[1] = true;
			}
		} catch (Exception e) {
			System.out.println(ANSI_RED + "Student email was not found." + ANSI_RESET);
		}

		return found;
	}

	// takes a Student’s email and a Course ID & checks in the join table (Student_Course)
	// to find if a Student with that Email is currently attending a Course with that ID
	// if the Student is NOT attending that Course, register the student for that course
	public void registerStudentToCourse(String sEmail, int cId) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Course> currentCourses = getStudentCourses(sEmail); // pull current courses
		boolean found = false;
		
		// search for input course id
		for (int i = 0; i < currentCourses.size(); i++) {
			if (currentCourses.get(i).getCId() == cId) { // if found
				found = true;
			}
		}

		if (found) {
			System.out.println(ANSI_RED + "Student is already attending this course." + ANSI_RESET);

		// register the student for the course -> insert into Student_Course
		} else {
			Student s = getStudentByEmail(sEmail);
			System.out.println(ANSI_GREEN + "Registering student " + s.getSName() + " for the course with ID: " + cId
					+ ANSI_RESET);

			Student_Course newStudentCourse = new Student_Course();
			newStudentCourse.setCourseId(cId);
			newStudentCourse.setStudentId(sEmail);

			session.save(newStudentCourse);
		}

		tx.commit();
		factory.close();
		session.close();
	}

	// takes a Student’s Email as a parameter and finds all the courses the student is registered for
	public List<Course> getStudentCourses(String sEmail) {

		Student s = getStudentByEmail(sEmail);
		List<Course> courses = s.getSCourses();

		return courses;

	}

}
