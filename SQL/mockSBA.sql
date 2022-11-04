-- 1. Create a query to return all orders made by users with the first name of “Marion”
select ORDER_ID, u.USER_ID, STORE_ID from orders o
join users u on u.USER_ID = o.USER_ID
where u.FIRST_NAME = 'Marion';

-- 2. Create a query to select all users that have not made an order
select * from users u
left join orders o on u.USER_ID = o.USER_ID
where o.USER_ID is null;

-- 3. Create a Query to select the names and prices of all items that have 
-- been part of 2 or more separate orders. -> item_id shows up more than once in orders
select NAME, PRICE from ITEMS i
join ORDER_ITEMS o on o.ITEM_ID = i.ITEM_ID
group by i.ITEM_ID
having count(i.ITEM_ID) >= 2;

-- 4. Create a query to return the Order Id (ORDER_ITEMS), Item name (ITEMS), 
-- Item Price (ITEMS), and Quantity (ORDER_ITEMS)
-- from orders made at stores in the city “New York”. 
-- Order by Order Id in ascending order.
select oi.ORDER_ID, i.NAME, i.PRICE, oi.QUANTITY
from ORDER_ITEMS oi 
	join items i on i.ITEM_ID = oi.ITEM_ID
	join orders o on o.ORDER_ID = oi.ORDER_ID
    join stores s on s.STORE_ID = o.STORE_ID
where s.CITY = 'New York'
order by oi.ORDER_ID asc;

-- 5. Your boss would like you to create a query that calculates the total revenue generated 
-- by each item. Revenue for an item can be found as (Item Price * Total Quantity Ordered). 
-- Please return the first column as ‘ITEM_NAME’ and the second column as ‘REVENUE’.
select i.NAME 'ITEM_NAME', sum(i.PRICE * oi.QUANTITY) 'REVENUE'
from ITEMS i join ORDER_ITEMS oi on i.ITEM_ID = oi.ITEM_ID
group by i.NAME;

-- 6. Create a query with the following output:
		-- a. Column 1 - Store Name
			-- i. The name of each store 
		-- b. Column 2 - Order Quantity
			-- i. The number of times an order has been made in this store 
		-- c. Column 3 - Sales Figure
			-- i. If the store has been involved in more than 3 orders, mark as ‘High’
			-- ii. If the store has been involved in less than 3 orders but more than 1 order, mark as ‘Medium’
			-- iii. If the store has been involved with 1 or less orders, mark as ‘Low’
		-- d. Should be ordered by the Order Quantity in Descending Order

select s.NAME 'Store Name', count(o.STORE_ID) 'Order Quantity', 
case
	when (count(o.STORE_ID)) > 3 then 'High'
    when (count(o.STORE_ID)) > 1 then 'Medium'
	else 'Low'
end as 'Sales Figure'
from STORES s join ORDERS o on s.STORE_ID = o.STORE_ID
group by s.NAME
order by count(o.STORE_ID) desc;



