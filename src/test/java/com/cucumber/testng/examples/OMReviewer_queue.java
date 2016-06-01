package com.cucumber.testng.examples;

import java.util.Iterator;
import java.util.TimerTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.testng.examples.*;
import com.cucumber.testng.pageobjects.Reviewer_Queue_pageobj;
import com.cucumber.testng.pageobjects.Reviewerqueue_PO;

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
@Given("^User is on the queue ([^\"]*)$")
public void User_is_on_the_queue (String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	
	 //now perform the action on this element
	Assert.assertEquals((Reviewerqueue_PO.tab_Review.getText()), arg1);
		String CurrURL = driver.getCurrentUrl();
		Assert.assertEquals("http://omdev.ca-labs.com/app/queue/reviewer", CurrURL);
		System.out.println("Current Queue "+CurrURL);
		System.out.println("Queue selected "+(Reviewerqueue_PO.tab_Review.getText())+" is Selected");
	
	
}
	//Select oSelect = new Select(Reviewer_Queue_pageobj.ddwn_Filter1(driver));
	//oSelect.selectByVisibleText("Status");


@Then("^User selects Filter by ([^\"]*)$")
public void user_selects_Filter_by (String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter1(driver).click();
	//Select oSelect = 
	new Select(Reviewerqueue_PO.ddwn_Filter1).selectByVisibleText(arg2);
	//new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div/select"))).selectByVisibleText("Status");
	//oSelect.selectByVisibleText("Status");
}

@And("^User selects the status ([^\"]*)$")
public void user_selects_the_status(String arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter2(driver).click();
	new Select (Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText(arg3);
	//new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select"))).selectByVisibleText("REVIEW IN PROGRESS");
	//oSelect.selectByVisibleText("Status");
}

@Then("^Only the firms showed with ([^\"]*)$")
public void only_the_firms (String arg4) throws Throwable {
    
	// Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//div[@id='app']/div/div/main/div/section/div/div/div/div[6]
	int rowcount=driver.findElements(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div")).size();
	if (rowcount > 0) 
	{
	System.out.println("Total firms in "+ arg4 + " "+(rowcount-4));
	}
	//div[@id='app']/div/div/main/div/section/div/div/div/div[5]
	
//	for (int x=5;x<rowcount+1;x++){
//		String s = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[1]/div[2]/p")).getText();	 
//	if(driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[1]/div[2]/p")).getText().matches(arg4))
//	{
//	System.out.println(arg4 +" firm found");
//	}
	else
	{
	System.out.println("Not firms in "+ arg4);
	}
	
//	try {
//		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div")).getText().matches("READY TO REVIEW"));
//		} catch (Error e) {
//		verificationErrors.append(e.toString());
//		}
	//Assert.assertEquals((Reviewer_Queue_pageobj.lbl_FundStatus(driver)).getText(), "REVIEW IN PROGRESS");
}
@Then("^check the fields displayed within a firm$")
public void check_the_fields_displayed_within_a_firm() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

//@When("^User selects the status READY TO REVIEW$")
//public void user_selects_the_status_READY_TO_REVIEW() throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new PendingException();
//	//new Select (Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText("READY TO REVIEW");
//	new Select (Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText("READY TO REVIEW");
//	
//	//new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select"))).selectByVisibleText("READY TO REVIEW");
//}
//
//@Then("^Only the firms in READY TO REVIEW are showed$")
//public void only_the_firms_in_READY_TO_REVIEW_are_showed() throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new PendingException();
//	int rowcount=driver.findElements(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div")).size();
//	System.out.println("Total firms in READY TO REVIEW "+(rowcount-4));
//	//div[@id='app']/div/div/main/div/section/div/div/div/div[5]
//	for (int x=5;x<rowcount+1;x++){
//	String s = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[1]/div[2]/p")).getText();	 
//	if(driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[1]/div[2]/p")).getText().matches("READY TO REVIEW"))
//	{
//	System.out.println("READY TO REVIEW firm found");
//	}
//	else
//	{
//	System.out.println("READY TO REVIEW IN PROGRESS");
//	}
//	}
////	Assert.assertEquals((Reviewer_Queue_pageobj.lbl_FundStatus(driver)).getText(), "READY TO REVIEW");
////	Assert.assertEquals("READY TO REVIEW", driver.findElement(By.cssSelector("p.pull-right.ng-binding")).getText());
////    Assert.assertEquals("Number of Funds: 12", driver.findElement(By.cssSelector("div.col-xs-12 > p")).getText());
////    Assert.assertEquals("PE", driver.findElement(By.cssSelector("div.col-xs-8 > p > span.ng-binding")).getText());
////    Assert.assertEquals("Submitted Date: 05/03/2016", driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[5]/div[4]/div/p")).getText());
//}


}