package com.remo.PageLayer;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.ValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.remo.base.BaseClass;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class ReportsPage extends BaseClass {

	private static final Logger LOG = Logger.getLogger(ReportsPage.class.getName());

	/**
	 * Constructor for the Reports Page class. Initializes the WebDriver instance
	 * and common utility. Also initializes the WebElements on the page using
	 * PageFactory.
	 * 
	 * @param driver WebDriver instance used for browser interactions.
	 */
	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
		util = new Utility();

		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElements For Reports Page
	 */

	@FindBy(xpath = "//div[@class='rcard']//div[@class='rt']")
	private List<WebElement> allReports;

	@FindBy(css = "[data-testid='view-report-totals-summary']")
	private WebElement totalsSummaryLink;

	@FindBy(css = "[data-testid='page-title']")
	private WebElement reportsHeader;

	@FindBy(xpath = "//a[contains(text(),'View ')]")
	public List<WebElement> viewReportBtns;

	@FindBy(xpath = "//a[@href='#/reports']")
	private WebElement reports;

	@FindBy(css = "[data-testid='filter-apply']")
	private WebElement filter;

	@FindBy(css = "[data-testid='report-period']")
	private WebElement reportPeriodLabel;

	@FindBy(css = "[data-testid='report-table-totals-row']")
	private WebElement totalsRow;

	/**
	 * WebElements For Reports Page
	 */

	@FindBy(css = "[data-testid='page-title']")
	private WebElement reportName;

	@FindBy(xpath = "//button[text()='Reports']")
	private WebElement reportNavigationLink;

	@FindBy(xpath = "//h5[contains(text(),'Summary Report')]//..//..//..//..//a[text()='View Report']")
	public WebElement totalsSummaryReport;

	@FindBy(xpath = "//h5[contains(text(),'Settled Batches')]//..//..//..//..//a[text()='View Report']")
	private WebElement settledBatches;

	@FindBy(xpath = "//h5[contains(text(),'ACH Deposit')]//..//..//..//..//a[text()='View Report']")
	private WebElement ACHDeposit;

	@FindBy(xpath = "//h5[contains(text(),'Merchant Statement')]//..//..//..//..//a[text()='View Report']")
	private WebElement merchantStatement;

	@FindBy(xpath = "//h5[contains(text(),'Search Transactions')]//..//..//..//..//a[text()='View Report']")
	public WebElement searchTransactions;

	@FindBy(xpath = "//h5[contains(text(),'Chargebacks Report')]//..//..//..//..//a[text()='View Report']")
	private WebElement chargebacksReport;

	@FindBy(xpath = "//h5[contains(text(),'Daily Upload Report')]//..//..//..//..//a[text()='View Report']")
	private WebElement dailyUploadReport;

	@FindBy(xpath = "//h5[contains(text(),'PCD Live View Report')]//..//..//..//..//a[text()='View Report']")
	private WebElement PCDLiveViewReport;

	@FindBy(xpath = "//h5[contains(text(),'Daily Discount Calculator')]//..//..//..//..//a[contains(text(),'View')]")
	private WebElement virwDailyDiscountCalculator;

	@FindBy(xpath = "//h5[contains(text(),'Daily Discount Calculator')]")
	private WebElement dailyDiscountCalculator;

	@FindBy(css = "[data-testid='filter-mode']")
	private WebElement filterByDropdown;

	@FindBy(css = "[data-testid='filter-month']")
	public WebElement monthDropdown;

	@FindBy(name = "year")
	private WebElement yearDropdown;

	@FindBy(xpath = "//label[contains(text(),'Type')]//..//select")
	private WebElement typeDropdown;

	@FindBy(xpath = "//button[text()='Filter']")
	private WebElement filterButton;

	@FindBy(xpath = "//button[text()='Clear Filter']")
	private WebElement clearFilterButton;

	@FindBy(xpath = "//input[@id='forDate']")
	private WebElement dateField;

	@FindBy(xpath = "//button[@aria-label='Previous Month']")
	private WebElement previousMonth;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	private WebElement nextMonth;

	@FindBy(xpath = "//div[@class='react-datepicker__current-month']")
	private WebElement calenderCurrentMonth;

	@FindBy(xpath = "//div[@class='react-datepicker__month']//div[contains(@class,'day--today')]")
	private WebElement today;

	@FindBy(xpath = "//input[@id = 'fromDate']")
	private WebElement fromDate;

	@FindBy(xpath = "//input[@id='toDate']")
	private WebElement toDate;

	@FindBy(xpath = "//label[contains(text(),'Amount')]/..//input")
	private WebElement amount;

	@FindBy(xpath = "//input[@name='TraceNum']")
	private WebElement traceNum;

	@FindBy(xpath = "//input[@name='last4digitsOfCard']")
	private WebElement last4digitsOfCard;

	@FindBy(xpath = "//button[contains(text(),'Download PDF')]")
	private WebElement downloadPDFButton;

	@FindBy(xpath = "//button[contains(text(),'Download Excel')]")
	private WebElement downloadExcelButton;

	@FindBy(xpath = "//label[contains(@for,'dateFilt')]/..//select")
	private WebElement dateTypeDropdown;

	@FindBy(xpath = "//label[contains(@for,'TransType')]/..//select")
	private WebElement transTypeDropdown;

	@FindBy(xpath = "//label[contains(@for,'TranCode')]/..//select")
	private WebElement transCodeDropdown;

	@FindBy(xpath = "//tbody[@role='presentation']//td[text()='No records available']")
	public WebElement noRecordsAvailableMsg;

	@FindBy(xpath = "//div[@class ='k-grid-footer']//td[7]")
	public WebElement totalsSummaryReportSalesAmount;

	// @FindBy(xpath = "//tbody[@role='presentation']//td[text()='Your download is
	// processing, will notify you once it is completed']")
	// private WebElement downloadIsInProgress;
	//

	@FindBy(xpath = "//button[@type='button' and text()='✖']/../div[text()='No data available so cannot download']")
	private WebElement NoDataAvailablePopup;

	@FindBy(xpath = "//button[@type='button' and text()='✖']")
	private WebElement closeNotification;

	@FindBy(xpath = "//button[@type='button' and text()='✖']/..//div[text()='Please enter valid filter options.']")
	private WebElement pleaseEnterValidInputMsg;

	@FindBy(xpath = "//div[@position='top-right']//div[text()='Your download is processing, will notify you once it is completed']")
	private WebElement downloadIsProcessing;

	@FindBy(xpath = "//label[@for='month']/..//select[@class='report-filter-select']//option")
	private List<WebElement> monthOptions;

	@FindBy(xpath = "//tbody[@role ='presentation']//tr//td//a")
	private List<WebElement> batchIds;

	@FindBy(xpath = "//tbody[@role ='presentation']//tr[contains(@class,'k-master-row')]")
	private List<WebElement> tableDataRows;

	@FindBy(xpath = "//div[@class='report-filter-outerPadding']//span[contains(text(), 'Batch ID')]")
	private WebElement batchIdText;

	@FindBy(xpath = "//div[@class='report-filter-outerPadding']//span[contains(text(), 'Count')]")
	private WebElement batchIdTransCount;

	@FindBy(xpath = "//div[@class='report-filter-outerPadding']//span[contains(text(), 'Amount')]")
	private WebElement batchIdTransAmount;

	@FindBy(xpath = "//tr[@class='k-grid-norecords']//td[text()='No records available']")
	private WebElement noRecodsAvailables;

	@FindBy(xpath = "//div[@class='k-grid-header']//tr//a")
	private List<WebElement> reportHeaderList;

	public int getIndexOfTableHeader(String header) {

		util.waitForVisibilityOfAllElements(driver, reportHeaderList);

		int size = reportHeaderList.size();
		// System.out.println("size: "+size);

		int HeaderIndex = 0;
		for (int i = 1; i <= size; i++) {
			util.waitForVisibilityOfElement(driver,
					driver.findElement(By.xpath("//div[@class='k-grid-header']//th[@aria-colindex= '" + i + "']//a")));
			WebElement e = driver.findElement(
					By.xpath("//div[@class='k-grid-header']//th[@aria-colindex= '" + i + "']//a[@class = 'k-link']"));

			// System.out.println(e.getText());

			if (e.getText().contains(header)) {
				return i;
			}
		}
		return HeaderIndex;

	}

	public List<WebElement> getTableColumnAtIndex(int index) {
		return driver.findElements(By.xpath(
				"//tbody[@role ='presentation']//tr[contains(@class,'k-master-row')]//td[position()=" + index + "]"));
	}

	/**
	 * Methods
	 */

	/**
	 * Waits for the filter button to be visible, then clicks on it.
	 */
	public void clickOnFilterButton() {
		util.waitForVisibilityOfElement(driver, filterButton);
		filterButton.click();
	}

	/**
	 * Waits for the clear filter button to be visible, then clicks on it.
	 */
	public void clickOnClearFilterButton() {
		util.waitForVisibilityOfElement(driver, clearFilterButton);
		clearFilterButton.click();
	}

	/**
	 * Verifies the navigation to the Reports page by checking the visibility of the
	 * reportsHeader element.
	 *
	 * @return True if the reportsHeader element is displayed, indicating successful
	 *         navigation to the Reports page; false otherwise.
	 */
	public boolean verifyNavigationToReportsPage() {
		util.waitForVisibilityOfElement(driver, reportsHeader);
		if (reportsHeader.isDisplayed()) {

			return true;
		} else {
			return false;
		}

	}

	/**
	 * Retrieves the current URL of the Reports page.
	 *
	 * @return The current URL of the Reports page as a String.
	 */
	public String getReportsPageUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Verifies the visibility of all report cards on the Reports page. It clicks on
	 * the Reports link from the Home page and verifies if each report card is
	 * displayed.
	 *
	 * @return true if all report cards are displayed, false otherwise.
	 */
	public boolean visibilityOfReportCards() {
		// dashboard.clickOnReports();
		verifyNavigationToReportsPage();
		boolean result = false;
		util.waitForVisibilityOfAllElements(driver, allReports);

		util.addBase64ScreenShotToReport(driver, test, "Reports Page");
		for (WebElement report : allReports) {
			util.waitForVisibilityOfElement(driver, report);
			if (report.isDisplayed()) {
				test.log(Status.PASS, report.getText() + " report card is displayed");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				result = true;
			} else {
				test.log(Status.FAIL, report.getText() + " report card is not displayed");
				result = false;
			}
			if (result == false) {
				return result;
			}
		}
		return result;

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
	 * This method checks the visibility of all the reports. Verifies the navigation
	 * functionality by comparing the Card name with the report name i.e., report
	 * header
	 * 
	 * @return true if the card name and report name are matching else return false
	 */
	public boolean linkValidationOfReports() {
		int size = 0;
		clickOnReports();
		boolean result = false;
		try {
			util.waitForVisibilityOfAllElements(driver, allReports, 20);
			size = allReports.size();
			System.out.println("***********Size: " + size);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Load Reports page");
			return false;
		}

		for (int i = 0; i < size; i++) {
			String cardName = null;
			try {
				util.waitForVisibilityOfAllElements(driver, allReports, 20);
				util.waitForVisibilityOfElement(driver, allReports.get(i));
				cardName = allReports.get(i).getText();
				System.out.println(cardName);
			} catch (Exception e) {
				test.log(Status.FAIL, "Failed to Fetch Report card names");
				return false;
			}
			// try {
			// util.waitForVisibilityOfAllElements(driver, allReports);
			// util.waitForVisibilityOfElement(driver, viewReportBtns.get(i));
			if (viewReportBtns.get(i).isDisplayed()) {
				viewReportBtns.get(i).click();

				String str1 = getReportName().replaceAll("\\s", "");
				System.out.println(str1);

				// String str1 = reportName.getText().replaceAll("\\s", "");
				String str2 = cardName.replaceAll("\\s", "");
				System.out.println(str2);

				if (str1.equalsIgnoreCase(str2)) {

					test.log(Status.PASS, "Navigated successfully to " + reportName.getText() + " page");

					clickOnReports();

					util.waitForVisibilityOfAllElements(driver, allReports);
					result = true;
				} else {
					// reportNavigationLink.click();
					dashboard.clickOnReports();
					result = false;
					test.log(Status.FAIL, "Failed to Navigate to " + cardName + " page");
				}
			} else {
				reportNavigationLink.click();
				test.log(Status.FAIL, cardName + " report card is not displayed");
				result = false;
			}

			// } catch (Exception e) {
			// reportNavigationLink.click();
			// test.log(Status.FAIL, "Failed to navigate to: " + cardName);
			// result = false;
			// continue;
			// }

			if (!result) {
				return result;
			}

		}
		return result;
	}

	/**
	 * Verifies the functionality of filtering by 'Month' in the filter dropdown. It
	 * waits for the visibility of the filterByDropdown element, selects 'By Month',
	 * and verifies if the filter is applied successfully.
	 *
	 * @return true if filtering by 'Month' is successful, false otherwise.
	 */
	public boolean verifyFilterByMonth() {
		util.waitForVisibilityOfElement(driver, filterByDropdown);

		if (filterByMonth()) {

			util.addBase64ScreenShotToReport(driver, test, "Filter by Month");

			test.log(Status.PASS, "Filter 'By Month' successful");
			clickOnClearFilterButton();
			return true;
		} else {
			test.log(Status.FAIL, "Filter 'By Month' Failed");

			return false;
		}

	}





























































	// ===========================================================
	// ===========================================================
	// ==========================================================


	public boolean verifyFilterByMonthBatch() {
		util.waitForVisibilityOfElement(driver, filterByDropdown);

		if (filterByMonthBatch(filterByDropdown)) {

			util.addBase64ScreenShotToReport(driver, test, "Filter by Month");

			test.log(Status.PASS, "Filter 'By Month' successful");
			clickOnClearFilterButton();
			return true;
		} else {
			test.log(Status.FAIL, "Filter 'By Month' Failed");

			return false;
		}

	}

	/**
	 * clicks on Totals summary report, checks the Filter 'By Month' and 'By Day'
	 * dropdown functionality
	 * 
	 * @return false if the filter By functionality is not working
	 */
	public void navigateToTotalsSummary() {
		try {
			clickOnReports();
			util.waitForVisibilityOfAllElements(driver, allReports);
			util.waitForVisibilityOfElement(driver, totalsSummaryLink);
			totalsSummaryLink.click();
			util.waitForVisibilityOfElement(driver, reportName);
			// System.out.println(reportName);

			if (reportName.getText().equals("Totals Summary Report")) {

			} else {
				test.log(Status.FAIL, "failed to navigate to totalsSummary");
			}
		} catch (Exception e) {
			System.out.println("failed to navigate to total summary report");
			test.log(Status.FAIL, "failed to navigate to total summary report");
			e.printStackTrace();
		}
	}

	/**
	 * Verifies the functionality of filtering by 'Day' in the filter dropdown. It
	 * waits for the visibility of the filterByDropdown element, selects 'By Day',
	 * and verifies if the filter is applied successfully.
	 *
	 * @return true if filtering by 'Day' is successful, false otherwise.
	 */
	public boolean verifyFilterByDay() {
		// clickOnClearFilterButton();
		boolean result = false;
		util.waitForVisibilityOfElement(driver, filterByDropdown);
		if (filterByDay(filterByDropdown)) {

			util.addBase64ScreenShotToReport(driver, test, "Filter by Day");

			test.log(Status.PASS, "Filter 'By Day' successful");
			clickOnClearFilterButton();
			result = true;
		} else {
			test.log(Status.FAIL, "Filter 'By Day' Failed");

			return false;
		}

		return result;
	}

	/**
	 * Verifies the functionality of filtering by a specific date range in the
	 * filter dropdown. It waits for the visibility of the filterByDropdown element,
	 * selects the specified date range, and verifies if the filter is applied
	 * successfully.
	 *
	 * @param value The value representing the date range to filter by.
	 * @return true if filtering by the specified date range is successful, false
	 *         otherwise.
	 */
	public boolean VerifyFilterByDateRange(String value) {
		// clickOnClearFilterButton();
		boolean result = false;
		util.waitForVisibilityOfElement(driver, filterByDropdown);
		if (filterByDateRange(filterByDropdown, value)) {

			// util.addBase64ScreenShotToReport(driver, test, "Filter by Date Range");
			test.log(Status.PASS, "Filter 'By Date Range' successful");

			result = true;
		} else {
			test.log(Status.FAIL, "Filter 'By Date Range' Failed");
			return false;
		}

		return result;
	}

	/**
	 * Filters by month in the specified dropdown element and verifies if the filter
	 * is applied successfully. It selects each month from the dropdown and checks
	 * if the filter criteria are met.
	 *
	 * @param e The WebElement representing the filter dropdown.
	 * @return true if the filter by month is applied successfully, false otherwise.
	 * @throws InterruptedException
	 */
	public boolean filterByMonthBatch(WebElement e) {
		SoftAssert s = new SoftAssert();
		util.waitForVisibilityOfElement(driver, e);
		util.selectDropdownByValue(e, "monthyear");
		boolean result = false;
		util.waitForVisibilityOfElement(driver, monthDropdown);
		util.waitForVisibilityOfElement(driver, yearDropdown);

		boolean filterChang = monthDropdown.isDisplayed() && yearDropdown.isDisplayed();

		if (filterChang) {

			int size = util.getMonthList().size();
			// for (int i = 1; i < size; i++) {
			// if (i <= util.getIntCurrentMonthNum()) {
			util.selectDropdownByValue(monthDropdown, util.getIntCurrentMonthNum() + "");

			util.selectDropdownByValue(yearDropdown, util.getCurrentYear());

			clickOnFilterButton();

			boolean con1 = util.getSelectedOption(driver, e).getText().contains("Month");
			boolean con2 = util.getMonthList().get(util.getIntCurrentMonthNum())
					.contains(util.getSelectedOption(driver, monthDropdown).getText());
			boolean con3 = util.getSelectedOption(driver, yearDropdown).getText()
					.equalsIgnoreCase(util.getCurrentYear());

			try {
				util.waitForVisibilityOfElementWithWait(driver, noRecodsAvailables, 1);
				if (!noRecodsAvailables.isDisplayed()) {
					throw new InterruptedException("Error message");

				}
				System.out.print(util.getSelectedOption(driver, monthDropdown).getText());
				System.out.println(" : No Data available");

			} catch (Exception ex) {

				System.out.println("data available");

				util.waitForVisibilityOfAllElements(driver, tableDataRows);
				util.waitForVisibilityOfAllElements(driver, batchIds);
				int rowcount = tableDataRows.size();

				String batchAmount;
				String transCount;
				String batchId;

				if (rowcount > 5) {
					for (int j = 0; j < 2; j++) {
						util.waitForVisibilityOfAllElements(driver, tableDataRows);
						util.waitForVisibilityOfAllElements(driver, batchIds);
						// try {
						// Thread.sleep(3000);
						// } catch (InterruptedException e1) {
						// // TODO Auto-generated catch block
						// e1.printStackTrace();
						// }

						int random = util.getRandomenumber(rowcount - 1);
						System.out.println("Row count" + rowcount);
						System.out.println("Randome: " + random);
						// util.waitForVisibilityOfAllElements(driver, batchIds);

						List<WebElement> batchIdList = getTableColumnAtIndex(getIndexOfTableHeader("Batch ID"));
						List<WebElement> batchAmountList = getTableColumnAtIndex(
								getIndexOfTableHeader("Batch Amount"));
						List<WebElement> transCountList = getTableColumnAtIndex(
								getIndexOfTableHeader("Trans Count"));

						batchId = batchIdList.get(random).getText().replace(",", "");
						batchAmount = batchAmountList.get(random).getText().replace(",", "");
						transCount = transCountList.get(random).getText().replace(",", "");

						batchIds.get(random).click();

						util.waitForVisibilityOfElement(driver, batchIdText);

						String expectedBatchId = batchIdText.getText().split(": ")[1].trim().replace(",", "");
						String expectedTransCount = batchIdTransCount.getText().split(": ")[1].trim().replace(",", "");
						String expectedBatchTransAmount = batchIdTransAmount.getText().split(": ")[1].trim()
								.replace(",", "");

						System.out.println(expectedBatchId);
						System.out.println(expectedTransCount);
						System.out.println(expectedBatchTransAmount);

						System.out.println(batchAmount);
						System.out.println(batchId);
						System.out.println(transCount);
						System.out.println("=====1111======");

						if (!expectedBatchId.equals(batchId)) {
							test.log(Status.FAIL,
									"'Batch ID' does not match from the Batch Transactions Report Expected: "
											+ batchId + " Actual: "
											+ expectedBatchId);
						}

						if (!expectedTransCount.equals(transCount)) {
							test.log(Status.FAIL,
									"'Trans Count' does not match from the Batch Transactions Report Expected: "
											+ transCount + " Actual: "
											+ expectedTransCount);
						}

						if (!expectedBatchTransAmount.equals(batchAmount)) {
							test.log(Status.FAIL,
									"'Batch Trans Amount' does not match from the Batch Transactions Report Expected: "
											+ batchAmount + " Actual: "
											+ expectedBatchTransAmount);
						}

						Assert.assertEquals(expectedBatchId, batchId);
						Assert.assertEquals(expectedTransCount, transCount);
						Assert.assertEquals(expectedBatchTransAmount, batchAmount);

						driver.navigate().back();
						util.waitForDomToLoad(driver);
					}
				}

			}

			if (con1 & con2 & con3) {
				test.log(Status.PASS, "'By Month' Filter applied successfully");
				result = true;
			} else {
				result = false;
				test.log(Status.FAIL, "Failed to apply filter");
			}

			// if (i > util.getIntCurrentMonthNum()) {
			// util.selectDropdownByValue(monthDropdown, i + "");
			// util.selectDropdownByValue(yearDropdown, util.getPrevYear());
			//
			// clickOnFilterButton();
			//
			// boolean con1 = util.getSelectedOption(driver, e).getText().contains("Month");
			// boolean con2 = util.getMonthList().get(i)
			// .contains(util.getSelectedOption(driver, monthDropdown).getText());
			// boolean con3 = util.getSelectedOption(driver, yearDropdown).getText()
			// .equalsIgnoreCase(util.getPrevYear());
			//
			// try {
			// util.waitForVisibilityOfElementWithWait(driver, noRecodsAvailables, 1);
			// if (!noRecodsAvailables.isDisplayed()) {
			// throw new InterruptedException("Error message");
			//
			// }
			// System.out.print(util.getSelectedOption(driver, monthDropdown).getText());
			// System.out.println(" : No Data available");
			//
			// } catch (Exception ex) {
			//
			// // System.out.println("data available");
			// // Thread.sleep(3000);
			// util.waitForVisibilityOfAllElements(driver, tableDataRows);
			// util.waitForVisibilityOfAllElements(driver, batchIds);
			// int rowcount = tableDataRows.size();
			//
			// String batchAmount;
			// String transCount;
			// String batchId;
			//
			// if (rowcount > 5) {
			// for (int j = 0; j < 2; j++) {
			// int random = util.getRandomenumber(rowcount - 1);
			// // int random =1;
			// // util.waitForVisibilityOfAllElements(driver,tableDataRows);
			//
			// List<WebElement> batchIdList =
			// getTableColumnAtIndex(getIndexOfTableHeader("Batch ID"));
			// List<WebElement> batchAmountList = getTableColumnAtIndex(
			// getIndexOfTableHeader("Batch Amount"));
			// List<WebElement> transCountList = getTableColumnAtIndex(
			// getIndexOfTableHeader("Trans Count"));
			//
			// batchId = batchIdList.get(random).getText().replace(",", "");
			// batchAmount = batchAmountList.get(random).getText().replace(",", "");
			// transCount = transCountList.get(random).getText().replace(",", "");
			//
			// batchIds.get(random).click();
			//
			// util.waitForVisibilityOfElement(driver, batchIdText);
			//
			// String expectedBatchId = batchIdText.getText().split(":
			// ")[1].trim().replace(",", "");
			// String expectedTransCount =batchIdTransCount.getText().split(":
			// ")[1].trim().replace(",", "");
			// String expectedBatchTransAmount =batchIdTransAmount.getText().split(":
			// ")[1].trim().replace(",", "");
			//
			//
			// System.out.println(expectedBatchId);
			// System.out.println(expectedTransCount);
			// System.out.println(expectedBatchTransAmount);
			//
			// System.out.println(batchAmount);
			// System.out.println(batchId);
			// System.out.println(transCount);
			// System.out.println("=====2222======");
			//
			// if (!expectedBatchId.equals(batchId)) {
			// test.log(Status.FAIL,
			// "'Batch ID' does not match from the Batch Transactions Report Expected: "
			// + batchId + " Actual: "
			// + expectedBatchId);
			// }
			//
			// if (!expectedTransCount.equals(transCount)) {
			// test.log(Status.FAIL,
			// "'Trans Count' does not match from the Batch Transactions Report Expected: "
			// + transCount + " Actual: "
			// + expectedTransCount);
			// }
			//
			// if (!expectedBatchTransAmount.equals(batchAmount)) {
			// test.log(Status.FAIL,
			// "'Batch Trans Amount' does not match from the Batch Transactions Report
			// Expected: "
			// + batchAmount + " Actual: "
			// + expectedBatchTransAmount);
			// }
			// Assert.assertEquals(expectedBatchId, batchId);
			// Assert.assertEquals(expectedTransCount, transCount);
			// Assert.assertEquals(expectedBatchTransAmount, batchAmount);
			//
			// driver.navigate().back();
			// // Thread.sleep(3000);
			// util.waitForDomToLoad(driver);
			// }
			// }
			// }
			//
			// if (con1 & con2 & con3) {
			// test.log(Status.PASS, "'By Month' Filter applied successfully");
			// result = true;
			// } else {
			// result = false;
			// test.log(Status.FAIL, "Failed to apply filter");
			// }
			// }
			// }

		} else {
			// s.assertAll();
			test.log(Status.FAIL, "Failed to change the filter for 'By Month' options");
			return false;
		}
		// s.assertAll();
		return result;
	}

	/**
	 * Get the report period label.
	 *
	 * @return the period label text
	 * @throws NotFoundException if the label is not found
	 */
	public String getReportPeriod() {
		String period = null;
		try {
			util.waitForVisibilityOfElement(driver, reportPeriodLabel);
			period = reportPeriodLabel.getText().trim();
			// LOG.fine("Report period: " + period);
			return period;
		} catch (NotFoundException e) {
			return period;
		} catch (Exception e) {
			// LOG.log(Level.SEVERE, "Failed to get report period", e);
			test.log(Status.FAIL, "Failed to get report period");
			return period;

		}
	}

	/**
	 * Get the Total Submitted Amount from the report table footer.
	 * This should equal the Business Overview Batch Total when bug is OFF.
	 * Bug-01 causes this to show gross sales instead of net (sales - refunds).
	 *
	 * @return the total submitted amount as a string
	 * @throws NotFoundException   if the totals row is not found
	 * @throws ValidationException if the amount cannot be parsed
	 */
	public String getTotalSubmittedAmount() {
		try {
			util.waitForVisibilityOfElement(driver, totalsRow);
			String totalText = totalsRow.getText().trim();
			// Parse the dollar amount from the text
			String amount = totalText.contains("$") ? totalText.substring(totalText.lastIndexOf("$")) : totalText;
			// LOG.fine("Total Submitted Amount: " + amount);
			return amount;
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to get total submitted amount: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Get the Total Submitted Amount as a numeric value (in cents).
	 * The app shows amounts in dollars like "$1,234.56"
	 *
	 * @return the amount in cents
	 * @throws ValidationException if the amount cannot be parsed
	 */
	public long getTotalSubmittedInCents() {
		long cents = 0;
		try {
			util.waitForVisibilityOfElement(driver, totalsRow);
			String amountText = totalsRow.getText().trim();
			// Find the dollar amount in the text
			int dollarIndex = amountText.lastIndexOf("$");
			if (dollarIndex >= 0) {
				amountText = amountText.substring(dollarIndex);
			}
			String cleaned = amountText.replace("$", "").replace(",", "").trim();
			cents = (long) (Double.parseDouble(cleaned) * 100);
			LOG.fine("Total Submitted in cents: " + cents);
			return cents;
		} catch (NumberFormatException e) {
			LOG.log(Level.SEVERE, "Failed to parse amount to cents: " + e.getMessage());
			test.log(Status.FAIL, "Failed to parse amount to cents: \" + e.getMessage()");
			return cents;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Failed to get total submitted in cents", e);
			test.log(Status.FAIL, "Failed to get total submitted in cents: " + e.getMessage());
			return cents;
		}
	}

	/**
	 * Set the report filter to By Month for a specific month and year.
	 *
	 * @param month the month number as string (e.g., "1" for January, "2" for
	 *              February)
	 * @param year  the year to filter by (e.g., "2026")
	 * @return this page instance for method chaining
	 * @throws ElementException if filter operation fails
	 */
	public void filterByMonth(String month, String year) {
		try {
			// Click the mode dropdown
			// filterByDropdown.click();
			util.selectDropdownByVisibleText(filterByDropdown, "By Month");

			// Select the month by value (1-12)
			// monthDropdown.click();
			util.selectDropdownByVisibleText(monthDropdown, month);

			// Select the year
			// yearDropdown.click();
			util.selectDropdownByVisibleText(yearDropdown, year);

			// Apply the filter

			filter.click();

			// Wait for table to refresh
			util.waitForVisibilityOfElement(driver, totalsRow);
			// LOG.fine("Filtered Totals Summary by month: " + month + ", year: " + year);

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to filter Totals Summary by month/year");
			// throw new Exception("Failed to filter mont '"+month+ "' and year '" + year +
			// "': " + e.getMessage(),e);
		}
	}

	public boolean filterByMonth() {
		util.waitForVisibilityOfElement(driver, filterByDropdown);
		util.selectDropdownByValue(filterByDropdown, "month");
		boolean result = false;

		util.waitForVisibilityOfElement(driver, monthDropdown);
		util.waitForVisibilityOfElement(driver, yearDropdown);

		boolean filterChang = monthDropdown.isDisplayed() && yearDropdown.isDisplayed();

		if (filterChang) {

			int size = util.getMonthList().size();
			for (int i = 1; i < size; i++) {
				if (i <= util.getIntCurrentMonthNum()) {
					util.selectDropdownByValue(monthDropdown, i + "");

					util.selectDropdownByValue(yearDropdown, util.getCurrentYear());

					clickOnFilterButton();
					boolean con1 = util.getSelectedOption(driver, filterByDropdown).getText().contains("Month");
					boolean con2 = util.getMonthList().get(i)
							.contains(util.getSelectedOption(driver, monthDropdown).getText());
					boolean con3 = util.getSelectedOption(driver, yearDropdown).getText()
							.equalsIgnoreCase(util.getCurrentYear());

					if (con1 & con2 & con3) {
						// test.log(Status.PASS, "'By Month' Filter applied successfully");
						result = true;
					} else {
						result = false;
						test.log(Status.FAIL, "Failed to apply filter");
					}
				}
				if (i > util.getIntCurrentMonthNum()) {
					util.selectDropdownByValue(monthDropdown, i + "");
					util.selectDropdownByValue(yearDropdown, util.getPrevYear());

					clickOnFilterButton();

					boolean con1 = util.getSelectedOption(driver, filterByDropdown).getText().contains("Month");
					boolean con2 = util.getMonthList().get(i)
							.contains(util.getSelectedOption(driver, monthDropdown).getText());
					boolean con3 = util.getSelectedOption(driver, yearDropdown).getText()
							.equalsIgnoreCase(util.getPrevYear());

					if (con1 & con2 & con3) {
						// test.log(Status.PASS, "'By Month' Filter applied successfully");
						result = true;
					} else {
						result = false;
						test.log(Status.FAIL, "Failed to apply filter");
					}
				}
			}

		} else {
			test.log(Status.FAIL, "Failed to change the filter for 'By Month' options");
			return false;
		}
		return result;
	}

	/**
	 * Selects a date from the calendar input field.
	 * 
	 * @param dateField The WebElement representing the date input field.
	 * @param month     The month value (e.g., "02" for February).
	 * @param dom       The day of the month value (e.g., "15" for 15th).
	 * @param year      The year value (e.g., "2023").
	 * @return The selected date as a string in the format "MM/DD/YYYY".
	 */
	public String selectDateFromTheCalenderInputField(WebElement dateField, String month, String dom, String year) {
		dateField.click();

		String searchDate = month + "/" + dom + "/" + year;

		Actions a = util.getActionObject(driver);

		while (true) {
			a.keyDown(dateField, Keys.BACK_SPACE).build().perform();
			if (dateField.getAttribute("value").equals("")) {
				a.keyUp(dateField, Keys.BACK_SPACE).build().perform();
				break;
			}
		}
		a.sendKeys(dateField, searchDate).perform();
		a.sendKeys(dateField, Keys.ENTER).perform();

		return dateField.getAttribute("Value");
	}

	/**
	 * Selects a date from the calendar popup.
	 * 
	 * @param dateField The WebElement representing the date input field.
	 * @param month     The numeric value of the month (1-12).
	 * @param dom       The day of the month (1-31).
	 * @param year      The year value (e.g., 2023).
	 * @return The selected date as a string in the format "MM/DD/YYYY".
	 */
	public String selectDateFromTheCalender(WebElement dateField, int month, int dom, int year) {
		String monthName = util.getMonthName(month);
		// month = util.getIntCurrentMonthNum();
		String expectedCalenderHeader = monthName + " " + year;
		String monthNum = month + "";

		String dayOfMonth = util.getCurrentDayOfMonth();
		if (dom < 10) {
			dayOfMonth = "0" + dom;
		}
		if (month < 10) {
			monthNum = "0" + month;
		}

		String searchDate = monthNum + "/" + dayOfMonth + "/" + year;
		dateField.click();

		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			util.waitForVisibilityOfElement(driver, previousMonth);
			previousMonth.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			if (calenderCurrentMonth.getText().equalsIgnoreCase(expectedCalenderHeader)) {
				break;
			}
		}
		selectDate(monthName, dom + "", year + "");
		String selectedDate = dateField.getAttribute("value");

		if (!(searchDate.equals(selectedDate))) {
			test.log(Status.FAIL, "Failed to select the date using calender");
		}
		return selectedDate;
	}

	/**
	 * Selects the current date from the calendar popup.
	 * 
	 * @param dateField The WebElement representing the date input field.
	 * @return The selected date as a string in the format "MM/DD/YYYY".
	 */
	public String selectCurrentDateFromTheCalender(WebElement dateField) {
		int month = util.getIntCurrentMonthNum();
		int dom = util.getIntCurrentDayOfMonth();
		String year = util.getCurrentYear();

		String monthNum = month + "";

		String dayOfMonth = util.getCurrentDayOfMonth();
		if (dom < 10) {
			dayOfMonth = "0" + dom;
		}

		if (!(month <= 10)) {
			monthNum = "0" + month;
		}

		return selectDateFromTheCalenderInputField(dateField, monthNum, dayOfMonth, year);

	}

	/**
	 * checks the Clear Filter button functionality
	 */
	public void clickOnFilter() {
		util.waitForVisibilityOfElement(driver, filterButton);
		clickOnFilterButton();
	}

	/**
	 * Applies the 'By Day' filter by selecting a date from the calendar or entering
	 * it manually.
	 * 
	 * @param e The WebElement representing the filter dropdown.
	 * @return true if the 'By Day' filter is successfully applied, false otherwise.
	 */
	public boolean filterByDay(WebElement e) {
		util.waitForVisibilityOfElement(driver, e);
		util.selectDropdownByVisibleText(e, "By Day");
		boolean result1 = false;
		boolean result2 = false;
		boolean result = false;

		util.waitForVisibilityOfElement(driver, dateField);
		boolean filterChang = dateField.isDisplayed();

		if (filterChang) {
			String searchDate = selectDateFromTheCalenderInputField(dateField, "1", util.getCurrentDayOfMonth(),
					util.getCurrentYear());

			clickOnFilterButton();

			boolean con1 = util.getSelectedOption(driver, e).getText().equalsIgnoreCase("By Day");
			boolean con2 = dateField.getAttribute("Value").equalsIgnoreCase(searchDate);

			if (con1 & con2) {
				// test.log(Status.PASS, "'By Day' Filter applied successfully by entering date
				// in 'Date' input field");

				result1 = true;
			} else {
				result1 = false;
				test.log(Status.FAIL, "Failed to apply 'By day' filter by entering date in 'Date' input field");
			}

			selectCurrentDateFromTheCalender(dateField);

			int prevMonth = util.getIntPrevMonth();
			int year = util.getIntCurrentYear();
			if (prevMonth == 12) {
				year = util.getIntPrevYear();
			}

			String selectedDate = selectDateFromTheCalender(dateField, prevMonth, util.getIntCurrentDayOfMonth(), year);

			clickOnFilter();

			con1 = util.getSelectedOption(driver, e).getText().equalsIgnoreCase("By Day");
			con2 = dateField.getAttribute("Value").equalsIgnoreCase(selectedDate);

			if (con1 & con2) {
				// test.log(Status.PASS, "Filter 'By Day' applied successfully using calender
				// ");
				result2 = true;
			} else {
				result2 = false;
				test.log(Status.FAIL, "Failed to apply filter 'By Day' using calender");
			}

			result = result1 & result2;
			if (!result) {
				return false;
			}

		} else {
			test.log(Status.FAIL, "Failed to change the filter options to By Date");
			return false;

		}
		return result;

	}

	/**
	 * Selects a specific date on the calendar popup based on the month name, day of
	 * month, and year.
	 * 
	 * @param monthName The name of the month (e.g., "June", "July").
	 * @param dom       The day of the month as a string (e.g., "15", "28").
	 * @param year      The year as a string (e.g., "2023", "2024").
	 */
	public void selectDate(String monthName, String dom, String year) {
		WebElement dateSelect = driver.findElement(By.xpath("//div[ contains(@aria-label , '" + monthName + " " + dom
				+ "') and contains(@aria-label ,'" + year + "')]"));
		util.waitForVisibilityOfElement(driver, dateSelect);
		dateSelect.click();

	}

	/**
	 * Applies the 'By Date Range' filter option by selecting a date range from
	 * 'fromDate' to 'toDate'.
	 * 
	 * @param e     The WebElement representing the filter dropdown.
	 * @param value The value to select from the filter dropdown (e.g.,
	 *              "dateRange").
	 * @return true if the 'By Date Range' filter is successfully applied; false
	 *         otherwise.
	 */
	public boolean filterByDateRange(WebElement e, String value) {

		util.waitForVisibilityOfElement(driver, e);
		// util.selectDropdownByVisibleText(e, "By Date Range");
		util.selectDropdownByValue(e, value);
		boolean result = false;

		boolean filterChang = fromDate.isDisplayed() && toDate.isDisplayed();

		if (filterChang) {

			fromDate.click();

			int prevMonth = util.getIntPrevMonth();
			int year = util.getIntCurrentYear();
			if (prevMonth == 12) {
				year = util.getIntPrevYear();
			}

			String selectedFromDate = selectDateFromTheCalender(fromDate, prevMonth, util.getIntCurrentDayOfMonth(),
					year);

			toDate.click();

			String selectedToDate = selectCurrentDateFromTheCalender(toDate);

			clickOnFilter();

			boolean con1 = util.getSelectedOption(driver, e).getText().contains("Date Range");

			boolean con2 = fromDate.getAttribute("Value").equalsIgnoreCase(selectedFromDate);

			boolean con3 = toDate.getAttribute("Value").equalsIgnoreCase(selectedToDate);

			if (con1 & con2 & con3) {
				// test.log(Status.PASS, "Filter '" + util.getSelectedOption(e).getText() + "'
				// applied successfully");
				util.addBase64ScreenShotToReport(driver, test, "Filter by Date Range");

				result = true;
			} else {
				result = false;
				test.log(Status.FAIL, "Failed to apply filter 'By Date Range'");
			}

		} else {
			test.log(Status.FAIL, "Failed to change the filter options to 'By Date range' Option");
			return false;
		}

		return result;
	}

	/**
	 * clicks on Totals summary report, checks the Filter 'By Month' and 'By Day'
	 * dropdown functionality
	 * 
	 * @return false if the filter By functionality is not working
	 */
	public void navigateTo_TotalsSummaryReport() {
		try {
			home.clickOnReports();
			util.waitForVisibilityOfAllElements(driver, viewReportBtns);
			util.waitForVisibilityOfElement(driver, totalsSummaryReport);
			totalsSummaryReport.click();
			util.waitForVisibilityOfElement(driver,
					driver.findElement(By.xpath("//h5[text()='Totals Summary Report']")));
		} catch (Exception e) {
			System.out.println("failed to navigate to total summary report");
			test.log(Status.FAIL, "failed to navigate to total summary report");
			e.printStackTrace();
		}

	}

	/**
	 * Verifies the ACH report by navigating to the Reports section, clicking on the
	 * ACH Deposit report, and validating the input fields.
	 * 
	 * @return true if input field validation is successful, false otherwise
	 */
	public boolean verifyACHReport() {

		boolean result = false;
		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		ACHDeposit.click();

		boolean inputFieldValidation = verifyAmountInputField() & verifyTraceNumberInputField();

		if (inputFieldValidation) {
			// test.log(Status.PASS, "ACH report input field verification successful");
			clickOnClearFilterButton();
			result = true;
		} else {
			test.log(Status.FAIL, "ACH report input field verification Failed");
			clickOnClearFilterButton();
			return false;
		}

		return result;

	}

	/**
	 * Verifies the functionality of the Amount input field: 1. Enters an invalid
	 * amount (0.001) and checks if the field highlights in red. 2. Clears the field
	 * and enters a valid amount (0.01), verifies if it accepts the input after
	 * clicking on Filter. 3. Clears the field and enters a negative amount (-0.01),
	 * verifies if it accepts the negative input after clicking on Filter.
	 * 
	 * @return true if all validations pass, false otherwise
	 */
	public boolean verifyAmountInputField() {
		boolean result = false;
		util.waitForVisibilityOfElement(driver, amount);
		try {
			if (amount.isDisplayed()) {
				amount.sendKeys("0.001");
				if (amount.getAttribute("style").contains("solid red")) {
					test.log(Status.PASS, "Amount input field is highlighted in red color for invalid amount input  ");
				} else {
					test.log(Status.FAIL, "Amount input field identify invalid input the input");
				}
				util.waitForVisibilityOfElement(driver, amount);
				amount.clear();
				amount.sendKeys("0.01");
				clickOnFilter();

				if (amount.getAttribute("value").equals("0.01")) {
					result = true;
				} else {
					test.log(Status.FAIL, "Amount input field is not accepting the input");
					return false;
				}
				amount.clear();
				amount.sendKeys("-0.01");
				clickOnFilter();

				if (amount.getAttribute("value").equals("-0.01")) {
					result = true;
				} else {
					test.log(Status.FAIL, "Amount input field is not accepting the negative input");
					return false;
				}

			} else {
				test.log(Status.FAIL, "Amount input field is not visible");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Amount input field validation Failed");
			return false;
		}
		return result;
	}

	/**
	 * Verifies the functionality of the Trace Number input field: 1. Enters a valid
	 * trace number (000000000012345) and verifies if it accepts the input after
	 * clicking Filter. 2. Enters an invalid trace number (0000000000123451234) and
	 * verifies if it does not accept the input after clicking Filter. 3. Clears the
	 * trace number field and verifies if it clears the data after clicking Filter.
	 * 
	 * @return true if all validations pass, false otherwise
	 */
	public boolean verifyTraceNumberInputField() {
		boolean result = false;
		util.waitForVisibilityOfElement(driver, traceNum);
		try {
			if (traceNum.isDisplayed()) {
				traceNum.clear();
				// 15 digits
				traceNum.sendKeys("000000000012345");
				clickOnFilter();

				if (traceNum.getAttribute("value").equals("000000000012345")) {
					result = true;

				} else {
					test.log(Status.FAIL, "TraceNumber input field failed to accept the input");
					result = false;
				}

				traceNum.clear();
				traceNum.sendKeys("0000000000123451234");
				clickOnFilter();
				if (traceNum.getAttribute("value").equals("0000000000123451234")) {
					test.log(Status.FAIL, "TraceNumber input field Accepts invalid input");
					util.addBase64ScreenShotToReport(traceNum, test, "TraceNumber input field with invalid input");
					return false;

				}

				traceNum.clear();
				clickOnFilter();

				if (traceNum.getAttribute("value").equals("")) {
					result = true;
				} else {
					test.log(Status.FAIL, "TraceNumber input field failed to clear the data");
					result = false;
				}

			} else {
				test.log(Status.FAIL, "TraceNumber input field is not visible");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "TraceNumber input field validation Failed");
			return false;
		}
		return result;

	}

	/**
	 * Verifies the Merchant Statement report functionality by applying filters for
	 * different months: 1. Selects the current month with the current year and
	 * verifies the filter application. 2. Selects the current month with the
	 * previous year and verifies the filter application. 3. Iterates over all
	 * months up to the current month of the current year and previous year, selects
	 * each month, and verifies the filter application.
	 * 
	 * @return true if all filter verifications pass, false otherwise
	 */

	public boolean verifyMerchantStatementReport() {
		boolean result = false;

		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		merchantStatement.click();

		int size = util.getMonthList().size();
		for (int i = 0; i < size; i++) {

			if (i == 0) {
				util.selectDropdownByValue(monthDropdown, i + "");

				util.selectDropdownByValue(yearDropdown, util.getCurrentYear());
				clickOnFilterButton();

				boolean con1 = util.getSelectedOption(driver, monthDropdown).getText().equals("Select Month");
				boolean con2 = util.getSelectedOption(driver, yearDropdown).getText()
						.equalsIgnoreCase(util.getCurrentYear());

				if (con1 & con2) {
					// test.log(Status.PASS, "'By Month' Filter applied successfully");

					util.addBase64ScreenShotToReport(driver, test, "Merchant Statement Report");
					result = true;
				} else {
					result = false;
					test.log(Status.FAIL, "Failed to apply filter");
				}

			}
			// if (i == 0) {
			// util.selectDropdownByValue(monthDropdown, i + "");
			// util.selectDropdownByValue(yearDropdown, util.getPrevYear());
			// clickOnFilterButton();
			//
			// boolean con1 =
			// util.getSelectedOption(driver,monthDropdown).getText().equals("Select
			// Month");
			// boolean con2 =
			// util.getSelectedOption(driver,yearDropdown).getText().equalsIgnoreCase(util.getPrevYear());
			//
			// if (con1 & con2) {
			// // test.log(Status.PASS, "'By Month' Filter applied successfully");
			// result = true;
			// } else {
			// result = false;
			// test.log(Status.FAIL, "Failed to apply filter");
			// }
			//
			// }

			if (i <= util.getIntCurrentMonthNum() & (i != 0)) {

				util.selectDropdownByValue(monthDropdown, i + "");

				util.selectDropdownByValue(yearDropdown, util.getCurrentYear());

				clickOnFilterButton();

				boolean con1 = util.getMonthList().get(i)
						.contains(util.getSelectedOption(driver, monthDropdown).getText());
				boolean con2 = util.getSelectedOption(driver, yearDropdown).getText()
						.equalsIgnoreCase(util.getCurrentYear());

				if (con1 & con2) {
					// test.log(Status.PASS, "'By Month' Filter applied successfully");
					result = true;
				} else {
					result = false;
					test.log(Status.FAIL, "Failed to apply filter");
				}
			}
			if (i > util.getIntCurrentMonthNum()) {
				util.selectDropdownByValue(monthDropdown, i + "");
				util.selectDropdownByValue(yearDropdown, util.getPrevYear());

				clickOnFilterButton();

				boolean con1 = util.getMonthList().get(i)
						.contains(util.getSelectedOption(driver, monthDropdown).getText());
				boolean con2 = util.getSelectedOption(driver, yearDropdown).getText()
						.equalsIgnoreCase(util.getPrevYear());

				if (con1 & con2) {
					// test.log(Status.PASS, "'By Month' Filter applied successfully");
					result = true;
				} else {
					result = false;
					test.log(Status.FAIL, "Failed to apply filter");
				}
			}

		}

		if (result) {
			test.log(Status.PASS, "Merchant Statement report verification successful");
			return true;
		} else {
			test.log(Status.FAIL, "Merchant Statement report verification failed");
			return false;
		}

	}

	/**
	 * Verifies the Settled Batches report functionality by iterating through
	 * different date types: 1. Selects each date type option from the dropdown and
	 * verifies the 'By Month' filter. 2. Selects each date type option from the
	 * dropdown and verifies the 'By Day' filter. 3. Selects each date type option
	 * from the dropdown and verifies the 'By Date Range' filter.
	 * 
	 * @return true if all date type verifications pass, false otherwise
	 */
	public boolean verifySettledBatchesReport() {
		boolean result = false;

		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		settledBatches.click();

		util.waitForVisibilityOfElement(driver, dateTypeDropdown);

		int size = util.getAllOption(dateTypeDropdown).size();

		util.selectDropdownByValue(dateTypeDropdown, "batchDate");

		if (util.getSelectedOption(driver, dateTypeDropdown).getText().equals("Batch Date")) {

			boolean con1 = verifyFilterByMonthBatch();

			// util.addBase64ScreenShotToReport(driver, test, "Filter by Month");
			clickOnClearFilterButton();
			util.selectDropdownByValue(dateTypeDropdown, "batchDate");

			boolean con2 = verifyFilterByDay();
			// util.addBase64ScreenShotToReport(driver, test, "Filter by Day");
			clickOnClearFilterButton();

			util.selectDropdownByValue(dateTypeDropdown, "batchDate");

			boolean con3 = VerifyFilterByDateRange("dateRange");

			// util.addBase64ScreenShotToReport(driver, test, "Filter by Date Range");

			if (con1 & con2 & con3) {
				result = true;
				test.log(Status.PASS, "Date Type : '" + util.getSelectedOption(driver, dateTypeDropdown).getText()
						+ "' verification successful");
			} else {
				test.log(Status.FAIL,
						"Date Type : '" + util.getSelectedOption(driver, dateTypeDropdown).getText()
								+ "' verification Failed");
				return false;
			}
		}

		if (result) {
			test.log(Status.PASS, "Settled Batches report verification successful");
		} else {
			test.log(Status.FAIL, "Settled Batches report verification Failed");
		}

		return result;
	}

	/**
	 * Verifies the Chargebacks Report functionality by selecting each year from the
	 * dropdown and checking if the year dropdown reflects the selected year.
	 * 
	 * @return true if all year dropdown verifications pass, false otherwise
	 */
	public boolean verifyChargebacksReport() {
		boolean result = false;

		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		chargebacksReport.click();

		util.waitForVisibilityOfElement(driver, yearDropdown);

		for (int i = util.getIntCurrentYear(); i >= util.getIntPrevYear(); i--) {
			util.waitForVisibilityOfElement(driver, yearDropdown);
			util.selectDropdownByValue(yearDropdown, "" + i);
			clickOnFilterButton();
			// System.out.println(yearDropdown.getAttribute("value") + " and " + i);
			if (yearDropdown.getAttribute("value").equals(i + "")) {
				// test.log(Status.PASS, "year dropdown verification successful");
				result = true;
			} else {
				test.log(Status.FAIL, "'year' dropdown verification Failed");
				result = false;
			}

			if (result == false) {
				return false;
			}
		}
		if (result == true) {
			test.log(Status.PASS, "Chargebacks Report verification successful");
			return result;
		} else {
			test.log(Status.FAIL, "Chargebacks Report verification failed");
			return result;
		}
	}

	/**
	 * Verifies functionality of the 'last4digitsOfCard' input field: - Enters valid
	 * input and verifies acceptance. - Clears the input field and verifies it is
	 * cleared. - Enters invalid input (more than 4 digits) and verifies
	 * highlighting in red. - Verifies the display of 'Please enter Valid Input'
	 * message.
	 * 
	 * @return true if all verifications pass successfully; false otherwise.
	 */

	public boolean verifyLast4digitOfCards() {
		boolean result = false;
		try {
			util.waitForVisibilityOfElement(driver, last4digitsOfCard);

			if (last4digitsOfCard.isDisplayed()) {
				String input = "1234";
				last4digitsOfCard.sendKeys(input);

				clickOnFilter();

				// System.out.println(last4digitsOfCard.getAttribute("value"));
				if (last4digitsOfCard.getAttribute("Value").equalsIgnoreCase(input)) {
					// test.log(Status.PASS, "last4digitsOfCard input field accepts the input");
					result = true;
				} else {
					test.log(Status.FAIL, "'last4digitsOfCard' input field failed to accepts the input");
					util.addBase64ScreenShotToReport(driver, test);
					return false;
				}

				last4digitsOfCard.clear();

				clickOnFilter();

				if (last4digitsOfCard.getAttribute("Value").equals("")) {
					// test.log(Status.PASS, "last4digitsOfCard input field cleared");
					result = true;
				} else {
					test.log(Status.FAIL, "'last4digitsOfCard' input failed to clear");
					return false;
				}

				last4digitsOfCard.sendKeys("123456");

				if (last4digitsOfCard.getAttribute("style").contains("red")) {
					result = true;
				} else {
					test.log(Status.FAIL,
							"'last4digitsOfCard' input field failed to highligt in red when entered more than 4 characters ");
					util.addBase64ScreenShotToReport(driver, test);
					return false;
				}
				clickOnFilter();
				clickOnFilter();
				util.waitForVisibilityOfElement(driver, pleaseEnterValidInputMsg);
				if (pleaseEnterValidInputMsg.isDisplayed()) {
					result = true;
				}
			} else {
				test.log(Status.FAIL, "'Please enter Valid Input' message is not displayed");
				util.addBase64ScreenShotToReport(driver, test);
				return false;
			}

		} catch (

		Exception e) {
			test.log(Status.FAIL, "last4digitsOfCard input field validation Failed");
			util.takeScreenShotOnFailuer(driver, test);
			return false;
		}
		return result;

	}

	/**
	 * Verifies the functionality of searching transactions: - Applies filters by
	 * month and year, verifying successful application. - Applies filters by
	 * transaction type and verifies successful selection. - Validates input fields
	 * for amount and last 4 digits of cards.
	 * 
	 * @return true if all verification steps pass successfully; false otherwise.
	 */
	public boolean verifySearchTransaction() {
		boolean result = false;

		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		searchTransactions.click();

		int size = util.getMonthList().size();
		for (int i = 0; i < size; i++) {

			if (i <= util.getIntCurrentMonthNum()) {

				util.selectDropdownByValue(monthDropdown, Integer.toString(i));

				util.selectDropdownByValue(yearDropdown, util.getCurrentYear());

				clickOnFilterButton();

				boolean con1 = util.getMonthList().get(i)
						.contains(util.getSelectedOption(driver, monthDropdown).getText());
				boolean con2 = util.getSelectedOption(driver, yearDropdown).getText()
						.equalsIgnoreCase(util.getCurrentYear());

				if (con1 & con2) {
					// test.log(Status.PASS, "'By Month' Filter applied successfully");
					result = true;
				} else {
					result = false;
					test.log(Status.FAIL, "Failed to apply filter for month: '" + util.getMonthList().get(i) + "'.");
					continue;
				}
			}

			if (i > util.getIntCurrentMonthNum()) {

				util.selectDropdownByValue(monthDropdown, i + "");
				util.selectDropdownByValue(yearDropdown, util.getPrevYear());

				clickOnFilterButton();

				boolean con1 = util.getMonthList().get(i)
						.contains(util.getSelectedOption(driver, monthDropdown).getText());
				boolean con2 = util.getSelectedOption(driver, yearDropdown).getText()
						.equalsIgnoreCase(util.getPrevYear());

				if (con1 & con2) {
					// test.log(Status.PASS, "'By Month' Filter applied successfully");
					result = true;
				} else {
					result = false;
					test.log(Status.FAIL, "Failed to apply filter for month: '" + util.getMonthList().get(i) + "'.");
					continue;
				}
			}

		}

		if (result) {

			util.addBase64ScreenShotToReport(driver, test, "SearchTransaction");

			test.log(Status.PASS, "'By Month' Filter applied successfully");

		} else {
			test.log(Status.FAIL, "Failed to apply 'By Month' Filter");
			util.addBase64ScreenShotToReport(driver, test);
		}

		clickOnClearFilterButton();

		int dropdownSize = util.getSelectOptions(transTypeDropdown).size();
		for (int i = 0; i < dropdownSize; i++) {

			util.selectDropdownByIndex(transTypeDropdown, i);
			String selectedOption = util.getSelectedOption(driver, transTypeDropdown).getText();
			clickOnFilter();
			util.waitForVisibilityOfElement(driver, transTypeDropdown);
			if (util.getSelectedOption(driver, transTypeDropdown).getText().equalsIgnoreCase(selectedOption)) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		if (result) {
			test.log(Status.PASS, "'Trans Type' Filter applied successfully");
		} else {
			util.addBase64ScreenShotToReport(driver, test);
			test.log(Status.FAIL, "Failed to apply 'Trans Type' Filter");
		}

		boolean inputFieldValidation = verifyAmountInputField() & verifyLast4digitOfCards();

		if (!(inputFieldValidation)) {
			result = false;
			test.log(Status.FAIL, "Search Transaction Report Input Field verification failed");
		} else {
			test.log(Status.PASS, "Search Transaction Report Input Field verification successful");
		}

		return result;
	}

	/**
	 * Verifies the functionality of Daily Discount Calculator report: - Navigates
	 * to Reports and opens Daily Discount Calculator. - Verifies filters by month
	 * and date range. - Checks if download options for PDF and Excel are enabled.
	 * 
	 * @return true if all verification steps pass successfully; false otherwise.
	 */
	public boolean verifyDailyDiscountCalculator() {

		boolean result = false;
		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		try {
			if (dailyDiscountCalculator.isDisplayed()) {
				test.log(Status.INFO, "Daily DiscountCalculator card displayed");

				util.moveToELement(driver, virwDailyDiscountCalculator);
				virwDailyDiscountCalculator.click();

				// boolean inputFieldValidation = verifyAmountInputField() &
				// verifyTraceNumberInputField();

				boolean con1 = verifyFilterByMonth();
				clickOnClearFilterButton();

				boolean con2 = VerifyFilterByDateRange("dateRange");

				if (con1 & con2 & isDownloadPDFEnabled() & isDownloadExcelEnabled()) {
					test.log(Status.PASS, "Daily DiscountCalculator verification successful");
					result = true;
				} else {
					test.log(Status.FAIL, "Daily DiscountCalculator verification Failed");
					return false;
				}

				return result;
			} else {
				test.log(Status.FAIL, "Daily DiscountCalculator Report not available");
				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.INFO, "Daily DiscountCalculator card not available");
			return true;
		}
	}

	/**
	 * Verifies if the 'Download PDF' button is enabled.
	 * 
	 * @return true if the 'Download PDF' button is enabled; false otherwise.
	 */
	public boolean isDownloadPDFEnabled() {
		try {
			util.waitForVisibilityOfElement(driver, downloadPDFButton);
			if (downloadPDFButton.isEnabled()) {
				// test.log(Status.PASS, " Download PDF is Enabled");

				return true;
			} else {
				test.log(Status.FAIL, "Download PDF is not Enabled");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Download PDF button");
			return false;
		}
	}

	/**
	 * Verifies if the 'Download Excel' button is enabled.
	 * 
	 * @return true if the 'Download Excel' button is enabled; false otherwise.
	 */
	public boolean isDownloadExcelEnabled() {
		try {
			util.waitForVisibilityOfElement(driver, downloadExcelButton);
			if (downloadExcelButton.isEnabled()) {
				// test.log(Status.PASS, " Download Excel is Enabled");
				return true;
			} else {
				test.log(Status.FAIL, "Download Excel is not Enabled");
				return false;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to verify Download Excel button");
			return false;
		}
	}

	/**
	 * Checks if a Excel file with the specified fileName is downloaded. Deletes the
	 * downloaded file if found.
	 * 
	 * @param fileName The name of the PDF file to check.
	 * @return true if the Excel file with the specified fileName is downloaded and
	 *         deleted successfully; false otherwise.
	 */
	public boolean isCsvDownloaded(String fileName) {
		File dir = new File(System.getProperty("user.dir") + "/Downloads/");
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			// if (dirContents[i].getName().matches(fileName+" -
			// \\d{4}-\\d{2}-\\d{2}T\\d{2}_\\d{2}_\\d{2}\\.csv")) {
			if ((dirContents[i].getName().contains(fileName)) & (dirContents[i].getName().endsWith(".csv"))) {

				// File has been found, it can now be deleted:
				dirContents[i].delete();

				return true;
			}
		}
		test.log(Status.FAIL, "Failed to Download CSV file");
		return false;
	}

	/**
	 * Clicks on the Download PDF button after waiting for its visibility.
	 */
	public void clickOnDownloadPdfBtn() {
		try {
			util.waitForVisibilityOfElement(driver, downloadPDFButton);
			downloadPDFButton.click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to click in 'Download PDF' Button");
		}
	}

	/**
	 * Clicks on the Download Excel button after waiting for its visibility.
	 */
	public void clickOnDownloadExcelBtn() {
		try {
			util.waitForVisibilityOfElement(driver, downloadExcelButton);
			downloadExcelButton.click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to click in 'Download Excel' Button");
		}
	}

	/**
	 * Verifies the functionality of downloading a PDF report based on the
	 * availability of records and download status. If no records are available,
	 * checks if the appropriate pop-up is displayed when attempting to download. If
	 * records are available, checks if the download process initiates and completes
	 * successfully.
	 *
	 * @param reportName The name of the report to be downloaded.
	 * @return True if the PDF download functionality behaves as expected, otherwise
	 *         false.
	 */
	public boolean verifyDownloadPdfFunctionality(String reportName) {

		if (reportName.equals("Search_Transaction")) {
			try {

				util.waitForVisibilityOfElementWithWait(driver, noRecordsAvailableMsg, 2);
				if (noRecordsAvailableMsg.isDisplayed()) {
					clickOnDownloadPdfBtn();
					util.waitForVisibilityOfElement(driver, NoDataAvailablePopup);
					if (NoDataAvailablePopup.isDisplayed()) {
						test.log(Status.PASS,
								"When records are not available, selection of 'Download Pdf' button shows : '"
										+ NoDataAvailablePopup.getText() + "'.");
						closeNotification.click();
						return true;
					} else {
						test.log(Status.FAIL, "failed to show : No data available Pop_up");
						return false;
					}
				}

			} catch (Exception e) {
				util.waitForVisibilityOfElement(driver, downloadIsProcessing);

				if (downloadIsProcessing.isDisplayed()) {
					test.log(Status.PASS,
							"Popup messgae displayed: 'Your download is processing, will notify you once it is completed'");

					return true;
				} else {
					test.log(Status.PASS, "'Your download is processing' Popup messg not displayed");
					return false;
				}
			}
		}

		try {

			util.waitForVisibilityOfElementWithWait(driver, noRecordsAvailableMsg, 2);
			if (noRecordsAvailableMsg.isDisplayed()) {
				clickOnDownloadPdfBtn();
				util.waitForVisibilityOfElement(driver, NoDataAvailablePopup);
				if (NoDataAvailablePopup.isDisplayed()) {
					test.log(Status.PASS, "When records are not available, selection of 'Download Pdf' button shows : '"
							+ NoDataAvailablePopup.getText() + "'.");
					closeNotification.click();
					return true;
				} else {
					test.log(Status.FAIL, "failed to show : No data available Pop_up");
					return false;
				}
			}

		} catch (Exception e) {

			try {
				clickOnDownloadPdfBtn();

				util.waitForVisibilityOfElementWithWait(driver, downloadIsProcessing, 5);

				if (downloadIsProcessing.isDisplayed()) {
					test.log(Status.PASS,
							"'Your download is processing, will notify you once it is completed' popup is displayed");
					closeNotification.click();
					return true;
				} else {
					return false;
				}

			} catch (Exception f) {

				if (isPdfDownloaded(reportName)) {
					test.log(Status.PASS, "PDF File Downloaded Successfully");
					return true;
				} else {

					test.log(Status.FAIL, "Failed to Download PDF file");
					return false;
				}
			}
		}
		test.log(Status.FAIL, "Download pdf verification Failed");
		return false;
	}

	/**
	 * Verifies the functionality of downloading an Excel report based on the
	 * availability of records and download status. If no records are available,
	 * checks if the appropriate pop-up is displayed when attempting to download. If
	 * records are available, checks if the download process initiates and completes
	 * successfully.
	 *
	 * @param reportName The name of the report to be downloaded.
	 * @return True if the Excel download functionality behaves as expected,
	 *         otherwise false.
	 */
	public boolean verifyDownloadExcelFunctionality(String reportName) {
		if (reportName.equals("Search_Transaction")) {
			try {

				util.waitForVisibilityOfElementWithWait(driver, noRecordsAvailableMsg, 2);
				if (noRecordsAvailableMsg.isDisplayed()) {
					clickOnDownloadExcelBtn();
					util.waitForVisibilityOfElement(driver, NoDataAvailablePopup);
					if (NoDataAvailablePopup.isDisplayed()) {
						test.log(Status.PASS,
								"When records are not available, selection of 'Download Excel' button shows : '"
										+ NoDataAvailablePopup.getText() + "'.");
						closeNotification.click();
						return true;
					} else {
						test.log(Status.FAIL, "failed to show : No data available Pop_up");
						return false;
					}
				}

			} catch (Exception e) {
				util.waitForVisibilityOfElement(driver, downloadIsProcessing);

				if (downloadIsProcessing.isDisplayed()) {
					test.log(Status.PASS,
							"Popup messgae displayed: 'Your download is processing, will notify you once it is completed'");

					return true;
				} else {
					test.log(Status.PASS, "'Your download is processing' Popup message is not displayed");
					return false;
				}
			}
		}
		try {
			if (noRecordsAvailableMsg.isDisplayed()) {
				clickOnDownloadExcelBtn();
				util.waitForVisibilityOfElement(driver, NoDataAvailablePopup);
				if (NoDataAvailablePopup.isDisplayed()) {
					test.log(Status.PASS,
							"When records are not available, selection of 'Download Excel' button shows : '"
									+ NoDataAvailablePopup.getText() + "'.");
					util.waitForInvisibilityOfElement(driver, NoDataAvailablePopup);
					return true;
				} else {
					test.log(Status.FAIL, "failed to show : No data available Pop_up");
					return false;
				}
			}
		} catch (Exception e) {
			try {
				clickOnDownloadExcelBtn();

				util.waitForVisibilityOfElementWithWait(driver, downloadIsProcessing, 3);
				if (downloadIsProcessing.isDisplayed()) {
					test.log(Status.PASS,
							"'Your download is processing, will notify you once it is completed' popup is displayed");
					return true;
				} else {
					return false;
				}

			} catch (Exception f) {

				if (isCsvDownloaded(reportName)) {
					test.log(Status.PASS, "Excel File Downloaded Successfully");
					return true;
				} else {

					test.log(Status.FAIL, "Failed to Download Excel file");
					return false;
				}

			}

		}
		test.log(Status.FAIL, "Download Excel verification Failed");
		return false;

	}

	/**
	 * Checks if a PDF file with the specified fileName is downloaded. Deletes the
	 * downloaded file if found.
	 * 
	 * @param fileName The name of the PDF file to check.
	 * @return true if the PDF file with the specified fileName is downloaded and
	 *         deleted successfully; false otherwise.
	 */
	public boolean isPdfDownloaded(String fileName) {
		File dir = new File(System.getProperty("user.dir") + "/Downloads/");
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			// if (dirContents[i].getName().matches(fileName+" -
			// \\d{4}-\\d{2}-\\d{2}T\\d{2}_\\d{2}_\\d{2}\\.pdf")) {
			if ((dirContents[i].getName().contains(fileName)) & (dirContents[i].getName().endsWith(".pdf"))) {

				// File has been found, it can now be deleted:

				for (File file : dirContents) {
					if (file.isFile()) {
						file.delete();
					}
				}

				// dirContents[i].delete();
				return true;
			}
		}
		test.log(Status.FAIL, "Failed to Download file");
		return false;
	}

	/**
	 * Verifies the functionality of the Daily Upload Report: - Navigates to Reports
	 * and opens Daily Upload Report. - Verifies filters by month and multiple date
	 * ranges.
	 * 
	 * @return true if all verification steps pass successfully; false otherwise.
	 */
	public boolean verifyDailyUploadReport() {
		boolean result = false;

		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		dailyUploadReport.click();

		boolean con1 = verifyFilterByMonth();
		clickOnClearFilterButton();

		boolean con2 = VerifyFilterByDateRange("dateRange");
		clickOnClearFilterButton();

		boolean con3 = VerifyFilterByDateRange("dateRange1");
		clickOnClearFilterButton();

		if (con1 & con2 & con3) {
			test.log(Status.PASS, "Daily UploadReport verification successful");
			result = true;
		} else {
			test.log(Status.FAIL, "Daily Upload Report verification Failed");
			return false;
		}
		return result;

	}

	/**
	 * Verifies the functionality of the PCD Live View Report:
	 * - Navigates to Reports and opens the PCD Live View Report.
	 * - Iterates through each type option in the dropdown and applies date range
	 * filters.
	 * - Verifies that the applied date range filters match the selected dates.
	 * 
	 * @return true if all verifications pass successfully; false otherwise.
	 */

	public boolean VerifyPCDLiveViewReport() {
		boolean result = false;

		home.clickOnReports();
		util.waitForVisibilityOfAllElements(driver, viewReportBtns);
		PCDLiveViewReport.click();

		int size = util.getSelectOptions(typeDropdown).size();

		for (int i = 0; i < size; i++) {
			util.selectDropdownByIndex(typeDropdown, i);

			fromDate.click();

			int prevMonth = util.getIntPrevMonth();
			int year = util.getIntCurrentYear();
			if (prevMonth == 12) {
				year = util.getIntPrevYear();
			}

			String selectedFromDate = selectDateFromTheCalender(fromDate, prevMonth, util.getIntCurrentDayOfMonth(),
					year);

			toDate.click();

			String selectedToDate = selectCurrentDateFromTheCalender(toDate);

			clickOnFilter();

			boolean con1 = fromDate.getAttribute("Value").equalsIgnoreCase(selectedFromDate);

			boolean con2 = toDate.getAttribute("Value").equalsIgnoreCase(selectedToDate);

			if (con1 & con2) {
				test.log(Status.PASS, "Filter '" + typeDropdown.getText() + "' applied successfully");
				result = true;
			} else {
				result = false;
				test.log(Status.FAIL, "Failed to apply filter 'By Date Range'");
			}
		}
		if (result) {
			test.log(Status.PASS, "PCD Live View report functionality successful");
			return true;
		} else {
			test.log(Status.FAIL, "PCD Live View report functionality failed");
			return false;
		}
	}

	public String getsalesItem() {
		try {
			int columnNumber = getIndexOfTableHeader("Sales Items");
			List<WebElement> footer = driver.findElements(By.xpath("//div[@class ='k-grid-footer']//td"));
			String salesItems = footer.get(columnNumber - 1).getText();

			return salesItems;

		}

		catch (Exception e) {
			return null;
		}
	}

	public String getsalesAmount() {
		try {
			int columnNumber = getIndexOfTableHeader("Total Submitted Amount");
			List<WebElement> footer = driver.findElements(By.xpath("//div[@class ='k-grid-footer']//td"));
			String salesAmount = footer.get(columnNumber - 1).getText();

			return salesAmount;

		}

		catch (Exception e) {
			return null;
		}
	}

	public String getDataFromReport(String date, String columnName) {
		try {
			String searchDate = null;
			String month = date.split("/")[0];
			String day = date.split("/")[1];

			util.waitForVisibilityOfElement(driver, filterByDropdown);
			util.selectDropdownByVisibleText(filterByDropdown, "By Day");
			util.waitForVisibilityOfElement(driver, dateField);
			boolean filterChang = dateField.isDisplayed();

			if (filterChang) {
				String year = util.getCurrentYear();
				if (Integer.parseInt(month) > util.getIntCurrentMonthNum()) {
					year = util.getPrevYear();
				}
				searchDate = selectDateFromTheCalenderInputField(dateField, month, day, year);
				clickOnFilterButton();

				int columnNumber = getIndexOfTableHeader(columnName);
				List<WebElement> footer = driver.findElements(By.xpath("//div[@class ='k-grid-footer']//td"));
				String salesItems = footer.get(columnNumber - 1).getText();

				return salesItems;

			} else {
				// result1 = false;
				test.log(Status.FAIL, "Failed to retrieve data' from total summury for date: " + searchDate);
				return null;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "failed to execute the script");
			return null;
		}

	}

	public String getReportName() {
		try {
			util.waitForVisibilityOfElementWithWait(driver, reportName, 10);
			return reportName.getText().trim();
		} catch (Exception e) {
			test.log(Status.FAIL, "Faile dto fetch the Report name");
			return null;
		}

	}

}
