package com.remo.TestLayer;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.remo.PageLayer.API;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reporter.ExtentUtility;

public class MerchantStatementPDFVerifyAPI_Live extends BaseClass {

	public List<String> months;

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("ProdURL") String env, @Optional("chrome") String browser) {
		api = new API();
		prop = new ConfigUtil();
		ExtentUtility.createReport("MerchantStatementPDFVerifyLive", env, browser);

	}

	@DataProvider(name = "MerchantStatement")
	public String[] getLoginTestData() {
		return api.getLiveMerchantStatementPdfVerifyData();
	}

	@Test(priority = 1, dataProvider = "MerchantStatement")
	public void getMerchantDetails(String mid) {
		// api = new API();
		SoftAssert a = new SoftAssert();

		// String data[] = api.getMerchantStatmentPdfVerifydata();

		months = Arrays.asList("", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		// for (String mid : data) {

		// System.out.println("data: " + mid);

		test = extent.createTest("Merchant :" + mid);

		LocalDate currentDate = LocalDate.now();
		int year = currentDate.getYear();
		int currentMonth = currentDate.getMonthValue();
		int prevMonth = currentMonth - 1;
		int prevYear = currentDate.getYear() - 1;
		int dayOfMonth = currentDate.getDayOfMonth();

		// String date = String.valueOf(LocalDate.now());

		// String filterBy = "All";
		String status;

		// String date = String.valueOf(LocalDate.now());
		// String bovRequestBody = "{\"MerchantID\":[" + mid + "],\"filterBy\":\"" +
		// filterBy + "\"}";

		Response BusinessOverViewResponse = RestAssured.given().header("M360KEY", prop.getProperty("ProdM360KEY"))
				.when()
				.get(prop.getProperty("GetMerchantDetailsProdAPI") + "=" + mid);

		String response1 = BusinessOverViewResponse.getBody().asString();
		// System.out.println( );
		if (response1 != null) {
			status = BusinessOverViewResponse.jsonPath().getString("[0].MerchantKey.Status");

			//
			// System.out.println("Value of key 'Status' " + status);
			//
			if (status.equalsIgnoreCase("Processing")) {
				status = "Active";

			}
			test.log(Status.INFO,
					"Merchant Status :  " + "\"" + status.toUpperCase() + "\"");
		} else {

			test.log(Status.FAIL, "Response body is null or empty.");

		}

		if (dayOfMonth < 10) {

			// for prev year
			for (int i = 1; i <= 12; i++) {
				if (currentMonth == 1 && i == 12) {
					continue;
				}

				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + prevYear + "&month=" + i);

				String responseBody = response.getBody().asString();

				boolean result = responseBody.equals("[]");

				// System.out.println(prevYear +" : "+months.get(i));

				if (result) {

					test.log(Status.FAIL,
							"no record available for the month " + prevYear + ":" + months.get(i) + "");
					a.assertTrue(!result);
				}

			}

			// for current year

			for (int m = 1; m < prevMonth; m++) {
				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + year + "&month=" + m);

				String responseBody = response.getBody().asString();

				boolean result = responseBody.equals("[]");

				// System.out.println(year +" : "+months.get(m));

				if (result) {
					test.log(Status.FAIL, "no record available for the month " + year + ":" + months.get(m) + "");
					a.assertTrue(!result);
				}
			}

		} else {

			for (int i = 1; i <= 12; i++) {
				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + prevYear + "&month=" + i);

				String responseBody = response.getBody().asString();

				boolean result = responseBody.equals("[]");

				// System.out.println(prevYear +" : "+months.get(i));

				if (responseBody.equals("[]")) {
					test.log(Status.FAIL,
							"no record available for the month " + prevYear + ":" + months.get(i) + "");
					a.assertTrue(!result);
				}
			}

			for (int m = 1; m < currentMonth; m++) {

				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + year + "&month=" + m);

				String responseBody = response.getBody().asString();

				boolean result = responseBody.equals("[]");

				// System.out.println(year +" : "+months.get(m));

				if (responseBody.equals("[]")) {
					test.log(Status.FAIL, "no record available for the month " + year + ":" + months.get(m) + "");
					a.assertTrue(!result);
				}
			}

		}

		// }
		a.assertAll();

	}

	@AfterClass
	public void closeReport() {
		ExtentUtility.quitReport();
	}

}
