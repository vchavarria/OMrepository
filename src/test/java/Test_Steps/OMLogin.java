package Test_Steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.cucumber.testng.examples.BaseStepDefs;
import com.cucumber.testng.examples.Login_Page_pageobj;

import Utilities.Utility;
import static org.testng.Assert.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.AssertJUnit.assertEquals;

public class OMLogin {
public WebDriver driver;
private StringBuffer verificationErrors = new StringBuffer();
	
	
	public OMLogin()
	    {
	    	driver = BaseStepDefs.driver;
	    	
	    }
	@When("^User enters a Reviewer valid user name$")
	public void user_enters_a_valid_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.get("https://cambridgeassociates.oktapreview.com/login/default?fromURI=%2F%2Fapp%2Fcambridgeassociates_opmetricsdevintegration_1%2Fexk66vqys4KYogFkR0h7%2Fsso%2Fsaml%3FSAMLRequest%3DPD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48c2FtbDJwOkF1dGhuUmVxdWVzdCB4bWxuczpzYW1sMnA9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpwcm90b2NvbCIgQXNzZXJ0aW9uQ29uc3VtZXJTZXJ2aWNlVVJMPSJodHRwOi8vb21kZXYuY2EtbGFicy5jb206ODAvc2FtbC9TU08iIERlc3RpbmF0aW9uPSJodHRwczovL2NhbWJyaWRnZWFzc29jaWF0ZXMub2t0YXByZXZpZXcuY29tL2FwcC9jYW1icmlkZ2Vhc3NvY2lhdGVzX29wbWV0cmljc2RldmludGVncmF0aW9uXzEvZXhrNjZ2cXlzNEtZb2dGa1IwaDcvc3NvL3NhbWwiIEZvcmNlQXV0aG49ImZhbHNlIiBJRD0iYTM2MjFoMjA0YjNmOTZkOTE4NTRmNTZoNDFlNjM5aCIgSXNQYXNzaXZlPSJmYWxzZSIgSXNzdWVJbnN0YW50PSIyMDE2LTA0LTIyVDE1OjEwOjMxLjczMVoiIFByb3RvY29sQmluZGluZz0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmJpbmRpbmdzOkhUVFAtUE9TVCIgVmVyc2lvbj0iMi4wIj48c2FtbDI6SXNzdWVyIHhtbG5zOnNhbWwyPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj5odHRwOi8vb21kZXYuY2EtbGFicy5jb206ODAvc2FtbC9tZXRhZGF0YTwvc2FtbDI6SXNzdWVyPjxkczpTaWduYXR1cmUgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxkczpTaWduZWRJbmZvPjxkczpDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIi8%252BPGRzOlNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPjxkczpSZWZlcmVuY2UgVVJJPSIjYTM2MjFoMjA0YjNmOTZkOTE4NTRmNTZoNDFlNjM5aCI%252BPGRzOlRyYW5zZm9ybXM%252BPGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIi8%252BPGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIvPjwvZHM6VHJhbnNmb3Jtcz48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiLz48ZHM6RGlnZXN0VmFsdWU%252BWlBBSWQ1Qk43Y3Z0MnBTN09KcWx6aWVqbXZNPTwvZHM6RGlnZXN0VmFsdWU%252BPC9kczpSZWZlcmVuY2U%252BPC9kczpTaWduZWRJbmZvPjxkczpTaWduYXR1cmVWYWx1ZT5pZ01sRVN1WDkrcUJaaXEzYWcyYnltaXhKcmpUQlRlVEg0RGJuRDZ1TFREQjJWenZUcWZlYmkwcE1hc1I5cTl5bFNsbmFTUEgzcXRVamtpTisrcjYvSVBFOWRIdElIZ3ZnK2tvQkJBaXQzRnc3ekFwSTZBUDRabkhhOXY3eFpmUVlvR083UlZGV2FQR3RKbTZFQjJJQkVKYUluNENUbEJZY3llYWpPSlNrN0Z0MXZnWFRvN0FZd2F2OVJCdzBMLzMwcHU1MFU0L3NlRkVjVGMrL1FhVzFMRjkzZHdPZXl6WkVTWW1xd09RQjFVSmo1S0hLblV1MkdwNU5nS3RNbDBsY2FtUDNId25TZklQNWZKMWpabDZGZzVpM1hKYmJ1OFZxbEFlRUlNUHByRFlib2JNSHErTXNQMW1GVytSdEtwcWtkT0RpWU1vZ1lCSFJ0QSs3N25QMmc9PTwvZHM6U2lnbmF0dXJlVmFsdWU%252BPGRzOktleUluZm8%252BPGRzOlg1MDlEYXRhPjxkczpYNTA5Q2VydGlmaWNhdGU%252BTUlJRHBUQ0NBbzJnQXdJQkFnSUVTSDcySnpBTkJna3Foa2lHOXcwQkFRc0ZBRENCZ2pFTE1Ba0dBMVVFQmhNQ1QwMHhDekFKQmdOVgpCQWdUQWsxQk1ROHdEUVlEVlFRSEV3WkNiM04wYjI0eEdqQVlCZ05WQkFvVEVVOXdaWEpoZEdsdVp5Qk5aWFJ5YVdOek1Sb3dHQVlEClZRUUxFeEZQY0dWeVlYUnBibWNnVFdWMGNtbGpjekVkTUJzR0ExVUVBeE1VUTJGdFluSnBaR2RsSUVGemMyOWphV0YwWlhNd0hoY04KTVRZd05EQTRNakl5TnpFeldoY05NVFl3TnpBM01qSXlOekV6V2pDQmdqRUxNQWtHQTFVRUJoTUNUMDB4Q3pBSkJnTlZCQWdUQWsxQgpNUTh3RFFZRFZRUUhFd1pDYjNOMGIyNHhHakFZQmdOVkJBb1RFVTl3WlhKaGRHbHVaeUJOWlhSeWFXTnpNUm93R0FZRFZRUUxFeEZQCmNHVnlZWFJwYm1jZ1RXVjBjbWxqY3pFZE1Cc0dBMVVFQXhNVVEyRnRZbkpwWkdkbElFRnpjMjlqYVdGMFpYTXdnZ0VpTUEwR0NTcUcKU0liM0RRRUJBUVVBQTRJQkR3QXdnZ0VLQW9JQkFRQ3VieGN6WVRRa3hDdnY1amE4L3hNaDRrNWNkODlTdWdPNXBkVlViYWV6Smx2dwpnSmZVbUE0N1BBMjZOUXFZRlY5SGxtL0Z1MmZWMWtxLy9BaFBGRFVvTml4N2lNeC9ydVhGc0pUZllRbGw4b0pRM2loVG1mTTdubkdmClBhdWJvRUoyWHJLNE5uUDhOMCtUQlZydUw0L3EwaUpsRkdvSW1wNERTN2RMblFjTEhGQkNtL0VHWG5KYlFQWDRBRUJGbE9QYjFndGcKSjFkd0VXbk9ON05JaUN0Y1VzMklVdkRBRHFRdkRkaStoNGd4cnVKTGxoZkgrT3F5QUozeVpsL0FmeGtGTFozNjVUV3pSS3BDYzRBVApBaDIxSUtqWHNDVmVERlV0QXJZc3BUWGdKMDRkaE1MazYzRTRIVXFkOUc1TlVLNm9zeUJVMlRBL0txWWlReDVrRU51YkFnTUJBQUdqCklUQWZNQjBHQTFVZERnUVdCQlNwMHl0VXd4WWlySWFWM0xSTy9tdmljWEc3Z2pBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQVFFQW50K24KVFFZcG9XVmFZM1RuaitCV3gvREhrb0xHRlI2b2poYTNuOHB3YW9HTXRhOWt5aG5DVkxLNFJFekdwR0ZQRm9oNkd2c0tFTFRoVjNEMApVcms5TFQySmY5TkdzN21hNElyeEp0bDJXYXFRbm9DSmhZWWZORlJwWXlKZkZVckNRUm9UTWxOYlZhTzVkTEwreHJQSHFXelN1ZTMzCldFZ1YxRHdhS3FiTkVmQTVXSkhvQW9tZ2RzNTg2OFNub0ZqSEtDUUYzSHJ5UGJGV1hpL2V1SU44ZDh6S05ab2tqS0VmdzZSVVpqYUIKZC8wT1NOYmtHVVlEWVZ4TWpIZyt3WSttRHZ0Rmo4TmZjVGNPeEpkK1ZXWW53ays1ZXoyOVR0WEZSYVR2L0pmT2lsTUduQlZWQktCTApjM0VGMGFJczNYT2pmSGxGSERZdkNhNmJKNE1LbjFDVVp3PT08L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvZHM6S2V5SW5mbz48L2RzOlNpZ25hdHVyZT48L3NhbWwycDpBdXRoblJlcXVlc3Q%252B%26OKTA_INVALID_SESSION_REPOST%3Dtrue");
	    assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	    Login_Page_pageobj.txtbx_UserName(driver).clear();
	    Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	    //driver.findElement(By.id("user-signin")).clear();
	    //driver.findElement(By.id("user-signin")).sendKeys("vchavarria");
	    //throw new PendingException();
	}

	@And("^User enters a Reviewer valid password$")
	public void user_enters_a_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login_Page_pageobj.txtbx_Password(driver).clear();
		Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2007");
		//driver.findElement(By.id("pass-signin")).clear();
	    //driver.findElement(By.id("pass-signin")).sendKeys("Daniel2006");
	    //driver.findElement(By.id("signin-button")).click();
	    
	    //throw new PendingException();
	}

	@And ("^User clicks in the Login button$")
	public void clicks_into_the_login_button() throws Throwable {
		Login_Page_pageobj.btn_LogIn(driver).click();		
	}
	
	@And("^Clicks into the alert page$")
	public void clicks_into_the_alert_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//Utility.isAlertPresent();
		//Utility.closeAlertAndGetItsText();
		Utility.isAlertPresent(driver);
		Utility.handleAlert(driver);
		//Alert alert = driver.switchTo().alert();
	    //alert.accept();
	    //throw new PendingException();
	}
	@Then("^user shall be redirected to the OM main page$")
	public void user_shall_be_redirected_to_the_OM_main_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(driver.getTitle(), "Operating Metrics");
	    //throw new PendingException();
	}

	@Then("^error message \"([^\"]*)\" shall be showed$")
	public void error_message_shall_be_showed(String signerr) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//assertEquals(signerr, driver.findElement(By.id("signin-feedback")).getText());
		assertEquals(driver.findElement(By.id("signin-feedback")).getText(), signerr);
		System.out.println("Login failed message " + signerr);
	   // throw new PendingException();
	}
	

	@When("^User enters a Reviewer invalid user name$")
	public void user_enters_a_Reviewer_invalid_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
		    Login_Page_pageobj.txtbx_UserName(driver).clear();
		    Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchava");
	    //throw new PendingException();
	}

	@When("^User enters an Reviewer invalid password$")
	public void user_enters_an_Reviewer_invalid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login_Page_pageobj.txtbx_Password(driver).clear();
		Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2008");
	    //throw new PendingException();
	}

	@When("^User enters a valid QC user name$")
	public void user_enters_a_valid_QC_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
		    Login_Page_pageobj.txtbx_UserName(driver).clear();
		    Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	    //throw new PendingException();
	}

	@When("^User enters a QC valid password$")
	public void user_enters_a_QC_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login_Page_pageobj.txtbx_Password(driver).clear();
		Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2007");
	    //driver.findElement(By.id("signin-button")).click();
	    
	    //throw new PendingException();
	}

	@When("^User enters a QC invalid user name$")
	public void user_enters_a_QC_invalid_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
		    Login_Page_pageobj.txtbx_UserName(driver).clear();
		    Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchava");
	    //throw new PendingException();
	}

	@When("^User enters a QC valid user name$")
	public void user_enters_a_QC_valid_user_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
		    Login_Page_pageobj.txtbx_UserName(driver).clear();
		    Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	   // throw new PendingException();
	}

	@When("^User enters a QC invalid password$")
	public void user_enters_a_QC_invalid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login_Page_pageobj.txtbx_Password(driver).clear();
		Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2008");
	   // throw new PendingException();
	}


	}
