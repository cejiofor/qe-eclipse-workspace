package com.perscholas.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.percholas.test.SimpleClass;

public class SimpleClassTestPt2 {
	private static SimpleClass simpleClass;

	@BeforeClass
	public static void createSimpleClass() {
		simpleClass = new SimpleClass();
	}

	@Test
	public void compareTwoObjectsTest() {
		Object obj1 = new Object();
		Object obj2 = new Object();

		assertNotSame(obj1,obj2);

		/* obj3 acquires the same memory address as obj1, so obj1 & obj3 point to
		 * the same Object.
		 */
		Object obj3 = obj1;
		assertSame(obj1, obj3);
	}

	// simpleClass.returnList() returns the list ["red", "green", "blue"]
	@Test
	public void listContainsRedBlueTest() {
		assertThat(simpleClass.returnList(), hasItems("red", "blue"));
	}

	@Test
	public void listItemsContainETest() {
		assertThat(simpleClass.returnList(), everyItem(containsString("e")));
	}

}

