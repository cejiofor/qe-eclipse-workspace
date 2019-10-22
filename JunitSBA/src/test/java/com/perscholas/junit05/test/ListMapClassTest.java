package com.perscholas.junit05.test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.junit05.ListMapClass;
import com.perscholas.junit05.User;

//Test the ListMapClass using Hamcrest matchers. Run at least 3 assert methods for each ListMapClass method. At least one of the assert methods for the User list and map should test for the contents of a User object and you should demonstrate the use of at least 3 String matchers.

public class ListMapClassTest {
	static ListMapClass lmc;
	
	@BeforeClass
	public static void setUp() {
		lmc = new ListMapClass();
	}
	
	@Test
	public void citiesTest() {
		List<String> cityList = lmc.cities();
		assertThat(cityList,hasItems("Dallas","Irving"));
		assertThat(cityList,allOf(hasItems("Boston","New York"), not(hasItems("San Francisco"))));
		assertThat(cityList.get(4), endsWith("phia"));
	}
	
	@Test
	public void getUserListTest() {
		List<User> userList = lmc.getUserList();
		User user = userList.get(0);
		assertEquals(3,userList.size());
		assertThat(userList.get(1).getName(), containsString("Jane"));
		assertThat(userList,hasItem(user));	
	}
	
	@Test
	public void getCourseMapTest() {
		Map<String, String> courses = lmc.getCoursesMap();
		assertThat(courses, hasEntry("ASM", "Application Support Management"));
		assertThat(courses, hasKey("QEA"));
		assertThat(courses, hasValue("Java Developer"));
	}
	
	@Test
	public void getUserMapTest() {
		Map<Integer, User> userMap = lmc.getUserMap();
		assertThat(userMap, hasKey(11));
		assertThat(userMap.get(11).getJavaScore(), is(Matchers.greaterThan(85.0)));
		assertEquals(userMap.get(10).getClass().toString(), "class com.perscholas.junit05.User");
		assertThat(userMap.get(12).getName(),startsWith("Jac"));
	}

}
