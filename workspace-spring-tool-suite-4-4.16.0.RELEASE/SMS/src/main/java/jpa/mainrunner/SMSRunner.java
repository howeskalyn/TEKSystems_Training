package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.dao.CourseService;
import jpa.dao.StudentService;
import jpa.entitymodels.Course;

/*
 * displays and prompts the user to select one of the following options:
 * 
 * 1. Student: This allows the user to enter their email and password and check
 * whether or not those credentials are valid.
 * 
 * -If the credentials are invalid the program should end with an appropriate
 * message to the student.
 * 
 * -If the credentials are valid, the student is logged in and all the classes
 * the Student is registered to should be displayed. Then prompt the
 * student to select one of the following two additional numeric (1 or 2)
 * options that are available:
 * 
 * 1a) Register to Class: This displays all the courses in the database and
 * allows the student to select a course in which the student wished to be
 * registered. If the Student is already registered in that course, display the
 * message "You are already registered in that course!", otherwise, register the
 * student to that course and save this result in your database. Also, show the
 * updated registered courses list for that student. After that end the program
 * with an appropriate message.
 * 
 * 1b) Logout: Which ends the program with an appropriate message.
 * 
 * 2. Quit: which ends the program with an appropriate message.
 */

public class SMSRunner {

	private static StudentService ss = new StudentService();
	private static CourseService cs = new CourseService();
	private static Scanner sc = new Scanner(System.in);
	
	// for colored output to console
	public static final String ANSI_RED = "\u001B[31m"; 
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {

		boolean systemOn = true;
		while (systemOn) {

			int choice = displayMainMenuGetInput();
			sc.nextLine();

			switch (choice) {
			case 1: // if the first option is selected, get credentials & send to log in

				try {
					String[] info = getLoginInfo(); // holds email in 0 index and password in 1
					if (ss.validateStudent(info[0], info[1])) {

						boolean cont = true;
						while (cont) {
							printCurrentCourses(info[0]);
							cont = studentLoginScreen(info[0]);
						}
					} else {
						System.out.println(ANSI_RED + "The password you entered was incorrect!" + ANSI_RESET);
						//systemOn = false;
					}

				} catch (Exception e) {
					System.out.println(ANSI_RED + "Student email was not found." + ANSI_RESET);
				}

				break;
			case 2: // otherwise, quit
				System.out.println(ANSI_RED + "System quitting..." + ANSI_RESET);
				systemOn = false;
				break;
			}
		}

	}

	// ----- HELPER METHODS -----

	// displays the main menu & gathers input from user
	public static int displayMainMenuGetInput() {
		System.out.println("\n------- MAIN MENU -------");
		System.out.println("1) Student Log In\n2) Quit");
		System.out.print("Choose an option: ");
		int input = 0;
		try {
			input = sc.nextInt();
			if (input < 0 || input > 2) {
				System.out.println(ANSI_RED + "Please enter either number 1 or 2.\n" + ANSI_RESET);
			}
		} catch (Exception e) {
			System.out.println(ANSI_RED + "Please enter either number 1 or 2.\n" + ANSI_RESET);
		}

		return input;

	}

	// takes in user login info
	public static String[] getLoginInfo() {
		String[] info = new String[2];

		System.out.print("\nEnter email: ");
		String email = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();

		info[0] = email;
		info[1] = password;
		return info;
	}

	// prints a students current courses by using their email
	public static void printCurrentCourses(String email) {
		List<Course> currentCourses = ss.getStudentCourses(email);
		System.out.println("\n--- Courses for " + email + " ---");
		for (Course c : currentCourses) {
			System.out.println(c.toString());
		}
	}

	// displays the student login screen and options & gathers input
	public static boolean studentLoginScreen(String email) {
		boolean cont = true;

		System.out.println("\n- Select from the Following -");
		System.out.println("1) Register for a Class\n2) Logout");
		System.out.print("Choose an option: ");
		int input = 0;
		try {
			input = sc.nextInt();
		} catch (Exception e) {
			System.out.println(ANSI_RED + "Please enter either number 1 or 2.\n" + ANSI_RESET);
		}

		switch (input) {
		case 1: // sends to register for a class
			registerForClass(email);
			break;
		case 2: // logout and return to main menu
			System.out.println(ANSI_RED + "Logging you out..." + ANSI_RESET);
			cont = false;
			break;
		}

		return cont;

	}

	// prints all courses, takes in input & registers the student for the course
	public static void registerForClass(String email) {
		// display all possible courses in database
		List<Course> allCourses = cs.getAllCourses();
		System.out.println("\n--- All Possible Courses ---");
		for (Course c : allCourses) {
			System.out.println(c.toString());
		}

		// select course to register for, using id
		System.out.print("\nSelect a Course ID: ");
		int courseSelection = 0;
		try {
			courseSelection = sc.nextInt();
		} catch (Exception e) {
			System.out.println(ANSI_RED + "Please enter a valid Course ID.\n" + ANSI_RESET);
		}

		ss.registerStudentToCourse(email, courseSelection);
	}

}
