package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.remo.Test.BaseTest;
import reporter.ExtentUtility;

public class ProductInfoTest extends BaseTest {
	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("ProductInformation", env, browser);

	}

	@Test(priority = 0)
	@Parameters("environment")

	public void verifyVisibilityOfProductInfoCards(@Optional("QAURL") String env) {
		test = extent.createTest("Verify visibility  of cards on Product Information page");
		login.loginVerification(env, "Username", "Password");

		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// home.verifyBusinessOverviewFunctionality();
		// home.isTrendAnalysisHeaderVisible();

		assertTrue(productInfo.visibilityOfProductInfoCards());
	}

	// @Test(priority = 1)

	public void VerifyBrokenImageOnProductInfoPage() {
		test = extent.createTest("Check for Broken images on Product Info Page");
		assertTrue(checkBrokenImages());

	}

	@Test(priority = 1)
	public void verifyProductHelp() {
		test = extent.createTest("Verify Product Help page");

		assertTrue(productInfo.linkValidationOfProductHelpCards());
	}

	// @Test(priority = 2)
	public void verifyHelpfulFormsAndLiteratures() {
		test = extent.createTest("Verify Helpful Forms and Literatures page");
		assertTrue(productInfo.linkValidationOfHelpfulFormsAndLiteratures());
	}

	// @Test(priority = 3)
	public void verifyEPIVideoChannel() {
		test = extent.createTest("Verify Navigation to EPI Video Channel");
		assertTrue(productInfo.linkValidationOfEPIVideoChannel());
	}

}
