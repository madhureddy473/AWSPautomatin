package pages.AgentPortal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.pages.BasePage.Page;

import java.util.List;

public class AgentPortalAdministrationPage extends Page{


	//OBJECTS


	@FindBy(xpath = "//button[@data-cy='btn_approve_requests']")
	WebElement approveCard;

	String checkButtonXpath = "//mat-row[@data-cy='%s']/mat-cell/wf-decision/div[1]/fa-icon[@data-cy='btn_approve']";

	@FindBy(xpath = "//mat-row[@data-cy='%s']/mat-cell/wf-decision/div[1]/fa-icon[@data-cy='btn_approve']")
	WebElement checkButton;

	@FindBy(linkText="Yes")
	WebElement yesLink;

	@FindBy(xpath = "//button[@data-cy='btn_unregister_devices']")
	WebElement unregisterDeviceCard;

	@FindBy(xpath="//input[@type='text']")
	WebElement locationId;

	@FindBy(xpath="//mat-radio-button[@id='mat-radio-1']/label/span")
	WebElement locationIdRadioBtn;

	@FindBy(xpath="//mat-checkbox[@id='mat-checkbox-4']/label/span")
	WebElement locationIdCheckBox;

	@FindBy(id="searchid")
	WebElement searchId;

	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement searchButton;

	String unregisterDeviceButtonXpath = "//button[@type='button' and @data-cy='btn_submit']";

	@FindBy(xpath="(//button[@type='submit' and contains(text(), ' Yes ')])")
	WebElement yesModal;

	@FindBy(xpath="//button[@type='button' and contains(text(), ' Close ')]")
	WebElement closeModal;

	@FindBy(xpath = "//mat-header-cell[contains(text(), 'Location ID')]")
	WebElement locationHeader;

	String locationXpath = "//mat-cell[contains(text(), '%s')]/ancestor::mat-row/mat-cell[1]/mat-radio-button";

	@FindBy(xpath="//strong[contains(text(), ' Administration ')]")
	WebElement adminPageLabel;

	@FindBy(linkText="Edit")
	WebElement editLink;

	@FindBy(xpath="//button[contains(text(), 'Save')]")
	WebElement locationIdSaveButton;

	@FindBy(xpath = "//*[@id='mat-select-value-1']")
	WebElement posSelectionDD;

	@FindBy(xpath = "//span[contains(text(), 'Create New')]")
	WebElement createNew;

	@FindBy(xpath = "//*[@id='first-name']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='last-name']")
	WebElement lastName;

	@FindBy(id="mail")
	WebElement email;

	@FindBy(xpath = "//*[@id='preferred-language']")
	WebElement language;

	String languageXpath = "//*[@id='mat-option-5']/span[contains(text(), 'English')]";

	@FindBy(xpath = "//button[@data-cy='btn_create_profile']")
	WebElement createProfile;

	String createProfileXpath = "//button[@data-cy='btn_create_profile']";

	@FindBy(xpath = "//span[contains(text(), 'AgentWorks')]/ancestor::div[1]/div")
	WebElement agentWorksCheckBox;

	public WebElement getNextButton() {  return nextButton; 	}

	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	WebElement nextButton;

	@FindBy(xpath = "//span[contains(text(), 'Teller')]/ancestor::div[1]/div")
	WebElement tellerCheckBox;

	@FindBy(xpath = "//label[contains(text(), 'Send Money')]/following-sibling::input")
	WebElement sendMoneyAmount;

	@FindBy(xpath = "//label[contains(text(), 'Receive money')]/following-sibling::input")
	WebElement receiveMoneyAmount;

	@FindBy(xpath = "//label[contains(text(), 'Amend transaction')]/following-sibling::input")
	WebElement amendTransactionAmount;

	@FindBy(xpath = "//label[contains(text(), 'Refund transaction')]/following-sibling::input")
	WebElement refundTransactionAmount;

	@FindBy(xpath = "//label[contains(text(), 'Bill payment')]/following-sibling::input")
	WebElement billPaymentAmount;

	@FindBy(xpath = "//label[contains(text(), 'Receive reversal transaction')]/following-sibling::input")
	WebElement receiveReversalAmount;

	@FindBy(xpath = "//label[contains(text(), 'Money Order Transaction')]/following-sibling::input")
	WebElement moneyOrderAmount;

	@FindBy(xpath = "//label[contains(text(), 'Vendor Payment Amount')]/following-sibling::input")
	WebElement vendorPaymentAmount;

	@FindBy(xpath = "//span[contains(text(), 'Finish')]")
	WebElement finishButton;

	@FindBy(xpath = "//mat-header-cell[contains(text(), 'Location ID')]/ancestor::mat-header-row/mat-header-cell[1]/mat-checkbox/label")
	WebElement locationCheckBox;

	@FindBy(xpath = "//button[@type='button' and @data-cy='btn_submit']")
	WebElement unregisterDeviceButton;

	String selectLocation = "//mat-cell[contains(text(), '%s')]/ancestor::mat-row/mat-cell[1]";

	@FindBy(xpath ="//a[@class='main-menu-item' and @data-cy='STRKEY_ADMIN']")
	WebElement administrationTab;

	@FindBy(xpath ="//mat-option[@id='mat-option-1']")
	WebElement selectPOStoUnregister;

	String administrationTabXpath = "//a[@class='main-menu-item' and @data-cy='STRKEY_ADMIN']";

	@FindBy(xpath ="//a[@class='main-menu-item' and @data-cy='STRKEY_HELP']")
	WebElement helpTab;

	String helpTabXpath = "//a[@class='main-menu-item' and @data-cy='STRKEY_HELP']";

	@FindBy(xpath = "//span[contains(text(), 'Application Info')]")
	WebElement applicationInfo;

	String applicationInfoXpath = "//span[contains(text(), 'Application Info')]";

	@FindBy(xpath = "//div[@data-cy='agent-deviceMainOffice']")
	WebElement deviceMainOfficeID;



	@FindBy(xpath = "//div[@data-cy='agent-deviceAgentId']")
	WebElement deviceAgentID;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary')])[2]")
	WebElement unregisterbutton;

	@FindBy(xpath = "//div[contains(@class,'mat-select-trigger')]")
	WebElement selectPOStounreg;

	@FindBy(xpath = "//mat-option[@id='mat-option-1']")
	WebElement POStounreg;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesTounregisterbutton;

	//button[contains(text(),'Yes')]
	
	//CONSTRUCTOR
	public AgentPortalAdministrationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
	}
	
	//METHODS
	public String getAdminPageText() {
		return adminPageLabel.getText();
	}

	/**
	 * Method to approve the device request
	 * @throws InterruptedException
	 */
	public void approveRequest() throws Exception {
		Assert.assertTrue(isElementDisplayed(approveCard, timeToWait));
		approveCard.click();
		Thread.sleep(6000);
		String checkBtn = String.format(checkButtonXpath, "row_"+System.getProperty("user.name")+"_device");
		driver.findElement(By.xpath(checkBtn)).click();
		Assert.assertTrue(isElementDisplayed(yesLink, timeToWait));
		yesLink.click();
		Thread.sleep(5000);
		getScreenShot();
	}

	public void unregisterTeller(String searchID, String locationID) throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", unregisterDeviceCard);

		unregisterDeviceCard.click();
		searchId.sendKeys(searchID);
		searchButton.click();Thread.sleep(3000);
		//boolean buttnStatus = unregisterbutton.isEnabled();
		//if(buttnStatus){
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectPOStounreg);

			selectPOStounreg.click();
			POStounreg.click();Thread.sleep(2000);
			unregisterbutton.click();Thread.sleep(7000);
			yesTounregisterbutton.click();



	}

	/**
	 * Method to unregister the device
	 * @param searchID Data sheet main office ID
	 * @param locationID Data sheet agent ID
	 * @throws InterruptedException
	 */
	public void unregister(String searchID, String locationID) throws InterruptedException {
		Thread.sleep(3000);
		unregisterDeviceCard.click();
		searchId.sendKeys(searchID);
		searchButton.click();
		if(isElementDisplayed(editLink, timeToWait)){
		editLink.click();
		Assert.assertTrue(isElementDisplayed(locationId, timeToWait));
		locationId.sendKeys(locationID);
		locationIdRadioBtn.click();
		locationIdSaveButton.click();
		Assert.assertTrue(isElementDisplayed(posSelectionDD, timeToWait));
		posSelectionDD.click();
		findElementUsingText(System.getProperty("user.name")+"_device").click();
		Assert.assertTrue(isElementDisplayed(unregisterDeviceButton, timeToWait));
		waitForElementToBeVisibleAndClick(unregisterDeviceButtonXpath);
		Assert.assertTrue(isElementDisplayed(yesModal, timeToWait));
		yesModal.click();
		Assert.assertTrue(isElementDisplayed(closeModal, timeToWait));
		closeModal.click();
		}
	}

	/**
	 * Method to unregister the device with single agent/few agents Id (No Edit button)
	 * @param searchID
	 * @param LocationID
	 */
	public void unRegisterDeviceWithNoEditButton(String searchID, String LocationID){
		unregisterDeviceCard.click();
		searchId.sendKeys(searchID);
		searchButton.click();
		if(isElementDisplayed(locationHeader, timeToWait)) {
			List<WebElement> rows = driver.findElements(By.xpath("//mat-cell[contains(text(), '')]/ancestor::mat-row"));
			if(rows.size()>1){
				String agentLocationId = String.format(locationXpath, LocationID);
				driver.findElement(By.xpath(agentLocationId)).click();
			}
			Assert.assertTrue(isElementDisplayed(posSelectionDD, timeToWait));
			posSelectionDD.click();
			findElementUsingText(System.getProperty("user.name") + "_device").click();
			waitForElementToBeVisibleAndClick(unregisterDeviceButtonXpath);
			yesModal.click();
			closeModal.click();

		}
	}

	/**
	 * Method to enter new user personal info, this method is only used while creating a user
	 * @param fName
	 * @param lName
	 * @param emailId
	 * @param lang
	 */
	public void newUserInfo(String fName, String lName, String emailId, String lang){
//		Assert.assertTrue(isElementDisplayed(createNew, waitTime));
		createNew.click();
		if(fName.equalsIgnoreCase("NA")){
			firstName.sendKeys(getRandomString(7));
		}
		else {
			firstName.sendKeys(fName);
		}
		if(lName.equalsIgnoreCase("NA")){
			lastName.sendKeys(getRandomString(7));
		}
		else {
			lastName.sendKeys(lName);
		}
		if(emailId.equalsIgnoreCase("NA")){
			email.sendKeys(getRandomString(9)+"@gmail.com");
		}
		else {
			email.sendKeys(emailId);
		}
		language.click();
		String languages = String.format(languageXpath, lang);
		driver.findElement(By.xpath(languages)).click();
		waitForElementToBeVisibleAndClick(createProfileXpath);
	}

	/**
	 * Method to select agent works checkbox
	 */
	public void selectAgentWorksCheckBox(){
		agentWorksCheckBox.click();
		nextButton.click();
	}

	/**
	 * Method to enter Main office Id and location ID
	 * @param searchID
	 * @param locationID
	 */
	public void enterMainOfficeAndLocation(String searchID, String locationID){
		searchId.sendKeys(searchID);
		searchButton.click();
		if(isElementDisplayed(editLink, 60)) {
			editLink.click();
			locationId.sendKeys(locationID);
			locationCheckBox.click();
			locationIdSaveButton.click();
		}
		else{
			System.out.println("No edit button");
			String location = String.format(locationXpath, locationID);
			driver.findElement(By.xpath(location)).click();
		}

	}

	/**
	 * Method to click on teller role
	 */
	public void selectRole(){
		tellerCheckBox.click();
		nextButton.click();
	}

	/**
	 * Method to enter transaction amount threshold
	 * @param send
	 * @param receive
	 * @param amend
	 * @param refund
	 * @param billPay
	 * @param receiveReversal
	 * @param moneyOrder
	 * @param vendorPayment
	 */
	public void enterAmountThreshold(String send, String receive, String amend, String refund, String billPay, String receiveReversal, String moneyOrder, String vendorPayment){
		sendMoneyAmount.sendKeys(send);
		receiveMoneyAmount.sendKeys(receive);
		amendTransactionAmount.sendKeys(amend);
		refundTransactionAmount.sendKeys(refund);
		billPaymentAmount.sendKeys(billPay);
		receiveReversalAmount.sendKeys(receiveReversal);
		moneyOrderAmount.sendKeys(moneyOrder);
		vendorPaymentAmount.sendKeys(vendorPayment);
		finishButton.click();
		if(isElementDisplayed(closeModal, 15)) {
			closeModal.click();
		}
	}

	public void goToApplicationInfo() throws InterruptedException {
		if(isElementDisplayed(helpTab, timeToWait)){
			Thread.sleep(3000);
			staleElementHandling(helpTabXpath, 10);
			helpTab.click();
			staleElementHandling(applicationInfoXpath, 15);
			Thread.sleep(3000);
			isElementDisplayed(applicationInfo, timeToWait);
			applicationInfo.click();
		}
	}

	public void isUnregistrationDone() throws InterruptedException {
		Assert.assertTrue(isElementDisplayed(deviceMainOfficeID, timeToWait));
		if(!deviceMainOfficeID.getText().equalsIgnoreCase("")){
			String searchID = deviceMainOfficeID.getText();
			String locationID = deviceAgentID.getText();
			staleElementHandling(administrationTabXpath, 15);
			Thread.sleep(3000);
			Assert.assertTrue(isElementDisplayed(administrationTab, timeToWait));
			administrationTab.click();
			unregisterDeviceCard.click();
			searchId.sendKeys(searchID);
			searchButton.click();
			if(isElementDisplayed(editLink, 60)) {
				editLink.click();
				locationId.sendKeys(locationID);
				locationIdRadioBtn.click();
				locationIdSaveButton.click();
			}
			else{
				System.out.println("No edit button");
				List<WebElement> rows = driver.findElements(By.xpath("//mat-cell[contains(text(), '')]/ancestor::mat-row"));
				if(rows.size()>1) {
					String location = String.format(locationXpath, locationID);
					driver.findElement(By.xpath(location)).click();
				}
			}
			Assert.assertTrue(isElementDisplayed(posSelectionDD, timeToWait));
			posSelectionDD.click();
			findElementUsingText(System.getProperty("user.name")+"_device").click();
			Assert.assertTrue(isElementDisplayed(unregisterDeviceButton, timeToWait));
			waitForElementToBeVisibleAndClick(unregisterDeviceButtonXpath);
			Assert.assertTrue(isElementDisplayed(yesModal, timeToWait));
			yesModal.click();
			Assert.assertTrue(isElementDisplayed(closeModal, timeToWait));
			closeModal.click();

		}

	}


}
