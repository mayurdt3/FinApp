package com.remo.base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.remo.PageLayer.API;
import com.remo.PageLayer.Dashboard;
import com.remo.PageLayer.HomePage;
import com.remo.PageLayer.Locations;
import com.remo.PageLayer.ProductInformationPage;
import com.remo.PageLayer.ProfileSettingPage;
import com.remo.PageLayer.ReportsPage;
import com.remo.PageLayer.SupportPage;
import com.remo.PageLayer.Users;
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
	public com.remo.PageLayer.LoginPage login;
	public HomePage home;
	public ReportsPage reportsP;
	public API api;
	// public MMAPI mmApi;
	public SupportPage support;
	public ProductInformationPage productInfo;
	public ProfileSettingPage profile;
	public Users user;
	public Locations location;

}