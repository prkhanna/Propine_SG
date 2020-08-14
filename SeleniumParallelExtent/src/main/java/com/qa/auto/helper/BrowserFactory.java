package com.qa.auto.helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Prince Khanna
 *
 */
public class BrowserFactory {

	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public final void setDriver(String browser) throws Exception {

		DesiredCapabilities caps = null;

		switch (browser) {

		case "Chrome":
			
			caps = DesiredCapabilities.chrome();
			ChromeOptions chOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			chOptions.setExperimentalOption("prefs", chromePrefs);
			chOptions.addArguments("--disable-plugins", "--disable-extensions",
					"--disable-popup-blocking");
			caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
			caps.setCapability("applicationCacheEnabled", false);
			System.setProperty("webdriver.chrome.driver",
					"src/test/java/resources/drivers/chromedriver.exe");

			// this will suppress the console warning for chrome browser
			System.setProperty("webdriver.chrome.silentOutput", "true");
			webDriver.set(new ChromeDriver());
		}
	}

	public  WebDriver getDriver() {
		return webDriver.get();
	}

}
