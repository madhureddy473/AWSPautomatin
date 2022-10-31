package pages.AgentPortal;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.pages.BasePage.Page;

public class AgentPortalLoginPage extends Page {
	
	//OBJECTS
	
	@FindBy(xpath="//input[@name='usernameInput']")
	WebElement userIdField;
	
	@FindBy(xpath="//input[@name='passwordInput']")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInButton;
	
	//CONSTRUCTOR
	public AgentPortalLoginPage(WebDriver driver) {
		
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

	public void login(String text, String text2) {
		reloadPage();
		Assert.assertTrue(isElementDisplayed(userIdField, timeToWait));
		userIdField.sendKeys(text);
		Assert.assertTrue(isElementDisplayed(passwordField, timeToWait));
		passwordField.sendKeys(text2);
		Assert.assertTrue(isElementDisplayed(signInButton, timeToWait));
		signInButton.click();
		
	}
}
