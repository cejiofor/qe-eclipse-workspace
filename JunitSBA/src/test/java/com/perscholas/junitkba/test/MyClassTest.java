package com.perscholas.junitkba.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyClassTest{

@Test

public void checkString(){

String message="Hello";

assertEquals(3, message.length());

}

}