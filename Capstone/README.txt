Java Developer Case Study - ShowSeek
Kalyn Howes

Overview:
ShowSeek is a website for locating events and concerts. Basic functionality includes searching for events, “purchasing” tickets for an event, adding friends, etc. 

The functionality of this website is dependent on Java, SpringBoot, JSP, and MySQL Databases. Basic package structure includes a runner, configuration files, data access objects, entities for SQL tables, forms for usage with JSP displays, security, and form validation. These packages are all found under the src/main/java package folder. All JSP displays using HTML/CSS/JS, image inclusions, and more are located in the following folder: src/main/webapp. For responsive, user-friendly displays, Bootstrap 5 has been used throughout all of the JSP pages. 

Security measures are in place for certain actions, as they cannot be completed unless a user is logged in. There are special admin privileges incorporated into this as well. Passwords are encrypted using BCrypt Hash and will never enter the database in plain text form. 

Notes:
•Logging has been implemented using Lombok. Logs are shown on the SpringBoot Console when each page is being accessed to keep a chronological	access memory.
•Some read methods created for pulling data from the database are brute-force and will not operate well in large-level production in their current state. 
•A Trello Board has been used during the process to keep track of to-do lists. It can be found here: https://trello.com/b/va4cMkbs/showseek-capstone
•Search bar in navigation bar is NOT implemented. It is there for only looks at the moment.

Future:
Ideas I had that are out of scope at this time include:
	⁃Recommending events based on previously bought tickets and events that friends are attending.
	⁃Automatic location proximity results
	⁃Notifications when a friend buys tickets to an event, tickets go on sale, etc
	⁃Link with Google to add events directly to a Google Calendar
	⁃Ticket purchase options through Ticketmaster, SeatGeek, etc.
