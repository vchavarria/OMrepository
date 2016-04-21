package com.cucumber.testng.examples;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OMLogin {
public WebDriver driver;
	
	
	public OMLogin()
	    {
	    	driver = BaseStepDefs.driver;
	    	
	    }
	@When("^User enters a valid user name$")
	public void user_enters_a_valid_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user shall be redirected to the OM main page$")
	public void user_shall_be_redirected_to_the_OM_main_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User enters an invalid user name$")
	public void user_enters_an_invalid_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^error message shall be showed$")
	public void error_message_shall_be_showed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User enters an invalid password$")
	public void user_enters_an_invalid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	}
