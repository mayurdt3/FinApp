package com.remo.TestLayer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.remo.Test.BaseTest;

import reporter.ExtentUtility;

public class LocationPageTest extends BaseTest {

    @BeforeClass
    @Parameters({ "environment", "browserName" })

    public void reportsPageSetup(@Optional("QAURL") String env, @Optional("chrome") String browser) {
        ExtentUtility.createReport("LocationTest", env, browser);

        test = extent.createTest("Verify Locations Page Setup");
        login.loginMethod(env, "Username", "Password");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        home.isBusinessOverviewInfoDisplayed();

    }

    @Test(priority = 1, enabled = true)
    public void verifyNavigationToLocationsPage() {
        SoftAssert a = new SoftAssert();

        test = extent.createTest("verify Profile Settings Navigation");

        home.visibilityOfUserProfileDropdown();
        home.clickOnUseManagement();
        a.assertTrue(profile.verifyNavigationToProfileSetting());

        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }

        test = extent.createTest("Verify navigation to the Locations Page");

        a.assertTrue(location.verifyNavigateToLocationsPage());
        util.addBase64ScreenShotToReport(driver, test, "Locations page");

        a.assertAll();

    }

    @Test(priority = 2, enabled = true)
    public void verifyDefaultFilterOptionsOnLocationPage() {
        SoftAssert a = new SoftAssert();
        test = extent.createTest("verify default values for filter Locations Page");

        a.assertTrue(location.verifyDefaultValuforStatusDropdown());
        a.assertTrue(location.isNameFieldBlank());
        a.assertTrue(location.isFilterButtonEnabled());
        a.assertTrue(location.isClearFilterButtonEnabled());
        a.assertAll();
    }

    @Test(priority = 3, enabled = true)
    public void verifyFilterFunctionality() {
        SoftAssert a = new SoftAssert();
        test = extent.createTest("verify filter by status functionality for Admin Login");

        a.assertTrue(location.verifyFilterByStatus());

        a.assertAll();

    }

    @Test(priority = 8, enabled = true)
    public void verifyActionFunctionalityForLocations() {
        test = extent.createTest("Verify Location Action Functionality for Admin Login");
        SoftAssert a = new SoftAssert();

        // try {
        // Thread.sleep(1500);
        // } catch (Exception e) {

        // }
        a.assertTrue(location.verifyNavigateToLocationsPage());

        test = extent.createTest("Verify Edit Location Action for Admin login");
        a.assertTrue(location.validateEditActionForLocatiionsTable());

        test = extent.createTest("Verify Active/Inactive Location Actions for Admin login");
        a.assertTrue(location.verifyActiveInactiveActionFunctionality());

        test = extent.createTest("Verify Remove Location Action for Admin login");
        a.assertTrue(location.verifyRemoveLocationFunctionality("Location MT"));

        a.assertAll();
    }

    @Test(priority = 9, enabled = true)
    public void verifyCreateLocationFormFunctionality() {
        SoftAssert a = new SoftAssert();

        a.assertTrue(location.verifyNavigateToLocationsPage());

        test = extent.createTest("Verify Navigation to product selection page");
        a.assertTrue(location.VerifyNavigationToProductSelectionPage());

        test = extent.createTest("Verify default values on select product dropdown");
        a.assertTrue(location.verifyDefaultValueOfSelectProductDropdown());

        test = extent.createTest("Verify select product dropdown functionality");
        a.assertTrue(location.verifySelectProductDropdownByText("Procharge"));
        a.assertTrue(location.verifySelectProductDropdownByText("TableTurn"));
        a.assertTrue(location.verifySelectProductDropdownByText("EPITerminal"));

        test = extent.createTest("Verify navigation button functionality on select product page");

        a.assertTrue(location.verifyBackButtonOnProductSelectionPage());
        a.assertTrue(location.verifySelectProductDropdownByText("Procharge"));
        a.assertTrue(location.verifyNextButtonOnProductSelectionPage());

        test = extent.createTest("Verify Create Location Form Fields Functionality");
        a.assertTrue(
                location.verifyCreateLocationFormFieldsFunctionality("Test Location MT", "123 Test St", "Test City",
                        "12345", "123456789", "Micros/Micros5", "Eastern Standard Time (ET) - UTC -5", "10", "30", "17",
                        "30", "30",
                        "qauser0004@outlook.com", "1234567890", "Tableturn Wired"));

        a.assertAll();
    }

}
