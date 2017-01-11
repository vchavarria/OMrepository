package com.cucumber.testng.examples;

import static org.testng.AssertJUnit.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cucumber.testng.pageobjects.Login_Page_pageobj;
import com.cucumber.testng.pageobjects.Reviewerqueue_PO;

import Utilities.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


/**
 * Created by amit.rawat on 21/12/15.
 */
public class BaseStepDefs {
	public String BaseURL = "http://omdev.ca-labs.com/app/queue/reviewer";
	public static WebDriver driver;
	Reviewerqueue_PO Reviewer_queuePO;
	Login_Page_pageobj LoginpagePO;
	
	
	/*@Parameters("browser")*/
   
   /* @Test*/
 
    @Before()
        public void openBrowser(Scenario scenario) throws MalformedURLException {
    	 System.out.println("This is before Scenario: " + scenario.getName().toString());
		 System.out.println("Called openBrowser");
		/*/System.setProperty("webdriver.chrome.driver", "C://Users/vchavarria/Downloads/Maven-Failsafe-Plugin-Example-master/resources/com/drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		if (browsername.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
		 }
		 else if (browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C://Users//vchavarria//Downloads//Maven-Failsafe-Plugin-Example-master//src//test//resources//com//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		 }
		 else if (browsername.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver", "C://Users//vchavarria//Downloads//Maven-Failsafe-Plugin-Example-master//src//test//resources//com//drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			 }
		 System.setProperty("webdriver.chrome.driver", "C://Users/vchavarria/Downloads/Maven-Failsafe-Plugin-Example-master/src/test/resources/com/drivers/chromedriver.exe");		 
		 driver = new ChromeDriver(); 	*/
		    driver = new FirefoxDriver();
		    /*System.setProperty("webdriver.chrome.driver", "C://Users//vchavarria//Downloads//Maven-Failsafe-Plugin-Example-master//src//test//resources//com//drivers//chromedriver.exe");
			driver = new ChromeDriver();*/
	      	driver.manage().deleteAllCookies();
	    	driver.manage().window().maximize();
	    	driver.get(BaseURL);
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	System.out.println(driver.getTitle());
	    	Reviewer_queuePO = PageFactory.initElements(driver, Reviewerqueue_PO.class);
	    	LoginpagePO = PageFactory.initElements(driver, Login_Page_pageobj.class);
	    	assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	        Login_Page_pageobj.txtbx_UserName(driver).clear();
	        Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	        Login_Page_pageobj.txtbx_Password(driver).clear();
	    	Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2008");
	    	Login_Page_pageobj.btn_LogIn(driver).click();
	    	Utility.isAlertPresent(driver);
	    	Utility.handleAlert(driver);
	    	assertEquals(driver.getTitle(), "Operating Metrics");
	    	
        
    }
    
   /* @BeforeSuite
    public void beforeSuite() {
       System.out.println("This is beforeSuite of Base Test Case");
       
       assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
	    Login_Page_pageobj.txtbx_UserName(driver).clear();
	    Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
	    Login_Page_pageobj.txtbx_Password(driver).clear();
		Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2007");
		Login_Page_pageobj.btn_LogIn(driver).click();
		Utility.isAlertPresent(driver);
		Utility.handleAlert(driver);
		assertEquals(driver.getTitle(), "Operating Metrics");
   }*/

      
    @After
    public void after(Scenario scenario) {
        //System.out.println("This is after Scenario: " + scenario.getName().toString());
          //   if (scenario.isFailed()) {
              // Take a screenshot...
            //  final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
              //scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
            //}
             driver.quit();
    }
}
   
     

  
    

