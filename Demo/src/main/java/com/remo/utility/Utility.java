package com.remo.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * Utility class providing a collection of common utility methods.
 * 
 * This class contains a variety of utility methods that can be used across the
 * application for performing common tasks, such as different kind of waits,
 * date or time stamp, string processing, mathematical operations, and more.
 * 
 * @author Qa Team
 * 
 *         Usage: 1. Utilize utility methods in this class for common utility
 *         tasks. 2. Create an instance of Utility class to access the utility
 *         common methods.
 * 
 * 
 */
public class Utility {

	/*
	 * WebDriver driver;
	 * 
	 * public Utility() { this.driver = driver; }
	 * 
	 */

	/**
	 * Generates a time stamp in a custom format as a string.
	 *
	 * @return A string for current time stamp
	 */
	public String getTimeStamp() {
		// Instant timestamp = Instant.now();
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd
		// HH.mm.ss.SSS");
		String timestampString = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
		// String timestampString =
		// timestamp.atZone(java.time.ZoneId.systemDefault()).format(formatter);

		return timestampString;
	}

	public void addScreenShotToReport(WebDriver driver, ExtentTest test) {
		String path = takeScreenshot(driver);
		test.addScreenCaptureFromPath(path);

	}

	/**
	 * Takes a screenshot of a specific element and add to the report
	 */
	public void addElementScreenShotToReport(WebDriver driver, WebElement ele, ExtentTest test) {
		String path = takeElementScreenshot(driver, ele);
		test.addScreenCaptureFromPath(path);

	}

	/**
	 * Takes a screenshot of a specific element and saves it to the specified file
	 * path.
	 *
	 * @param driver the WebDriver instance
	 * @param by     the locator of the element
	 * @return the file path where the screenshot was saved
	 */
	public String takeElementScreenshot(WebDriver driver, WebElement element) {
		String directory = System.getProperty("user.dir") + "//Screenshots//SS ";
		TakesScreenshot ss = (TakesScreenshot) element;
		String ssPath = directory + getTimeStamp() + ".png";
		try {
			FileHandler.copy(ss.getScreenshotAs(OutputType.FILE), new File(ssPath));

		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
		return ssPath;
	}

	/**
	 * configure take screenshot
	 */
	public String takeScreenshot(WebDriver driver) {
		String directory = System.getProperty("user.dir") + "//Screenshots//SS ";
		TakesScreenshot ss = (TakesScreenshot) driver;
		String ssPath = directory + getTimeStamp() + ".png";
		try {
			FileHandler.copy(ss.getScreenshotAs(OutputType.FILE), new File(ssPath));

		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
		return ssPath;
	}

	public static String takeScreenshotBase64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}

	public static String takeScreenshotBase64(WebElement element) {
		TakesScreenshot ts = (TakesScreenshot) element;
		return ts.getScreenshotAs(OutputType.BASE64);
	}

	public void addBase64ScreenShotToReport(WebDriver driver, ExtentTest test, String name) {

		try {
			String base64Screenshot = takeScreenshotBase64(driver);
			test.addScreenCaptureFromBase64String(base64Screenshot, name);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void addBase64ScreenShotToReport(WebDriver driver, ExtentTest test) {

		try {
			String base64Screenshot = takeScreenshotBase64(driver);
			test.addScreenCaptureFromBase64String(base64Screenshot);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void addBase64ScreenShotToReport(WebElement ele, ExtentTest test) {

		try {
			String base64Screenshot = takeScreenshotBase64(ele);
			test.addScreenCaptureFromBase64String(base64Screenshot);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void addBase64ScreenShotToReport(WebElement ele, ExtentTest test, String name) {

		try {
			String base64Screenshot = takeScreenshotBase64(ele);
			test.addScreenCaptureFromBase64String(base64Screenshot, name);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * Takes a screenshot of a specific element and saves it to the specified file
	 * path.
	 *
	 * @param driver   the WebDriver instance
	 * @param by       the locator of the element
	 * @param filePath the path to save the screenshot
	 * @throws IOException if an I/O error occurs
	 */
	public static void takeElementScreenshot(WebDriver driver, WebElement element, String filePath) throws IOException {

		// System.out.println("Screenshot saved at: " +
		// destinationFile.getAbsolutePath());
	}

	public String takeScreenshotOfReport(WebDriver driver) {
		String directory = System.getProperty("user.dir") + "//ExtentReports//TestngReport//";
		TakesScreenshot ss = (TakesScreenshot) driver;
		String ssPath = directory + "testngReport.png";
		try {
			FileHandler.copy(ss.getScreenshotAs(OutputType.FILE), new File(ssPath));

		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
		return ssPath;
	}

	public void takeScreenShotOnFailuer(WebDriver driver, ExtentTest test) {
		String path = takeScreenshot(driver);

		test.addScreenCaptureFromPath(path);

	}

	/**
	 * Converts a WebElement into a By locator object.
	 * 
	 * @param
	 * @return
	 */
	public By getByFromWebElement(WebElement element) {
		String elementAsString = element.toString();
		String locatorString = elementAsString.substring(elementAsString.indexOf("-> ") + 3);
		return By.xpath(locatorString);
	}

	public By getByFromWebElement(List<WebElement> element) {
		String elementAsString = element.toString();
		String locatorString = elementAsString.substring(elementAsString.indexOf("-> ") + 3);
		return By.xpath(locatorString);
	}

	public void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	public void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int time) {
		// try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

		// }catch(NoSuchElementException e) {
		// System.out.println("Elements not loaded within time");
		//
		// }
	}

	/**
	 * Waits for a WebElement to become clickable on the web page.
	 *
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Waits for a WebElement to become Present on Dom,
	 *
	 * @param element
	 */
	public void waitForPresenceOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By locator = getByFromWebElement(element);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForPresenceOfAllElement(WebDriver driver, List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By locator = getByFromWebElement(element);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * Waits for the visibility of a WebElement on the web page with a custom
	 * timeout.
	 *
	 * @param element
	 * @param timeoutInSeconds
	 * 
	 */
	public void waitForElementWithPollingFrequency(WebDriver driver, WebElement element, int timeoutInSeconds,
			int pollingFrequency) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingFrequency))
				.ignoring(org.openqa.selenium.NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Generates a random string by appending a random number to the prefix
	 * "screenShot".
	 *
	 * @return
	 */
	public String randomString() {
		String randomNumber = "ScreenShot" + Math.random();
		return randomNumber;

	}

	/**
	 * Waits for the web page URL to match the expected URL.
	 *
	 * @param driver
	 * @param expectedUrl
	 */
	public void waitForUrlToLoad(WebDriver driver, String expectedUrl) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(expectedUrl));

	}

	/**
	 * Waits for the web page title to contain the specified text.
	 *
	 * @param title
	 */
	public void waitForTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * Waits for the visibility of a WebElement on the web page with a custom
	 * timeout and polling frequency.
	 * 
	 * @param element
	 * @param timeoutInSeconds
	 * @param freq
	 */

	public void waitForElementWithFrequency(WebDriver driver, WebElement element, int timeoutInSeconds, int freq) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(freq)) // Adjust the polling interval as needed
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Waits till presence of element on DOM using locator.
	 *
	 * @param title
	 */
	public void waitForPresenceOfElementByLocator(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	/**
	 * Waits till DOM is loaded completely using JavaScriptExecutor command
	 */
	public void waitForDomToLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	}

	/**
	 * Waits till expected condition expected condition with Lambda expression
	 */
	public void customWaitBeforeClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		ExpectedCondition<Boolean> condition = webDriver -> element.isEnabled() && element.isDisplayed(); /// lambda
																											/// expression

		// Wait until the condition is true before clicking the button
		wait.until(condition);
	}

	/**
	 * Custom wait till expected condition is true with frequency 500 ms.
	 * 
	 */

	public void customWaitForElementIsDisplayed(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 40) {
			try {
				// System.out.println("CW isDisplayed() is working");
				element.isDisplayed();
				break;
			} catch (Throwable e) {
				Thread.sleep(500);
				count++;
			}
		}
	}

	/**
	 * Waits for the visibility of a WebElement on the web page with a custom
	 * timeout.
	 *
	 * @param element
	 * @param timeoutInSeconds
	 * 
	 */
	public void waitForElementIgnoringTime(WebDriver driver, WebElement element, int timeoutInSeconds) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(500)).ignoring(TimeoutException.class);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Moves the mouse pointer to the specified WebElement using the Actions class.
	 *
	 * @param driver
	 * @param ele    The WebElement to which the mouse pointer will be moved.
	 */
	public void moveToELement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

	}

	public void moveTohalfsideOfanElement(WebDriver driver, WebElement element, String side) {
		Actions actions = new Actions(driver);
		int elementWidth = element.getSize().getWidth();
		int elementHeight = element.getSize().getHeight();
		// int yOffset = elementHeight /2; // Center vertically
		/// \ int yOffset = elementHeight * 3/4; // Center vertically
		int yOffset = elementHeight / 4; // Center vertically
		// int yOffset = elementHeight ;
		int centerXOffset = elementWidth / 2;

		if (side.equalsIgnoreCase("left")) {
			int leftHalfXOffset = elementWidth / 4; // Move to a quarter width to be in the left half

			actions.moveToElement(element, leftHalfXOffset, yOffset).perform();
		} else if (side.equalsIgnoreCase("right")) {
			// Hover over the right half
			int rightHalfXOffset = (3 * elementWidth) / 4; // Move to three-quarters width to be in the right half

			actions.moveToElement(element, rightHalfXOffset, yOffset).perform();

		} else {
			actions.moveToElement(element, centerXOffset, yOffset).perform();
		}

	}

	public void moveToQuarterOfElement(WebDriver driver, WebElement element, String position) {

		Actions actions = new Actions(driver);

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		int x = 0;
		int y = 0;

		switch (position.toLowerCase()) {

			case "top-left":
				x = -(width / 4);
				y = -(height / 4);
				break;

			case "top-right":
				x = width / 4;
				y = -(height / 4);
				break;

			case "bottom-left":
				x = -(width / 4);
				y = height / 4;
				break;

			case "bottom-right":
				x = width / 4;
				y = height / 4;
				break;
		}

		actions.moveToElement(element, x, y).perform();
	}

	public void waitForVisibilityOfElement(WebDriver driver, WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public WebElement waitForVisibilityOfElementWithWait(WebDriver driver, WebElement e, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(e));
	}

	public WebElement waitForVisibilityOfElementLocatorWithWait(WebDriver driver, String e, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
	}

	public void waitForInvisibilityOfElement(WebDriver driver, WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(e));
	}

	public void waitForInvisibilityOfElementWithWait(WebDriver driver, WebElement e, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(e));
	}

	public void waitForInvisibilityOfElementByxpathLocator(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForInvisibilityOfElementByCSSLocator(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
	}

	public int getRandomenumber(int upperlimit) {
		int upperBound = upperlimit;
		Random random = new Random();
		return random.nextInt(upperBound);

	}
	// public static void main(String[] args) {
	// System.out.println(getRandomenumber(16));
	// }

	/**
	 * Scrolls to bring the specified WebElement into the view using
	 * JavaScriptExecutor.
	 *
	 * @param driver
	 * @param element
	 */
	public void scrollHandle(WebDriver driver, WebElement element) {
		element.getLocation();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
		// element);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block: 'center'});", element);
	}

	public void scrollHandleEndOfTheElement(WebDriver driver, WebElement element) {
		element.getLocation();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
		// element);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block: 'end'});", element);
	}

	public void hoverOnElementInView(WebDriver driver, WebElement element) {
		// Scroll the element to the center of the screen
		((JavascriptExecutor) driver).executeScript(
				"const elementRect = arguments[0].getBoundingClientRect();" +
						"const absoluteElementTop = elementRect.top + window.pageYOffset;" +
						"const middle = absoluteElementTop - (window.innerHeight / 2);" +
						"window.scrollTo({top: middle, behavior: 'smooth'});",
				element);

		// Perform hover action using Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void hoverOnElement(WebDriver driver, WebElement element) {
		// // Scroll the element to the center of the screen
		// ((JavascriptExecutor) driver).executeScript(
		// "const elementRect = arguments[0].getBoundingClientRect();" +
		// "const absoluteElementTop = elementRect.top + window.pageYOffset;" +
		// "const middle = absoluteElementTop - (window.innerHeight / 2);" +
		// "window.scrollTo({top: middle, behavior: 'smooth'});",
		// element);

		// Perform hover action using Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void forceClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public Actions getActionObject(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	/**
	 * Switches the WebDriver focus to the specified window by its index.
	 *
	 * @param driver
	 * @param windowIndex The index of the window to switch to (0-based index).
	 */
	public void windowHandle(WebDriver driver, int windowIndex) {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(windowIndex));
	}

	/**
	 * Switches the focus of the WebDriver to the newly opened window.
	 *
	 * @param driver
	 */
	private String parentWindowID;

	public void switchToNewlyOpenedWindow(WebDriver driver) {
		parentWindowID = driver.getWindowHandle();
		Set<String> AllWindowIDs = driver.getWindowHandles();
		for (String winID : AllWindowIDs) {
			if (!(winID.equals(parentWindowID))) {
				driver.switchTo().window(winID);
			}
		}

	}

	/**
	 * Switches to the window with the specified expected page title.
	 *
	 * @param driver
	 * @param expectedPageTitle The expected title of the window to switch to.
	 */
	public void switchToWindowWithTitle(WebDriver driver, String expectedPageTitle) {

		parentWindowID = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (!(driver.getTitle().contains(expectedPageTitle))) {
				continue;
			} else {
				break;
			}
		}
	}

	/**
	 * Switches the focus of the WebDriver back to the parent window.
	 *
	 * @param driver The WebDriver instance for window handling.
	 */
	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(parentWindowID);
	}

	/**
	 * Close the current window
	 * 
	 * @param driver
	 */
	public void closeWindow(WebDriver driver) {
		driver.close();
	}

	Select s;

	public void selectDropdownByValue(WebElement e, String value) {
		s = new Select(e);
		s.selectByValue(value);

	}

	public void selectDropdownByIndex(WebElement e, int index) {
		s = new Select(e);
		s.selectByIndex(index);

	}

	public void selectDropdownByVisibleText(WebElement e, String text) {
		s = new Select(e);
		s.selectByVisibleText(text);

	}

	public List<WebElement> getSelectOptions(WebElement e) {
		s = new Select(e);

		return s.getOptions();

	}

	public void deselectAll(WebElement e) {
		s = new Select(e);
		s.deselectAll();
	}

	public void setWindowResolution(WebDriver driver, int zoomResolution) {
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '" + zoomResolution + "%';");

			// Actions actions = new Actions(driver);

			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys("-").keyUp(Keys.CONTROL).build().perform();
			// actions.sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();

		} catch (Exception e) {

		}
	}

	public void ZoomOutUsingKeyboard(WebDriver driver, int count) {
		try {

			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).perform();

			for (int i = 1; i <= count; i++) {
				actions.sendKeys(Keys.SUBTRACT).perform();
			}

			actions.keyUp(Keys.CONTROL).perform();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	public WebElement getSelectedOption(WebDriver driver, WebElement e) {
		waitForVisibilityOfElement(driver, e);
		s = new Select(e);
		return s.getFirstSelectedOption();
	}

	public List<WebElement> getAllOption(WebElement e) {
		s = new Select(e);
		return s.getOptions();
	}

	LocalDate currentDate = LocalDate.now();
	int currentYear = currentDate.getYear();
	int currentMonth = currentDate.getMonthValue();
	int prevMonth = currentMonth - 1;
	int prevYear = currentYear - 1;
	int dayOfMonth = currentDate.getDayOfMonth();

	public String getCurrentYear() {
		return "" + currentYear;
	}

	public int getIntCurrentYear() {
		return currentYear;
	}

	public String getCurrentMonthNum() {
		return "" + currentMonth;
	}

	public int getIntCurrentMonthNum() {
		return currentMonth;
	}

	public String getCurrentDayOfMonth() {
		return "" + dayOfMonth;
	}

	public int getIntCurrentDayOfMonth() {
		return dayOfMonth;
	}

	public String getPrevYear() {
		return "" + prevYear;
	}

	public int getIntPrevYear() {
		return prevYear;
	}

	public String getPrevMonth() {
		if (currentMonth == 1) {
			prevMonth = 12;
		}
		return "" + prevMonth;
	}

	public int getIntPrevMonth() {
		if (currentMonth == 1) {
			prevMonth = 12;
		}
		return prevMonth;
	}

	public List<String> months;

	public String getMonthShortName(int monthNum) {
		months = Arrays.asList("", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec");
		return months.get(monthNum);
	}

	public List<String> getMonthListTillDate() {
		List<String> monthList = new ArrayList<String>();
		int i = 1;
		int monthNum = getIntCurrentMonthNum();

		while (i <= monthNum) {
			// System.out.println(getMonthShortName(i));
			monthList.add(getMonthShortName(i));
			i++;
		}
		return monthList;
	}

	public String getMonthName(int monthNum) {

		months = Arrays.asList("", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		return months.get(monthNum);
	}

	public List<String> getMonthList() {

		months = Arrays.asList("Select Month", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		return months;
	}

	public boolean checkBrokenImages(WebDriver driver, ExtentTest test) {

		try {
			int brokenImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));

			for (WebElement imgElement : imagesList) {
				// scrollHandle(driver, imgElement);
				if (imgElement != null) {
					try {
						HttpClient client = HttpClientBuilder.create().build();

						// HttpGet request = new HttpGet(imgElement.getAttribute("src"));
						// HttpResponse response = client.execute(request);
						//
						// // verifying response code he HttpStatus should be 200 if not,
						// // increment as invalid images count
						String src = imgElement.getAttribute("src");

						if (src == null || src.isEmpty()) {
							System.out.println("Broken image: src is empty");
							continue;
						}

						int responseCode = getResponseCode(src, test);

						// if (responseCode >= 400) {
						// System.out.println("Broken image: " + src
						// + " | Response Code: " + responseCode);
						// } else {
						// System.out.println("Valid image: " + src
						// + " | Response Code: " + responseCode);
						// }

						if (responseCode >= 400) {

							brokenImageCount++;
							addBase64ScreenShotToReport(driver, test, "Broken Image" + brokenImageCount);

						}
					} catch (Exception e) {
						e.printStackTrace();
						test.log(Status.FAIL, "Failed to send the request ");

						// System.out.println(imgElement.getAttribute("alt"));
						// brokenImageCount++;
						continue;

					}
				}
			}
			if (brokenImageCount == 0) {
				test.log(Status.PASS, "No Broken Images");
				return true;
			} else {
				test.log(Status.FAIL, "Broken image found: " + brokenImageCount);
				return false;
			}

		} catch (Exception e) {
			// e.printStackTrace();
			test.log(Status.FAIL, "Broken Image validation failed");
			return false;

		}

	}

	public static int getResponseCode(String src, ExtentTest test) {

		try {
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("Get");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			connection.connect();

			return connection.getResponseCode();

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed to send the request ");
			return 500;

		}
	}

	public void uploadFileWithRobot(WebDriver driver, String filePath, WebElement fileUploadArea) {
		try {
			// Ensure the path is absolute
			File file = new File(filePath);
			String absolutePath = file.getAbsolutePath();

			// Wait briefly to ensure the native OS window has opened after the Selenium
			// click
			Thread.sleep(1000);

			// Ensure the file path is absolute, as required by Selenium

			// Wait for the element to be present
			waitForVisibilityOfElement(driver, fileUploadArea);
			fileUploadArea.click();

			Thread.sleep(1000);

			// Simulate the key events to paste the path and press Enter
			StringSelection stringSelection = new StringSelection(absolutePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			// Instantiate the Robot class
			Robot robot = new Robot();

			// Simulate the key events to paste the path and press Enter
			// Press Ctrl+V (Cmd+V on Mac)
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Wait for the path to paste
			Thread.sleep(1000);

			// Press Enter to confirm the selection (clicks 'Open' or 'Choose')
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			System.out.println("File successfully uploaded using Robot class: " +
					absolutePath);

		} catch (AWTException | InterruptedException e) {
			System.err.println("Failed to upload file using Robot class.");
			e.printStackTrace();
		}
	}

	public void uploadFileWithSendKeys(WebDriver driver, WebElement uploadAreia, String filePath) {
		try {
			// Ensure the file path is absolute, as required by Selenium
			File file = new File(filePath);
			String absolutePath = file.getAbsolutePath();

			// Wait for the element to be present
			waitForVisibilityOfElement(driver, uploadAreia);
			uploadAreia.click();

			By locator = By.xpath("//input[@type='file']");

			WebElement fileInput = driver.findElement(locator);
			// Send the absolute path to the input element
			fileInput.sendKeys(absolutePath);
			System.out.println("File successfully uploaded using sendKeys: " + absolutePath);

		} catch (Exception e) {
			System.err.println("Failed to upload file using sendKeys for locator:");
			e.printStackTrace();
		}
	}

	public void scrollHandleEndOfThePage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	//
	// public static void waitForTheExcelFileToDownload(String fileName, int
	// timeWait)
	// throws IOException, InterruptedException {
	// String downloadPath = getSystemDownloadPath();
	// File dir = new File(downloadPath);
	// File[] dirContents = dir.listFiles();
	//
	// for (int i = 0; i < 3; i++) {
	// if (dirContents[i].getName().equalsIgnoreCase(fileName)) {
	// break;
	// }else {
	// Thread.sleep(timeWait);
	// }
	// }
	// }

	// public void navigateToUrl(String url) {
	// driver.navigate().to(url);
	// }

	// public void navigateBack() {
	// driver.navigate().back();
	// }

	// public void navigateForward() {
	// driver.navigate().forward();
	// }

	// public void refreshPage() {
	// driver.navigate().refresh();
	// }

	// public String getCurrentUrl() {
	// return driver.getCurrentUrl();
	// }

	// public String getPageTitle() {
	// return driver.getTitle();
	// }
}
