package com.qa.auto.helper;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Prince Khanna
 *
 */
public class BowserFactory {

	public static RemoteWebDriver driver;

	public static RemoteWebDriver getDriver() {

		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/drivers/chromedriver.exe");
		// this will suppress the console warning for chrome browser
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();

		return driver;
	}

}
