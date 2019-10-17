package com.perscholas.junit.test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category ({ TestEnv.class })
public class PaymentTests {
	
	@Category ({ ProductionEnv.class })
	@Test
	public void verifyPaymentTest() {
		System.out.println("Printed from the verifyPaymentTest method");
	}
	@Test
	public void submitPaymentTest() {
		System.out.println("Printed from the submitPaymentTest method");
	}
	
	@Test
	public void confirmPaymentTest() {
		System.out.println("Printed from the confirmPaymentTest method");
	}

}
