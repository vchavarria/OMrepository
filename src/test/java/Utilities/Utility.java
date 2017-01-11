package Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.testng.examples.BaseStepDefs;

public class Utility {

	public static boolean acceptNextAlert = true;
	public static WebDriver driver;

	public Utility() {
		driver = BaseStepDefs.driver;

	}

	public static void handleAlert(WebDriver ldriver) {
		if (isAlertPresent(ldriver)) {
			Alert alert = ldriver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public static boolean isAlertPresent(WebDriver ldriver) {
		try {
			ldriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver ldriver, By by) {
		try {
			ldriver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementVisible(String cssLocator) {
		return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
	}

	public static boolean elementIsPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
