package com.perscholas.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.perscholas.devclub.dao.MariaDBConnection;

public class LoginAutomationTest {
	private static WebDriver driver;
	private static Boolean mariaDB;
	@BeforeClass
	public static void setUp() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("http://localhost:8080/SoftwareDeveloperClubExercise/LoginPage.jsp");
		driver.get("http://localhost:8080/InsuranceProject/HomeServlet");
		
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			mariadbConnection.getConnection();
			mariaDB = true;
			System.out.println("Connected to MariaDB!");
		}
		catch(Exception e) {
			mariaDB = false;
			System.out.println("Database connection failed.");
		}
	}
	
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	
	@Test 
	public void validLoginTest(){
		assumeTrue(mariaDB);
		WebElement userInput = driver.findElement(By.name("userEmail"));
		WebElement passwordInput = driver.findElement(By.name("userPassword"));
		assertEquals(driver.getTitle(), "Login Page");
	}
	

}
