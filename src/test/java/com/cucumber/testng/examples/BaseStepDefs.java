package com.cucumber.testng.examples;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


/**
 * Created by amit.rawat on 21/12/15.
 */

	

public class BaseStepDefs {
	public static WebDriver driver;


    @Before()
    //public void before(Scenario scenario) {
     //   System.out.println("This is before Scenario: " + scenario.getName().toString());
        /**
         * Delete all cookies at the start of each scenario to avoid
         * shared state between tests
         */
  // }
        public void openBrowser() throws MalformedURLException {
		 System.out.println("Called openBrowser");
		 //System.setProperty("webdriver.chrome.driver", "C://Users/vchavarria/Downloads/Maven-Failsafe-Plugin-Example-master/resources/com/drivers/chromedriver.exe");
		 //driver = new ChromeDriver();
	      	driver = new FirefoxDriver();
	      	driver.manage().deleteAllCookies();
	    	driver.manage().window().maximize();
	    	driver.get("http://omdev.ca-labs.com/app/queue/reviewer");
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	
        
    }

      
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
  
    

