package com.remo.TestLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.remo.PageLayer.API;
import com.remo.Test.BaseTest;
import com.aventstack.extentreports.Status;

import reporter.ExtentUtility;

public class BoDataCheck extends BaseTest {

	String FILE_PATH = System.getProperty("user.dir") + "/BO_Output/BO_log.xlsx";

	SoftAssert s = new SoftAssert();

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("ProdURL") String env, @Optional("Chrome") String browser) {
		ExtentUtility.createReport("BoTest", env, browser);
		SoftAssert s = new SoftAssert();
		test = extent.createTest("Login");
		// util.setWindowresolution(driver,50);
		try {

			login.loginVerificationProd(env, "Username", "Password");
			test.log(Status.PASS, "Logged in successfuly");
			System.out.println("Login successful");
			// api = new API();

			s.assertTrue(home.isBusinessOverviewInfoDisplayedWithTime(25));

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Log in to the application");
			e.printStackTrace();
			util.addBase64ScreenShotToReport(driver, test);
		}
		s.assertAll();
	}

	@DataProvider(name = "LiveMIDs")
	public String[] getLiveMIDData() {
		api = new API();
		return api.getLiveMerchantStatementPdfVerifyData();
	}

	@Test(priority = 0, dataProvider = "LiveMIDs")
	public void businessOverview(String MID) {
		String bt;
		String btc;
		String tst;
		String tstc;
		String stad;
		try {

			test = extent.createTest("Business Overview of: " + MID);
			System.out.println("Given MID:" + MID);
			home.searchMID(MID);

			// Thread.sleep(2000);
			// System.out.println(home.getMIDFromList());
			home.selectFirstMIDFromList();

			System.out.println("Searched MID: " + home.getMid());

			if (MID.equalsIgnoreCase(home.getMid())) {
				// test.log(Status.PASS, "Sucessfuly searched the given MID");
				s.assertTrue(true);

			} else {
				s.assertTrue(false);
				test.log(Status.FAIL, "Failed to select searched MID");
			}

			s.assertTrue(home.isBusinessOverviewInfoDisplayedWithTime(25));

			bt = home.getBObatchTotal();
			btc = home.getBONumOfTransactions();

			System.out.println("bo data : \nbatch total:" + bt + "\nNumber of Transaction" + btc);
			util.scrollHandle(driver, home.businessOverviewCard);

			util.addBase64ScreenShotToReport(home.businessOverviewCard, test, "BusinessOverview for: " + MID);

			if (home.getNumberOfTransactions().equalsIgnoreCase("0")) {
				reportsP.navigateTo_TotalsSummaryReport();
				// util.waitForVisibilityOfElement(driver,
				// reportsP.totalsSummaryReportSalesAmount);
				s.assertTrue(reportsP.getReportName().equals("Totals Summary Report"));
				Thread.sleep(2000);
				// util.waitForInvisibilityOfElementWithWait(driver,
				// reportsP.noRecordsAvailableMsg,10);
				if (reportsP.noRecordsAvailableMsg.isDisplayed()) {
					test.log(Status.PASS, "'No records available' text is displayed");

					util.addBase64ScreenShotToReport(driver, test);

					tst = reportsP.getsalesAmount();
					tstc = reportsP.getsalesItem();

					System.out.println("Total Summary data : \nSalse Amount:" + tst + "\nSlse Items: " + tstc);

					s.assertTrue(true);
				} else {
					test.log(Status.PASS, "'No records available' text is not displayed for '0' Transactions");

					util.addBase64ScreenShotToReport(driver, test);

					tst = reportsP.getsalesAmount();
					tstc = reportsP.getsalesItem();

					System.out.println("Total Summary data : \nSalse Amount:" + tst + "\nSlse Items" + tstc);

					s.assertTrue(false);
				}

			} else {

				reportsP.navigateTo_TotalsSummaryReport();
				// util.waitForVisibilityOfElement(driver,
				// reportsP.totalsSummaryReportSalesAmount);
				s.assertTrue(reportsP.getReportName().equals("Totals Summary Report"));

				// util.scrollHandleEndOfTheElement(driver,
				// reportsP.totalsSummaryReportSalesAmount);
				util.addBase64ScreenShotToReport(driver, test);

				tst = reportsP.getsalesAmount();
				tstc = reportsP.getsalesItem();

				System.out.println("Total Summary data : \nSalse Amount:" + tst + "\nSlse Items" + tstc);

				System.out.println();

				test.log(Status.PASS, "Recods Available ");
				System.out.println("Captured TSReport");

			}

			/////////
			/// Search transaction calculation
			///
			///

			home.clickOnReports();
			util.waitForVisibilityOfAllElements(driver, reportsP.viewReportBtns);
			reportsP.searchTransactions.click();

			if (reportsP.getReportName().contains("Search Transaction")) {

				int currentMonthnum = util.getIntCurrentMonthNum();
				String currentMonth = util.getMonthShortName(currentMonthnum);
				System.out.println(currentMonth + " = " + currentMonthnum);

				String selectedMonth = util.getSelectedOption(driver, reportsP.monthDropdown).getText();

				if (currentMonth.equalsIgnoreCase(selectedMonth)) {

					try {

						util.waitForVisibilityOfElementWithWait(driver, reportsP.noRecordsAvailableMsg, 2);

						if (reportsP.noRecordsAvailableMsg.isDisplayed()) {
							System.out.println("No Records available");
							test.log(Status.INFO, "Search Transaction: No Records available");
							stad = "No Records available";
						} else {
							stad = "failed to load";
						}
					} catch (Exception e) {

						String lastTransaction = driver.findElement(By.xpath("//tbody//tr[1]/td[1]")).getText();

						test.log(Status.INFO, "Search Transaction: For " + selectedMonth
								+ " month the data uploaded is till : " + lastTransaction);
						System.out.println("Search Transaction: For " + selectedMonth
								+ " month the data uploaded is till : " + lastTransaction);
						String availabeleDate = lastTransaction.replaceAll("-", ".");
						stad = availabeleDate;

					}
				} else {
					System.out.println("By default currnt month is not slected in 'Month' dropdown");
					test.log(Status.FAIL,
							"Search Transaction: By default currnt month is not slected in 'Month' dropdown\n Expected: "
									+ currentMonth + ", found: " + selectedMonth);
					stad = "Issue with month dropdown";
				}

			} else {
				System.out.println("Failed to navigate to Seacrh Transaction Report");
				test.log(Status.FAIL, "Failed to navigate to Seacrh Transaction Report");
				stad = "failed to load";
			}

			appendTransaction(MID, bt, btc, tst, tstc, stad);

		} catch (Exception e) {
			bt = "failed to load";
			btc = "failed to load";
			tst = "failed to load";
			tstc = "failed to load";
			stad = "failed to load";
			appendTransaction(MID, bt, btc, tst, tstc, stad);

			test.log(Status.FAIL, "Verification failed");
			e.printStackTrace();
		} finally {

			s.assertAll();
			home.clickOnDashBoard();
			home.isBusinessOverviewInfoDisplayedWithTime(10);

		}
	}

	public void appendTransaction(String MID, String boTransaction, String boTransCount, String summaryTransaction,
			String summaryTransCount, String SearchTransactionUpdatedDate) {
		File file = new File(FILE_PATH);
		Workbook workbook;
		Sheet sheet;

		try {
			if (!file.exists()) {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("Transaction Logs");

				// Create header row
				Row header = sheet.createRow(0);
				header.createCell(0).setCellValue("Date");
				header.createCell(1).setCellValue("MID");
				header.createCell(2).setCellValue("BO Transaction");
				header.createCell(3).setCellValue("BO Trans Count");
				header.createCell(4).setCellValue("Summary Transaction");
				header.createCell(5).setCellValue("Summary Tran Count");
				header.createCell(6).setCellValue("Search Transaction updated date");
			} else {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
			}

			int lastRowNum = sheet.getLastRowNum();
			Row row = sheet.createRow(lastRowNum + 1);

			String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			row.createCell(0).setCellValue(currentDate);
			row.createCell(1).setCellValue(MID);
			row.createCell(2).setCellValue(boTransaction);
			row.createCell(3).setCellValue(boTransCount);
			row.createCell(4).setCellValue(summaryTransaction);
			row.createCell(5).setCellValue(summaryTransCount);
			row.createCell(6).setCellValue(SearchTransactionUpdatedDate);

			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();
			fos.close();

			System.out.println("Transaction added successfully!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
