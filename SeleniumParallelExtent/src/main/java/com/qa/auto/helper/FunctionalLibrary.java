package com.qa.auto.helper;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Generic Function Class
 * 
 * @author Prince Khanna
 *
 */
public class FunctionalLibrary {

	WebDriver driver;

	public FunctionalLibrary(WebDriver driver) {
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

	public String takeSnap(WebDriver driver, String Description) {

		String strGetScreenshotPath = "target\\cucumber-reports\\Screenshots";
		String ImageFilePath = "";
		String userDir = System.getProperty("user.dir");
		try {

			ImageFilePath = userDir + "\\" + strGetScreenshotPath + "\\" + Description.trim() + "_" + GetDate()
					+ ".png";

			boolean AlertCheck = isAlertPresent();
			if (AlertCheck) {
				BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					
				ImageIO.write(image, "png", new File(ImageFilePath));
			} else {

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(ImageFilePath));

			}
		} catch (Exception e) {

		}

		return ImageFilePath;

	}

	private boolean isAlertPresent() {
		boolean blValue = false;
		try {
			driver.switchTo().alert();
			blValue = true;
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			blValue = false;
			e.printStackTrace();
		}
		return blValue;
	}

	private String GetDate() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHssmm");
		Date date = new Date();
		String formatedDate = dateFormat.format(date);
		return formatedDate;
	}
	
	public static HashMap<String , String> ReadPropertiesFile() {
		File file = new File("src/test/java/com/qa/auto/config/config.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> AUT_Properties = new HashMap<String, String>();
        Enumeration KeyValues = prop.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = prop.getProperty(key);
            AUT_Properties.put(key, value);
        }
        return AUT_Properties;
    }

	}

