package com.remo.TestLayer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.remo.Test.BaseTest;

import reporter.ExtentUtility;

public class PartnerHubTest extends BaseTest {

    @BeforeClass
    @Parameters({ "environment", "browserName" })
    public void reportsPageSetup(@Optional("QAURL") String env, @Optional("chrome") String browser) {
        ExtentUtility.createReport("Reports", env, browser);
        test = extent.createTest("launnch app");
        // login.loginMethod(env, "Username", "Password");
        launchApp(env);
    }

    @Test(priority = 6)
    public void VerifySkipPaymentScenario() {

        test = extent.createTest(" VerifyEditApplicationpaymentCycle");

        SoftAssert a = new SoftAssert();
        a.assertTrue(partnerH.VerifyEditEquipmentAfterPayment());
        a.assertAll();

    }

}
