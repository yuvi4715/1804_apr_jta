--Select all records from the Employee table where 
--first name is Andrew and REPORTSTO is NULL.

SELECT * FROM employee 
    WHERE firstname='Andrew' AND reportsto IS NULL; 
    
    
--Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM album 
    ORDER BY title DESC;    --To sort in ascending order, either provide no keyword or use the ASC keyword
    
    
--Update Aaron Mitchell in Customer table to Robert Walter 

UPDATE customer SET firstname='Robert', lastname='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';


--Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM employee 
    WHERE hiredate 
    BETWEEN to_date('2003-06-01', 'yyyy-mm-dd') AND to_date('01-03-04', 'dd-mm-yy');
    
    
--Delete a record in Customer table where the name is Robert Walter 

SELECT * FROM customer WHERE firstname='Robert' and lastname='Walter';

SELECT concat(concat(c.firstname, ' '), c.lastname) AS FullName, il.invoiceid FROM customer c
    INNER JOIN invoice i
    ON c.customerid = i.customerid
    INNER JOIN invoiceline il
    ON il.invoiceid = i.invoiceid
    WHERE c.customerid = 32;
    
DELETE FROM invoiceline WHERE invoiceid IN(61, 116, 245, 268, 290, 50, 342);

select * from customer;

DELETE FROM invoice WHERE invoice.customerid in (
    SELECT customer.customerid FROM invoice
    inner join customer
    on customer.customerid = invoice.customerid
    where customer.customerid = 32);
    
SELECT * FROM invoice WHERE customerid = 32;

DELETE FROM customer WHERE customerid = 32;


--Create an inner join that joins customers and orders and 
--specifies the name of the customer and the invoiceId. 

SELECT c.firstname || ' ' || c.lastname as Name, i.invoiceid FROM customer c
    INNER JOIN invoice i
    ON c.customerid = i.customerid;
    
    
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, 
--firstname, lastname, invoiceId, and total.

SELECT c.customerid, c.firstname || ' ' || c.lastname as Name, i.invoiceid, i.total 
    FROM customer c 
    FULL OUTER JOIN invoice i
    ON c.customerid = i.customerid;
    
-- Demo of how you can use aggregate functions
SELECT count(*) as CountOfCustomers FROM customer;


--Create a right join that joins album and artist specifying artist name and title
SELECT al.title, ar.name FROM album al
    RIGHT JOIN artist ar
    on al.artistid = ar.artistid;
    
    /* Alternative Solution */
SELECT al.title, ar.name FROM album al
    NATURAL JOIN artist ar;
    
    
    
--Create a cross join that joins album and artist 
--and sorts by artist name in ascending order

SELECT al.title, ar.name FROM album al
    CROSS JOIN artist ar
    ORDER BY ar.name;
    
    
--Perform a self-join on the employee table, joining on the REPORTSTO column.
SELECT e.firstname || ' ' || e.lastname as Employee, 
      e2.firstname || ' ' || e2.lastname as ReportsTo
    FROM employee e
    INNER JOIN employee e2
    ON e.reportsto = e2.employeeid;

