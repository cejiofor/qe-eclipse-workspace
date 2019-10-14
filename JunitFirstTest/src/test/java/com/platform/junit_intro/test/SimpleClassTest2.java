package com.platform.junit_intro.test;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.core.StringStartsWith.startsWith;

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.number.IsCloseTo.closeTo;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;

import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

import static org.hamcrest.object.HasToString.hasToString;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

import com.platform.junit_into.SimpleClass;

public class SimpleClassTest2{
	private static SimpleClass simpleClass;
	
	@BeforeClass
	public static void createSimpleClass() {
		simpleClass = new SimpleClass();
	}
	
	// ***********************************************************************************
	// ***********************************************************************************
	// Core Matchers - fundamental matchers of objects and values, and composite matchers

	@Test
	public void coreTest() {
		assertThat(simpleClass.returnList().get(0), is("red"));
		assertThat(simpleClass.returnList().get(1), not("red"));
		// Examples of the various ways to test logic
		// Only 1 matcher must return true
		assertThat(simpleClass.returnList().get(2), anyOf(equalTo("blue"),containsString("Hello"),
				is("orange"), startsWith("y")));
		// Here all matchers must return true
		assertThat(simpleClass.returnList().get(1), allOf(not("red"),containsString("green"),
				not(startsWith("b")), startsWith("g")));
	}
	
	@Test
	public void returnObjectsTest() {
		Object obj1 = simpleClass.returnNotNull();
		Object obj2 = obj1;
		// Objects obj1 and obj2 are the same instance
		assertThat(obj1, sameInstance(obj2) );
		
		obj2 = new Object(); // Now obj2 is a different instance
		assertThat(obj1, not(sameInstance(obj2)));
		
		// Tests for null
		assertThat(simpleClass.returnNull(), nullValue());
		assertThat(simpleClass.returnNotNull(), notNullValue());
		
		String s1 = "Hello";
		String s2 = new String("Hello");
		// s1 & s2 are not the same instance
		assertThat(s1, not(sameInstance(s2)));

		// However, s1 & s2 values/content are equivalent
		assertThat(s1, equalTo(s2));
	}

	// ***********************************************************************************
	// ***********************************************************************************
	// Object Matchers - inspect objects and classes
	
	@Test
	public void toStringTest() {
		assertThat(simpleClass, 
				hasToString(equalTo("This is the custom toString ouput for SimpleClass.")));
	}
	
	// ***********************************************************************************
	// ***********************************************************************************
	// Bean Matchers - matchers of JavaBeans properties and their values
	
	@Test
	public void beanPropertiesTest() {
		/* Be sure the class SimpleObject is in your project. If not, 
		 * you may create the class with name, city and home_state
		 * attributes/properties and place it in your project. */
		
		SimpleObject obj1 = new SimpleObject();
		/* The hasProperty matcher is overloaded to accept a string only
		 * or a string with a specified value. However, two separate imports 
		 * are required: HasProperties.hasProperty & 
		 * HasPropertiesWithValue.hasProperty & */
		
		// org.hamcrest.beans.HasProperty.hasProperty;
		assertThat(obj1, hasProperty("name"));
		obj1.setName("John");
		// org.hamcrest.beans.HasPropertyWithValue.hasProperty;
		assertThat(obj1, hasProperty("name", equalTo("John")));
	}
	
	// ***********************************************************************************
	// ***********************************************************************************
	// Number Matchers - matchers that perform numeric comparisons
	
	@Test
	public void orderingComparisonTest() {
		// Test for range of values
		assertThat(simpleClass.returnOne(), both(greaterThan(0)).and(lessThan(10)));
		// Test for a specific value
		assertThat(simpleClass.returnOne(), is(1));
		/* Here we cast the integer 1 to a double and use the closeTo matcher
		 * to test it's proximity to 1.3 using a error margin of .5.*/
		assertThat((double)simpleClass.returnOne(), is(closeTo(1.3, .5)) );
	}
	
	// ***********************************************************************************	
	// ***********************************************************************************
	// Collection Matchers - matchers of arrays and collections
	
	@Test
	public void collectionMatchersTest() {
		List<String> colors = simpleClass.returnList();
		Map<String, String> officers = simpleClass.returnHashMap();
		// allOf test
		assertThat(colors, allOf(hasItems("red","blue"), not(hasItems("orange"))));
		// anyOf test
		assertThat(colors, anyOf(hasItems("red", "blue"), hasItems("yellow", "cyan")));
		// both test
		assertThat(colors, both(hasItems("red")).and(hasItems("green")));
		// everyItem test
		assertThat( colors, everyItem( is(not("orange")) ) );
		// Map hasEntry test
		assertThat(officers, hasEntry("president", "Jane"));
		// Map hasKey test
		assertThat(officers, hasKey("treasurer"));
		// Map hasValue test
		assertThat(officers, hasValue("James"));
	}
	
	// ***********************************************************************************	
	// ***********************************************************************************
	// Text Matchers - matchers that perform text comparisons
	
	@Test
	public void testMatcherTest() {
		String str1 = "It's a great day!";
		String str2 = "it's a great day!";
		String str3 = "   It's a great day!     ";
		String str4 = "";
		String str5 = null;
		// Test for equality while ignoring case
		assertThat(str1, equalToIgnoringCase(str2));
		// Test for equality while ignoring LEADING and TRAILING white space
		assertThat(str1, equalToCompressingWhiteSpace(str3));
		// Starts or ends with, or contains
		assertThat(str1, startsWith("It's"));
		assertThat(str1, endsWith("ay!"));
		assertThat(str1, containsString("a grea"));
		// Test for empty string
		assertThat(str4, emptyString());
		// Test for null
		assertThat(str5, emptyOrNullString());
	}
}