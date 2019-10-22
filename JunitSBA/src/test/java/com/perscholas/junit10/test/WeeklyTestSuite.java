package com.perscholas.junit10.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({WeeklyTest.class})
@Suite.SuiteClasses({StudentTests.class, InstructorTests.class, SchoolTests.class})

public class WeeklyTestSuite {

}
