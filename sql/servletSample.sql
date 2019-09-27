DROP TABLE IF EXISTS Students;
CREATE TABLE Students (
	student_id INT AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	course_selected VARCHAR(100),
	PRIMARY KEY (student_id)
);

INSERT INTO students VALUES (1, 'Jack', 'jack@school.com', 'Biology');
INSERT INTO students VALUES (2, 'Kate', 'kate@school.com', 'Sociology');
INSERT INTO students VALUES (3, 'Mariah', 'mariah@school.com', 'Sociology');
INSERT INTO students VALUES (4, 'Jack', 'jacke@school.com', 'Biology');
INSERT INTO students VALUES (5, 'John', 'john@school.com', 'Computer Science');

SELECT * FROM Students;