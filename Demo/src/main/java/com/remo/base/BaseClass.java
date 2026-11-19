package com.remo.base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.remo.PageLayer.Dashboard;
import com.remo.PageLayer.PartnerHub;
import com.remo.PageLayer.ReportsPage;
import com.remo.driverManager.DriverManager;
import com.remo.reader.ConfigUtil;
import com.remo.reader.ExcelFileReader;
import com.remo.utility.Utility;

/**
 * This class provides a foundation for all page classes. It contains common
 * properties and object variables of all the classes that are used across
 * multiple classes of the application.
 * 
 * @author Remosys Testing Team.
 *         Usage: 1. Extend this class when creating specific
 *         page classes for different web pages.
 * 
 *         2. Implement page-specific elements and methods in the derived
 *         classes.
 *
 */

public class BaseClass {

	public WebDriver driver;
	public ExcelFileReader excel;
	public Utility util;
	public ConfigUtil prop;
	public DriverManager manager;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public static ExtentSparkReporter spark1;

	public Dashboard dashboard;
	public ReportsPage reportsP;
	public PartnerHub partnerH;

}