package com.cucumber.testng.examples;

import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;

public class OMStepdefs {
    
	public WebDriver driver;
	
	
	public OMStepdefs()
	    {
	    	driver = BaseStepDefs.driver;
	    	
	    }
	 
	 //http://localhost:4002/#/app/fundCompanies/211
	 
	 @When("^Navigate to OM site$")
	 public void navigate_to_OM_site() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
		
	     //throw new PendingException();
	 }
	 @Then("^Header shall be \"([^\"]*)\"$")
	 public void header_shall_be_displayed(String header) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		//header = driver.findElement(By.linkText("#/app/home")).getText();
		  assertEquals(header, driver.findElement(By.xpath("/html/body/div[1]/div/div/header/nav/div/div[1]/div/h1")).getText());
		  
		 System.out.println("Header displayed "+(header)+" is Present");
	     //throw new PendingException();
	 }
	 @And("^user double clicks in Company notes$")
	 public void user_double_click_in_Company_notes() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 String Note = driver.findElement(By.xpath("//div[4]/div[3]/div/div/div/div/div")).getText();
		 assertEquals(Note, driver.findElement(By.xpath("//div[4]/div[3]/div/div/div/div/div")).getText());
		 Actions action = new Actions(driver);
		 WebElement element = driver.findElement(By.xpath("//div[4]/div[3]/div/div/div/div/div"));
		 action.click(element).perform();
		 action.sendKeys((element),Keys.ENTER).perform();
		 action.sendKeys((element), "Comapany note here test").perform();
		 System.out.println("Note edited "+(Note)+" was entered");
		 //throw new PendingException();
	 }

	 @Then("^User is able to enter \"([^\"]*)\"$")
	 public void user_is_able_to_enter(String Note) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 //driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/section/div/div/div[2]/div[3]/div/div/div/div/div/div[1]/div/div[4]/div[3]/div/div/div[1]/div[1]/div")).sendKeys("Company note here for 401 test");
		 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 //throw new PendingException();
	 }

	 @Then("^user shall be able to click in save button$")
	 public void user_shall_be_able_to_click_in_save_button() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//button")).click();
		 							   
		 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     //throw new PendingException();
	 }
   	
	 @Then("^I should be see the table header \"([^\"]*)\"$")
	 public void i_should_be_see_the_table_header(String arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 assertEquals(arg1, driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/section/div/div/div[2]/div[3]/div/div/div/div/div/div[1]/div/div[1]/div[3]/div/div[1]/div[1]/div[2]/span")).getText());
		 System.out.println("Header displayed "+(arg1)+" is Present");
		 //throw new PendingException();
	 }
	 @Then("^pass the xpath locator \"([^\"]*)\"$")
	 public void pass_the_xpath_locator_div_div_div_div_div_span(String arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath(arg1)).getText();
		 System.out.println("Header displayed "+(arg1));
		 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 //throw new PendingException();
	
}
}
    