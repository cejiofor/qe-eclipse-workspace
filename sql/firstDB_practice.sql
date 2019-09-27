DROP TABLE IF EXISTS student;
CREATE TABLE student (
  student_id INT PRIMARY KEY,
  name VARCHAR(20),
  major VARCHAR(20)
--   PRIMARY KEY(student_id)
-- Another way to set the primary key, instead of doiong it as above
);

DESCRIBE student;

-- Add a columnd for gpa in format #.##
ALTER TABLE student ADD gpa DECIMAL(3,2) DEFAULT 3.50;

ALTER TABLE student DROP COLUMN gpa; -- remove the gpa column

INSERT INTO student VALUES (
    1, 'Jack', 'Biology'
);

SELECT * FROM student;
-- gives all information from student table

INSERT INTO student VALUES (2, 'Kate', 'Sociology');

INSERT INTO student(student_id, name) VALUES (3, 'Mariah');
-- when you want to add a row, but not all arributes are defined for entry

INSERT INTO student VALUES (4, 'Jack', 'Biology');
INSERT INTO student VALUES (5, 'John', 'Computer Science');


DROP TABLE IF EXISTS student;
CREATE TABLE student (
  student_id INT,
  name VARCHAR(20) NOT NULL,
  -- name cannot be null
  major VARCHAR(20),
  -- major field must be unqie for each row int the table 
  PRIMARY KEY(student_id)
);

INSERT INTO student VALUES (1, 'Jack', 'Biology');
INSERT INTO student VALUES (2, 'Kate', 'Sociology');
INSERT INTO student(student_id, name) VALUES (3, 'Mariah');
INSERT INTO student VALUES (4, 'Jack', 'Biology');
INSERT INTO student VALUES (5, 'John', 'Computer Science');

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  student_id INT AUTO_INCREMENT,
  -- AUTOMATICALLY increments the student id
  name VARCHAR(20) NOT NULL,
  major VARCHAR(20) DEFAULT 'undecided',
  -- set a default value if attirubte not given 
  PRIMARY KEY(student_id)
);

INSERT INTO student (name, major) VALUES ('Jack', 'Biology');
INSERT INTO student (name, major) VALUES ('Kate', 'Sociology');
INSERT INTO student (name) VALUES ('Mariah');
INSERT INTO student (name, major) VALUES ('Jack', 'Biology');
INSERT INTO student (name, major) VALUES ('John', 'Computer Science');

SELECT * FROM student;
UPDATE student
SET major = 'Bio'
WHERE major = 'Biology';

UPDATE student
set major = 'BioChem'
where major = 'Bio' OR major = 'Chemistry';
-- use where to select specifc rows
-- where is option, thus applies to every row in the table


-- DELETE ROWS
DELETE FROM student; -- deletes all rows
DELETE FROM student WHERE student_id = 5;

SHOW TABLES;
TRUNCATE student; -- Delete contecnts while maintaining the table strcuture

-- use sql queriew to specific basic conditions around requesting inforationm from database

SELECT name, student.major -- prepend these with table name for clarity
FROM student -- get specfic columns back, use * to get all
ORDER BY name DESC -- order the result by nmae in descending order
-- can order by attribute that are not being returne , i.e. ordere 
LIMIT 2; -- limit the number or results being returned


SELECT *
FROM student
WHERE major = "Biochem" OR "undecided";-- use where statments to get specific statements

SELECT *
FROM student
WHERE major IN ('Biology', 'Chemistry') and student_id > 2;
-- Comparisions: < > <= >= = <> AND OR
-- combine with where statement for more throuough giltering

-- Need more complex data bases with more that one ta

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS works_with;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS branch_supplier;
DROP TABLE IF EXISTS branch;
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    first_name VARCHAR(40),
    last_name VARCHAR(40),
    birth_day DATE,
    sex VARCHAR(1),
    salary INT,
    super_id INT, -- CAN'T yet define as foregin keys since the other tables don't exisit
    branch_id INT  
);

CREATE TABLE branch (
    branch_id INT PRIMARY KEY,
    branch_name VARCHAR(40),
    mgr_id INT,
    mgr_start_date DATE,
    FOREIGN KEY(mgr_id) REFERENCES employee(emp_id) ON DELETE SET NULL
);

ALTER TABLE employee -- alter table
ADD FOREIGN KEY(branch_id) 
REFERENCES branch(branch_id) -- reference 
ON DELETE SET NULL;

select * from employee;

ALTER TABLE employee
ADD FOREIGN KEY (super_id)
REFERENCES employee(emp_id)
ON DELETE SET NULL;

CREATE TABLE client (
  client_id INT PRIMARY KEY,
  client_name VARCHAR(40),
  branch_id INT,
  FOREIGN KEY(branch_id) REFERENCES branch(branch_id) ON DELETE SET NULL
);

CREATE TABLE works_with (
  emp_id INT,
  client_id INT,
  total_sales INT,
  PRIMARY KEY(emp_id, client_id),
  FOREIGN KEY(emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE,
  FOREIGN KEY(client_id) REFERENCES client(client_id) ON DELETE CASCADE
);

CREATE TABLE branch_supplier (
  branch_id INT,
  supplier_name VARCHAR(40),
  supply_type VARCHAR(40),
  PRIMARY KEY(branch_id, supplier_name),
  FOREIGN KEY(branch_id) REFERENCES branch(branch_id) ON DELETE CASCADE
);


-- -----------------------------------------------------------------------------

-- Corporate
INSERT INTO employee VALUES(100, 'David', 'Wallace', '1967-11-17', 'M', 250000, NULL, NULL);

INSERT INTO branch VALUES(1, 'Corporate', 100, '2006-02-09');

UPDATE employee
SET branch_id = 1
WHERE emp_id = 100;

INSERT INTO employee VALUES(101, 'Jan', 'Levinson', '1961-05-11', 'F', 110000, 100, 1);

-- Scranton
INSERT INTO employee VALUES(102, 'Michael', 'Scott', '1964-03-15', 'M', 75000, 100, NULL);

INSERT INTO branch VALUES(2, 'Scranton', 102, '1992-04-06');

UPDATE employee
SET branch_id = 2
WHERE emp_id = 102;

INSERT INTO employee VALUES(103, 'Angela', 'Martin', '1971-06-25', 'F', 63000, 102, 2);
INSERT INTO employee VALUES(104, 'Kelly', 'Kapoor', '1980-02-05', 'F', 55000, 102, 2);
INSERT INTO employee VALUES(105, 'Stanley', 'Hudson', '1958-02-19', 'M', 69000, 102, 2);

-- Stamford
INSERT INTO employee VALUES(106, 'Josh', 'Porter', '1969-09-05', 'M', 78000, 100, NULL);

INSERT INTO branch VALUES(3, 'Stamford', 106, '1998-02-13');

UPDATE employee
SET branch_id = 3
WHERE emp_id = 106;

INSERT INTO employee VALUES(107, 'Andy', 'Bernard', '1973-07-22', 'M', 65000, 106, 3);
INSERT INTO employee VALUES(108, 'Jim', 'Halpert', '1978-10-01', 'M', 71000, 106, 3);


-- BRANCH SUPPLIER
INSERT INTO branch_supplier VALUES(2, 'Hammer Mill', 'Paper');
INSERT INTO branch_supplier VALUES(2, 'Uni-ball', 'Writing Utensils');
INSERT INTO branch_supplier VALUES(3, 'Patriot Paper', 'Paper');
INSERT INTO branch_supplier VALUES(2, 'J.T. Forms & Labels', 'Custom Forms');
INSERT INTO branch_supplier VALUES(3, 'Uni-ball', 'Writing Utensils');
INSERT INTO branch_supplier VALUES(3, 'Hammer Mill', 'Paper');
INSERT INTO branch_supplier VALUES(3, 'Stamford Lables', 'Custom Forms');

-- CLIENT
INSERT INTO client VALUES(400, 'Dunmore Highschool', 2);
INSERT INTO client VALUES(401, 'Lackawana Country', 2);
INSERT INTO client VALUES(402, 'FedEx', 3);
INSERT INTO client VALUES(403, 'John Daly Law, LLC', 3);
INSERT INTO client VALUES(404, 'Scranton Whitepages', 2);
INSERT INTO client VALUES(405, 'Times Newspaper', 3);
INSERT INTO client VALUES(406, 'FedEx', 2);

-- WORKS_WITH
INSERT INTO works_with VALUES(105, 400, 55000);
INSERT INTO works_with VALUES(102, 401, 267000);
INSERT INTO works_with VALUES(108, 402, 22500);
INSERT INTO works_with VALUES(107, 403, 5000);
INSERT INTO works_with VALUES(108, 403, 12000);
INSERT INTO works_with VALUES(105, 404, 33000);
INSERT INTO works_with VALUES(107, 405, 26000);
INSERT INTO works_with VALUES(102, 406, 15000);
INSERT INTO works_with VALUES(105, 406, 130000);

SELECT * FROM employee;
SELECT * FROM branch;
SELECT * FROM branch_supplier;
SELECT * FROM client;
SELECT * FROM works_with;

SELECT * FROM employee Inner JOIN works_with on employee.emp_id = works_with.emp_id SUM(works_with.total_sales);