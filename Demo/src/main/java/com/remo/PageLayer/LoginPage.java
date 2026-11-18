package com.remo.PageLayer;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.remo.reader.ExcelFileReader;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass {

	/**
	 * Constructor for the LoginPage class.
	 * Initializes the WebDriver instance, configuration utility, common utility,
	 * Excel file reader, and home page instance.
	 * Also initializes the WebElements on the page using PageFactory.
	 * 
	 * @param driver WebDriver instance used for browser interactions.
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		prop = new ConfigUtil();
		util = new Utility();
		excel = new ExcelFileReader();
		home = new HomePage(driver);

		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * WebElements USing PageFactory FindBy Annotation
	 * 
	 */
	@FindBy(xpath = "//input[@class='login-page']")
	private WebElement loginPage;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameProd;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordProd;

	// @FindBy(xpath = "//button//span[text()='Sign in']")
	// private WebElement signInBtn;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtn;

	@FindBy(xpath = "//h2[text()='Sign in']")
	private WebElement signInText;

	@FindBy(xpath = "//div[@class='bert-content']//p")
	private WebElement loginAlert;

	@FindBy(linkText = "Forgot Password?")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//h6[contains(text(),'Enter your Email')]")
	private WebElement forgotPasswordHeaderMsg;

	@FindBy(id = "username")
	private WebElement forgotPasswordUserID;

	@FindBy(xpath = "//button[text()='Reset my password']")
	private WebElement ResetPasswordBtn;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement closePopUpBtn;

	@FindBy(xpath = "//div[text()='Invalid input: Incorrect username or password.']")
	private WebElement invalidInputWarning;

	@FindBy(xpath = "//div[@class='login-logo']//img")
	WebElement logo;

	/**
	 * This method will launch the given url
	 * 
	 * @param url
	 */
	public void launchApp(String url) {

		driver.get(prop.getProperty(url));

	}

	/**
	 * Checks if the logo is displayed.
	 *
	 * @return true if the logo is displayed; else false.
	 */

	public boolean verifyLogo() {
		try {
			util.waitForVisibilityOfElement(driver, logo);
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to display the Logo ");
			return false;
		}

		if (logo.isDisplayed()) {
			test.log(Status.INFO, "M360 Logo is displayed");
			return true;
		} else {
			test.log(Status.FAIL, " Welcome Merchants! text is not displayed");
			return false;
		}

	}

	/**
	 * Checks if the "Welcome" Text is displayed.
	 *
	 * @return true if the "Welcome" text is displayed; else false.
	 */
	public boolean verifySignInText() {
		try {
			util.waitForVisibilityOfElement(driver, signInText);
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to display 'Welcome' text ");
		}
		if (signInText.isDisplayed()) {
			// System.out.println("Sign in text is displayed");
			test.log(Status.INFO, "'" + signInText.getText() + "' text is displayed");
			return true;
		} else {
			test.log(Status.FAIL, "Welcome Merchants!text is not displayed");

			return false;
		}
	}

	/**
	 * Verifies successful Logout
	 * 
	 * @return true if log out successful; else false.
	 */

	public boolean verifyLogout() {
		try {
			home.logout();
			util.waitForVisibilityOfElementWithWait(driver, username, 20);
			util.waitForVisibilityOfElement(driver, password);
			boolean result = username.isDisplayed();
			if (result) {
				test.log(Status.PASS, "Logout successfully");
				return true;
			} else {

				test.log(Status.FAIL, "Failed to navigate to logout page");

				return false;
			}

		} catch (Exception e) {

			test.log(Status.FAIL, "Failed to verify logOut");
			return false;
		}

	}

	/**
	 * Retrieves the userName field WebElement
	 * 
	 * @return username field
	 */
	public WebElement getUserNameField() {
		try {
			util.waitForVisibilityOfElement(driver, username);
		} catch (NoSuchElementException e) {

			test.log(Status.FAIL, "Failed to display 'Username' text field");
		}
		return username;
	}

	/**
	 * Sets the value of the userName field with the provided String.
	 *
	 * @param username The String userName to be entered into the username field.
	 */
	public void setUserNameField(String userName) {
		try {

			util.waitForVisibilityOfElement(driver, this.username);

			util.waitForElementWithPollingFrequency(driver, signInBtn, 20, 2);

			if (this.username.isEnabled()) {
				getUserNameField().click();
				getUserNameField().clear();
				// getUserNameField().click();
				util.getActionObject(driver).moveToElement(getUserNameField()).click().build().perform();
				// util.forceClick(driver, getUserNameField());
				getUserNameField().clear();
				getUserNameField().sendKeys(userName);
				// test.log(Status.INFO, "Username Entered");
			} else {
				test.log(Status.INFO, "Failed to enter Username");
			}
		} catch (NoSuchElementException e) {
			test.log(Status.INFO, "Failed to verify enter Username");
		}

	}

	/**
	 * Sets the value of the Password field with the provided String.
	 *
	 * @param password The String password to be entered into the password field.
	 */
	public void setPasswordField(String password) {
		try {
			util.waitForVisibilityOfElement(driver, this.password);

			if (this.getPasswordField().isEnabled()) {
				getPasswordField().click();
				getPasswordField().clear();
				// util.forceClick(driver,getPasswordField());
				util.getActionObject(driver).moveToElement(getPasswordField()).click().build().perform();
				getPasswordField().click();
				getPasswordField().clear();
				getPasswordField().sendKeys(password);

				// test.log(Status.INFO, "Password Entered");

			} else {
				test.log(Status.INFO, "Failed to enter Password");
			}
		} catch (NoSuchElementException e) {
			test.log(Status.INFO, "Failed to verify enter Password");
		}
	}

	/**
	 * Clicks on the login button after waiting for it to be clickable.
	 */
	public void clickOnLoginBtn() {
		try {
			// util.waitForElementToBeClickable(driver, loginBtn);
			util.waitForElementWithPollingFrequency(driver, signInBtn, 30, 2);

			signInBtn.click();
			// test.log(Status.INFO, "Clicked On Login Button");
		} catch (Exception e) {
			test.log(Status.INFO, "Failed to Click Login Button");
		}
	}

	/**
	 * Performs login verification by launching the application, entering the
	 * username and password from property file, and clicking on the login button.
	 *
	 * @param username The username to be used for login.
	 * @param password The password to be used for login.
	 * @return true if the login is successful, false otherwise.
	 */

	public boolean loginVerification(String env, String username, String password) {
		try {
			launchApp(env);

			util.waitForDomToLoad(driver);

			if (verifySignInText()) {
				// util.takeScreenShotOnFailuer(driver, test);//////////////////////
				test.log(Status.PASS, "Application launched Successfully");

			} else {
				test.log(Status.FAIL, "Application Unsuccessful to launch");

			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Login");
			return false;
		}

		try {
			if (this.username.isEnabled()) {
				getUserNameField().click();
				getUserNameField().sendKeys(prop.getProperty(username));
				// test.log(Status.INFO, "Username Entered");
				if (this.username.getAttribute("value").isEmpty()) {
					test.log(Status.INFO, "Failed to enter Username");

				}

			} else {
				test.log(Status.FAIL, "Username not enabled");
				return false;
			}

			if (this.getPasswordField().isEnabled()) {
				getPasswordField().click();
				getPasswordField().sendKeys(prop.getProperty(password));

				// test.log(Status.INFO, "Password Entered");

			} else {
				test.log(Status.FAIL, "Password not enabled");
				return false;
			}

			// util.takeScreenShotOnFailuer(driver, test);////////////////

			util.waitForElementToBeClickable(driver, signInBtn);
			signInBtn.click();

			// util.takeScreenShotOnFailuer(driver, test);//////////////////

			// test.log(Status.INFO, "Clicked On Login Button");

			return home.getPlatformText(test).isDisplayed();

		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Login verification failed");
			util.addBase64ScreenShotToReport(driver, test, "Login verification failed");
			return false;
		}
	}

	public boolean loginVerificationProd(String env, String username, String password) {
		try {
			launchApp(env);

			util.waitForDomToLoad(driver);
			util.waitForVisibilityOfElement(driver, signInBtn);
			if (signInBtn.isDisplayed()) {
				// util.takeScreenShotOnFailuer(driver, test);//////////////////////
				test.log(Status.PASS, "Application launched Successfully");

			} else {
				test.log(Status.FAIL, "Application Unsuccessful to launch");

			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Login");
			return false;
		}

		try {
			util.waitForVisibilityOfElement(driver, usernameProd);
			if (usernameProd.isEnabled()) {
				// util.waitForVisibilityOfElement(driver, ResetPasswordBtn);

				usernameProd.sendKeys(prop.getProperty(username));
				// test.log(Status.INFO, "Username Entered");
				if (usernameProd.getAttribute("value").isEmpty()) {
					test.log(Status.INFO, "Failed to enter Username");

				}

			} else {
				test.log(Status.FAIL, "Username not enabled");
				return false;
			}
			util.waitForVisibilityOfElement(driver, passwordProd);
			if (passwordProd.isEnabled()) {
				passwordProd.click();
				passwordProd.sendKeys(prop.getProperty(password));

				// test.log(Status.INFO, "Password Entered");

			} else {
				test.log(Status.FAIL, "Password not enabled");
				return false;
			}

			// util.takeScreenShotOnFailuer(driver, test);////////////////

			util.waitForElementToBeClickable(driver, signInBtn);
			signInBtn.click();

			// util.takeScreenShotOnFailuer(driver, test);//////////////////

			// test.log(Status.INFO, "Clicked On Login Button");

			return home.getPlatformText(test).isDisplayed();

		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Login verification failed");
			util.addBase64ScreenShotToReport(driver, test, "Login verification failed");
			return false;
		}
	}

	/**
	 * Retrieves the PAssword field WebElement
	 * 
	 * @return password field
	 */
	public WebElement getPasswordField() {
		try {
			util.waitForVisibilityOfElement(driver, password);
			return password;
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to find Password Field");
			util.addBase64ScreenShotToReport(driver, test, "Failed to find Password Field");
			return password;
		}

	}

	/**
	 * Retrieves the current Url
	 * 
	 * @return current Url
	 */
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Verifies whether the application is launched successfully by comparing the
	 * current URL with the expected login page URL.
	 *
	 * @return true if the application is launched successfully; else false.
	 */
	public boolean verifyLaunchApplication(String env) {
		try {
			launchApp(env);
			// util.waitForDomToLoad(driver);
			// if (verifyWelcomeText()& verifyLogo()) {
			if (verifySignInText()) {
				test.log(Status.PASS, "Application launched Successfully");

				return true;

			} else {
				test.log(Status.FAIL, "Application Unsuccessful to launch");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed to launch the Application");
			return false;
		}
	}

	/**
	 * This method verifies if the login attempt with invalid credentials displays
	 * an appropriate pop-up message.
	 * It sets the userName and password fields, clicks the login button, and checks
	 * for the visibility of the invalid login pop-up/ notification.
	 * 
	 * @param invalidUsername
	 * @param password
	 * @return true if the invalid login pop-up is displayed; else false.
	 */
	public boolean verifyInvalidLogin(String invalidUsername, String password) {
		setUserNameField(prop.getProperty(invalidUsername));
		setPasswordField(prop.getProperty(password));
		clickOnLoginBtn();
		try {
			util.waitForVisibilityOfElement(driver, invalidInputWarning);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		if (invalidInputWarning.isDisplayed()) {
			test.log(Status.PASS, "Popup displayed with '" + invalidInputWarning.getText() + "' message");
			// closePopUpBtn.click();
			// driver.navigate().refresh();
			// util.waitForDomToLoad(driver);
			return true;
		} else {
			test.log(Status.FAIL,
					"Login verification with invalid username and password does not show any popup message ");
			// driver.navigate().refresh();
			// util.waitForDomToLoad(driver);
			return false;
		}
	}

	/**
	 * Performs a login using the provided username and password.
	 *
	 * @param username The key to fetch the username property from the properties
	 *                 file.
	 * @param password The key to fetch the password property from the properties
	 *                 file.
	 */

	public void loginMethod(String env, String username, String password) {

		launchApp(env);

		setUserNameField(prop.getProperty(username));
		setPasswordField(prop.getProperty(password));
		clickOnLoginBtn();
		// util.ZoomOutUsingKeyboard(driver, 1);

	}

	/**
	 * Performs a login using the provided String username and String password.
	 *
	 * @param username
	 * @param password
	 */

	public boolean doLogin(String username, String password) {
		try {
			String env = "ProdURL";
			launchApp(env);

			if (prop.getProperty(env + "LoginPageUrl").equals(getUrl())) {
				test.log(Status.PASS, "Application launched Successfully");

			} else {
				test.log(Status.FAIL, "Application Unsuccessful to launch");
				return false;

			}

			setUserNameField(username);
			setPasswordField(password);
			clickOnLoginBtn();

			if (home.getPlatformText(test).isDisplayed()) {
				test.log(Status.PASS, "Login Successful");
				return true;
			} else {

				test.log(Status.FAIL, "Login Unsuccessful");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Login Unsuccessful");
			util.addBase64ScreenShotToReport(driver, test, "Login Unsuccessful");
			return false;
		}
	}

	/**
	 * This method performs the login operation with the provided username and
	 * password.
	 * It sets the username and password fields, clicks the login button, and
	 * verifies if the login was successful
	 * by checking the visibility of an element on the home page.
	 * 
	 * @param username The username to be used for login.
	 * @param password The password to be used for login.
	 * @return true if the login is successful; else false.
	 */

	public boolean login(String username, String password) {
		try {
			setUserNameField(prop.getProperty(username));
			setPasswordField(prop.getProperty(password));
			clickOnLoginBtn();
			if (!(home.getPlatformText(test) == null)) {
				test.log(Status.PASS, "Login Successful");
				return true;
			} else {

				test.log(Status.FAIL, "Login Unsuccessful");
				util.addBase64ScreenShotToReport(driver, test, "Failed to verify Login");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login Unsuccessful");
			util.addBase64ScreenShotToReport(driver, test, "Failed to verify Login");
			return false;
		}
	}

	/**
	 * This method verifies the login functionality after deleting all cookies.
	 * It clears all cookies, then log in with the provided username and password.
	 * 
	 * @param username
	 * @param password
	 * @return true if the login is successful; else false.
	 */
	public boolean verifyMultipleLoginMethod(String username, String password) {

		// System.out.println("cookies before deleting"+driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		// System.out.println("Cookies After deletion: " +
		// driver.manage().getCookies());

		// driver.navigate().refresh();
		// System.out.println("Cookies after refresh: " + driver.manage().getCookies());

		return doLogin(username, password);

	}

	/**
	 * This method verifies a successful login operation for a given environment.
	 * It logins with the specified environment, username, and password.
	 * If the login is successful, it checks for the visibility of a specific
	 * element on the home page.
	 * 
	 * @param env The environment to use for login (e.g., QA, Prod, Dev).
	 * @return true if the login is successful; else false.
	 */
	public boolean verifySuccessfulLogin(String env) {

		try {
			loginMethod(env, "Username", "Password");

			if (home.getPlatformText(test).isDisplayed()) {
				test.log(Status.PASS, "Login Successful");
				return true;
			} else {
				test.log(Status.FAIL, "Login Unsuccessful");
				return false;
			}

		} catch (Exception e) {
			util.addBase64ScreenShotToReport(driver, test, "Failed verify Login");
			test.log(Status.FAIL, "Failed verify Login");
			return false;
		}
	}

	/**
	 * Performs multiple logins using the data from the specified Excel sheet.
	 *
	 * @param sheetName The name of the Excel sheet containing login data.
	 */
	public void multipleLogin(String sheetName) {
		try {
			for (int rowIndex = 1; rowIndex <= excel.getLastRow(sheetName); rowIndex++) {
				setUserNameField(excel.getExcelColumnValue(sheetName, rowIndex, "username"));
				setPasswordField(excel.getExcelColumnValue(sheetName, rowIndex, "password"));
				clickOnLoginBtn();
			}
		} catch (Exception e) {
			util.addBase64ScreenShotToReport(driver, test, "Failed to verify login");
			test.log(Status.FAIL, "Failed to verify login");

		}
	}

	/**
	 * Verifies whether the Alert message is displayed after invalid input.
	 *
	 * @return true if the alert displayed; else false.
	 */
	public boolean isLoginAlertVisible() {
		try {
			util.waitForVisibilityOfElement(driver, loginAlert);
			if (loginAlert.isDisplayed()) {
				test.log(Status.PASS, "Login Unsuccessful using invalid data with Alert \"" + getAlertText() + "\"");
				return true;
			} else {
				test.log(Status.FAIL, "Data mismatch");

				return false;

			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Data mismatch");
			return false;
		}

	}

	/**
	 * Retrieves the text from the alert
	 * 
	 * @return
	 */
	public String getAlertText() {
		try {
			util.waitForVisibilityOfElement(driver, loginAlert);
			return loginAlert.getText();
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to display login Alert");
			util.addBase64ScreenShotToReport(driver, test, "Failed to display login Alert");
			return null;
		}
	}

	/**
	 * Clicks on the "Forgot Password" link and checks if the related elements are
	 * enabled.
	 *
	 * @return true if the "Forgot Password" link is clicked successfully and
	 *         related elements are enabled;else false.
	 */
	public boolean verifyForgotPasswordLink() {
		launchApp("DevURL");
		util.waitForElementToBeClickable(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitForVisibilityOfElement(driver, forgotPasswordHeaderMsg);
		if ((forgotPasswordUserID.isEnabled()) && (ResetPasswordBtn.isEnabled())) {
			test.log(Status.PASS, "Forgot Password link validation successful");
			return true;
		}

		test.log(Status.FAIL, "Failed to verify forgot password link");
		util.addBase64ScreenShotToReport(driver, test, "Failed to verify forgot password link");
		return false;
	}

}
