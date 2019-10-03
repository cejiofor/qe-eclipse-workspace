create table department(
	id int NOT NULL PRIMARY KEY,
    name varchar(30) NOT NULL
);

create table faculty(
	id int NOT NULL PRIMARY KEY,
    firstname varchar(30) NOT NULL,
    lastname varchar(50) NOT NULL,
    deptId int NOT NULL,
    CONSTRAINT faculty_dept_fk FOREIGN KEY(deptId) REFERENCES department(id)
);

create table student(
	id int NOT NULL PRIMARY KEY,
    firstname varchar(30) NOT NULL,
    lastname varchar(50) NOT NULL,
    street varchar(50) NOT NULL,
    streetDetail varchar(30),
    city varchar(30) NOT NULL,
    state varchar(30) NOT NULL,
    postalCode char(5) NOT NULL,
    majorId int NOT NULL,
    CONSTRAINT student_dept_fk FOREIGN KEY(majorId) REFERENCES department(id)
);

create table course(
	id int NOT NULL PRIMARY KEY,
    name varchar(50) NOT NULL,
    deptId int NOT NULL,
    CONSTRAINT course_dept_fk FOREIGN KEY(deptId) REFERENCES department(id)
);

create table studentCourse(
	studentId int NOT NULL,
    courseId int NOT NULL,
    progress int DEFAULT 0,
    startdate date NOT NULL,
    CONSTRAINT sc_pk PRIMARY KEY(studentId, courseId),
    CONSTRAINT sc_student_fk FOREIGN KEY(studentId) REFERENCES student(id),
    CONSTRAINT sc_course_fk FOREIGN KEY(courseId) REFERENCES course(id)
);

create table facultyCourse(
    facultyId int NOT NULL,
	courseId int NOT NULL,
    CONSTRAINT fc_pk PRIMARY KEY(facultyId, courseId),
    CONSTRAINT fc_faculty_fk FOREIGN KEY(facultyId) REFERENCES faculty(id),
    CONSTRAINT fc_course_fk FOREIGN KEY(courseId) REFERENCES course(id)
);
