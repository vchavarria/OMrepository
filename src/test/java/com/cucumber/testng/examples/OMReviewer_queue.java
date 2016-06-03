package com.cucumber.testng.examples;

import java.util.Iterator;
import java.util.List;
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
	String Filter;
	
public OMReviewer_queue()
{
	driver = BaseStepDefs.driver;
	
}

@Given("^User is on the queue ([^\"]*)$")
public void User_is_on_the_queue (String Queue) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	
	 //now perform the action on this element
	Assert.assertEquals((Reviewerqueue_PO.tab_Review.getText()), Queue);
		String CurrURL = driver.getCurrentUrl();
		Assert.assertEquals("http://omdev.ca-labs.com/app/queue/reviewer", CurrURL);
		System.out.println("Current Queue "+CurrURL);
		System.out.println("Queue selected "+(Reviewerqueue_PO.tab_Review.getText())+" is Selected");
	
	
}
	//Select oSelect = new Select(Reviewer_Queue_pageobj.ddwn_Filter1(driver));
	//oSelect.selectByVisibleText("Status");


@Then("^User selects Filter by ([^\"]*)$")
public void user_selects_Filter_by (String Filter1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter1(driver).click();
	//Select oSelect = 
	Filter = Filter1;
	new Select(Reviewerqueue_PO.ddwn_Filter1).selectByVisibleText(Filter1);
	//new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div/select"))).selectByVisibleText("Status");
	//oSelect.selectByVisibleText("Status");
}

@And("^User selects the status ([^\"]*)$")
public void user_selects_the_status(String Filter2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//Reviewer_Queue_pageobj.ddwn_Filter2(driver).click();
	new Select (Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText(Filter2);
	//new Select(driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select"))).selectByVisibleText("REVIEW IN PROGRESS");
	//oSelect.selectByVisibleText("Status");
}

@Then("^Only the firms showed with ([^\"]*)$")
public void only_the_firms (String Stat) throws Throwable {
    
	// Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	//div[@id='app']/div/div/main/div/section/div/div/div/div[6]
	
	int rowcount=driver.findElements(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div")).size();
//	Select se = new Select(Reviewerqueue_PO.ddwn_Filter1);
//	WebElement strCurrentValue = se.getFirstSelectedOption();
	
	if (rowcount > 0) 
	{
	System.out.println("Total firms Filtered by "+Filter+" "+ Stat + " "+(rowcount-4));
	}
	else
	{
	System.out.println("Not firms Filtered by "+Filter+" "+ Stat);
	}
	
}
@Then("^check the fields displayed within a firm$")
public void check_the_fields_displayed_within_a_firm() throws Throwable {
	int rowcount=driver.findElements(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div")).size();
	if (rowcount > 0) 
		for (int x=5;x<rowcount+1;x++){
		String Compname = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[1]/div[1]/h3")).getText();	
		String NumFunds = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[2]/div/p")).getText();
		String FundTyp = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[3]/div/p")).getText();
		String SubmDt = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[4]/div/p")).getText();
		String Status = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+x+"]/div[1]/div[2]/p")).getText();
		System.out.println("Company "+Compname+" has "+NumFunds+" and "+FundTyp+" and "+SubmDt+" Status "+Status);
		}
	else
		{
		System.out.println("Verification Failed - No Fields found");
		}
}


@When("^User selects Sort by ([^\"]*)$")
public void user_selects_Sort_by_Number_of_Funds(String Sort) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	new Select(Reviewerqueue_PO.ddwn_Sort).selectByVisibleText(Sort);
    //throw new PendingException();
}
@When("^User selects the criteria ([^\"]*)$")
public void user_selects_the_criteria_Ascending(String Criteria) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	if (Criteria.equals("Ascending")){
		Reviewerqueue_PO.chk_Ascending.click();
	}
		else if (Criteria.equals("A-Z")){
			Reviewerqueue_PO.chk_AZ.click();
		}
		else if (Criteria.equals("Descending")){
			Reviewerqueue_PO.chk_Descending.click();
		}
		else if (Criteria.equals("Z-A")){
			Reviewerqueue_PO.chk_ZA.click();
		}
	}

@Then("^check the fields Sorted within a firm$")
public void check_the_fields_Sorted_within_a_firm() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 WebElement table = driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div[5]"));

	    List rows = table.findElements(By.tagName("tr"));
	    int row_count = rows.size();
	    System.out.println("Total rows is " + row_count);
	    Iterator I1 = rows.iterator();

	    while(I1.hasNext()){
	      WebElement data = (WebElement) I1.next();

	      List columns= data.findElements(By.tagName("td"));
	      Iterator I2=columns.iterator();
	      while(I2.hasNext()){
	        WebElement text=(WebElement) I2.next();
	        String columndata=text.getText();
	        System.out.print(" ");
	        System.out.print(columndata);
	        System.out.print(" ");
	      }
	      System.out.println("");
	    }
	  }
    
    //throw new PendingException();
}


