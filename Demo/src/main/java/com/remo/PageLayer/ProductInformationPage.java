package com.remo.PageLayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.remo.base.BaseClass;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class ProductInformationPage extends BaseClass {

	/**
	 * Constructor for the ProductInformationPage class.
	 * Initializes the WebDriver instance, home page instance, and common utility.
	 * Also initializes the WebElements on the page using PageFactory.
	 * 
	 * @param driver WebDriver instance used for browser interactions.
	 */
	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
		util = new Utility();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card-body']//h5")
	private List<WebElement> allCards;

	@FindBy(xpath = "//div[@class='card-footer']//a[contains(text(),'View')]")
	private List<WebElement> allCardLinks;

	@FindBy(xpath = "//td//h6")
	private List<WebElement> fileNames;

	@FindBy(xpath = "//a[text()='Download File']")
	private List<WebElement> downloadFileLinks;

	@FindBy(xpath = "//h5[text()='Product Information']")
	private WebElement productInformationHeader;

	@FindBy(xpath = "//a[contains(text(),'Product Information ')]")
	private WebElement productInformationNavigationLink;

	@FindBy(xpath = "//h5/..//a[contains(text(),'Product Help')]")
	private WebElement productHelpNavigationLink;

	@FindBy(xpath = "//h5[contains(@class, 'widget-name')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()='Get Help']")
	private WebElement ProductHelp;

	@FindBy(xpath = "//a[text()='Download Documents']")
	private WebElement helpfulForms;

	@FindBy(xpath = "//a[text()='Read The Blog']")
	private WebElement electronicPaymentsBlog;

	@FindBy(xpath = "//a[contains(text(),'Video Library')]")
	private WebElement epiVideoChannel;

	@FindBy(xpath = "//*[text()='EPI Video Channel'] ")
	private WebElement epiVideoChannelHeader;

	// h1//span[text()='EPI Video Channel']

	public boolean verifyNavigationToProductInformationPage() {
		util.waitForVisibilityOfElement(driver, productInformationHeader);
		if (productInformationHeader.isDisplayed()) {

			return true;
		} else {
			return false;
		}

	}

	/***
	 * This method waits for the visibility of all the product information cards,
	 * get the text of the cards and compares with the list of all cards(allCards)
	 * 
	 * @return true if the cards are displayed, else false
	 */

	public boolean visibilityOfProductInfoCards() {
		home.clickOnProductInformation();

		verifyNavigationToProductInformationPage();

		util.addBase64ScreenShotToReport(driver, test, "Product information page");

		boolean result = false;
		util.waitForVisibilityOfAllElements(driver, allCards);
		for (WebElement card : allCards) {
			util.waitForVisibilityOfElement(driver, card);
			if (card.isDisplayed()) {
				test.log(Status.PASS, card.getText() + " card is displayed");

				result = true;
			} else {
				test.log(Status.FAIL, card.getText() + " card is not displayed");

				result = false;
			}
			if (result == false) {
				return result;
			}
		}
		return result;

	}

	/**
	 * checks the clickability of Product Help card link
	 */
	public void clickOnProductHelp() {
		util.waitForVisibilityOfElement(driver, ProductHelp);
		ProductHelp.click();
	}

	/**
	 * checks the clickability of the Helpful forms and Literatures card link
	 */
	public void clickOnHelpfulFormsAndLiteratures() {
		util.waitForVisibilityOfElement(driver, helpfulForms);
		helpfulForms.click();
	}

	/**
	 * checks the clickability of the Electronic Payments Blog card link
	 */
	public void clickOnElectronicPaymentsBlog() {
		util.waitForVisibilityOfElement(driver, electronicPaymentsBlog);
		electronicPaymentsBlog.click();
	}

	/**
	 * checks the clickability of EPI Video Channel card link
	 */
	public void clickOnEPIVideoChannel() {
		util.waitForVisibilityOfElement(driver, epiVideoChannel);
		epiVideoChannel.click();
	}

	/**
	 * This method verifies the visibility of the cards in the Product Help page.
	 * checks the navigation functionality for each card and verifies the header of
	 * the card with the help of get.Text() method
	 * 
	 * @return true if the hyper links of the cards navigate to their respective
	 *         pages otherwise false
	 */
	public boolean linkValidationOfProductHelpCards() {

		home.clickOnProductInformation();
		clickOnProductHelp();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		boolean result = false;
		try {
			util.waitForDomToLoad(driver);
			util.waitForVisibilityOfAllElements(driver, allCardLinks);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Link Validation of Product Help Cards Failed");
		}
		try {
			int allCardCount = allCardLinks.size();
			System.out.println("product help card forund : size: " + allCardCount);

			for (int i = 0; i < allCardCount; i++) {
				util.waitForVisibilityOfElement(driver, allCardLinks.get(i));
				WebElement card = allCardLinks.get(i);
				util.waitForVisibilityOfElement(driver, card);
				if (card.isDisplayed()) {
					util.waitForVisibilityOfElement(driver, allCards.get(i));
					String header = allCards.get(i).getText();
					util.waitForVisibilityOfElement(driver, card);
					card.click();

					Thread.sleep(1000);

					util.waitForVisibilityOfElement(driver, pageHeader);

					if (pageHeader.getText().equalsIgnoreCase(header)) {
						test.log(Status.PASS, "Successfully navigated to " + header + " page");

						util.addBase64ScreenShotToReport(driver, test, header);
						// util.waitForVisibilityOfElement(driver, productHelpNavigationLink);
						// productHelpNavigationLink.click();

						driver.navigate().back();
						result = true;
					} else {
						test.log(Status.FAIL, card.getText() + " link Failed to navigate to " + header + " page");
						driver.navigate().back();
						result = false;
					}

				} else {
					test.log(Status.FAIL, " card is not visible");
					result = false;
				}
				if (result == false) {
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed when enteractibg with product cards");
			util.addBase64ScreenShotToReport(driver, test, "Link Validation of Product Help Cards Failed");
			return false;
		}
		return result;

	}

	/***
	 * This method navigates from Product Information page to Helpful forms and
	 * Literatures page. waits for the visibility of all the download file
	 * links.checks if the download links are enabled
	 * 
	 * @return true if the download links are enabled else return false
	 */
	public boolean linkValidationOfHelpfulFormsAndLiteratures() {
		home.clickOnProductInformation();
		clickOnHelpfulFormsAndLiteratures();
		boolean result = false;
		util.waitForVisibilityOfAllElements(driver, fileNames);
		util.waitForVisibilityOfAllElements(driver, downloadFileLinks);

		util.addBase64ScreenShotToReport(driver, test, "Helpful Forms and Literatures-1");

		int fileCount = fileNames.size();
		for (int i = 0; i < fileCount; i++) {
			WebElement fileName = fileNames.get(i);
			WebElement link = downloadFileLinks.get(i);
			util.waitForVisibilityOfElement(driver, link);
			if (i == fileCount - 1) {
				util.scrollHandle(driver, fileName);
				util.addBase64ScreenShotToReport(driver, test, "Helpful Forms and Literatures-2");
				//
				// try {
				// Thread.sleep(1000);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }

			}
			if (link.isEnabled()) {
				result = true;
			} else {
				test.log(Status.FAIL, fileName.getText() + " Download File link is disabled");
				result = false;
			}

		}
		if (result == false) {
			return result;
		} else {
			test.log(Status.PASS, " All download links are enabled ");
			return result;
		}
	}

	/**
	 * This method checks the navigation functionality from Product Information page
	 * to EPI Video Channel. switches to the new window and verifies the header of
	 * the page
	 * 
	 * @return true if the EPI Video Header is displayed else return false
	 */
	public boolean linkValidationOfEPIVideoChannel() {

		home.clickOnProductInformation();
		clickOnEPIVideoChannel();
		util.switchToNewlyOpenedWindow(driver);
		util.waitForVisibilityOfElement(driver, epiVideoChannelHeader);
		if (epiVideoChannelHeader.isDisplayed()) {
			test.log(Status.PASS, " Successfully navigated to EPI Video Channel");

			util.addBase64ScreenShotToReport(driver, test, "EPI Video Channel");
			driver.close();
			util.switchToParentWindow(driver);
			return true;
		} else {
			test.log(Status.FAIL, " Failed to navigated to EPI Video Channel");
			driver.close();
			util.switchToParentWindow(driver);
			return false;
		}
	}

}
