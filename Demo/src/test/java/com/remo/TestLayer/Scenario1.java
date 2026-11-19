package com.remo.TestLayer;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.remo.Test.BaseTest;

import net.bytebuddy.build.Plugin.Engine.Summary;
import reporter.ExtentUtility;

public class Scenario1 extends BaseTest {

    SoftAssert soft = new SoftAssert();

    @BeforeClass
    @Parameters({ "environment", "browserName" })

    public void createReport(@Optional("QAURL") String env, @Optional("Chrome") String browser) {
        ExtentUtility.createReport("DemoFinApp", env, browser);
        launchApp(env);
    }

    String monthNum = "1";

    @Test(priority = 0)
    @Parameters("environment")
    public void VerifyOverviewBatchTotalWithSummaryTotal(@Optional("QAURL") String env) {
        test = extent.createTest("Scenario 1");
        // util.setWindowresolution(driver,50);

        dashboard.selectOverviewYear("2026");
        System.out.println(dashboard.getSlectedOverview());
        if (dashboard.getSlectedOverview().equals("2026")) {
            System.out.println("=========2026");
            test.log(Status.PASS, "Slected succesfuly");
        } else {
            System.out.println("failed to show");
        }

        // Step 3: Get Batch Total from Business Overview (this is the correct net
        // amount)
        String batchTotalDisplay = dashboard.getBatchTotal();
        long batchTotalCents = parseMoneyToCents(batchTotalDisplay);
        LOG.info("Business Overview Batch Total (Year): {} cents (${})", batchTotalCents, batchTotalDisplay);

        long monthlySumCents = 0L;
        List<String> monthlyEvidence = new ArrayList<>();

        // Step 4: Navigate to Totals Summary Report
        reportsP.navigateToTotalsSummary();
        int j = Integer.parseInt(util.getCurrentMonthNum());

        for (int i = 1; i <= j; i++) {
            try {
                // Filter by month
                reportsP.filterByMonth(util.getMonthShortName(i), util.getCurrentYear());
                String reportPeriod = reportsP.getReportPeriod();

                // Get monthly total
                String monthlyTotalDisplay = reportsP.getTotalSubmittedAmount();
                long monthlyCents = reportsP.getTotalSubmittedInCents();

                LOG.info("Month {} - Report Period: {}, Monthly Total: {} cents (${})",
                        i, reportPeriod, monthlyCents, monthlyTotalDisplay);

                monthlySumCents += monthlyCents;
                monthlyEvidence.add(String.format("Month %s: %s cents (%s)",
                        monthNum, formatCents(monthlyCents), monthlyTotalDisplay));
            } catch (Exception e) {
                LOG.error("Failed to process month " + monthNum + ": " + e.getMessage());
                // Continue with next month on error
            }
        }

        LOG.info("Sum of monthly totals: {} cents (${})", monthlySumCents, formatCents(monthlySumCents));

        // Step 6: Store values for evidence
        List<String> evidence = new ArrayList<>();
        evidence.add("Test Year: " + util.getCurrentYear());
        evidence.add("Business Overview Batch Total (Year): $" + formatCents(batchTotalCents));
        evidence.add("Totals Summary Monthly Sum: $" + formatCents(monthlySumCents));

        // Log monthly breakdown
        for (String line : monthlyEvidence) {
            LOG.info("EVIDENCE: {}", line);
        }

        // Step 7: Calculate difference
        long differenceCents = Math.abs(monthlySumCents - batchTotalCents);
        evidence.add("Difference: $" + formatCents(differenceCents));

        // Step 8: Verification logic
        // When BUG-01 is ON: monthly sum will be GREATER than batch total (gross > net)
        // The difference represents refunds that are included in gross but deducted
        // from net
        if (monthlySumCents > batchTotalCents) {
            evidence.add("VERIFIED:  is ACTIVE - Totals Summary shows gross sales");
            evidence.add("Difference ($" + formatCents(differenceCents) + ") = Total refunds not deducted");
            LOG.info("VERIFIED: is ACTIVE - Totals Summary gross > Business Overview net");
            LOG.info("Difference (${}): Total refunds included but not deducted", formatCents(differenceCents));
        } else {
            evidence.add("UNEXPECTED:  Values match unexpectedly");
            LOG.warn("UNEXPECTED: Totals Summary does not exceed Business Overview - bug may be fixed");
        }

        // Print evidence for the report
        for (String line : evidence) {
            LOG.info("EVIDENCE: {}", line);
        }

        // Assertion: Monthly sum should EQUAL year total (correct behavior)

        test.log(Status.FAIL,
                "Totals Summary monthly sum " + formatCents(monthlySumCents)
                        + " should equal Business Overview year total " + formatCents(batchTotalCents)
                        + ", but differs by " + formatCents(differenceCents));

        Assert.assertEquals(monthlySumCents, batchTotalCents,
                String.format(
                        "Totals Summary monthly sum ($%s) should equal Business Overview year total ($%s), but differs by $%s",
                        formatCents(monthlySumCents), formatCents(batchTotalCents), formatCents(differenceCents)));

    }

    @Test(priority = 1)
    @Parameters("environment")
    public void VerifyTotalSummuryreport(@Optional("QAURL") String env) {
        test = extent.createTest("Verify Total Summary report");

    }

    @Test(priority = 2)
    @Parameters("environment")
    public void VerifyTotalSummuryWithStSettledBatchAmounts(@Optional("QAURL") String env) {
        test = extent.createTest("Scenario 1");

    }

    /** Parse money string like "$1,234.56" to cents as long */
    private long parseMoneyToCents(String money) {
        String cleaned = money.replace("$", "").replace(",", "").trim();
        return (long) (Double.parseDouble(cleaned) * 100);
    }

    /** Format cents back to dollars */
    private String formatCents(long cents) {
        return String.format("$%.2f", cents / 100.0);
    }

    // // @Test(priority = 1)

    // public void VerifyBrokenImageOnHomePage() {
    // test = extent.createTest("Check for Broken images on Home Page");
    // assertTrue(checkBrokenImages());

    // }

    // @Test(priority = 1, dependsOnMethods = "VerifyLogin")
    // public void VerifyVisibilityOfDBA_Details() {
    // // test = extent.createTest("Verify Visibility of DBA Details");

    // SoftAssert s = new SoftAssert();

    // s.assertTrue(home.isDBA_NameIsVisible());

    // s.assertTrue(home.isDBA_AddressVisible());

    // s.assertTrue(home.isMIDVisible());

    // s.assertAll();
    // }

    // // @Test(priority = 1, dependsOnMethods = "VerifyLogin")
    // public void verifyNotificationFunctionality() {
    // // test = extent.createTest("Verify Notification Functionality");
    // assertTrue(home.verifyNotificationDropdown());

    // }

    // // @Test(priority = 2, dependsOnMethods = "VerifyLogin")
    // public void verifyProfileDropdown() {
    // assertTrue(home.visibilityOfUserProfileDropdown());

    // }

    // @Test(priority = 3, dependsOnMethods = "VerifyLogin")
    // public void VerifyVisibilityOfSearchBar() {
    // assertTrue(home.isSearchbarVisible());
    // }

    // @Test(priority = 4, dependsOnMethods = "VerifyLogin")
    // public void verifyVisibilityOfSideMenuBar() {

    // // test = extent.createTest("Verify Visibility of Side Menu bar Options");
    // assertTrue(home.isSideBarOptionsDisplayed());

    // }

    // @Test(priority = 6, dependsOnMethods = "VerifyLogin")
    // public void verifyLinkValidationOfSideMenuBar() {
    // // test = extent.createTest("Verify Visibility of Side Menu bar Options");
    // assertTrue(home.linkValidationForSideBar());

    // }

    // // @Test(priority = 5, dependsOnMethods = "VerifyLogin")
    // public void businessOverview() {
    // assertTrue(home.verifyBusinessOverviewFunctionality());
    // }

    // // @Test(priority = 8, dependsOnMethods = "VerifyLogin")
    // public void verifyProductBarNavigation() {
    // // test = extent.createTest("Verify navigation functionality of product
    // cards");
    // assertTrue(home.productNavigation());

    // }

    // // @Test(priority = 7, dependsOnMethods = "VerifyLogin")
    // public void verifyAllProducts() {
    // // test = extent.createTest("Verify all Product card");

    // // assertTrue(home.verifyNumberOfProducts() );

    // assertTrue(home.VerifyProductsWidgetsIsVisible());

    // }

    // // @Test(priority = 7)
    // public void verifyActiveProducts() {
    // // test = extent.createTest("Verify Active Product card");

    // assertTrue(home.verifyActiveProductsAreDisplayedOptionl());

    // }

    // // @Test(priority = 8)
    // public void verifyCountOfActiveEPIServices() {
    // // test = extent.createTest(
    // // "Verify if Active product count from home page matches with count of
    // product
    // // displayed in user profile");
    // if (home.verifyNumberOfActiveProductsInUseProfile()) {
    // test.log(Status.PASS,
    // "Count of active Active product cards displayed on the homepage matches with
    // the count in user profile");
    // } else {
    // test.log(Status.FAIL, "active product count does not match");
    // assertTrue(home.verifyNumberOfActiveProductsInUseProfile());
    // }
    // }

}
