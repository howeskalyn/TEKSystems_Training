# 1.) Write a query to display the name, product line, and buy price of all products. 
# The output columns should display as “Name,” “Product Line,” and “Buy Price.” 
# The output should display the most expensive items first.
select productName 'Name', productLine 'Product Line', buyPrice 'Buy Price'
from products order by buyPrice asc;

# 2) Write a query to display the first name, last name, and city name of all customers from Germany. 
# Columns should display as “First Name,” “Last Name,” and “City.” 
# The output should be sorted by “Last Name” (ascending).
select contactFirstName 'First Name', contactLastName 'Last Name', city 'City'
from customers where country = 'Germany'
order by contactLastName asc;

# 3) Write a query to display each of the unique values of the status field in the orders table. 
# The output should be sorted alphabetically, increasing. 
# Hint: The output should show exactly six rows.
select distinct status from orders order by status asc;

# 4) Select all fields from the payments table for payments made on or after January 1, 2005. 
# The output should be sorted by increasing the payment date.
select * from payments where paymentDate >= '2005-01-01' order by paymentDate asc;

# 5) Write a query to display the Last Name, First Name, Email Address,  
# and Job Title of all employees working out of the San Francisco office. 
# Output should be sorted by “Last Name.”
select lastName 'Last Name', firstName 'First Name', email 'Email', jobTitle 'Job Title'
from employees where officeCode = 1 order by lastName;

# 6) Write a query to display the Name, Product Line, Scale, and Vendor of all of the Car products – both classic and vintage. 
# The output should display all vintage cars first (sorted alphabetically by name), 
# and all classic cars last (also sorted alphabetically by name). 
# (productLine hold whether the car is classic or vintage)
select productName 'Product Name', productLine 'Product Line', productScale 'Product Scale', 
productVendor 'Product Vendor' from products 
where productLine = 'Vintage Cars' or productLine = 'Classic Cars'
order by productLine desc, substring(productName,6,100); 
# to disregard the year in front of productName

