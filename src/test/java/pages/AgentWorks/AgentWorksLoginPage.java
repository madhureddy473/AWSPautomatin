package pages.AgentWorks;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.pages.BasePage.Page;

import java.awt.*;
import java.awt.event.KeyEvent;


public class AgentWorksLoginPage extends Page {
	
	//OBJECTS
	
	@FindBy(xpath="//input[@name='usernameInput']")
	WebElement userIdField;
	
	@FindBy(xpath="//input[@name='passwordInput']")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInButton;

	@FindBy(xpath = "//a[contains(text(), 'Terms of Use')]")
	WebElement termsOfUse;

	@FindBy(xpath = "//strong[contains(text(), 'AgentPortal, AgentReporting, and AgentWorks TM Terms of Use')]")
	WebElement termsOfUsePage;

	@FindBy(xpath = "//span[contains(text(), 'Locations')]")
	WebElement findALocation;

	@FindBy(xpath = "//*[@id='inputaddress']")
	WebElement inputAddress;

	@FindBy(xpath = "//*[@id='locator_submit']")
	WebElement searchLocator;

	@FindBy(xpath = "(//*[@id='collection_poi']/tbody/tr[1]/td[2]/div[5])[1]")
	WebElement searchResults;
	
	//CONSTRUCTOR
	public AgentWorksLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//METHODS
	
	public void enterUserId(String text) {
		userIdField.sendKeys(text);
	}
	
	public void enterPassword(String text) {
		passwordField.sendKeys(text);
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}

	/**
	 * Method to login
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) throws InterruptedException, AWTException {
		try {
			Thread.sleep(5000);
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_ESCAPE);
			robo.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(3000);
		} finally {
			Assert.assertTrue(isElementDisplayed(userIdField, timeToWait));
			userIdField.sendKeys(userName);
			Assert.assertTrue(isElementDisplayed(passwordField, 3));
			passwordField.sendKeys(password);
			Assert.assertTrue(isElementDisplayed(signInButton, 3));
			signInButton.click();
		}
	}

	/**
	 * Method to click on terms of use
	 */
	public void termsOfUse(){
		termsOfUse.click();
		if(isElementDisplayed(termsOfUsePage, 15)) {
			Assert.assertTrue(termsOfUsePage.getText().equalsIgnoreCase("AgentPortal, AgentReporting, and AgentWorks TM Terms of Use"));
		}
	}

	public void findALocation() throws InterruptedException {
		findALocation.click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		inputAddress.clear();
		inputAddress.sendKeys("75034");
		searchLocator.click();
		driver.switchTo().window(winHandleBefore);

	}

	public void testRail(String testCaseTitle_TestRails, String testCaseID_TestRails){
		currentTestScenarioIsSupportedByApplication(testCaseTitle_TestRails, testCaseID_TestRails);
	}
}
