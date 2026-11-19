package com.remo.PageLayer;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.ValidationException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.remo.utility.Utility;

public class Dashboard extends BaseClass {

    /**
     * Constructor for the Dashboard class. Initializes the WebDriver instance,
     * configuration utility, and common utility. Also initializes the WebElements
     * on the page using PageFactory.
     * 
     * @param driver WebDriver instance used for browser interactions.
     */
    public Dashboard(WebDriver driver) {
        this.driver = driver;
        prop = new ConfigUtil();
        util = new Utility();

        PageFactory.initElements(driver, this);

    }

    // ==================================================================
    // Web Elements
    // ==================================================================

    @FindBy(css = "[data-testid='overview-select']")
    private WebElement overviewSelect;

    @FindBy(css = "[data-testid='overview-label']")
    private WebElement overviewLabel;

    @FindBy(xpath = "//a[@href='#/reports']")
    private WebElement reports;

    @FindBy(css = "[data-testid='batch-total']")
    private WebElement batchTotalElement;

    @FindBy(css = "[data-testid='overview-count']")
    private WebElement overviewCount;

    // ==================================================================
    // Methods
    // =================================================================

    private static final Logger LOG = Logger.getLogger(Dashboard.class.getName());

    /**
     * Select year from the overview date selection dropdown.
     * 
     * @param year the year or period string to select (e.g., "2026", "2025", "All",
     *             or "January 2026")
     * @return this page instance for method chaining
     * @throws ElementException if the dropdown element is not interactable
     */
    public void selectOverviewYear(String year) {
        try {
            util.waitForVisibilityOfElementWithWait(driver, overviewSelect, 20);
            util.selectDropdownByVisibleText(overviewSelect, year);

            // LOG.fine("Selected year: " + year);

        } catch (Exception e) {
            test.log(Status.INFO, "Failed to select year: " + year);
            throw new NoSuchElementException("Failed to select year '" + year + "': " + e.getMessage(), e);
        }

    }

    public void verifyDashboard() {
        util.waitForVisibilityOfElementWithWait(driver, overviewSelect, 20);
        if (overviewSelect.isDisplayed()) {
            System.out.println("launched successfuly");
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

    public String getSlectedOverview() {
        // util.getSelectedOption(driver, overviewSelect).getText()
        return util.getSelectedOption(driver, overviewSelect).getText();
    }

    /**
     * Get the Batch Total from Business Overview.
     * This should equal the Totals Summary Total Submitted Amount when bug is OFF.
     * Bug-01 causes Totals Summary to show gross sales instead of net (sales -
     * refunds).
     * 
     * @return the batch total as a string
     * @throws NotFoundException   if the batch total element is not found
     * @throws ValidationException if the element text is empty or invalid
     */
    public String getBatchTotal() {
        try {
            util.waitForVisibilityOfElement(driver, batchTotalElement);
            String batchTotal = batchTotalElement.getText().trim();

            if (batchTotal == null || batchTotal.isEmpty()) {
                throw new ValidationException("Batch total value is empty");
            }

            return batchTotal;

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to get Batch total");
            throw new NotFoundException("Failed to get Batch total: " + e.getMessage(), e);
        }
    }

    /**
     * Get the Batch Total from Business Overview.
     * This should equal the Totals Summary Total Submitted Amount when bug is OFF.
     * Bug-01 causes Totals Summary to show gross sales instead of net (sales -
     * refunds).
     * 
     * @return the batch total as a string
     * @throws NotFoundException   if the batch total element is not found
     * @throws ValidationException if the element text is empty or invalid
     */
    public String getOverviewTransactionCount() {
        try {
            util.waitForVisibilityOfElement(driver, overviewCount);
            String batchTcount = overviewCount.getText().trim();

            if (batchTcount == null || batchTcount.isEmpty()) {
                throw new ValidationException("Overview Number of Transactions value is empty");
            }

            return batchTcount;

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to get Number of Transactions");
            throw new NotFoundException("Failed to get Number of Transactions: " + e.getMessage(), e);
        }
    }

    // /**
    // * Get dynamically generated overview item by key.
    // *
    // * @param key the data-testid key suffix
    // * @return the WebElement for the overview item
    // * @throws NotFoundException if the element is not found
    // */
    // private WebElement getOverviewItem(String key) {
    // try {
    // By locator = By.cssSelector("[data-testid='overview-" + key + "']");
    // WebElement element = driver.findElement(locator);
    // return element;
    // } catch (org.openqa.selenium.NoSuchElementException e) {
    // LOG.warning("Overview item not found: " + key);
    // throw new NotFoundException("Overview item '" + key + "' not found: " +
    // e.getMessage(), e);
    // } catch (Exception e) {
    // LOG.log(Level.SEVERE, "Unexpected error finding overview item: " + key, e);
    // throw new NoSuchElementException("Error finding overview item '" + key + "':
    // " + e.getMessage(), e);
    // }
    // }

}
