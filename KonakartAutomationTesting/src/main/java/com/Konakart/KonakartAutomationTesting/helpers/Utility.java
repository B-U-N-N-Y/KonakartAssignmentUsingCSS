package com.Konakart.KonakartAutomationTesting.helpers;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.Konakart.KonakartAutomationTesting.testbase.TestBase;

/**
 * This class contains all the methods which are required to do automation for a
 * web application
 * 
 * @author arjun.santra
 *
 */
public class Utility extends TestBase {
	public static WebElement element = null;

	public static void selectLocator(String locator) {

		String[] loc = locator.split(",", 2);

		switch (loc[0].toUpperCase()) {
		case "ID":
			element = driver.findElement(By.id(loc[1]));
			break;
		case "NAME":
			element = driver.findElement(By.name(loc[1]));
			break;
		case "CLASS":
			element = driver.findElement(By.className(loc[1]));
			break;
		case "LINKTEXT":
			element = driver.findElement(By.linkText(loc[1]));
			break;
		case "PARTIAL":
			element = driver.findElement(By.partialLinkText(loc[1]));
			break;
		case "CSS":
			element = driver.findElement(By.cssSelector(loc[1]));
			break;
		case "TAGNAME":
			element = driver.findElement(By.tagName(loc[1]));
			break;
		case "XPATH":
			element = driver.findElement(By.xpath(loc[1]));
			break;
		}

	}

	public static void clickElement(final String locator) {
		try {
			selectLocator(locator);

			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(30));
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element.click();
					return true;
				}
			});
		} catch (Exception exception) {
			System.out.println("Element is not clickable or not present");
			exception.printStackTrace();
		}
	}

	/**
	 * This method select any option from the drop down in a web application
	 * 
	 * @param locator
	 * @param text
	 */
	public static void selectDropdownByText(final String locator, final String text) {
		try {
			selectLocator(locator);
			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(30));
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					Select trip = new Select(element);
					trip.selectByVisibleText(text);
					return true;
				}

			});
		} catch (Exception exception) {
			System.out.println("Drop down functionality is not working");
			exception.printStackTrace();
		}
	}

	/**
	 * method click the blank fields and send the text to be entered
	 * 
	 * @param locator
	 * @param text
	 */
	public static void clickAndSendText(final String locator, final String text) {
		try {
			selectLocator(locator);
			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(30));

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element.sendKeys(text);
					;
					return true;
				}
			});
		} catch (Exception exception) {
			System.out.println("Send text is not working");
		}
	}

	/**
	 * 
	 * @param locator
	 * @return web element
	 */
	public static WebElement getElement(String locator) {
		try {
			selectLocator(locator);
			return element;
		} catch (Exception exception) {
			System.out.println("Element is not present");
			exception.printStackTrace();
		}
		return element;
	}

	/**
	 * method check that specific web element is displayed in the web application or
	 * not
	 * 
	 * 
	 * @param locator
	 * @return boolean value
	 */
	public static boolean isDisplayed(String locator) {
		selectLocator(locator);
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * method check that web element is selected or not
	 * 
	 * if it is selected this method return true otherwise return false
	 * 
	 * @param locator
	 * @return boolean value
	 */
	public static boolean isSelected(String locator) {
		selectLocator(locator);
		boolean isSelected = false;
		try {
			isSelected = element.isSelected();
		} catch (Exception e) {
			isSelected = false;
			e.printStackTrace();
		}
		return isSelected;
	}

	/**
	 * method scroll down the window on the web page
	 * 
	 * 
	 * @param horizontal index
	 * @param vertical   index
	 */

	public static void scrollDownPage(int horizontalIndex, int verticalIndex) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(" + horizontalIndex + "," + verticalIndex + ")";
		js.executeScript(scroll);
	}

	/**
	 * In this method,Input boxes entered texts are cleared
	 * 
	 * 
	 * @param locator
	 */
	public static void clearField(String locator) {
		try {
			selectLocator(locator);
			element.clear();
		} catch (Exception exception) {
			System.out.println("Clear field functionality is not working");
			exception.printStackTrace();
		}
	}

	/**
	 * Method gets the title of the current page
	 */
	public static String getTitle() {
		String title = null;
		try {
			title = driver.getTitle();

		} catch (Exception exception) {
			System.out.println("Title is not getting");
			exception.printStackTrace();
		}
		return title;
	}

	/**
	 * Method scrolls down the window resolution until the view of webelement is not
	 * found
	 * 
	 * 
	 * @param locator
	 */
	public static void scrollIntoview(String locator) {
		try {
			selectLocator(locator);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception exception) {
			System.out.println("scroll into view in not working");
			exception.printStackTrace();
		}
	}

	/**
	 * In this method, mouse over operation of the mouse is done
	 * 
	 * @param locator
	 */
	public static void actionMoveToElement(String locator) {
		try {
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			selectLocator(locator);
			if (browser.equals("firefox"))
				action.click(element).build().perform();
			else
				action.moveToElement(element).build().perform();
		} catch (Exception exception) {
			System.out.println("System interrupted");
			exception.printStackTrace();
		}
	}

	/**
	 * method select the dropdown and select the Element by index, using the fluent
	 * wait concepts ignoring the ElementClickInterceptedException.
	 * 
	 * @param locator
	 * @param index
	 */
	public static void selectDropdownByIndex(final String locator, final int index) {
		try {
			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(30));
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					selectLocator(locator);
					Select trip = new Select(element);

					trip.selectByIndex(index);
					return true;
				}

			});

		} catch (Exception exception) {
			System.out.println("Drop down by index not working");
			exception.printStackTrace();
		}
	}

	/**
	 * Method sets the attribute value of the web element
	 * 
	 * @param locator
	 * @param xOffset
	 */
	public static void setAttributeValue(String locator, int xOffset) {
		try {
			selectLocator(locator);
			Actions move = new Actions(driver);
			move.clickAndHold(element).dragAndDropBy(element, xOffset, 0).build().perform();

		} catch (Exception exception) {

			System.out.println("slider bar is not working");
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * @param locators
	 * @return the list of elements
	 */

	public static List<WebElement> getElementsList(final String locators) {
		String[] loc = locators.split(",");
		List<WebElement> element;
		if ((loc[0].toUpperCase()).equalsIgnoreCase("CSS")) {
			element = driver.findElements(By.cssSelector(loc[1]));
		} else {
			element = driver.findElements(By.xpath(loc[1]));
		}

		return element;
	}
}
