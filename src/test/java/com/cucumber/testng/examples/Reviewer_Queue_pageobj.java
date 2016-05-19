package com.cucumber.testng.examples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reviewer_Queue_pageobj {
	
	
	

		private static WebElement element = null;
		
		public static WebElement tab_Review(WebDriver driver){
			element = driver.findElement(By.cssSelector("li.selected"));
			return element;
		}
		
		public static WebElement ddwn_Filter1(WebDriver driver){
			element = driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div/select"));
			return element;
		}

		public static WebElement ddwn_Filter2(WebDriver driver){
			element = driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select"));
			return element;
		}
		public static WebElement lbl_Fund1(WebDriver driver){
			element = driver.findElement(By.cssSelector("h3.ngLink.ng-binding"));
			return element;
		}
		public static WebElement lbl_Numfunds(WebDriver driver){
			element = driver.findElement(By.cssSelector("div.col-xs-12 > p"));
			return element;
		}
		public static WebElement lbl_FundType(WebDriver driver){
			element = driver.findElement(By.cssSelector("div.col-xs-8 > p"));
			return element;
		}
		public static WebElement lbl_LastModifDate(WebDriver driver){
			element = driver.findElement(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div[5]/div[4]/div/p/span"));
			return element;
		}
		public static WebElement lbl_FundStatus(WebDriver driver){
			element = driver.findElement(By.cssSelector("p.pull-right.ng-binding"));
			return element;
		}
	}


