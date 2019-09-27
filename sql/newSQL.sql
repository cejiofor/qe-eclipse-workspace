DROP TABLE IF EXISTS students;
CREATE TABLE students (
	student_id INT AUTO_INCREMENT,
	name VARCHAR(100) NOT null,
	score INT not null,
	PRIMARY KEY(student_id)
	); 
	
INSERT INTO students(name, score) VALUES('Billy', 95);
INSERT INTO students(name, score) VALUES('Jack', 75);
INSERT INTO students(name, score) VALUES('Sarah', 98);
INSERT INTO students(name, score) VALUES('Mimi', 86);
INSERT INTO students(name, score) VALUES('Adrian', 95);
INSERT INTO students(name, score) VALUES('Mariah', 83);
INSERT INTO students(name, score) VALUES('Eric', 65);
INSERT INTO students(name, score) VALUES('Chris', 96);
INSERT INTO students(name, score) VALUES('Ryan', 76);
INSERT INTO students(name, score) VALUES('Mavin', 58);

SELECT * FROM students;

SELECT name,score, -- columns to return after case is run
CASE 
	WHEN score >=90 and score <= 100 THEN "A"
	WHEN score >=80 and score <= 89 THEN "B"
	WHEN score >=70 and score <= 79 THEN "C"
ELSE "Failed, less than a c"
END AS grade -- end of the functions, followed by alias -> the column name for the output, defaults to Case 
FROM students;

SELECT name,score,
CASE 
	WHEN score >=90 and score <= 100 THEN "A"
	WHEN score >=80 THEN "B"
	WHEN score >=70 THEN "C"
ELSE "Failed, less than a c"
END AS grade
FROM students;

-- ASSGINMENT
-- Work on Join for tables
-- For next week, hands on in class, will move quikly to practice

-- Aggregare functions in SQL
-- ex sum, average, min, max
