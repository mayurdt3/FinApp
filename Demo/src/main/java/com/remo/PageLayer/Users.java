package com.remo.PageLayer;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class Users extends BaseClass {

	public Users(WebDriver driver) {
		this.driver = driver;
		prop = new ConfigUtil();
		util = new Utility();
		home = new HomePage(driver);
		profile = new ProfileSettingPage(driver);

		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElements
	 */

	@FindBy(xpath = "//h5[text()='Users']")
	private WebElement usersPageHeader;

	@FindBy(xpath = "//div[@class='card dashboardCard']//a[text()='User Management']")
	private WebElement UMbradecrimb;

	@FindBy(xpath = "//label[contains(text(),'Role')]/..//select")
	private WebElement roleDropdown;

	@FindBy(xpath = "//label[contains(text(),'Status')]/..//select")
	private WebElement statusDropdown;

	@FindBy(xpath = "//label[contains(text(),'Email')]/..//input")
	private WebElement emailField;

	@FindBy(xpath = "//label[contains(text(),'Location')]/..//input")
	private WebElement locationNameField;

	@FindBy(xpath = "//button[text()='Filter']")
	private WebElement filterButton;

	@FindBy(xpath = "//button[text()='Invitations']")
	private WebElement invitationButton;

	@FindBy(xpath = "//button[text()='Clear Filter']")
	private WebElement clearFilterButton;

	@FindBy(xpath = "//thead[@role='presentation']//th")
	private List<WebElement> tableHeaderOptopns;

	@FindBy(xpath = "//tbody//tr")
	public List<WebElement> rows;

	@FindBy(xpath = "//h5[text()='Invitations']")
	private WebElement invitationsPageHeader;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-nav')]/..")
	private WebElement actionsPopup;

	// ul[contains(@class,'dropdown-nav')]//li//span/following-sibling::span")
	@FindBy(xpath = "//li//span/following-sibling::span")
	private List<WebElement> actionsList;

	@FindBy(xpath = "//h5[contains(text(),'Edit User:')]")
	private WebElement editPageHeader;

	@FindBy(xpath = "//a[text()='Users  ']")
	private WebElement usersBreadcrumb;

	@FindBy(xpath = "//i[@class='fas fa-ellipsis-v']/..")
	public List<WebElement> actionButtons;

	@FindBy(xpath = "//button[contains(text(),'✖')]/../div[contains(text(),' ')]")
	private WebElement notification;

	@FindBy(xpath = "//button[contains(text(),'✖')]/../div")
	private WebElement notificationText;

	@FindBy(xpath = "//section[@class='panel']//div[@class='loaderOverlay']")
	public WebElement loader;

	@FindBy(xpath = "//button[contains(text(),'✖')]")
	private WebElement notificationCloseButton;

	@FindBy(xpath = "//h2[text()='Reinvite User']")
	private WebElement reinvitePopupText;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement canelBtn;

	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmBtn;

	@FindBy(xpath = "//h2[text()='Reset Password']")
	private WebElement resetPasswordPopupText;

	@FindBy(xpath = "//h5[text()='Set Password']")
	private WebElement setPasswordPageHeader;

	@FindBy(xpath = "//input[@id='newPassword']")
	private WebElement newPasswordField;

	@FindBy(xpath = "//input[@id='confirmNewPassword']")
	private WebElement confirmNewPasswordField;

	@FindBy(xpath = "//button[text()='Change Password']")
	private WebElement changePasswordButton;

	@FindBy(xpath = "//h5[text()='Assign Location']")
	private WebElement assignLocationPageHeaderText;

	@FindBy(xpath = "//label[text()='Please Select an Existing Location: ']/../div/div")
	private WebElement selectLocationDropdownInputField;

	@FindBy(xpath = "//label[text()='Please Select an Existing Location: ']/..//div[contains(@class,'option')]")
	private List<WebElement> LocationDropdownOptions;

	@FindBy(xpath = "//strong[contains(text(),'Selected User Email:')]/..")
	private WebElement selectedUserEmail;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//h5/strong[text()='Location Details']")
	private WebElement locationDetailsHeaderText;

	@FindBy(xpath = "//h2[text()='Resend Invite']")
	private WebElement resendInvitedPopupText;

	@FindBy(xpath = "//h2[text()='Revoke Access']")
	private WebElement revokeAccessPopupText;

	@FindBy(xpath = "//h2[text()='Revoke Invite']")
	private WebElement revokeInvitePopupText;

	@FindBy(xpath = "//h2[text()='Extend Access']")
	private WebElement extendAccessPopupText;

	@FindBy(xpath = "//input[@type='radio']/..")
	private List<WebElement> expiryRadioOptionLabel;

	@FindBy(xpath = "//input[@type='radio']")
	private List<WebElement> expiryRadioOption;

	@FindBy(xpath = "//input[@type='date']")
	private WebElement expiryDateCalender;

	@FindBy(xpath = "//button[text()='Create New User']")
	private WebElement createNewUserBtn;

	@FindBy(xpath = "//h5[text()='Create New Users']")
	private WebElement createNewuserPageHeaderText;

	@FindBy(xpath = "//select[@name='select_role']")
	private WebElement selectRoleDropdown;

	@FindBy(xpath = "//section[@class='panel']//button[text()='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//h5[text()='New User']")
	private WebElement newUserFormHeader;

	@FindBy(xpath = "//label[contains(text(),'First Name')]/../input")
	private WebElement firstNameField;

	@FindBy(xpath = "//label[contains(text(),'Last Name')]/../input")
	private WebElement lastNameField;

	@FindBy(xpath = "//label[contains(text(),'Street')]/../input")
	private WebElement streetField;

	@FindBy(xpath = "//label[contains(text(),'City')]/../input")
	private WebElement cityField;

	@FindBy(xpath = "//label[contains(text(),'State')]/../input")
	private WebElement stateField;

	@FindBy(xpath = "//label[contains(text(),'Zipcode')]/../input")
	private WebElement zipCodeField;

	@FindBy(xpath = "//label[contains(text(),'Email')]/../input")
	private WebElement emailinputField;

	@FindBy(xpath = "//label[contains(text(),'Phone Number')]/../input")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//label[contains(text(),'First Name')]/..")
	private WebElement firstNameFieldTooltip;

	@FindBy(xpath = "//label[contains(text(),'Last Name')]/..")
	private WebElement lastNameFieldTooltip;

	@FindBy(xpath = "//label[contains(text(),'Street')]/..")
	private WebElement streetFieldtooltip;

	@FindBy(xpath = "//label[contains(text(),'City')]/..")
	private WebElement cityFieldTooltip;

	@FindBy(xpath = "//label[contains(text(),'State')]/..")
	private WebElement stateFieldTooltip;

	@FindBy(xpath = "//label[contains(text(),'Zipcode')]/..")
	private WebElement zipCodeFieldTooltip;

	@FindBy(xpath = "//label[contains(text(),'Email')]/..")
	private WebElement emailinputFieldTooltip;

	@FindBy(xpath = "//label[contains(text(),'Phone Number')]/..")
	private WebElement phoneNumberFieldTooltip;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement createButton;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	private WebElement backButton;

	@FindBy(xpath = "//div[contains(@class,'fileUploader')]//img")
	private WebElement fileUploadArea;

	@FindBy(xpath = "//button[text()='Upload Image']")
	private WebElement uploadImageButton;

	@FindBy(xpath = "//div[contains(@class,'fileUploader')]/..")
	private WebElement FileUploadFieldTooltip;

	@FindBy(xpath = "//h3[text()='User Created Successfully']")
	private WebElement userCreatedPopupHeader;

	@FindBy(xpath = "//button[text()='Later']")
	private WebElement laterBtn;

	@FindBy(xpath = "//button[text()='Create New Location']")
	private WebElement createNewLocationBtn;

	@FindBy(xpath = "//button[text()='Assign Existing Location']")
	private WebElement assignExistingLocation;

	@FindBy(xpath = "//h5[contains(text(),'Remove User:')]")
	private WebElement removeUserHeader;

	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;
	// @FindBy(xpath ="")
	// private WebElement
	// @FindBy(xpath ="")
	// private WebElement

	public boolean isUsersPageHeaderDisplayed() {
		try {
			util.waitForVisibilityOfElement(driver, usersPageHeader);
			if (usersPageHeader.isDisplayed()) {
				return true;
			}
			// util.addBase64ScreenShotToReport(driver, test, "Failed Profile Setting");
			return false;
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch header text");
			return false;
		}
	}

	public String getPageHeader() {
		return usersPageHeader.getText();
	}

	public String getValueforRoleDropdown() {
		try {
			return util.getSelectedOption(driver, roleDropdown).getText();
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch default value of Role dropdown");
			return "no result";
		}
	}

	public boolean verifyDefaultValuforRoleDropdown() {
		if (getValueforRoleDropdown().equalsIgnoreCase("All")) {
			test.log(Status.PASS, "Default value for Roll dropdown is 'ALL'");
			return true;
		} else {
			test.log(Status.FAIL, "Default value for Roll dropdown is not 'ALL'");
			return false;
		}
	}

	public String getValueforStatusDropdown() {
		try {
			return util.getSelectedOption(driver, statusDropdown).getText();
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch default value of Status dropdown");
			return "no result";
		}
	}

	public boolean verifyDefaultValuforStatusDropdown() {
		if (getValueforStatusDropdown().equalsIgnoreCase("All")) {
			test.log(Status.PASS, "Default value for Status dropdown is 'ALL'");
			return true;
		} else {
			test.log(Status.FAIL, "Default value for Status dropdown is not 'ALL'");
			return false;
		}
	}

	public boolean isEmailFieldBlank() {
		try {
			util.waitForVisibilityOfElement(driver, emailField);
			if (emailField.isDisplayed() && emailField.getText().isEmpty()) {
				test.log(Status.PASS, "Email filed is by default blank");
				return true;
			} else {
				test.log(Status.FAIL, "Email filed is not blank");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch email field");
			return false;
		}
	}

	public boolean isLocationNameBlank() {
		try {
			util.waitForVisibilityOfElement(driver, locationNameField);
			if (locationNameField.isDisplayed() && locationNameField.getText().isEmpty()) {
				test.log(Status.PASS, "Location Filed is by default blank");
				return true;
			} else {
				test.log(Status.FAIL, "Location FIels is not blank");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed to fetch Location Name field");
			return false;
		}
	}

	public boolean isInvitationsButtonDisplayed() {
		try {
			util.waitForVisibilityOfElement(driver, invitationButton);
			if (invitationButton.isDisplayed()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch Invitations button");
			return false;
		}
	}

	public void selectInvitation() {
		try {
			if (isInvitationsButtonDisplayed()) {
				invitationButton.click();
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to slect Invitations button");
			e.printStackTrace();
		}
	}

	public boolean isFilterButtonEnabled() {
		try {
			util.waitForVisibilityOfElement(driver, filterButton);
			if (filterButton.isDisplayed() && filterButton.isEnabled()) {
				// test.log(Status.PASS, "Filter button is displayed and is enabled");
				return true;
			} else {
				test.log(Status.FAIL, "Filter button is not displayed/enabled");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch filtetr button");
			return false;
		}
	}

	public void clickOnFilterButton() {
		try {
			if (isFilterButtonEnabled()) {
				filterButton.click();
			} else {
				test.log(Status.FAIL, "Failed to Click on Filter button");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Click on Filter button");
			e.printStackTrace();
		}
	}

	public boolean isClearFilterButtonEnabled() {
		try {
			util.waitForVisibilityOfElement(driver, clearFilterButton);
			if (clearFilterButton.isDisplayed() && clearFilterButton.isEnabled()) {
				// test.log(Status.PASS, "Clear filter button is displayed and is enabled");
				return true;
			} else {
				test.log(Status.FAIL, "Clear filter button is not displayed/enabled");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch clear filtetr button");
			return false;
		}
	}

	public void clickOnClearFilterButton() {
		try {
			if (isClearFilterButtonEnabled()) {
				clearFilterButton.click();
				util.waitForElementWithFrequency(driver, clearFilterButton, 10, 2);
			} else {
				test.log(Status.FAIL, "Failed to Click on Clear Filter button");
			}
		} catch (Exception e) {
			test.log(Status.PASS, "Failed to slect Clear button");
			e.printStackTrace();
		}
	}

	public boolean verifyClearFilterFunctionality() {

		clickOnClearFilterButton();
		boolean con1 = getValueforRoleDropdown().equalsIgnoreCase("All");
		boolean con2 = getValueforStatusDropdown().equalsIgnoreCase("All");

		if (con1 && con2) {
			test.log(Status.PASS, "Fileter cleared successfuly");
			return true;
		}
		return false;

	}

	public boolean filterByRole() {
		boolean result = false;
		try {
			util.waitForVisibilityOfElement(driver, roleDropdown);
			List<WebElement> options = util.getSelectOptions(roleDropdown);
			int rollOptionSize = options.size();

			for (int i = 0; i <= rollOptionSize; i++) {
				util.selectDropdownByIndex(roleDropdown, i);
				clickOnFilterButton();

				if (util.getSelectedOption(driver, roleDropdown).getText().equals(options.get(i).getText())) {
					result = true;
				} else {
					result = false;
				}

			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed to filter by Role");
			return false;
		}

	}

	public boolean verifyAvailableOptionsForRoleFilter(String role) {

		Map<String, List<String>> expectedOptions = new HashMap<>();
		expectedOptions.put("superadmin", Arrays.asList("All", "SuperAdmin", "Merchant", "Power"));
		expectedOptions.put("merchant", Arrays.asList("All", "Merchant", "Power"));
		expectedOptions.put("power", Arrays.asList("All", "Merchant", "Power"));

		List<String> expected = expectedOptions.get(role.toLowerCase());

		List<String> actualOptions = new ArrayList<>();

		util.waitForVisibilityOfElement(driver, roleDropdown);
		util.waitForVisibilityOfAllElements(driver, util.getAllOption(roleDropdown));
		List<WebElement> optionElements = util.getAllOption(roleDropdown);
		actualOptions = optionElements.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());

		Set<String> expectedSet = new HashSet<String>();
		expectedSet.addAll(expected);
		// for(String s :expected) {
		// expectedSet.addAll(expected);
		// }
		Set<String> actualSet = new HashSet<>(actualOptions);

		if (actualSet.equals(expectedSet)) {
			System.out.println("Role dropdown options match Login role: " + role);
			test.log(Status.PASS, "Role dropdown options for " + role + ": " + actualOptions);
			return true;
		} else {
			test.log(Status.FAIL, "Role dropdown options mismatch for " + role + "\n" + "Expected: " + expected + "\n"
					+ "Actual:   " + actualOptions);

			return false;
		}

	}

	public boolean verifyAvailableOptionsForStatusFilter(String role) {

		List<String> expectedOptions = Arrays.asList("All", "CONFIRMED", "UNCONFIRMED", "FORCE_CHANGE_PASSWORD",
				"RESET_REQUIRED");

		List<String> actualOptions = new ArrayList<>();

		List<WebElement> optionElements = util.getAllOption(statusDropdown);
		actualOptions = optionElements.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());

		Set<String> expectedSet = new HashSet<>(expectedOptions);
		Set<String> actualSet = new HashSet<>(actualOptions);

		if (actualSet.equals(expectedSet)) {
			System.out.println("Status dropdown options match Login role: " + role);
			test.log(Status.PASS, "Status dropdown options for " + role + ": " + actualOptions);
			return true;
		} else {
			test.log(Status.FAIL, "Status dropdown options mismatch for " + role + "\n" + "Expected: " + expectedSet
					+ "\n" + "Actual:   " + actualOptions);

			return false;
		}

	}

	public boolean verifyNavigateToUsersPage() {

		// home.isBusinessOverviewInfoDisplayed();
		home.clickOnUseManagement();
		if (profile.verifyNavigationToProfileSetting()) {
			profile.clickonUsersbutton();
			util.waitForVisibilityOfElementLocatorWithWait(driver, "//h5[text()='Users']", 30);
			if (getPageHeader().equals("Users")) {
				test.log(Status.PASS, "Successfully Navigated to Users page");
				return true;
			} else {
				test.log(Status.FAIL, "failed to navigate to the users page");
				return false;
			}
		} else {
			test.log(Status.FAIL, "Failed to navigate to the profile page");
			return false;
		}

	}

	public String getColumnName(int colNumber) {
		util.waitForVisibilityOfAllElements(driver, tableHeaderOptopns);
		// System.out.println("Tableheader size ="+tableHeaderOptopns.size());
		for (int i = 1; i < tableHeaderOptopns.size(); i++) {
			if (i == colNumber) {
				// System.out.println("Tableheader title
				// ("+i+")="+tableHeaderOptopns.get(i).getText());
				return tableHeaderOptopns.get(i).getText();
			}
		}
		return null;
	}

	public int getcolumnNumber(String colName) {
		util.waitForVisibilityOfAllElements(driver, tableHeaderOptopns);
		int colNum = 0;
		for (int i = 1; i < tableHeaderOptopns.size(); i++) {
			// if (i == 1) {
			// continue;
			// }

			// System.out.println("column name : "+tableHeaderOptopns.get(i).getText());
			String columnName = tableHeaderOptopns.get(i).getText();

			if (!columnName.isBlank() && !columnName.isEmpty() && columnName.contains(colName)) {
				// System.out.println("column number for:" + colName + " is : " + i);
				// System.out.println("column name:" + getColumnName(i));
				colNum = i;
				break;
			}

		}
		return colNum;
	}

	public int getRowCount() {
		util.waitForVisibilityOfAllElements(driver, rows);
		return rows.size();
	}

	public String getColumnValueforRow(int row, String column) {

		int columnNum = getcolumnNumber(column);
		columnNum++;
		String locator = "//tbody//tr[" + row + "]//td[" + columnNum + "]";
		util.waitForPresenceOfElementByLocator(driver, locator);
		util.waitForVisibilityOfElement(driver, (driver.findElement(By.xpath(locator))));
		String colvalue = driver.findElement(By.xpath(locator)).getText();

		return colvalue;
	}

	public boolean verifyFilterByRole() {
		boolean result = false;
		util.waitForVisibilityOfElement(driver, roleDropdown);
		List<WebElement> options = util.getAllOption(roleDropdown);
		for (int i = 0; i < options.size(); i++) {

			clickOnClearFilterButton();
			util.waitForVisibilityOfElement(driver, roleDropdown);
			String expectedoptText = util.getAllOption(roleDropdown).get(i).getText().trim();
			if (expectedoptText.equalsIgnoreCase("All")) {
				continue;
			}
			System.out.println("filter by:" + expectedoptText);
			util.selectDropdownByVisibleText(roleDropdown, util.getAllOption(roleDropdown).get(i).getText());
			clickOnFilterButton();

			util.waitForVisibilityOfAllElements(driver, rows);
			if (rows.size() == 1) {
				System.out.println("No results found for the Status filter");
				continue;
			}

			for (int r = 1; r <= rows.size(); r++) {
				System.out.println("checking in table for role option:" + expectedoptText);
				String actualiOptionText = getColumnValueforRow(r, "Role");
				if (getColumnValueforRow(r, "Role").equalsIgnoreCase(expectedoptText)) {
					System.out.println("option found: " + actualiOptionText);

					result = true;
				} else {
					System.out.println(
							"wrong option found: expected:" + expectedoptText + " found: " + actualiOptionText);
					test.log(Status.FAIL,
							"Filter by Role: '" + expectedoptText + "' shows different results :" + actualiOptionText);
					util.addBase64ScreenShotToReport(driver, test, "FilterByText");
					return false;
				}
			}
			if (result) {
				test.log(Status.PASS, "Filter by Role '" + expectedoptText + "' shows proper results");
			}
		}
		if (result) {
			test.log(Status.PASS, "Filter by Role shows proper results");
			return true;
		}

		return false;
	}

	public boolean verifyFilterByStatus() {
		boolean result = false;
		util.waitForVisibilityOfElement(driver, statusDropdown);
		List<WebElement> options = util.getAllOption(statusDropdown);
		for (int i = 0; i < options.size(); i++) {

			clickOnClearFilterButton();
			util.waitForVisibilityOfElement(driver, statusDropdown);
			String expectedoptText = util.getAllOption(statusDropdown).get(i).getText().trim();
			if (expectedoptText.equalsIgnoreCase("All")) {
				continue;
			}
			System.out.println("filter by:" + expectedoptText);
			util.selectDropdownByVisibleText(statusDropdown, util.getAllOption(statusDropdown).get(i).getText());
			clickOnFilterButton();

			util.waitForVisibilityOfAllElements(driver, rows);
			if (rows.size() == 1) {
				System.out.println("No results found for the Status filter");
				continue;
			}

			for (int r = 1; r <= rows.size(); r++) {
				// expectedoptText=expectedoptText.replaceAll("_", " ");
				System.out.println("checking in table for Status option:" + expectedoptText);
				String actualiOptionText = getColumnValueforRow(r, "Status");
				if ((getColumnValueforRow(r, "Status").replaceAll("_", " "))
						.equalsIgnoreCase(expectedoptText.replaceAll("_", " "))) {
					System.out.println("option found: " + actualiOptionText);

					result = true;
				} else {
					System.out.println(
							"wrong option found: expected:" + expectedoptText + " found: " + actualiOptionText);
					test.log(Status.FAIL, "Filter by Status: '" + expectedoptText + "' shows different results :"
							+ actualiOptionText);
					util.addBase64ScreenShotToReport(driver, test, "FilterByText");
					return false;
				}
			}
			if (result) {
				test.log(Status.PASS, "Filter by Status '" + expectedoptText + "' shows proper results");
			}
		}
		if (result) {
			test.log(Status.PASS, "Filter by Status shows proper results");
			return true;
		}

		return false;
	}

	public boolean verifyInvitationsButton() {
		try {
			util.waitForVisibilityOfElement(driver, invitationButton);

			if (invitationButton.isDisplayed() && invitationButton.isEnabled()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Faled to load the invitations button");
			util.addBase64ScreenShotToReport(driver, test, "InvitationsB_utton");
			e.printStackTrace();
			return false;
		}
	}

	public void clickOnInvitaionsButton() {

		if (verifyInvitationsButton()) {
			invitationButton.click();
		} else {
			test.log(Status.FAIL, "Faled to click on the invitations button");
		}
	}

	public boolean isInvitationPageHeaderDisplayed() {
		try {
			util.waitForVisibilityOfElement(driver, invitationsPageHeader);
			if (invitationsPageHeader.isDisplayed()) {
				return true;
			} else {
				test.log(Status.FAIL, "Failed to displaye Invations header");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to loade Invations header");
			util.addBase64ScreenShotToReport(driver, test, getPageHeader());
			e.printStackTrace();
			return false;
		}

	}

	public boolean verifyNavigationToInvitationsPgae() {
		clickOnInvitaionsButton();

		if (isInvitationPageHeaderDisplayed()) {
			test.log(Status.PASS, "Navigated to Invitations page successfuly");
			util.addBase64ScreenShotToReport(driver, test, "InvitationPage");
			return true;
		} else {
			test.log(Status.FAIL, "Failed to Navigate to Invitations page");
			return false;
		}
	}

	public boolean verifyAvailableOptionsForStatusFilterInvitationPage(String role) {

		List<String> expectedOptions = Arrays.asList("All", "Invitation Sent", "Accepted", "Invitation Revoked",
				"Access Revoked", "Expired");

		List<String> actualOptions = new ArrayList<>();

		List<WebElement> optionElements = util.getAllOption(statusDropdown);
		actualOptions = optionElements.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());

		Set<String> expectedSet = new HashSet<>(expectedOptions);
		Set<String> actualSet = new HashSet<>(actualOptions);

		if (actualSet.equals(expectedSet)) {
			System.out.println("Status dropdown options match Login role: " + role);
			test.log(Status.PASS, "Status dropdown options for " + role + ": " + actualOptions);
			return true;
		} else {
			test.log(Status.FAIL, "Status dropdown options mismatch for " + role + "\n" + "Expected: " + expectedSet
					+ "\n" + "Actual:   " + actualOptions);

			return false;
		}

	}

	public void selectActionsButtonforRow(int rownum) {

		util.waitForVisibilityOfAllElements(driver, actionButtons);
		for (int i = 0; i < actionButtons.size(); i++) {

			if (i == rownum) {
				WebElement action = actionButtons.get(i);
				util.hoverOnElementInView(driver, action);

				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
				// util.forceClick(driver, action);
				action.click();
				System.out.println("Clicked on actions button");
			}
		}

	}

	public void navigatBackToUsersPage() {
		util.waitForVisibilityOfElement(driver, usersBreadcrumb);
		usersBreadcrumb.click();
		util.waitForVisibilityOfAllElements(driver, rows);
	}

	public boolean validateEditActionForUserTable() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int o = 0;
			boolean isActionPresent = false;
			for (int row = 0; row < 3; row++) {

				String userName = getColumnValueforRow(row + 1, "User Name");
				String email = getColumnValueforRow(row + 1, "Email");
				System.out.println("UsereName: " + userName);
				System.out.println("Email :" + email);

				selectActionsButtonforRow(row);
				util.waitForVisibilityOfElement(driver, actionsPopup);

				if (actionsPopup.isDisplayed()) {
					// test.log(Status.PASS, "Action popup is displayed");
					util.waitForVisibilityOfAllElements(driver, actionsList);

					for (int opt = 0; opt < actionsList.size(); opt++) {

						// try {
						// Thread.sleep(1000);
						// } catch (Exception e) {
						//
						// }
						util.waitForVisibilityOfElement(driver, actionsList.get(opt));
						if (!(actionsList.get(opt).getText().equals("Edit"))) {
							isActionPresent = false;
							continue;
						} else {
							util.hoverOnElementInView(driver, actionsList.get(opt));
							isActionPresent = true;
							actionsList.get(opt).click();
							util.waitForVisibilityOfElement(driver, editPageHeader);

							System.out.println("Edit page header" + editPageHeader.getText());

							if (editPageHeader.getText().contains(email)) {
								System.out.println("suceesfully lodaed an edit user pahe");
							} else {
								System.out.println("Failed to load edit page for user:" + email
										+ " Expected naeme contains found: "
										+ editPageHeader.getText().replace("Edit User: ", "").trim());
								util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
								test.log(Status.FAIL,
										"Failed to load edit page for user:" + email
												+ " Expected naeme contains found: "
												+ editPageHeader.getText().replace("Edit User: ", "").trim());
								o++;
							}
							navigatBackToUsersPage();
						}
					}
					if (!isActionPresent) {
						test.log(Status.FAIL, "Actions does not contain Edit option for user with email:" + email);
						util.addBase64ScreenShotToReport(driver, test, "Actions Edit option missing");
						return false;
					}
				} else {
					util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
					test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
					return false;
				}
			}
			if (o > 0) {
				return false;
			} else {
				test.log(Status.PASS, "Successfuly navigatetd to the Edit User page");
				return true;
			}

		}

	}

	public boolean validateEnableDesableActionForUserTable() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int o = 0;
			// boolean isActionPresent = false;
			for (int row = 0; row < 3; row++) {
				for (int j = 0; j <= 1; j++) {

					String userName = getColumnValueforRow(row + 1, "User Name");
					String email = getColumnValueforRow(row + 1, "Email");
					String status = getColumnValueforRow(row + 1, "Status");
					System.out.println("UsereName: " + userName);
					System.out.println("Email :" + email);
					System.out.println("Status :" + status);

					if (!status.equalsIgnoreCase("UNCONFIRMED")) {

						selectActionsButtonforRow(row);

						util.waitForVisibilityOfElement(driver, actionsPopup);

						if (actionsPopup.isDisplayed()) {
							// test.log(Status.PASS, "Action popup is displayed");
							util.waitForVisibilityOfAllElements(driver, actionsList);

							for (int opt = 0; opt < actionsList.size(); opt++) {

								util.waitForVisibilityOfElement(driver, actionsList.get(opt));

								if (actionsList.get(opt).getText().equalsIgnoreCase("Enable")
										|| actionsList.get(opt).getText().equalsIgnoreCase("Disable")) {
									System.out.println("Found  Action :" + actionsList.get(opt).getText());

									util.hoverOnElementInView(driver, actionsList.get(opt));
									actionsList.get(opt).click();
									util.waitForVisibilityOfElement(driver, notification);
									util.waitForVisibilityOfElement(driver, notificationText);

									if (notificationText.getText().contains("User Enabled successfully")) {
										System.out.println("'User Enabled successfully' Message is displayed");
										util.waitForVisibilityOfElement(driver, notificationCloseButton);
										util.addBase64ScreenShotToReport(driver, test, "Enable User Notifiaction");
										notificationCloseButton.click();
										test.log(Status.PASS,
												"'User Enabled successfully' Message is displayed for user with email: "
														+ email);

									} else if (notificationText.getText().contains("User Disabled successfully")) {
										System.out.println(
												"'User Desable successfully' Message is displayed for user with email: "
														+ email);
										util.addBase64ScreenShotToReport(driver, test, "Desable User Notifiaction");
										util.waitForVisibilityOfElement(driver, notificationCloseButton);
										notificationCloseButton.click();
										test.log(Status.PASS,
												"'User Desable successfully' Message is displayed for user with email: "
														+ email);
										// util.addBase64ScreenShotToReport(driver, test, "User Disabled notification");
									} else {
										test.log(Status.FAIL,
												"Failed to display the notification message for user with email: "
														+ email);
										o++;
									}
								}
								// else {
								// //util.addBase64ScreenShotToReport(driver, test, "Actions issue");
								// continue;
								// }
							}

						} else {
							util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
							test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
							return false;
						}
					} else {
						continue;
					}
				}
			}

			if (o > 0) {
				test.log(Status.FAIL, "Enable/Desable Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Enable/Desable Action Verification Sucessful");
				return true;
			}
		}
	}

	public boolean validateReinviteActionForUserTable() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int o = 0;
			// boolean isActionPresent = false;
			for (int row = 0; row < 1; row++) {
				// for (int j = 0; j <= 1; j++) {

				String userName = getColumnValueforRow(row + 1, "User Name");
				String email = getColumnValueforRow(row + 1, "Email");
				String status = getColumnValueforRow(row + 1, "Status");
				System.out.println("UsereName: " + userName);
				System.out.println("Email :" + email);
				System.out.println("Status :" + status);

				selectActionsButtonforRow(row);

				util.waitForVisibilityOfElement(driver, actionsPopup);

				if (actionsPopup.isDisplayed()) {
					// test.log(Status.PASS, "Action popup is displayed");
					util.waitForVisibilityOfAllElements(driver, actionsList);

					for (int opt = 0; opt < actionsList.size(); opt++) {

						util.waitForVisibilityOfElement(driver, actionsList.get(opt));

						if (actionsList.get(opt).getText().equalsIgnoreCase("Reinvite")) {
							System.out.println("Found  Action :" + actionsList.get(opt).getText());

							util.hoverOnElementInView(driver, actionsList.get(opt));
							actionsList.get(opt).click();

							util.waitForVisibilityOfElement(driver, reinvitePopupText);

							if (reinvitePopupText.isDisplayed()) {
								System.out.println("'ReinviteUser' Popup is displayed");
								if (canelBtn.isEnabled() && confirmBtn.isEnabled()) {
									canelBtn.click();
									test.log(Status.PASS,
											"'Navigated to Reinvite popup succesfuly and clicked on cancel for user with email: "
													+ email);
								} else {
									test.log(Status.FAIL,
											"Cancle/ confirm button is not enabled for user with email:" + email);
									o++;
								}

							} else {
								test.log(Status.FAIL,
										"Failed to Navigated to Reinvite popup for user with email: " + email);
								o++;
							}
						} else {
							continue;
						}
					}
				} else {
					util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
					test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
					return false;
				}
				// }
			}
			if (o > 0) {
				test.log(Status.FAIL, "Reinvite Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Reinvite Action Verification Sucessful");
				return true;
			}
		}

	}

	public boolean validateResetPasswordFunctionality() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int o = 0;
			// boolean isActionPresent = false;
			for (int row = 0; row < 1; row++) {
				// for (int j = 0; j <= 1; j++) {

				String userName = getColumnValueforRow(row + 1, "User Name");
				String email = getColumnValueforRow(row + 1, "Email");
				String status = getColumnValueforRow(row + 1, "Status");
				System.out.println("UsereName: " + userName);
				System.out.println("Email :" + email);
				System.out.println("Status :" + status);

				selectActionsButtonforRow(row);

				util.waitForVisibilityOfElement(driver, actionsPopup);

				if (actionsPopup.isDisplayed()) {
					// test.log(Status.PASS, "Action popup is displayed");
					util.waitForVisibilityOfAllElements(driver, actionsList);

					for (int opt = 0; opt < actionsList.size(); opt++) {

						util.waitForVisibilityOfElement(driver, actionsList.get(opt));

						if (actionsList.get(opt).getText().equalsIgnoreCase("Send Reset Password")) {
							System.out.println("Found  Action :" + actionsList.get(opt).getText());

							util.hoverOnElementInView(driver, actionsList.get(opt));
							actionsList.get(opt).click();

							util.waitForVisibilityOfElement(driver, resetPasswordPopupText);

							if (resetPasswordPopupText.isDisplayed()) {
								System.out.println("'Reset Password' Popup is displayed");
								if (canelBtn.isEnabled() && confirmBtn.isEnabled()) {
									canelBtn.click();
									test.log(Status.PASS,
											"'Navigated to Reset Password popup succesfuly and clicked on cancel for user with email: "
													+ email);
								} else {
									test.log(Status.FAIL,
											"Cancle/ confirm button is not enabled for user with email:" + email);
									o++;
								}

							} else {
								test.log(Status.FAIL,
										"Failed to Navigated to Reset Password popup for user with email: " + email);
								o++;
							}
						} else {
							continue;
						}
					}
				} else {
					util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
					test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
					return false;
				}
				// }
			}
			if (o > 0) {
				test.log(Status.FAIL, "Reset Password Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Reset Password Action Verification Sucessful");
				return true;
			}
		}

	}

	public boolean validateSetPasswordFunctionality() {

		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int o = 0;
			// boolean isActionPresent = false;
			for (int row = 0; row < 1; row++) {
				// for (int j = 0; j <= 1; j++) {

				String userName = getColumnValueforRow(row + 1, "User Name");
				String email = getColumnValueforRow(row + 1, "Email");
				String status = getColumnValueforRow(row + 1, "Status");
				System.out.println("UsereName: " + userName);
				System.out.println("Email :" + email);
				System.out.println("Status :" + status);

				selectActionsButtonforRow(row);

				util.waitForVisibilityOfElement(driver, actionsPopup);

				if (actionsPopup.isDisplayed()) {
					// test.log(Status.PASS, "Action popup is displayed");
					util.waitForVisibilityOfAllElements(driver, actionsList);

					for (int opt = 0; opt < actionsList.size(); opt++) {

						util.waitForVisibilityOfElement(driver, actionsList.get(opt));

						if (actionsList.get(opt).getText().equalsIgnoreCase("Set Password")) {
							System.out.println("Found  Action :" + actionsList.get(opt).getText());

							util.hoverOnElementInView(driver, actionsList.get(opt));
							actionsList.get(opt).click();

							util.waitForVisibilityOfElement(driver, setPasswordPageHeader);

							if (setPasswordPageHeader.isDisplayed()) {
								System.out.println("'Set Password' Popup is displayed");
								if (newPasswordField.isEnabled() && confirmNewPasswordField.isEnabled()) {
									newPasswordField.sendKeys("Welcome@123");
									confirmNewPasswordField.sendKeys("Welcome@123");
									changePasswordButton.click();

									util.waitForVisibilityOfElement(driver, notification);
									if (notification.isDisplayed() && notificationText.getText()
											.contains("Successfully Set New password, Redirecting back")) {
										test.log(Status.PASS,
												"'Navigated to Set Password page and succesfuly set new password: 'Welcome@123' for user with email: "
														+ email);
									} else {
										util.addBase64ScreenShotToReport(driver, test, "Set Password Failed");
										test.log(Status.FAIL,
												"Failed to set new password for user with email:" + email);
										o++;
									}
								} else {
									test.log(Status.FAIL,
											"New Password / Confirm password fields is not enabled for user with email:"
													+ email);
									o++;
								}

							} else {
								test.log(Status.FAIL,
										"Failed to Navigated to Set Password popup for user with email: " + email);
								o++;
							}
						} else {
							continue;
						}
					}
				} else {
					util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
					test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
					return false;
				}
				// }
			}
			if (o > 0) {
				test.log(Status.FAIL, "Set Password Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Set Password Action Verification Sucessful");

				return true;
			}
		}
	}

	public boolean validateAssignLocationFunctionality() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int o = 0;
			// boolean isActionPresent = false;
			// for (int row = 0; row < 3; row++) {
			for (int row = 0; row < rows.size(); row++) {
				// String userName = getColumnValueforRow(row + 1, "User Name");
				// String email = getColumnValueforRow(row + 1, "Email");
				// String status = getColumnValueforRow(row + 1, "Status");
				String locationName = getColumnValueforRow(row + 1, "Location Name");
				// System.out.println("UsereName: " + userName);
				// System.out.println("Email :" + email);
				// System.out.println("Status :" + status);
				// System.out.println("Location Name :" + locationName);

				if (locationName.contains("No location is attached")) {

					String userName = getColumnValueforRow(row + 1, "User Name");
					String email = getColumnValueforRow(row + 1, "Email");
					String status = getColumnValueforRow(row + 1, "Status");

					System.out.println("UsereName: " + userName);
					System.out.println("Email :" + email);
					System.out.println("Status :" + status);
					System.out.println("Location Name :" + locationName);

					selectActionsButtonforRow(row);

					util.waitForVisibilityOfElement(driver, actionsPopup);

					if (actionsPopup.isDisplayed()) {

						try {
							Thread.sleep(1000);
						} catch (Exception e) {

						}

						test.log(Status.PASS, "Action popup is displayed");
						util.waitForVisibilityOfAllElements(driver, actionsList);

						for (int opt = 0; opt < actionsList.size(); opt++) {

							util.waitForVisibilityOfElement(driver, actionsList.get(opt));
							String optionText = actionsList.get(opt).getText();
							System.out.println("Option Text:" + optionText);

							if (optionText.contains("Assign Location")) {
								System.out.println("Found  Action :" + actionsList.get(opt).getText());

								util.hoverOnElementInView(driver, actionsList.get(opt));
								actionsList.get(opt).click();

								util.waitForVisibilityOfElement(driver, assignLocationPageHeaderText);

								try {
									Thread.sleep(1000);
								} catch (Exception e) {

								}

								if (assignLocationPageHeaderText.isDisplayed()) {
									System.out.println("User navigated to Assign Locations page successfully");

									String selectedEmail = selectedUserEmail.getText();

									if (selectedEmail.equals(email) || selectedEmail.contains(email)) {
										test.log(Status.PASS,
												"User navigated to Assign Locations page successfully for user with email: "
														+ email);
										util.addBase64ScreenShotToReport(driver, test, "Assign Locations page");
									} else {
										test.log(Status.FAIL,
												"User navigated to Assign Locations page for user with expected selected email:"
														+ email + ", but found: " + selectedEmail);

										util.addBase64ScreenShotToReport(driver, test, "Assign Locations page");
									}

									util.waitForVisibilityOfElement(driver, selectLocationDropdownInputField);

									// try {

									selectLocationDropdownInputField.click();
									// System.out.println("Cleared the select location field");
									util.getActionObject(driver).sendKeys("Location01 MT").build().perform();

									// selectLocationDropdownInputField.sendKeys("Test Location MT");
									System.out.println("Entered location in select location field");

									util.waitForVisibilityOfAllElements(driver, LocationDropdownOptions);

									for (WebElement option : LocationDropdownOptions) {
										util.waitForVisibilityOfElement(driver, option);
										System.out.println("Location option: " + option.getText());

										if (option.getText().contains("Location01 MT")) {
											option.click();
											System.out.println("Clicked on location option Location01 MT");
											test.log(Status.PASS,
													"Selected location option 'Location01 MT' from dropdown");
											break;
										}
									}
									// for (int ld = 0; ld < LocationDropdownOptions.size(); ld++) {
									// util.waitForVisibilityOfElement(driver,
									// LocationDropdownOptions.get(ld));
									// System.out.println("Location option: "
									// + LocationDropdownOptions.get(ld).getText());

									// if (LocationDropdownOptions.get(ld).getText()
									// .contains("Location MT")) {
									// LocationDropdownOptions.get(ld).click();
									// System.out.println("Clicked on location option Location MT");
									// test.log(Status.PASS,
									// "Selected location option 'Location MT' from dropdown");
									// break;
									// }
									// }

									util.waitForVisibilityOfElement(driver, locationDetailsHeaderText);

									if (locationDetailsHeaderText.isDisplayed()) {
										test.log(Status.PASS, "Location details displayed");
									} else {
										test.log(Status.FAIL, "Failed to display Location Details");
										o++;
									}

									if (selectLocationDropdownInputField.getText().contains("Location01 MT")) {
										submitButton.click();
										util.waitForVisibilityOfElement(driver, notification);
										if (notification.isDisplayed() && notificationText.getText()
												.contains("Location Added Successfully!")) {
											test.log(Status.PASS,
													"Successfully selected the location and assigned");
										} else {
											test.log(Status.FAIL, "Failed to display notification");
										}
									} else {
										test.log(Status.FAIL, "Failed to select the location");
									}

									// } catch (Exception e) {
									// Actions act = util.getActionObject(driver);
									// act.click(selectLocationDropdownInputField);
									// act.sendKeys("01 MT");

									// act.keyDown(Keys.ENTER);
									// act.keyUp(Keys.ENTER);

									// if (!selectLocationDropdownInputField.getText().contains("01 MT")) {
									// test.log(Status.FAIL,
									// "Failed to interact with select location field");
									// } else {
									// o++;
									// }
									// }
									try {
										Thread.sleep(1000);
									} catch (Exception e) {

									}

								} else {
									test.log(Status.FAIL,
											"Failed to navigated to Assign Locations page for user with email: "
													+ email);
									o++;
								}
							} else {
								// test.log(Status.FAIL,
								// "Assign Locations Action option is not available when no Location is attached
								// for user with email: "
								// + email);
								// util.addBase64ScreenShotToReport(driver, test, "Assign Location Action
								// missing");
								// o++;
								continue;
							}
						}

					} else {
						util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
						test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
						return false;
					}

				} else {
					System.out.println("User with No location assigned not found ");
					continue;
				}
			}

			if (o > 0) {
				test.log(Status.FAIL, "Assign Location Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Assign Location Action Verification Sucessful");
				return true;
			}
		}
	}

	public boolean validateResendInviteForInviteUserTable() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int rowsize = 2;
			int o = 0;
			if (rows.size() > 2 && rows.size() < 5) {
				rowsize = 3;
			} else if (rows.size() > 4 && rows.size() < 10) {
				rowsize = rows.size();
			} else if (rows.size() > 10) {
				rowsize = 10;
			} else {

				for (int row = 0; row < rowsize; row++) {

					// String userName = getColumnValueforRow(row + 1, "User Name");
					String email = getColumnValueforRow(row + 1, "Email");
					String status = getColumnValueforRow(row + 1, "Status");
					// System.out.println("UsereName: " + userName);
					System.out.println("Email :" + email);
					System.out.println("Status :" + status);

					if (!(status.equalsIgnoreCase("Accepted"))) {

						selectActionsButtonforRow(row);

						util.waitForVisibilityOfElement(driver, actionsPopup);

						if (actionsPopup.isDisplayed()) {

							util.waitForVisibilityOfAllElements(driver, actionsList);

							for (int opt = 0; opt < actionsList.size(); opt++) {

								util.waitForVisibilityOfElement(driver, actionsList.get(opt));

								if (actionsList.get(opt).getText().equalsIgnoreCase("Resend Invite")) {
									System.out.println("Found  Action :" + actionsList.get(opt).getText());

									util.hoverOnElementInView(driver, actionsList.get(opt));
									actionsList.get(opt).click();

									util.waitForVisibilityOfElement(driver, resendInvitedPopupText);

									if (resendInvitedPopupText.isDisplayed()) {
										System.out.println("'Resend InviteUser' Popup is displayed");
										if (canelBtn.isEnabled() && confirmBtn.isEnabled()) {
											canelBtn.click();
											test.log(Status.PASS,
													"'Navigated to Resend Invite popup succesfuly and clicked on cancel for user with email: "
															+ email);
										} else {
											test.log(Status.FAIL,
													"Cancle/ confirm button is not enabled for user with email:"
															+ email);
											o++;
										}

									} else {
										test.log(Status.FAIL,
												"Failed to Navigated to Resend Invite popup for user with email: "
														+ email);
										o++;
									}
								} else {
									continue;
								}
							}
						} else {
							util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
							test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
							return false;
						}
					}
				}
			}
			if (o > 0) {
				test.log(Status.FAIL, "Resend Invite Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Resend Invite Action Verification Sucessful");
				return true;
			}
		}

	}

	public boolean validateRevokeAccessForInviteUserTable() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int rowsize = 2;
			int o = 0;
			if (rows.size() > 2 && rows.size() < 5) {
				rowsize = 3;
			} else if (rows.size() > 4 && rows.size() < 10) {
				rowsize = rows.size();
			} else if (rows.size() > 10) {
				rowsize = 10;
			} else {

				for (int row = 0; row < rowsize; row++) {

					// String userName = getColumnValueforRow(row + 1, "User Name");
					String email = getColumnValueforRow(row + 1, "Email");
					String status = getColumnValueforRow(row + 1, "Status");
					// System.out.println("UsereName: " + userName);
					System.out.println("Email :" + email);
					System.out.println("Status :" + status);

					if (status.equalsIgnoreCase("Accepted")) {

						selectActionsButtonforRow(row);

						util.waitForVisibilityOfElement(driver, actionsPopup);

						if (actionsPopup.isDisplayed()) {

							util.waitForVisibilityOfAllElements(driver, actionsList);

							for (int opt = 0; opt < actionsList.size(); opt++) {

								util.waitForVisibilityOfElement(driver, actionsList.get(opt));

								if (actionsList.get(opt).getText().equalsIgnoreCase("Revoke Access")) {
									System.out.println("Found  Action :" + actionsList.get(opt).getText());

									util.hoverOnElementInView(driver, actionsList.get(opt));
									actionsList.get(opt).click();

									util.waitForVisibilityOfElement(driver, revokeAccessPopupText);

									if (revokeAccessPopupText.isDisplayed()) {
										System.out.println("'Revoke Access' Popup is displayed");

										if (canelBtn.isEnabled() && confirmBtn.isEnabled()) {
											canelBtn.click();
											test.log(Status.PASS,
													"'Navigated to Revoke Access popup succesfuly and clicked on cancel for user with email: "
															+ email);
										} else {
											test.log(Status.FAIL,
													"Cancle/ confirm button is not enabled for user with email:"
															+ email);
											o++;
										}

									} else {
										test.log(Status.FAIL,
												"Failed to Navigated to Revoke Access popup for user with email: "
														+ email);
										o++;
									}
								} else {
									continue;
								}
							}
						} else {
							util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
							test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
							return false;
						}
					}
				}
			}

			if (o > 0) {
				test.log(Status.FAIL, "Revoke Access Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Revoke Access Action Verification Sucessful");
				return true;
			}
		}

	}

	public boolean validateExtendAccessForInviteUserTable() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int rowsize = 2;
			int o = 0;
			if (rows.size() > 2 && rows.size() < 5) {
				rowsize = 3;
			} else if (rows.size() > 4 && rows.size() < 10) {
				rowsize = rows.size();
			} else if (rows.size() > 10) {
				rowsize = 10;
			} else {

				for (int row = 0; row < rowsize; row++) {

					// String userName = getColumnValueforRow(row + 1, "User Name");
					String email = getColumnValueforRow(row + 1, "Email");
					String status = getColumnValueforRow(row + 1, "Status");
					// System.out.println("UsereName: " + userName);
					System.out.println("Email :" + email);
					System.out.println("Status :" + status);

					if (status.equalsIgnoreCase("Accepted")) {

						selectActionsButtonforRow(row);

						util.waitForVisibilityOfElement(driver, actionsPopup);

						if (actionsPopup.isDisplayed()) {

							util.waitForVisibilityOfAllElements(driver, actionsList);

							for (int opt = 0; opt < actionsList.size(); opt++) {

								util.waitForVisibilityOfElement(driver, actionsList.get(opt));

								if (actionsList.get(opt).getText().equalsIgnoreCase("Extend Access")) {
									System.out.println("Found  Action :" + actionsList.get(opt).getText());

									util.hoverOnElementInView(driver, actionsList.get(opt));
									actionsList.get(opt).click();

									util.waitForVisibilityOfElement(driver, extendAccessPopupText);

									if (extendAccessPopupText.isDisplayed()) {
										System.out.println("'Extend Access' Popup is displayed");

										util.waitForVisibilityOfAllElements(driver, expiryRadioOptionLabel);

										for (int e = expiryRadioOptionLabel.size() - 1; e >= 0; e--) {
											expiryRadioOption.get(e).click();

											if (e == 1 && expiryRadioOption.get(e).isSelected()) {
												test.log(Status.PASS, "'" + expiryRadioOptionLabel.get(e).getText() +
														"' radio button is sleected");
												if (expiryDateCalender.isDisplayed()) {
													test.log(Status.PASS,
															"Selection of '" + expiryRadioOptionLabel.get(e).getText() +
																	"' radio button displays calender selection");
												} else {
													test.log(Status.FAIL, "claender is not displayed");
													o++;
												}

											} else if (e == 0) {
												if (expiryRadioOption.get(e).isSelected()) {
													test.log(Status.PASS,
															"'" + expiryRadioOptionLabel.get(e).getText() +
																	"' radio button is sleected");
												} else {
													test.log(Status.FAIL, "Failed to select '"
															+ expiryRadioOptionLabel.get(e).getText() + "'");
													o++;
												}
											}
											try {
												Thread.sleep(1000);
											} catch (Exception k) {

											}
										}

										if (canelBtn.isEnabled() && confirmBtn.isEnabled()) {
											canelBtn.click();
											test.log(Status.PASS,
													"'Navigated to Extend Access  popup succesfuly and clicked on cancel for user with email: "
															+ email);
										} else {
											test.log(Status.FAIL,
													"Cancle/ confirm button is not enabled for user with email:"
															+ email);
											o++;
										}

									} else {
										test.log(Status.FAIL,
												"Failed to Navigated to Revoke Access popup for user with email: "
														+ email);
										o++;
									}
								} else {
									continue;
								}
							}
						} else {
							util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
							test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
							return false;
						}
					}
				}
			}
			if (o > 0) {
				test.log(Status.FAIL, "Extend Access Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Extend Access Action Verification Sucessful");
				return true;
			}
		}

	}

	public boolean validateRevokeInviteForInviteUserTable() {
		util.waitForVisibilityOfAllElements(driver, rows);
		if (rows.size() <= 1) {
			System.out.println("No results found ");
			test.log(Status.FAIL, "No data availabe");
			return false;
		} else {
			int rowsize = 2;
			int o = 0;
			if (rows.size() > 2 && rows.size() < 5) {
				rowsize = 3;
			} else if (rows.size() > 4 && rows.size() < 10) {
				rowsize = rows.size();
			} else if (rows.size() > 10) {
				rowsize = 10;
			} else {

				for (int row = 0; row < rowsize; row++) {

					// String userName = getColumnValueforRow(row + 1, "User Name");
					String email = getColumnValueforRow(row + 1, "Email");
					String status = getColumnValueforRow(row + 1, "Status");
					// System.out.println("UsereName: " + userName);
					System.out.println("Email :" + email);
					System.out.println("Status :" + status);

					if (status.equalsIgnoreCase("Invitation Sent")) {

						selectActionsButtonforRow(row);

						util.waitForVisibilityOfElement(driver, actionsPopup);

						if (actionsPopup.isDisplayed()) {

							util.waitForVisibilityOfAllElements(driver, actionsList);

							for (int opt = 0; opt < actionsList.size(); opt++) {

								util.waitForVisibilityOfElement(driver, actionsList.get(opt));

								if (actionsList.get(opt).getText().equalsIgnoreCase("Revoke Access")) {
									System.out.println("Found  Action :" + actionsList.get(opt).getText());

									util.hoverOnElementInView(driver, actionsList.get(opt));
									actionsList.get(opt).click();

									util.waitForVisibilityOfElement(driver, revokeInvitePopupText);

									if (revokeInvitePopupText.isDisplayed()) {
										System.out.println("'Revoke Access' Popup is displayed");

										if (canelBtn.isEnabled() && confirmBtn.isEnabled()) {
											canelBtn.click();
											test.log(Status.PASS,
													"'Navigated to Revoke Invite popup succesfuly and clicked on cancel for user with email: "
															+ email);
										} else {
											test.log(Status.FAIL,
													"Cancle/ confirm button is not enabled for user with email:"
															+ email);
											o++;
										}

									} else {
										test.log(Status.FAIL,
												"Failed to Navigated to Revoke Invite popup for user with email: "
														+ email);
										o++;
									}
								} else {
									continue;
								}
							}
						} else {
							util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
							test.log(Status.FAIL, "Actions popup failed to open for user with email:" + email);
							return false;
						}
					}
				}
			}

			if (o > 0) {
				test.log(Status.FAIL, "Revoke Invite Action Verification Failed");

				return false;
			} else {
				test.log(Status.PASS, "Revoke Invite Action Verification Sucessful");
				return true;
			}
		}

	}

	public boolean verifyNavigateToCreateNewUserPage() {
		util.waitForVisibilityOfElement(driver, createNewUserBtn);
		if (createNewUserBtn.isDisplayed()) {
			createNewUserBtn.click();
			util.waitForVisibilityOfElement(driver, createNewuserPageHeaderText);
			if (createNewuserPageHeaderText.isDisplayed()) {
				test.log(Status.PASS, "Navigated to 'Create New User' page successfuly");
				return true;
			} else {
				test.log(Status.FAIL, "Failed to navigate to 'Create New User' page");
				return false;
			}
		} else {
			test.log(Status.FAIL, "'Create New User' button failed to display");
			return false;
		}

	}

	public boolean verifyDefaultValueOfSelectRoleDropdoen() {
		util.waitForVisibilityOfElement(driver, selectRoleDropdown);
		if (util.getSelectedOption(driver, selectRoleDropdown).getText().equalsIgnoreCase("Select Role")) {
			return true;
		} else {
			return false;
		}
	}

	public void selectRoleDropdownByText(String text) {
		util.waitForVisibilityOfElement(driver, selectRoleDropdown);
		util.selectDropdownByVisibleText(selectRoleDropdown, text);
	}

	public void clickOnNextBtn() {
		util.waitForVisibilityOfElement(driver, nextButton);
		if (nextButton.isEnabled() && nextButton.isDisplayed()) {
			nextButton.click();
		}
	}

	public boolean verifyNavigationToCreateUserFormForRole(String role) {
		if (verifyNavigateToCreateNewUserPage()) {
			verifyDefaultValueOfSelectRoleDropdoen();
			selectRoleDropdownByText(role);
			if (util.getSelectedOption(driver, selectRoleDropdown).getText().equals(role)) {
				test.log(Status.PASS, "Selected the role:" + role + " from select role dropdown");

			} else {
				test.log(Status.FAIL, "Failed to selected the role:" + role + " from select role dropdown");
				return false;
			}

			clickOnNextBtn();
			if (newUserFormHeader.isDisplayed()) {
				test.log(Status.PASS, "Navigated to New User Creation Form for role:" + role);
				return true;

			} else {
				test.log(Status.FAIL, "Failed to navigate to user creation form for role:" + role);
				return false;
			}

		} else {
			return false;
		}

	}

	public boolean verifyErrorMessageDisappears(String fieldName) {
		String lodator = "//label[contains(text(),'" + fieldName + "')]/../..//h4";
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lodator)));

			WebElement error1 = driver.findElement(By.xpath(lodator));

			if (error1.isDisplayed()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return true;
		}

	}

	public boolean verifyInputsWithValidData(String fieldName, String validData) {
		boolean isAbsent = false;
		switch (fieldName) {
			case "First Name":
				enterText(firstNameField, validData, "First Name");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("First Name");
				break;
			case "Last Name":
				enterText(lastNameField, validData, "Last Name");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("Last Name");
				break;
			case "Street":
				enterText(streetField, validData, "Street");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("Street");
				break;
			case "City":
				enterText(cityField, validData, "City");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("City");
				break;
			case "State":
				enterText(stateField, validData, "State");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("State");
				break;
			case "Zipcode":
				enterText(zipCodeField, validData, "Zipcode");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("Zipcode");
				break;
			case "Email":
				enterText(emailField, validData, "Email");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("Email");
				break;
			case "Phone Number":
				enterText(phoneNumberField, validData, "Phone Number");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isAbsent = verifyErrorMessageDisappears("Phone Number");
				break;
			default:
				System.out.println("No matching field found for: " + fieldName);
				isAbsent = false;
				break;
		}
		return isAbsent;

	}

	public boolean verifyInputsWithInvalidData(String fieldName, String invalidData) {
		boolean isErrorPresent = false;
		switch (fieldName) {

			case "First Name":
				enterText(firstNameField, invalidData, "First Name");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("First Name");
				break;
			case "Last Name":
				enterText(lastNameField, invalidData, "Last Name");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("Last Name");
				break;
			case "Street":
				enterText(streetField, invalidData, "Street");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("Street");
				break;
			case "City":
				enterText(cityField, invalidData, "City");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("City");
				break;
			case "State":
				enterText(stateField, invalidData, "State");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("State");
				break;
			case "Zipcode":
				enterText(zipCodeField, invalidData, "Zipcode");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("Zipcode");
				break;
			case "Email":
				enterText(emailField, invalidData, "Email");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("Email");
				break;
			case "Phone Number":
				enterText(phoneNumberField, invalidData, "Phone Number");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				isErrorPresent = !verifyErrorMessageDisappears("Phone Number");
				break;
			default:
				System.out.println("No matching field found for: " + fieldName);
				isErrorPresent = false;
				break;
		}

		return isErrorPresent;

	}

	public boolean verifyErrorMessageForField(String fieldName, String expectedMessage) {
		String actualMessage = getErrorMessage(fieldName);
		if (actualMessage.equalsIgnoreCase(expectedMessage)) {
			test.log(Status.PASS,
					"Verified error message for '" + fieldName + "' field. Expected & Actual message: "
							+ actualMessage);
			return true;
		} else {
			test.log(Status.FAIL, "Error message verification failed for '" + fieldName + "' field. Expected: "
					+ expectedMessage + ", but found: " + actualMessage);
			return false;
		}
	}

	public String getErrorMessage(String fieldName) {
		try {
			String lodator = "//h4[contains(text(),'" + fieldName + "')]";
			util.waitForPresenceOfElementByLocator(driver, lodator);
			WebElement errorElement = driver
					.findElement(By.xpath(lodator));

			return errorElement.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public WebElement getFieldElements(String fieldName) {
		switch (fieldName) {
			case "First Name":
				return firstNameField;
			case "Last Name":
				return lastNameField;
			case "Street":
				return streetField;
			case "City":
				return cityField;
			case "State":
				return stateField;
			case "Zipcode":
				return zipCodeField;
			case "Email":
				return emailField;
			case "Phone Number":
				return phoneNumberField;
			default:
				System.out.println("No matching field found for: " + fieldName);
				return null;
		}
	}

	public WebElement getFieldTooltipElements(String fieldName) {
		switch (fieldName) {
			case "First Name":
				return firstNameFieldTooltip;
			case "Last Name":
				return lastNameFieldTooltip;
			case "Street":
				return streetFieldtooltip;
			case "City":
				return cityFieldTooltip;
			case "State":
				return stateFieldTooltip;
			case "Zipcode":
				return zipCodeFieldTooltip;
			case "Email":
				return emailinputFieldTooltip;
			case "Phone Number":
				return phoneNumberFieldTooltip;
			default:
				System.out.println("No matching field found for: " + fieldName);
				return null;
		}
	}

	public boolean validateInputField(String field, String invalidData, String validData) {

		WebElement inputField = null;
		WebElement inputFieldTooltip = null;
		inputField = getFieldElements(field);
		inputFieldTooltip = getFieldTooltipElements(field);
		int result = 0;
		util.waitForVisibilityOfElement(driver, inputField);

		if (inputField.isDisplayed()) {

			if (inputFieldTooltip.isDisplayed()) {
				String value = getTooltipTextFromElement(inputField);
				test.log(Status.PASS, field + " input field tool-tip text: " + value);
			} else {
				test.log(Status.FAIL, "Failed to fetch the tool-tip for " + field + " input field");
				result++;
			}

			if (inputField.getText().isEmpty()) {
				test.log(Status.PASS, field + " input field is by default blank");
			} else {
				test.log(Status.FAIL, field + " input field's default value is not blank");
				result++;
			}

			inputField.clear();

			try {
				util.waitForVisibilityOfElement(driver, createButton);
				createButton.click();

				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}

				String msg = field + " is required";
				if (verifyErrorMessageForField(field, msg)) {
					test.log(Status.PASS,
							field + " input field displays error message when left blank: " + field + " is required");
				} else {
					test.log(Status.FAIL, field + " input field failed to display error message when left blank");
					result++;
				}
			} catch (Exception e) {
				test.log(Status.FAIL, field + ": Exception while Checking error message" + e.getMessage());
			}

			if (verifyInputsWithInvalidData(field, invalidData)) {
				test.log(Status.PASS,
						field + " input field displays error message for invalid input: " + invalidData);
			} else {
				test.log(Status.FAIL,
						field + " input field failed to display error message for invalid input: " + invalidData);
				result++;
			}

			if (verifyInputsWithValidData(field, validData)) {
				test.log(Status.PASS,
						field + " input field error message disappeared after entering valid input: " + validData);
			} else {
				test.log(Status.FAIL,
						field + " input field error message did not disappear after entering valid	 input: "
								+ validData);
				result++;
			}

			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}

			if (result < 0) {
				return false;
			} else {
				return true;
			}

		} else {
			test.log(Status.FAIL, "Failed to display " + field + " input field");
			return false;
		}

	}

	public String getTooltipTextFromElement(WebElement parentElement) {
		util.waitForVisibilityOfElement(driver, parentElement);
		util.hoverOnElement(driver, parentElement);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		return parentElement.getDomAttribute("data-tooltip");

	}

	private void enterText(WebElement element, String text, String fieldName) {
		try {
			// Wait until the element is visible before sending keys
			util.waitForVisibilityOfElement(driver, element);
			element.clear();
			element.sendKeys(text);
			System.out.println("INFO: Successfully entered '" + text + "' into the '" + fieldName + "'.");
		} catch (TimeoutException e) {

			System.err.println("ERROR: Timeout waiting for '" + fieldName + "' field to be visible or interactable.");
			// Re-throw as a runtime exception to fail the TestNG test gracefully
			throw new RuntimeException("Wait Timeout: Element not visible: " + fieldName, e);
		} catch (NoSuchElementException e) {
			System.err.println("ERROR: Locator for '" + fieldName + "' is incorrect. Element not found on the page.");
			throw new RuntimeException("Locator Error: Element not found: " + fieldName, e);
		}
	}

	private void clickElement(WebElement element, String elementName) {
		try {
			// Wait until the element is clickable (visible and enabled)
			util.waitForVisibilityOfElement(driver, element);
			element.click();
			System.out.println("INFO: Successfully clicked the '" + elementName + "' element.");
		} catch (TimeoutException e) {
			System.err.println("ERROR: Timeout waiting for '" + elementName + "' to be clickable.");
			test.log(Status.FAIL, "Timeout waiting for '" + elementName + "' to be clickable.");
			throw new RuntimeException("Wait Timeout: Element not clickable: " + elementName, e);
		} catch (NoSuchElementException e) {
			System.err.println("ERROR: Locator for '" + elementName + "' is incorrect. Element not found on the page.");
			test.log(Status.FAIL, "Locator for '" + elementName + "' is incorrect. Element not found on the page.");
			throw new RuntimeException("Locator Error: Element not found: " + elementName, e);
		}
	}

	// --- Public Action Methods (using robust helper methods) ---

	/**
	 * Enters data into all text fields on the form.
	 */
	public void enterUserDetails(String firstName, String lastName, String street, String city,
			String state, String zip, String email, String phone) {
		enterText(firstNameField, firstName, "First Name");
		enterText(lastNameField, lastName, "Last Name");
		enterText(streetField, street, "Street");
		enterText(cityField, city, "City");
		enterText(stateField, state, "State");
		enterText(zipCodeField, zip, "Zipcode");
		enterText(emailinputField, email, "Email");
		enterText(phoneNumberField, phone, "Phone Number");
		VerifyUploadUserLogo();
		clickCreateButton();
	}

	/**
	 * Uploads a file for the User Logo.
	 * 
	 * @param filePath The absolute path to the file.
	 */
	public boolean VerifyUploadUserLogo() {
		int result = 0;
		if (fileUploadArea.isDisplayed()) {
			String value = getTooltipTextFromElement(FileUploadFieldTooltip);
			test.log(Status.PASS, "File upload field tool-tip text: " + value);
		} else {
			test.log(Status.FAIL, "Failed to fetch the tool-tip for the file upload input field");
			result++;
		}

		String absoluteFilePath = new File("Resource\\logo.png").getAbsolutePath();
		// uploadFileWithSendKeys(driver, fileUploadArea, absoluteFilePath);

		util.uploadFileWithRobot(driver, absoluteFilePath, fileUploadArea);

		util.waitForVisibilityOfElement(driver, uploadImageButton);
		uploadImageButton.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		boolean isUploaded = !(fileUploadArea.getDomAttribute("src").equals("/assets/img/drop.png"));

		if (!uploadImageButton.isEnabled() && isUploaded) {
			test.log(Status.PASS, "User logo uploaded successfully.");

			return true;
		} else {
			test.log(Status.FAIL, "User logo upload failed.");
			result++;
		}

		if (result > 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Clicks the Create button to submit the form.
	 */
	public void clickCreateButton() {
		clickElement(createButton, "Create Button");
	}

	/**
	 * Clicks the Back button.
	 */
	public void clickBackButton() {
		clickElement(backButton, "Back Button");
	}

	public void clickonCreateButton() {
		clickElement(createButton, "Create button");
	}

	public void clickOnLaterButton() {
		clickElement(laterBtn, "Later button");
	}

	public void clickOnDeleteButton() {
		clickElement(deleteButton, "Delete button");
	}

	public String getCreateNewLocationPageHederText() {
		util.waitForVisibilityOfElement(driver, assignLocationPageHeaderText);
		return assignLocationPageHeaderText.getText();
	}

	public String getUserPageHederText() {
		util.waitForVisibilityOfElement(driver, usersPageHeader);
		return usersPageHeader.getText();
	}

	public boolean verifyCreateUserFunctionality(String role, String email) {
		verifyNavigateToUsersPage();
		verifyNavigationToCreateUserFormForRole(role);
		enterUserDetails("test", "test", "test", "test", "test", "12345", email, "+12345678900");

		util.waitForVisibilityOfElement(driver, notification);
		if (notification.isDisplayed()) {
			String notificationTextMsg = notificationText.getText();
			if (notificationTextMsg.contains("User successfully created. Please choose a location")) {

				test.log(Status.PASS, "Notification displayed for User successfully created");
				util.addBase64ScreenShotToReport(driver, test, "User successfully created");
				// clickOnLaterButton();
			} else if (notificationTextMsg.contains("User with entered email already exists")) {
				test.log(Status.PASS, "Notification displayed: User with entered email already exist");
				notificationCloseButton.click();

				return true;
			} else {
				test.log(Status.FAIL, "Failed to Match the Text on notification, found: " + notificationTextMsg);
				return false;
			}
			if (verifyLocationAssignment(laterBtn)) {
				return true;
			} else {
				return false;
			}
		} else {
			test.log(Status.FAIL, "Failed to display notification");
			return false;
		}
	}

	public boolean verifyLocationAssignment(WebElement assignmentButton) {

		util.waitForVisibilityOfElement(driver, assignmentButton);
		String assignmentOption = assignmentButton.getText();

		assignmentButton.click();

		switch (assignmentOption) {
			case "Create New Location": {
				if (location.getCreateNewLocationPageHederText().equals("Create New Location")) {
					test.log(Status.PASS, "Navigate 'Create New Location' page successfully");
					return true;
				} else {
					test.log(Status.FAIL, "Failed to navigate 'Create New Location' page");
					return false;
				}

			}
			case "Assign Existing Location": {
				if (getCreateNewLocationPageHederText().equals("Assign Existing Location")) {
					test.log(Status.PASS, "Navigate 'Assign Existing Location' page successfully");
					return true;
				} else {
					test.log(Status.FAIL, "Failed to navigate 'Create New Location' page");
					return false;
				}

			}
			case "Later": {
				if (getUserPageHederText().equals("Users")) {
					test.log(Status.PASS, "Navigate 'Users' page successfully");
					return true;
				} else {
					test.log(Status.FAIL, "Failed to navigate 'Users' page");
					return false;
				}
			}
			default:
				throw new IllegalArgumentException("Navigated to Unexpected Page: " + assignmentOption);
		}

	}

	public String getNotificationText() {
		util.waitForVisibilityOfElement(driver, notification);
		return notificationText.getText();
	}

	public boolean verifyDeleteUserFunctionality(String role, String email) {

		home.clickOnUseManagement();
		verifyNavigateToUsersPage();
		util.waitForVisibilityOfElement(driver, emailField);
		emailField.sendKeys(email);
		clickOnFilterButton();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// int roleColnum =getcolumnNumber("Role");
		int rowcount = getRowCount();
		String roleValue = getColumnValueforRow(rowcount, "Role");
		System.out.println("Created user role :" + roleValue);

		if (!roleValue.equalsIgnoreCase(role)) {
			return false;
		}

		util.waitForVisibilityOfAllElements(driver, actionButtons);
		int size = actionButtons.size();

		if (size == 1) {
			actionButtons.get(0).click();
			util.waitForVisibilityOfElement(driver, actionsPopup);
			util.waitForVisibilityOfAllElements(driver, actionsList);
			int i = 0;
			for (WebElement option : actionsList) {
				String optionText = option.getText();
				System.out.println("Action Option :" + optionText);
				if (optionText.equalsIgnoreCase("Remove")) {
					i++;
					option.click();

					util.waitForVisibilityOfElement(driver, removeUserHeader);
					clickOnDeleteButton();
					String notificationTextMsg = getNotificationText();
					if (notificationTextMsg.equalsIgnoreCase("Selected user is removed successfully.")) {
						test.log(Status.PASS, "Successfully removed user");
						return true;
					} else {
						test.log(Status.FAIL,
								"Failed to Match the Text on notification, found: " + notificationTextMsg);
						return false;
					}
				} else {
					continue;
				}
			}
			if (i == 0) {
				test.log(Status.FAIL, "Failed to find Remove Action Option");
				return false;
			}
		}

		test.log(Status.FAIL, "Multiple users with email: " + email);
		return false;

	}

}
