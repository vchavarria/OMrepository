package com.cucumber.testng.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.testng.examples.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class OMReviewer_queue {
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

public OMReviewer_queue()
{
	driver = BaseStepDefs.driver;
	
}
@Given("^User is on the Reviewer queue$")
public void User_is_on_the_Reviewer_queue () throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	Assert.assertEquals((Reviewer_Queue_pageobj.tab_Review(driver)).getText(), "REVIEW");
	System.out.println("Queue selected "+(Reviewer_Queue_pageobj.tab_Review(driver).getText())+" is Present");
	//Select oSelect = new Select(Reviewer_Queue_pageobj.ddwn_Filter1(driver));
	//oSelect.selectByVisibleText("Status");
}

@Then("^User selects Filter by Status$")
public void user_selects_Filter_by () throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter1(driver).click();
	//Select oSelect = 
	//new Select (Reviewer_Queue_pageobj.ddwn_Filter1(driver)).selectByVisibleText("REVIEW IN PROGRESS");
	new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div/select"))).selectByVisibleText("Status");
	//oSelect.selectByVisibleText("Status");
}

@And("^User selects the status REVIEW IN PROGRESS$")
public void user_selects_the_status() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter2(driver).click();
	//new Select (Reviewer_Queue_pageobj.ddwn_Filter2(driver)).selectByVisibleText("REVIEW IN PROGRESS");
	new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select"))).selectByVisibleText("REVIEW IN PROGRESS");
	//oSelect.selectByVisibleText("Status");
}

@Then("^Only the firms in REVIEW IN PROGRESS are showed$")
public void only_the_firms () throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	Assert.assertEquals((Reviewer_Queue_pageobj.lbl_FundStatus(driver)).getText(), "REVIEW IN PROGRESS");
}
@Then("^check the fields displayed within a firm$")
public void check_the_fields_displayed_within_a_firm() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

@When("^User selects the status READY TO REVIEW$")
public void user_selects_the_status_READY_TO_REVIEW() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select"))).selectByVisibleText("READY TO REVIEW");
}

@Then("^Only the firms in READY TO REVIEW are showed$")
public void only_the_firms_in_READY_TO_REVIEW_are_showed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	Assert.assertEquals((Reviewer_Queue_pageobj.lbl_FundStatus(driver)).getText(), "READY TO REVIEW");
	Assert.assertEquals("READY TO REVIEW", driver.findElement(By.cssSelector("p.pull-right.ng-binding")).getText());
    Assert.assertEquals("Number of Funds: 12", driver.findElement(By.cssSelector("div.col-xs-12 > p")).getText());
    Assert.assertEquals("PE", driver.findElement(By.cssSelector("div.col-xs-8 > p > span.ng-binding")).getText());
    Assert.assertEquals("Submitted Date: 05/03/2016", driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[5]/div[4]/div/p")).getText());
}


}