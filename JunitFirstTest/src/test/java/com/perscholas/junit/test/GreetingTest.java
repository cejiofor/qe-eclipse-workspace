package com.perscholas.junit.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.perscholas.junit.Greeting;

public class GreetingTest extends Mockito {
	private static Greeting mockGreeting;
	public GreetingTest() {
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public static void setUp() {
		mockGreeting = Mockito.mock(Greeting.class);
	}
	
	@Test
	public void selectLangTest()
	{
//		Mockito.when(mockGreeting.selectLanguage(1).thenCallRealMethod())
//		when(listMock.size()).thenCallRealMethod(); 
		assertThat(mockGreeting.selectLanguage(1), is("English"));
	}
}
