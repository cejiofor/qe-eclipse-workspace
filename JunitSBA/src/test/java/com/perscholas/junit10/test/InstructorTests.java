package com.perscholas.junit10.test;
import org.junit.Test;
import org.junit.experimental.categories.Category;

//Assign the category “Semester” to the following test methods:
//	School - addCourseTest(), registerStudentTest() and publishGradesTest()
//	Student - joinClubTest()
//	Instructor - submitFinalGradesTest() and adviseStudentTest()
//Assign the category "Weekly" to the following test methods:
//	School - createWeeklyReportTest()
//	Student - submitExamTest()
//	Instructor - gradeExamTest()
//Assign the category "Daily" to the following test methods:
//	School - takeAttendanceTest()
//	Student - submitAssignmentTest()
//	Instructor - gradeAssignmentTest()
//Create three test suites:
//	A test suite that will run all of the tests
//	A suite that will exclude the Daily tests
//	A suite that will run only the Weekly tests.

public class InstructorTests {
	@Category ({ DailyTest.class })
	@Test
	public void gradeAssignmentTest() {
		System.out.println("InstructorTests gradeAssignmentTest.");
	}
	@Category ({ WeeklyTest.class })
	@Test
	public void gradeExamTest() {
		System.out.println("InstructorTests gradeExamTest.");
	}
	@Category ({ SemesterTest.class })
	@Test
	public void submitFinalGradesTest() {
		System.out.println("InstructorTests submitFinalGradesTest.");
	}
	@Category ({ SemesterTest.class })
	@Test
	public void adviseStudentTest() {
		System.out.println("InstructorTests adviseStudentTest.");
	}
}
