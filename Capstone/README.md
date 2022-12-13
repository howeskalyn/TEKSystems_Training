{\rtf1\ansi\ansicpg1252\cocoartf2578
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;\red252\green87\blue8;}
{\*\expandedcolortbl;;\cssrgb\c100000\c43066\c0;}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid1\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid1}
{\list\listtemplateid2\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid101\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{hyphen\}}{\leveltext\leveltemplateid102\'01\uc0\u8259 ;}{\levelnumbers;}\fi-360\li1440\lin1440 }{\listname ;}\listid2}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}{\listoverride\listid2\listoverridecount0\ls2}}
\margl1440\margr1440\vieww13440\viewh7800\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs36 \cf0 Java Developer Case Study - \cf2 ShowSeek
\fs32 \cf0 \
Kalyn Howes\
\

\fs28 Overview:\

\fs24 ShowSeek is a website for locating events and concerts. Basic functionality includes searching for events, \'93purchasing\'94 tickets for an event, adding friends, etc. \
\
The functionality of this website is dependent on Java, SpringBoot, JSP, and MySQL Databases. Basic package structure includes a runner, configuration files, data access objects, entities for SQL tables, forms for usage with JSP displays, security, and form validation. These packages are all found under the src/main/java package folder. All JSP displays using HTML/CSS/JS, image inclusions, and more are located in the following folder: src/main/webapp. For responsive, user-friendly displays, Bootstrap 5 has been used throughout all of the JSP pages. \
\
Security measures are in place for certain actions, as they cannot be completed unless a user is logged in. There are special admin privileges incorporated into this as well. Passwords are encrypted using BCrypt Hash and will never enter the database in plain text form. \
\
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\fs28 \cf0 Notes:
\fs24 \
\pard\tx220\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\li720\fi-720\pardirnatural\partightenfactor0
\ls1\ilvl0\cf0 {\listtext	\uc0\u8226 	}Logging has been implemented using Lombok. Logs are shown on the SpringBoot Console when each page is being accessed to keep a chronological	access memory.\
{\listtext	\uc0\u8226 	}Some read methods created for pulling data from the database are brute-force and will not operate well in large-level production in their current state. \
{\listtext	\uc0\u8226 	}A Trello Board has been used during the process to keep track of to-do lists. It can be found here: https://trello.com/b/va4cMkbs/showseek-capstone\
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0
\cf0 \
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\fs28 \cf0 Future:\
\pard\tx220\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\li720\fi-720\pardirnatural\partightenfactor0
\ls2\ilvl0\cf0 {\listtext	\uc0\u8226 	}
\fs24 Ideas I had that are out of scope at this time include:\
\pard\tx940\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\li1440\fi-1440\pardirnatural\partightenfactor0
\ls2\ilvl1
\fs28 \cf0 {\listtext	\uc0\u8259 	}
\fs24 Recommending events based on previously bought tickets and events that friends are attending.\
\ls2\ilvl1
\fs28 {\listtext	\uc0\u8259 	}
\fs24 Automatic location proximity results\
\ls2\ilvl1
\fs28 {\listtext	\uc0\u8259 
\fs24 	}Notifications when a friend buys tickets to an event, tickets go on sale, etc\
{\listtext	\uc0\u8259 	}Link with Google to add events directly to a Google Calendar\
{\listtext	\uc0\u8259 	}Ticket purchase options through Ticketmaster, SeatGeek, etc.\
}
