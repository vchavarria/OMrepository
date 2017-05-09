package com.cucumber.testng.examples;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.testng.pageobjects.DataAnalysis_PO;

import Utilities.Constant;
import Utilities.ExcelLoadUtil;
import Utilities.ExcelUtils;
import Utilities.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OMDataAnalysis {
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	String Reptyp;

	public OMDataAnalysis() {
		driver = BaseStepDefs.driver;
		driver.get(Utilities.Constant.BaseURL + Utilities.Constant.Lnk_DtaAnalysys);
	}

	// @Given("^User is on the Section([^\"]*)$")
	// public void user_is_on_the_Section(String Section) throws Throwable {
	// // boolean Sect =
	// // Utility.elementIsPresent(DataAnalysis_PO.Lnk_DataAnalysis);
	// // if (Section.equals("Defined Reports") && Sect == true) {
	// DataAnalysis_PO.Lnk_DataAnalysis.click();
	// // }
	// // Write code here that turns the phrase above into concrete actions
	// // throw new PendingException();
	// }

	@Given("^User selects Report Section([^\"]*)$")
	public void user_selects_Report_Section(String Section) throws Throwable {

		boolean Sction = Utility.elementIsPresent(DataAnalysis_PO.Tab_DefReports);
		System.out.println(Section);
		System.out.println(Sction);
		if (Section.contentEquals(" Defined Reports") && Sction == true) {
			DataAnalysis_PO.Tab_DefReports.click();
		} else {
			System.out.println(Section + " Section is not present");
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^User is in Report Type([^\"]*)$")
	public void user_is_in_Report_Type(String Reptype) throws Throwable {

		boolean Rtype = Utility.elementIsPresent(DataAnalysis_PO.Typ_Report);
		System.out.println(Reptype);
		System.out.println(Rtype);
		if (Reptype.equals(" EBITDA PPM") && Rtype == true) {
			System.out.println("Current Report Selected " + Reptype);
		} else {
			System.out.println(Reptype + " Report Type is not present");
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@And("^User selects Report to be showed([^\"]*)$")
	public void user_selects_Report_to_be_showed(String Rep) throws Throwable {

		System.out.println(Rep);
		Reptyp = Rep;
		if (Rep.equals(" Total Universe")) {
			boolean PPMtotUniv = Utility.elementIsPresent(DataAnalysis_PO.Rpt_PPMTotUniv);
			System.out.println(PPMtotUniv);
			DataAnalysis_PO.Rpt_PPMTotUniv.click();
		} else if (Rep.equals(" Company Type")) {
			boolean PPMCompType = Utility.elementIsPresent(DataAnalysis_PO.Rpt_PPMCompTyp);
			System.out.println(PPMCompType);
			DataAnalysis_PO.Rpt_PPMCompTyp.click();
		} else if (Rep.equals(" Sector")) {
			boolean PPMSector = Utility.elementIsPresent(DataAnalysis_PO.Rpt_PPMSector);
			System.out.println(PPMSector);
			DataAnalysis_PO.Rpt_PPMSector.click();
		} else {
			System.out.println(Rep + " is not present");
		}
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@And("^User clicks on Run button$")
	public void user_clicks_on_Run_button() throws Throwable {
		boolean Btn = Utility.elementIsPresent(DataAnalysis_PO.Btn_Run);
		if (Btn == true) {
			System.out.println(Btn);
			DataAnalysis_PO.Btn_Run.click();
		} else {
			System.out.println("Button is not present");
		}

		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^The report displayed is ([^\"]*)$")
	public void the_report_showed_is(String Rep) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^check the values showed$")
	public void check_the_values_showed() throws Throwable {
		int rowCount = driver
				.findElements(By.xpath("/html/body/div/div/div/main/div/div/div/div[3]/div/div/div/div[1]/span"))
				.size();
		System.out.println("Total rows = " + rowCount);
		int colCount = driver
				.findElements(By.xpath("/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[4]/div/span"))
				.size();
		System.out.println("Total cols = " + colCount);

		int sheet = 2;
		int row = 7;
		int col = 0;

		if (rowCount > 0 && colCount > 0 && Reptyp.equals(" Total Universe")) {
			ExcelLoadUtil excelUtil = new ExcelLoadUtil();
			excelUtil.setExcelFile(Constant.Path_EBITDA_PPMSimple + Constant.File_EBITDA_PPMSimple);
			for (int x = 4; x < rowCount + 3; x++) {
				int frntAcqYear = Utility.converttoint(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[1]/span"))
						.getText());
				System.out.println(frntAcqYear);
				int excAcqYear = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col).intValue();
				System.out.println(excAcqYear);
				int frntCmpCnt = Utility.converttoint(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[2]/span"))
						.getText());
				System.out.println(frntCmpCnt);
				int excCmpCnt = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 1)
						.intValue();
				System.out.println(excCmpCnt);
				double frntAvg = Utility.converttodouble(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[3]/span"))
						.getText());
				System.out.println(frntAvg);
				double excAvg = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 2)
						.doubleValue();
				DecimalFormat df = new DecimalFormat("###.##");
				String excAvgdecimal = df.format(excAvg);
				double d = Double.parseDouble(excAvgdecimal);
				System.out.println(d);
				Utility.intareEqual(frntAcqYear, excAcqYear);
				Utility.intareEqual(frntCmpCnt, excCmpCnt);
				Utility.intareEqual(frntAvg, d);
				row++;
			}
		} else if (rowCount > 0 && colCount > 0 && Reptyp.equals(" Company Type")) {
			ExcelLoadUtil excelUtil = new ExcelLoadUtil();
			excelUtil.setExcelFile(Constant.Path_EBITDA_PPMComptypSimple + Constant.File_EBITDA_PPMComptypSimple);
			for (int x = 4; x < rowCount + 3; x++) {
				String frntCmpType = driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[1]/span"))
						.getText();
				System.out.println(frntCmpType);
				String excCmpType = ExcelUtils.getStringCellValue(excelUtil.getExcelWBook(), sheet, row, col)
						.toString();
				System.out.println(excCmpType);
				int frntAcqYear = Utility.converttoint(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[2]/span"))
						.getText());
				System.out.println(frntAcqYear);
				int excAcqYear = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 1)
						.intValue();
				System.out.println(excAcqYear);
				int frntCmpCnt = Utility.converttoint(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[3]/span"))
						.getText());
				System.out.println(frntCmpCnt);
				int excCmpCnt = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 2)
						.intValue();
				System.out.println(excCmpCnt);
				double frntAvg = Utility.converttodouble(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[4]/span"))
						.getText());
				System.out.println(frntAvg);
				double excAvg = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 3)
						.doubleValue();
				DecimalFormat df = new DecimalFormat("###.##");
				String excAvgdecimal = df.format(excAvg);
				double d = Double.parseDouble(excAvgdecimal);
				System.out.println(d);
				Utility.intareEqual(frntAcqYear, excAcqYear);
				Utility.intareEqual(frntCmpCnt, excCmpCnt);
				Utility.intareEqual(frntAvg, d);
				row++;
			}

		} else if (rowCount > 0 && colCount > 0 && Reptyp.equals(" Sector")) {
			ExcelLoadUtil excelUtil = new ExcelLoadUtil();
			excelUtil.setExcelFile(Constant.Path_EBITDA_PPMSectorSimple + Constant.File_EBITDA_PPMSectorSimple);
			for (int x = 4; x < rowCount + 3; x++) {
				String frntSector = driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[1]/span"))
						.getText();
				System.out.println(frntSector);
				String excSector = ExcelUtils.getStringCellValue(excelUtil.getExcelWBook(), sheet, row, col).toString();
				System.out.println(excSector);
				int frntAcqYear = Utility.converttoint(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[2]/span"))
						.getText());
				System.out.println(frntAcqYear);
				int excAcqYear = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 1)
						.intValue();
				System.out.println(excAcqYear);
				int frntCmpCnt = Utility.converttoint(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[3]/span"))
						.getText());
				System.out.println(frntCmpCnt);
				int excCmpCnt = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 2)
						.intValue();
				System.out.println(excCmpCnt);
				double frntAvg = Utility.converttodouble(driver
						.findElement(By.xpath(
								"/html/body/div/div/div/main/div/div/div/div[3]/div/div/div[" + x + "]/div[4]/span"))
						.getText());
				System.out.println(frntAvg);
				double excAvg = ExcelUtils.getDoubleCellValue(excelUtil.getExcelWBook(), sheet, row, col + 3)
						.doubleValue();
				DecimalFormat df = new DecimalFormat("###.##");
				String excAvgdecimal = df.format(excAvg);
				double d = Double.parseDouble(excAvgdecimal);
				System.out.println(d);
				Utility.intareEqual(frntAcqYear, excAcqYear);
				Utility.intareEqual(frntCmpCnt, excCmpCnt);
				Utility.intareEqual(frntAvg, d);
				row++;
			}
		} else {
			System.out.println("Report " + Reptyp + "is empty");
		}

		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}