package com.cucumber.testng.examples;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.testng.pageobjects.Login_Page_PO;

import Utilities.Constant;
import Utilities.ExcelLoadUtil;
import Utilities.ExcelUtils;
import Utilities.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OMLogin {
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	public OMLogin() throws Exception {
		driver = BaseStepDefs.driver;
	}

	@When("^User enters a Reviewer valid user name$")
	public void user_enters_a_valid_user_name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// This is to get the Path of the excel file
		ExcelLoadUtil excelUtil = new ExcelLoadUtil();
		excelUtil.setExcelFile(Constant.Path_TestDataLogin + Constant.File_TestDataLogin);
		// This is to get the values from Excel sheet, passing parameters (Row
		// num &amp; Col num)
		String sUserName = ExcelUtils.getStringCellValue(excelUtil.getExcelWBook(), 0, 0, 0);
		boolean userField = Utilities.Utility.elementIsPresent(Login_Page_PO.Inpt_Username);
		if (userField == true) {
			Login_Page_PO.Inpt_Username.clear();
			System.out.println("User Name is " + sUserName);
			Login_Page_PO.Inpt_Username.sendKeys(sUserName);
		} else {
			System.out.println("Element " + Login_Page_PO.Inpt_Username + " is not present please check");
		}
		// throw new PendingException();
	}

	@And("^User enters a Reviewer valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ExcelLoadUtil excelUtil = new ExcelLoadUtil();
		excelUtil.setExcelFile(Constant.Path_TestDataLogin + Constant.File_TestDataLogin);
		String sPassword = ExcelUtils.getStringCellValue(excelUtil.getExcelWBook(), 0, 0, 1);
		boolean passWordField = Utilities.Utility.elementIsPresent(Login_Page_PO.Inpt_Password);
		if (passWordField == true) {
			// System.out.println(Login_Page_PO.Inpt_Password.getAttribute(arg0));
			// Assert.assertEquals(Login_Page_PO.Inpt_Password.getTagName(),
			// "Operating Metrics");
			Login_Page_PO.Inpt_Password.clear();
			System.out.println("Password is " + sPassword);
			Login_Page_PO.Inpt_Password.sendKeys(sPassword);
		} else {
			System.out.println("Element " + Login_Page_PO.Inpt_Password + "  is not present please check");
		}
		// throw new PendingException();
	}

	@And("^User clicks in the Login button$")
	public void clicks_into_the_login_button() throws Throwable {
		Login_Page_PO.Btn_Login.click();
	}

	@And("^Clicks into the alert page$")
	public void clicks_into_the_alert_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		boolean alertWindow = Utilities.Utility.isAlertPresent(driver);
		if (alertWindow == true)
			Utility.handleAlert(driver);
		// throw new PendingException();
	}

	@Then("^user shall be redirected to the OM main page$")
	public void user_shall_be_redirected_to_the_OM_main_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), "Operating Metrics");
		// throw new PendingException();
	}

	// @Then("^error message \"([^\"]*)\" shall be showed$")
	// public void error_message_shall_be_showed(String signerr) throws
	// Throwable {
	// Write code here that turns the phrase above into concrete actions
	// assertEquals(signerr,
	// driver.findElement(By.id("signin-feedback")).getText());
	// assertEquals(driver.findElement(By.id("signin-feedback")).getText(),
	// signerr);
	// System.out.println("Login failed message " + signerr);
	// throw new PendingException();
	// }

	// @When("^User enters a Reviewer invalid user name$")
	// public void user_enters_a_Reviewer_invalid_user_name() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	// Login_Page_pageobj.txtbx_UserName(driver).clear();
	// Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchava");
	// throw new PendingException();
	// }

	// @When("^User enters an Reviewer invalid password$")
	// public void user_enters_an_Reviewer_invalid_password() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// Login_Page_pageobj.txtbx_Password(driver).clear();
	// Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2009");
	// throw new PendingException();
	// }

	// @When("^User enters a valid QC user name$")
	// public void user_enters_a_valid_QC_user_name() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	// Login_Page_pageobj.txtbx_UserName(driver).clear();
	// Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	// throw new PendingException();
	// }

	// @When("^User enters a QC valid password$")
	// public void user_enters_a_QC_valid_password() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// Login_Page_pageobj.txtbx_Password(driver).clear();
	// Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2007");
	// driver.findElement(By.id("signin-button")).click();

	// throw new PendingException();
	// }

	// @When("^User enters a QC invalid user name$")
	// public void user_enters_a_QC_invalid_user_name() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	// Login_Page_pageobj.txtbx_UserName(driver).clear();
	// Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchava");
	// throw new PendingException();
	// }
	//
	// @When("^User enters a QC valid user name$")
	// public void user_enters_a_QC_valid_user_name() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	// Login_Page_pageobj.txtbx_UserName(driver).clear();
	// Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	// throw new PendingException();
	// }

	// @When("^User enters a QC invalid password$")
	// public void user_enters_a_QC_invalid_password() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	// Login_Page_pageobj.txtbx_Password(driver).clear();
	// Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2008");
	// throw new PendingException();
	// }

}
