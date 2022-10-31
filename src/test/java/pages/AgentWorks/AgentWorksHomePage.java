package pages.AgentWorks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.pages.BasePage.Page;

public class AgentWorksHomePage extends Page {


	//OBJECTS

	@FindBy(xpath="")
	WebElement confidentialLink;

	@FindBy(xpath="//i[@class='fa fa-user login mg-font-size-36']")
	WebElement personIcon;

	@FindBy(xpath="")
	WebElement myProfile;

	@FindBy(xpath="//i[@class='mg-font-size-20 align-middle fas fa-sign-out-alt']")
	WebElement logout;

	@FindBy(id="oldPasswordControl")
	WebElement oldPassword;

	@FindBy(id="newPasswordControl")
	WebElement newPassword;

	@FindBy(id="confirmPasswordControl")
	WebElement confirmPassword;

	@FindBy(xpath="//button[@type='submit']")
	WebElement changePasswordBtn;
	
	@FindBy(xpath="//a/span[contains(text(), ' Transact')]")
	WebElement transactTab;
	
	@FindBy(tagName="body")
	WebElement refresh;



	//CONSTRUCTOR
	public AgentWorksHomePage(WebDriver driver) {

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

	public void logout() {
		Assert.assertTrue(isElementDisplayed(personIcon , timeToWait));
		personIcon.click();
		Assert.assertTrue(isElementDisplayed(logout , timeToWait));
		logout.click();
	}

	public void changePassword(String string, String string2, String string3) {
		oldPassword.sendKeys(string);
		newPassword.sendKeys(string2);
		confirmPassword.sendKeys(string3);
		changePasswordBtn.click();
	}

	/**
	 * Method to click on transact tab
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void clickTransactTab() throws InterruptedException, AWTException {
		transactTab.click();
	    Robot robot = new Robot();  // Robot class throws AWT Exception
	    Thread.sleep(2000); // Thread.sleep throws InterruptedException
	    robot.keyPress(KeyEvent.VK_CONTROL);  // press Control key down key of 
	    robot.keyPress(KeyEvent.VK_F5);
	}


}
