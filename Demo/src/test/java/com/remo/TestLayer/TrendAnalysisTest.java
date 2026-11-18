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

public class TrendAnalysisTest extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })
	public void reportsPageSetup(@Optional("ProdURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("TrendAnalysis", env, browser);

	}

	@Test(priority = 0)
	@Parameters("environment")
	public void verifyLogin(@Optional("ProdURL") String env) {
		test = extent.createTest("Verify Login");
		// util.setWindowresolution(driver,50);
		login.loginVerification(env, "Username", "Password");
		SoftAssert s = new SoftAssert();
		s.assertTrue(home.isUserProfileIconDisplayed());
		// try {
		//// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		assertTrue(home.verifyBusinessOverviewFunctionality());
		s.assertAll();
	}

	@Test(priority = 1, dependsOnMethods = "verifyLogin")
	public void businessOverview() {
		assertTrue(home.verifyBusinessOverviewFunctionality());
	}

	@Test(priority = 2, dependsOnMethods = "verifyLogin")
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

	@Test(priority = 3, dependsOnMethods = "verifyLogin")
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
			double graphTransaction = Double.parseDouble(transactions.get(i).replaceAll("[$,]", ""));
			double reportTransaction = Double.parseDouble(salesItemsList.get(i).replaceAll("[$,]", ""));

			if (graphTransaction == reportTransaction) {
				// if (transactions.get(i).equals(salesItemsList.get(i))) {
				test.log(Status.PASS, "Trasactions on graph for date  " + dates.get(i) + ": " + graphTransaction
						+ " match with Sales Items form report : " + reportTransaction);
			} else {
				test.log(Status.FAIL, "Trasactions on graph for date  " + dates.get(i) + ": " + graphTransaction
						+ " does not match with  Sales Items form report : " + reportTransaction);
			}
		}
		// if(transactions.equals(salesItemsList)) {
		// test.log(Status.PASS,"Sales items from the Totals Summary report and
		// transaction count from the trend analysys is same");
		// }
		// else {
		// test.log(Status.FAIL,"Transaction count from graph and Sales Items from Total
		// Summary reportdose does not match");
		// }
		// assertEquals(transactions, salesItemsList);

	}

	@Test(priority = 4, dependsOnMethods = "verifyLogin")
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
			salesAmount.add(reportsP.getDataFromReport(date, "Sales Amount").replace("[,$]", ""));
		}

		for (int i = 0; i < dates.size(); i++) {
			double graphSale = Double.parseDouble(totalSales.get(i).replaceAll("[$,]", ""));
			double reportSale = Double.parseDouble(salesAmount.get(i).replaceAll("[$,]", ""));

			if (graphSale == reportSale) {
				// if (totalSales.get(i).replace("[,$]","").equals(salesAmount.get(i))) {
				test.log(Status.PASS, "Total Sales on graph for date  " + dates.get(i) + ": " + graphSale
						+ " match with Sales Amount form report : " + reportSale);
			} else {
				test.log(Status.FAIL, "Total Sales on graph for date  " + dates.get(i) + ": " + graphSale
						+ " does not match with Sales Amount form report : " + reportSale);
			}
		}

		// if(totalSales.equals(salesAmount)) {
		// test.log(Status.PASS,"Sales Amount from the Totals Summary report and Total
		// Sales from the trend analysys is same");
		// }
		// else {
		// test.log(Status.FAIL,"Total Sales from graph and, Sales Amount from Total
		// Summary report not match");
		// }
		//
		// assertEquals(totalSales, salesAmount);

	}

	@Test(priority = 5, dependsOnMethods = "verifyLogin")
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
			double graphRefund = Double.parseDouble(refunds.get(i).replaceAll("[$,]", ""));
			double reportRefund = Double.parseDouble(refundsAmount.get(i).replaceAll("[$,]", ""));

			if (graphRefund == reportRefund) {
				test.log(Status.PASS, "Total Sales on graph for date  " + dates.get(i) + ": " + graphRefund
						+ " match with Sales Amount form report : " + reportRefund);
			} else {
				test.log(Status.FAIL, "Total Sales on graph for date  " + dates.get(i) + ": " + graphRefund
						+ " does not match with Sales Amount form report : " + reportRefund);
			}
		}

		// if(refunds.equals(refundsAmount)) {
		// test.log(Status.PASS,"Refund Amount from the Totals Summary report and
		// Refunds from the trend analysys is same");
		// }
		// else {
		// test.log(Status.FAIL,"Refunds from graph, and Refund Amount from Total
		// Summary report does not match");
		// }
		// assertEquals(refunds, refundsAmount);

	}

}
