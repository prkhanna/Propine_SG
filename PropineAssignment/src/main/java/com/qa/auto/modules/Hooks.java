package com.qa.auto.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.qa.auto.helper.BowserFactory;
import com.qa.auto.helper.FunctionlLibrary;
import com.qa.auto.pages.Home;

/**
 * @author Prince Khanna
 *
 */
public class Hooks {

	public static RemoteWebDriver driver;
	public static FunctionlLibrary misc;

	public static Home home = new Home();

	@Before
	public void setUp() {
		driver = BowserFactory.getDriver();
		driver.manage().window().maximize();
		misc = new FunctionlLibrary(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://vast-dawn-73245.herokuapp.com/");
		PageFactory.initElements(driver, home);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}