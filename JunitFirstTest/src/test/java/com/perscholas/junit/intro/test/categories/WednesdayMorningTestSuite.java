package com.perscholas.junit.intro.test.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({WednesdayMorningTests.class})
@Suite.SuiteClasses({CoffeeTests.class, EspressoTests.class, CappuccinoTests.class})

public class WednesdayMorningTestSuite {

}
