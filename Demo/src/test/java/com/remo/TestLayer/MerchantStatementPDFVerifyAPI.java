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

public class MerchantStatementPDFVerifyAPI extends BaseClass {

	public List<String> months;

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("ProdURL") String env, @Optional("chrome") String browser) {
		api = new API();
		prop = new ConfigUtil();
		ExtentUtility.createReport("MerchantStatementPDFVerify", env, browser);

	}

	@DataProvider(name = "MerchantStatement")
	public String[] getLoginTestData() {
		return api.getMerchantStatementPdfVerifyData();
	}

	@Test(priority = 1, dataProvider = "MerchantStatement")
	public void getMerchantDetails(String mid) {

		// @Test(priority = 1) ///////for testing
		// public void getMerchantDetails() {

		SoftAssert soft = new SoftAssert();

		months = Arrays.asList("", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		test = extent.createTest("Merchant :" + mid);

		LocalDate currentDate = LocalDate.now();
		int year = currentDate.getYear();
		int currentMonth = currentDate.getMonthValue();
		int prevMonth = currentMonth - 1;
		int prevYear = currentDate.getYear() - 1;
		int dayOfMonth = currentDate.getDayOfMonth();

		/**
		 * Following code will verify the merchant Status
		 */

		Response BusinessOverViewResponse = RestAssured.given().header("M360KEY", prop.getProperty("ProdM360KEY"))
				.when()
				.get(prop.getProperty("GetMerchantDetailsProdAPI") + "=" + mid);

		String response1 = BusinessOverViewResponse.getBody().asString();

		if (response1 != null) {
			String status = BusinessOverViewResponse.jsonPath().getString("[0].MerchantKey.Status");

			if (status.equalsIgnoreCase("Processing")) {
				status = "ACTIVE";

			}
			test.log(Status.INFO,
					"Merchant Status :  " + status.toUpperCase());
		} else {

			test.log(Status.FAIL, "Response body is null or empty.");

		}

		/**
		 * following code will verify merchant statement pdf report
		 */

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

				// System.out.println(prevYear +" : "+months.get(i)); //////for testing

				if (result) {

					test.log(Status.FAIL,
							"no record available for the month " + prevYear + ":" + months.get(i) + "");
					soft.assertTrue(!result);
				}
			}

			// for current year

			for (int m = 1; m < prevMonth; m++) {
				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + year + "&month=" + m);

				String responseBody = response.getBody().asString();

				boolean result = responseBody.equals("[]");

				// System.out.println(year +" : "+months.get(m)); //////for testing

				if (result) {
					test.log(Status.FAIL, "no record available for the month " + year + ":" + months.get(m) + "");
					soft.assertTrue(!result);
				}
			}

		} else {

			for (int i = 1; i <= 12; i++) {
				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + prevYear + "&month=" + i);

				String responseBody = response.getBody().asString();

				// System.out.println(prevYear +" : "+months.get(i)); //////for testing

				boolean result = responseBody.equals("[]");
				if (responseBody.equals("[]")) {
					test.log(Status.FAIL,
							"no record available for the month " + prevYear + ":" + months.get(i) + "");
					soft.assertTrue(!result);
				}
			}

			for (int m = 1; m < currentMonth; m++) {

				Response response = given().header("Authorization", prop.getProperty("Authorization"))
						.when().get(prop.getProperty("MerchantStatmentAPI") + mid
								+ "&role=Merchant&year=" + year + "&month=" + m);

				String responseBody = response.getBody().asString();

				boolean result = responseBody.equals("[]");

				if (responseBody.equals("[]")) {
					test.log(Status.FAIL, "no record available for the month " + year + ":" + months.get(m) + "");
					soft.assertTrue(!result);
				}
			}

		}

		// }

		soft.assertAll();
	}

	@AfterClass
	public void closeReport() {
		ExtentUtility.quitReport();
	}

}
