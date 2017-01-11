package com.cucumber.testng.examples;

import org.openqa.selenium.WebDriver;

import com.cucumber.testng.pageobjects.DataAnalysis_PO;

import Utilities.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OMDataAnalysis {
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	public OMDataAnalysis() throws Exception {
		driver = BaseStepDefs.driver;
	}

	@Given("^User is on the Section([^\"]*)$")
	public void user_is_on_the_Section(String Section) throws Throwable {
		boolean Sect = Utility.elementIsPresent(DataAnalysis_PO.Lnk_DataAnalysis);
		if (Section.equals("Defined Reports") && Sect == true) {
			DataAnalysis_PO.Lnk_DataAnalysis.click();
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^User selects Type Report([^\"]*)$")
	public void user_selects_Type_Report(String Reptype) throws Throwable {
		boolean Rtype = Utility.elementIsPresent(DataAnalysis_PO.Tab_DefReports);
		if (Reptype.equals("EBITDA PPM") && Rtype == true) {
			DataAnalysis_PO.Tab_DefReports.click();
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^User selects Report([^\"]*)$")
	public void user_selects_Total_Universe(String Rep) throws Throwable {
		boolean Report = Utility.elementIsPresent(DataAnalysis_PO.Rpt_PPMTotUniv);
		if (Rep.equals("Total Universe ") && Report == true) {
			DataAnalysis_PO.Rpt_PPMTotUniv.click();
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^User clicks on Run button$")
	public void user_clicks_on_Run_button() throws Throwable {
		boolean Btn = Utility.elementIsPresent(DataAnalysis_PO.Btn_Run);
		if (Btn == true) {
			DataAnalysis_PO.Btn_Run.click();
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("([^\"]*)$ is showed$")
	public void is_showed(String Rep) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^check the values showed$")
	public void check_the_values_showed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}