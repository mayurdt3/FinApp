package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.remo.Test.BaseTest;
import com.aventstack.extentreports.Status;
import reporter.ExtentUtility;

public class HomePageTest extends BaseTest {

	SoftAssert soft = new SoftAssert();

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("QAURL") String env, @Optional("Chrome") String browser) {
		ExtentUtility.createReport("M360Test", env, browser);
	}

	@Test(priority = 0)
	@Parameters("environment")
	public void VerifyLogin(@Optional("QAURL") String env) {
		test = extent.createTest("Login");
		// util.setWindowresolution(driver,50);

		login.loginVerification(env, "Username", "Password");

		SoftAssert s = new SoftAssert();

		s.assertTrue(home.isUserProfileIconDisplayed());
		s.assertTrue(checkBrokenImages());
		// s.assertTrue(home.isBusinessOverviewInfoDisplayed());

		s.assertAll();

	}

	// @Test(priority = 1)

	public void VerifyBrokenImageOnHomePage() {
		test = extent.createTest("Check for Broken images on Home Page");
		assertTrue(checkBrokenImages());

	}

	@Test(priority = 1, dependsOnMethods = "VerifyLogin")
	public void VerifyVisibilityOfDBA_Details() {
		// test = extent.createTest("Verify Visibility of DBA Details");

		SoftAssert s = new SoftAssert();

		s.assertTrue(home.isDBA_NameIsVisible());

		s.assertTrue(home.isDBA_AddressVisible());

		s.assertTrue(home.isMIDVisible());

		s.assertAll();
	}

	// @Test(priority = 1, dependsOnMethods = "VerifyLogin")
	public void verifyNotificationFunctionality() {
		// test = extent.createTest("Verify Notification Functionality");
		assertTrue(home.verifyNotificationDropdown());

	}

	// @Test(priority = 2, dependsOnMethods = "VerifyLogin")
	public void verifyProfileDropdown() {
		assertTrue(home.visibilityOfUserProfileDropdown());

	}

	@Test(priority = 3, dependsOnMethods = "VerifyLogin")
	public void VerifyVisibilityOfSearchBar() {
		assertTrue(home.isSearchbarVisible());
	}

	@Test(priority = 4, dependsOnMethods = "VerifyLogin")
	public void verifyVisibilityOfSideMenuBar() {

		// test = extent.createTest("Verify Visibility of Side Menu bar Options");
		assertTrue(home.isSideBarOptionsDisplayed());

	}

	@Test(priority = 6, dependsOnMethods = "VerifyLogin")
	public void verifyLinkValidationOfSideMenuBar() {
		// test = extent.createTest("Verify Visibility of Side Menu bar Options");
		assertTrue(home.linkValidationForSideBar());

	}

	// @Test(priority = 5, dependsOnMethods = "VerifyLogin")
	public void businessOverview() {
		assertTrue(home.verifyBusinessOverviewFunctionality());
	}

	// @Test(priority = 8, dependsOnMethods = "VerifyLogin")
	public void verifyProductBarNavigation() {
		// test = extent.createTest("Verify navigation functionality of product cards");
		assertTrue(home.productNavigation());

	}

	// @Test(priority = 7, dependsOnMethods = "VerifyLogin")
	public void verifyAllProducts() {
		// test = extent.createTest("Verify all Product card");

		// assertTrue(home.verifyNumberOfProducts() );

		assertTrue(home.VerifyProductsWidgetsIsVisible());

	}

	// @Test(priority = 7)
	public void verifyActiveProducts() {
		// test = extent.createTest("Verify Active Product card");

		assertTrue(home.verifyActiveProductsAreDisplayedOptionl());

	}

	// @Test(priority = 8)
	public void verifyCountOfActiveEPIServices() {
		// test = extent.createTest(
		// "Verify if Active product count from home page matches with count of product
		// displayed in user profile");
		if (home.verifyNumberOfActiveProductsInUseProfile()) {
			test.log(Status.PASS,
					"Count of active Active product cards displayed on the homepage matches with the count in user profile");
		} else {
			test.log(Status.FAIL, "active product count does not match");
			assertTrue(home.verifyNumberOfActiveProductsInUseProfile());
		}
	}

	// @Test(priority = 9)
	public void verifyLinkValidationOfActiveProducts() {
		// test = extent.createTest("Verify link validation of active product cards");
		assertTrue(home.linkValidationOfActiveProducts());

	}

	// @Test(priority = 10)
	public void verify15DaysAnalysis() {
		// test = extent.createTest("Verify 14 Day Trend Analysis Cards");

		SoftAssert s = new SoftAssert();
		s.assertTrue(home.isTrendAnalysisHeaderVisible());

		s.assertTrue(home.isTrendAnalysisTransactionCardVisible());

		s.assertTrue(home.isTrendAnalysisAverageTicketCardVisible());

		s.assertTrue(home.isTrendAnalysisTotalSalesCardVisible());

		s.assertTrue(home.isTrendAnalysisRefundCardVisible());

		// test.log(Status.PASS, "14 Days Trend Analysis is displayed");
		s.assertAll();

	}

	// @Test(priority = 11, dependsOnMethods = "VerifyLogin")
	public void paylyticsSalesForecaster() {
		// test = extent.createTest("Verify Paylytics Sales Forecaster card");
		assertTrue(home.isPaylyticsSalesForecasterVisible());
	}

	// @Test(priority = 12)
	public void Logout() {

		assertTrue(login.verifyLogout());

	}

	// @DataProvider(name = "DBA_details")
	// public Object[][] getDBAtestData(){
	// return excel.getTestData("DBA_Details");
	// }
	//
	// @Test(dataProvider = "DBA_details",priority=1)
	// public void VerifySearchDBAFunctionality(String last4DigitOfMid,String
	// DBAname) {
	// login.launchApp("DevURL");
	// login.loginMethod("Username","Password");
	// test = extent.createTest("Verify Search Functionality ");
	// home.searchMID("6906");
	// //home.getFromListOfDBA();
	//
	// }

}
