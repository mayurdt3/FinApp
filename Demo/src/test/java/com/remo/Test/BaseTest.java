package com.remo.Test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.remo.PageLayer.Dashboard;
import com.remo.PageLayer.PartnerHub;
import com.remo.PageLayer.ReportsPage;
// import com.remo.PageLayer.ReportsPage;
import com.remo.base.BaseClass;
import com.remo.driverManager.DriverManager;
import com.remo.reader.ConfigUtil;
import com.remo.reader.ExcelFileReader;
import com.remo.utility.Utility;

/**
 * Base test class serving as the foundation for all test classes.
 * 
 * This class provides common setup and tear down methods, ExtentReport
 * configuration, Logs, screenshot on failure configuration and flush methods,
 * property Configuration and Utilities that are shared across multiple test
 * cases. It follows the Test Automation Framework design pattern, promoting
 * code re usability and maintainability.
 * 
 * @author Remosys Testing Team
 *
 *         Usage: 1. Extend this class when creating specific test classes for
 *         different test scenarios. 2. Implement test cases by defining methods
 *         that perform specific actions and verifications. 3. Organize your
 *         test cases into specific test classes, each focusing on a particular
 *         application.
 * 
 */
public class BaseTest extends BaseClass {



	/**
	 * This method sets up the WebDriver instance with the specified browser. It
	 * initializes the driver, maximizes the window, deletes all cookies, sets
	 * timeouts, and initializes various utility and page objects.
	 *
	 * @param The name of the browser to initialize (default is "chrome").
	 */
	@BeforeClass
	@Parameters({ "browserName", "headless" })

	public void setUp(@Optional("chrome") String browser, @Optional("false") Boolean headless) {

		manager = new DriverManager(driver);
		super.driver = manager.initializeDriver(browser, headless);
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		/*
		 * Set custom window size if needed
		 * 
		 * // Dimension resolution = new Dimension(1920, 1000); //
		 * driver.manage().window().setSize(resolution);
		 * 
		 */

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		util = new Utility();
		prop = new ConfigUtil();
		excel = new ExcelFileReader();

		reportsP = new ReportsPage(driver);
		dashboard = new Dashboard(driver);
		partnerH = new PartnerHub(driver);

	}

	/**
	 * Handles test result status and logs it in the test report.
	 * 
	 * @param result
	 */
	@AfterMethod
	public void testResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL", ExtentColor.RED));
			// String path = util.takeScreenshot(driver);

			// test.addScreenCaptureFromPath(path);
			util.addBase64ScreenShotToReport(driver, test, result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS", ExtentColor.GREEN));
			// test.pass(result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP", ExtentColor.YELLOW));
			// test.skip(result.getName());
		} else {

		}

	}

	/**
	 * This method will close the browser Instance After execution of each test
	 * Class
	 */
	@AfterClass
	public void quit() {

		driver.quit();
		extent.flush();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public boolean checkBrokenImages() {
		return util.checkBrokenImages(driver, test);
	}

	/**
	 * This method will launch the given url
	 * 
	 * @param url
	 */
	public void launchApp(String url) {

		driver.get(prop.getProperty(url));
		util.waitForDomToLoad(driver);

	}

}
