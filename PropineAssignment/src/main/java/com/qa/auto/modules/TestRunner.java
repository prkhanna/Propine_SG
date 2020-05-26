package com.qa.auto.modules;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

/**
 * @author Prince Khanna
 *
 */

@CucumberOptions(dryRun = false, monochrome = true, glue = { "" }, 
                 features = { "src/test/java/resources/features" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
