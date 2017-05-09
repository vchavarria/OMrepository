package Utilities;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.testng.examples.BaseStepDefs;

public class Utility {

	public static boolean acceptNextAlert = true;
	public static WebDriver driver;
	public static WebElement element;

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

	private boolean existsElementbyCSS(String css) {
		try {
			driver.findElement(By.cssSelector(css));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	private boolean existsElementbyXpath(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public static int converttoint(String string) {
		// the String to int conversion happens here
		return StringUtils.isNotBlank(string) ? Integer.parseInt(string) : 0;
		// print out the value after the conversion

	}

	public static double converttodouble(String string) {
		// the String to int conversion happens here
		return (StringUtils.isNotBlank(string) ? Double.parseDouble(string) : 0);
		// print out the value after the conversion

	}

	public static void RoundValue(String number) {

		// double kilobytes = 1205.6358;
		// System.out.println("kilobytes : " + kilobytes);

		// double newKB = Math.round(kilobytes*100.0)/100.0;
		// System.out.println("kilobytes (Math.round) : " + newKB);

		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("kilobytes (DecimalFormat) : " + df.format(number));
	}

	public static boolean intareEqual(Number first, Number second) {
		if (first != null && second != null) {
			return first.equals(second);
		}
		return false;
	}

}
