package com.remo.PageLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.remo.utility.Utility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HomePage extends BaseClass {

	/**
	 * Constructor for the HomePage class. Initializes the WebDriver instance,
	 * configuration utility, and common utility. Also initializes the WebElements
	 * on the page using PageFactory.
	 * 
	 * @param driver WebDriver instance used for browser interactions.
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		prop = new ConfigUtil();
		util = new Utility();

		PageFactory.initElements(driver, this);

	}

	/**
	 * WebElements
	 */

	@FindBy(xpath = "//h5[text()='Platforms']")
	private WebElement platformsText;

	@FindBy(xpath = "//div[@class='pt-2']")
	private WebElement arrow;

	@FindBy(xpath = "//input[@aria-label='DBA Search']")
	private WebElement DBASearch;

	@FindBy(id = "dba-search")
	private WebElement searchBtn;

	@FindBy(id = "cover-spin")
	public WebElement spinIcon;

	@FindBy(xpath = "//div[@id='Products']")
	private WebElement platformCardBody;

	@FindBy(xpath = "//li[@class='locationItem']")
	private List<WebElement> listOfItems;

	@FindBy(xpath = "//li[@class='locationItem']//strong")
	private List<WebElement> listOfMids;

	@FindBy(className = "header-profile-img")
	private WebElement userProfileIcon;

	@FindBy(xpath = "//ul[@class ='userMeta text-center']//li")
	private List<WebElement> userProfileDataList;

	@FindBy(id = "//li[@class='nav-item dropdown']/div[contains(@class, 'dropdown notification')]")
	private WebElement notificationDropdown;

	@FindBy(id = "//a[text()='User Management']//ancestor::a[@id='dropdown05']//div[contains(@class, 'dropdown profile')]")
	private WebElement profileDropdown;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggler']")
	private WebElement notificationIcon;

	@FindBy(xpath = "//h4//span[@class='logoutbutton']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//h1[@class='dbaTitle']")
	private WebElement dbaName;

	@FindBy(xpath = "//nav[@id='sidebar']")
	private WebElement navbar;

	@FindBy(xpath = "//h1[@class='dbaTitle']/following-sibling::p[@class='dbaAddress']")
	private WebElement dbaAddress;

	@FindBy(xpath = "//h1[@class='dbaTitle']/following-sibling::p[@class='midNumber']")
	private WebElement mid;

	@FindBy(xpath = "//h4[text()='Messages']")
	WebElement notificationHeaderText;

	@FindBy(xpath = "//h5[text() = '15 Days Trend Analysis']")
	private WebElement TrendAnalysisText;

	@FindBy(xpath = "//p[text()='Average Transactions']/../../div[@class='card-body']")
	private WebElement trendAnalysisTransactionCard;

	@FindBy(xpath = "div[class ='card-body']>p:nth-child(2)")
	private List<WebElement> cardNames;

	@FindBy(xpath = "//p[text()='Average Ticket']/../../div[@class='card-body']")
	private WebElement trendAnalysisAverageTicketCard;

	@FindBy(xpath = "//p[text()='Average Total Sales']/../../div[@class='card-body']")
	private WebElement trendAnalysisTotalSalesCard;

	@FindBy(xpath = "//p[text()='Average Refunds']/../../div[@class='card-body']")
	private WebElement trendAnalysisRefundCard;

	@FindBy(xpath = "//ul[@class='userProducts']//li")
	private List<WebElement> userProfileActiveProducts;

	@FindBy(xpath = "//h5[text() = 'Paylytics Sales Forecaster']/../../..//div[@class='card']")
	private WebElement paylyticsSalesForecaster;

	@FindBy(xpath = "//ul[@class='list-unstyled components']//li")
	private List<WebElement> sideBarMenulist;

	@FindBy(xpath = "//ul[@class= 'list-unstyled components']//p[text()='Dashboard']")
	private WebElement dashboardMenuOption;

	@FindBy(xpath = "//h5[text()='Platforms']")
	private WebElement platformTextHeader;

	@FindBy(xpath = "//div[contains(@class,'slick-slide')and @data-index>='0' and @data-index<='6' ]//h5")
	private List<WebElement> allProducts;

	@FindBy(xpath = "//div[@data-index>='0' and @data-index<='6' ]//a[contains(text(),'View')]")
	private List<WebElement> activeProducts;

	@FindBy(xpath = "//div[contains(@class,'slick-slide')and @data-index<=6 and @data-index >=0 ]//a[contains(text(),'View')]")

	private List<WebElement> activeProductFooterText;

	@FindBy(xpath = "//span[@class='next']")
	private WebElement nextNavBtn;

	@FindBy(xpath = "//span[@class='prev']")
	private WebElement prevNavBtn;

	@FindBy(xpath = "//ul[@class= 'list-unstyled components']//p")
	private List<WebElement> sideBar;

	@FindBy(xpath = "//p[text()='Reports']")
	private WebElement reports;

	@FindBy(xpath = "//p[text()='Support']")
	private WebElement support;

	@FindBy(xpath = "//p[text()='Product Information']")
	private WebElement productInformation;

	@FindBy(xpath = "//div[contains(@class,'profile-img-container')]//img[@alt='Profile']")
	private WebElement userProfileImage;

	@FindBy(xpath = "//div[@class='bizOverview']")
	private WebElement businessOverview;

	@FindBy(xpath = "//div[@id='BusinessOverview']")
	public WebElement businessOverviewCard;

	@FindBy(xpath = "//h5[text()='Business Overview']")
	private WebElement businessOverviewHeader;

	@FindBy(xpath = "//p[text()='Batch Total']/preceding-sibling::h4")
	private WebElement bOBatchTotal;

	@FindBy(xpath = "//p[text()='Number of Transactions']/preceding-sibling::h4")
	private WebElement bONumOfTransaction;

	@FindBy(id = "calendarDropdown")
	private WebElement businessOverviewCalender;

	@FindBy(id = "boRange")
	private WebElement boCalenderDropdown;

	@FindBy(xpath = "//select[@id='boRange']//option")
	private List<WebElement> boCalenderDropdownList;

	@FindBy(xpath = "//p[contains(text(),'Sales data for')]")
	private WebElement boSecondaryHeader;

	@FindBy(xpath = "//div[@class='bizOverview']//div[@class='row']")
	private WebElement boInfo;

	@FindBy(xpath = "//a[text()='Dashboard/']")
	private WebElement dashboardFormBreadcrumb;

	@FindBy(xpath = "//a[text()='User Management']")
	private WebElement userManagement;

	@FindBy(xpath = "//div[@class='slick-slider platformCards slick-initialized']")
	private WebElement productsWidgets;

	@FindBy(xpath = "//p[text()='Transactions']/..//*[local-name()='svg']")
	private WebElement transactionsSvg;

	@FindBy(xpath = "//p[text()='Transactions']/..//*[local-name()='svg']/*[name()='g']//*[name()='circle' and not(@style ='display: none;')] ")
	private List<WebElement> transactionsCircles;

	@FindBy(xpath = "//div[@class='k-chart-tooltip k-chart-shared-tooltip']//div[contains(text(),'/')]")
	private WebElement circleTooltip;

	@FindBy(xpath = "//h5[text()='15 Days Trend Analysis']/../..")
	private WebElement trendAnalisyscard;

	@FindBy(xpath = "//h4[text()='Select a Location']/../../../div")
	private WebElement dbaSearchfield;

	@FindBy(xpath = "//div[@class='bizOverview']//p[contains(text(),'Number of')]/../h4")
	private WebElement dbNumberOfTransactions;

	//// div[@class='bizOverview']//p[contains(text(),'Number of')]/../h4

	// p[text()='Transactions']/..//*[local-name()='svg']/*[name()='g']//*[name()='circle'
	// and not(@style ='display: none;')][last()]

	// @FindBy(xpath = "//p[text()='Transactions']/..//*[local-name()='svg'] ")
	// private WebElement Average TicketSvg;
	//
	// @FindBy(xpath = "//p[text()='Transactions']/..//*[local-name()='svg'] ")
	// private WebElement Total SalesSvg;
	//
	// @FindBy(xpath = "//p[text()='Transactions']/..//*[local-name()='svg'] ")
	// private WebElement transactionsSvg;
	//

	@FindBy(xpath = "//div[@class='card-body']//h3/..//*[name()='g']//*[name()='text'][text()='0']")
	private WebElement zero;

	/**
	 * 
	 * Methods
	 */

	/**
	 * Waits for the productInformation element to be visible and then clicks on it.
	 */
	public void clickOnProductInformation() {
		util.waitForVisibilityOfElement(driver, productInformation);
		productInformation.click();

	}

	/**
	 * Retrieves the MID (Merchant ID) from the page and returns it.
	 *
	 * @return The MID extracted from the page.
	 */
	public String getMid() {
		try {
			util.waitForVisibilityOfElementWithWait(driver, this.mid, 20);
			String mid = this.mid.getText();
			// System.out.println(mid);
			String mids[] = mid.split(": ");
			mid = mids[1].trim();
			System.out.println(mid);
			return mid;
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to load dashboard in time");
			return null;
		}

	}

	/**
	 * Waits for the support element to be visible and then clicks on it.
	 */
	public void clickOnSupport() {
		try {
			util.waitForVisibilityOfElementWithWait(driver, support, 20);
			support.click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed to click on Support");
		}

	}

	/**
	 * Waits for the reports element to be visible and then clicks on it.
	 */
	public void clickOnReports() {

		try {
			util.waitForVisibilityOfElement(driver, reports);
			reports.click();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed to click on Repoers");
		}

	}

	/**
	 * Retrieves a list of active product footer text elements. If an element is not
	 * displayed, navigates to the next page and retries.
	 *
	 * @return List of active product footer text elements.
	 */
	public List<WebElement> activeProductText() {

		util.waitForDomToLoad(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		List<WebElement> text = new ArrayList<WebElement>();
		for (WebElement s : activeProductFooterText) {
			if (s.isDisplayed()) {
				text.add(s);
			} else {
				util.waitForVisibilityOfElement(driver, nextNavBtn);
				nextNavBtn.click();
				util.waitForVisibilityOfElement(driver, s);
				text.add(s);
			}

		}

		prevNavBtn.click();
		return text;

	}

	/**
	 * Checks if the "platformsText" element is currently displayed.
	 *
	 * @return true if the "platformsText" element is displayed; false otherwise.
	 */
	public WebElement getPlatformText(ExtentTest test) {
		int waitTime = 25;
		try {
			util.waitForVisibilityOfElementWithWait(driver, platformsText, waitTime);
			return platformsText;
		} catch (Exception e) {
			test.log(Status.FAIL, "Dashboard failed not load in " + waitTime + " Sec");
			return null;
		}
	}

	/**
	 * Clicks on the navigation button
	 */
	public void clickOnNavigationBtn() {
		util.waitForVisibilityOfElement(driver, arrow);
		arrow.click();

	}

	/**
	 * Enters MIDS in the search field
	 * 
	 * @param mid
	 */
	public void enterMID(String mid) {
		util.waitForVisibilityOfElement(driver, DBASearch);
		DBASearch.clear();
		DBASearch.sendKeys(mid);
	}

	/**
	 * Checks if search bar is visible
	 * 
	 * @return
	 */
	public boolean isSearchbarVisible() {
		try {
			clickOnNavigationBtn();
			if (DBASearch.isDisplayed()) {
				util.addBase64ScreenShotToReport(dbaSearchfield, test, "DBA serch bar");
				test.log(Status.PASS, "Search bar is displayed");

				// util.addBase64ScreenShotToReport(driver, test, "Search bar");
				return true;
			} else {
				test.log(Status.FAIL, "Search Bar is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Search bar visibility");
			return false;
		}
	}

	/**
	 * Clicks on the search button to search DBA details
	 * 
	 * @param mid
	 */
	public void clickOnSearch() {
		util.waitForVisibilityOfElement(driver, searchBtn);
		searchBtn.click();
	}

	/**
	 * Performs a search operation for a given MID (Merchant ID).
	 *
	 * it involves clicking on the navigation button, entering the MID, and then
	 * clicking on the search button.
	 *
	 * @param MID The Merchant ID to be searched.
	 */
	public void searchMID(String MID) {
		try {
			clickOnNavigationBtn();

			enterMID(MID);
			Thread.sleep(1000);
			clickOnSearch();

			// util.waitForVisibilityOfElementWithWait(driver, spinIcon, 10);
			// util.waitForInvisibilityOfElementWithWait(driver, spinIcon,10);

		} catch (Exception e) {

		}
	}

	/**
	 * Retrieves the DBA Name
	 * 
	 * @return
	 */
	public String getDBAnameFromList() {
		return listOfItems.get(0).getText();

	}

	/**
	 * Retrieves the first MID from the list of DBA
	 * 
	 * @return
	 */
	public String getMIDFromList() {
		return listOfMids.get(0).getText().split(": ")[1];

	}

	/**
	 * Select he first MID from the DBA list
	 * 
	 * @return
	 */
	public void selectFirstMIDFromList() {

		try {
			Thread.sleep(2000);
			// util.waitForVisibilityOfAllElements(driver, listOfMids);
			util.waitForVisibilityOfElementWithWait(driver, listOfMids.get(0), 10);
			listOfMids.get(0).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Verifies the DBA Name
	 * 
	 * @param DBAname
	 * @return
	 */
	public boolean verifyDBAName(String DBAname) {
		if (DBAname.contains(getDBAnameFromList())) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if the notification icon is currently displayed.
	 *
	 * @return true if the notification icon is displayed; false.
	 */
	public boolean isBusinessOverviewInfoDisplayed() {
		// util.waitForDomToLoad(driver);
		try {
			// util.waitForVisibilityOfElement(driver, boInfo);
			util.waitForVisibilityOfElementWithWait(driver, boInfo, 20);
			if (boInfo.isDisplayed()) {

				test.log(Status.PASS, "BO info is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Home page not loaded properly");
				util.addBase64ScreenShotToReport(driver, test, "Home page not loaded properly");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Home page not loaded properly");
			util.addBase64ScreenShotToReport(driver, test, "Home page not loaded properly");
			return false;
		}

	}

	public boolean verifyLogin() {

		if (isBusinessOverviewInfoDisplayed()) {
			test.log(Status.PASS, "HomePage loaded succsessfuly");
			return true;
		} else {
			test.log(Status.FAIL, "Failed to log in within time");
		}
		return false;
	}

	/**
	 * Checks if the notification icon is currently displayed with given time.
	 *
	 * @return true if the notification icon is displayed; false.
	 */
	public boolean isBusinessOverviewInfoDisplayedWithTime(int time) {
		// util.waitForDomToLoad(driver);
		try {
			// util.waitForVisibilityOfElement(driver, boInfo);
			util.waitForVisibilityOfElementWithWait(driver, boInfo, time);
			if (boInfo.isDisplayed()) {

				// test.log(Status.PASS, "Notification Icon is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Failed to load BuisnessOvervive properly");
				util.addBase64ScreenShotToReport(driver, test, "Home page not loaded properly");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Home page not loaded properly");
			util.addBase64ScreenShotToReport(driver, test, "Home page not loaded properly");
			return false;
		}

	}

	/**
	 * Checks if the User Profile icon is currently displayed.
	 *
	 * @return true if the User Profile icon is displayed; else false.
	 */
	public boolean isUserProfileIconDisplayed() {

		util.waitForDomToLoad(driver);
		try {
			util.waitForVisibilityOfElement(driver, userProfileIcon);
			if (userProfileIcon.isDisplayed()) {

				test.log(Status.PASS, "Header Profile picture logo is displayed");

				return true;
			} else {
				test.log(Status.FAIL, "Home page not loaded properly");
				util.addBase64ScreenShotToReport(driver, test, "Home page not loaded properly");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Home page not loaded properly");
			util.addBase64ScreenShotToReport(driver, test, "Failed to verify User Profile Icon");
			return false;

		}

	}

	/**
	 * Clicks on the notificationIcon
	 */
	public void clickOnNotification() {
		util.waitForElementToBeClickable(driver, notificationIcon);
		notificationIcon.click();
	}

	/**
	 * Clicks on the UserProfile
	 */
	public void clickOnUserProfile() {
		util.waitForVisibilityOfElement(driver, userProfileIcon);
		userProfileIcon.click();
	}

	/**
	 * Clicks on Usermanagement button
	 */
	public void clickOnUseManagement() {
		clickOnUserProfile();
		util.waitForVisibilityOfElement(driver, userManagement);
		userManagement.click();
	}

	/**
	 * Checks visibility of the profile Image
	 * 
	 * @return
	 */
	public boolean visibilityOfUserProfileDropdown() {
		try {
			clickOnUserProfile();
			util.waitForVisibilityOfElement(driver, userProfileImage);
			boolean result = false;
			if (userProfileImage.isDisplayed()) {

				test.log(Status.PASS, "User profile image is displayed");

				// clickOnUserProfile();
				result = true;
			} else {
				test.log(Status.FAIL, "User profile image is not displayed");
				clickOnUserProfile();

				return false;
			}

			util.waitForVisibilityOfAllElements(driver, userProfileDataList);
			for (WebElement userInfo : userProfileDataList) {
				if (userInfo.isDisplayed()) {

					result = true;
				} else {
					test.log(Status.FAIL, "User profile data is not displayed");
					clickOnUserProfile();

					return false;
				}
			}
			if (result) {
				test.log(Status.PASS, "User profile data is displayed");
				util.addBase64ScreenShotToReport(driver, test, "Profile Dropdown");
				// util.addScreenShotToReport(driver, test);
				clickOnUserProfile();

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to test user profile");
			util.addBase64ScreenShotToReport(driver, test, "Failed to test user profile");
			return false;
		}

	}

	/**
	 * checks the functionality of the navigation buttons for products
	 * 
	 * @return
	 */
	public boolean productNavigation() {
		Boolean result = false;
		try {
			util.waitForVisibilityOfElement(driver, nextNavBtn);
			if (nextNavBtn.isDisplayed()) {
				util.waitForElementToBeClickable(driver, nextNavBtn);

				util.addBase64ScreenShotToReport(platformCardBody, test, "platform section before navigation");

				nextNavBtn.click();

				Thread.sleep(1000);

				test.log(Status.PASS, "Clicked on next navigation button for products");

				util.addBase64ScreenShotToReport(platformCardBody, test, "Platform section after navigation");

				result = true;
			} else
				result = false;

			if (result == false) {
				test.log(Status.FAIL, "Failed to Click on Next navigation button for products");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Verify Click on Next navigation button for products");
			return false;
		}

		try {
			util.waitForVisibilityOfElement(driver, prevNavBtn);

			if (prevNavBtn.isDisplayed()) {
				util.waitForElementToBeClickable(driver, prevNavBtn);
				prevNavBtn.click();
				test.log(Status.PASS, "Clicked on Previous navigation button for products");
				result = true;

			} else
				result = false;

			if (result == false) {
				test.log(Status.FAIL, "Failed to Click on Previous navigation button for products");
				return false;
			}
			return result;
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Verify Click on Previous navigation button for products");
			return false;
		}
	}

	/**
	 * Clicks on the Logout button
	 */
	public void clickOnLogout() {
		util.waitForVisibilityOfElement(driver, logoutBtn);
		logoutBtn.click();
	}

	/**
	 * Performs a Logout operation
	 *
	 * It involves wait till profile icon is visible, clicking on the userProfile
	 * button, clicking logout
	 */
	public void logout() {
		util.waitForVisibilityOfElement(driver, userProfileIcon);
		clickOnUserProfile();
		clickOnLogout();
		// /test.log(Status.INFO, "Clicked on logout Button");

	}

	/**
	 * This method will returns if DBA Name is visible
	 * 
	 * @return true if it is visible; else false
	 */
	public boolean isDBA_NameIsVisible() {
		try {
			util.waitForVisibilityOfElement(driver, dbaName);

			if (dbaName.isDisplayed()) {
				test.log(Status.PASS, "DBA name is displayed :" + dbaName.getText());
				util.addBase64ScreenShotToReport(dbaName, test, "DBA Name");
				return true;
			} else {
				test.log(Status.FAIL, "DBA name is not displayed ");
				util.addBase64ScreenShotToReport(driver, test, "DBA name is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify DBA Name");
			return false;
		}

	}

	/**
	 * Retrieves the get DBA Name
	 * 
	 * @return
	 */
	public String getDbaName() {
		if (isDBA_NameIsVisible()) {
			return dbaName.getText();
		} else {
			test.log(Status.FAIL, "Failed to display DBA name");
			return null;
		}

	}

	/**
	 * This method will returns if DBA Address is visible
	 * 
	 * @return true if it is visible; else false
	 */
	public boolean isDBA_AddressVisible() {
		util.waitForVisibilityOfElement(driver, dbaAddress);
		if (dbaAddress.isDisplayed()) {
			test.log(Status.PASS, "DBA Address is displayed : " + dbaAddress.getText());
			util.addBase64ScreenShotToReport(dbaAddress, test, "DBA Address");
			return true;
		} else {
			test.log(Status.FAIL, "DBA Address is not displayed");
			util.addBase64ScreenShotToReport(driver, test, "DBA Address is not displayed");
			return false;
		}

	}

	/**
	 * This method retrieves the DBA address if it is visible on the page.
	 * 
	 * @return The DBA address as a string if it is visible; else null.
	 */

	public String getDbaAddress() {
		if (isDBA_AddressVisible()) {
			return dbaAddress.getText();
		} else {
			test.log(Status.FAIL, "Failed to display MID");
			return null;
		}

	}

	/**
	 * This method will returns if MID is visible
	 * 
	 * @return true if it is visible; else false
	 */
	public boolean isMIDVisible() {
		util.waitForVisibilityOfElement(driver, mid);
		if (mid.isDisplayed()) {
			util.addBase64ScreenShotToReport(mid, test, "MID");
			test.log(Status.PASS, "MID is displayed : " + mid.getText());
			return true;
		} else {
			test.log(Status.FAIL, "MID is not displayed");
			util.addBase64ScreenShotToReport(driver, test, "MID is not displayed");
			;
			return false;
		}

	}

	/**
	 * This method verifies if the displayed DBA name matches the expected DBA name.
	 * 
	 * @param dbaName The expected DBA name to verify.
	 * @return true if the displayed DBA name matches the expected DBA name; false
	 *         otherwise.
	 */

	public boolean verifyDbaName(String dbaName) {
		if (getDbaName().equals(dbaName)) {
			test.log(Status.PASS, "DBA name is matching");
			return true;
		} else
			test.log(Status.FAIL, "Failed to match DBA name");
		return false;
	}

	public boolean verifyDbaAddress(String dba) {
		if (getDbaAddress().equals(dba)) {
			test.log(Status.PASS, "DBA Address is matching");
			return true;
		} else
			test.log(Status.FAIL, "Failed to match DBA Address");
		return false;
	}

	/**
	 * This method verifies if the displayed MID matches the expected MID.
	 * 
	 * @param mid The expected MID to verify.
	 * @return true if the displayed MID matches the expected MID; else false.
	 */
	public boolean verifyMid(String mid) {

		try {

			// Thread.sleep(3000);

			util.waitForVisibilityOfElement(driver, this.mid);
			if (this.mid.getText().trim().contains(mid.toString())) {

				test.log(Status.PASS, "MID is matching");
				return true;

			} else {
				test.log(Status.FAIL, "Failed to match MID");
				return false;

			}
		} catch (Exception e) {
			util.addBase64ScreenShotToReport(driver, test, "Failed to verify MID");

			test.log(Status.FAIL, "Failed to verify MID");
			return false;
		}
	}

	/**
	 * clicks on notification icon from the header
	 */
	public void clickOnNotificationButton() {
		try {
			util.waitForElementToBeClickable(driver, notificationIcon);
			notificationIcon.click();
		} catch (Exception e) {
			test.log(Status.PASS, "Failed to verify open Header Notification dropdown");

		}
	}

	/**
	 * Verifies the visibility of the notification dropdown by clicking on the
	 * notification button.
	 *
	 * @return true if the notification dropdown is displayed; else false.
	 */
	public boolean verifyNotificationDropdown() {
		try {
			util.waitForElementToBeClickable(driver, notificationIcon);
			notificationIcon.click();
			util.waitForVisibilityOfElement(driver, notificationHeaderText);
			if (notificationHeaderText.isDisplayed()) {

				test.log(Status.PASS, "Header Notification dropdown opened Successfully");

				util.addBase64ScreenShotToReport(driver, test, "Header Notification dropdown opened Successfully");

				clickOnNotificationButton();
				return true;
			} else {
				test.log(Status.PASS, "Failed to open Header Notification dropdown");

				return false;
			}
		} catch (Exception e) {
			test.log(Status.PASS, "Failed to Verify Header Notification dropdown");
			return false;
		}
	}

	/**
	 * Retrieves a list of active products displayed on the User Profile.
	 *
	 * @return List of active products.
	 */
	public List<WebElement> getUserProfileActiveProducts() {
		clickOnUserProfile();
		List<WebElement> activeProducts = new ArrayList<WebElement>();
		for (WebElement activeP : userProfileActiveProducts) {
			if (activeP.isDisplayed()) {
				activeProducts.add(activeP);
			}
		}
		clickOnUserProfile();
		return activeProducts;
	}

	/**
	 * Checks if the visibility of the Platforms text.
	 *
	 * @return true if the Platforms Text is displayed; else false.
	 */
	public boolean isPlatformTextVisible() {
		util.waitForVisibilityOfElementWithWait(driver, platformTextHeader, 20);
		return platformTextHeader.isDisplayed();
	}

	/**
	 * Retrieves a list of active products displayed on the Home page.
	 *
	 * @return List of active products.
	 */
	public List<WebElement> getActiveProducts() {
		List<WebElement> activeProducts = new ArrayList<WebElement>();
		for (WebElement activeProduct : this.activeProducts) {

			if (activeProduct.isDisplayed()) {
				util.waitForVisibilityOfElement(driver, activeProduct);
				activeProducts.add(activeProduct);

			} else {
				util.waitForElementToBeClickable(driver, nextNavBtn);
				nextNavBtn.click();
				if (activeProduct.isDisplayed()) {
					util.waitForElementToBeClickable(driver, activeProduct);
					activeProducts.add(activeProduct);
				} else
					continue;
			}
		}

		return activeProducts;

	}

	/**
	 * This method retrieves a list of active product elements for link validation.
	 * 
	 * @return List of WebElements (active products) for link validation.
	 */

	public List<WebElement> getActiveProductsForLinkValidation() {
		List<WebElement> activeProducts = new ArrayList<WebElement>();
		for (int i = 1; i <= 6; i++) {
			WebElement activeProduct = driver
					.findElement(By.xpath("//div[@data-index>='" + i + "']//a[contains(text(),'View')]"));

			if (activeProduct.isDisplayed()) {
				util.waitForVisibilityOfElement(driver, activeProduct);
				activeProducts.add(activeProduct);

			} else {
				util.waitForElementToBeClickable(driver, nextNavBtn);
				nextNavBtn.click();
				if (activeProduct.isDisplayed()) {
					util.waitForElementToBeClickable(driver, activeProduct);
					activeProducts.add(activeProduct);
				} else
					continue;
			}
		}

		return activeProducts;
	}

	/**
	 * Retrieves a list of all products displayed on the Home page.
	 *
	 * @return List of all products.
	 */
	// public List<WebElement> getAllProductcards() {
	//
	// List<WebElement> allProducts = new ArrayList<WebElement>();
	//
	// for (int i = 0; i < 7; i++) {
	// WebElement product = driver
	// .findElement(By.xpath("//div[contains(@class,'slick-slide')and @data-index='"
	// + i + "']//h5"));
	// if (product.isDisplayed()) {
	// util.waitForVisibilityOfElement(driver, product);
	// allProducts.add(product);
	// } else {
	// util.waitForElementToBeClickable(driver, nextNavBtn);
	// nextNavBtn.click();
	// util.waitForElementToBeClickable(driver, product);
	// allProducts.add(product);
	// }
	// }
	// return allProducts;
	// }

	/**
	 * Checks if the visibility of the TrendAnalysis header.
	 *
	 * @return true if the Trend Analysis header is displayed; else false.
	 */
	public boolean isTrendAnalysisHeaderVisible() {
		try {

			if (TrendAnalysisText.isDisplayed()) {
				test.log(Status.PASS, "15 Days Trend Analysis Header is displayed");

				util.scrollHandle(driver, TrendAnalysisText);
				// util.scrollHandle(driver, businessOverviewHeader);
				// try {
				// Thread.sleep(5000);
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

				util.addBase64ScreenShotToReport(driver.findElement(By.id("TrendAnalysis")), test,
						"15 days Trend Analysis");
				return true;
			} else {
				test.log(Status.FAIL, "15 Days Trend Analysis Header is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify 15 Days Trend Analysis Header ");
			return false;
		}
	}

	/**
	 * Checks if the visibility of the TrendAnalysis TransactionCard.
	 *
	 * @return true if the Trend Analysis TransactionCard is displayed; else false.
	 */
	public boolean isTrendAnalysisTransactionCardVisible() {
		dashboardMenuOption.click();
		try {
			util.scrollHandle(driver, trendAnalysisTransactionCard);

			if (trendAnalysisTransactionCard.isDisplayed()) {
				test.log(Status.PASS, "Average Transactions Card is displayed");
				// verifyGraph("Transactions");
				return true;
			} else {
				test.log(Status.FAIL, "Average Transaction Card is not displayed");
				util.addBase64ScreenShotToReport(driver, test, "Average Transaction Card is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Average Transaction Card");

			return false;
		}

	}

	/**
	 * Checks if the visibility of the TrendAnalysis AverageTicketCard.
	 *
	 * @return true if the Trend Analysis AverageTicketCard is displayed; else
	 *         false.
	 */
	public boolean isTrendAnalysisAverageTicketCardVisible() {
		try {
			util.scrollHandle(driver, trendAnalysisAverageTicketCard);
			if (trendAnalysisAverageTicketCard.isDisplayed()) {
				test.log(Status.PASS, "Average Ticket Card is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Average Ticket Card is not displayed");
				util.addBase64ScreenShotToReport(driver, test, "Average Ticket Card is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Average Ticket Card ");
			return false;
		}
	}

	/**
	 * Checks if the visibility of the TrendAnalysis TotalSalesCard.
	 *
	 * @return true if the Trend Analysis TotalSalesCard is displayed; else false.
	 */
	public boolean isTrendAnalysisTotalSalesCardVisible() {
		try {
			util.scrollHandle(driver, trendAnalysisTotalSalesCard);
			trendAnalysisTotalSalesCard.isDisplayed();
			if (trendAnalysisTotalSalesCard.isDisplayed()) {
				test.log(Status.PASS, "Average Total Sales Card Ticket Card is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Average Total Sales Card is not displayed");
				util.addBase64ScreenShotToReport(driver, test, "Average Total Sales Card is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Average Total Sales Card");
			return false;
		}
	}

	/**
	 * Checks if the visibility of the TrendAnalysis RefundCard.
	 *
	 * @return true if the Trend Analysis RefundCard is displayed; else false.
	 */
	public boolean isTrendAnalysisRefundCardVisible() {
		try {
			util.scrollHandle(driver, trendAnalysisRefundCard);
			if (trendAnalysisRefundCard.isDisplayed()) {
				test.log(Status.PASS, "Average Refund Card is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Average Refund Card is not displayed");
				util.addBase64ScreenShotToReport(driver, test, "Average Refund Card is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Average Refund Card visibility");
			return false;
		}

	}

	/**
	 * This method retrieves a list of all product elements. It iterates through the
	 * allProducts list, collects each product element, and returns the list.
	 * 
	 * @return List of WebElements representing all products;
	 */
	public List<WebElement> getAllProducts() {

		try {
			List<WebElement> products = new ArrayList<WebElement>();

			for (WebElement product : allProducts) {
				products.add(product);
			}

			return products;
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fetch products");
			return null;
		}
	}

	/**
	 * This method verifies if the product widgets are visible on the page. It waits
	 * for the visibility of each product widget element and checks if they are
	 * displayed.
	 * 
	 * @return true if all product widgets are visible; else false.
	 */
	public boolean VerifyProductsWidgetsIsVisible() {
		try {
			if (productsWidgets.isDisplayed()) {
				test.log(Status.PASS, "Products are displayed");
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Products widget is not displayed");
			return false;
		}
	}

	/**
	 * Checks if the visibility of the All Products Card.
	 *
	 * @return true if the All Products Cards are displayed; else false.
	 */
	public boolean verifyIfAllProductsAreDisplayed() {

		boolean result = false;

		List<String> s = new ArrayList<String>();

		for (int i = 0; i < allProducts.size(); i++) {
			WebElement product = getAllProducts().get(i);

			util.waitForVisibilityOfElement(driver, product);
			if (product.isDisplayed()) {

				s.add(product.getText());
				// test.log(Status.PASS, product.getText() + " card displayed");
				result = true;
			} else {
				util.waitForElementToBeClickable(driver, nextNavBtn);
				nextNavBtn.click();
				util.waitForDomToLoad(driver); // added
				util.waitForVisibilityOfElement(driver, product);
				if (product.isDisplayed()) {
					s.add(product.getText());
					// test.log(Status.PASS, product.getText() + " card displayed");
					result = true;
				} else {
					util.waitForElementToBeClickable(driver, nextNavBtn);
					nextNavBtn.click();
					util.waitForDomToLoad(driver); // added
					util.waitForVisibilityOfElement(driver, product);
					if (product.isDisplayed()) {
						s.add(product.getText());
						// test.log(Status.PASS, product.getText() + " card displayed");
						result = true;
					} else {
						result = false;
					}
				}

			}
			if (result == false) {
				test.log(Status.FAIL, product.getText() + " card not displayed");
				return result;
			}

			// } catch (Exception e) {
			// test.log(Status.FAIL, product.getText() + " card not displayed");
			// result = false;
			// continue;
			// }
		}
		util.waitForElementToBeClickable(driver, prevNavBtn);

		prevNavBtn.click();
		String productList = s + " ";
		// System.out.println(productList);
		productList = productList.replace("[", "").replace("]", "");
		// System.out.println(productList);
		test.log(Status.PASS, productList + " are  displayed");

		return result;

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
	 * Checks if the visibility of the All Side Menu-bar Options.
	 *
	 * @return true if the All Side Menu-bar Options are displayed; else false.
	 */
	public boolean isSideBarOptionsDisplayed() {
		try {
			boolean result = false;
			List<String> s = new ArrayList<String>();
			if (navbar.isDisplayed()) {
				util.addBase64ScreenShotToReport(navbar, test, "Sidbar");
			}

			for (WebElement sideMenuOption : sideBar) {
				try {

					if (sideMenuOption.isDisplayed()) {
						s.add(sideMenuOption.getText());
						result = true;
					} else {
						test.log(Status.FAIL, "Failed to display side Menubar options");
						result = false;
					}
				} catch (Exception e) {
					String ss = sideMenuOption + "";
					ss = ss.replaceAll("[", "");
					ss = ss.replaceAll("]", "");
					test.log(Status.FAIL, "Failed to display '" + ss.trim() + "' side Menubar options");
					return false;
				}
			}

			test.log(Status.INFO, s + " is visible");

			// util.addBase64ScreenShotToReport(driver, test, "Menu bar");
			return result;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean linkValidationForSideBar() {
		boolean result = false;
		for (int i = sideBar.size() - 1; i >= 0; i--) {
			System.out.println(sideBar.get(i).getText());
		}
		for (int i = sideBar.size() - 1; i >= 0; i--) {

			try {

				util.waitForElementToBeClickable(driver, sideBar.get(i));
				String text = sideBar.get(i).getText().toLowerCase().substring(0, 4);

				sideBar.get(i).click();
				// Thread.sleep(2000);
				System.out.println("**Clicked on :" + text);

				// util.waitForVisibilityOfElement(driver,
				// driver.findElement(By.xpath("//div[@class='card-header d-flex border-bottom-0
				// bg-white pt-3 pb-0 px-4']/../div[position()=2]")));

				if (sideBar.get(i).getText().equals("Dashboard")) {

					util.waitForVisibilityOfElement(driver, driver.findElement(By.xpath(
							"//div[@class='card-header d-flex border-bottom-0 bg-white pt-3 pb-0 px-4']/../div[position()=2]")));

					if (platformsText.isDisplayed()) {
						test.log(Status.PASS,
								"Navigate to " + sideBar.get(i).getText() + " link from side bar option successfully");
						continue;
					} else {
						test.log(Status.FAIL, "Failed to navigate to " + sideBar.get(i).getText()
								+ " link from side Menubar options");
						result = false;
					}

				} else if (getUrl().contains(text)) {
					System.out.println("**" + getUrl());
					test.log(Status.PASS,
							"Navigate to " + sideBar.get(i).getText() + " link from side bar option successfully");

					// Thread.sleep(3000);

					util.addBase64ScreenShotToReport(driver, test, sideBar.get(i).getText());

					// navigateToDashboard();
					driver.navigate().back();
					result = true;
				} else {
					test.log(Status.FAIL,
							"Failed to navigate to " + sideBar.get(i).getText() + " link from side Menubar options");
					result = false;
				}

				if (result == false)
					return false;
			} catch (Exception e) {

				test.log(Status.FAIL, "Failed to verify navigation to " + sideBar.get(i).getText()
						+ " link from side Menubar options");
				return false;
			}

		}
		return result;
	}

	public void navigateToDashboard() {
		util.waitForElementToBeClickable(driver, dashboardFormBreadcrumb);
		dashboardFormBreadcrumb.click();
	}

	/**
	 * Verifies the visibility of the All Active products.
	 *
	 * @return true if the All Active products are displayed; else false.
	 */
	public boolean verifyActiveProductsAreDisplayed() {
		boolean result = false;
		util.waitForDomToLoad(driver);
		List<String> s = new ArrayList<String>();

		for (WebElement activeP : activeProducts) {
			result = false;

			if (activeP.isDisplayed()) {
				// test.log(Status.PASS, "Active service card is displayed");
				s.add(activeP.getText());
				result = true;
			} else {
				util.waitForElementToBeClickable(driver, nextNavBtn);
				nextNavBtn.click();
				if (activeP.isDisplayed()) {
					util.waitForElementToBeClickable(driver, activeP);
					s.add(activeP.getText());
					// test.log(Status.PASS, "active service card is displayed");

					result = true;
				}
			}
			if (result == false) {

				test.log(Status.FAIL, "failed to display active service card '" + activeP.getText() + "'");

				return false;
			}
		}
		test.log(Status.PASS, s + " active service card are displayed");

		util.waitForElementToBeClickable(driver, nextNavBtn);
		nextNavBtn.click();
		return result;
	}

	public boolean verifyActiveProductsAreDisplayedOptionl() {
		boolean result = false;
		util.waitForDomToLoad(driver);
		List<String> s = new ArrayList<String>();
		int size = activeProducts.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 3; i++) {
				try {
					util.waitForVisibilityOfElementWithWait(driver, activeProducts.get(i), 2);

					if (activeProducts.get(i).isDisplayed()) {
						// test.log(Status.PASS, "Active service card is displayed");
						s.add(activeProducts.get(i).getText());
						result = true;
						break;
					}

				} catch (Exception e) {

					util.waitForElementToBeClickable(driver, nextNavBtn);
					nextNavBtn.click();
				}

			}

		}
		test.log(Status.PASS, s + " active service card are displayed");

		util.waitForElementToBeClickable(driver, nextNavBtn);
		nextNavBtn.click();
		return result;
	}

	/**
	 * Verifies the number of all products.
	 *
	 * @return true if the number of products equals to 7; else false.
	 */
	public boolean verifyNumberOfProducts() {

		return activeProducts.size() == 7;
	}

	/**
	 * Verifies Link validation of links that are provided at the footer of
	 * ActiveProducts(). this includes Switch case statement where driver will
	 * clicks on active product footer link, switch focus of driver to newly opened
	 * window and verifies the title of the page, close the window tab and again
	 * switch to parent window
	 *
	 * @return true if the link navigate to expected page with Title, else false.
	 */
	public boolean linkValidationOfActiveProducts() {
		boolean result = false;

		for (WebElement activeProductLink : activeProductFooterText) {
			util.waitForDomToLoad(driver);
			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e1) {
			//
			// e1.printStackTrace();
			// }
			if (activeProductLink.isDisplayed()) {
				String expectedTitle = getTitleForActiveProduct(activeProductLink.getText());
				if (!((expectedTitle.equals("eGiftSolutions")) || (expectedTitle.equals("TableTurn")))) {
					activeProductLink.click();
					// try {
					// Thread.sleep(5000);
					// } catch (InterruptedException e) {
					//
					// e.printStackTrace();
					// }

					util.switchToWindowWithTitle(driver, expectedTitle);

					util.waitForTitle(driver, expectedTitle);
					if (driver.getTitle().equals(expectedTitle)) {
						test.log(Status.INFO, "navigated to" + expectedTitle + " link");
						result = true;
					} else {
						result = false;
					}

					util.closeWindow(driver);
					util.switchToParentWindow(driver);
				} else {

					if (expectedTitle.contains("eGiftSolutions")) {
						activeProductLink.click();
						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String eGift = "eGift";
						if (driver.getCurrentUrl().contains(eGift))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
						driver.navigate().back();
					} else if (expectedTitle.contains("TableTurn")) {

						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String tt = "tableturn";
						if (driver.getCurrentUrl().contains(tt))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
					}
				}

			} else {

				util.waitForElementToBeClickable(driver, nextNavBtn);
				nextNavBtn.click();

				if (activeProductLink.isDisplayed()) {
					String expectedTitle = getTitleForActiveProduct(activeProductLink.getText());

					if (!((expectedTitle.equals("eGiftSolutions")) || (expectedTitle.equals("TableTurn")))) {
						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						util.switchToWindowWithTitle(driver, expectedTitle);

						util.waitForTitle(driver, expectedTitle);
						if (driver.getTitle().contains(expectedTitle)) {
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
							result = true;
						} else {
							result = false;
						}

						util.closeWindow(driver);
						util.switchToParentWindow(driver);
					} else

					if (expectedTitle.contains("eGiftSolutions")) {

						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String eGift = "eGift";
						if (driver.getCurrentUrl().contains(eGift))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
						driver.navigate().back();
					} else if (expectedTitle.contains("TableTurn")) {
						// table turn
						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String tt = "tableturn";
						if (driver.getCurrentUrl().contains(tt))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
					}
				} else {
					result = false;
				}
			}

			if (result == false) {
				break;
			}
		}
		if (result) {
			test.log(Status.PASS, "Active Product card link validation successful");
			return true;
		} else {
			test.log(Status.FAIL, "Failed to navigate to expected link");
			return false;
		}

	}

	public boolean linkValidationOfActiveProductsOption() {
		boolean result = false;

		int size = activeProducts.size();
		for (int i = 0; i <= size; i++) {
			WebElement activeProductLink = activeProducts.get(i);
			util.waitForDomToLoad(driver);
			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e1) {
			//
			// e1.printStackTrace();
			// }
			if (activeProductLink.isDisplayed()) {
				String expectedTitle = getTitleForActiveProduct(activeProductLink.getText());
				if (!((expectedTitle.equals("eGiftSolutions")) || (expectedTitle.equals("TableTurn")))) {
					activeProductLink.click();
					// try {
					// Thread.sleep(5000);
					// } catch (InterruptedException e) {
					//
					// e.printStackTrace();
					// }

					util.switchToWindowWithTitle(driver, expectedTitle);

					util.waitForTitle(driver, expectedTitle);
					if (driver.getTitle().equals(expectedTitle)) {
						test.log(Status.INFO, "navigated to" + expectedTitle + " link");
						result = true;
					} else {
						result = false;
					}

					util.closeWindow(driver);
					util.switchToParentWindow(driver);
				} else {

					if (expectedTitle.contains("eGiftSolutions")) {
						activeProductLink.click();
						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String eGift = "eGift";
						if (driver.getCurrentUrl().contains(eGift))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
						driver.navigate().back();
					} else if (expectedTitle.contains("TableTurn")) {

						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String tt = "tableturn";
						if (driver.getCurrentUrl().contains(tt))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
					}
				}

			} else {

				util.waitForElementToBeClickable(driver, nextNavBtn);
				nextNavBtn.click();

				if (activeProductLink.isDisplayed()) {
					String expectedTitle = getTitleForActiveProduct(activeProductLink.getText());

					if (!((expectedTitle.equals("eGiftSolutions")) || (expectedTitle.equals("TableTurn")))) {
						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						util.switchToWindowWithTitle(driver, expectedTitle);

						util.waitForTitle(driver, expectedTitle);
						if (driver.getTitle().contains(expectedTitle)) {
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
							result = true;
						} else {
							result = false;
						}

						util.closeWindow(driver);
						util.switchToParentWindow(driver);
					} else

					if (expectedTitle.contains("eGiftSolutions")) {

						activeProductLink.click();

						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String eGift = "eGift";
						if (driver.getCurrentUrl().contains(eGift))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
						driver.navigate().back();
					} else if (expectedTitle.contains("TableTurn")) {
						// table turn
						activeProductLink.click();
						//
						// try {
						// Thread.sleep(5000);
						// } catch (InterruptedException e) {
						//
						// e.printStackTrace();
						// }

						String tt = "tableturn";
						if (driver.getCurrentUrl().contains(tt))
							test.log(Status.INFO, "navigated to" + expectedTitle + " link");
					}
				} else {
					result = false;
				}
			}

			if (result == false) {
				break;
			}
		}
		if (result) {
			test.log(Status.PASS, "Active Product card link validation successful");
			return true;
		} else {
			test.log(Status.FAIL, "Failed to navigate to expected link");
			return false;
		}

	}

	/**
	 * Gets the expected title for an active product based on its footer link text.
	 *
	 * @param linkText The text of the active product footer link.
	 * @return The expected title of the page for the active product.
	 */
	private String getTitleForActiveProduct(String linkText) {
		switch (linkText) {
			case "View YouLend":
				return "YouLend";
			case "View EPI CRM":
				return "EPI CRM";
			case "View ProCharge":
				return "ProCharge";
			case "View eGiftSolutions":
				return "eGiftSolutions";
			case "View Exatouch":
				return "Exatouch";
			case "View TableTurn":
				return "TableTurn";
			case "View DeliverMe":
				return "DeliverMe";
			default:
				throw new NoSuchElementException("Product card is not available");
		}
	}

	/**
	 * Verifies Link validation of links that are provided at the footer of
	 * ActiveProducts(). this includes Switch case statement where driver will
	 * clicks on active product footer link, switch focus of driver to newly opened
	 * window and verifies the title of the page, close the window tab and again
	 * switch to parent window
	 *
	 * @return true if the link navigate to expected page with Title, else false.
	 */
	public boolean linkValidationOfActiveProductsOptional() {
		boolean result = false;

		for (WebElement activeProductLink : activeProductFooterText) {
			switch (activeProductLink.getText()) {
				case "View YouLend":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "YouLend");
					if (driver.getTitle().equals("YouLend")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				case "View EPI CRM":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "EPI CRM");
					if (driver.getTitle().equals("EPI CRM")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				case "ProCharge":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "ProCharge");
					if (driver.getTitle().equals("ProCharge")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				case "eGiftSolution":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "eGiftSolution");
					if (driver.getTitle().equals("eGiftSolution")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				case "Exatouch":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "Exatouch");
					if (driver.getTitle().equals("Exatouch")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				case "TableTurn":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "TableTurn");
					if (driver.getTitle().equals("TableTurn")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				case "DeliverMe":
					activeProductLink.click();
					util.switchToNewlyOpenedWindow(driver);
					util.waitForTitle(driver, "DeliverMe");
					if (driver.getTitle().equals("DeliverMe")) {
						util.closeWindow(driver);
						util.switchToParentWindow(driver);
						result = true;
						continue;
					} else {
						result = false;
						return false;
					}

				default:
					throw new NoSuchElementException("Product card is not available");
			}

		}
		return result;

	}

	/**
	 * This method returns the count of active products from the page.
	 * 
	 * @return The number of active products displayed on the page.
	 */
	public int getActiveProductCountFromPage() {

		return activeProducts.size();
	}

	/**
	 * This method returns the count of active products from the user profile.
	 * 
	 * @return
	 */
	public int getActiveProductCountFromUserProfile() {

		return getUserProfileActiveProducts().size();
	}

	/**
	 * This method verifies if the number of active products displayed on the page
	 * matches the number of active products in the user profile.
	 * 
	 * @return true if the counts match; else false.
	 */

	public boolean verifyNumberOfActiveProductsInUseProfile() {

		if (getActiveProductCountFromPage() == getActiveProductCountFromUserProfile()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method checks if the Paylytics Sales Forecaster is visible on the page.
	 * It scrolls to the element and verifies its visibility.
	 * 
	 * @return true if the Paylytics Sales Forecaster is visible; else false.
	 */

	public boolean isPaylyticsSalesForecasterVisible() {
		try {
			clickOnDashBoard();
			util.scrollHandleEndOfTheElement(driver, paylyticsSalesForecaster);
			if (paylyticsSalesForecaster.isDisplayed()) {

				util.addBase64ScreenShotToReport(paylyticsSalesForecaster, test, "Paylytics Sales Forcaster");
				test.log(Status.PASS, "Paylytics Sales Forecaster is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Paylytics Sales Forecaster is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Paylytics Sales Forecaster is not displayed");
			return false;
		}
	}

	/**
	 * This method checks if the Business Overview section is visible on the page.
	 * It waits for the element to be visible and then verifies its visibility.
	 * 
	 * @return true if the Business Overview is visible; else false.
	 */
	public boolean isBusinessOverviewVisible() {
		try {
			util.waitForVisibilityOfElement(driver, businessOverview);

			if (businessOverview.isDisplayed()) {
				// test.log(Status.PASS, "Business Overview is displayed");
				return true;
			} else {
				test.log(Status.FAIL, "Business Overview is not displayed");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Business Overview is not displayed");
			return false;
		}

	}

	/**
	 * This method verifies the functionality of the Business Overview section. It
	 * checks the visibility of the Business Overview element, interacts with the
	 * calendar dropdown, and verifies if the selected options are correctly
	 * reflected.
	 * 
	 * @return true if the Business Overview functionality works as expected; else
	 *         false.
	 */

	public boolean verifyBusinessOverviewFunctionality() {
		boolean result = false;
		try {
			isBusinessOverviewVisible();
			util.waitForVisibilityOfElement(driver, businessOverviewCalender);
			businessOverviewCalender.click();
			util.waitForVisibilityOfElement(driver, boCalenderDropdown);
			boCalenderDropdown.click();

			util.addBase64ScreenShotToReport(driver, test, "business Overview");

			int size = boCalenderDropdownList.size();
			for (int i = 0; i < size; i++) {
				String value = boCalenderDropdownList.get(i).getText();
				util.selectDropdownByIndex(boCalenderDropdown, i);

				util.waitForVisibilityOfElement(driver, boSecondaryHeader);
				if (boSecondaryHeader.getText().contains(value)) {
					test.log(Status.PASS, "Business Overview: Selected '" + value + "' option is reflected");
					result = true;
				}

				else {
					test.log(Status.FAIL, "Business Overview: Selected '" + value + "' option is not reflected");
					result = false;
				}
				util.waitForVisibilityOfElement(driver, businessOverviewCalender);
				businessOverviewCalender.click();
				if (result == false) {
					test.log(Status.FAIL, "Business Overview:Selected '" + value + "' option is not reflected");
					return false;
				}
			}
			util.waitForVisibilityOfElement(driver, businessOverviewCalender);
			businessOverviewCalender.click();
			if (result) {
				test.log(Status.PASS, "Business Overview verification successful");
				return result;
			} else {
				return result;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Verify business overview ");
			return false;
		}

	}

	private List<String> dates = new ArrayList<String>();
	private List<String> transactions = new ArrayList<String>();

	public void getTrasactionsDataFromGraph(String graphName) {
		dates.clear();
		transactions.clear();

		dashboardMenuOption.click();
		// util.ZoomOutUsingKeyboard(driver, 2);

		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// util.waitForVisibilityOfElement(driver, transactionsSvg);
		util.scrollHandle(driver, trendAnalisyscard);

		try {
			By noDataCardLocator = By
					.xpath("//div[@class='card-body']//p[text()='" + graphName + "']/..//div[contains(text(),'No')]");
			WebElement noDataMessage = driver.findElement(noDataCardLocator);
			if (noDataMessage.isDisplayed()) {
				test.log(Status.INFO, "No " + graphName + " data available to plot graph");
			} else {
				throw new Exception();
			}

		} catch (Exception e1) {
			try {
				By circleLocator = By.xpath(("//p[text()='" + graphName
						+ "']/..//*[local-name()='svg']/*[name()='g']//*[name()='circle' and not(@style ='display: none;')]"));
				util.waitForVisibilityOfAllElements(driver, driver.findElements(circleLocator), 20);

				List<WebElement> circles = driver.findElements(circleLocator);
				// WebElement cardName = driver.findElement(By.xpath("//div[@class
				// ='card-body']//p[text()='" + graphName + "']"));
				if (circles.size() == 15) {
					// for (WebElement webElement : circles) {
					for (int i = 0; i < 15; i++) {

						// WebElement e =
						// driver.findElement(By.xpath("//div[@class='card-body']//p[text()='" +
						// graphName
						// + "']/..//*[name()='g']//*[name()='text'][text()='0']"));
						WebElement e = driver.findElement(By.xpath("//div[@class='card-body']//p[text()='" + graphName
								+ "']/..//*[name()='g']//*[name()='text']"));

						// WebElement e =
						// driver.findElement(By.xpath(//div[@class='card-body']//p[text()='" +
						// graphName+ "']));

						if (i == 0) {
							util.waitForVisibilityOfElement(driver, circles.get(i));
							if (circles.get(i).isDisplayed()) {
								util.scrollHandle(driver, circles.get(i));

								// try {
								// Thread.sleep(200);
								// } catch (InterruptedException z) {
								// // e.printStackTrace();
								// }
								util.moveTohalfsideOfanElement(driver, circles.get(i), "right");
								util.moveToQuarterOfElement(driver, circles.get(i), "top-right");

								// try {
								// Thread.sleep(1000);
								// } catch (InterruptedException z) {
								// // e.printStackTrace();
								// }

								util.waitForVisibilityOfElement(driver, circleTooltip);
								String tooltip = circleTooltip.getText();
								dates.add(tooltip.split(" : ")[0]);
								transactions.add(tooltip.split(" : ")[1]);

								// try {
								// Thread.sleep(200);
								// } catch (InterruptedException x) {
								// // e.printStackTrace();
								// }
								util.moveToELement(driver, e);
							} else {
								test.log(Status.FAIL, "Failed to displa the graph point");
								System.out.println("Failed to displa the graph point");
							}
							System.out.println("moved to element: " + i);
						} else if (i == 14) {
							util.waitForVisibilityOfElement(driver, circles.get(i));
							if (circles.get(i).isDisplayed()) {
								// util.moveTohalfsideOfanElement(driver, circles.get(i), "right");
								util.moveToELement(driver, circles.get(i));
								System.out.println("moved to element: " + i);
								util.waitForVisibilityOfElement(driver, circleTooltip);
								String tooltip = circleTooltip.getText();
								dates.add(tooltip.split(" : ")[0]);
								transactions.add(tooltip.split(" : ")[1]);

								// try {
								// Thread.sleep(200);
								// } catch (InterruptedException x) {
								// // TODO Auto-generated catch block
								// // e.printStackTrace();
								// }
								util.moveToELement(driver, e);
							} else {
								test.log(Status.FAIL, "Failed to displa the graph point");
								System.out.println("Failed to displa the graph point");
							}
						} else if (i > 0 & i < 14) {

							util.waitForVisibilityOfElement(driver, circles.get(i));
							if (circles.get(i).isDisplayed()) {
								// util.moveTohalfsideOfanElement(driver, circles.get(i), "center");
								util.moveToELement(driver, circles.get(i));
								System.out.println("moved to element: " + i);

								util.waitForVisibilityOfElement(driver, circleTooltip);
								String tooltip = circleTooltip.getText();
								dates.add(tooltip.split(" : ")[0]);
								transactions.add(tooltip.split(" : ")[1]);

								// try {
								// Thread.sleep(200);
								// } catch (InterruptedException x) {
								// // TODO Auto-generated catch block
								// // e.printStackTrace();
								// }
								util.moveToELement(driver, e);
							} else {
								test.log(Status.FAIL, "Failed to display the graph point");
								System.out.println("Failed to display the graph point");
							}

						}
					}
				} else {
					test.log(Status.FAIL, "graph circle count is not 15, actual count is: " + circles.size());
				}
			} catch (Exception e) {

				test.log(Status.FAIL, "Failed to load the graph point");
				System.out.println("Failed to load the graph point");
			}

		}

	}

	public List<String> getTooltipDate() {
		return this.dates;
	}

	public List<String> getTooltipValue() {
		return this.transactions;
	}

	public void clickOnDashBoard() {
		dashboardMenuOption.click();
	}

	public String getBObatchTotal() {
		util.waitForVisibilityOfElement(driver, bOBatchTotal);
		return bOBatchTotal.getText();
	}

	public String getBONumOfTransactions() {
		util.waitForVisibilityOfElement(driver, bONumOfTransaction);
		return bONumOfTransaction.getText();
	}

	public String getNumberOfTransactions() {
		// if(dbNumberOfTransactions.getText().contains(".")) {
		// return dbNumberOfTransactions.getText().split(".")[0];
		// }
		// else {

		return dbNumberOfTransactions.getText();
		// }

	}

}