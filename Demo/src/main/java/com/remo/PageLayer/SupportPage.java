package com.remo.PageLayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.remo.base.BaseClass;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class SupportPage extends BaseClass {

	public SupportPage(WebDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
		util = new Utility();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5/..//a[@class='supportEmails']")
	private List<WebElement> emails;

	@FindBy(xpath = "//div[@class='col-4']") // h6[contains(text(),'Company Name')]/..
	public WebElement companyName;

	@FindBy(xpath = "//h5/..//a[@class='supportEmails']")
	private WebElement Phone;

	@FindBy(xpath = "//h5[text()= 'Sales Agent Information']/..//h6[text()='Email']/../a")
	private WebElement agentEmail;

	@FindBy(xpath = "//h5[text()='Merchant Support']/..//h6[text()='Phone']/../span")
	public WebElement merchantSupportPhone;

	public String getMerchantSupportPhone() {
		return merchantSupportPhone.getText();

	}

	public String getSalesAgentEmail() {
		return agentEmail.getText();
	}

	/***
	 * THis method checks if all the email links in the page are enabled
	 * 
	 * @return true if the email links are enabled else false
	 */
	public boolean verifySupportEmailLinks() {
		boolean result = false;
		home.clickOnSupport();
		try {
			Thread.sleep(10000);
			util.waitForVisibilityOfAllElements(driver, emails, 20);

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, " Failed to fetch the links ");
			return result;
		}

		util.addBase64ScreenShotToReport(driver, test, "Support Page");
		if (!emails.isEmpty()) {
			for (WebElement email : emails) {
				util.waitForVisibilityOfElement(driver, email);
				if (email.isEnabled()) {
					result = true;
				} else {
					test.log(Status.FAIL, "email link is disabled");
					return false;
				}
			}
		}
		if (result) {
			test.log(Status.PASS, " All email links are enabled ");
		}
		return result;
	}

}
