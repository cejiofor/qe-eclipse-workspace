package com.platform.junit_intro.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SimpleClassTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SimpleClassTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Result==" + result.wasSuccessful());
	}
}