package com.perscholas.css_selectors.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumXPathTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/xPathOne");
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	@Test
	public void xPathAbsolutePathTest() {
		/* Using XPath to find an element at the basic level is similar to finding an
		 * element by CSS selector. The absolute path of the target element begins
		 * with "html/" and then proceeds through the document tree. The drawback to
		 * using an absolute path is that if any part of the path changes in the
		 * future then the XPath string will return an error when attempting to locate
		 * the target element. This isn't a huge problem on this web page, but it could
		 * be on web page with a large number of lines and elements. */
		 String actual = driver.findElement(By.xpath("html/body/header/h1")).getText();
		 assertThat(actual, equalTo("Selenium XPath Demonstration - Main Page"));
	}
	@Test
	public void xPathRelativePathTest() {
		/* This test uses a relative path to find the target element. The relative
		 * path begins with two forward slashes ("//") and can begin at any unique
		 * position in the document. In this case, our starting point is the second
		 * div element from the first "family" of div elements. Most XPath strings will
		 * utilize the relative path because it reduces the length and complexity of
		 * the string which makes it easier to deal with changes made to the HTML
		 * document. Here we also see examples of using integers in square brackets to
		 * specify the "child" of a "parent" tag. */
		String actual = driver.findElement(By.xpath("//*/div[2]/div[2]/p[2]")).getText();
		assertThat(actual, equalTo("div2 div2 p2"));
	}
	@Test
	public void xPathAttribute() {
		/* This test demonstrates how to use XPath to locate an element by the value
		 * of an attribute. In this case, the attribute is "title" and the value is
		 * "ul1li1". */
		String actual = driver.findElement(By.xpath("//*[@title='ul1li1']")).getText();
		assertThat(actual, equalTo("div1 ul1 li1"));
		/* We can also specify the type of tag that is being searched for as in the
		 * following example. */
		actual = driver.findElement(By.xpath("//li[@title='ul1li1']")).getText();
		assertThat(actual, equalTo("div1 ul1 li1"));
	}
	@Test
	public void xPathContainsStartsWith() {
		/* The first search in this method attempts to locate any element with an id that
		 * contains the string "pId". The <a> tag with id of "pId" includes a dynamic
		 * portion which changes with each page refresh so we can locate the element
		 * as long as there are no other <a> tags that include "pId" in the id string
		 * that come before the target on the document. */
		String actual = driver.findElement(By.xpath("//*[contains(@id,'pId')]")).getText();
		assertThat(actual, equalTo("div2 div1 p1"));
		/* This next search attempts to locate any <a> elements that contain 'cond'
		 * as part of the link text. It will match the link with "Second Page" as
		 * it's link text. */
		driver.findElement(By.xpath("//a[contains(text(), 'cond')]")).click();
		actual = driver.getTitle();
		assertThat(actual, equalTo("Selenium XPath Second Page"));
		/* This search will attempt to locate an <a> element that begins with the letter "M".
		 * It will match the <a> element with "Main Page" as it's link text. */
		driver.findElement(By.xpath("//a[starts-with(text(), 'M')]")).click();
		actual = driver.getTitle();
		assertThat(actual, equalTo("Selenium XPath Main Page"));
	}
	@Test
	public void xPathOr() {
		/* The "or" operator enables Selenium to locate any elements that meet
		 * either of the conditions specified inside the square brackets (either
		 * assigned "pClass2" or contains "li1" as part of it's title). In this case
		 * it will return two elements so the statement is set up to receive a list
		 * of WebElement type. */
		List<WebElement> elementList = driver.findElements(By.xpath(
				"//*[@class='pClass2' or contains(@title,'li1')]"));
		/* A list of String type is created so that we can test the list for the
		 * inclusion of specific strings using the "hasItems()" matcher. */
		List<String> elementText = new ArrayList<>();
		for (WebElement we : elementList) {
			elementText.add(we.getText());
		}
		/* We are expecting four elements so we will test for that here. */
		assertThat(elementList.size(), equalTo(4));
		/* Here we test for the expected text in each element. */
		assertThat(elementText, hasItems("div1 ul1 li1", "div1 ul2 li1",
				"div2 div1 p2", "div2 div2 p2"));
	}
	@Test
	public void xPathAnd() {
		/* The "and" operator requires that two conditions be true to select an
		 * element. In this example, the test is set up to search for any type of tag
		 * with class "pClass1" and that contains a "p" in it's ID. There are two tags
		 * assigned to pClass1 and two tags with "p" in their ID's, but only one
		 * element satisfies both conditions. */
		String actual = driver.findElement(By.xpath("//*[@class='pClass1' and "
				+ "contains(@id, 'p')]")).getText();
		assertThat(actual, equalTo("div2 div1 p1"));
	}
}
