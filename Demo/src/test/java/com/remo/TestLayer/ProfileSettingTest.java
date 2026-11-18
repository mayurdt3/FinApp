package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.remo.Test.BaseTest;
import reporter.ExtentUtility;

public class ProfileSettingTest extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void reportsPageSetup(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("Profile Settings", env, browser);

		test = extent.createTest("Verify login");
		login.loginMethod(env, "Username", "Password");

	}

	@Test(priority = 1)
	public void verifyProfileSettingsNavigation() {
		test = extent.createTest("verify Profile Settings Navigation");
		home.clickOnUseManagement();
		assertTrue(profile.verifyNavigationToProfileSetting());
	}

	@Test(priority = 2)
	public void verifyInputFieldsFromProfileSetting() {
		SoftAssert a = new SoftAssert();
		test = extent.createTest("Verify Input Fields From Profile Setting Page");
		home.clickOnUseManagement();
		a.assertTrue(profile.verifyInputFields());
		a.assertTrue(profile.verifyPhoneNumField());
		// a.assertTrue(home.checkBrokenImages());
		a.assertAll();

	}

	// @Test(priority = 3)

	public void VerifyBrokenImageOnProfileOnProductInformationPage() {
		test = extent.createTest("Check for Broken images on Product Information Page");
		refreshPage();
		assertTrue(checkBrokenImages());

	}

}
