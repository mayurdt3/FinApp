package com.remo.driverManager;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.remo.base.BaseClass;

/**
 * DriverManager is a utility class that extends BaseClass and manages the
 * initialization and retrieval of WebDriver instances for various browsers.
 * 
 * 
 */

public class DriverManager extends BaseClass {

	/**
	 * Constructor for DriverManager class.
	 * 
	 * @param driver WebDriver instance used for browser interactions.
	 */
	public DriverManager(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will Initializes the WebDriver instance on the specified browser
	 * name. reference for the selected browser Supported browsers: Chrome, Firefox,
	 * Internet Explorer, Edge
	 * 
	 * @param browserName
	 * @return driver
	 * @throws IOException
	 */

	public WebDriver initializeDriver(String browser, boolean headless) {
		switch (browser.toLowerCase()) {
			case "chrome":

				if (headless) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					driver = new ChromeDriver(options);
				} else {

					String downloadFilepath = System.getProperty("user.dir") + "\\Downloads\\";
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadFilepath);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", chromePrefs);

					// options.addArguments("--incognito");
					options.addArguments("--test-type");
					options.addArguments("--disable-infobars"); // Disables the "Chrome is being controlled by automated
																// test software" info bar
					options.addArguments("--disable-notifications"); // Disables notifications
					options.addArguments("--disable-extensions"); // Disables extensions to avoid unnecessary
																	// notifications

					options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

					driver = new ChromeDriver(options);

					// driver = new ChromeDriver();
				}

				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		return driver;
	}

	/**
	 * This method returns the current WebDriver instance.
	 * 
	 * @return The current WebDriver instance.
	 */
	public WebDriver getDriver() {

		return driver;
	}

}
