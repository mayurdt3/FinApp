package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.remo.Test.BaseTest;

import net.bytebuddy.build.Plugin.Engine.Summary;
import reporter.ExtentUtility;

public class ReportsTest extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })
	public void reportsPageSetup(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("Reports", env, browser);
		test = extent.createTest("launnch app");
		// login.loginMethod(env, "Username", "Password");
		launchApp(env);
	}

	@Test(priority = 1)
	public void verifyVisibilityReportCards() {

		test = extent.createTest("Verify Visibility of all report cards");

		dashboard.verifyDashboard();
		dashboard.clickOnReports();
		System.out.print("clicked on reportsP");
		assertTrue(reportsP.visibilityOfReportCards());

	}

	@Test(priority = 2)
	public void verifyLinkValidationOfReportCards() {
		test = extent.createTest("Verify Link Validation of all report cards");
		assertTrue(reportsP.linkValidationOfReports());

	}

	// data integrity
	@Test(priority = 3)
	public void verifyTotalsSummaryReportFunctionality() {
		test = extent.createTest("Verify functionality of totals summary report");
		reportsP.navigateToTotalsSummary();
		SoftAssert a = new SoftAssert();
		// Sales amount - refund =Total Submitted Amount

		a.assertTrue(reportsP.verifySummaryCalculations());

		a.assertAll();

	}

	@Test(priority = 4)
	public void VerifyTotalsSummaryTotalSubmittedAmountWithSearchTransactionAmounts() {
		reportsP.navigateToTotalsSummary();
		test = extent.createTest("Totals Summary total submitted = Σ settled batch amounts (per month)");
		SoftAssert a = new SoftAssert();
		a.assertTrue(reportsP.verifyTotalsubmittedVsTransactionAmount());
		a.assertAll();

	}

	@Test(priority = 5)
	public void VerifyBatchTransactionCountWithSettledBatchCount() {
		reportsP.navigateToSearchTransactions();
		test = extent.createTest("Search Transaction Count = settled batch Count (per month)");
		SoftAssert a = new SoftAssert();
		a.assertTrue(reportsP.verifySearchTeasactionCountVsSettledBatchCount());
		a.assertAll();

	}

	@Test(priority = 6)
	public void VerifyOverviewBatchTotalWithSummaryTotalSubmittedAmount() {

		test = extent.createTest(" Buisness Overview Batch total= Σ Totals Summary total submitted (per month)");

		reportsP.navigateToSearchTransactions();
		SoftAssert a = new SoftAssert();
		a.assertTrue(reportsP.VerifyOverviewBatchTotalWithSummaryTotal());
		a.assertAll();

	}

	// // @Test(priority =4)
	// public void verifySettledBatchesReportFunctionality() {
	// test = extent.createTest("Verify Functionality of Settled BatchesReport");
	// SoftAssert a = new SoftAssert();
	// assertTrue(reportsP.verifySettledBatchesReport());

	// // a.assertTrue(reports.verifyDownloadPdfFunctionality("Settled Batches"));
	// // a.assertTrue(reports.verifyDownloadExcelFunctionality("Settled_Batches"));
	// // a.assertTrue(reports.verifyClearFilterFunctionalityForSettledBatches());

	// a.assertAll();
	// }

	// // @Test(priority = 5)
	// public void verifyACHReportFunctionality() {
	// test = extent.createTest("Verify functionality of ACH Report");
	// SoftAssert a = new SoftAssert();
	// a.assertTrue(reportsP.verifyACHReport());
	// a.assertTrue(reportsP.verifyFilterByMonth());
	// a.assertTrue(reportsP.verifyFilterByDay());
	// a.assertTrue(reportsP.VerifyFilterByDateRange("dateRange"));
	// a.assertTrue(reportsP.verifyDownloadPdfFunctionality("ACH"));
	// a.assertTrue(reportsP.verifyDownloadExcelFunctionality("ACH"));
	// assertTrue(reportsP.verifyClearFilterFunctionalityForACH());
	// }

	// // @Test(priority =5)
	// public void verifySearchTransactionReportFunctionality() {
	// test = extent.createTest("Verify functionality of Search Transaction
	// Report");
	// SoftAssert a = new SoftAssert();
	// a.assertTrue(reportsP.verifySearchTransaction());
	// a.assertTrue(reportsP.verifyClearFilterFunctionalityForSearchTransactions());
	// a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Search Transactions"));
	// a.assertTrue(reportsP.verifyDownloadExcelFunctionality("Search
	// Transactions"));
	// a.assertAll();
	// }

	// // @Test(priority =7)
	// public void verifyMerchantStatementReportFunctionality() {
	// test = extent.createTest("Verify Functionality of Merchant Statement
	// Report");
	// SoftAssert a = new SoftAssert();
	// a.assertTrue(reportsP.verifyMerchantStatementReport());
	// a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Merchant"));
	// a.assertTrue(reportsP.verifyDownloadExcelFunctionality("Merchant"));
	// a.assertTrue(reportsP.verifyClearFilterFunctionalityForMerchantStatement());
	// a.assertAll();
	// }

	// // @Test(priority =9)
	// public void verifyChargebacksReportFunctionality() {
	// test = extent.createTest("Verify Functionality of Chargebacks Report");
	// SoftAssert a = new SoftAssert();

	// a.assertTrue(reportsP.verifyChargebacksReport());
	// a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Chargebacks"));
	// a.assertTrue(reportsP.verifyDownloadPdfFunctionality("Chargebacks"));
	// a.assertTrue(reportsP.verifyLast4digitOfCards());
	// a.assertTrue(reportsP.verifyClearFilterFunctionalityForChargeBacks());

	// a.assertAll();
	// }

	// @Test(priority =7)
	// public void verifyDailyUploadReportFunctionality() {
	// test = extent.createTest("Verify Functionality of Daily Upload Report");
	// assertTrue(reports.verifyDailyUploadReport());
	// }

	// @Test(priority =7)
	// public void verifyPCDLiveViewReportFunctionality() { not for every MID
	// test = extent.createTest("Verify PCD Live View Report");
	// assertTrue(reports.VerifyPCDLiveViewReport());
	// }

	// // @Test(priority =10)
	// public void verifyDailyDiscountCalculatorFunctionality() {
	// test = extent.createTest("Verify Functionality of Daily Discount
	// Calculator");
	// assertTrue(reports.verifyDailyDiscountCalculator());
	// }

}
