CREATE TABLE student (
  student_id INT PRIMARY KEY,
  name VARCHAR(20),
  major VARCHAR(20)
--   PRIMARY KEY(student_id)
-- Another way to set the primary key, instead of doiong it as above
);

DESCRIBE student;

-- DROP TABLE student;

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

drop table student;

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

DROP TABLE student;

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
DELETE FROM student
WHERE student_id = 5;

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

DROP TABLE student;

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
REFERENCES employee(emp_id) -- reference 
ON DELETE SET NULL;

select * from employee;

ALTER TABLE employee
ADD FOREIGN KEY (super_id)
REFERENCES employee(emp_id)
ON DELETE SET NULL;

