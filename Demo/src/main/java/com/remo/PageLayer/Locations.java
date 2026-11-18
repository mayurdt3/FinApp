package com.remo.PageLayer;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi.sha256WithSM2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.remo.utility.Utility;
import com.aventstack.extentreports.Status;

public class Locations extends BaseClass {

    public Locations(WebDriver driver) {
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

    @FindBy(xpath = "//h5[text()='Locations']")
    private WebElement locationsPageHeader;

    @FindBy(xpath = "//div[@class='card dashboardCard']//a[text()='User Management']")
    private WebElement UMbradecrimb;

    @FindBy(xpath = "//label[contains(text(),'Status')]/..//select")
    private WebElement statusDropdown;

    @FindBy(xpath = "//label[contains(text(),'Name/MID')]/..//input")
    private WebElement nameMIDField;

    @FindBy(xpath = "//button[text()='Filter']")
    private WebElement filterButton;

    @FindBy(xpath = "//button[text()='Clear Filter']")
    private WebElement clearFilterButton;

    @FindBy(xpath = "//button[text()='Create New Location']")
    private WebElement createNewLocationBtn;

    @FindBy(xpath = "//h5[text()='Create New Location']")
    private WebElement createNewLocationPageHeader;

    @FindBy(xpath = "//div[contains(@class,'card-header')]//h5")
    private WebElement pageHeader;

    @FindBy(xpath = "//label[contains(text(),'Name')]/..//input")
    private WebElement nameField;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//thead[@role='presentation']//th")
    private List<WebElement> tableHeaderOptopns;

    @FindBy(xpath = "//button[contains(text(),'New Location')]")
    private WebElement createNewLocationButton;

    @FindBy(xpath = "//h5[text()='Locations']")
    private WebElement LocationsPageHeader;

    @FindBy(xpath = "//h5[text()='Select Product']")
    private WebElement selectProductPageHeader;

    @FindBy(xpath = "//i[@class='fas fa-ellipsis-v']/..")
    private List<WebElement> actionButtons;

    @FindBy(xpath = "//select[@name='select_product']")
    private WebElement selectProductDropdown;

    @FindBy(xpath = "//div[@class='panel-body']//button[contains(text(),'<')]")
    private WebElement backButton;

    @FindBy(xpath = "//div[@class='panel-body']//button[contains(text(),'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-nav')]")
    private WebElement actionsPopup;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-nav')]//li//span/following-sibling::span")
    private List<WebElement> actionsList;

    @FindBy(xpath = "//h5[contains(text(),'Edit Location')]")
    private WebElement editPageHeader;

    @FindBy(xpath = "//a[contains(text(),'Locations')]")
    private WebElement locationsBreadcrumb;

    @FindBy(xpath = "//button[contains(text(),'✖')]/..")
    private WebElement notification;

    @FindBy(xpath = "//button[contains(text(),'✖')]/../div")
    private WebElement notificationText;

    @FindBy(xpath = "//button[contains(text(),'✖')]")
    private WebElement notificationCloseButton;

    // Input Fields
    @FindBy(xpath = "//label[contains(text(),'Name')]/..//input")
    private WebElement nameInput;

    // Buttons (Assuming there are Update/Save and Cancel buttons)
    @FindBy(xpath = "//button[text()='Update']")
    private WebElement updateButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//h5[contains(text(),'Remove Location:')]")
    private WebElement removeLocationHeader;
    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement deleteButton;

    // ////
    // /
    // /
    // /
    // /
    // /
    // /
    // /
    // /
    // //

    @FindBy(xpath = "//label[contains(text(),'Address  Line 1')]/..//input")
    private WebElement addressLine1;

    @FindBy(xpath = "//label[contains(text(),'Address Line 2')]/..//input")
    private WebElement addressLine2;

    @FindBy(xpath = "//label[contains(text(),'Address  Line 3')]/..//input")
    private WebElement addressLine3;

    @FindBy(xpath = "//label[contains(text(),'Merchant ID')]/..//input")
    private WebElement merchantIdField;

    @FindBy(xpath = "//select[contains(., 'Select Owner Name')]")
    private WebElement ownerNameDropdown;

    @FindBy(xpath = "//label[contains(text(),'MIDs')]/..//input")
    private WebElement midsField;

    @FindBy(xpath = "//label[contains(text(),'RMS')]/..//select")
    private WebElement rmsDropdown;

    @FindBy(xpath = "//label[contains(text(),'Timezone')]/..//select")
    private WebElement timezoneDropdown;

    @FindBy(xpath = "//label[contains(text(),'Start time')]/..//div[text()='HH']/..//input")
    private WebElement startTimeHourDropdown;

    @FindBy(xpath = "//label[contains(text(),'Start time')]/..//div[text()='MM']/..//input")
    private WebElement startTimeMinuteDropdown;

    @FindBy(xpath = "//label[contains(text(),'End time')]/..//div[text()='HH']/..//input")
    private WebElement endTimeHourDropdown;

    @FindBy(xpath = "//label[contains(text(),'End time')]/..//div[text()='MM']/..//input")
    private WebElement endTimeMinuteDropdown;

    @FindBy(xpath = "//label[contains(text(),'Hours open')]/..//div[text()='HH']/..//input")
    private WebElement hoursOpenHourInput;

    @FindBy(xpath = "//label[contains(text(),'Hours open')]/..//div[text()='MM']/..//input")
    private WebElement hoursOpenMinuteInput;

    @FindBy(xpath = "//label[contains(text(),'Seats available')]/..//input")
    private WebElement seatsAvailableField;

    @FindBy(xpath = "//label[contains(text(),'Daily Report Emails')]/..//input")
    private WebElement dailyReportEmailsField;

    @FindBy(xpath = "//label[contains(text(),'Device Serial Nos')]/..//input")
    private WebElement deviceSerialNosField;

    @FindBy(xpath = "//label[contains(text(),'Products for Daily Reports')]/..//select")
    private WebElement productsForDailyReportsDropdown;

    @FindBy(xpath = "//button[contains(text(), 'Upload Image')]")
    private WebElement uploadLogoButton;

    @FindBy(xpath = "//div[contains(@class,'fileUploader')]//img")
    private WebElement fileUploadArea;

    @FindBy(xpath = "//button[text()='Upload Image']")
    private WebElement uploadImageButton;

    @FindBy(xpath = "//div[contains(@class,'fileUploader')]/..")
    private WebElement FileUploadFieldTooltip;

    public String getCreateNewLocationPageHederText() {
        util.waitForVisibilityOfElement(driver, createNewLocationPageHeader);
        return createNewLocationPageHeader.getText();
    }

    public boolean verifyNavigateToLocationsPage() {

        // home.isBusinessOverviewInfoDisplayed();
        home.clickOnUseManagement();
        if (profile.verifyNavigationToProfileSetting()) {
            profile.clickonLocationsbutton();
            util.waitForVisibilityOfElement(driver, LocationsPageHeader);
            String locPageHeader = locationsPageHeader.getText();
            if (locPageHeader.equalsIgnoreCase("Locations")) {
                test.log(Status.PASS, "Successfully Navigated to locations page");
                return true;
            } else {
                util.addBase64ScreenShotToReport(deleteButton, test, "failed to navigate to the locations page");
                test.log(Status.FAIL, "failed to navigate to the locations page");
                return false;
            }
        } else {
            test.log(Status.FAIL, "Failed to navigate to the profile page");
            return false;
        }

    }

    //

    public String getPageHeader() {
        util.waitForVisibilityOfElement(driver, pageHeader);
        String header = pageHeader.getText();
        System.out.println("Page header is :" + header);
        return header;
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

    public boolean isNameFieldBlank() {
        try {
            util.waitForVisibilityOfElement(driver, nameField);
            if (nameField.isDisplayed() && nameField.getText().isEmpty()) {
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

    public int getRowCount() {
        util.waitForVisibilityOfAllElements(driver, rows);
        return rows.size();
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

    public String getColumnValueforRow(int row, String column) {

        int columnNum = getcolumnNumber(column);
        columnNum++;
        String locator = "//tbody//tr[" + row + "]//td[" + columnNum + "]";
        util.waitForPresenceOfElementByLocator(driver, locator);
        util.waitForVisibilityOfElement(driver, (driver.findElement(By.xpath(locator))));
        String colvalue = driver.findElement(By.xpath(locator)).getText();

        return colvalue;
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

    public boolean verifyCreateNewLocationsButton() {
        try {
            util.waitForVisibilityOfElement(driver, createNewLocationButton);

            if (createNewLocationButton.isDisplayed() && createNewLocationButton.isEnabled()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Faled to load the Create New Locations button");
            util.addBase64ScreenShotToReport(driver, test, "Create New Locations button");
            e.printStackTrace();
            return false;
        }
    }

    public void clickOncreateNewLocationsButton() {

        if (verifyCreateNewLocationsButton()) {
            createNewLocationBtn.click();
        } else {
            test.log(Status.FAIL, "Faled to click on the Locations button");
        }
    }

    public boolean isSelectProductPageHeaderDisplayed() {
        try {
            util.waitForVisibilityOfElement(driver, selectProductPageHeader);
            if (selectProductPageHeader.isDisplayed()) {
                return true;
            } else {
                test.log(Status.FAIL, "Failed to displaye Select Product header");
                return false;
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to loade create Location header");
            util.addBase64ScreenShotToReport(driver, test, getPageHeader());
            e.printStackTrace();
            return false;
        }

    }

    public boolean VerifyNavigationToProductSelectionPage() {
        clickOncreateNewLocationsButton();

        if (isSelectProductPageHeaderDisplayed()) {
            test.log(Status.PASS, "Navigated to p page successfuly");
            util.addBase64ScreenShotToReport(driver, test, "Product Selection page");
            return true;
        } else {
            test.log(Status.FAIL, "Failed to Navigate to product selection page");
            return false;
        }
    }

    public boolean verifyDefaultValueOfSelectProductDropdown() {
        util.waitForVisibilityOfElement(driver, selectProductDropdown);
        String option = util.getSelectedOption(driver, selectProductDropdown).getText();
        if (option.equalsIgnoreCase("Select product")) {
            test.log(Status.PASS, "Default value for Select Product dropdown is 'Select Role'");
            return true;
        } else {
            test.log(Status.FAIL, "Default value for Select Product dropdown is not 'Select Role' found " + option);
            return false;
        }
    }

    public boolean verifySelectProductDropdownByText(String text) {
        util.waitForVisibilityOfElement(driver, selectProductDropdown);
        util.selectDropdownByVisibleText(selectProductDropdown, text);
        if (util.getSelectedOption(driver, selectProductDropdown).getText().equalsIgnoreCase(text)) {
            test.log(Status.PASS, "Successfully selected product: " + text);
            return true;
        } else {
            test.log(Status.FAIL, "Failed to select product: " + text);
            return false;
        }
    }

    public boolean verifyBackButtonOnProductSelectionPage() {
        util.waitForVisibilityOfElement(driver, backButton);
        if (backButton.isDisplayed() && backButton.isEnabled()) {
            backButton.click();
            util.waitForVisibilityOfElement(driver, LocationsPageHeader);
            if (LocationsPageHeader.isDisplayed()) {
                test.log(Status.PASS, "Successfully navigated back to Locations page from Product Selection page");
                clickOncreateNewLocationsButton();
                return true;
            } else {
                test.log(Status.FAIL, "Failed to navigate back to Locations page from Product Selection page");
                return false;
            }
        } else {
            test.log(Status.FAIL, "Back navigation button is not displayed/enabled on Product Selection page");
            return false;
        }

    }

    public boolean verifyNextButtonOnProductSelectionPage() {
        util.waitForVisibilityOfElement(driver, nextButton);
        if (nextButton.isDisplayed() && nextButton.isEnabled()) {
            nextButton.click();
            util.waitForVisibilityOfElement(driver, createNewLocationPageHeader);
            if (createNewLocationPageHeader.isDisplayed()) {
                test.log(Status.PASS, "Successfully navigated to create Locations page from Product Selection page");
                return true;
            } else {
                test.log(Status.FAIL, "Failed to navigate to create Locations page from Product Selection page");
                return false;
            }
        } else {
            test.log(Status.FAIL, "Next navigation button is not displayed/enabled on Product Selection page");
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

    public void navigatBackToLcoationsPage() {
        util.waitForVisibilityOfElement(driver, locationsBreadcrumb);
        locationsBreadcrumb.click();
        util.waitForVisibilityOfAllElements(driver, rows);
    }

    public boolean validateEditActionForLocatiionsTable() {
        try {
            Thread.sleep(1000);
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
                String mid = getColumnValueforRow(row + 1, "Email");
                System.out.println("UsereName: " + userName);
                System.out.println("MID :" + mid);

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

                            // if (editPageHeader.getText().contains(mid)) {
                            // System.out.println("suceesfully lodaed an edit location pahe");
                            // } else {
                            // System.out.println("Failed to load edit page for location:" + mid
                            // + " Expected naeme contains found: "
                            // + editPageHeader.getText().replace("Edit location: ", "").trim());
                            // util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to
                            // open");
                            // test.log(Status.FAIL,
                            // "Failed to load edit page for location:" + mid
                            // + " Expected naeme contains found: "
                            // + editPageHeader.getText().replace("Edit location: ", "").trim());
                            // o++;
                            // }
                            navigatBackToLcoationsPage();
                        }
                    }
                    if (!isActionPresent) {
                        test.log(Status.FAIL, "Actions dose not contain Edit option for location with mid:" + mid);
                        return false;
                    }
                } else {
                    util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
                    test.log(Status.FAIL, "Actions popup failed to open for location with email:" + mid);
                    return false;
                }
            }
            if (o > 0) {
                return false;
            } else {
                test.log(Status.PASS, "Successfuly navigatetd to the Edit Location page");
                return true;
            }

        }

    }

    public String getLocationStatus(int rownum) {
        int colNum = getcolumnNumber("Status");
        String locator = "//tbody//tr[" + rownum + "]//td[" + colNum + "]";
        return driver.findElement(By.xpath(locator)).getText();
    }

    public boolean isLocationActive(int rownum) {
        if (getLocationStatus(rownum).equalsIgnoreCase("Active")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyActiveInactiveActionFunctionality() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        util.waitForVisibilityOfElement(driver, clearFilterButton);
        clearFilterButton.click();

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
                    String mid = getColumnValueforRow(row + 1, "MID");
                    String status = getColumnValueforRow(row + 1, "Status");
                    System.out.println("UsereName: " + userName);
                    System.out.println("MID :" + mid);
                    System.out.println("Status :" + status);

                    if (!status.equalsIgnoreCase("UNCONFIRMED")) {

                        selectActionsButtonforRow(row);
                        System.out.println("Clicked on actions button");
                        util.waitForVisibilityOfElement(driver, actionsPopup);
                        System.out.println("************popup displayed****************");

                        if (actionsPopup.isDisplayed()) {

                            // test.log(Status.PASS, "Action popup is displayed");
                            util.waitForVisibilityOfAllElements(driver, actionsList);

                            for (int opt = 0; opt < actionsList.size(); opt++) {

                                util.waitForVisibilityOfElement(driver, actionsList.get(opt));

                                if (actionsList.get(opt).getText().equalsIgnoreCase("Active")
                                        || actionsList.get(opt).getText().equalsIgnoreCase("Inactive")) {
                                    System.out.println("Found  Action :" + actionsList.get(opt).getText());

                                    util.hoverOnElementInView(driver, actionsList.get(opt));
                                    actionsList.get(opt).click();

                                    try {
                                        util.waitForVisibilityOfElement(driver, notification);
                                        // catch(Exception e){

                                        // }
                                        // try{

                                        if (notificationText.getText().contains("Location Activated successfully")) {
                                            System.out
                                                    .println("'Location Activated successfully' Message is displayed");
                                            notificationCloseButton.click();
                                            test.log(Status.PASS,
                                                    "'Location Activated successfully' Message is displayed for location with MID: "
                                                            + mid);
                                            util.addBase64ScreenShotToReport(driver, test,
                                                    "Activate Location Notifiaction");
                                            util.hoverOnElementInView(driver, actionsList.get(opt));
                                            actionsList.get(opt).click();
                                        } else if (notificationText.getText()
                                                .contains("Location inactivated successfully")) {
                                            System.out.println(
                                                    "'Location Inactivated successfully' Message is displayed for location with MID: "
                                                            + mid);
                                            util.addBase64ScreenShotToReport(driver, test,
                                                    "Inactivate Location Notifiaction");
                                            notificationCloseButton.click();
                                            test.log(Status.PASS,
                                                    "'Location inactivated successfully' Message is displayed for location with MID: "
                                                            + mid);
                                            // util.addBase64ScreenShotToReport(driver, test, "location Disabled
                                            // notification");
                                            // util.hoverOnElementInView(driver, actionsList.get(opt));
                                            // actionsList.get(opt).click();
                                        } else {
                                            test.log(Status.FAIL,
                                                    "Failed to display the notification message for location with MID: "
                                                            + mid);
                                            o++;
                                        }

                                    } catch (Exception e) {

                                        test.log(Status.FAIL,
                                                "Failed to display the notification message for location with MID: "
                                                        + mid);
                                    }
                                }
                                // else {
                                // //util.addBase64ScreenShotToReport(driver, test, "Actions issue");
                                // continue;
                                // }
                            }

                        } else {
                            util.addBase64ScreenShotToReport(driver, test, "Actions popup failed to open");
                            test.log(Status.FAIL, "Actions popup failed to open for location with email:" + mid);
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            }

            if (o > 0) {
                test.log(Status.FAIL, "Active/Inactive Action Verification Failed");

                return false;
            } else {
                test.log(Status.PASS, "Active/Inactive Action Verification Sucessful");
                return true;
            }
        }
    }

    /**
     * Checks if the First Name input field is displayed.
     */
    public boolean isFirstNameFieldDisplayed() {
        try {
            // Wait for visibility; if it succeeds, the element is displayed and ready.
            util.waitForVisibilityOfElement(driver, nameInput);
            return nameInput.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyRemoveLocationFunctionality(String nmae) {

        home.clickOnUseManagement();
        verifyNavigateToLocationsPage();

        util.waitForVisibilityOfElement(driver, clearFilterButton);
        clearFilterButton.click();

        util.waitForVisibilityOfElement(driver, nameMIDField);
        nameMIDField.sendKeys(nmae);
        clickOnFilterButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // int roleColnum =getcolumnNumber("Role");
        // int rowcount = getRowCount();
        // String roleValue = getColumnValueforRow(rowcount, "Role");
        // System.out.println("Created user role :" + roleValue);

        // if (!roleValue.equalsIgnoreCase(role)) {
        // return false;
        // }

        util.waitForVisibilityOfAllElements(driver, actionButtons);
        int size = actionButtons.size();

        if (size >= 1) {
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

                    util.waitForVisibilityOfElement(driver, removeLocationHeader);

                    if (deleteButton.isDisplayed() & deleteButton.isEnabled()) {
                        test.log(Status.PASS, "Delete button is displayed and enabled");
                        return true;
                    } else {
                        test.log(Status.FAIL,
                                "Delete button is not displayed/enabled");
                        return false;
                    }
                } else {
                    continue;
                }
            }
            if (i == 0) {
                test.log(Status.FAIL, "Failed to find Remove Action Option");
                return false;
            } else {
                return true;
            }

        } else {
            test.log(Status.FAIL, "No results found for location given MID/name: " + nmae);
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

    private void enterText(WebElement element, String text, String fieldName) {
        try {
            // Wait until the element is visible before sending keys
            util.waitForVisibilityOfElement(driver, element);
            element.clear();
            element.sendKeys(text);
            if (element.getAttribute("value").equalsIgnoreCase(text)) {
                test.log(Status.PASS, "INFO: Successfully entered '" + text + "' into the '" + fieldName + "'.");
            } else {
                test.log(Status.FAIL, "ERROR: Failed to enter '" + text + "' into the '" + fieldName + "'.");
            }

        } catch (TimeoutException e) {

            System.err.println("ERROR: Timeout waiting for '" + fieldName + "' field to be visible or interactable.");
            test.log(Status.FAIL,
                    "ERROR: Timeout waiting for '" + fieldName + "' field to be visible or interactable.");
            // Re-throw as a runtime exception to fail the TestNG test gracefully
            throw new RuntimeException("Wait Timeout: Element not visible: " + fieldName, e);

        } catch (NoSuchElementException e) {
            System.err.println("ERROR: Locator for '" + fieldName + "' is incorrect. Element not found on the page.");
            test.log(Status.FAIL,
                    "ERROR: Locator for '" + fieldName + "' is incorrect. Element not found on the page.");

            throw new RuntimeException("Locator Error: Element not found: " + fieldName, e);
        }
    }

    private void selectOption(WebElement element, String text, String fieldName) {
        try {
            // Wait until the element is visible before sending keys
            util.waitForVisibilityOfElement(driver, element);
            util.selectDropdownByVisibleText(element, text);
            if (util.getSelectedOption(driver, element).getText().equalsIgnoreCase(text)) {
                test.log(Status.PASS, "INFO: Successfully selected '" + text + "' into the '" + fieldName + "'.");
            } else {
                test.log(Status.FAIL, "ERROR: Failed to select '" + text + "' into the '" + fieldName + "'.");
            }

        } catch (TimeoutException e) {

            System.err.println("ERROR: Timeout waiting for '" + fieldName + "' field to be visible or interactable.");
            // Re-throw as a runtime exception to fail the TestNG test gracefully
            throw new RuntimeException("Wait Timeout: Element not visible: " + fieldName, e);
        } catch (NoSuchElementException e) {
            System.err.println("ERROR: Locator for '" + fieldName + "' is incorrect. Element not found on the page.");
            throw new RuntimeException("Locator Error: Element not found: " + fieldName, e);
        }
    }

    public boolean verifyCreateLocationFormFieldsFunctionality(String name, String address1, String address2,
            String address3, String mid,
            String rms, String Timezone, String startTHH, String startMM, String endTHH, String endMM,
            String seatsAvailable,
            String email, String deviceSelealNo, String products) {

        enterText(nameField, name, "Name");
        enterText(addressLine1, address1, "Address Line 1");
        enterText(addressLine2, address2, "Address Line 2");
        enterText(addressLine3, address3, "Address Line 3");
        enterText(midsField, mid, "MID");

        selectOption(rmsDropdown, rms, "RMs");
        // util.selectDropdownByIndex(rmsDropdown, util.getRandomenumber(3));

        // selectOption(timezoneDropdown, Timezone, "Timezone");
        util.selectDropdownByValue(timezoneDropdown, "America/New_York");
        if (util.getSelectedOption(driver, timezoneDropdown).getText()
                .equalsIgnoreCase("Eastern Standard Time (ET) - UTC -5")) {
            test.log(Status.PASS, "INFO: Successfully selected 'America/New_York' into the 'Timezone'.");
        } else {
            test.log(Status.FAIL, "ERROR: Failed to select 'America/New_York' into the 'Timezone'.");
        }

        // enterText(startTimeHourDropdown, startTHH, "Start Time Hour");
        startTimeHourDropdown.sendKeys(startTHH);
        util.getActionObject(driver).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        // enterText(startTimeMinuteDropdown, startMM, "Start Time Minute");
        startTimeMinuteDropdown.sendKeys(startMM);
        util.getActionObject(driver).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        // enterText(endTimeHourDropdown, endTHH, "End Time Hour");
        endTimeHourDropdown.sendKeys(endTHH);
        util.getActionObject(driver).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        // enterText(endTimeMinuteDropdown, endMM, "End Time Minute");
        endTimeMinuteDropdown.sendKeys(endMM);
        util.getActionObject(driver).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        enterText(seatsAvailableField, seatsAvailable, "Seats Available");

        // String hrOpenH = hoursOpenHourInput.getAttribute("value");
        // String hrOpenM = hoursOpenMinuteInput.getAttribute("value");
        // System.out.println("Hours Open HH:" + hrOpenH);
        // System.out.println("Hours Open MM:" + hrOpenM);

        // int startTHHInt = Integer.parseInt(startTHH);
        // int startMMInt = Integer.parseInt(startMM);
        // int endTHHInt = Integer.parseInt(endTHH);
        // int endMMInt = Integer.parseInt(endMM);

        // int hrOpenHInt = Integer.parseInt(hrOpenH);
        // int hrOpenMInt = Integer.parseInt(hrOpenM);

        // // calcaulate hr open
        // int totalStartMins = startTHHInt * 60 + startMMInt;
        // int totalEndMins = endTHHInt * 60 + endMMInt;
        // int totalOpenMins = totalEndMins - totalStartMins;
        // if (totalOpenMins < 0) {
        // totalOpenMins += 24 * 60; // Adjust for next day
        // }
        // int expectedHrOpenH = totalOpenMins / 60;
        // int expectedHrOpenM = totalOpenMins % 60;

        // if (hrOpenHInt == expectedHrOpenH && hrOpenMInt == expectedHrOpenM) {
        // test.log(Status.PASS, "Hours Open field auto-calculation is correct: " +
        // hrOpenH + " HH : " + hrOpenM
        // + " MM");
        // } else {
        // test.log(Status.FAIL, "Hours Open field auto-calculation is incorrect:
        // Expected: " + expectedHrOpenH
        // + " HH : " + expectedHrOpenM + " MM" + " Found: " + hrOpenH + " HH : " +
        // hrOpenM + " MM");
        // }

        // enterText(hoursOpenHourInput, hoursOpenHH, "Hours Open Hour");
        // enterText(hoursOpenMinuteInput, hoursOpenMM, "Hours Open Minute");
        enterText(dailyReportEmailsField, email, "Daily Report Emails");
        enterText(deviceSerialNosField, deviceSelealNo, "Device Serial Nos");
        selectOption(productsForDailyReportsDropdown, products, "Products for Daily Reports");
        // util.selectDropdownByIndex(productsForDailyReportsDropdown,
        // util.getRandomenumber(3));

        VerifyUploadUserLogo();

        return true;

    }

}
