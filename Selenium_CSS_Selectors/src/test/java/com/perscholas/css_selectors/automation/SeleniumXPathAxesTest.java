package com.perscholas.css_selectors.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumXPathAxesTest {
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
	public void xPathPreceding() {
		/* The "preceding" axes method locates all elements that come before
		 * the target element (@id='div2'), except for ancestors, attribute nodes
		 * and namespace nodes. It does not include the target element, but will
		 * include it's own children and grandchildren. */
		List<WebElement> elementList;
		StringBuilder sb = new StringBuilder();
		String tagSequence;

		elementList = driver.findElements(By.xpath("//div[@id='div2']//preceding::*"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("head meta title header h1 nav a a form input "
				+ "input div ul li li ul li li div p p div p p"));
		/* Notice that all four p tags are included which are children of the target
		 * element, but the target itself is not included. The <body> and <html> tags
		 * are also not included because they are ancestors to the target element */

		/* We can filter the search to return a specific type of tag by replacing the
		 * asterisk with a tag name. */
		sb.setLength(0);
		elementList = driver.findElements(By.xpath("//div[@id='div2']//preceding::li"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("li li li li"));
		/* We can also specify the position of a particular preceding element by
		 * counting from the target element and placing an integer argument in
		 * square brackets. The following statement will locate the second <li>
		 * element preceding from the target element (i.e., the third <li> element). */
		WebElement target = driver.findElement(By.xpath("//div[@id='div2']//"
				+ "preceding::li[2]"));
		assertThat(target.getText(), equalTo("div1 ul2 li1"));
	}
	@Test
	public void xPathFollowing() {
		/* The "following" axes method finds and selects all elements in the
		 * document that come after the target element (@id='div2'). It does not
		 * include itself. */
		List<WebElement> elementList;
		StringBuilder sb = new StringBuilder();
		String tagSequence;

		elementList = driver.findElements(By.xpath("//div[@id='div2']//following::*"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("div p p div p p footer p p a"));
		/* We can filter the search to only include a specific type of tag by
		 * replacing the asterisk with a tag name.*/
		sb.setLength(0); // This resets the StringBuilder object
		elementList = driver.findElements(By.xpath("//div[@id='div2']//following::p"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("p p p p p p"));
		/* We can specify a particular element by providing an integer to the tag
		 * name argument of the "following" method. */
		WebElement target = driver.findElement(By.xpath("//div[@id='div2']//following::p[5]"));
		assertThat(target.getText(), equalTo("Powered by Selenium & HTML"));
	}
	@Test
	public void xPathAncestor() {
		/* The "ancestor" axes method finds and selects the target element and all of
		 * it's ancestors ( parents and grandparents) along with children and
		 * grandchildren of the target element. */
		List<WebElement> elementList;
		StringBuilder sb = new StringBuilder();
		String tagSequence;

		elementList  = driver.findElements(By.xpath("//div[@id='div2']//ancestor::*"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("html body div div p p div p p"));
		/* As in previous examples, we can filter the search by specifying the type of
		 * tag we are looking for by replacing the asterisk with a tag name. */
		sb.setLength(0);
		elementList  = driver.findElements(By.xpath("//div[@id='div2']//ancestor::div"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("div div div"));
		/* Specifies the second ancestor removed (i.e. grandparent) from the target
		element of type "div". */
		sb.setLength(0);
		WebElement target = driver.findElement(By.xpath("//p[contains(@id, 'pId')]//ancestor::div[2]"));
		assertThat(target.getAttribute("id"), equalTo("div2"));
	}
	@Test
	public void xPathChild() {
		/* The "child" axes method will find and select all children and
		 * grandchildren beyond. This method will not return (i.e., select) the
		 * target element. */
		List<WebElement> elementList;
		StringBuilder sb = new StringBuilder();
		String tagSequence;
		elementList = driver.findElements(By.xpath("//div[@id='div2']//child::*"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("div p p div p p"));
		/* We can also specify what level of children and grand children we would like
		 * to locate by adding an integer argument to the axes method. The following
		 * lines of code will find and select the second child and second grandchild
		 * of the elements that follow the target element. Notice that even though it
		 * skips the first <div> child, it includes the second <p> child of that element
		 * (i.e., second grandchild). So we end up with the second <p> child of the
		 * first div element after the target (i.e., second grandchild of the target),
		 * the second <div> child of the target element and the second <p> child of
		 * the second <div> child (another second grandchild). */
		sb.setLength(0);
		elementList = driver.findElements(By.xpath("//div[@id='div2']//child::*[2]"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("p div p"));
		/* The following section specifies only <p> elements and so eliminates the
		 * div child located in the previous section. We end up with the second
		 * grandchild of each of the two <div> children. */
		sb.setLength(0);
		elementList = driver.findElements(By.xpath("//div[@id='div2']//child::p[2]"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("p p"));
	}
	@Test
	public void xPathParent() {
		/* The "parent" axes method without any type specified selects itself, it's
		 * children and the parent element. */
		List<WebElement> elementList;
		StringBuilder sb = new StringBuilder();
		String tagSequence;

		elementList = driver.findElements(By.xpath("//div[@id='div2']//parent::*"));
		for (WebElement we : elementList) {
			sb.append(we.getTagName() + " ");
		}
		tagSequence = sb.toString().trim();
		assertThat(tagSequence, equalTo("body div div p p div p p"));
		/* The parent is the first element found so if we chose to return a single
		 * element then only the parent is selected. */
		WebElement target = driver.findElement(By.xpath("//div[@id='div2']//parent::*"));
		assertThat(target.getTagName(), equalTo("body"));
		/* We can and should specify the type of parent tag since we can know the type
		 * by visual examination of the HTML document. */
		target = driver.findElement(By.xpath("//div[@id='div2']//parent::body"));
		assertThat(target.getTagName(), equalTo("body"));
        }
}
