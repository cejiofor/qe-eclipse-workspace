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

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
	user_id INT AUTO_INCREMENT,
	username VARCHAR(100),
	password VARCHAR(100),
	PRIMARY KEY (user_id)
);

INSERT INTO users VALUES (1, 'monkey', 'monkey123');
INSERT INTO users VALUES (2, 'letters', 'abcd123');
INSERT INTO users VALUES (3, 'numbers', '123456');
INSERT INTO users VALUES (4, 'barrack', 'obama');

SELECT * FROM users;