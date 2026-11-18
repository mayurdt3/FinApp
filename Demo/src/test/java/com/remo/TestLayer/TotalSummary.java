package com.remo.TestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reporter.ExtentUtility;

public class TotalSummary extends BaseClass {
	ConfigUtil prop = new ConfigUtil();

	@BeforeClass
	@Parameters({ "environment", "browserName" })
	public void createReport(String env, String browser) {
		ExtentUtility.createReport("TotalSummaryAPi", env, browser);
	}

	@Test
	public void getMerchantDetails() {

		test = extent.createTest("Merchent Details API");
		String MID = "434002025881";
		String startDate = "01-01-2024";
		String enddate = "01-02-2034";
		String requestBody = "{ \"merchantID\" : \"" + MID + "\"}";

		Response response = RestAssured.given()
				.header("Authorization", prop.getProperty("Authorization"))
				.body(requestBody)
				.when()
				.get("https://merchant360.com:3003/fdfeed/getTotalSummary?merchantId=" + MID + "&startDate=" + startDate
						+ "&endDate=" + enddate + "&reconciliation=month&dateFilterType=fundedDate");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		int responseCode = response.getStatusCode();

		test.log(Status.INFO, "Response Code :" + responseCode);

		if (responseCode == 200) {
			test.log(Status.PASS, "Total Summary API is up and running!");
		} else {

			test.log(Status.FAIL, "Total Summary API is not working!");
		}
		Assert.assertEquals(responseCode, 200);

	}
}
