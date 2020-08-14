package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Prince Khanna
 *
 */
public class Home {

	/**
	 * Web Elements for this Page
	 */
	@FindBy(how = How.XPATH, using = "//input[@type = 'submit']")
	public static WebElement submitBtn;
	@FindBy(how = How.XPATH, using = "//input[@type = 'text']")
	public static WebElement inputField;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div")
	public static WebElement displayedOutput;
	@FindBy (how = How.XPATH, using = "//title[text() = 'Propine Date Parser']") 
	public static WebElement title;
	@FindBy (how = How.XPATH, using = "//p[contains(text(), 'Enter a text')]") 
	public static WebElement text;
	@FindBy (how = How.XPATH, using = "//img[@src = '/img/logo.png']") 
	public static WebElement logo;
	
	

	
}
