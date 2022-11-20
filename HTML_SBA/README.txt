README.txt
Kalyn Howes
ShowSeek

GitHub: https://github.com/howeskalyn/TEKSystems_Training/tree/main/HTML_SBA

front_page.html:
This file contains code for the home page of the ShowSeek website. It uses external and internal JavaScript and CSS. Bootstrap 5 has also been implemented here for the general page structures including the navigation bar, cards, and a footer. Only the following buttons/links are implemented:
	- "Start Rockin" button to display shows near you
	- Navigation bar:
		- "Home" takes you to the home page
		- "Events" takes you to the same page as the "Start Rockin'" button
		- "Profile" moves you to the user log-in page
	-"Display Pages" calls an external JavaScript function to create the pagination bar. This function uses a for loop to add list items to the html div tag.


show_page.html:
This file contains code for the "Events" page of the ShowSeek website. It uses external and internal JavaScript and CSS. Bootstrap 5 has also been implemented here for the general page structures including the navigation bar, form, and a footer. The form includes two text boxes to input the address and city, which are labeled as required in the inout tag. The state selection is presented in the form of a dropdown. There is also regex validation in the Zip Code field, using a pattern to allow only 5 digit numbers. This form does not actually present any events at this time. The "Display All Shows" button is a toggle that will switch between showing an html table of all events, and hiding them.

user_login.html:
This file contains code for the "Profile" page of the ShowSeek website. It uses external and internal JavaScript and CSS. Bootstrap 5 has also been implemented here for the general page structures including the navigation bar, form, and a footer. This form has two required text fields that allow the user to input a username and password. There is also a silly button included here that will show a window alert, just for personal practice with window object models and event handling.

