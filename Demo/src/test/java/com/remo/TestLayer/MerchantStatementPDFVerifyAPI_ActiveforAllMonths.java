package com.remo.TestLayer;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.remo.PageLayer.API;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reporter.ExtentUtility;

public class MerchantStatementPDFVerifyAPI_ActiveforAllMonths extends BaseClass {
	ConfigUtil prop = new ConfigUtil();
	int j = 0;
	public List<String> months = Arrays.asList("", "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December");
	LocalDate currentDate = LocalDate.now();
	int year = currentDate.getYear();
	int currentMonth = currentDate.getMonthValue();
	int prevMonth = currentMonth - 1;
	int prevYear = currentDate.getYear() - 1;
	int dayOfMonth = currentDate.getDayOfMonth();
	String status;
	String backend;

	List<String> north = new ArrayList<String>();
	List<String> omaha = new ArrayList<String>();
	List<String> tierII = new ArrayList<String>();

	List<String> mids = new ArrayList<String>();
	SoftAssert a = new SoftAssert();

	@BeforeClass
	@Parameters({ "environment", "browserName" })

	public void createReport(@Optional("ProdURL") String env, @Optional("chrome") String browser) {
		api = new API();
		ExtentUtility.createReport("MerchantStatementPDFVerify");

	}

	// @DataProvider(name = "MerchantStatement")
	// public String[] getLoginTestData() {
	// return api.geMixMerchantStatementPdfVerifyData();
	// }

	@Test(priority = 1)
	public void getMerchantDetails() {
		// for (String mid : api.geMixMerchantStatementPdfVerifyData()) {
		for (String mid : api.getMerchantStatementPdfVerifyData()) {
			mids.add(mid);
		}
		for (String mid : mids) {
			// String mid = mid;
			Response BusinessOverViewResponse = RestAssured.given().header("M360KEY", prop.getProperty("ProdM360KEY"))
					.when().get(prop.getProperty("GetMerchantDetailsProdAPI") + "=" + mid);

			String response1 = BusinessOverViewResponse.getBody().asString();

			if (response1 != null) {

				////// System.out.println(response1);
				// status =
				// BusinessOverViewResponse.jsonPath().getString("[0].MerchantKey.Status");
				backend = BusinessOverViewResponse.jsonPath().getString("[0].MerchantKey.Backend");

				// System.out.println(backend.toUpperCase());
				////// System.out.println(status);
				//

				// if (status.equalsIgnoreCase("Processing")) {
				// // status = "Active";
				//
				// }

				if (backend.toUpperCase().equals("OMAHA")) {
					omaha.add(mid);
				} else if (backend.toUpperCase().equals("NORTH")) {
					north.add(mid);
				}
				if (backend.toUpperCase().equals("TIERII")) {
					tierII.add(mid);
				}

			}
		}
		// System.out.println("sorting done");
		// for Omaha
		test = extent.createTest("OMAHA");
		for (String omid : omaha) {

			status = checkmidstatus(omid).toUpperCase();

			String o = checkMidforlastTwoMonths(omid);
			// String o = checkMid(omid);
			if (status.equalsIgnoreCase("Active")) {

				status = "<span style='color:green;'>" + status + "</span>";
			} else {

				status = "<span style='color:red;'>" + status + "</span>";
			}
			// System.out.println(o);
			if (!(o.isEmpty())) {
				test.log(Status.FAIL,
						omid + " | Status: " + status + " | <br>No record available for the months: <br>" + o);
			} else {
				test.log(Status.PASS,
						omid + " | Status: " + status + " | Records are available for the last two months.");
			}

		}

		// for North
		test = extent.createTest("NORTH");
		for (String nmid : north) {
			status = checkmidstatus(nmid).toUpperCase();

			String n = checkMidforlastTwoMonths(nmid);
			if (status.equalsIgnoreCase("Active")) {

				status = "<span style='color:green;'>" + status + "</span>";
			} else {

				status = "<span style='color:red;'>" + status + "</span>";
			}
			if (!n.isEmpty()) {
				test.log(Status.FAIL,
						nmid + " | Status: " + status + " | <br>No record available for the months: <br>" + n);
			} else {
				test.log(Status.PASS,
						nmid + " | Status: " + status + " | Records are available for the last two months.");
			}
		}
		//

		// for tierII
		test = extent.createTest("TIER||");
		for (String tmid : tierII) {

			status = checkmidstatus(tmid).toUpperCase();
			if (status.equalsIgnoreCase("Active")) {

				status = "<span style='color:green;'>" + status + "</span>";
			} else {

				status = "<span style='color:red;'>" + status + "</span>";
			}
			// String t = checkMid(tmid);
			String t = checkMidforlastTwoMonths(tmid);
			if (!t.isEmpty()) {
				test.log(Status.FAIL,
						tmid + " | Status: " + status + " |<br>No record available for the months: <br>" + t);
			} else {
				test.log(Status.PASS,
						tmid + " | Status: " + status + " | Records are available for the last two months.");
			}
		}
		a.assertAll();

	}

	public String checkmidstatus(String mid) {
		// String mid = mid;
		Response BusinessOverViewResponse = RestAssured.given().header("M360KEY", prop.getProperty("ProdM360KEY"))
				.when().get(prop.getProperty("GetMerchantDetailsProdAPI") + "=" + mid);

		String response1 = BusinessOverViewResponse.getBody().asString();

		if (response1 != null) {

			////// System.out.println(response1);
			status = BusinessOverViewResponse.jsonPath().getString("[0].MerchantKey.Status");
			backend = BusinessOverViewResponse.jsonPath().getString("[0].MerchantKey.Backend");

			// System.out.println(backend.toUpperCase());
			////// System.out.println(status);
			//
			j = j + 1;
			// System.out.println(i);

			if (status.equalsIgnoreCase("Processing")) {
				status = "Active";

			}

		}
		return status;
	}

	// public void isMstatmentEmpty(String mid, int month) {
	// List<String> l = new ArrayList<String>();
	// //String s = "";
	// int year;
	// // boolean result;
	//
	// for (i = 1; i <= 12; i++) {
	// if (i == month && month == 1) {
	//
	// int m1 = 12;
	// int m2 = 11;
	// year = prevYear;
	//
	// // for prev month
	// Response response1 = given().header("Authorization",
	// prop.getProperty("Authorization")).when()
	// .get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year="
	// + year
	// + "&skip=0&limit=25&month=" + m1);
	//
	// // String responseBody1 = response1.getBody().asString();
	//
	// String totalCount1 = response1.jsonPath().getString("totalCount");
	//
	// boolean result_pMonth = totalCount1.equals("0");
	// if (result_pMonth) {
	//
	// l.add(months.get(m1) + prevYear + ", ");
	// a.assertTrue(!result_pMonth);
	// }
	//
	// // for prev to prev month
	// Response response2 = given().header("Authorization",
	// prop.getProperty("Authorization")).when()
	// .get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year="
	// + year
	// + "&skip=0&limit=25&month=" + m2);
	//
	// // String responseBody2 = response2.getBody().asString();
	//
	// String totalCount2 = response2.jsonPath().getString("totalCount");
	//
	// boolean result_ptpMonth = totalCount2.equals("0");
	// if (result_ptpMonth) {
	//
	// l.add(months.get(m2) + year + ", ");
	// a.assertTrue(!result_ptpMonth);
	// }
	//
	// } else if (i == month && month == 2) {
	// int m1 = 1;
	// int m2 = 12;
	//
	// year = this.year;
	//
	// // for prev month
	// Response response1 = given().header("Authorization",
	// prop.getProperty("Authorization")).when()
	// .get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year="
	// + year
	// + "&skip=0&limit=25&month=" + m1);
	//
	// // String responseBody1 = response1.getBody().asString();
	//
	// String totalCount1 = response1.jsonPath().getString("totalCount");
	//
	// boolean result_pMonth = totalCount1.equals("0");
	//
	// if (result_pMonth) {
	//
	// l.add(months.get(m1) + year + ", ");
	// a.assertTrue(!result_pMonth);
	// }
	//
	// year = prevYear;
	//
	// // for prev to prev month
	// Response response2 = given().header("Authorization",
	// prop.getProperty("Authorization")).when()
	// .get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year="
	// + year
	// + "&skip=0&limit=25&month=" + m2);
	//
	// // String responseBody2 = response2.getBody().asString();
	//
	// String totalCount2 = response2.jsonPath().getString("totalCount");
	//
	// boolean result_ptpMonth = totalCount2.equals("0");
	//
	// if (result_ptpMonth) {
	//
	// l.add(months.get(m2) + year + ", ");
	// a.assertTrue(!result_ptpMonth);
	// }
	//
	// } else {
	// if (i == month) {
	// int m1 = i - 1;
	// int m2 = i - 2;
	// year = this.year;
	// // for prev month
	// Response response1 = given().header("Authorization",
	// prop.getProperty("Authorization")).when()
	// .get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year="
	// + year
	// + "&skip=0&limit=25&month=" + m1);
	//
	// // String responseBody1 = response1.getBody().asString();
	//
	// String totalCount1 = response1.jsonPath().getString("totalCount");
	//
	// boolean result_pMonth = totalCount1.equals("0");
	// if (result_pMonth) {
	//
	// l.add(months.get(m1) + year + ", ");
	// a.assertTrue(!result_pMonth);
	// }
	//
	// // for prev to prev month
	// Response response2 = given().header("Authorization",
	// prop.getProperty("Authorization")).when()
	// .get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year="
	// + year
	// + "&skip=0&limit=25&month=" + m2);
	//
	// // String responseBody2 = response2.getBody().asString();
	//
	// String totalCount2 = response2.jsonPath().getString("totalCount");
	//
	// boolean result_ptpMonth = totalCount2.equals("0");
	//
	// if (result_ptpMonth) {
	//
	// l.add(months.get(m2) + year + ", ");
	// a.assertTrue(!result_ptpMonth);
	// }
	// }
	// }
	//
	// }
	//
	// }

	//////////////////////////////////////////////////////

	public String checkMidforlastTwoMonths(String mid) {

		LocalDate today = LocalDate.now();

		int day = today.getDayOfMonth();
		int currentMonth = today.getMonthValue();
		int currentYear = today.getYear();
		List<String> l = new ArrayList<String>();
		String s = "";
		int start = (day <= 10) ? 2 : 1; // start from last-to-last month or last month

		for (int i = start; i < start + 12; i++) {

			int month = currentMonth - i;
			int year = currentYear;

			if (month <= 0) {
				month += 12;
				year -= 1;
			}

			System.out.println("Month: " + month + " Year: " + year);

			Response response1 = given().header("Authorization", prop.getProperty("Authorization")).when()
					.get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year=" + year
							+ "&skip=0&limit=25&month=" + month);

			String totalCount1 = response1.jsonPath().getString("totalCount");

			boolean result_pMonth = totalCount1.equals("0");
			if (result_pMonth) {

				l.add(months.get(month) + year + ", ");
				a.assertTrue(!result_pMonth);
			}

		}

		for (String str : l) {

			s = s.concat(str);
			// s= s.concat(", ");
		}

		return s;
	}

	/////////////////////////////////////////////////////////////
	public String checkMid(String mid) {
		List<String> l = new ArrayList<String>();
		String s = "";

		if (dayOfMonth < 10) {

			// for prev year
			for (int i = 1; i <= 2; i++) {
				if (currentMonth == 1 && currentMonth == 2 && i == 12) {
					continue;
				}

				Response response = given().header("Authorization", prop.getProperty("Authorization")).when()
						.get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year=" + prevYear
								+ "&skip=0&limit=25&month=" + i);

				String responseBody = response.getBody().asString();

				String totalCount = response.jsonPath().getString("totalCount");

				boolean result = totalCount.equals("0");

				if (result) {

					l.add(months.get(i) + prevYear + ", ");
					a.assertTrue(!result);
				}

			}

			// for current year

			for (int m = 1; m < prevMonth; m++) {

				Response response = given().header("Authorization", prop.getProperty("Authorization")).when()
						.get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year=" + year
								+ "&skip=0&limit=25&month=" + m);

				// Response response =
				// given().header("Authorization",prop.getProperty("Authorization"))
				// .when().get(prop.getProperty("MerchantStatmentAPI") + mid
				// + "&role=Merchant&year=" + year + "&month=" + m);

				String totalCount = response.jsonPath().getString("totalCount");
				////// System.out.println(totalCount);

				boolean result = totalCount.equals("0");

				// ////System.out.println(year +" : "+months.get(m));

				if (result) {
					l.add(months.get(m) + year + ", ");
					// test.log(Status.FAIL, "no record available for the month " + year + ":" +
					// months.get(m) + "");
					a.assertTrue(!result);
				}
			}

		} else {

			for (int i = 1; i <= 12; i++) {

				Response response = given().header("Authorization", prop.getProperty("Authorization")).when()
						.get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year=" + prevYear
								+ "&skip=0&limit=25&month=" + i);

				String totalCount = response.jsonPath().getString("totalCount");
				////// System.out.println(totalCount);

				boolean result = totalCount.equals("0");

				if (result) {
					// test.log(Status.FAIL, "no record available for the month " + prevYear + ":" +
					// months.get(i) + "");
					l.add(months.get(i) + prevYear + ", ");
					a.assertTrue(!result);
				}
			}

			for (int m = 1; m < currentMonth; m++) {

				Response response = given().header("Authorization", prop.getProperty("Authorization")).when()
						.get(prop.getProperty("MerchantStatmentAPI") + mid + "&role=SuperAdmin&year=" + year
								+ "&skip=0&limit=25&month=" + m);

				String totalCount = response.jsonPath().getString("totalCount");
				//// System.out.println(totalCount);

				boolean result = totalCount.equals("0");

				// ////System.out.println(year +" : "+months.get(m));

				if (result) {
					// test.log(Status.FAIL, "no record available for the month " + year + ":" +
					// months.get(m) + "");
					l.add(months.get(m) + year + ", ");

					a.assertTrue(!result);
				}
			}

		}

		// }
		// test.log(Status.FAIL, mid+"|Status:"+status+"|"+"No record available for the
		// month " );

		for (String str : l) {

			s = s.concat(str);
			// s= s.concat(", ");
		}

		return s;
	}

	@AfterClass
	public void closeReport() {
		ExtentUtility.quitReport();
	}

}
