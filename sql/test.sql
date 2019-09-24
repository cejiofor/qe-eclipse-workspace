CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
); 

-- Add contrainst -> primary key, new columns, insert 3-5 rows of dummy data
-- INSERT 

ALTER TABLE Persons
ADD PRIMARY KEY (PersonID);

DROP TABLE Persons;

CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255),
    PRIMARY KEY (PersonID)
); 
-- DROP PRIMARY KEY;

