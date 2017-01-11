package com.cucumber.testng.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.testng.pageobjects.Reviewerqueue_PO;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class OMValidate_queues {

	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	String Filter;
	String SlctCriteria;
	String SrtOption;

	public OMValidate_queues() {
		driver = BaseStepDefs.driver;

	}

	@Given("^User is on the queue ([^\"]*)$")
	public void User_is_on_the_queue(String Queue) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		// now perform the action on this element
		boolean Revpresent = Utilities.Utility.elementIsPresent(Reviewerqueue_PO.tab_Review);
		boolean Excpresent = Utilities.Utility.elementIsPresent(Reviewerqueue_PO.tab_Exception);
		boolean Quapresent = Utilities.Utility.elementIsPresent(Reviewerqueue_PO.tab_Quality);
		Thread.sleep(2000);
		if (Queue.equals("REVIEW") && Revpresent == true) {

			Reviewerqueue_PO.tab_Review.click();
			String QRev = Reviewerqueue_PO.tab_Review.getText();
			Assert.assertEquals(QRev, Queue);
			String CurrURL = driver.getCurrentUrl();
			Assert.assertEquals("http://omdev.ca-labs.com/app/queue/reviewer", CurrURL);
			System.out.println("Current Queue URL " + CurrURL);
			System.out.println("Queue selected " + QRev);
		} else if (Queue.equals("EXCEPTION") && Excpresent == true) {

			Reviewerqueue_PO.tab_Exception.click();
			String QExce = Reviewerqueue_PO.tab_Exception.getText();
			Assert.assertEquals(QExce, Queue);
			String CurrURL = driver.getCurrentUrl();
			Assert.assertEquals("http://omdev.ca-labs.com/app/queue/exception", CurrURL);
			System.out.println("Current Queue URL " + CurrURL);
			System.out.println("Queue selected " + QExce);
		} else if (Queue.equals("QUALITY") && Quapresent == true) {

			Reviewerqueue_PO.tab_Quality.click();
			String QQua = Reviewerqueue_PO.tab_Quality.getText();
			Assert.assertEquals(QQua, Queue);
			String CurrURL = driver.getCurrentUrl();
			Assert.assertEquals("http://omdev.ca-labs.com/app/queue/qc", CurrURL);
			System.out.println("Current Queue URL " + CurrURL);
			System.out.println("Queue selected " + QQua);
		}
	}

	@Then("^User selects Filter by ([^\"]*)$")
	public void user_selects_Filter_by(String Filter1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Reviewerqueue_PO.ddwn_Filter1.click();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30); Boolean element =
		 * wait
		 * .until(ExpectedConditions.textToBePresentInElement(Reviewerqueue_PO.
		 * ddwn_Filter1, Filter1)); // elementToBeClickable(By.id("someid")
		 */
		Filter = Filter1;
		new Select(Reviewerqueue_PO.ddwn_Filter1).selectByVisibleText(Filter1);

		/*
		 * boolean Filterpresent =
		 * Utilities.Utility.elementIsPresent(Reviewerqueue_PO.ddwn_Filter1); if
		 * (Filterpresent == true && element == true) { new
		 * Select(Reviewerqueue_PO.ddwn_Filter1)Filter1.selectByVisibleText(
		 * Filter1); System.out.println("Element " + Filter1 + " present"); }
		 * else { System.out.println("No " + Filter1 + " present"); }
		 */
	}

	@And("^User selects the status ([^\"]*)$")
	public void user_selects_the_status(String Filter2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		// new
		// Select(Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText(Filter2);
		Reviewerqueue_PO.ddwn_Filter2.click();
		new Select(Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText(Filter2);
		Thread.sleep(2000);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30); Boolean element =
		 * wait
		 * .until(ExpectedConditions.textToBePresentInElement(Reviewerqueue_PO.
		 * ddwn_Filter2, Filter2)); boolean Filterpresent =
		 * Utilities.Utility.elementIsPresent(Reviewerqueue_PO.ddwn_Filter2); if
		 * (Filterpresent == true && element == true) { new
		 * Select(Reviewerqueue_PO.ddwn_Filter2).selectByVisibleText(Filter2);
		 * System.out.println("Element " + Filter2 + " present"); } else {
		 * System.out.println("No " + Filter2 + " present"); }
		 */

	}

	@Then("^Only the firms showed with Filter ([^\"]*)$")
	public void only_the_firms_showed_with_Filter(String Stat) throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		int rowcount = driver.findElements(By.xpath("html/body/div/div/div/main/div/section/div/div/div/div")).size();
		// Select se = new Select(Reviewerqueue_PO.ddwn_Filter1);
		// WebElement strCurrentValue = se.getFirstSelectedOption();

		if (rowcount > 0) {
			System.out.println("Total firms Filtered by " + Filter + " " + Stat + " " + (rowcount - 5));
		} else {
			System.out.println("Not firms Filtered by " + Filter + " " + Stat);
		}

	}

	@Then("^check the fields displayed within a firm$")
	public void check_the_fields_displayed_within_a_firm() throws Throwable {
		int rowcount = driver.findElements(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div"))
				.size();
		if (rowcount > 0)
			for (int x = 6; x < rowcount + 1; x++) {
				String Compname = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[1]/div[1]/h3"))
						.getText();
				String NumFunds = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[2]/div/p"))
						.getText();
				String FundTyp = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[3]/div/p"))
						.getText();
				String SubmDt = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[4]/div/p"))
						.getText();
				String Status = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[1]/div[2]/p"))
						.getText();
				System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
						+ " Status " + Status);
			}
		else {
			System.out.println("Verification Failed - No Fields found");
		}
	}

	@When("^User selects Sort by ([^\"]*)$")
	public void user_selects_Sort_by_Number_of_Funds(String Sort) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		new Select(Reviewerqueue_PO.ddwn_Sort).selectByVisibleText(Sort);
		SrtOption = Sort;
		// throw new PendingException();
	}

	@When("^User selects the criteria ([^\"]*)$")
	public void user_selects_the_criteria_Ascending(String Criteria) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SlctCriteria = Criteria;
		if (Criteria.equals("Ascending")) {
			Reviewerqueue_PO.chk_Ascending.click();
		} else if (Criteria.equals("A-Z")) {
			Reviewerqueue_PO.chk_AZ.click();
		} else if (Criteria.equals("Descending")) {
			Reviewerqueue_PO.chk_Descending.click();
		} else if (Criteria.equals("Z-A")) {
			Reviewerqueue_PO.chk_ZA.click();
		}
		Thread.sleep(2000);
	}

	@Then("^Only the firms showed with Sort ([^\"]*)$")
	public void only_the_firms_showed_with_Sort(String Sorting) throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		int rowcount = driver.findElements(By.xpath("html/body/div/div/div/main/div/section/div/div/div/div")).size();
		// Select se = new Select(Reviewerqueue_PO.ddwn_Filter1);
		// WebElement strCurrentValue = se.getFirstSelectedOption();

		if (rowcount > 0) {
			System.out.println("Total firms Sorted by " + Sorting + " " + SlctCriteria + " " + (rowcount - 5));
		} else {
			System.out.println("Not firms Sorted by " + Sorting + " " + SlctCriteria);
		}
	}

	@Then("^check the fields Sorted within a firm$")
	public void check_the_fields_Sorted_within_a_firm() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		int rowcount = driver.findElements(By.xpath("//div[@id='app']/div/div/main/div/section/div/div/div/div"))
				.size();
		if (rowcount > 0)
			for (int x = 6; x < rowcount + 1; x++) {
				String Compname = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[1]/div[1]/h3"))
						.getText();
				String NumFunds = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[2]/div/p"))
						.getText();
				String FundTyp = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[3]/div/p"))
						.getText();
				String SubmDt = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[4]/div/p"))
						.getText();
				String Status = driver
						.findElement(By.xpath(
								"html/body/div/div/div/main/div/section/div/div/div/div[" + x + "]/div[1]/div[2]/p"))
						.getText();
				if ((SlctCriteria.equals("Ascending") && SrtOption.equals("Number of Funds"))) {

					System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
							+ " Status " + Status);
				} else if ((SlctCriteria.equals("Descending") && SrtOption.equals("Number of Funds"))) {
					System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
							+ " Status " + Status);
				} else if ((SlctCriteria.equals("A-Z") && SrtOption.equals("Firm Name"))) {

					System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
							+ " Status " + Status);
				} else if ((SlctCriteria.equals("Z-A") && SrtOption.equals("Firm Name"))) {
					System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
							+ " Status " + Status);
				} else if ((SlctCriteria.equals("Ascending") && SrtOption.equals("Submitted Date"))) {

					System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
							+ " Status " + Status);
				} else if ((SlctCriteria.equals("Descending") && SrtOption.equals("Submitted Date"))) {
					System.out.println("Company " + Compname + " has " + NumFunds + " and " + FundTyp + " and " + SubmDt
							+ " Status " + Status);
				}
			}
		else {
			System.out.println("Verification Failed - No Fields found");
		}
	}

	// int eleCount;
	// List<String> customerNameA = new ArrayList();
	// List<String> customerNameB = new ArrayList();
	//
	// // Check for our Customer elements and count them.... replace xxx with
	// your xpath
	// Assert.assertTrue(Utilities.Utility.isElementPresent(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div")));
	// List<WebElement> elements =
	// driver.findElements(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div/div[2]/div/p/span"));
	//
	// eleCount = elements.size();
	// System.out.println("Element count: " + eleCount);
	//
	// for(int i = 5; i < eleCount; i++){
	// //Capture the customer name values
	// //replace xxx with your xpath & replace the value increments for each
	// element in xpath with + i +
	//
	// customerNameA.add(driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+i+"]/div[2]/div/p/span")).getText());
	// System.out.println(driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+i+"]/div[2]/div/p/span")).getText());
	// customerNameB.add(driver.findElement(By.xpath("html/body/div[1]/div/div/main/div/section/div/div/div/div["+i+"]/div[2]/div/p/span")).getText());
	//
	// }
	// Collections.sort(customerNameA);
	//
	// for (int i=0;i<customerNameA.size();i++) {
	// System.out.println("Customer Name from input: " + customerNameB.get(i) +
	// "--Customer Name from sorted input: " + customerNameA.get(i));
	// if (!(customerNameA.get(i).equals(customerNameB.get(i)))) {
	// System.out.println("Customer Names not sorted: " + i);
	// break;
	//
	// }
	// }

	// throw new PendingException();
}
