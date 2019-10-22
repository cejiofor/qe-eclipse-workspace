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

public class SchoolTests {
	@Category ({ SemesterTest.class })
	@Test
	public void addCourseTest() {
		System.out.println("SchoolTests addCourseTest.");
	}
	@Category ({ SemesterTest.class })
	@Test
	public void registerStudentTest() {
		System.out.println("School Tests registerStudentTest.");
	}
	@Category ({ WeeklyTest.class })
	@Test
	public void createWeeklyReportTest() {
		System.out.println("School Tests createWeeklyReportTest.");
	}
	@Category ({ DailyTest.class })
	@Test
	public void takeAttendanceTest() {
		System.out.println("School Tests takeAttendanceTest.");
	}
	@Category ({ SemesterTest.class })
	@Test
	public void publishGradesTest() {
		
	}
}