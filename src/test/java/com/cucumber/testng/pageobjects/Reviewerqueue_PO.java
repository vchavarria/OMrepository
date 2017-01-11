package com.cucumber.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Reviewerqueue_PO {
	final WebDriver driver;

	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div/main/div/section/div/div/div/div[1]/div/ul/li[1]")
	public static WebElement tab_Review;
	@FindBy(how = How.CSS, using = "[ng-change='vm.filterChange(vm.filter)']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div/select")
	public static WebElement ddwn_Filter1;
	@FindBy(how = How.CSS, using = "[ng-change='vm.filterFunds(vm.filterOption)']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select")
	public static WebElement ddwn_Filter2;
	@FindBy(how = How.CSS, using = "[ng-model='vm.sortField']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select")
	public static WebElement ddwn_Sort;
	@FindBy(how = How.CSS, using = "[type='checkbox'][ng-model='vm.sortOption.a']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select")
	public static WebElement chk_Ascending;
	@FindBy(how = How.CSS, using = "[type='checkbox'][ng-model='vm.sortOption.z']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select")
	public static WebElement chk_Descending;
	@FindBy(how = How.CSS, using = "[type='checkbox'][ng-model='vm.sortOption.a']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select")
	public static WebElement chk_AZ;
	@FindBy(how = How.CSS, using = "[type='checkbox'][ng-model='vm.sortOption.z']")
	// (how = How.XPATH, using =
	// "//div[@id='app']/div/div/main/div/section/div/div/div/div[3]/div/div/div[3]/select")
	public static WebElement chk_ZA;
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div/main/div/section/div/div/div/div[1]/div/ul/li[3]")
	public static WebElement tab_Exception;

	public Reviewerqueue_PO(WebDriver driver) {

		this.driver = driver;

	}

}
