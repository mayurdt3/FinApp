package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.remo.Test.BaseTest;
import reporter.ExtentUtility;

public class MultipleLogin extends BaseTest {

	/**
	 * Initializes the Extent report and sets up the WebDriver based on the
	 * specified browser.
	 *
	 * @param browser The name of the browser (e.g., "chrome").
	 */

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(String env, String browser) {
		ExtentUtility.createReport("Multiple Login", env, browser);

	}

	/**
	 * Provides test data for multiple logins from an Excel sheet named
	 * "MultipleLogin".
	 *
	 * @return Two-dimensional array containing login test data.(Row and column)
	 */

	@DataProvider(name = "loginTestData")
	public Object[][] getLoginTestData() {
		return excel.getUserLoginTestData("MultipleLogin");
	}

	/**
	 * Test method to verify multiple logins.
	 *
	 * @param username The username for the login.
	 * @param password The password for the login.
	 * @param dba      The information.
	 * @param mid      The Merchant ID.
	 */

	@Test(priority = 1, dataProvider = "loginTestData")

	public void verifyMultipleLogin(String username, String password, String dba, String mid) {

		test = extent.createTest("Login as : " + username);

		assertTrue(login.verifyMultipleLoginMethod(username, password));
		// test = extent.createTest("Information of merchant");
		// soft.assertTrue(home.verifyDbaName(dbaName));
		// soft.assertTrue(home.verifyDbaAddress(dba));
		assertTrue(home.verifyMid(mid));
		assertTrue(login.verifyLogout());

	}

}
