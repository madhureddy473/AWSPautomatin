package pages.AgentWorks;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import test.java.pages.BasePage.Page;

public class AgentWorksReceivePage extends Page{

	//OBJECTS

	@FindBy(xpath="//button[@type='button']/span[contains(text(),'Next')]")
	WebElement nextBtn;
	
	@FindBy(xpath="//app-address-finder/div/input")
	WebElement receiverAddressField; 
	
	@FindBy(id="recvconfirmationpayout")
	WebElement payoutBtn;
	
	@FindBy(id="receivefinishscanreceiptorfinish")
	WebElement finishedBtn;

	String finishButtonXpath = "//*[@id='receivefinishscanreceiptorfinish']";
	
	@FindBy(xpath="//select")
	WebElement selectBirthYear;
	
	@FindBy(xpath="//div[2]/select")
	WebElement selectBirthMonth;
	
	@FindBy(xpath="//div[3]/select")
	WebElement selectBirthDay;
	
	@FindBy(xpath="//button[@id='findRefNoBtn']/span")
	WebElement findRefNumBtn;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement refNumField;
	
	@FindBy(id="receiver_PreferredLanguage")
	WebElement preferredLanguage;

	@FindBy(xpath = "//*[@id='receiver_Birth_Country']/input")
	WebElement birthCountry;

	@FindBy(xpath = "//span[contains(text(), 'Birth City')]/ancestor::div[1]/input")
	WebElement birthCity;
	
	@FindBy(id="receiver_PrimaryPhone")
	WebElement receiverPrimaryPhoneNumber;
	
	@FindBy(xpath="//div[@id='Receive Offers_radio']/ul/li[4]/label/span")
	WebElement receiveOffersRadioBtn;
	
	@FindBy(id="receiver_PersonalId1_Type")
	WebElement personalId_Type;

	@FindBy(id="receiver_PersonalId1_Issue_City")
	WebElement idIssueCity;
	
	@FindBy(id="receiver_PersonalId1_Choice")
	WebElement idChoiceField;
	
	@FindBy(id="receiver_PersonalId2_Type")
	WebElement personalId2_Type;
	
	@FindBy(id="receiver_PersonalId2_Choice")
	WebElement idSecChoiceField;
	
	@FindBy(id="receiver_PersonalId1_Number")
	WebElement personalId_Number;
	
	@FindBy(id="receiver_PersonalId2_Number")
	WebElement personalId2_Number;

	@FindBy(xpath="//*[@id='receiver_Occupation']")
	WebElement occupation;

	String occupationXpath = "//*[@id='receiver_Occupation']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='relationshipToSender']")
	WebElement relationshipToSender;

	String relationshipToSenderXpath = "//*[@id='relationshipToSender']/option[contains(text(), '%s')]";
	
	@FindBy(xpath="//app-typeahead[@id='receiver_PersonalId1_Issue_Country']/input")
	WebElement idIssueCountryField;

	String countryXpath = "//span[text()='%s']";
	
	@FindBy(xpath="//app-typeahead[@id='receiver_PersonalId1_Issue_Country_SubdivisionCode']/input")
	WebElement idIssueStateField;

	@FindBy(xpath = "//strong[contains(text(), ' Third party information ')]")
	WebElement thirdPartyPageHeader;

	@FindBy(xpath = "//*[@id='STRKEY_IS_CUST_RECEIVING_radio']/div/label/span[contains(text(), 'None')]")
	WebElement noneRadioButton;

	@FindBy(xpath = "//span[contains(text(), 'Other taxes')]/ancestor::div[1]/strong")
	WebElement taxAmount;

	@FindBy(xpath = "//*[@id='receiver_CitizenshipCountry']/input")
	WebElement citizenShipCountry;

	@FindBy(xpath = "//*[@id='receiver_Residence_Country']/input")
	WebElement receivePermanentResidency;

	String receivePermanentResidencyXpath = "//*[@id='receiver_Residence_Country']/ngb-typeahead-window/button/ngb-highlight/span[contains(text(), '%s')]";

	String idChoiceDropDown = "//*[@id='receiver_PersonalId1_Choice']/option[contains(text(), '%s')]";

	String idChoiceTwoDropDown = "//*[@id='receiver_PersonalId2_Choice']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]")
	WebElement expirationYear;

	String expirationYearNumber = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]")
	WebElement expirationMonth;

	String expirationMonthNumber = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]")
	WebElement expirationDate;

	String expirationDateNumber = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='receiver_PersonalId1_Issue_Authority']")
	WebElement idIssueAuthority;

	@FindBy(xpath = "//strong[contains(text(), ' Identification - Primary Photo ID ')]")
	WebElement senderIdentification;

	@FindBy(xpath = "//span[contains(text(), 'Other taxes')]")
	WebElement receive_OtherTaxes;

	@FindBy(xpath = "//span[contains(text(), 'Other fees')]")
	WebElement receive_OtherFees;

	@FindBy(xpath = "//*[@id='receive_PurposeOfTransaction']")
	WebElement receiverPurposeOfTransactionAdditionData;

	String receiverPurposeOfTransactionAdditionalDataXpath = "//*[@id='receive_PurposeOfTransaction']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='receiver_Gender']")
	WebElement receiverGender;

	String receiverGenderXpath = "//*[@id='receiver_Gender']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='receiver_Nationality']/input")
	WebElement receiverNationality;

	@FindBy(xpath = "//strong[contains(text(), 'Additional data collection')]")
	WebElement additionalDataFieldHeader;



	public WebElement getNextBtn() {
		isElementDisplayed(nextBtn, 20);
		return nextBtn;
	}


	//CONSTRUCTOR
	public AgentWorksReceivePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//METHODS
	/**
	 * Method to reference number and year of birth to pull the transaction
	 * @param refNum Data sheet send reference number
	 * @param birthYear Data sheet send birth year
	 * @param birthMonth Data sheet send birth month
	 * @param birthDay Data sheet send birth day
	 */
	public void enterSenderInfo(String refNum, String birthYear, String birthMonth, String birthDay){
		Assert.assertTrue(isElementDisplayed(refNumField, timeToWait));
		refNumField.sendKeys(refNum);
		Assert.assertTrue(isElementDisplayed(selectBirthYear, timeToWait));
		selectDdlByText(selectBirthYear, birthYear);
		Assert.assertTrue(isElementDisplayed(selectBirthMonth, timeToWait));
		selectDdlByText(selectBirthMonth, birthMonth);
		Assert.assertTrue(isElementDisplayed(selectBirthDay, timeToWait));
		selectDdlByText(selectBirthDay, birthDay);
		Assert.assertTrue(isElementDisplayed(findRefNumBtn, timeToWait));
		findRefNumBtn.click();
	}

	/**
	 * Method to enter receiver details
	 * Note: country should be in CAPS
	 * @param country Data sheet receiver country
	 * @param addressNum Data sheet receiver address
	 * @param recOccupation Data sheet receiver occupation
	 * @param relationShip Data sheet receiver relation
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void receiverInformation(String country, String addressNum, String recOccupation, String relationShip) throws InterruptedException, AWTException {
		if(!country.equalsIgnoreCase("NA")) {
			Assert.assertTrue(isElementDisplayed(birthCountry, timeToWait));
			birthCountry.sendKeys(country);
		}
		robotPageDownAndEnter(receiverAddressField, addressNum);
		Thread.sleep(3000);
		if (!recOccupation.equalsIgnoreCase("NA")) {
			scrollPage("DOWN");
			if (isElementDisplayed(occupation, 10)) {
				occupation.click();
				String occupation1 = String.format(occupationXpath, recOccupation);
				driver.findElement(By.xpath(occupation1)).click();
			}
		}
		if(!relationShip.equalsIgnoreCase("NA")){
			scrollPage("DOWN");
			if(isElementDisplayed(relationshipToSender, 10)) {
				relationshipToSender.click();
				String relationship = String.format(relationshipToSenderXpath, relationShip);
				driver.findElement(By.xpath(relationship)).click();
			}
		}
		nextBtn.click();
	}


	/**
	 * Method only for belgium and Italy receiver
	 * @param country
	 * @param addressNum
	 * @param recOccupation
	 * @param relationShip
	 * @param birthCityField
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void receiverInfo(String country, String addressNum, String recOccupation, String relationShip, String birthCityField) throws InterruptedException, AWTException {
		Assert.assertTrue(isElementDisplayed(birthCountry, 60));
		birthCountry.sendKeys(country);
		String countries = String.format(countryXpath, country);
		driver.findElement(By.xpath(countries)).click();
		robotPageDownAndEnter(receiverAddressField, addressNum);
		Thread.sleep(3000);
		if (!recOccupation.equalsIgnoreCase("NA")) {
			scrollPage("DOWN");
			if (isElementDisplayed(occupation, 10)) {
				occupation.click();
				String occupation1 = String.format(occupationXpath, recOccupation);
				driver.findElement(By.xpath(occupation1)).click();
			}
		}
		if(!birthCityField.equalsIgnoreCase("NA")){
			birthCity.sendKeys(birthCityField);
			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		if(!relationShip.equalsIgnoreCase("NA")){
			scrollPage("DOWN");
			if(isElementDisplayed(relationshipToSender, 10)) {
				relationshipToSender.click();
				String relationship = String.format(relationshipToSenderXpath, relationShip);
				driver.findElement(By.xpath(relationship)).click();
			}
		}
		nextBtn.click();
	}

	/**
	 * Method to receive Contact information
	 * @param phone Data sheet phone
	 * @param language Data sheet language
	 */
	public void receiverContactInformation(String phone, String language){
		if(!phone.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(receiverPrimaryPhoneNumber, timeToWait));
			receiverPrimaryPhoneNumber.sendKeys(phone);
		}
		Assert.assertTrue(isElementDisplayed(preferredLanguage, timeToWait));
		selectDdlByText(preferredLanguage, language);
		receiveOffersRadioBtn.click();
		nextBtn.click();
	}

	/**
	 * Method to enter additional receiver information
	 * @param purposeOfTran Datasheet Purpose Of Transaction
	 * @param gender Datasheet Gender
	 * @param nationality Datasheet Nationality
	 */
	public void additionalReceiverPageInfo(String purposeOfTran, String gender, String nationality, String perResidency, String citizenship) throws AWTException, InterruptedException {

		if(isElementDisplayed(additionalDataFieldHeader, 60)){
			if(!purposeOfTran.equalsIgnoreCase("NA")) {
				receiverPurposeOfTransactionAdditionData.click();
				String purpose = String.format(receiverPurposeOfTransactionAdditionalDataXpath, purposeOfTran);
				driver.findElement(By.xpath(purpose)).click();
			}
			if(!gender.equalsIgnoreCase("NA")){
				receiverGender.click();
				String gen = String.format(receiverGenderXpath, gender);
				driver.findElement(By.xpath(gen)).click();
			}
			if(!nationality.equalsIgnoreCase("NA")){
				receiverNationality.sendKeys(nationality);
				Robot robot = new Robot();
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
			}
			if(!perResidency.equalsIgnoreCase("NA")){
				receivePermanentResidency.sendKeys(perResidency);
				String countries = String.format(receivePermanentResidencyXpath, perResidency);
				driver.findElement(By.xpath(countries)).click();
			}
			if(!citizenship.equalsIgnoreCase("NA")){
				citizenShipCountry.sendKeys(citizenship);
			}
			nextBtn.click();
		}
	}

	public void additionalInfoBirthCountry(String birthCoun){
		Assert.assertTrue(isElementDisplayed(birthCountry, timeToWait));
		birthCountry.sendKeys(birthCoun);
		String country = String.format(countryXpath, birthCoun);
		driver.findElement(By.xpath(country)).click();
	}

	/**
	 * Method to click payout
	 */
	public void clickPayout(){
		Assert.assertTrue(isElementDisplayed(payoutBtn, 15));
		payoutBtn.click();
		if(isElementDisplayed(finishedBtn, 10)){
			waitForElementToBeVisibleAndClick(finishButtonXpath);
		}
	}

	public void validatePayoutIsNotFound(){
		Assert.assertFalse(isElementDisplayed(payoutBtn, 30));
	}

	/***************************************************

	/**
	 * Method to enter receiver Identification one for the first time
	 * Note : Country name should be in CAPS
	 * @param idChoice Data sheet idType
	 * @param idNumber Data sheet idNumber
	 * @param country Data sheet idIssueCountry
	 * @param State Data sheet idIssueState
	 */
	public void enterReceiverIdentificationOneUnknown(String idChoice, String idNumber, String country, String State){
		Assert.assertTrue(isElementDisplayed(personalId_Type, 60));
		personalId_Type.click();
		List<WebElement> idTypes = driver.findElements(By.xpath("//*[@id='receiver_PersonalId1_Type']/option"));

		for(int i=0; i<idTypes.size(); i++){
			if(idTypes.get(i).getText().equalsIgnoreCase(idChoice)){
				idTypes.get(i).click();
				break;
			}
		}
		Assert.assertTrue(isElementDisplayed(personalId_Number, timeToWait));
		personalId_Number.sendKeys(idNumber);
		Assert.assertTrue(isElementDisplayed(idIssueCountryField, timeToWait));
		idIssueCountryField.sendKeys(country);
		String countries = String.format(countryXpath, country);
		driver.findElement(By.xpath(countries)).click();
		if(!State.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(idIssueStateField, timeToWait));
			textSuggestAndEnter(idIssueStateField, State);
		}
	}

	/**
	 * Method to enter identification city
	 * @param city
	 */
	public void receiverIdOneCity(String city){
		idIssueCity.sendKeys(city);
	}

	/**
	 * Method to select ID issue authority
	 * @param idAuthority
	 */
	public void receiverIdOneIssueAuthority(String idAuthority){
		selectDdlByText(idIssueAuthority, idAuthority);
	}


	/**
	 * Method to enter Id two details for the first time
	 * @param secondaryId Data sheet secIdType
	 * @param secondaryIdNum Data sheet secIdNumber
	 */
	public void enterReceiverIDTwoIdentificationUnknown(String secondaryId, String secondaryIdNum){

		personalId2_Type.click();
		List<WebElement> secondaryIdTypes = driver.findElements(By.xpath("//*[@id='receiver_PersonalId2_Type']/option"));

		for(int i=0; i<secondaryIdTypes.size(); i++){
			if(secondaryIdTypes.get(i).getText().equalsIgnoreCase(secondaryId)){
				secondaryIdTypes.get(i).click();
				break;
			}
		}
		personalId2_Number.sendKeys(secondaryIdNum);
		nextBtn.click();
	}

	/**
	 * Method to enter expiration Date
	 * @param year
	 * @param month
	 * @param date
	 */
	public void enterExpirationDate(String year, String month, String date) {

		if(!year.equalsIgnoreCase("NA")) {
			expirationYear.click();
			driver.findElement(By.xpath("//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]/select/option[contains(text(), '2030')]")).click();
		}
		if(!month.equalsIgnoreCase("NA")){
			expirationMonth.click();
			driver.findElement(By.xpath("//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]/select/option[contains(text(), '12')]")).click();
		}
		if(!date.equalsIgnoreCase("NA")){
			expirationDate.click();
			driver.findElement(By.xpath("//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]/select/option[contains(text(), '12')]")).click();
		}
		nextBtn.click();
		if(isElementDisplayed(senderIdentification, 5)){
			nextBtn.click();
		}
	}

	/**
	 * Method to validate third party page and click on next
	 */
	public void thirdPartyInfoForHighAmount()
	{
		if(isElementDisplayed(thirdPartyPageHeader, 20)) {
			noneRadioButton.click();
			nextBtn.click();
		}
	}

	/**
	 * Method to validate Haiti tax amount
	 */
	public void taxAmount(){
		Assert.assertTrue(taxAmount.getText().contains("1.50"));
	}

	/**
	 * Method to validate if other Fees and taxes are been displayed
	 */
	public void validateReceiveTaxes(){
		Assert.assertTrue(isElementDisplayed(receive_OtherFees,30));
		Assert.assertTrue(isElementDisplayed(receive_OtherTaxes,0));
	}

	/**
	 * Method to enter citizenship country
	 * @param country
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void citizenShipCountry(String country) throws AWTException, InterruptedException {
		citizenShipCountry.sendKeys(country);
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		nextBtn.click();
	}


	//********************************** Temporary *********************************************//

	@FindBy(xpath = "//button[@class='btn mx-5 btn-success hover-shadow']")
	WebElement deviceContinue;

	@FindBy(xpath = "//input[@type='text' and @name='devicename']")
	WebElement deviceNameTextField;

	@FindBy(xpath = "//button[@type='button' and @data-cy='btn_next']")
	WebElement deviceNextButton;

	@FindBy(xpath = "//button[@type='button' and @data-cy='btn_done']")
	WebElement doneButton;

	@FindBy(xpath = "//label[contains(text(), 'Authentication Code')]")
	WebElement authenticationCode;

	@FindBy(xpath = "//*[@id='mat-dialog-3']/fp-tellerotp/div/div[1]/div/fa-icon/svg")
	WebElement close;

	@FindBy(xpath = "//button[contains(text(), 'Yes')]")
	WebElement yesButton;

	public void enterRegisterDevice1() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_CONTROL);

		int timeToWaitForElement = 180;
		boolean displayed = false;
		Instant start = Instant.now();
		while (!displayed) {
			if (isElementDisplayed(deviceContinue, 5)) {
				deviceContinue.click();
				displayed = true;
			}
			if (isElementDisplayed(deviceNameTextField, 5)) {
				deviceNameTextField.sendKeys(System.getProperty("user.name") + "_device");
				deviceNextButton.click();
				displayed = true;
				if(isElementDisplayed(authenticationCode, 10)){
					close.click();
					yesButton.click();
				}
				else{
					doneButton.click();
				}
			}
			Instant end = Instant.now();
			long secondsPassed = Duration.between(start, end).getSeconds();
			if(secondsPassed > timeToWaitForElement){
				break;
			}
		}
		doneButton.click();
	}






	//*************************************** Unused Methods ************************************

	/**
	 * Method to enter receiver details
	 * @param country Data sheet country
	 * @param address_num Data sheet address
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void receiverInfo(String country, String address_num, String recOccupation) throws InterruptedException, AWTException {
		birthCountry.sendKeys(country);
		robotPageDownAndEnter(receiverAddressField, address_num);
		Thread.sleep(3000);
		if (!recOccupation.equalsIgnoreCase("NA")) {
			scrollPage("DOWN");
			if(isElementDisplayed(occupation, 10)) {
				occupation.click();
				String occupation1 = String.format(occupationXpath, recOccupation);
				driver.findElement(By.xpath(occupation1)).click();
			}
		}
		nextBtn.click();
	}


	public void enterSenderInfoExs(String refnum, String birth_year, String birth_month, String birth_day) throws AWTException, InterruptedException

	{
		refNumField.sendKeys(refnum);
		selectDdlByText(selectBirthYear, birth_year);
		selectDdlByText(selectBirthMonth, birth_month);
		selectDdlByText(selectBirthDay, birth_day);
		findRefNumBtn.click();
		driver.findElement(By.xpath("//card-footer[contains(text(),'Select')]")).click();
		nextBtn.click();
		Thread.sleep(1000);
		nextBtn.click();
		nextBtn.click();
	}

	public void enterReceiverIdentificationInfo(String address_num, String phone, String language, String personal_idtype, String personal_idnum, String country, String state, String personal_idtype2, String personal_idnum2) throws Exception {
		birthCountry.sendKeys(country);
		robotPageDownAndEnter(receiverAddressField, address_num);
		Thread.sleep(3000);
		nextBtn.click();
		if(!phone.equalsIgnoreCase("NA")){
			receiverPrimaryPhoneNumber.sendKeys(phone);
		}
		selectDdlByText(preferredLanguage, language);
		receiveOffersRadioBtn.click();
		nextBtn.click();
		nextBtn.click();
		selectDdlByText(personalId_Type, personal_idtype);
		personalId_Number.sendKeys(personal_idnum);
		textSuggestAndEnter(idIssueCountryField, country);
		textSuggestAndEnter(idIssueStateField, state);
		nextBtn.click();
		selectDdlByText(personalId2_Type, personal_idtype2);
		personalId2_Number.sendKeys(personal_idnum2);
		nextBtn.click();
		payoutBtn.click();
		waitElementIsClickable(finishedBtn);
		getScreenShot();
		finishedBtn.click();
	}
}