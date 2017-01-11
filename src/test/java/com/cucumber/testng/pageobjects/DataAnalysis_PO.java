package com.cucumber.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DataAnalysis_PO {
	final WebDriver driver;

	@FindBy(how = How.XPATH, using = "html/body/div/div/div/header/nav/div/div/div[1]/div/div[2]/ul/li[2]")
	public static WebElement Lnk_DataAnalysis;

	@FindBy(how = How.XPATH, using = "html/body/div/div/div/main/div/omreport/section/div/div[1]/section/div/div[1]/div/div/ul/li[1]")
	public static WebElement Tab_DefReports;

	@FindBy(how = How.XPATH, using = "html/body/div/div/div/main/div/omreport/section/div/div[1]/section/div/div[2]/div/div[1]/div[1]/div[2]/div")
	public static WebElement Rpt_PPMTotUniv;

	@FindBy(how = How.CSS, using = "[ng-click='vm.runReport()']")
	public static WebElement Btn_Run;

	public DataAnalysis_PO(WebDriver driver) {

		this.driver = driver;

	}
}
