CREATE DATABASE transportDB;
USE transportDB;

CREATE TABLE users(
     id INT AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(40) UNIQUE NOT NULL,
     password VARCHAR(40) NOT NULL,
     role VARCHAR(10) NOT NULL
);
INSERT INTO users(username,password,role) VALUES("s","s123","ADMIN");

CREATE TABLE vehicles(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(30),
    seats INT default 1,
    from_ varchar(50),
    to_ varchar(50),
    price DOUBLE,
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE CUSTOMERS (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(40),
     phone bigint unique not null,
     email VARCHAR(30)
);


CREATE TABLE booking(
     id INT AUTO_INCREMENT PRIMARY KEY,
     customer_id INT,
     vehicle VARCHAR(40),
     seats INT DEFAULT 1,
     fare DOUBLE,
     booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
     status VARCHAR(20),
     FOREIGN KEY fr_key (customer_id) REFERENCES customers(id)
);

select * from booking 
inner join customers on customers.id = booking.customer_id;

SELECT CONSTRAINT_NAME
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_SCHEMA = 'transportdb'
  AND TABLE_NAME = 'booking'
  AND COLUMN_NAME = 'vehicle_id'
  AND REFERENCED_TABLE_NAME = 'vehicles';

describe vehicles;