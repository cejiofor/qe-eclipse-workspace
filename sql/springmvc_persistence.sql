DROP TABLE if EXISTS students;
CREATE TABLE students (
	student_id INT AUTO_INCREMENT,
	name VARCHAR(45),
	email VARCHAR(45),
	PRIMARY KEY (student_id)
	);
	
DROP TABLE IF EXISTS courses;
CREATE TABLE courses(
	course_id INT(11) AUTO_INCREMENT,
	code VARCHAR(45),
	name VARCHAR(45),
	max_size INT(11),
	PRIMARY KEY (course_id)
);

DROP TABLE IF EXISTS course_enrollments;
CREATE TABLE course_enrollments(
	course_enrollement_id INT(11),
	students_student_id INT(11),
	courses_course_id INT(11)
);