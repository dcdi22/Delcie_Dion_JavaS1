-- make northwind Db default
use northwind;

-- What are the categories of products in the database?
select * from products;

-- What products are made by Dell?
select * from products where product_name like 'Dell%';

-- List all the orders shipped to Pennsylvania.
select * from orders where ship_state = 'Pennsylvania';

-- List the first name and last name of all employees with last names that start with w
select first_name, last_name from employees where last_name like 'W%';

-- List all customers from zipcodes that start with 55
select * from customers 
where postal_code like '55%';

-- List all customers from zipcodes that end with 0
select * from customers 
where postal_code like '%0';

-- List the first name, last name, and email for all customers with a .org email address
select first_name, last_name, email from customers 
where email like '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code
select first_name, last_name, phone from customers 
where phone like '___202%';

-- List the order id for each order placed by George Wilson
select id from orders where ship_name = 'George Wilson'; -- this one doesn't work 

-- List all the products and quantities associated with order 4003
select products.product_name, order_details.quantity
from northwind.products
inner join northwind.order_details on order_details.product_id = products.id
where order_details.order_id = 4003;

-- =====================================
-- car_lot

use car_lot;

insert into car_lot.car (id ,model_year, color, make, model)
values 
(25, '2012', 'Red', 'Honda', 'Accord'),
(26, '2017', 'Black', 'Chevy', 'Implala'),
(27, '2019', 'Silver', 'Ford', 'F-150'),
(28, '2020', 'White', 'Subaru', 'Outback'),
(29, '2015', 'Silver', 'Ford', 'Mustang'),
(30, '2018', 'Blue', 'Honda', 'Ridgeline'),
(31, '2017', 'Gray', 'Chevy', 'Silverado');

select * from car;

-- All Hondas to Black
update car_lot.car
set color = 'Black' 
where make = 'Honda';

select * from car;

-- Change Chevy to Chevrolet
update car_lot.car
set make = 'Chevyrolet' 
where make = 'Chevy';

select * from car;

-- Change 2020 to 2019
update car_lot.car
set model_year = '2019' 
where model_year = '2020' ;

select * from car;

-- Delete all blue
delete from car_lot.car 
where color = 'Blue';

-- Delete all fords
delete from car_lot.car 
where make = 'Ford';

-- Delete cars from 2010 and 2017
delete from car_lot.car 
where model_year between '2012' and '2017';



