package com.remo.PageLayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.remo.utility.Utility;

public class PartnerHub extends BaseClass {

    /**
     * Constructor for the PartnerHub class. Initializes the WebDriver instance,
     * configuration utility, and common utility. Also initializes the WebElements
     * on the page using PageFactory.
     * 
     * @param driver WebDriver instance used for browser interactions.
     */
    public PartnerHub(WebDriver driver) {
        this.driver = driver;
        prop = new ConfigUtil();
        util = new Utility();

        PageFactory.initElements(driver, this);

    }

    // ==================================================================
    // Web Elements
    // ==================================================================

    @FindBy(css = "[data-testid='nav-iso']")
    private WebElement partnerHubLink;

    @FindBy(xpath = "//a[@text='Add Equipment']")
    private List<WebElement> addEquipment;

    @FindBy(css = "[data-testid='page-title']")
    private WebElement reportName;

    @FindBy(css = "[data-testid='iso-tab']")
    private List<WebElement> equipmwtCatTabs;

    @FindBy(css = "[data-testid='iso-program']")
    private WebElement program;

    // ==================================================================
    // Action Methods of the class
    // ==================================================================

    public void navigateToPartnershub() {
        try {
            util.waitForVisibilityOfElement(driver, partnerHubLink);
            partnerHubLink.click();
            util.waitForVisibilityOfElement(driver, reportName);

            if (reportName.getText().equals("Merchant Applications")) {

            } else {
                test.log(Status.FAIL, "failed to navigate to totalsSummary");
            }
        } catch (Exception e) {
            System.out.println("Failed to navigate to Partners Hub");
            test.log(Status.FAIL, "Failed to navigate to partners Hub");
            e.printStackTrace();
        }

    }

    public void addequipment() {
        util.waitForVisibilityOfAllElements(driver, addEquipment);
        int size = addEquipment.size();
        addEquipment.get(util.getRandomenumber(size - 1)).click();
        util.waitForVisibilityOfElement(driver, reportName);

        if (reportName.getText().contains("New Merchant Application for"))
            ;
        {

        }

    }

    public void editapplication() {

    }

    public boolean VerifyEditEquipmentAfterPayment() {
        return false;
    }

}
