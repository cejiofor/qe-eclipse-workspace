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

public class SeleniumCSSTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet");
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	@Test
	public void findByCssBasic() {
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet");
		// The following example will use the full CSS path.
		WebElement pLink = driver.findElement(By.cssSelector("html > body > div > p > a"));
		String actual = pLink.getText();
		assertThat(actual, equalTo("p Link"));
		/* The following example will use the partial CSS path that is sufficient
		 * because it provides a unique path to the target element. In other words,
		 * there are no other elements which fit this pattern so Selenium is able to
		 * isolate the target element. */
		pLink = driver.findElement(By.cssSelector("div > p > a"));
		assertThat(actual, equalTo("p Link"));
	}
	@Test
	public void findCssSiblings() {
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/showPage2");
		/* The "SeleniumChildren.jsp" page includes several examples of siblings.
		 * This test will demonstrate specifying sibling positioning to find a target
		 * element. There are two sets of unordered lists <ul> and two sets of <p>
		 * elements. In the first test we will locate the second child of the second
		 * unordered list. Notice that the <div> specifies "nth-child(2)" even though
		 * it is the first <div> below it's parent. This is because even though it is the
		 * first <div>, it is the second child of the parent element <body>. The <header>
		 * element is the first child. */
		WebElement ul2 = driver.findElement(By.cssSelector(
				"html > body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2)"));
		String actual = ul2.getText();
		assertThat(actual, equalTo("div1 ul2 li2"));
		/* In the next example, there is no child specification for the <div> element
		 * and yet Selenium will locate the correct <div>. This is because Selenium will
		 * find the first child of <div> type if no child is specified. */
		ul2 = driver.findElement(By.cssSelector(
				"html > body > div > ul:nth-child(2) > li:nth-child(2)"));
		actual = ul2.getText();
		assertThat(actual, equalTo("div1 ul2 li2"));
		// The following CSS pattern will also work
		ul2 = driver.findElement(By.cssSelector(
				"div > ul:nth-child(2) > li:nth-child(2)"));
		actual = ul2.getText();
		assertThat(actual, equalTo("div1 ul2 li2"));
	}
	@Test
	public void findCssSiblingsUsingId() {
		/* In this example, the origin of the CSS pattern is an element with an "id"
		 * attribute ("#div2"). A CSS pattern can begin at any location that Selenium
		 * can locate without any ambiguity and locating the attribute "id" allows it to
		 * do that. */
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/showPage2");
		WebElement ul2 = driver.findElement(By.cssSelector("#div2 > div:nth-child(2) > "
				+ "p:nth-child(2)"));
		String actual = ul2.getText();
		assertThat(actual, equalTo("div2 div2 p2"));
	}
	@Test
	public void findCssUsingClassCombinations() {
		/* Finding an element through class combinations involves specifying the
		 * element type and adding the class combination as a parameter. */
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/showPage2");
		WebElement p1 = driver.findElement(By.cssSelector(".pClass1.pClass2"));
		String actual = p1.getText();
		assertThat(actual, equalTo("div2 div2 p1"));
	}
	@Test
	public void findCssListByClass() {
		/* This example demonstrates using Selenium to locate a list of
		 * elements by class. In this case we are searching for the class
		 * "pClass1". */
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/showPage2");
		List<WebElement> byClass = driver.findElements(By.className("pClass1"));
		/* We need a list of strings so we can test the text content for each
		 * WebElement. */
		List<String> elementText = new ArrayList<>();
		for (WebElement we : byClass) {
			elementText.add(we.getText());
		}
		assertThat(byClass.size(), equalTo(2));
		assertThat(elementText, hasItems("div2 div1 p1","div2 div2 p1"));
	}
}
