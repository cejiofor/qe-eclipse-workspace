package com.perscholas.junit10.test;

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


import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StudentTests {
	@Category ({ DailyTest.class })
	@Test
	public void submitAssignmentTest() {
		System.out.println("StudentTests submitAssignmentTest.");
	}
	@Category ({ WeeklyTest.class })
	@Test
	public void submitExamTest() {
		System.out.println("StudentTests submitExamTest.");
	}
	
	@Category ({ SemesterTest.class })
	@Test
	public void joinClubTest() {
		System.out.println("StudentTests joinClubTest.");
	}
}