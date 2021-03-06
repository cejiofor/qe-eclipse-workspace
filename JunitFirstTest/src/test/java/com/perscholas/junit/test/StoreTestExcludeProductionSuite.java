package com.perscholas.junit.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory({ProductionEnv.class})
@Suite.SuiteClasses({ProductTests.class, ShoppingCartTests.class, PaymentTests.class})
public class StoreTestExcludeProductionSuite {

}
