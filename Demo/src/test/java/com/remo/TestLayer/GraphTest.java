package com.remo.TestLayer;

import static org.testng.Assert.assertEquals;
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

public class GraphTest extends BaseTest {
	SoftAssert s;

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("GraphTest", env, browser);
		test = extent.createTest("Verify login");
		login.loginMethod(env, "Username", "Password");
		// s = new SoftAssert();
	}

	@Test(priority = 0)
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

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void verifyRefundsGraph(@Optional("QAURL") String env) {
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
}
