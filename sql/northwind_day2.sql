SELECT * FROM customers;

SELECT * 
FROM customers
WHERE City = 'London';

SELECT * 
FROM customers
-- WHERE (SELECT City = 'London' FROM customers WHERE City = 'london');
-- return error as it return more than one row, conditions where not met

-- WHERE (SELECT PostalCode FROM customers WHERE PostalCode = '12209');
-- returns many values, why?
-- following where, looking for a condition, instead returns a set of data/items, then returns everything

WHERE PostalCode = (SELECT PostalCode FROM customers WHERE PostalCode = '12209');
-- nesest selected operates separate from the main query

-- BE CAREFUL WITH SUB QUERY, one bad actor will cause error in whole query
-- Sub query can be a good replacement for joins, not always as effcient though

-- GOAL Return just one data of UK
SELECT DISTINCT Country 
FROM customers
WHERE City = (SELECT City FROM customers WHERE City = 'London' group by city) group by Country; -- group by for outer select statement

-- stored procedure - heavy sql statements are put here, started with a trigger
-- reg. sql statments are executed on the application server
-- store procedues aexecuteed on the database server
-- commonly used in disaster recovery
SELECT * FROM products;

/* BASIC SQL EXECISES*/

-- 1. Write a query to get Product name and quantity/unit.
SELECT ProductName, QuantityPerUnit FROM products;

-- 2. Write a query to get current Product list (Product ID and name).
SELECT ProductID, ProductName FROM products WHERE Discontinued = 0;

-- 3. Write a query to get discontinued Product list (Product ID and name).
SELECT ProductID, ProductName FROM products WHERE Discontinued = 1;

-- 4. Write a query to get most expense and least expensive Product list (name and unit price).
/* SELECT 
	(SELECT ProductID, ProductName FROM products ORDER BY UnitPrice DESC LIMIT 1) as MaxItem 
	(SELECT ProductID, ProductName FROM products ORDER BY UnitPrice ASC LIMIT 1) as MinItem;
*/
SELECT ProductName, UnitPrice from products where UnitPrice = (SELECT MAX(UnitPrice) FROM products) or UnitPrice = (SELECT MIN(UnitPrice) FROM products);

-- 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20.
SELECT ProductID, ProductName, UnitPrice FROM products WHERE UnitPrice < 20 and discontinued = 0;

-- 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25.
SELECT ProductName, UnitPrice FROM products WHERE UnitPrice > 15 and UnitPrice < 25;

-- 7. Write a query to get Product list (name, unit price) of above average price.
SELECT ProductName, UnitPrice FROM products WHERE UnitPrice > (Select AVG(UnitPrice) from products);

-- 8. Write a query to get Product list (name, unit price) of ten most expensive products.
SELECT ProductName, UnitPrice FROM products ORDER BY UnitPrice DESC LIMIT 10;

-- 9. Write a query to count current and discontinued products.
/*
SELECT
	(SELECT count(discontinued) from products where discontinued = 0) as NumCurrent,
	(SELECT count(discontinued) from products where discontinued = 1) as NumDiscontinued;
*/

-- SELECT count(discontinued) as NumCurrent (select count(*) from products where discontinued = 0), 
-- as NumDiscontinued (select count(*) from products where discontinued = 1);
SELECT
	(SELECT count(discontinued) from products where discontinued = 0) as NumCurrent,
	(SELECT count(discontinued) from products where discontinued = 1) as NumDiscontinued;
	
-- 10. Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order.
SELECT ProductName, UnitsOnOrder, UnitsInStock FROM products WHERE UnitsInStock< UnitsOnOrder;

SELECT ProductID, ProductName, Address from products JOIN Suppliers on products.SupplierID = suppliers.SupplierID;

-- For each order, give Order ID, Product NAme, and Company Name
SELECT orders.orderID, ProductID, CustomerID from orders join `order details` on orders.orderID = `order details`.orderID;

SELECT orderID, ProductID, customers.CustomerID, CompanyName from customers join 
	(SELECT orders.orderID, ProductID, CustomerID, 
	from orders join `order details` 
	on orders.orderID = `order details`.orderID) 
	as table1 on customers.CustomerID = table1.CustomerID;
	
SELECT ProductName, orderID, CompanyName from products join
	(SELECT orderID, ProductID, customers.CustomerID, CompanyName from customers join 
	(SELECT orders.orderID, ProductID, CustomerID 
	from orders join `order details` 
	on orders.orderID = `order details`.orderID) 
	as table1 on customers.CustomerID = table1.CustomerID)
	as table2 on products.ProductID = table2.ProductID;

-- SIMPLIFY!!!!
SELECT * from products p 
	join `order details` od on p.ProductID = od.ProductID
	join orders o on o.orderID = od.orderID
	join customers c on c.CustomerID = o.CustomerID
	order by o.OrderID;

SELECT p.ProductName, o.OrderID, od.UnitPrice from products p 
	join `order details` od on p.ProductID = od.ProductID
	join orders o on o.orderID = od.orderID
	join customers c on c.CustomerID = o.CustomerID;
	GROUP BY o.orderID

-- Return orderID, company name, and the number of products ordered for the company
SELECT o.orderID, c.CompanyName, sum(od.Quantity) from orders o 
	join `order details` od on o.orderID = od.orderID
	join customers c on c.CustomerID = o.CustomerID
	GROUP BY o.orderID;