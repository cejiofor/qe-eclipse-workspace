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
SALES_TAX_RATE FLOAT (6,5)
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

-- 1. Create a query to return all orders made by users with the first name of “Marion” 

select * from orders where order_id in 
(Select order_id from orders 
join users on orders.USER_ID = users.USER_ID 
where first_name = "Marion");

-- 2. Create a query to select all users that have not made an order 

select * from users 
where user_id not in 
(select users.USER_ID from users right join orders on orders.USER_ID = users.USER_ID);

-- 3. Create a Query to select the names and prices of all items that have been part of 2 or more separate orders.

select name, price from items i 
join order_items oi on i.item_id = oi.item_id 
group by name
having count(oi.item_id) >= 2;

-- 4. Create a query to return the Order Id, Item name, Item Price, and Quantity 
-- from orders made at stores in the city “New York”. 
-- Order by Order Id in ascending order.

select o.ORDER_ID, i.name, price, quantity from order_items oi 
join items i on oi.item_id = i.item_id
join orders o on o.ORDER_ID = oi.order_id
join stores s on o.store_id = s.STORE_ID where s.city = "new york"
order by order_id;

-- 5. Your boss would like you to create a query that calculates the 
-- total revenue generated by each item. Revenue for an item can be 
-- found as (Item Price * Total Quantity Ordered). 
-- Please return the first column as ‘ITEM_NAME’ and the second column as ‘REVENUE’.

select name as `ITEM NAME`, sum(quantity*price) as REVENUE 
from (
	select o.order_id, i.name, oi.quantity, i.price 
		from order_items oi 
		join items i 
		on oi.item_id = i.item_id
		join orders o 
		on o.ORDER_ID = oi.order_id)
		group by name;

-- 6. Create a query with the following output:
-- 	a. Column 1 - Store Name 
			-- i. The name of each store 
-- 	b. Column 2 - Order Quantity 
			-- i. The number of times an order has been made in this store 
-- 	c. Column 3 - Sales Figure 
-- 		i. If the store has been involved in more than 3 orders, mark as ‘High’ 
-- 		ii. If the store has been involved in less than 3 orders but more than 1 order, mark as ‘Medium’ 
-- 		iii. If the store has been involved with 1 or less orders, mark as ‘Low’ d. 
-- 		iiii Should be ordered by the Order Quantity in Descending Order 

SELECT NAME AS `Store Name`, COUNT(o.store_id) AS `Order Quantity`,
Case
	When COUNT(o.store_id) > 3 Then "High"
	When COUNT(o.store_id) > 1 AND COUNT(s.store_id) <= 3 Then "Medium"
	When COUNT(o.store_id) <= 1 Then "Low"
END AS `Sales Figures`
from orders o
join stores s ON s.STORE_ID = o.STORE_ID 
GROUP BY s.store_id ORDER BY `Order Quantity` DESC;

