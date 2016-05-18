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

@Then("^User selects Filter by \"([^\"]*)\"$")
public void user_selects_Filter_by (String FltStatus) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter1(driver).click();
	//Select oSelect = 
	new Select(Reviewer_Queue_pageobj.ddwn_Filter1(driver)).selectByVisibleText(FltStatus);
	//oSelect.selectByVisibleText("Status");
}

@And("^User selects the status \"([^\"]*)\"$")
public void user_selects_the_status(String FndStatus) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter2(driver).click();
	new Select(Reviewer_Queue_pageobj.ddwn_Filter1(driver)).selectByVisibleText(FndStatus);;
	//oSelect.selectByVisibleText("Status");
}

@Then("^Only the firms in \"([^\"]*)\"$ are showed$")
public void only_the_firms (String FndStatus2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	Assert.assertEquals((Reviewer_Queue_pageobj.lbl_FundStatus(driver)).getText(), FndStatus2);
}






}