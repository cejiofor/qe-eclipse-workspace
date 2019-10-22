package com.perscholas.junit06.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit06.User;

//Write a parameterized test to test the constraints and calculateCredits method of the User class.

@RunWith(Parameterized.class)
public class UserTest{
	private static User user;
	private Integer userId;
	private String name;
	private String password;
	private Double javaScore;
	private Double sqlScore;
	private Integer expectedCredits;
	private Boolean confirmation;
	
	public UserTest(Integer userId, String name, String password, Double javaScore, 
			Double sqlScore, Integer expectedCredits, Boolean confirmation) {
		this.userId = userId;
		this.name= name;
		this.password = password;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
		this.expectedCredits = expectedCredits;
		this.confirmation = confirmation;
	}
	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ 1, "John", "password", 69.0, 69.0, 0, null},
                		{ 2, "Jacob", "password", 70.0, 69.0, 1, null},
                		{ 3, "Jingle", "password", 69.0, 70.0, 1, null},
                		{ 4, "Himmer", "password", 70.0, 70.0, 2, null }
                		});
    }
	
	
	@Test
	public void calculateCredits() {
		user = new User(userId, name, password, javaScore, sqlScore);
		Integer credits = user.calculateCredits();
		if (credits == expectedCredits) {
    		confirmation = true;
        	assertThat(credits, equalTo(expectedCredits));
    	} else {
    		confirmation = false;
        	assertThat(credits, not(equalTo(expectedCredits)));
    	}
	}
	
	

}
