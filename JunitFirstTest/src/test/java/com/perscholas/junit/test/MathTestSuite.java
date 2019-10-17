package com.perscholas.junit.test;

// 4. Test Suites: Create a test suite to run both of the test classes associated with item 2 and 3 above.

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasisMathTest.class, 
				AdvancedMathTest.class})

public class MathTestSuite {

}
