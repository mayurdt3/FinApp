package com.remo.PageLayer;

import java.awt.Robot;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.remo.base.BaseClass;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class ProfileSettingPage extends BaseClass {

	/**
	 * Constructor for the ProfileSettingPage class. Initializes the WebDriver
	 * instance and common utility. Also initializes the WebElements on the page
	 * using PageFactory.
	 * 
	 * @param driver WebDriver instance used for browser interactions.
	 */
	public ProfileSettingPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility();
		// home = new HomePage(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * WebElements
	 * 
	 */

	@FindBy(xpath = "//h5[text()='Profile Settings']")
	private WebElement profileSettingHeader;

	@FindBy(xpath = "//label[contains(text(),'First Name')]/..//input")
	private WebElement firstName;

	@FindBy(xpath = "//label[contains(text(),'Last')]/..//input")
	private WebElement lastName;

	@FindBy(xpath = "//label[contains(text(),'Email Address')]/..//input")
	private WebElement email;

	@FindBy(xpath = "//label[contains(text(),'Phone')]/..//input")
	private WebElement phone;

	@FindBy(xpath = "//label[text()='Street']/..//input")
	private WebElement address;

	@FindBy(xpath = "//label[contains(text(),'City')]/..//input")
	private WebElement city;

	@FindBy(xpath = "//label[contains(text(),'State')]/..//input")
	private WebElement state;

	@FindBy(xpath = "//label[contains(text(),'ZIP')]/..//input")
	private WebElement zip;

	@FindBy(xpath = "//button[@type='button']//preceding-sibling::div[contains(text(),'not exceed 15 digits')]")
	private WebElement notExeed15digitsMsg;

	@FindBy(xpath = "//button[@type='button']/../div[contains(text(),'Please enter a valid phone number.')]")
	private WebElement enterValidNumberMsg;

	// @FindBy(xpath =
	// "//button[@type='button']//preceding-sibling::div[contains(text(),'must have
	// at least 4 digits')]")
	// private WebElement mustHaveAtLeast4DigitsMsg;

	@FindBy(xpath = "//button[@type='button']//preceding-sibling::div[contains(text(),'country code is invalid')]")
	private WebElement invalidCountrycodeMsg;

	@FindBy(xpath = "//button[@type='button']//preceding-sibling::div[contains(text(),'should contain only digits and')]")
	private WebElement shouldContainOnlyDigitsAndPlusMsg;

	@FindBy(xpath = "//button[@type='button']//preceding-sibling::div[contains(text(),'User successfully updated')]")
	private WebElement successMsgPopup;

	@FindBy(xpath = "//button[@type='button']//preceding-sibling::div[contains(text(),'phone cannot be empty')]")
	private WebElement phoneCanotEmptyMsgPopup;

	//

	@FindBy(xpath = "//button[@type='button']//preceding-sibling::div[contains(text(),'Failed to update user')]")
	private WebElement failureMsgPopup;

	@FindBy(xpath = "//button[text()='Save Profile']")
	private WebElement saveProfileButton;

	@FindBy(xpath = "//button[text()='Users']")
	private WebElement usersButton;

	@FindBy(xpath = "//button[text()='Locations']")
	private WebElement locationsButton;

	/**
	 * 
	 * Methods
	 * 
	 */

	public void clickonUsersbutton() {
		try {
			util.waitForVisibilityOfElement(driver, usersButton);
			if (usersButton.isDisplayed()) {
				usersButton.click();
			}
		} catch (Exception e) {

		}
	}

	public void clickonLocationsbutton() {
		try {
			util.waitForVisibilityOfElement(driver, locationsButton);
			if (locationsButton.isDisplayed()) {
				locationsButton.click();
				System.out.println("clicked on locations button");
			} else {
				System.out.println("locations button is not displayed");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * This method verifies if the navigation to the Profile Setting page is
	 * successful. It waits for the profile setting header element to be visible and
	 * checks its presence.
	 * 
	 * @return true if successfully navigated to Profile Setting page; else false.
	 */
	public boolean verifyNavigationToProfileSetting() {

		try {

			// home.clickOnUseManagement();

			util.waitForVisibilityOfElement(driver, profileSettingHeader);
			if (profileSettingHeader.isDisplayed()) {
				test.log(Status.PASS, "Successfully Navigated to Profile setting Page");
				return true;
			} else {
				test.log(Status.FAIL, "Navigation to Profile setting Page failed");
				return false;
			}

		} catch (NoSuchElementException e) {
			util.addBase64ScreenShotToReport(driver, test, "Failed Profile Setting");
			test.log(Status.FAIL, "Failed to verify profile Setting Header");
			return false;

		}
	}

	/**
	 * This method verifies the validation rules for the phone number input field.
	 * It tests various scenarios: - Valid input with different formats. - Invalid
	 * input with more than 16 digits. - Invalid input with less than 6 digits. -
	 * Invalid input without '+' prefix. - Invalid input with alphanumeric
	 * characters.
	 * 
	 * @return true if all validation scenarios pass; else false.
	 */
	public boolean verifyPhoneNumField() {
		boolean con1, con2, con3, con4, con5;

		util.waitForVisibilityOfElement(driver, phone);
		// Save initial phone number value
		String phoneNum = phone.getAttribute("value");

		// Test scenario 1: Empty phone number

		// try {
		// // Clear phone number field
		// Thread.sleep(2000);
		// phone.click();
		//
		// phone.clear();
		//
		// Thread.sleep(2000);
		//
		// System.out.println("Cleared");
		// Thread.sleep(9000);
		// phone.sendKeys("");
		// saveProfileButton.click();
		// Thread.sleep(9000);
		// System.out.println("Clicked on save");
		//
		//
		// util.waitForVisibilityOfElement(driver, phoneCanotEmptyMsgPopup);
		// if (phoneCanotEmptyMsgPopup.isDisplayed()) {
		// con1 = true;
		// test.log(Status.PASS, "'phone cannot be empty' Message displayed");
		// } else {
		// util.addBase64ScreenShotToReport(phoneCanotEmptyMsgPopup, test);
		// test.log(Status.FAIL, "'phone cannot be empty' Message is not displayed");
		// con1 = false;
		// }
		// } catch (Exception e) {
		// test.log(Status.FAIL, "Popup message verification failed");
		// con1 = false;
		// }

		// Test scenario 2: Invalid input with more than 11 digits

		util.waitForVisibilityOfElement(driver, phone);

		clearField(phone);

		phone.sendKeys("+1234234234555");
		saveProfileButton.click();
		try {
			util.waitForVisibilityOfElement(driver, enterValidNumberMsg);
			if (enterValidNumberMsg.isDisplayed()) {
				test.log(Status.PASS,
						"'Please enter a valid phone number' Message is displayed for invalid input (more than 11 digits)");
				con2 = true;
			} else {
				test.log(Status.FAIL,
						"'Please enter a valid phone number' Message is not displayed for invalid input (more than 11 digits)");
				con2 = false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Popup message verification failed");
			con2 = false;
		}

		// Test scenario 3: Invalid input with less than 11 digits
		util.waitForVisibilityOfElement(driver, phone);

		clearField(phone);

		phone.sendKeys("+123456789");
		saveProfileButton.click();
		try {
			util.waitForVisibilityOfElement(driver, enterValidNumberMsg);
			if (enterValidNumberMsg.isDisplayed()) {
				con3 = true;
				test.log(Status.PASS,
						"'Please enter a valid phone number' Message is displayed for invalid input (less than 11 digits)");
			} else {
				test.log(Status.FAIL,
						"'Please enter a valid phone number' Message is not displayed for invalid input (less than 11 digits)");
				con3 = false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Popup message verification failed");
			con3 = false;
		}

		// // Test scenario 4: Invalid input without '+' prefix
		// util.waitForVisibilityOfElement(driver, phone);
		//
		// clearField(phone);
		//
		// phone.sendKeys("1234567890");
		// saveProfileButton.click();
		// try {
		// util.waitForVisibilityOfElement(driver, enterValidNumberMsg);
		// if (enterValidNumberMsg.isDisplayed()) {
		// test.log(Status.FAIL,
		// "'Please enter a valid phone number' Message is displayed for invalid input
		// (without '+' sign as prefix)");
		// con4 = true;
		// } else {
		// test.log(Status.FAIL,
		// "'Please enter a valid phone number' Message is not displayed for invalid
		// input (without '+' sign as prefix)");
		// con4 = false;
		// }
		// } catch (Exception e) {
		// test.log(Status.FAIL, "Popup message verification failed");
		// con4 = false;
		// }

		// Test scenario 5: Invalid input with alphanumeric characters
		util.waitForVisibilityOfElement(driver, phone);

		clearField(phone);
		String invalidInput = "+12ABc60890";
		phone.sendKeys(invalidInput);
		// saveProfileButton.click();
		String expectedPhone = "+1 260 890";
		try {
			String actualResult = phone.getDomAttribute("value");

			if (expectedPhone.equals(actualResult)) {

				con5 = true;
			} else {
				test.log(Status.FAIL, "Phone number field accepts Alphanumeric input");
				con5 = false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Popup message verification failed");
			con5 = false;
		}

		// Restore original phone number value
		util.waitForVisibilityOfElement(driver, phone);

		clearField(phone);

		phone.sendKeys(phoneNum);
		saveProfileButton.click();
		util.waitForVisibilityOfElement(driver, successMsgPopup);
		util.waitForInvisibilityOfElement(driver, successMsgPopup);

		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// Evaluate overall result
		boolean result = con2 & con3 & con5;
		if (result) {
			return true;
		} else {
			test.log(Status.FAIL, "Phone Number input field validation failed");
			return false;
		}
	}

	/**
	 * Verifies the input fields on the profile page by checking if each field is
	 * cleared and populated correctly with its respective value.
	 * 
	 * @return true if all input fields are validated successfully; otherwise false.
	 */

	public boolean verifyInputFields() {
		boolean result = false;

		util.waitForVisibilityOfElement(driver, firstName);

		util.addBase64ScreenShotToReport(driver, test, "Profile Setting page");

		String fname = firstName.getAttribute("value");

		util.waitForVisibilityOfElement(driver, lastName);
		String lname = lastName.getAttribute("value");

		util.waitForVisibilityOfElement(driver, this.email);
		// String email = this.email.getAttribute("value");
		String phone = this.phone.getAttribute("value");
		System.out.println(phone);
		String street = this.address.getAttribute("value");
		String city = this.city.getAttribute("value");
		String state = this.state.getAttribute("value");
		String zip = this.zip.getAttribute("value");

		boolean con1 = verifyInputFiled(firstName, fname);
		boolean con2 = verifyInputFiled(lastName, lname);
		// // boolean con3 = verifyInputFiled(this.email,email);
		// boolean con4 = verifyInputFiled(this.phone, phone);
		boolean con5 = verifyInputFiled(this.address, street);
		boolean con6 = verifyInputFiled(this.city, city);
		boolean con7 = verifyInputFiled(this.state, state);
		boolean con8 = verifyInputFiled(this.zip, zip);

		if (con1 & con2 & con5 & con6 & con7 & con8) {

			test.log(Status.PASS, "Input field validation Successful");
			result = true;
		}

		else {
			test.log(Status.FAIL, "Input field validation Failed");
			result = false;
		}

		return result;
	}

	/**
	 * Verifies the functionality of an input field by clearing its existing value,
	 * entering new data, and ensuring the data is correctly entered.
	 * 
	 * @param inputField to be verified.
	 * @param data       to be entered into the input field.
	 * @return true if the input field is cleared and data is entered successfully;
	 *         else false.
	 */
	public boolean verifyInputFiled(WebElement inputField, String data) {
		boolean con1 = false;
		boolean con2 = false;
		// boolean con3 = false;
		try {
			util.waitForVisibilityOfElement(driver, inputField);
			String name = inputField.getAttribute("name");
			if (!name.isEmpty()) {

				if (inputField.isDisplayed()) {
					inputField.click();
					inputField.clear();

					if (inputField.getAttribute("value").equals("")) {
						con1 = true;
					} else {
						test.log(Status.FAIL, "failed to clear the data form " + name + " field");
					}

					util.waitForVisibilityOfElement(driver, inputField);

					inputField.click();

					inputField.sendKeys(data);

					if (inputField.getAttribute("value").equals(data)) {
						con2 = true;
					} else {
						test.log(Status.FAIL, "failed to clear the data form " + name + " field");
					}

					if (con1 & con2) {
						return true;
					} else {
						test.log(Status.FAIL, "failed to pass the condition");
						return false;
					}

				} else {
					test.log(Status.FAIL, name + " field is not displayed");
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			test.log(Status.FAIL, " Failed identify an input field");
			return false;
		}
	}

	public void clearField(WebElement e) {
		Actions actions = new Actions(driver);

		actions.click(e)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.perform();

	}

}
