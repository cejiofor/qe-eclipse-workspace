package com.perscholas.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductTests.class, ShoppingCartTests.class, PaymentTests.class})
public class StoreTestSuite {

}
