package com.perscholas.css_selectors.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHiddenElementsTest {
	private static WebDriver driver;
        private static Actions actions;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/hiddenElements");
		actions = new Actions(driver);
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	@Test(expected = AssertionError.class)
	public void findDisplayNoneElement() {
		/* style="display:none; - The element is included in the DOM and is found by 
		 * Selenium, but it is removed from the page layout. The WebElement "getText()" 
		 * method returns an empty string. Attributes are retrievable through the 
		 * WebDriver "getAttribute()" method, including text through the attributes 
		 * "innerHTML" and "outerHTML". However, "innerHTML" and "outerHTML" will not 
		 * ignore hidden characters such as "\n" or "\t" in cases where the tag text 
		 * has been written across two or more lines as is the case in this example (refer to 
		 * the file "SeleniumHiddenElements.jsp" to examine the layout of the HTML 
		 * code). The attribute "outerHTML" returns the entire tag string. */
		WebElement displayNone = driver.findElement(By.id("displayNone"));
		/* The following line will return "\n\t\tDisplay None Span". This assertion 
		will succeed. */
		String innerHtml = displayNone.getAttribute("innerHTML");
		assertThat(innerHtml, equalTo("\n\t\tDisplay None Span"));
		/* The following line will return "<span id="displayNone" 
		 * style="display:none;">\n\t\tDisplay None Span</span>". This assertion will 
		 * also succeed. */
		String outerHtml = displayNone.getAttribute("outerHTML");
		assertThat(outerHtml, equalTo("<span id=\"displayNone\" "
				+ "style=\"display:none;\">\n\t\tDisplay None Span</span>"));
		/* The following line will return an empty string so the test will throw an 
		 * AssertionError which is expected so the test will pass. */
		String actual = displayNone.getText();
		assertThat(actual, equalTo("Display None Span"));
		/* The "innerHTML" and "outerHTML" attributes can be unreliable because the 
		 * strings returned depend on the layout of the HTML code in the HTML file. 
		 * Caution should be used whenever utilizing the getAttribute() methods with 
		 * these attributes. */ 
	}
	@Test(expected = AssertionError.class)
	public void findVisibilityHiddenElement() {
		/* style="visibility:hidden; - The element is included in the DOM and is 
		 * found by Selenium, and it remains in the page layout (i.e., takes up space). 
		 * However, it is invisible to the user. The getText() method returns an 
		 * empty string. The getAttribute() method works the same as for "display: none;" 
		 * as explained above. */
		WebElement visibilityHidden = driver.findElement(By.id("visibilityHidden"));
		String actual = visibilityHidden.getText();
		assertThat(actual, equalTo("Visibility Hidden"));
	}
	@Test(expected = NoSuchElementException.class)
	public void findIfStatementElement() {
		/* <c:if test="${false}"> - The element is not created in the DOM because the 
		 * "if" condition is not met. */
		driver.findElement(By.id("ifStatement"));
	}
	/* The first test for the drop-down menu includes an attempt to get the text of an 
	 * element that is hidden and so it throws an AssertionError which is expected 
	 * so the test passes. */
	@Test(expected = AssertionError.class)
	public void findDropDownSelectionHidden() {
		WebElement dropDown = driver.findElement(By.cssSelector("#dropdown > div > a:nth-child(2)"));
		String actual = dropDown.getText();
		assertThat(actual, equalTo("Platform by Per Scholas"));
	}
	/* The following test is identical to the previous one, but uses the Actions 
	 * class to move the cursor over the "Drop-Down Menu" button. This exposes the 
	 * select options and allows Selenium to retrieve the text from the second menu 
	 * option. This test passes. */
	@Test
	public void findDropDownSelectionVisible() {
		WebElement dropDownMenu = driver.findElement(By.cssSelector("#dropdown > button"));
		actions.moveToElement(dropDownMenu).perform();
		WebElement dropDownSelect = driver.findElement(By.cssSelector("#dropdown > div > a:nth-child(2)"));
		String actual = dropDownSelect.getText();
		assertThat(actual, equalTo("Platform by Per Scholas"));
	}
}