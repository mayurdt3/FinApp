package com.remo.TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reporter.ExtentUtility;

public class MMAPITest extends BaseClass {
	ConfigUtil prop = new ConfigUtil();

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(String env, String browser) {

		ExtentUtility.createReport("MMApiTest", env, browser);

	}

	@DataProvider(name = "VerifyProduct")
	public String[] getLoginTestData() {
		return api.getMIDDataForProductVerification();
	}

	@Test
	public void getMerchantDetails() {

		test = extent.createTest("Merchant Details API");

		Response response = RestAssured.given()
				.header("M360KEY", prop.getProperty("ProdM360KEY"))
				.when()
				.get(prop.getProperty("GetMerchantDetailsProdAPI"));

		// String responseBody = response.getBody().asString();

		int responseCode = response.getStatusCode();

		test.log(Status.INFO, "Response Code :" + responseCode);

		if (responseCode == 200) {
			test.log(Status.PASS, "Merchants Details API is up and running!");
		} else {

			test.log(Status.FAIL, "Merchants Details API is not working!");
		}
		Assert.assertEquals(responseCode, 200);

	}

	@Test
	public void getOwnerDetails() {

		test = extent.createTest("Owner Details API");

		Response response = RestAssured.given()
				.header("M360KEY", prop.getProperty("ProdM360KEY"))
				.when()
				.get(prop.getProperty("GetOwnerDetailsProdAPI"));

		// String responseBody = response.getBody().asString();

		int responseCode = response.getStatusCode();

		test.log(Status.INFO, "Response Code :" + responseCode);

		if (responseCode == 200) {
			test.log(Status.PASS, "Owner Details API is up and running!");
		} else {

			test.log(Status.FAIL, "Owner Details API is not working!");

		}
		Assert.assertEquals(responseCode, 200);
	}

	@AfterClass
	public void closeReport() {
		ExtentUtility.quitReport();
	}

}
