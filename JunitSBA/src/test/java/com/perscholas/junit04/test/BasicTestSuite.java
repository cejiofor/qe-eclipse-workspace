package com.perscholas.junit04.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.perscholas.junit01.test.StringTest;
import com.perscholas.junit02.test.OtherStringTest;
import com.perscholas.junit03.test.IntegerTest;

@RunWith(Suite.class)
@SuiteClasses({ StringTest.class, 
				OtherStringTest.class, 
				IntegerTest.class, })

public class BasicTestSuite {

}
