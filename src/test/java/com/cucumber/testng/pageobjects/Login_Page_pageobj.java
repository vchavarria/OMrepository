package com.cucumber.testng.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page_pageobj {

	private static WebElement element = null;
	public static WebElement txtbx_UserName(WebDriver driver){
		element = driver.findElement(By.id("user-signin"));
		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver){
		element = driver.findElement(By.id("pass-signin"));
		return element;
	}

	public static WebElement btn_LogIn(WebDriver driver){
		element = driver.findElement(By.id("signin-button"));
		return element;
	}

}
