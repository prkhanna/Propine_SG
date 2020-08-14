package com.qa.auto.stepdefination;

import static com.qa.auto.modules.Hooks.misc;

import org.testng.Assert;

import com.qa.auto.pages.Home;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author Prince Khanna
 *
 */
public class HomePage {

	@Given("^Enter the date in '(.*)' input field$")
	public void enter_the_date_in_input_field(String value) throws Throwable {
		misc.elementSendKeys(Home.inputField, value);
	}

	@Then("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
		misc.elementClick(Home.submitBtn);
	}

	@Then("^Check the output '(.*)' field$")
	public void check_the_output_Invalid_Date_field(String value) throws Throwable {
		String outputResult = misc.elementGetText(Home.displayedOutput);
		Assert.assertEquals(outputResult, value);
	}

	@Given("^Check for the title of the page$")
	public void check_for_the_title_of_the_page() throws Throwable {
		String outputResult = misc.getTitle();
		Assert.assertEquals(outputResult, "Propine Date Parser");
	}

	@Then("^Check for the input field$")
	public void check_for_the_input_field() throws Throwable {
		misc.isElementPresent(Home.inputField);
	}

	@Then("^Check for submit button$")
	public void check_for_submit_button() throws Throwable {
		misc.isElementPresent(Home.submitBtn);
	}

	@Then("^Check for the Result section$")
	public void check_for_the_Result_section() throws Throwable {
		misc.isElementPresent(Home.displayedOutput);
	}

	@Then("^Check for the displayed text$")
	public void check_for_the_displayed_text() throws Throwable {
		misc.isElementPresent(Home.text);
	}

	@Given("^Click on the company image to refresh the page$")
	public void display_the_company_image() throws Throwable {
		misc.elementClick(Home.logo);
	}

	@Then("^Check the result has been reset or not$")
	public void check_the_result_has_been_reset_or_not() throws Throwable {
		String outputResult = misc.elementGetText(Home.displayedOutput);
		Assert.assertEquals(outputResult, "0");
	}
	
}
