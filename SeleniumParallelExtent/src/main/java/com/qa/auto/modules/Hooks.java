package com.qa.auto.modules;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionalLibrary;
import static com.qa.auto.helper.FunctionalLibrary.ReadPropertiesFile;
import com.qa.auto.pages.Home;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Prince Khanna
 *
 */
public class Hooks {

	public  WebDriver driver;
	public static FunctionalLibrary misc;
	 public ExtentReports extent;
	    public ExtentTest logger;


	public static Home home = new Home();
	HashMap<String, String> appProperties = ReadPropertiesFile();
	String URL = appProperties.get("url");
	String Browser = appProperties.get("browser");
	
	
	@Before
	public void setUp() throws Exception {
		BrowserFactory bf =  BrowserFactory.getInstance();
		bf.setDriver(Browser);
		driver = bf.getDriver();
		driver.manage().window().maximize();
		misc = new FunctionalLibrary(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Open url");
     	driver.get(URL);
		System.out.println("close url");
		PageFactory.initElements(driver, home);

	}

	



	@After
	public void tearDown(Scenario scenario) {
		
		
		if (scenario.isFailed()) {
			 String sc = misc.takeSnap(driver, scenario.getName());
			 try {
				Reporter.addScreenCaptureFromPath(sc);
			} catch (Exception e) {
				e.printStackTrace();
			}
}
		driver.quit(); 
	}

}