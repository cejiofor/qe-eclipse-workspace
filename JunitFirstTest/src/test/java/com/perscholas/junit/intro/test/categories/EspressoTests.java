package com.perscholas.junit.intro.test.categories;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ MondayMorningTests.class, WednesdayMorningTests.class})
public class EspressoTests {
	@Test
	public void espressoTest1() {
		Boolean stayAwake = true;
		assertThat(stayAwake, equalTo(true));
	}

}
