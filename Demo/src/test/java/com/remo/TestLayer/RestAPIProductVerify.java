package com.remo.TestLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.remo.PageLayer.API;
import com.remo.base.BaseClass;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reporter.ExtentUtility;

public class RestAPIProductVerify extends BaseClass {

	API api = new API();

	@BeforeClass
	@Parameters({ "environment", "browserName" })
	public void createReport(String env, String browser) {
		ExtentUtility.createReport("RestApiVerifyProduct", env, browser);
	}

	@DataProvider(name = "VerifyProduct")
	public String[] getLoginTestData() {
		return api.getMIDDataForProductVerification();
	}

	@Test(priority = 1, dataProvider = "VerifyProduct")
	public void verifyRESTAPIVerifyProduct(String MID) {

		SoftAssert soft = new SoftAssert();

		try {
			test = extent.createTest("Verify Product : " + MID);

			RestAssured.baseURI = "https://api.iso360.com/epicrm/GetMerchantDetails";

			Response response = RestAssured.given().header("M360KEY", prop.getProperty("ProdM360KEY")).when()
					.get(prop.getProperty("GetMerchantDetailsProdAPI") + "=" + MID);

			String responseBody = response.getBody().asString();

			// int dbaName = responseBody.indexOf("DBAName");
			// int mid = responseBody.indexOf("MID");

			soft.assertEquals(response.getStatusCode(), 200);

			test.log(Status.PASS, "Status code:  " + response.getStatusCode());

			// String name = responseBody.substring(dbaName, mid).trim().replace(",\"", "");

			// test = extent.createTest( "Verify Product : " + MID + " " + name);

			int products = responseBody.indexOf("Products");
			int equipments = responseBody.indexOf("Equipment");

			String finalResponse = responseBody.substring(products, equipments).trim();

			test.log(Status.INFO, " " + finalResponse);

		} catch (Exception e) {
			test.log(Status.FAIL, "Test Data Failed.");
		}

		soft.assertAll();
	}

	@AfterClass
	public void closeReport() {
		ExtentUtility.quitReport();
	}
}
