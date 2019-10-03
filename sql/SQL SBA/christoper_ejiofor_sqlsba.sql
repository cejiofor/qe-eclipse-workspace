/**************************** STEP 3 *******************************************/
-- A. Add a column named EndDate of type Date and a column named Credits of type INT.
Alter TABLE StudentCourse add EndDate DATE;
Alter TABLE StudentCourse add Credits INT;

-- B. Add NOT NULL constraint to the column EndDate.
SELECT * FROM StudentCourse WHERE EndDate IS NULL;
UPDATE StudentCourse
SET EndDate = DATE_ADD(StartDate, INTERVAL 105 DAY)
WHERE EndDate IS NULL;

Alter TABLE StudentCourse 
CHANGE EndDate EndDate DATE NOT NULL;

-- C. Modify the name of the field EndDate to FinishDate.
ALTER TABLE StudentCourse CHANGE EndDate FinishDate DATE NOT NULL;

-- D. Write a query to remove the columns FinishDate and Credits from the StudentCourse table.
ALTER TABLE StudentCourse DROP COLUMN FinishDate;
ALTER TABLE StudentCourse DROP COLUMN Credits;


/**************************** STEP 4 *******************************************/

/* Question A:
	The Curriculum Planning Committee is attempting to fill in gaps in the current course
	offerings.
	You need to provide them with a query which lists each department and the
	number of courses offered by that department. 
	The two columns should have headers
	“Department Name” and “# Courses”, and the output should be sorted by “# Courses” in
	each department (ascending).
*/

Select department.name as `Department Name`, count(course.name) as `# Courses` 
	from department 
	join course 
	on course.deptid = department.id 
GROUP BY department.id 
ORDER BY count(course.name);

/* Question B
	The recruiting department needs to know which courses are most popular with the
	students. Please provide them with a query which lists the name of each course and the
	number of students in that course. The two columns should have headers “Course Name”
	and “# Students”, and the output should be sorted first by # Students descending and then
	by course name ascending.
*/

Select course.name as `Course Name`, count(course.id) as `# Students` 
	from studentcourse
	join course
	on course.id = studentcourse.courseId
Group by course.id 
Order by `# Students` DESC, `Course Name` ASC;
	
/* QUESTION C
	1. Write a query to list the names of all courses where the # of faculty assigned to
		those courses is zero. The output should be in alphabetical order by course name
		
	2. Using the above, write a query to list the course names and the # of students in
		those courses for all courses where there are no assigned faculty. The output should be
		ordered first by # of students descending and then by course name ascending.
*/
 
Select name 
from course c
Where c.id not in 
 (select courseId from facultycourse)
Order by name;

Select c.name as `Course Name`, count(sc.courseid) as `# Students` 
from course c
join studentcourse sc
on c.id = sc.courseId 
Where c.id not in 
 (select courseId from facultycourse)
Group by name
Order by `# Students` DESC, `Course Name` ASC;

/* Question D
	Write a query that lists the total # of students that were enrolled in classes during each school year.
	The first column should have the header “Students”. 
	Provide a second “Year” column showing the enrollment year. 
	Display the records sorted in ascending order based on startDate.
*/
Select count(firstname) as `Students`, Year(startdate) as `Year`
from student s
join studentcourse sc
on s.id = sc.studentId
group by `year`, IF(MONTH(startdate) = 8, 1, 2)
Order by startdate ASC;
	
/* Question E
	Write a query that lists the Start Date and # of Students who enrolled in classes in August of each year.
	Output should be ordered by start date ascending.
*/

Select startdate as `Start Date`, count(s.id) as `# Students`
from student s
join studentcourse sc
on s.id = sc.studentId
where month(startdate) = 8
group by year(startdate);

/* Question F
	Write a query to list students’ First Name, Last Name, and number of courses they are taking in their major department. 
	The output should be sorted first in increasing order of the number of courses, then by student last name. 
	Use aliases	“First Name”, “Last Name” and “Number of Courses”.
*/
Select firstname as `First Name`, lastname as `Last Name`, count(sc.courseId) as `Number of Courses`
From student s
join studentcourse sc
on s.id = sc.studentId
join course c
on c.id = sc.courseId
where s.majorId = c.deptId
group by s.id
order by count(sc.courseId), lastname;

/* Question G.
	Write a query to list First Name, Last Name and Average Progress of all students achieving average progress of less than 50%. 
	The average progress as	displayed should be rounded to one decimal place. 
	Sort the output by average progress	descending. 
	Use aliases “First Name”, “Last Name” and “Average Progress”.
*/
Select firstname as `First Name`, lastname as `Last Name`, Round(avg(progress),1) as `Average Progress`
from student s
join studentcourse sc
on s.id = sc.studentId
group by s.id
Having `Average Progress` < 50
order by `Average Progress` Desc;

/* Question H
	1. Write a query to list each course name and the average progress of students in that
		course. The output should be sorted descending by average progress. Use aliases
		“Course Name” and “Average Progress”.
*/ 
Select name as `Course Name`, avg(progress) as `Average Progress`
from studentcourse sc
join course c
on c.id = sc.courseId
group by c.id
order by `Average Progress` Desc;

/* Question H
	2. Write a query that selects the maximum value of the average progress reported by the
		previous query
*/ 
Select MAX(AVG_PROG)
from
	(Select name as `Course Name`, avg(progress) as AVG_PROG
	from studentcourse sc
	join course c
	on c.id = sc.courseId
	group by c.id) as ProgressTable;

/* Question H
	3. Write a query that outputs the faculty First Name, Last Name, and average of the
		progress made over all of their courses. Use aliases “First Name”, “Last Name” and
		“Avg. Progress”
*/ 
Select firstname as `First Name`, lastname as `Last Name`, avg(progress) as `Avg. Progress`
from faculty f
join facultycourse fc 
on f.id = fc.facultyId
join studentcourse sc
on fc.courseId = sc.courseId
group by f.id
order by `Avg. Progress`;

/* Question H
	4. Write a query just like #3, but where only those faculties where average progress in their
		courses is 90% or more of the maximum observed in #2.
		Display the records sorted in descending order based on “Average Progress”. 
*/ 
Select firstname as `First Name`, lastname as `Last Name`, avg(progress) as `Avg. Progress`
from faculty f
join facultycourse fc 
on f.id = fc.facultyId
join studentcourse sc
on fc.courseId = sc.courseId
group by f.id
Having `Avg. Progress` >= 69.7647*0.9
order by `Avg. Progress` DESC;


/* Question I
	The grading scale is as follows:
	Progress < 40: F, Progress < 50: D, Progress < 60: C, Progress < 70: B, Progress >= 70: A
	Write a query which displays each student’s “First Name”, “Last Name”, 
	minimum progress with “Min Grade” as alias, and maximum progress with alias “Max Grade”.
	Display the records sorted in ascending order based on “Average Progress”. 
*/
select firstname as `First Name`, lastname as `Last Name`,
Case
	When min(progress) < 40 Then "F"
	When min(progress) < 50 Then "D"
	When min(progress) < 60 Then "C"
	When min(progress) < 70 Then "B"
	When min(progress) >= 70 Then "A"
END AS `Min Grade`,
Case
	When max(progress) < 40 Then "F"
	When max(progress) < 50 Then "D"
	When max(progress) < 60 Then "C"
	When max(progress) < 70 Then "B"
	When max(progress) >= 70 Then "A"
END AS `Max Grade`
from student s
join studentcourse sc
on s.id = sc.studentId
group by s.id
order by AVG(progress);

/*Question J
	Write a query that returns student’s full name with “Student Name” as alias whose
	progress is greater than the average progress for their course and order by “Student
	Name”
*/
select concat(firstname," ",lastname) as `Student Name`
from student s
join studentcourse sc
on s.id = sc.studentId
join 
	-- Course Averge Table
	(Select c.id, avg(progress) as courseAvg
	from studentcourse sc
	join course c
	on c.id = sc.courseId
	group by c.id) as courseAvgTable
on sc.courseId = courseAvgTable.id
where progress > courseAvgTable.courseAvg
group by `Student Name`
order by `Student Name`