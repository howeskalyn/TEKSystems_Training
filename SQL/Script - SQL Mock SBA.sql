
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`SBA_MOCKUP` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `SBA_MOCKUP`;

/*Table structure for table `customers` */

CREATE TABLE USERS (
USER_ID INTEGER PRIMARY KEY,
FIRST_NAME VARCHAR(30),
LAST_NAME VARCHAR(30),
CITY VARCHAR(60)
);

CREATE TABLE STORES (
STORE_ID INTEGER PRIMARY KEY,
NAME VARCHAR(100),
CITY VARCHAR(60),
SALES_TAX_RATE FLOAT(6,5)
);

CREATE TABLE ITEMS (
ITEM_ID INTEGER PRIMARY KEY,
NAME VARCHAR(30),
PRICE FLOAT(5,2)
);

CREATE TABLE ORDERS (
ORDER_ID INTEGER PRIMARY KEY,
USER_ID INTEGER,
STORE_ID INTEGER,
CONSTRAINT FK_UserID FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
CONSTRAINT FK_StoreID FOREIGN KEY (STORE_ID) REFERENCES STORES(STORE_ID)
);

CREATE TABLE ORDER_ITEMS (
ORDER_ID INTEGER,
ITEM_ID INTEGER,
QUANTITY INTEGER,
CONSTRAINT PK_Order_Items PRIMARY KEY (ORDER_ID, ITEM_ID),
CONSTRAINT FK_OrderID FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
CONSTRAINT FK_ItemID FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)
);



INSERT INTO USERS VALUES (1, 'Lucien', 'Arnolfi', 'New York');
INSERT INTO USERS VALUES (2, 'Susila', 'Foster', 'Stamford');
INSERT INTO USERS VALUES (3, 'Marion', 'Cole', 'New York');
INSERT INTO USERS VALUES (4, 'Edna', 'Kay', 'New York');
INSERT INTO USERS VALUES (5, 'Meridith', 'Stefanov', 'Stamford');
INSERT INTO USERS VALUES (6, 'Mike', 'G', 'New York');

INSERT INTO STORES VALUES (1, 'Bronx Location', 'New York', 0.08875);
INSERT INTO STORES VALUES (2, 'Financial District', 'New York', 0.08875);
INSERT INTO STORES VALUES (3, 'Harlem Location', 'New York', 0.08875);
INSERT INTO STORES VALUES (4, 'North Stamford Location', 'Stamford', 0.0635);
INSERT INTO STORES VALUES (5, 'South Stamford Location', 'Stamford', 0.0635);

INSERT INTO ITEMS VALUES (1,'Hotdog',1.35);
INSERT INTO ITEMS VALUES (2,'Hamburger', 2.00);
INSERT INTO ITEMS VALUES (3,'Cheeseburger',2.50);
INSERT INTO ITEMS VALUES (4,'Fries',1.00);
INSERT INTO ITEMS VALUES (5,'Soda',1.00);


INSERT INTO ORDERS VALUES(1,1,1);
INSERT INTO ORDERS VALUES(2,3,1);
INSERT INTO ORDERS VALUES(3,3,3);
INSERT INTO ORDERS VALUES(4,2,5);
INSERT INTO ORDERS VALUES(5,4,1);
INSERT INTO ORDERS VALUES(6,5,5);
INSERT INTO ORDERS VALUES(7,1,2);
INSERT INTO ORDERS VALUES(8,5,4);

INSERT INTO ORDER_ITEMS VALUES(1,1,2);
INSERT INTO ORDER_ITEMS VALUES(1,4,1);
INSERT INTO ORDER_ITEMS VALUES(1,5,1);
INSERT INTO ORDER_ITEMS VALUES(2,3,1);
INSERT INTO ORDER_ITEMS VALUES(2,5,1);
INSERT INTO ORDER_ITEMS VALUES(3,4,8);
INSERT INTO ORDER_ITEMS VALUES(4,3,1);
INSERT INTO ORDER_ITEMS VALUES(4,4,1);
INSERT INTO ORDER_ITEMS VALUES(5,5,1);
INSERT INTO ORDER_ITEMS VALUES(6,1,2);
INSERT INTO ORDER_ITEMS VALUES(7,1,2);
INSERT INTO ORDER_ITEMS VALUES(8,1,2);


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;