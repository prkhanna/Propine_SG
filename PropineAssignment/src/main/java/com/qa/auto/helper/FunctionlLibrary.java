package com.qa.auto.helper;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Generic Function Class
 * @author Prince Khanna
 *
 */
public class FunctionlLibrary {

	WebDriver driver;

	public FunctionlLibrary(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Generic method for element click
	 * 
	 * @param element
	 */
	public void elementClick(WebElement element) {
		try {
			if (isElementPresent(element)) {
				waitElementToBeClickable(element);
				element.click();
			}
		} catch (Exception e) {
			fail("The element is not found");
		}
	}

	/**
	 * To check whether an element is present or not
	 * 
	 * @param element
	 * @return
	 */
	public boolean isElementPresent(WebElement element) {
		boolean blnResult = false;
		if (element.isDisplayed())
			blnResult = true;
		else
			blnResult = false;
		return blnResult;
	}

	/**
	 * Method written for explicit wait
	 * 
	 * @param element
	 */
	public void waitElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			fail("Element is not present");
		} catch (Exception e) {
			fail("Wait for the element is not working");
		}
	}

	/**
	 * Method written for sending data for a web element like input text etc
	 * 
	 * @param element
	 * @param data
	 */
	public void elementSendKeys(WebElement element, String data) {
		try {
			waitElementToBeClickable(element);
			element.clear();
			element.sendKeys(data);
		} catch (java.util.NoSuchElementException e) {
			fail("Textbox element is not present");
		} catch (Exception e) {
			fail("The textbox can not be edited");
		}
	}

	/**
	 * Method to get the element text based of locator
	 * 
	 * @param locator
	 * @return
	 */
	public String elementGetText(WebElement locator) {
		String strValue = null;
		try {
			strValue = locator.getText();
		} catch (NoSuchElementException e) {
			fail("Element is not present");
		} catch (Exception e) {
			fail("Can not retrieve the text for the element");
		}
		return strValue;
	}

	/**
	 * Method to get the title of the page
	 * 
	 * @return
	 */
	public String getTitle() {
		String strValue = null;
		try {
			strValue = driver.getTitle();
		} catch (Exception e) {
			fail("cannot find the title of the page");
		}
		return strValue;
	}
}
