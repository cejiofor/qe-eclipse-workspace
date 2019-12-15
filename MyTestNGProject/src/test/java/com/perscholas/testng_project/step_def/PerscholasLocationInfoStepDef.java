package com.perscholas.testng_project.step_def;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PerscholasLocationInfoStepDef {
	private static WebDriver driver;
	private String actual;
	private String expected;
	
	@Given("^the user navigates to the Per Scholas website$")
	public void the_user_navigates_to_the_Per_Scholas_website() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Charlie\\Documents\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.get("https://perscholas.org");
	    driver.manage().window().maximize();
	    actual = driver.getTitle();
	    expected = "Per Scholas";
	    assertEquals(actual, expected);
	}

	@Given("^selects a location$")
	public void selects_a_location() throws Throwable {
	    System.out.println("Given");
	}

	@When("^the user clicks on the About link$")
	public void the_user_clicks_on_the_About_link() throws Throwable {
	    System.out.println("When");
	}

	@Then("^the user is directed to a page with location-specific information$")
	public void the_user_is_directed_to_a_page_with_location_specific_information() throws Throwable {
	    System.out.println("Then");
	    driver.quit();
	}
}
