package pages.AgentPortal;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.pages.BasePage.Page;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

public class AgentPortalHomePage extends Page {


	//OBJECTS

	@FindBy(xpath="")
	WebElement confidentialLink;

	@FindBy(xpath="//div[@data-toggle='dropdown']")
	WebElement personIcon;

	@FindBy(xpath="")
	WebElement myProfile;
	
	@FindBy(xpath="//div[contains(text(), ' Logout ')]")
	WebElement logout;

	@FindBy(xpath ="//a[@class='main-menu-item' and @data-cy='STRKEY_ADMIN']")
	WebElement administrationTab;

	String administrationTabXpath = "//a[@class='main-menu-item' and @data-cy='STRKEY_ADMIN']";

	@FindBy(xpath ="//a[@class='main-menu-item' and @data-cy='STRKEY_TRANSACT']")
	WebElement transactTab;

	String transactTabXpath = "//a[@class='main-menu-item' and @data-cy='STRKEY_TRANSACT']";

	public WebElement getTransactTabAfterSend() {	return transactTabAfterSend; }

	@FindBy(xpath = "//a[@class='nav-link' and contains(text(), 'Transact')]")
	WebElement transactTabAfterSend;

	@FindBy(xpath="//strong[contains(text(), ' Latest News')]")
	WebElement latestNews;

	@FindBy(xpath = "//button[@class='btn mx-5 btn-success hover-shadow']")
	WebElement deviceContinue;

	@FindBy(xpath = "//button[contains(text(), 'Authenticate Code')]")
	WebElement authenticationCode;

	@FindBy(xpath = "//*[@id='mat-dialog-3']/fp-tellerotp/div/div[1]/div/fa-icon")
	WebElement close;

	@FindBy(xpath = "//button[contains(text(), 'Yes')]")
	WebElement yesButton;

	@FindBy(xpath = "//input[@type='text' and @name='devicename']")
	WebElement deviceNameTextField;

	@FindBy(xpath = "//button[@type='button' and @data-cy='btn_next']")
	WebElement deviceNextButton;

	@FindBy(xpath = "//button[@type='button' and @data-cy='btn_done']")
	WebElement doneButton;


	//CONSTRUCTOR
	public AgentPortalHomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
	}

	//METHODS

	public void clickConfidentialLink() {
		confidentialLink.click();
	}

	public void clickProfileIcon() {
		personIcon.click();
	}	

	public void clickMyProfile() {
		myProfile.click();
	}
	
	public void clickLogout() {
		logout.click();
	}


	/**
	 * Method to click on admin tab
	 */
	public void clickAdministrationTab() throws InterruptedException {
		staleElementHandling(administrationTabXpath, 15);
//		isElementDisplayed(administrationTab, 15);
//		retryingFind(administrationTabXpath);
		Thread.sleep(3000);
		Assert.assertTrue(isElementDisplayed(administrationTab, timeToWait));
		administrationTab.click();
	}

	/**
	 * Method to click on transact
	 */
	public void clickTransact() throws InterruptedException {
		retryingFind(transactTabXpath);
		staleElementHandling(transactTabXpath, 10);
		Thread.sleep(3000);
		transactTab.click();
	}

	public void isTransactEnabled() throws InterruptedException {
		retryingFind(transactTabXpath);
		staleElementHandling(transactTabXpath, 10);
		Thread.sleep(3000);
		if(isElementDisplayed(transactTab, 20)){
			transactTab.click();
		}
	}

	/**
	 * Method to enter device name and click on done
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void enterRegisterDevice() throws InterruptedException, AWTException {
		if(isElementDisplayed(deviceContinue, 30)){
			deviceContinue.click();
		}
		Assert.assertTrue(isElementDisplayed(deviceNameTextField, timeToWait));
		deviceNameTextField.sendKeys(System.getProperty("user.name")+"_device");
		Assert.assertTrue(isElementDisplayed(deviceNextButton, timeToWait));
		deviceNextButton.click();
		Assert.assertTrue(isElementDisplayed(doneButton, timeToWait));
		doneButton.click();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void enterRegisterDeviceRetailAgent() throws InterruptedException, AWTException {
		if(isElementDisplayed(deviceContinue, 30)){
			deviceContinue.click();
		}
		Assert.assertTrue(isElementDisplayed(deviceNameTextField, timeToWait));
		deviceNameTextField.sendKeys(System.getProperty("user.name")+"_device");
		Assert.assertTrue(isElementDisplayed(deviceNextButton, timeToWait));
		deviceNextButton.click();
		Assert.assertTrue(isElementDisplayed(authenticationCode, timeToWait));
		Assert.assertTrue(isElementDisplayed(close, timeToWait));
		close.click();
		yesButton.click();

	}

	/**
	 * Method to logout
	 */
	public void logout() {
		Assert.assertTrue(isElementDisplayed(personIcon, timeToWait));
		personIcon.click();
		Assert.assertTrue(isElementDisplayed(logout, timeToWait));
		logout.click();		
	}

	/**
	 *
	 * @param element
	 * @param waitForElement
	 * @return
	 */
	public static boolean isElementDisplay(WebElement element, int waitForElement){
		boolean isElementDisplayed = false;
		Instant start = Instant.now();
		while (!isElementDisplayed) {
			try {
				if(element.isDisplayed()){
					isElementDisplayed = true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("this element being checked Will wait specified time for element to be visible.");
			}
			Instant end = Instant.now();
			long secondsPassed = Duration.between(start, end).getSeconds();
			if(secondsPassed > waitForElement){
				break;
			}
		}
		System.out.println(isElementDisplayed);
		return  isElementDisplayed;
	}


}
