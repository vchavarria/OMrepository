package com.cucumber.testng.examples;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by amit.rawat on 21/12/15.
 */
public class BaseTestCase {
	/* static WebDriver driver; */
	/* public String BaseURL = "http://omdev.ca-labs.com/app/queue/reviewer"; */
	public static WebDriver driver;
	/*
	 * Reviewerqueue_PO Reviewer_queuePO; Login_Page_pageobj LoginpagePO;
	 */

	//// private static final Properties frameworkProperty = PropertyManager
	//// .loadFrameworkPropertyFile("framework.properties");
	// protected static final Logger log = Logg.createLogger();
	// protected final static Utilities util = new Utilities();
	// protected static String[][] strorage = null;
	// private static final String dateAndTimeFormat = "MM-dd-yyyy_hh.mm.ss";
	// protected final static Properties applicationProperty = PropertyManager
	// .loadApplicationPropertyFile("application.properties");
	//
	// @DataProvider(name = "ReadExcel")
	// public String[][] readDataFromExcel(Method m) throws Exception {
	// log.info(Utilities.getCurrentThreadId() + "Data Provider: Read Excel");
	// log.info(Utilities.getCurrentThreadId()
	// + "Data Provider: Running for Method: " + m.getName());
	// if ("enterAndValidateUniversityData".equals(m.getName())) {
	// strorage = ReadExcel.readTestData("Customer");
	// log.info(Utilities.getCurrentThreadId()
	// + "Data Provider: Retrieved data from the Customer Sheet of Test Data
	//// Excel");
	// } else if ("".equals(m.getName())) {
	// strorage = ReadExcel.readTestData("Sheet2");
	// } else {
	// log.info(Utilities.getCurrentThreadId()
	// + "NO MATCHING METHOD FOUND. PLEASE CHECK THE METHOD NAME IN THE DATA
	//// PROVIDER");
	// }
	// return strorage;
	// }
	//
	// protected void logErrorMessage(Throwable ex) {
	// StringWriter stw = new StringWriter();
	// PrintWriter pw = new PrintWriter(stw);
	// ex.printStackTrace(pw);
	// log.error(stw.toString());
	// }
	//
	// protected static WebDriver getWebDriverInstance(ITestContext context) {
	// return (WebDriver) context.getAttribute(context.getCurrentXmlTest()
	// .getName());
	// }
	//
	@BeforeTest
	/* public void beforetest() { */

	/* @Parameters("executionType", "browser") */
	/*
	 * protected void beforeTest(@Optional("local") String
	 * executionTypebrowsername, ITestContext context, String browsername)
	 * throws Exception {
	 */
	/*
	 * Browser browser = new Browser(
	 * frameworkProperty.getProperty("browserName"),
	 * frameworkProperty.getProperty("browserVersion"), Platform.WINDOWS);
	 * DriverFactory factory = new DriverFactory(); IDriver idriver =
	 * factory.getDriver(executionType); WebDriver driver =
	 * idriver.getDriver(browser);
	 * context.setAttribute(context.getCurrentXmlTest().getName(), driver); }
	 */
	// System.setProperty("webdriver.chrome.driver",
	// "C://Users/vchavarria/Downloads/Maven-Failsafe-Plugin-Example-master/resources/com/drivers/chromedriver.exe");
	// driver = new ChromeDriver();
	/*
	 * if (browsername.equalsIgnoreCase("firefox")){ driver = new
	 * FirefoxDriver(); } else if (browsername.equalsIgnoreCase("chrome")){
	 * System.setProperty("webdriver.chrome.driver",
	 * "C://Users/vchavarria/Downloads/Maven-Failsafe-Plugin-Example-master/src/test/resources/com/drivers/chromedriver.exe"
	 * ); driver = new ChromeDriver(); } else if
	 * (browsername.equalsIgnoreCase("ie")){
	 * System.setProperty("webdriver.ie.driver",
	 * "C://Users/vchavarria/Downloads/Maven-Failsafe-Plugin-Example-master/src/test/resources/com/drivers/IEDriverServer.exe"
	 * ); driver = new InternetExplorerDriver(); }
	 * 
	 * //driver = new FirefoxDriver(); driver.manage().deleteAllCookies();
	 * driver.manage().window().maximize(); driver.get(BaseURL);
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * System.out.println(driver.getTitle()); Reviewer_queuePO =
	 * PageFactory.initElements(driver, Reviewerqueue_PO.class); LoginpagePO =
	 * PageFactory.initElements(driver, Login_Page_pageobj.class); }
	 */
	/* } */

	@AfterTest
	protected void afterTest(ITestContext context) {
		// WebDriver driver = getWebDriverInstance(context);
		// log.info(Utilities.getCurrentThreadId() + "Closing the instance:"
		// + webdriver.toString());
		/* driver.quit(); */
		// context.removeAttribute(context.getCurrentXmlTest().getName());
	}

	//
	@AfterMethod
	// protected File afterMethod(ITestResult result) throws IOException {
	// WebDriver webdriver = getWebDriverInstance(result.getTestContext());
	// if (result.isSuccess()) {
	// return ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
	// }
	// if ("remote".equals(frameworkProperty.getProperty("executionType")))
	// webdriver = new Augmenter().augment(webdriver);
	// String dateAndTime = DateAndTime
	// .getFormattedCurrentDateAndTime(dateAndTimeFormat);
	// File screenshot = ((TakesScreenshot) webdriver)
	// .getScreenshotAs(OutputType.FILE);
	// String screenShotName = Utilities.getCurrentThreadId().replace(":", "")
	// .replace("\t", "")
	// + dateAndTime + ".png";
	// FileUtils.copyFile(screenshot, new File("./screenshots/"
	// + screenShotName));
	// return screenshot;
	//

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is beforeSuite of Base Test Case");

		/*
		 * assertEquals(driver.getTitle(), "Cambridge Associates - Sign In");
		 * Login_Page_pageobj.txtbx_UserName(driver).clear();
		 * Login_Page_pageobj.txtbx_UserName(driver).sendKeys("vchavarria");
		 * Login_Page_pageobj.txtbx_Password(driver).clear();
		 * Login_Page_pageobj.txtbx_Password(driver).sendKeys("Daniel2007");
		 * Login_Page_pageobj.btn_LogIn(driver).click();
		 * Utility.isAlertPresent(driver); Utility.handleAlert(driver);
		 * assertEquals(driver.getTitle(), "Operating Metrics");
		 */
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This is afterSuite of Base Test Case");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is beforeClass of Base Test Case");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is beforeMethod of Base Test Case");

	}
}
