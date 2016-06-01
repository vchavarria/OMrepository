package com.cucumber.testng.pageobjects;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;

public class Reviewerqueue_PO {
	final WebDriver driver;	
		
	@FindBy(how = How.CSS, using = "li.selected")	
	public static WebElement tab_Review;	
	@FindBy(how = How.XPATH, using = "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div/select") 	
	public static WebElement ddwn_Filter1;
	@FindBy(how = How.XPATH, using = "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select") 	
	public static WebElement ddwn_Filter2;

	public Reviewerqueue_PO(WebDriver driver){ 
		 
	    this.driver = driver; 
	 
	    } 
	 
			 
}
