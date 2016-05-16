package Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.cucumber.testng.examples.BaseStepDefs;



public class Utility {
	
public static boolean acceptNextAlert = true;	
public static WebDriver driver;

	
	
	public Utility()
	    {
	    	driver = BaseStepDefs.driver;
	    	
	    }
		  
	public static void handleAlert(WebDriver ldriver){
		if(isAlertPresent(ldriver)){
			Alert alert = ldriver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public static boolean isAlertPresent(WebDriver ldriver){
		try{
			ldriver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}
	
}
