package com.remo.TestLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.remo.Test.BaseTest;
import com.aventstack.extentreports.Status;

import reporter.ExtentUtility;

public class UsersRefreshTest extends BaseTest {

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	// public void reportsPageSetup(@Optional("ProdURL") String env,
	// @Optional("chrome") String browser) {
	public void reportsPageSetup(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("Users Refresh", env, browser);

		test = extent.createTest("Verify Login");
		login.loginMethod(env, "Username", "Password");

		test = extent.createTest("Verify navigation to the Users Page");
		home.clickOnUseManagement();
		profile.verifyNavigationToProfileSetting();

		home.visibilityOfUserProfileDropdown();

		user.verifyNavigateToUsersPage();

		util.addBase64ScreenShotToReport(driver, test, "Users page");
	}

	/*
	 * Verify Navigation to Users Page
	 */
	@Test(priority = 1, enabled = true, invocationCount = 5)
	public void verifyNavigationToUsersPage() {
		SoftAssert a = new SoftAssert();

		test = extent.createTest("Verify Refresh functionality of Users Page");

		double startTime = System.currentTimeMillis();
		double endTime = 0.0;

		try {

			System.out.println("Start Time: " + startTime);
			// String TimeStampBeforeRefresh = util.getTimeStamp();
			driver.navigate().refresh();

			util.waitForVisibilityOfElement(driver, user.loader);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.invisibilityOf(user.loader));

			endTime = System.currentTimeMillis();
			System.out.println("End Time: " + endTime);
			double timedifference = (endTime - startTime);
			double totalTime = timedifference / 1000;
			util.addBase64ScreenShotToReport(driver, test, "Users page loaded in " + totalTime + " seconds");

			System.out.println("Time to reload pahe: " + totalTime);
			test.log(Status.INFO, "Page took " + totalTime + " Seconds to reload the page");
			a.assertTrue(totalTime < 12);

		} catch (Exception e) {
			endTime = System.currentTimeMillis();
			System.out.println("End Time: " + endTime);
			double timedifference = (endTime - startTime);
			double totalTime = timedifference / 1000;
			util.addBase64ScreenShotToReport(driver, test, "Users page loaded in " + totalTime + " seconds");

			System.out.println("Time to reload pahe: " + totalTime);
			test.log(Status.INFO, "Page took " + totalTime + " Seconds to reload the page");
			a.assertTrue(totalTime < 12);
			e.printStackTrace();

		}

		a.assertAll();

	}

}