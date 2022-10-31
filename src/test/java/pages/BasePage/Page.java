package test.java.pages.BasePage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import main.java.api.restAPI.GetPropertiesFromSysOrConfig;
import main.java.api.restAPI.TestRailsIntegration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;
import utilities.ExcelUtil;

public class Page {
	protected static WebDriver driver;
	public ExcelUtil write;

	static String dateFormat = "yyyy" + "_" + "MM" + "_" + "dd" + "__" + "a_hh_mm_ss";
	static DateTimeFormatter dtForm = DateTimeFormatter.ofPattern(dateFormat);
	static LocalDateTime current = LocalDateTime.now();

	public static int timeToWait ;

	public void setTimeToWait(int time){
		Page.timeToWait = time;
	}

	public void setWebDriver(WebDriver driver) {
		Page.driver = driver;
	}

	/************* Added for test rail ******************/

	public static String currentRunID;
	public static String currentEntryID;
	public static ExtentTest test;
	private String testRailsTestCaseUniqueID;
	private boolean isTestCaseIDValid;
	public static final TestRailsIntegration railsIntegration = new TestRailsIntegration();

	 /********************** End *****************/

	public WebElement findElementUsingText(String searchText)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+searchText+"')]"));
	}

	public void selectDdlByText(WebElement locator, String optionToSelect) {
		try {
			Select sel = new Select(locator);
			sel.selectByVisibleText(optionToSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElementDoubleClick(WebElement locator) {
		Actions a = new Actions(driver);
		a.moveToElement(locator).
		doubleClick().
		build().perform();
	}

	public void getScreenShot() throws Exception
	{
		String filename = dtForm.format(current)  +  ".png";
		String directory = Constants.screenshots.concat(File.separator+"screenShots" + File.separator).concat(Year.now() + File.separator).concat(LocalDate.now().getMonthValue() + File.separator).
				concat(LocalDate.now().getDayOfMonth() + File.separator);;
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public boolean verifyTextPresent(String text1){
		if (driver.getPageSource().contains(text1)) 
			return true;
		else
			return false;
	}
	
	public void robotPageDownAndEnter(WebElement locator, String text) throws AWTException, InterruptedException {
		locator.sendKeys(text);
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);  
		Thread.sleep(2000);
		locator.sendKeys(Keys.ENTER);
	}

	public void textSuggestAndEnter(WebElement locator, String text){
		locator.sendKeys(text);
		locator.sendKeys(Keys.ENTER);
	}

	public void waitElementIsClickable(WebElement locator) {
	      // explicit wait condition
	      WebDriverWait w = new WebDriverWait(driver,4);
	      w.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public class WebElementWait  extends FluentWait<WebElement>  {
	    public final static long DEFAULT_SLEEP_TIMEOUT = 500;

	      public WebElementWait(WebElement element, long timeOutInSeconds) {
	            this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
	      }

	      public WebElementWait(WebElement element, long timeOutInSeconds, long sleepInMillis) {
	            this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
	      }

	      protected WebElementWait(WebElement element, Clock clock, Sleeper sleeper, long timeOutInSeconds,
	              long sleepTimeOut) {
	            super(element, clock, sleeper);
	            withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
	            pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
	            ignoring(NotFoundException.class);
	      }

	}

	public static boolean retryingFind(String element) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 2) {
			try {
				driver.findElement(By.xpath(element));
				result = true;
				break;
			} catch(StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	/**
	 * Method to wait for the element to be visible and click
	 * @param webElement
	 */
	public static void waitForElementToBeVisibleAndClick(String webElement){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
		element.click();
	}

	/**
	 * Method to reload the page
	 */
	public void reloadPage(){
		driver.navigate().refresh();
	}

	/**
	 * Method to wait for an element to be displayed
	 * @param element web element
	 * @param time time to wait looking for the element
	 * @return
	 */
	public static boolean isElementDisplayed(WebElement element, int time){
		int timeToWaitForElement = time;
		boolean isElementDisplayed = false;
		Instant start = Instant.now();
		while (!isElementDisplayed) {
			try {
				if(element.isDisplayed()){
					isElementDisplayed = true;
					highlightElement(element);
				}
			} catch (NoSuchElementException e) {
				System.out.println("this element being checked Will wait specified time for element to be visible." + element);
			}
			Instant end = Instant.now();
			long secondsPassed = Duration.between(start, end).getSeconds();
			if(secondsPassed > timeToWaitForElement){
				break;
			}
		}
		return  isElementDisplayed;
	}

	public static void highlightElement(WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", we, "border: 3px solid red;");
	}

	public static void highlightElement(By element) {
		WebElement we = driver.findElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", we, "border: 3px solid red;");
	}

	public static WebElement staleElementHandling(String xPathElement, int timeToWaitForElement){
		boolean isElementStale = true;
		WebElement webElementUnderTest = null;
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Instant start = Instant.now();
		while(isElementStale) {
			try {
				webElementUnderTest = driver.findElement(By.xpath(xPathElement));
				highlightElement(By.xpath(xPathElement));
				isElementStale = false;
			} catch (StaleElementReferenceException e) {
				driver.navigate().refresh();
				System.out.println("Stale element ");
			} catch (NoSuchElementException e) {
				System.out.println("StaleElementHandling: this element being checked for staleness is not visible.");
				isElementStale = false;
			}
			Instant end = Instant.now();
			long secondsPassed = Duration.between(start, end).getSeconds();
			if(secondsPassed > timeToWaitForElement && isElementStale){
				break;
			}
		}
		return webElementUnderTest;
	}


	/**
	 * Method to scroll up and down
	 * @param scroll scroll type
	 * @throws AWTException
	 */
	public void scrollPage(String scroll) throws AWTException {
		switch (scroll){
			case "DOWN":
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			case "UP":
				Robot robot1 = new Robot();
				robot1.keyPress(KeyEvent.VK_PAGE_UP);
				robot1.keyRelease(KeyEvent.VK_PAGE_UP);
		}
	}

	/**
	 * Method to check if element is clickable or not
	 * @param element Web element
	 * @param time amount of time to wait looking for element
	 * @return boolean
	 */
	public static boolean ifElementIsClickable(WebElement element, int time) {
		try {
			WebDriverWait w = new WebDriverWait(driver, time);
			w.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}
		catch (Exception e){
			return false;
		}
	}


	public void currentTestScenarioIsSupportedByApplication(String testCaseTitle_TestRails, String testCaseID_TestRails) {
		testCaseTitle_TestRails = testCaseTitle_TestRails.replaceAll(" ", "");

		System.out.println("Currently running TestRails TestCase with title: " + testCaseTitle_TestRails + " and TestCase ID: " + testCaseID_TestRails);
		testRailsTestCaseUniqueID = testCaseID_TestRails;

		isTestCaseIDValid = railsIntegration.checkIfCaseIDExists(testCaseID_TestRails, test);

		if(!(testCaseID_TestRails.contains("NOT_A_TEST_CASE") || testCaseID_TestRails.contains("not a test") || testCaseID_TestRails.contains("blank"))) {
			if(isTestCaseIDValid) {
				if(new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("usingTestPlan").equalsIgnoreCase("false")) {
					railsIntegration.updateRunWithCase(testCaseID_TestRails, currentRunID, test);
				} else {
					railsIntegration.updatePlanEntryWithCase(testCaseID_TestRails, currentEntryID, test);
				}
			}
		}

	}
}
