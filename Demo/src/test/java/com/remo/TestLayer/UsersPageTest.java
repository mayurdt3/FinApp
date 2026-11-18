package com.remo.TestLayer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.remo.Test.BaseTest;
import reporter.ExtentUtility;

public class UsersPageTest extends BaseTest {
	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void reportsPageSetup(@Optional("QAURL") String env, @Optional("chrome") String browser) {
		ExtentUtility.createReport("Users Test", env, browser);

		test = extent.createTest("Verify Login");
		login.loginMethod(env, "Username", "Password");

	}

	/*
	 * Verify Navigation to Users Page
	 */
	@Test(priority = 1, enabled = true)
	public void verifyNavigationToUsersPage() {
		SoftAssert a = new SoftAssert();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {

		}

		test = extent.createTest("verify Profile Settings Navigation");
		home.visibilityOfUserProfileDropdown();
		home.clickOnUseManagement();
		a.assertTrue(profile.verifyNavigationToProfileSetting());

		// try {
		// Thread.sleep(10000);
		// } catch (Exception e) {

		// }
		// home.isBusinessOverviewInfoDisplayed();
		// home.clickOnUseManagement();
		test = extent.createTest("Verify navigation to the Users Page");

		a.assertTrue(user.verifyNavigateToUsersPage());
		util.addBase64ScreenShotToReport(driver, test, "Users page");

		a.assertAll();

	}

	/*
	 * Verify default values for filter
	 */
	@Test(priority = 2, enabled = true)
	public void verifyDefaultFilterOptionsOnUserPage() {
		SoftAssert a = new SoftAssert();
		test = extent.createTest("verify default values for filter");

		a.assertTrue(user.verifyDefaultValuforRoleDropdown());
		a.assertTrue(user.verifyDefaultValuforStatusDropdown());
		a.assertTrue(user.isLocationNameBlank());
		a.assertTrue(user.isEmailFieldBlank());
		a.assertTrue(user.isFilterButtonEnabled());
		a.assertTrue(user.isClearFilterButtonEnabled());
		a.assertAll();
	}

	/*
	 * Verify Filter Functionality
	 */
	@Test(priority = 3, enabled = true)
	public void verifyFilterFunctionalityForAdminLogin() {
		SoftAssert a = new SoftAssert();
		test = extent.createTest("verify Filter by roll functionality for Admin Login");
		a.assertTrue(user.verifyAvailableOptionsForRoleFilter("SuperAdmin"));
		a.assertTrue(user.verifyAvailableOptionsForStatusFilter("SuperAdmin"));
		a.assertTrue(user.verifyFilterByRole());
		a.assertTrue(user.verifyFilterByStatus());

		a.assertTrue(login.verifyLogout());
		a.assertAll();

	}

	/**
	 * Verify Filter Functionality for Merchant Login
	 */
	@Test(priority = 4, enabled = true)
	public void verifyFilterFunctionalityForMerchantLogin() {
		test = extent.createTest("verify Filter by roll functionality for Merchant Login");
		SoftAssert a = new SoftAssert();

		a.assertTrue(login.login("MerchantUsername", "MerchantPassword"));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());
		a.assertTrue(user.verifyAvailableOptionsForRoleFilter("Merchant"));
		a.assertTrue(user.verifyAvailableOptionsForStatusFilter("Merchant"));
		a.assertTrue(user.verifyFilterByRole());
		a.assertTrue(user.verifyFilterByStatus());
		a.assertTrue(login.verifyLogout());

		a.assertAll();

	}

	/**
	 * Verify Filter Functionality for Power User Login
	 */
	// @Test(priority = 5, enabled = true)
	public void verifyFilterFunctionalityForPowerUserLogin() {
		test = extent.createTest("verify Filter by roll functionality for Power user Login");
		SoftAssert a = new SoftAssert();

		a.assertTrue(login.login("PowerUsername", "PowerPassword"));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());
		a.assertTrue(user.verifyAvailableOptionsForRoleFilter("Power"));
		a.assertTrue(user.verifyAvailableOptionsForStatusFilter("Power"));
		a.assertTrue(user.verifyFilterByRole());
		a.assertTrue(user.verifyFilterByStatus());
		a.assertTrue(login.verifyLogout());

		a.assertAll();

	}

	/*
	 * Verify Navigation to Invitations Page
	 */
	@Test(priority = 7, enabled = true)
	public void verifyNavigateToInvitationsPgaeFunctionality() {
		test = extent.createTest("Verify Navigate To Invitations page");
		SoftAssert a = new SoftAssert();

		a.assertTrue(login.login("MerchantUsername", "MerchantPassword"));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());
		a.assertTrue(user.verifyNavigationToInvitationsPgae());
		a.assertTrue(user.verifyDefaultValuforStatusDropdown());
		a.assertTrue(user.isLocationNameBlank());
		a.assertTrue(user.isEmailFieldBlank());
		a.assertTrue(user.isFilterButtonEnabled());
		a.assertTrue(user.isClearFilterButtonEnabled());

		a.assertTrue(user.verifyAvailableOptionsForStatusFilterInvitationPage("Merchant"));
		a.assertTrue(user.verifyFilterByStatus());
		a.assertTrue(login.verifyLogout());

		a.assertAll();
	}

	/*
	 * Verify Action Functionality for Users
	 */
	@Test(priority = 8, enabled = true)
	public void verifyActionFunctionalityForUsers() {
		test = extent.createTest("Verify User Action FUnctionality for Admin Login");
		SoftAssert a = new SoftAssert();
		a.assertTrue(login.verifyLogout());
		a.assertTrue(login.login("Username", "Password"));

		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());

		test = extent.createTest("Verify Edit User Action for Admin login");
		a.assertTrue(user.validateEditActionForUserTable());

		test = extent.createTest("Verify Enable/Desable User Actions for Admin login");
		a.assertTrue(user.validateEnableDesableActionForUserTable());

		test = extent.createTest("Verify Reinvite User Actions for Admin login");
		a.assertTrue(user.validateReinviteActionForUserTable());

		test = extent.createTest("Verify Reset Password User Actions for Admin login");
		a.assertTrue(user.validateResetPasswordFunctionality());

		test = extent.createTest("Verify Set Password User Actions for Admin login");
		a.assertTrue(user.validateSetPasswordFunctionality());

		test = extent.createTest("Verify Assign Location User Actions for Admin login");
		a.assertTrue(user.validateAssignLocationFunctionality());

		a.assertAll();
	}

	/**
	 * Verify Action Functionality for Invitation Page for Super Admin
	 */
	@Test(priority = 9, enabled = true)
	public void verifyActionFunctionalityForInvitationPageForSuperAdmin() {

		test = extent.createTest("Verify User Action Functionality for Invitation Page for Admin Login");

		SoftAssert a = new SoftAssert();

		try {
			Thread.sleep(15000);
		} catch (Exception e) {

		}

		// a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());
		a.assertTrue(user.verifyNavigationToInvitationsPgae());

		test = extent.createTest("Verify Resend Invite Actions for Admin login");
		a.assertTrue(user.validateResendInviteForInviteUserTable());
		test = extent.createTest("Verify Revoke Access Actions for Admin login");
		a.assertTrue(user.validateRevokeAccessForInviteUserTable());
		test = extent.createTest("Verify Revoke Invite Actions for Admin login");
		a.assertTrue(user.validateRevokeInviteForInviteUserTable());
		test = extent.createTest("Verify Extend Access Actions for Admin login");
		a.assertTrue(user.validateExtendAccessForInviteUserTable());

		a.assertTrue(login.verifyLogout());

		a.assertAll();

	}

	/**
	 * Verify Action Functionality for Invitation Page for Merchant
	 * 
	 */
	@Test(priority = 10, enabled = true)
	public void verifyActionFunctionalityForInvitationPageForMerchantLogin() {

		SoftAssert a = new SoftAssert();

		test = extent.createTest("Verify User Action Functionality for Invitation Page for Merchnat Login");

		a.assertTrue(login.login("MerchantUsername", "MerchantPassword"));

		try {
			Thread.sleep(15000);
		} catch (Exception e) {

		}

		a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());
		a.assertTrue(user.verifyNavigationToInvitationsPgae());

		test = extent.createTest("Verify Resend Invite Actions for Merchant login");
		a.assertTrue(user.validateResendInviteForInviteUserTable());
		test = extent.createTest("Verify Revoke Access Actions for Merchant login");
		a.assertTrue(user.validateRevokeAccessForInviteUserTable());
		test = extent.createTest("Verify Revoke Invite Actions for Merchant login");
		a.assertTrue(user.validateRevokeInviteForInviteUserTable());
		test = extent.createTest("Verify Extend Access Actions for Merchant login");
		a.assertTrue(user.validateExtendAccessForInviteUserTable());

		a.assertAll();

	}

	/**
	 * Verify Create New User Functionality for Merchant Login
	 */
	@Test(priority = 10, enabled = true)
	public void verifyCreateNewUserFunctionalityForMerchantLogin() {

		SoftAssert a = new SoftAssert();

		a.assertTrue(home.verifyLogin());
		a.assertTrue(user.verifyNavigateToUsersPage());
		test = extent.createTest("Verify Navigation to Create new user form for Admin login");
		a.assertTrue(user.verifyNavigationToCreateUserFormForRole("Merchant"));
		test = extent.createTest("Verify Create new user form");
		a.assertTrue(user.validateInputField("First Name", "John@123", "John-son"));
		a.assertTrue(user.validateInputField("Last Name", "Doe@123", "Doe-son"));
		// Enter your street address (letters, numbers, spaces, commas,apostrophes,-,/,
		// ., and #). Example: 123 Main Street, Apt #4
		a.assertTrue(user.validateInputField("Street", "123 abc@xyz St.", "456 Elm. St."));
		// Enter your city (letters, spaces, hyphens, and periods only, 2-50
		// characters). Example: New York
		a.assertTrue(user.validateInputField("City", "New York1", "Los Angeles"));
		// Enter your state (2-letter code or 3-20 character name). Example: NY or
		// California
		a.assertTrue(user.validateInputField("State", "C@lifornia", "California"));
		// Enter your zipcode (3-10 characters, letters, numbers, spaces, andhyphens
		// allowed). Example: 12345 or A1B 2C3
		a.assertTrue(user.validateInputField("Zipcode", "1234@", "12345"));
		// Enter a valid email address (6-128 characters). Example:6w4o9@example.com
		a.assertTrue(user.validateInputField("Email", "testemail.com", "test@example.com"));
		// Enter a valid phone number in international format
		a.assertTrue(user.validateInputField("Phone Number", "123-456", "+112345678901"));

		a.assertTrue(user.VerifyUploadUserLogo());

		a.assertAll();

	}

	/**
	 * Verify Create New Merchant Functionality
	 */
	@Test(priority = 11, enabled = true)
	public void verifyCreateNewMerchantFunctionality() {

		SoftAssert a = new SoftAssert();

		test = extent.createTest("Verify Create new Merchant ");
		a.assertTrue(user.verifyCreateUserFunctionality("Merchant", "qauser0005@outlook.com"));
		a.assertAll();
	}

	/*
	 * Verify Delete Merchant Functionality
	 */
	@Test(priority = 12, enabled = true, dependsOnMethods = "verifyCreateNewMerchantFunctionality")
	// @Test(priority = 12, enabled = true)
	public void verifyDeleteMerchantFunctionality() {

		SoftAssert a = new SoftAssert();
		test = extent.createTest("Verify Delete newly Created Merchant ");
		a.assertTrue(user.verifyDeleteUserFunctionality("Merchant", "qauser0005@outlook.com"));
		a.assertAll();

	}

}
