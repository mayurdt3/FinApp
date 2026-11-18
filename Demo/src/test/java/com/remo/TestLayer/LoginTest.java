package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.remo.Test.BaseTest;
import reporter.ExtentUtility;

public class LoginTest extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("LoginTest", env, browser);
		test = extent.createTest("Verify launch application");
		assertTrue(login.verifyLaunchApplication(env));

	}

	/**
	 * Test case to verify presence of broken images on login page.
	 */
	// @Test(priority = -3)

	public void VerifyBrokenImageOnLoginPage() {
		test = extent.createTest("Check for Broken images");
		assertTrue(checkBrokenImages());

	}

	/**
	 * Test case to verify login with Invalid User name & valid password.
	 */
	// @Test(priority = -2)
	public void VerifyInvalidLogin() {
		test = extent.createTest("Login with invalid UserName");
		assertTrue(login.verifyInvalidLogin("InvalidUsername", "Password"));

	}

	/**
	 * Test case to verify login with wrong password.
	 */
	@Test(priority = -1)
	public void VerifyLoginWithIncorrectPassword() {
		test = extent.createTest("Login with Incorrect Password");

		assertTrue(login.verifyInvalidLogin("Username", "WrongPassword"));
	}

	/**
	 * Test case to verify login with Invalid password.
	 */
	@Test(priority = 0)
	public void VerifyLoginWithInvalidPassword() {
		test = extent.createTest("Login with invalid Password");
		assertTrue(login.verifyInvalidLogin("Username", "InvalidPassword"));
	}

	/**
	 * Test case to verify the successful login.
	 */
	@Test(priority = 1)

	public void verifyLogin() {
		test = extent.createTest("Login with valid data");
		assertTrue(login.login("Username", "Password"));

		home.logout();

	}

	/**
	 * Test case to verify the forgot password text.
	 */
	// @Test(priority = 3)
	public void forgotPasswordLinkValidation() {
		// test =extent.createTest("Verify forgot Password link");
		login.verifyForgotPasswordLink();

	}

}
