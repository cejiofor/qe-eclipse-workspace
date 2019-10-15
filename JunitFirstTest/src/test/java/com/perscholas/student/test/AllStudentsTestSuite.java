package com.perscholas.student.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ StudentTest.class, 
				ASMStudentAssistantTest.class, 
				QEAStudentAssistantTest.class })

public class AllStudentsTestSuite {
	
}