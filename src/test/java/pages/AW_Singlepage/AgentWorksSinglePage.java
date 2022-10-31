package pages.AW_Singlepage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.pages.BasePage.Page;

import java.awt.*;
import java.util.HashMap;

public class AgentWorksSinglePage extends Page{

	String firstname=null;
	String lastname=null;

	//OBJECTS

	//*************************** Customer Search *******************************

	public WebElement getManualSearch() {	return manualSearch;	}

	@FindBy(xpath = "//*[@id='manualSearch']")
	WebElement manualSearch;

	@FindBy(xpath="(//button[@class='btn btn-primary' and contains(text(), 'Search')])")
	WebElement searchBtn;

	@FindBy(xpath="(//button[@class='btn btn-secondary'])")
	WebElement newCustomerBtn;

	@FindBy(xpath="(//div[contains(text(), ' Name and Phone ')])")
	WebElement nameAndPhoneTab;

	@FindBy(id="consumer_LastName")
	WebElement consumerLastNameField;

	@FindBy(id="consumer_PrimaryPhone")
	WebElement consumerPhoneField;

	//**************Customer Search Results*************************

	@FindBy(xpath="(//p[@class='customer-name'])")
	WebElement customerSearchResults;
	//p[@class='customer-name']


	//*************************************** Sender Info ***********************************

	@FindBy(id="sender_FirstName")
	WebElement senderFirstName;

	@FindBy(id="sender_LastName")
	WebElement senderLastName;

	@FindBy(xpath="//input[@placeholder='Enter a location']")
	WebElement senderAddressField;

	//	@FindBy(xpath="//div/div/select")
	@FindBy(xpath = "//option[contains(text(), 'Year')]/ancestor::select")
	WebElement selectBirthYear;

	//	@FindBy(xpath="//div[2]/select")
	@FindBy(xpath = "//option[contains(text(), 'Month')]/ancestor::select")
	WebElement selectBirthMonth;

	//	@FindBy(xpath="//div[3]/select")
	@FindBy(xpath = "//option[contains(text(), 'Day')]/ancestor::select")
	WebElement selectBirthDay;

	@FindBy(xpath="//app-typeahead[@id='sender_Birth_Country']/input[@type='text']")
	WebElement birthCountryField;

	String countryXpath = "//span[text()='%s']";

	@FindBy(xpath="(//*[@id=\"Primary Phone Country Code\"]/input)")
	WebElement primaryCountryCode;

	@FindBy(xpath="(//*[@id=\"sender_PrimaryPhone\"])")
	WebElement senderPrimaryPhoneNumber;
	@FindBy(xpath="(//span[@class='checkmark'])[1]")
	WebElement mobilenumbercheckbox;



	@FindBy(xpath="(//*[@id=\"sender_Email\"])")
	WebElement senderEmail;

	@FindBy(xpath="(//*[@id=\"sender_PreferredLanguage\"])")
	WebElement senderPreferredLanguage;

	@FindBy(xpath="(//*[@id=\"Receive Offers_radio\"]/ul/li[4]/label/span)")
	WebElement marketingNotifications;

	@FindBy(xpath="((//span[@class='checkmark'])[2])")
	WebElement plusnumcheckbox;

	@FindBy(xpath="(//input[@id='sender_Marketing_NotificationOptedCode_0'])")
	WebElement marketingnotifictns;

	@FindBy(xpath="(//*[@id=\"Receive Transaction Status_radio\"]/ul/li[4]/label/span)")
	WebElement transactionNotifications;


	//***************************** Destination and Amount ***********************

	@FindBy(xpath="(//*[@class='mr-auto' and contains (text(), ' Send amount excluding fee ')])")
	 WebElement sendAmountExclFee;

	@FindBy(xpath="(//*[@class='mr-auto' and contains (text(), ' Send amount including fee ')])")
	WebElement sendAmountInclFee;

	@FindBy(xpath="(//*[@class='mr-auto' and contains (text(), ' Receive amount ')])")
	WebElement receiveAmount;

	@FindBy(xpath="//input[@type='tel']")
	WebElement sendMoney;

	@FindBy(xpath="//*[@id=\"receive_Country\"]/input")
	WebElement destCountry;
	//app-typeahead[@id='receive_Country']

	@FindBy(xpath="//*[@id='destination_Country_SubdivisionCode']/input")
	WebElement DestinationState;


	@FindBy(xpath="//app-typeahead[@id='destination_Country_SubdivisionCode']")
	WebElement destStateProvince;

	@FindBy(xpath="//span[contains(text(),'Transaction Quote')]")
	WebElement transactionQuote;

	//*[@id="destination_Country_SubdivisionCode"]/input

	//span[contains(text(),'Transaction Quote')]
	//html/body/app-root/div/app-quick-send-container/div[1]/quick-content-section[2]/quick-send-amount/form/div[7]/div[3]/button/span


//	public WebElement getIncludingFee() {
//		return includingFee;
//	}

	@FindBy(xpath = "//div[contains(text(), 'Send amount including fee')]")
	WebElement includingFee;

	@FindBy(xpath = "//div[contains(text(), 'Send amount excluding fee')]")
	WebElement excludingFee;

	@FindBy(xpath = "//div[contains(text(), 'Receive amount')]")
	WebElement destReceiveAmt;

	//*************************Service option***********************************************************

	@FindBy (xpath ="//span[contains(text(),' Cash ')]")
	WebElement cashOption;

	@FindBy (xpath ="//span[contains(text(),' Account Deposit ')]")
	WebElement acountDepositOption;

	@FindBy (xpath ="//div[contains(text(),' 10 Minute Service')]")
	WebElement tenMinuteService;

	@FindBy (xpath ="//div[contains(text(),' Bank Deposit - All Banks ')]")
	WebElement bankDepositAllBanks;

	@FindBy (xpath ="//div[contains(text(),' Bank Deposit - Xpress24x7  ')]")
	WebElement bankDepositXpress;


	//***********************Indentification**********************************************************

	@FindBy(xpath = "//select[@id='sender_PersonalId1_Type']")
	WebElement selectIdType;

	@FindBy(xpath = "//select[@id='sender_PersonalId2_Type']")
	WebElement selectId2Type;

	@FindBy(xpath = "//input[@id='sender_PersonalId1_Number']")
	WebElement idNumber;

	@FindBy(xpath = "//input[@id='sender_PersonalId2_Number']")
	WebElement id2Number;

	@FindBy(xpath = "//*[@id=\"sender_PersonalId1_Issue_Country\"]/input")
	WebElement idIssueCountry;

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]/select")
	WebElement selectExpirationYear;

	@FindBy(xpath = "//select[@id='thirdParty_Sender_Type']")
	WebElement thirdparty;
	@FindBy(xpath = "//select[@id='sender_Occupation']")
	WebElement senderoccupationn;

	@FindBy(xpath = "//input[@id='direction1']")
	WebElement direction1;

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]/select")
	WebElement selectExpirationMonth;

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]/select")
	WebElement selectExpirationDate;

	@FindBy(xpath = "//*[@id=\"sender_PersonalId1_Issue_Country_SubdivisionCode\"]/input")
	WebElement idIssueState;

	//*[@id="sender_PersonalId1_Issue_Country_SubdivisionCode"]/input


	//***********************Additional Information**********************************************

	@FindBy(xpath = "//*[@id='sender_Birth_Country']/input")
	WebElement birthCountry;
//(//input[@role='combobox'])[1]
	//**********************Receiver Information*********************************************

	@FindBy(id="receiver_FirstName")
	WebElement receiverFirstName;

	@FindBy(id="receiver_LastName")
	WebElement receiverLastName;

	@FindBy(xpath = "//span[contains(text(),' Submit ')]")
	WebElement submitBtn;


	//*****************************Send Money************************************

	@FindBy(xpath = "//p[contains(text(),'Sender')]/following-sibling::p")
	WebElement senderInfo;

	@FindBy(xpath = "//p[contains(text(),'Receiver')]/following-sibling::p")
	WebElement receiverInfo;

	@FindBy(xpath = "//p[contains(text(),'Destination')]/following-sibling::p")
	WebElement destinationInfo;

	@FindBy(xpath = "//p[contains(text(),'Service')]/following-sibling::p")
	WebElement serviceOption;

	@FindBy(xpath = "//div[contains(text(),'Send amount')]/following-sibling::div")
	WebElement sendAmountValue;

	@FindBy(xpath = "//span[contains(text(),'Send Money')]")
	WebElement sendMoneyBtn;

	@FindBy(xpath = "//span[contains(text(),' Reprint Receipt ')]")
	WebElement reprintReceiptBtn;

	//************************* Final page*****************************************************

	@FindBy(xpath = "//div[contains(text(),'Reference number ')]/following-sibling::div")
	WebElement referenceNumber;

	@FindBy(xpath = "//div[contains(text(),'Pay to ')]/following-sibling::div")
	WebElement payTo;

	@FindBy(xpath = "//div[contains(text(),'Sent from ')]/following-sibling::div")
	WebElement sentFrom;

	@FindBy(xpath = "//div[contains(text(),'Receive Amount ')]/following-sibling::div")
	WebElement receiveAmt;

	@FindBy(xpath = "//button[contains(text(),' Finished ')]")
	WebElement finished;

	@FindBy(xpath = "//button[contains(text(),' Reprint Receipts ')]")
	WebElement reprintReceipts;

	@FindBy(xpath = "//p[@class='success']")
	WebElement transactionStatus;

	@FindBy(xpath = "//p[@class='check']")
	WebElement image;


	//*************************** End of objects **********************************************

	//CONSTRUCTOR
	public AgentWorksSinglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//METHODS

	public void searchUsingLastNameAndPhoneNumber(String lastName, String phoneNumber) throws InterruptedException {
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
Thread.sleep(3000);
		newCustomerBtn.click();
		Thread.sleep(3000);

	}

	public void searchForExistingCustomer(String lastName, String phoneNumber){
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
		customerSearchResults.click();


	}

	public void fillNewSenderInformation(String senFName, String senLName, String birthYear, String birthMonth, String birthDay, String address, String countryCode, String phone, String email, String language) throws AWTException, InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(isElementDisplayed(senderFirstName, timeToWait));

		if(!senFName.equalsIgnoreCase("NA")){
			senderFirstName.clear();
			senderFirstName.sendKeys(senFName);
			Thread.sleep(5000);
		}

		else{
			firstname = getRandomString(5).toLowerCase();
			senderFirstName.sendKeys(firstname);
		}
		Assert.assertTrue(isElementDisplayed(senderLastName, timeToWait));
		if(!senLName.equalsIgnoreCase("NA")){
			senderLastName.sendKeys(senLName);
		}
		else{
			lastname = getRandomString(5).toLowerCase();
			senderLastName.sendKeys(lastname);
		}

		/*if(!senFName.equalsIgnoreCase("NA")){
			senderFirstName.clear();
			senderFirstName.sendKeys(senFName);
		}
		else{
			firstname = getRandomString(5).toLowerCase();
			senderFirstName.sendKeys(firstname);
		}*/

		if(!birthYear.equalsIgnoreCase("NA")) {
			selectDdlByText(selectBirthYear, birthYear);
			selectDdlByText(selectBirthMonth, birthMonth);
			selectDdlByText(selectBirthDay, birthDay);
		}

		if(isElementDisplayed(senderAddressField,2)) {
			senderAddressField.sendKeys(address);
			Thread.sleep(1000);
			senderAddressField.sendKeys(Keys.ARROW_DOWN);
			senderAddressField.sendKeys(Keys.ENTER);
		}
		else{
			driver.findElement(By.xpath("//*[@id='sender_Address_helpText']/ancestor::div[1]/input")).sendKeys(address);
		}

		if(isElementDisplayed(primaryCountryCode,2)) {
			primaryCountryCode.sendKeys(countryCode);
			primaryCountryCode.sendKeys(Keys.ARROW_DOWN);
			primaryCountryCode.sendKeys(Keys.ENTER);
		}

		if(isElementDisplayed(senderPrimaryPhoneNumber,2)) {
			senderPrimaryPhoneNumber.sendKeys(phone);
		}

		if(isElementDisplayed(mobilenumbercheckbox,2)) {
			Thread.sleep(2000);
			mobilenumbercheckbox.click();
			Thread.sleep(2000);

		}

		if(isElementDisplayed(senderEmail,2)) {
			senderEmail.sendKeys(email);
		}

		if(isElementDisplayed(senderPreferredLanguage,2)) {
			senderPreferredLanguage.sendKeys(language);
			senderPreferredLanguage.sendKeys(Keys.ARROW_DOWN);
			senderPreferredLanguage.sendKeys(Keys.ENTER);
Thread.sleep(3000);
		}
	}

	public void selectplusnumber() throws InterruptedException, AWTException {
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		if(isElementDisplayed(plusnumcheckbox,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", plusnumcheckbox);

			plusnumcheckbox.click();
			marketingnotifictns.click();
		}}
	public void destinationAndAmount(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys(amount);
		Thread.sleep(3000);
		if(isElementDisplayed(marketingNotifications,2)) {

			marketingNotifications.click();
		}
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
			DestinationState.sendKeys(DestState);
			DestinationState.sendKeys(Keys.ARROW_DOWN);
			DestinationState.sendKeys(Keys.ENTER);}
		}

		if(isElementDisplayed(transactionNotifications,2)) {
			transactionNotifications.click();
		}
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

	public void destinationAndAmount_Ext(String amount, String destinationCountry) throws InterruptedException, AWTException {
		Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));
		sendMoney.sendKeys(amount);
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		Assert.assertTrue(isElementDisplayed(transactionQuote, timeToWait));
		transactionQuote.click();
	}
	public void serviceOption(String serviceoption)throws InterruptedException{

		if (serviceoption.equalsIgnoreCase("10 Minute Service")) {
			Assert.assertTrue(isElementDisplayed(tenMinuteService, timeToWait));
			tenMinuteService.click();
		}
		if (serviceoption.equalsIgnoreCase("Home Delivery")) {
			Assert.assertTrue(isElementDisplayed(tenMinuteService, timeToWait));
			tenMinuteService.click();
		}


}

	public void identification(String idType, String idNum, String idIssCountry, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		//Assert.assertTrue(isElementDisplayed(selectIdType, timeToWait));
		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);
		
		if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);
			selectDdlByText(selectExpirationMonth, expMon);
			selectDdlByText(selectExpirationDate, expDate);
		}

		if(isElementDisplayed(selectId2Type,2)) {
			selectDdlByText(selectId2Type, id2type);
			id2Number.sendKeys(id2number);

		}

	}

	public void additionalInformationforexisting(String senderoccupation, String thirdparttype)throws InterruptedException{
		/*((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(1000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);*/

		if(isElementDisplayed(senderoccupationn,2)) {
			selectDdlByText(senderoccupationn, senderoccupation);

		}
		if(isElementDisplayed(thirdparty,2)) {
			selectDdlByText(thirdparty, thirdparttype);

		}
		if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("fdgfgfgfdg");


		}

	}


	public void additionalInformation(String bcountry, String senderoccupation, String thirdparttype)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
			Thread.sleep(1000);
			birthCountry.sendKeys(Keys.ARROW_DOWN);
			birthCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(senderoccupationn,2)) {
			selectDdlByText(senderoccupationn, senderoccupation);

		}
		if(isElementDisplayed(thirdparty,2)) {
			selectDdlByText(thirdparty, thirdparttype);

		}

	}

 	public void receiverInformation(String fName, String lName,String state) throws InterruptedException {
		Thread.sleep(4000);
		//Assert.assertTrue(isElementDisplayed(receiverFirstName, timeToWait));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);
		receiverFirstName.sendKeys(fName);
		Thread.sleep(5000);
		Assert.assertTrue(isElementDisplayed(receiverLastName, timeToWait));
		receiverLastName.sendKeys(lName);
		Thread.sleep(3000);
		submitBtn.click();
		Thread.sleep(3000);
		Assert.assertTrue(isElementDisplayed(idIssueState, timeToWait));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", idIssueState);

		Assert.assertTrue(isElementDisplayed(idIssueState, timeToWait));
		idIssueState.sendKeys(state);
		idIssueState.sendKeys(Keys.ARROW_DOWN);
		idIssueState.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		submitBtn.click();
	}

	public void validations(HashMap <String, String> teller, String Cus) throws InterruptedException {
		/*HashMap <String, String> sendMoney = new HashMap<>();
		Assert.assertTrue(isElementDisplayed(senderInfo, timeToWait));
		String senderdetails=senderInfo.getText();
		String[] senderinfo=senderdetails.split("\n");
		String[] actualname=senderinfo[0].split(" ");
		sendMoney.put("senLastName",actualname[1]);
		sendMoney.put("senFirstName",actualname[0]);
		sendMoney.put("senAddress",senderinfo[1]);
		String receiverdetails=receiverInfo.getText();
		String destinationdetails=destinationInfo.getText();
		String servicedetails=serviceOption.getText();
		String sendamount=sendAmountValue.getText();
		String[] amount = sendamount.split(" ");
		String[] receivername = receiverdetails.split(" ");
		sendMoney.put("recFirstName", receivername[0]);
		sendMoney.put("recLastName", receivername[1]);
		sendMoney.put("destCountry",destinationdetails);
		sendMoney.put("serviceOption",servicedetails);
		sendMoney.put("destAmt",amount[0]);

		Set<String> keys = sendMoney.keySet();
		for(String key: keys){
			String Expvalue = null;
			if(key.contains("senLastName")&& Cus.equalsIgnoreCase("No")){
				Expvalue = lastname;
			}else if(key.contains("senFirstName")&& Cus.equalsIgnoreCase("No")){
				Expvalue = firstname;
			}else {
				Expvalue = teller.get(key);
			}
			String Actvalue = sendMoney.get(key);
			if (Expvalue.equalsIgnoreCase(Actvalue)){
				Assert.assertTrue(true,"Actual value '"+Actvalue +"' and Expected Value '"+Expvalue +"' are matched for '"+key +"'");
			}else{
				Assert.assertTrue(false,"Actual value '"+Actvalue +"' and Expected Value '"+Expvalue +"' are not matched for '"+key +"'");
			}

		}
		Thread.sleep(5000);*/
		sendMoneyBtn.click();

		Assert.assertTrue(isElementDisplayed(referenceNumber, timeToWait));
		HashMap <String, String> finalPage = new HashMap<>();
		String Referencenumber=referenceNumber.getText();
		/*String[] Payto=payTo.getText().split(" ");
		finalPage.put("recFirstName", Payto[0]);
		finalPage.put("recLastName", Payto[1]);
		String[] Sentfrom=sentFrom.getText().split(" ");
		finalPage.put("senLastName",Sentfrom[1]);
		finalPage.put("senFirstName",Sentfrom[0]);
		Set<String> finalPagekeys = finalPage.keySet();
		for(String key: finalPagekeys){
			String Expvalue = null;
			if(key.contains("senLastName")&& Cus.equalsIgnoreCase("No")){
				Expvalue = lastname;
			}else if(key.contains("senFirstName")&& Cus.equalsIgnoreCase("No")){
				Expvalue = firstname;
			}else {
				Expvalue = teller.get(key);
			}
			String Actvalue = finalPage.get(key);
			if (Expvalue.equalsIgnoreCase(Actvalue)){
				Assert.assertTrue(true,"Actual value '"+Actvalue +"' and Expected Value '"+Expvalue +"' are matched for '"+key +"'");
			}else{
				Assert.assertTrue(false,"Actual value '"+Actvalue +"' and Expected Value '"+Expvalue +"' are not matched for '"+key +"'");
			}

		}*/
		finalPage.put("Referencenumber", Referencenumber);
		finished.click();

	}



	public void getScreenShotFromPage() throws Exception {
		getScreenShot();
	}


}