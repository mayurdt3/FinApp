package com.remo.Test;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Abc {
	public static void main(String[] args) { // Initialize the Chrome driver

		WebDriver driver = new ChromeDriver();

		// Open the application
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
			driver.get("https://hindustantimes.com");
		} catch (TimeoutException e) {
			// TODO: handle exception
			System.out.println("page not loaded in time");
		}

	}
}
