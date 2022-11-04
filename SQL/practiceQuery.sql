-- 10/17/2022 class exmaples
select * from customers;
select * from employees;

select * from employees where firstName = 'Mary';
select firstName, lastName, email from employees;
select count(*) from employees where firstName = 'Mary';

select distinct postalCode from customers order by postalCode asc;
select distinct firstName, lastName from employees order by firstName;
select firstName as employeefirstName, lastName from employees order by firstName;

SET sql_safe_updates=0; -- turns off safe mode 
select concat(contactFirstName, " ", contactLastName) as fullName, contactFirstName, contactLastName 
from customers where contactLastName = 'King';
update customers set customerName = "" where contactLastName = 'King';
update customers set customerName = concat(contactFirstName, " ", contactLastName) where contactLastName = 'King';

select * from customers where contactFirstName = "Susan";
select * from customers where state = "CA";
select * from customers where state = "CA" order by contactLastName limit 5;

select * from employees order by email; -- looking for dupes to alter table
update employees set email = 'jfirrelli2@classicmodelcars.com' where employeeNumber = 1188;

-- slide examples
select customerName, contactLastName, contactFirstName, city, state from customers;

INSERT into customers VALUES
(497, 'Jenny','Jenny','Jones','917-433-2828','12 Mockingbird Lane', NULL,'Omaha','NE','54550','USA',1002,2000.00);

CREATE TABLE `temporary_payments` (
	`customerNumber` INT(11) NOT NULL,
	`checkNumber` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`paymentDate` DATE NOT NULL,
	`amount` DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (`customerNumber`, `checkNumber`) USING BTREE
) COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

INSERT into temporary_payments
SELECT * from payments
WHERE amount>2000;

-- 10/18/2022 class examples
select * from vehicles;
insert into vehicles (year, make) values (2021, 'Jeep');
insert into vehicles (year, make) values (2022, 'Tesla');
insert into vehicles (year, make) values (1999, 'Beater');
insert into vehicles (year, make) values (1974, 'Pinto');
insert into vehicles (year, make) values (2020, 'F350');

delete from vehicles where id = 2;

-- bad practice to enter an id
insert into vehcicles (id, year, make) values (7, 2008, 'Highlander');

-- created 'manufacturers' table
select * from manufacturers;
insert into manufacturers (name) value ('Ford'); -- id 1
insert into manufacturers (name) value ('Jeep'); -- id 2
update vehicles set manufacturer_id = 1 where id > 1;
update vehicles set manufacturer_id = 2 where id = 1;

select status, count(*) from orders group by status;

select productVendor, avg(buyPrice) from products 
group by productVendor order by avg(buyPrice) asc;

-- IN CLASS WORK
-- How many customers are in each state, ordered by the state name?
select state, count(*) from customers group by state order by state asc;

-- How many customers does each sales rep have?
select salesRepEmployeeNumber, count(*) from customers group by salesRepEmployeeNumber;

-- What is the average credit limit by state, showing highest credit limit first?
select state, avg(creditLimit) from customers 
group by state order by avg(creditLimit) desc;

-- What is the average credit limit, and number of customers in each country ordered by # of customers, low-high
select country, avg(creditLimit), count(*), min(creditLimit), max(creditLimit)
from customers group by country order by avg(creditLimit) asc;

-- countries with most customers first, and then by country name alphabetically
select country, avg(creditLimit), count(*), min(creditLimit), max(creditLimit)
from customers group by country order by count(*) desc, country asc;

-- Total # of vacation hours & the average # of vacation hours by jobTitle
-- ordered by the job title w the most vacation days first
select jobTitle, avg(VacationHours), sum(VacationHours) from employees 
group by jobTitle order by sum(VacationHours) desc;

-- Count of # employees that report to a manager
select reportsTo, count(*) from employees group by (reportsTo);

-- Count of each individual first name
select firstName, count(firstName) from employees group by firstName;

-- Total amount collected for each month orderd by the most recent month first
-- you can group by 2 things just like an order by
select month(paymentDate), year(paymentDate), sum(amount) from payments 
group by year(paymentDate), month(paymentDate) 
order by year(paymentDate) desc, month(paymentDate) desc;

-- Class examples 10/19/22
select * from orderdetails;

select * from products where productCode = 'S18_1749';

-- JOIN EXAMPLE
select od.orderNumber, p.productName, od.quantityOrdered, od.priceEach, (od.quantityOrdered * od.priceEach) as totalPrice
from orderdetails od, products p
where od.productCode = p.productCode
order by orderNumber;

-- Question 1:
-- customer number, order number, order date, customer name & order status, 
-- sorted by order date with oldest first
select o.customerNumber, o.orderNumber, o.orderDate, c.customerName, o.status
from orders o, customers c 
where o.customerNumber = c.id
order by o.orderDate asc;

-- Question 2:
-- sales person first and last name, year, total amount in payments, total number payments
select concat(e.firstName, " ", e.lastName) as Name, year(p.paymentDate) 'Year', sum(p.amount) 'Total Payments', count(p.amount) 'Number of Payments'
from employees e, customers c, payments p
where c.salesRepEmployeeNumber = e.id and p.customerNumber = c.id
group by e.id, year(p.paymentDate)
order by Name;

-- Question 3:
-- item name, the item number, the sales person's first and last name
-- there can be no duplicates and orderd by the sales persons last name alphabetially
select distinct p.productName, p.productCode, e.firstName 'First Name', e.lastName 'Last Name'
from employees e, customers c, orderdetails od, products p, orders o
where c.salesRepEmployeeNumber = e.id 
and p.productCode = od.productCode 
and od.orderNumber = o.orderNumber
and c.id = o.customerNumber
order by e.lastName asc;

-- andrew's way
select distinct p.productName, p.productCode, e.firstName, e.lastName
from employees e 
join customers c on e.id = c.salesRepEmployeeNumber 
join orders o on c.id = o.customerNumber 
join orderdetails od on o.orderNumber = od.orderNumber 
join products p on p.productCode = od.productCode
order by e.lastName;

-- JOIN TYPES
select p.productName, od.quantityOrdered, od.priceEach
from products p join orderdetails od on p.productCode = od.productCode;
-- vs
select p.productName, od.quantityOrdered, od.priceEach
from products p, orderdetails od
where p.productCode = od.productCode;

-- Question #4
-- the purchasing department wants to know which products they need to restock
-- need: product line and the product line description, the product name, product vendor, quantity
-- ordered by the product line and then the product name both in alphabetical order
select  p.productLine, pl.textDescription, p.productName, p.productVendor, p.quantityInStock
from products p join productlines pl on p.productLine = pl.productLine
order by p.productLine, substring(p.productName,6,100);

-- Class 10/20/22

-- 304.3.2 Union
(select firstName, lastName
from employees limit 5)
UNION
(select contactFirstName, contactLastName
from customers limit 5);

-- subquery - will give us all employees that do have a custoemr relationship
-- NOTE : a subquery must return only 1 column - if you have more than 1 column then it will not compile
select * from employees 
where employeeNumber in (select distinct salesRepEmployeeNumber from customers where salesRepEmployeeNumber is not null);

select * from employees where employeeNumber in (1501, 1504, 1611); 

-- first develop the subquery and get that to be what you want before putting into a larger query
 select distinct salesRepEmployeeNumber from customers where salesRepEmployeeNumber is not null;

-- The sales department wants to know which items are being orderd in the largest quantity per order.  Show a report
-- of all products that have the largest quantity in each order.  Show the product name, the order number
-- use a subqqeury to find the largest product quantity by order and then work it into a larger query
select od.orderNumber, p.productName, od.quantityOrdered
from products p join orderDetails od using (productCode)
where od.quantityOrdered = (select max(quantityOrdered) from orderDetails where od.orderNumber = orderNumber);

-- HOMEWORK
-- 1) The sales manager wants to see all orders that have an average price that is greater than $50
-- you do not need to include the quantity ordered in the average price calculation
-- the manager wants to see the order number and the average price rounded to 2 decimal places
-- (HINT: this will use the HAVING command)
select orderNumber 'Order Number', round(avg(priceEach), 2) 'Average Price'
from orderdetails
group by orderNumber having avg(priceEach) > 50.00;

-- 2) Do the same report above, however use the average of (quantity ordered * price)
-- and show orders with an average price greater than $500 - format report the same way
select orderNumber 'Order Number', round(avg(priceEach * quantityOrdered), 2) 'Average Price' 
from orderdetails
group by orderNumber having avg(priceEach * quantityOrdered) > 500.00;

-- 3) Using the query above in #2, show the first and last name of each employee that goes with the order and the average price
-- of (quantity ordered * the price). Also, include the total number of items ordered. Use a left join
select firstName, lastName, o.orderNumber, count(*) 'Total Items Ordered', round(avg(quantityOrdered * priceEach),2)
from orders o 
	left join orderdetails od on o.orderNumber=od.orderNumber 
	left join customers c on c.id = o.customerNumber 
	left join employees e on e.id = c.salesRepEmployeeNumber
group by o.orderNumber having avg(priceEach * quantityOrdered) > 500.00;

-- 4) Use a case statement to show the margin (MSRP - buyPrice) of the products. We want to assign a rating to the margin.
-- if the margin is greater than 80 then output excellent, if greater or equal to 50 output good, if less than 50 output poor
-- report should include the product name, MSRP, buyPrice, margin, and rating.
-- HINT - research how to use a MySQL case statement
select productName, MSRP, buyPrice,
case
	when (MSRP - buyPrice) > 80 then 'Excellent'
    when (MSRP - buyPrice) >= 50 then 'Good'
    when (MSRP - buyPrice) < 50 then 'Poor'
end as margin
from products;

-- 5) Do problem #4, #9, #12 on page https://www.w3resource.com/sql-exercises/sql-subqueries-exercises.php
-- #25 is really a great example of an SBA question

-- 6) Do #6 on https://www.w3resource.com/sql-exercises/union/sql-union.php

-- 7) aditional exercises - https://www.hackerrank.com/challenges/harry-potter-and-wands/problem
-- focus on using left join and also left join as a subquery

-- 8) subquery as a table <----

-- 9) find the difference between the price of each product and the avg price of all products
-- round result to 2 decimal places
-- include productCode, productName, average, and difference
select productCode, productName, avg(MSRP), round(MSRP - (select avg(MSRP) from products), 2)
from products;


















-- Hibernate Lab 1
create database usersdb;
use usersdb;
select * from user;

INSERT INTO `usersdb`.`employee` (`addressLine`, `city`, `job`, `name`, `officeCode`, `salary`, `startDate`, `zipcode`) VALUES 
('24-10', 'NYC', 'Ceo', 'Tom Thele', 1, '25600', '2021-09-09 18:32:11.000000', '11102'),
('35-16', 'LA', 'Manager', 'Jenny Ji', 2, '15600', '2021-09-09 18:32:11.000000', '11103'),
('34-10', 'NJ', 'Cfo', 'M Joseph', 3, '16600', '2021-09-09 18:32:11.000000', '11583'),
('44-20', 'NYC', 'Manager', 'James Judge', 4, '185600', '2021-09-09 18:32:11.000000', '18983'),
('44-20', 'Dallas', 'Manager', 'Ramon Rio', 5, '36600', '2021-09-09 18:32:11.000000', '14783'),
('44-40', 'LA', 'Manager', 'James Santana', 6, '78600', '2021-09-09 18:32:11.000000', '18483'),
('484-40', 'LA', 'Manager', 'Elded Oreo', 6, '50089', '2021-09-09 18:32:11.000000', '155483');
















