package com.remo.TestLayer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.remo.Test.BaseTest;
import com.aventstack.extentreports.Status;
import reporter.ExtentUtility;

public class Regression extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("M360" + env + " Regression", env, browser);
		test = extent.createTest("Verify launch application");
		assertTrue(login.verifyLaunchApplication(env));
		util.addBase64ScreenShotToReport(driver, test, "LauchApplication");
	}

	// @Test(priority = -4)

	public void verifyBrokenImageOnLoginPage() {
		test = extent.createTest("Check for Broken images on Login Page");
		// util.addScreenShotToReport(driver, test);
		assertTrue(checkBrokenImages());

	}

	@Test(priority = -3)

	public void verifyInvalidLogin() {
		test = extent.createTest("Login with invalid UserName");

		assertTrue(login.verifyInvalidLogin("InvalidUsername", "Password"));
		util.addBase64ScreenShotToReport(driver, test, "Invalid Username");
		driver.navigate().refresh();
		util.waitForDomToLoad(driver);
	}

	@Test(priority = -2)

	public void verifyLoginWithIncorrectPassword() {
		test = extent.createTest("Login with Incorrect Password");

		assertTrue(login.verifyInvalidLogin("Username", "WrongPassword"));
		util.addBase64ScreenShotToReport(driver, test, "Incorrect password");
		driver.navigate().refresh();
		util.waitForDomToLoad(driver);
	}

	@Test(priority = -1)

	public void verifyLoginWithInvalidPassword() {
		test = extent.createTest("Login with invalid Password");

		assertTrue(login.verifyInvalidLogin("Username", "InvalidPassword"));
		util.addBase64ScreenShotToReport(driver, test, "Invalid password");
		driver.navigate().refresh();
		util.waitForDomToLoad(driver);
	}

	@Test(priority = 0)

	public void verifyLogin() {
		SoftAssert s = new SoftAssert();
		test = extent.createTest("Login with valid data");
		assertTrue(login.login("Username", "Password"));
		s.assertTrue(home.isUserProfileIconDisplayed());
		s.assertTrue(home.isBusinessOverviewInfoDisplayed());
		s.assertAll();

		util.addBase64ScreenShotToReport(driver, test, "Dashboard");
	}

	// @Test(priority = 1, dependsOnMethods = "verifyLogin")

	public void verifyBrokenImageOnHomePage() {
		test = extent.createTest("Check for Broken images on Home Page");
		assertTrue(checkBrokenImages());
	}

	@Test(priority = 1, dependsOnMethods = "verifyLogin")
	public void verifyVisibilityOfDBA_Details() {
		test = extent.createTest("Verify Visibility of DBA Details");

		SoftAssert s = new SoftAssert();

		s.assertTrue(home.isDBA_NameIsVisible());
		s.assertTrue(home.isDBA_AddressVisible());
		s.assertTrue(home.isMIDVisible());
		s.assertAll();
	}

	@Test(priority = 2, dependsOnMethods = "verifyLogin")
	public void verifyNotificationFunctionality() {
		test = extent.createTest("Verify Notification Functionality");
		assertTrue(home.verifyNotificationDropdown());

	}

	@Test(priority = 3, dependsOnMethods = "verifyLogin")
	public void verifyProfileDropdown() {
		test = extent.createTest("Verify Functionality of 'User Profile' dropdown");
		assertTrue(home.visibilityOfUserProfileDropdown());

	}

	@Test(priority = 4, dependsOnMethods = "verifyLogin")
	public void VerifyVisibilityOfSearchBar() {
		test = extent.createTest("Verify Visibility of Search bar");
		assertTrue(home.isSearchbarVisible());
	}

	@Test(priority = 5, dependsOnMethods = "verifyLogin")
	public void verifyVisibilityOfSideMenuBar() {

		test = extent.createTest("Verify Visibility of Side bar Options");

		assertTrue(home.isSideBarOptionsDisplayed());

	}

	@Test(priority = 6, dependsOnMethods = "verifyLogin")
	public void verifyLinkValidationOfSideMenuBar() {
		test = extent.createTest("Verify link validation of Side menu bar Options");
		assertTrue(home.linkValidationForSideBar());

	}

	@Test(priority = 7, dependsOnMethods = "verifyLogin")
	public void businessOverview() {
		test = extent.createTest("Verify functionality of Business Overview Filter");
		assertTrue(home.verifyBusinessOverviewFunctionality());
	}

	@Test(priority = 8, dependsOnMethods = "verifyLogin")
	public void verifyProductBarNavigation() {
		test = extent.createTest("Verify Navigation Functionality of product cards");
		assertTrue(home.productNavigation());

	}

	@Test(priority = 9, dependsOnMethods = "verifyLogin")
	public void verifyAllProducts() {
		test = extent.createTest("Verify all Product cards");

		// home.verifyNumberOfProducts() &&
		assertTrue(home.VerifyProductsWidgetsIsVisible());

	}

	@Test(priority = 10, dependsOnMethods = "verifyLogin")
	public void verify15DaysAnalysis() {
		test = extent.createTest("Verify 15 Days Trend Analysis Cards");

		SoftAssert s = new SoftAssert();
		s.assertTrue(home.isTrendAnalysisHeaderVisible());
		s.assertTrue(home.isTrendAnalysisTransactionCardVisible());
		s.assertTrue(home.isTrendAnalysisAverageTicketCardVisible());
		s.assertTrue(home.isTrendAnalysisTotalSalesCardVisible());
		s.assertTrue(home.isTrendAnalysisRefundCardVisible());

		s.assertAll();
	}

	@Test(priority = 11, dependsOnMethods = "verifyLogin")
	@Parameters("environment")

	public void verifyTransactonsGraph() {
		test = extent.createTest("Verify Transactions graph");

		home.getTrasactionsDataFromGraph("Average Transactions");
		List<String> dates = home.getTooltipDate();
		List<String> transactions = home.getTooltipValue();
		List<String> salesItemsList = new ArrayList<String>();
		reportsP.navigateTo_TotalsSummaryReport();
		for (int i = 0; i < dates.size(); i++) {
			String date = dates.get(i);
			// String transaction = transactions.get(i);
			salesItemsList.add(reportsP.getDataFromReport(date, "Sales Items"));
		}

		for (int i = 0; i < transactions.size(); i++) {
			if (transactions.get(i).equals(salesItemsList.get(i))) {
				test.log(Status.PASS, "Trasactions on graph for date  " + dates.get(i) + ": " + transactions.get(i)
						+ " match with Sales Items form report : " + salesItemsList.get(i));
			} else {
				test.log(Status.FAIL, "Trasactions on graph for date  " + dates.get(i) + ": " + transactions.get(i)
						+ " does not match with  Sales Items form report : " + salesItemsList.get(i));
			}
		}
		if (transactions.equals(salesItemsList)) {
			test.log(Status.PASS,
					"Sales items from the Totals Summary report and transaction count from the trend analysys is same");
		} else {
			test.log(Status.FAIL,
					"Transaction count from graph and Sales Items from Total Summary reportdose does not match");
		}
		assertEquals(transactions, salesItemsList);

	}

	@Test(priority = 12, dependsOnMethods = "verifyLogin")
	public void verifyTotalSalesGraph() {
		test = extent.createTest("Verify Total Sales graph");
		home.getTrasactionsDataFromGraph("Average Total Sales");
		List<String> dates = home.getTooltipDate();
		List<String> totalSales = home.getTooltipValue();
		List<String> salesAmount = new ArrayList<String>();
		reportsP.navigateTo_TotalsSummaryReport();
		// String date = home.getTooltipDate();
		// String totalSales = home.getTooltipValue();
		// String salesAmount = reportsP.getDataFromReport(date,"Sales
		// Amount").replace(",","");
		for (int i = 0; i < dates.size(); i++) {
			String date = dates.get(i);
			// String transaction = transactions.get(i);
			salesAmount.add(reportsP.getDataFromReport(date, "Sales Amount").replace(",", ""));
		}

		for (int i = 0; i < dates.size(); i++) {
			if (totalSales.get(i).equals(salesAmount.get(i))) {
				test.log(Status.PASS, "Total Sales on graph for date  " + dates.get(i) + ": " + totalSales.get(i)
						+ " match with Sales Amount form report : " + salesAmount.get(i));
			} else {
				test.log(Status.FAIL, "Total Sales on graph for date  " + dates.get(i) + ": " + totalSales.get(i)
						+ " does not match with Sales Amount form report : " + salesAmount.get(i));
			}
		}

		if (totalSales.equals(salesAmount)) {
			test.log(Status.PASS,
					"Sales Amount from the Totals Summary report and Total Sales from the trend analysys is same");
		} else {
			test.log(Status.FAIL, "Total Sales from graph and, Sales Amount from Total Summary report not match");
		}

		assertEquals(totalSales, salesAmount);

	}

	@Test(priority = 13, dependsOnMethods = "verifyLogin")
	public void verifyRefundsGraph() {
		test = extent.createTest("Verify Refunds Amount graph");

		home.getTrasactionsDataFromGraph("Average Refunds");

		reportsP.navigateTo_TotalsSummaryReport();
		List<String> dates = home.getTooltipDate();
		List<String> refunds = home.getTooltipValue();
		List<String> refundsAmount = new ArrayList<String>();

		for (int i = 0; i < dates.size(); i++) {
			String date = dates.get(i);
			// String transaction = transactions.get(i);
			if (reportsP.getDataFromReport(date, "Refunds Amount").replaceAll("[$-]", "").equals("0")) {
				refundsAmount.add("$0.00");
			} else {
				refundsAmount.add(reportsP.getDataFromReport(date, "Refunds Amount").replaceAll("[-]", ""));
			}
		}

		for (int i = 0; i < dates.size(); i++) {
			if (refunds.get(i).equals(refundsAmount.get(i))) {
				test.log(Status.PASS, "Total Sales on graph for date  " + dates.get(i) + ": " + refunds.get(i)
						+ " match with Sales Amount form report : " + refundsAmount.get(i));
			} else {
				test.log(Status.FAIL, "Total Sales on graph for date  " + dates.get(i) + ": " + refunds.get(i)
						+ "does not match with Sales Amount form report : " + refundsAmount.get(i));
			}
		}

		if (refunds.equals(refundsAmount)) {
			test.log(Status.PASS,
					"Refund Amount from the Totals Summary report and Refunds from the trend analysys is same");
		} else {
			test.log(Status.FAIL, "Refunds from graph, and Refund Amount from Total Summary report does not match");
		}
		assertEquals(refunds, refundsAmount);

	}

	@Test(priority = 14, dependsOnMethods = "verifyLogin")
	public void paylyticsSalesForecaster() {

		test = extent.createTest("Verify Paylytics Sales Forecaster card");
		assertTrue(home.isPaylyticsSalesForecasterVisible());
	}

	@Test(priority = 15, dependsOnMethods = "verifyLogin")
	public void verifyProfileSettingsNavigation() {
		test = extent.createTest("verify Profile Settings Navigation");

		home.clickOnUseManagement();
		assertTrue(profile.verifyNavigationToProfileSetting());

	}

	@Test(priority = 17, dependsOnMethods = "verifyLogin")
	public void verifyInputFieldsFromProfileSetting() {
		SoftAssert a = new SoftAssert();

		test = extent.createTest("Verify Input Fields From Profile Setting Page");
		home.clickOnUseManagement();

		a.assertTrue(profile.verifyInputFields());
		a.assertTrue(profile.verifyPhoneNumField());

		// a.assertTrue(home.checkBrokenImages());
		a.assertAll();

	}

	// @Test(priority = 16, dependsOnMethods = "verifyLogin")

	public void verifyBrokenImageOnProfileSettingPage() { //
		test = extent.createTest("Check for Broken images on Profile setting page");
		assertTrue(checkBrokenImages());

	}

	@Test(priority = 18, dependsOnMethods = "verifyLogin")

	public void verifyVisibilityOfCardsOnProductInformationPage() {
		test = extent.createTest("Verify visibility of Product Information page");
		assertTrue(productInfo.visibilityOfProductInfoCards());
	}

	// @Test(priority = 19, dependsOnMethods = "verifyLogin")

	public void verifyBrokenImageOnProfileOnProductInformationPage() { //
		test = extent.createTest("Check for Broken images on Product Information Page");
		assertTrue(checkBrokenImages());

	}

	@Test(priority = 20, dependsOnMethods = "verifyLogin")
	public void verifyProductHelp() {
		test = extent.createTest("Verify Product links from Product help page");
		assertTrue(productInfo.linkValidationOfProductHelpCards());
	}

	@Test(priority = 21, dependsOnMethods = "verifyLogin")
	public void verifyHelpfulFormsAndLiteratures() {
		test = extent.createTest("Verify Helpful Forms And Literatures links");
		assertTrue(productInfo.linkValidationOfHelpfulFormsAndLiteratures());
	}

	@Test(priority = 22, dependsOnMethods = "verifyLogin")

	public void verifyEPIVideoChannel() {
		test = extent.createTest("Verify Navigation to EPI Video Channel");
		assertTrue(productInfo.linkValidationOfEPIVideoChannel());
	}

	@Test(priority = 23, dependsOnMethods = "verifyLogin")
	public void verifySupportPageEmailLinksValidation() {
		test = extent.createTest("Verify available email links On Support Page");

		assertTrue(support.verifySupportEmailLinks());
	}

	@Test(priority = 24, dependsOnMethods = "verifyLogin")
	public void verifyVisibilityReportCards() {
		test = extent.createTest("Verify Visibility of all report cards");
		assertTrue(reportsP.visibilityOfReportCards());

	}

	@Test(priority = 25, dependsOnMethods = "verifyVisibilityReportCards")
	public void verifyLinkValidationOfReportCards() {
		test = extent.createTest("Verify Link Validation of all report cards");
		assertTrue(reportsP.linkValidationOfReports());

	}

	@Test(priority = 26, dependsOnMethods = "verifyVisibilityReportCards")
	public void verifyTotalsSummaryReportFunctionality() {
		test = extent.createTest("Verify functionality of totals summary report");
		reportsP.navigateTo_TotalsSummaryReport();
		SoftAssert a = new SoftAssert();
		a.assertTrue(reportsP.verifyFilterByMonth());

		a.assertTrue(reportsP.verifyFilterByDay());

		a.assertTrue(reportsP.VerifyFilterByDateRange("dateRange"));

		a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Totals Summary"));
		a.assertTrue(reportsP.verifyDownloadExcelFunctionality("Totals_Summary"));
		a.assertTrue(reportsP.verifyClearFilterFunctionalityForTotalSummary());
		a.assertAll();

		// assertTrue(reports.verifyTotalsSummaryReport());
	}

	@Test(priority = 27, dependsOnMethods = "verifyVisibilityReportCards")
	public void verifySettledBatchesReportFunctionality() {
		test = extent.createTest("Verify Functionality of Settled BatchesReport");
		SoftAssert a = new SoftAssert();
		assertTrue(reportsP.verifySettledBatchesReport());

		a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Settled Batches"));
		a.assertTrue(reportsP.verifyDownloadExcelFunctionality("Settled_Batches"));
		a.assertTrue(reportsP.verifyClearFilterFunctionalityForSettledBatches());
		a.assertAll();
	}

	@Test(priority = 28, dependsOnMethods = "verifyVisibilityReportCards")

	public void verifyACHReportFunctionality() {
		test = extent.createTest("Verify functionality of ACH Report");
		SoftAssert a = new SoftAssert();
		a.assertTrue(reportsP.verifyACHReport());
		a.assertTrue(reportsP.verifyFilterByMonth());
		a.assertTrue(reportsP.verifyFilterByDay());
		a.assertTrue(reportsP.VerifyFilterByDateRange("dateRange"));
		a.assertTrue(reportsP.verifyDownloadPdfFunctionality("ACH"));
		a.assertTrue(reportsP.verifyDownloadExcelFunctionality("ACH"));
		a.assertTrue(reportsP.verifyClearFilterFunctionalityForACH());
		a.assertAll();

	}

	@Test(priority = 29, dependsOnMethods = "verifyVisibilityReportCards")
	public void verifySearchTransactionReportFunctionality() {
		test = extent.createTest("Verify Functionality of Search Transaction Report");
		SoftAssert a = new SoftAssert();
		assertTrue(reportsP.verifySearchTransaction());

		a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Search_Transaction"));
		a.assertTrue(reportsP.verifyDownloadExcelFunctionality("Search_Transaction"));
		a.assertTrue(reportsP.verifyClearFilterFunctionalityForSearchTransactions());

		a.assertAll();
	}

	@Test(priority = 30, dependsOnMethods = "verifyVisibilityReportCards")
	public void verifyMerchantStatementReportFunctionality() {
		test = extent.createTest("Verify Functionality of Merchant Statement Report");
		assertTrue(reportsP.verifyMerchantStatementReport());
	}

	@Test(priority = 31, dependsOnMethods = "verifyVisibilityReportCards")
	public void verifyChargebacksReportFunctionality() {
		test = extent.createTest("Verify Functionality of Chargebacks Report");
		SoftAssert a = new SoftAssert();
		util.addBase64ScreenShotToReport(driver, test, "Chargebacks Report");
		a.assertTrue(reportsP.verifyChargebacksReport());
		a.assertTrue(reportsP.verifyLast4digitOfCards());
		a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Chargebacks"));
		a.assertTrue(reportsP.verifyDownloadExcelFunctionality("Chargebacks"));
		a.assertAll();
		// supriya

	}

	// @Test(priority =27)
	public void verifyDailyUploadReportFunctionality() {
		test = extent.createTest("Verify Functionality of Daily Upload Report");
		assertTrue(reportsP.verifyDailyUploadReport());
	}

	@Test(priority = 29)
	public void verifyDailyDiscountCalculatorFunctionality() {
		test = extent.createTest("Verify Functionality of Daily Discount Calculator");
		assertTrue(reportsP.verifyDailyDiscountCalculator());
	}

	@Test(priority = 32)
	public void Logout() {
		test = extent.createTest("Verify Logout Functionality");
		assertTrue(login.verifyLogout());
		util.addBase64ScreenShotToReport(driver, test, "Logout");
	}

}
