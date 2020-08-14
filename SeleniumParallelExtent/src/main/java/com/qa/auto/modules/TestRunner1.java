package com.qa.auto.modules;

import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;

/**
 * @author Prince Khanna
 *
 */

@CucumberOptions(dryRun = false, monochrome = true, glue = { "" }, 
features = { "src/test/java/resources/features" },tags= {"@Regression"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
public class TestRunner1 extends AbstractTestNGCucumberTests {
	public static ExtentReports extent;
	
	
	
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/java/com/qa/auto/config/extent-config.xml");
        extent.flush();
    }
}
