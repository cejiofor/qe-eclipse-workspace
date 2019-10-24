package com.perscholas.junitkba.test;


import org.junit.BeforeClass;

import org.junit.Test;

public class Sample1 {

@BeforeClass

public void beforeClass(){

System.out.println("before class"); }

@Test

public void test1(){

System.out.println("test1"); }

}