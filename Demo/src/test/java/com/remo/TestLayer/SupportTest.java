package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.remo.Test.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reporter.ExtentUtility;

public class SupportTest extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })
	public void createReport(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("SupportPage", env, browser);
		test = extent.createTest("Verify login");
		login.loginMethod(env, "Username", "Password");
		String mid = home.getMid();

	}

	// @Test
	// public void VerifyLogin() {
	// test = extent.createTest("Verify launch application");
	//
	// }
	// @Test
	@Parameters("environment")

	public void verifyEmailLinksAvailable(@Optional("QAURL") String env) {

		test = extent.createTest("Verify support details");

		String mid = home.getMid();
		System.out.println(mid);

		home.clickOnSupport();

		// String companyName = support.companyName.getText();

		// mid ="530961210042529";

		/**
		 * API Request
		 */
		Response response = RestAssured.given()
				.header("M360KEY", prop.getProperty("QAM360KEY"))
				.when()
				.get(prop.getProperty("GetMerchantDetailsQAAPI") + "=" + mid);

		String responseBody = response.getBody().asString();

		System.out.println("---------------------------------------------------------------");
		System.out.println(responseBody);

		System.out.println("---------------------------------------------------------------");

		int responseCode = response.getStatusCode();
		System.out.println(responseCode);

		if (responseBody != null) {
			String companyNameApi = response.jsonPath().getString("[0].AgentOffice.CompanyName");

			System.out.println("Api: " + companyNameApi);

			System.out.println("UI agent email :" + support.getSalesAgentEmail());
			System.out.println(
					"Api agent email :" + response.jsonPath().getString("[0].AgentMainOffice.Contact.EmailAddress"));

		} else {

			// test.log(Status.FAIL,"Response body is null or empty.");

		}

	}

	@Test
	public void verifyEmailLinksAvailable() {
		test = extent.createTest("Verify available email links");

		assertTrue(support.verifySupportEmailLinks());

	}

}
