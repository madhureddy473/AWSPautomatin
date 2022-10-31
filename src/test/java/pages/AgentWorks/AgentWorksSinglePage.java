package pages.AgentWorks;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test.java.pages.BasePage.Page;


import java.awt.*;
import java.util.HashMap;

public class AgentWorksSinglePage extends Page{

	String firstname=null;
	String lastname=null;
	String recfirstname=null;
	String reclastname=null;
	String plusnummber =null;
String lastname1=null;
	//OBJECTS

	//*************************** Customer Search *******************************


	public WebElement getManualSearch() {	return manualSearch;	}
	@FindBy(xpath="//div[@id='send']")
	WebElement sendCard;

	@FindBy(xpath = "//*[@id='manualSearch']")
	WebElement manualSearch;

	@FindBy(xpath="(//button[@class='btn btn-primary' and contains(text(), 'Search')])")
	WebElement searchBtn;

	@FindBy(xpath="(//button[@class='btn btn-secondary'])")
	WebElement newCustomerBtn;

	@FindBy(xpath="(//div[contains(text(), ' Name and Phone ')])")
	WebElement nameAndPhoneTab;

	@FindBy(xpath="(//input[@id='mgiRewardsNumber'])")
	WebElement searchwithplusnumber;

	//input[@id='mgiRewardsNumber']

	@FindBy(id="consumer_LastName")
	WebElement consumerLastNameField;

	@FindBy(id="consumer_PrimaryPhone")
	WebElement consumerPhoneField;

	//**************Customer Search Results*************************

	@FindBy(xpath="(//p[@class='customer-name'])")
	WebElement customerSearchResults;
	//p[@class='customer-name']

	//div[@class='row receiver-header']
	@FindBy(xpath="(//div[@class='prev-receiver'])")
	WebElement existingrec;


	//*************************************** Sender Info ***********************************

	@FindBy(id="sender_FirstName")
	WebElement senderFirstName;

	@FindBy(id="sender_LastName")
	WebElement senderLastName;

	@FindBy(xpath="//input[@placeholder='Enter a location']")
	WebElement senderAddressField;
	@FindBy(xpath="(//input[@placeholder='Enter a location'])[2]")
	WebElement senderAddressField1;

	//	@FindBy(xpath="//div/div/select")
	@FindBy(xpath = "//option[contains(text(), 'Year')]/ancestor::select")
	//@FindBy(xpath = "//select[@id='sender_DOB_year']")
			//input[@id='sender_DOB_year']
	WebElement selectBirthYear;

	@FindBy(xpath="//input[@id='sender_DOB_year']")
	WebElement selectBirthYear1;
	@FindBy(xpath="//input[@list='sender_DOB_dateMonthData']")
	WebElement selectBirthMonth1;
	@FindBy(xpath="//input[@list='sender_DOB_dateDaysData']")
	WebElement selectBirthDay1;

	//	@FindBy(xpath="//div[2]/select")
	@FindBy(xpath = "//option[contains(text(), 'Month')]/ancestor::select")
	//@FindBy(xpath = "//select[@id='sender_DOB_month']")
			//input[@list='sender_DOB_dateMonthData']
	WebElement selectBirthMonth;

	//	@FindBy(xpath="//div[3]/select")
	@FindBy(xpath = "//option[contains(text(), 'Day')]/ancestor::select")
	//input[@list='sender_DOB_dateDaysData']
	WebElement selectBirthDay;

	@FindBy(xpath="//app-typeahead[@id='sender_Birth_Country']/input[@type='text']")
	WebElement birthCountryField;

	String countryXpath = "//span[text()='%s']";

	@FindBy(xpath="(//*[@id=\"Primary Phone Country Code\"]/input)")
	WebElement primaryCountryCode;

	@FindBy(xpath="((//*[@id=\"Primary Phone Country Code\"]/input)[2])")
	WebElement primaryCountryCode2;

	@FindBy(xpath="(//input[@id='bankIdentifier_WithLookup'])")
	WebElement bankroutenum;

	@FindBy(xpath="(//span[contains(text(),'Search')])")
	WebElement searchbank;

	@FindBy(xpath="((//*[@id=\"Primary Phone Country Code\"]/input)[2])")
	WebElement primaryCountryCode1;


	@FindBy(xpath="(//*[@id=\"sender_PrimaryPhone\"])")
	WebElement senderPrimaryPhoneNumber;

	@FindBy(xpath="(//input[@id='receiver_PrimaryPhone'])")
	WebElement senderPrimaryPhoneNumber1;


	@FindBy(xpath="(//input[@id='accountNumber'])")
	WebElement accountnum;

	@FindBy(xpath="(//input[@id='accountNumberVerification'])")
	WebElement reenteraccountnum;

	@FindBy(xpath="(//input[@id='bankIdentifier_WithLookup'])")
	WebElement ifscinput;

	@FindBy(xpath="(//span[@class='checkmark'])[1]")
	WebElement mobilenumbercheckbox;



	@FindBy(xpath="(//*[@id=\"sender_Email\"])")
	WebElement senderEmail;

	@FindBy(xpath="(//*[@id=\"sender_PreferredLanguage\"])")
	WebElement senderPreferredLanguage;

	@FindBy(xpath="(//*[@id=\"Receive Offers_radio\"]/ul/li[4]/label/span)")
	WebElement marketingNotifications;

	@FindBy(xpath="(//*[@id=\"Receive Offers_radio\"]/ul/li[1]/label/span)")
	WebElement marketingNotificationss;

	@FindBy(xpath="((//span[@class='checkmark'])[2])")
	WebElement plusnumcheckbox;

	@FindBy(xpath="(//input[@id='sender_Marketing_NotificationOptedCode_1'])")
	WebElement marketingnotifictns;

	@FindBy(xpath="(//*[@id=\"Receive Transaction Status_radio\"]/ul/li[4]/label/span)")
	WebElement transactionNotifications;

	@FindBy(xpath="(//*[@id=\"Receive Transaction Status_radio\"]/ul/li[1]/label/span)")
	WebElement transactionNotificationss;


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

	@FindBy(xpath="//span[contains(text(),'Estimate Fee')]")
	WebElement estimatefee;

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

	@FindBy (xpath ="//span[contains(text(),'Account Deposit')]")
	WebElement acountDepositOption;

	@FindBy (xpath ="//span[contains(text(),'Home Delivery')]")
	WebElement homedeliveryoption;

	@FindBy (xpath ="//div[contains(text(),'Home Delivery')]")
	WebElement homedeliveryoptiontype;

	@FindBy (xpath ="//div[contains(text(),' 10 Minute Service')]")
	WebElement tenMinuteService;

	@FindBy (xpath ="//span[contains(text(),' Account Deposit ' )]")
	WebElement accountdeposit;

	@FindBy (xpath ="//div[contains(text(),'Bank Deposit ')]")
	WebElement directToAccount;

	@FindBy (xpath ="//div[contains(text(),' Direct to Account  ')]")
	WebElement directToAccount1;


	@FindBy (xpath ="//div[contains(text(),' Bank Deposit - All Banks ')]")
	WebElement bankDepositAllBanks;

	@FindBy (xpath ="//div[contains(text(),' Bank Deposit - Xpress24x7  ')]")
	WebElement bankDepositXpress;


	//***********************Indentification**********************************************************

	@FindBy(xpath = "//select[@id='sender_PersonalId1_Type']")
	WebElement selectIdType;

	@FindBy(xpath = "(//button[@id='image-scan'])[2]")
	WebElement scanfront;

	@FindBy(xpath = "(//button[@id='image-scan'])[1]")
	WebElement scanback;

	@FindBy(xpath = "//*[@id='Confirm image matches customer ID_radio']/div[1]/label/span")
	WebElement verifyimageradiobutton;

	//*[@id='Confirm image matches customer ID_radio']/div[1]/label/span

	@FindBy(xpath = "//select[@id='sender_PersonalId1_Choice']")
	WebElement selectId1Choice;

	@FindBy(xpath = "//select[@id='sender_PersonalId2_Choice']")
	WebElement selectId2Choice;

	@FindBy(xpath = "//select[@id='sender_PersonalId2_Type']")
	WebElement selectId2Type;

	@FindBy(xpath = "//input[@id='sender_PersonalId1_Number']")
	WebElement idNumber;

	@FindBy(xpath = "//input[@id='sender_PersonalId1_VerificationStr']")
	WebElement id1verify;

	@FindBy(xpath = "//input[@id='sender_PersonalId2_VerificationStr']")
	WebElement id2verify;



	@FindBy(xpath = "//input[@id='sender_PersonalId1_VerificationStr']")
	WebElement verifyidexistingID;



	@FindBy(xpath = "//input[@id='sender_PersonalId2_Number']")
	WebElement id2Number;

	@FindBy(xpath = "//*[@id=\"sender_PersonalId1_Issue_Country\"]/input")
	WebElement idIssueCountry;

	//@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]/select")
	@FindBy(xpath = "//input[@id='STRKEY_EXPIRATION_DATE_year']")
	WebElement selectExpirationYear;


	@FindBy(xpath = "//div[contains(text(),'None')]")
	WebElement thirdpartynone;
	@FindBy(xpath = "//select[@id='thirdParty_Sender_Type']")
	WebElement thirdparty;
	@FindBy(xpath = "//select[@id='sender_Occupation']")
	WebElement senderoccupationn;

	@FindBy(xpath = "//select[@id='relationshipToReceiver']")
	WebElement relationtoReceiver;

	@FindBy(xpath = "//input[@id='direction1']")
	WebElement direction1;

	//@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]/select")
	@FindBy(xpath = "//input[@id='STRKEY_EXPIRATION_DATE_month']")
	WebElement selectExpirationMonth;

	//@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]/select")
	@FindBy(xpath = "//input[@id='STRKEY_EXPIRATION_DATE_day']")
	WebElement selectExpirationDate;

	@FindBy(xpath = "//*[@id=\"sender_PersonalId1_Issue_Country_SubdivisionCode\"]/input")
	WebElement idIssueState;

	@FindBy(xpath = "//input[@id='sender_PersonalId1_Issue_City']")
	WebElement issueCity;

	@FindBy(xpath = "//select[@id='sender_PersonalId1_Issue_Authority']")
	WebElement issueAuthorityy;

	@FindBy(xpath = "//input[@id='STRKEY_ISSUE_DATE_year']")
	WebElement selectissueyear;

	@FindBy(xpath = "//input[@id='STRKEY_ISSUE_DATE_month']")
	WebElement selectissuemonth;

	@FindBy(xpath = "//input[@id='STRKEY_ISSUE_DATE_day']")
	WebElement selectissuedate;





	//*[@id="sender_PersonalId1_Issue_Country_SubdivisionCode"]/input


	//***********************Additional Information**********************************************

	@FindBy(xpath = "//*[@id='sender_Birth_Country']/input")
	WebElement birthCountry;
//(//input[@role='combobox'])[1]


	@FindBy(xpath = "//select[@id='sender_Gender']")
	WebElement sengender;

	@FindBy(xpath = "//input[@class='form-control required ng-pristine ng-valid ng-touched']")
	WebElement sennationality;

	@FindBy(xpath = "//input[@id='sender_Birth_City']")
	WebElement birthcity;



	@FindBy(xpath = "//*[@id='sender_Residence_Country']/input")
	WebElement permaaddress;
//(//input[@role='combobox'])[1]

	@FindBy(xpath = "//*[@id='sender_CitizenshipCountry']/input")
	WebElement countrycitizen;

	@FindBy(xpath = "//select[@id='sourceOfFunds']")
	WebElement fundssource;

	@FindBy(xpath = "//select[@id='send_PurposeOfTransaction']")
	WebElement transactionpurpose;

	@FindBy(xpath = "//select[@id='sendPurposeOfTransactionPartnerField']")
	WebElement purposeoffunds;

	//**********************Receiver Information*********************************************

	@FindBy(xpath="//input[@id='receiver_FirstName']")
	WebElement receiverFirstName;

	@FindBy(xpath="//input[@id='receiver_LastName']")
	WebElement receiverLastName;

	@FindBy(xpath="//input[@id='receiver_City']")
	WebElement receivercity;

	@FindBy(xpath="//input[@id='receiver_PrimaryPhone']")
	WebElement receiverphone;

	@FindBy(xpath = "//span[contains(text(),' Submit ')]")
	WebElement submitBtn;

	@FindBy(xpath = "(//*[@id=\"Primary Phone Country Code\"]/input)[2]")
	WebElement countrycodeAdtnldetails;

	Actions actions=new Actions(driver);

	@FindBy(xpath = "//button[@class='btn btn-tertiary']")
	WebElement backbutton;

	@FindBy(xpath = "//input[@id='mgiRewardsNumber']")
	WebElement plusnumgenerated;

	@FindBy(xpath = "//p[@class='field-value']")
	WebElement plusnumgeneratedd;


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

	@FindBy(xpath = "//button[@id='yes']")
	WebElement fraudalertOK;


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

	@FindBy(xpath = "(//div[@class='col-6 frame-value'])[1]")
	WebElement discount20percent;






	//*************************** End of objects **********************************************

	//CONSTRUCTOR
	public AgentWorksSinglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//METHODS
	public void selectexistreceiverIT() throws InterruptedException {
		/*Thread.sleep(1000);
		if(isElementDisplayed(existingrec,2)){
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", existingrec);
			existingrec.click();
		}
		else{*/
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", destCountry);

			destCountry.sendKeys("usa");
			destCountry.sendKeys(Keys.ARROW_DOWN);
			destCountry.sendKeys(Keys.ENTER);

	}

public void selectexistreceiver() throws InterruptedException {
		Thread.sleep(5000);
		if(isElementDisplayed(existingrec,2)){
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", existingrec);
			existingrec.click();
		}

		}


	public void clickSendCard() throws InterruptedException {

		Assert.assertTrue(isElementDisplayed(sendCard, 2));

		sendCard.click();

	}
	public void submitdetailsforexistus() throws InterruptedException {
		submitBtn.click();
		Thread.sleep(3000);

		/*Thread.sleep(5000);
		if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, "2025");
			selectDdlByText(selectExpirationMonth, "12");
			selectDdlByText(selectExpirationDate, "12");
		}*/

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys("TX");
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}
		submitBtn.click();
		Thread.sleep(3000);
		/*if(isElementDisplayed(selectId2Type,2)){
			selectexistingIDtwoforus();
		}*/
	}

	public void submitdetailsforexistingIT() throws InterruptedException {
		submitBtn.click();
		Thread.sleep(4000);

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", idIssueState);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys("IT-TE");Thread.sleep(1000);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(issueCity,2)) {
			issueCity.sendKeys("Taranto");
			Thread.sleep(3000);
		}

		if(isElementDisplayed(issueAuthorityy,2)) {
			selectDdlByText(issueAuthorityy, "Embassy");
			Thread.sleep(1000);
		}

		if(isElementDisplayed(selectissueyear,2)) {
			selectDdlByText(selectissueyear, "2020");Thread.sleep(1000);
			selectDdlByText(selectissuemonth, "12");Thread.sleep(1000);
			selectDdlByText(selectissuedate, "12");Thread.sleep(1000);
		}

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, "2025");Thread.sleep(1000);
			selectDdlByText(selectExpirationMonth, "12");Thread.sleep(1000);
			selectDdlByText(selectExpirationDate, "12");Thread.sleep(1000);
		}

		submitBtn.click();
		Thread.sleep(5000);

	}

public void submitdetailsforexistDE() throws InterruptedException {
	submitBtn.click();

	Thread.sleep(5000);
	if(isElementDisplayed(selectExpirationYear,2)) {
		selectDdlByText(selectExpirationYear, "2025");
		selectDdlByText(selectExpirationMonth, "12");
		selectDdlByText(selectExpirationDate, "12");
	}

	if(isElementDisplayed(idIssueState,2)) {
		idIssueState.sendKeys("Berlin");
		idIssueState.sendKeys(Keys.ARROW_DOWN);
		idIssueState.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	submitBtn.click();
	Thread.sleep(5000);

}
	public void validate40percentSummarypage(){

		boolean discount1 =discount20percent.isDisplayed();
		if(discount1){
			String disc1 =discount20percent.getText();
			Assert.assertTrue(true,"20 percent is displayed as expected:" + disc1);
		}
		else{
			Assert.fail("Discount is not displayed");
		}

	}
public void validate20percentSummarypage(){



			boolean discount1 =discount20percent.isDisplayed();
			if(discount1){
				String disc1 =discount20percent.getText();
				Assert.assertTrue(true,"20 percent is displayed as expected:" + disc1);
			}
			else{
				Assert.fail("Discount is not displayed");
			}

}
public void completesendmoney() throws InterruptedException {

	WebElement ele = driver.findElement(By.xpath("//button[@id='yes']"));

	if(isElementDisplayed(ele,2)) {
		ele.click();

	}

		sendMoneyBtn.click();
	Thread.sleep(4000);
	//finalPage.put("Referencenumber", Referencenumber);
	finished.click();Thread.sleep(3000);

}

	public void verify40percentdiscountUSA() throws InterruptedException, AWTException {
		for(int i=0;i<4;i++) {
			clickSendCard();
			existcustsearchwithplusnum();
			selectexistreceiver();
			destAmountforexistingcust();
			selectserviceOptionforplus();
			selectexistingIDoneforus();
			//additionalInfoexistforDE();
			submitdetailsforexistus();
			if(i==3) {
				validate20percentSummarypage();
			}
			completesendmoney();
		}
	}

	public void verify40percentdiscountIT() throws InterruptedException, AWTException {
		for(int i=0;i<4;i++) {
			clickSendCard();
			existcustsearchwithplusnum();
			//selectexistreceiver();
			destAmountforexistingcust();
			selectserviceOptionforplus();
			selectexistingIDoneforIT();
			additionalInfoexistingIT();
			receiverinfoforexistingIT();
			submitdetailsforexistingIT();
			if(i==3) {
				validate20percentSummarypage();
			}
			completesendmoney();
		}
	}
	public void verify40percentdiscount() throws InterruptedException, AWTException {
		for(int i=0;i<4;i++) {
			clickSendCard();
			existcustsearchwithplusnum();
			selectexistreceiver();
			destAmountforexistingcust();
			selectserviceOptionforplus();
			selectexistingIDoneforDE();
			additionalInfoexistforDE();
			submitdetailsforexistus();
			if(i==3) {
				validate20percentSummarypage();
			}
			completesendmoney();
		}
	}
public void addthirdpartytype() throws InterruptedException {
	if(isElementDisplayed(thirdparty,2)) {
		selectDdlByText(thirdparty, "None");
		Thread.sleep(2000);

	}
}
	public void verify20percentdiscountUSAHighamounts() throws InterruptedException, AWTException {
		clickSendCard();
		existcustsearchwithplusnum();
		selectexistreceiver();
		//destAmountforexistingcust();
		destAmountforexistingcusthighamount();
		selectserviceOptionforplus();
		selectexistingIDoneforus();
		selectexistingIDtwoforus();
		addthirdpartytype();
		//additionalInfoexistforDE();
		submitdetailsforexistus();
		validate20percentSummarypage();
		completesendmoney();

	}
	public void verify20percentdiscountUSA() throws InterruptedException, AWTException {
		clickSendCard();
		existcustsearchwithplusnum();
		selectexistreceiver();
		destAmountforexistingcust();
		selectserviceOptionforplus();
		selectexistingIDoneforus();
		//selectexistingIDtwoforus();
		//additionalInfoexistforDE();
		submitdetailsforexistus();
		validate20percentSummarypage();
		completesendmoney();

	}

	public void verify20percentdiscountIT() throws InterruptedException, AWTException {
		clickSendCard();
		existcustsearchwithplusnum();
		//selectexistreceiverIT();
		destAmountforexistingcust();
		selectserviceOptionforplus();
		//selectexistingIDoneforDE();
		selectexistingIDoneforIT();
		additionalInfoexistingIT();
		receiverinfoforexistingIT();
		submitdetailsforexistingIT();
		validate20percentSummarypage();
		completesendmoney();

	}
	public void verify20percentdiscount() throws InterruptedException, AWTException {
		clickSendCard();
		existcustsearchwithplusnum();
		selectexistreceiver();
		destAmountforexistingcust();
		selectserviceOptionforplus();
		selectexistingIDoneforDE();
		additionalInfoexistforDE();
		submitdetailsforexistDE();
		validate20percentSummarypage();
		completesendmoney();

	}

	public void searchUsingLastNameAndPhoneNumber(String lastName, String phoneNumber) throws InterruptedException {
		nameAndPhoneTab.click();
		//consumerLastNameField.sendKeys(lastName);
		Assert.assertTrue(isElementDisplayed(consumerLastNameField, 2));
		if(!lastName.equalsIgnoreCase("NA")){
			consumerLastNameField.sendKeys(lastName);
		}
		else{
			lastname1 = getRandomString(5).toLowerCase();
			consumerLastNameField.sendKeys(lastname1);
		}
		consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
Thread.sleep(3000);
		newCustomerBtn.click();
		Thread.sleep(5000);

	}

	public void sendtonewcustomer(String lastName, String phoneNumber) throws InterruptedException {
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
		customerSearchResults.click();
		Thread.sleep(4000);
	}


	public void existcustsearchwithplusnumber(String plusnumb) throws InterruptedException {
		//nameAndPhoneTab.click();
		searchwithplusnumber.sendKeys(plusnumb);
		//consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
		customerSearchResults.click();
		Thread.sleep(4000);


	}
	public void existcustsearchwithplusnum() throws InterruptedException {
		//nameAndPhoneTab.click();
		searchwithplusnumber.sendKeys(plusnummber);
		//consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
		customerSearchResults.click();
		Thread.sleep(4000);


	}


	public void searchForExistingCustomer(String lastName, String phoneNumber) throws InterruptedException {
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
		searchBtn.click();
		Thread.sleep(3000);
		customerSearchResults.click();
		Thread.sleep(5000);


	}
	public void fillNewSenderInformationforexisting(String senFName, String senLName, String birthYear, String birthMonth, String birthDay, String address, String countryCode, String phone, String email, String language) throws AWTException, InterruptedException {

		if(isElementDisplayed(senderPreferredLanguage,2)) {
			senderPreferredLanguage.sendKeys(language);
			senderPreferredLanguage.sendKeys(Keys.ARROW_DOWN);
			senderPreferredLanguage.sendKeys(Keys.ENTER);Thread.sleep(1000);

		}

	}
	public void fillNewSenderInformationefee(String senFName, String senLName, String senBirthYear, String senBirthMonth, String senBirthDay, String address, String countryCode, String phone, String email, String language) throws AWTException, InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(isElementDisplayed(senderFirstName, timeToWait));

		if(!senFName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			senderFirstName.sendKeys(senFName);
			Thread.sleep(3000);
		}

		else{
			firstname = getRandomString(5).toLowerCase();
			senderFirstName.sendKeys(firstname);
			Thread.sleep(2000);
		}
		Assert.assertTrue(isElementDisplayed(senderLastName, timeToWait));
		if(!senLName.equalsIgnoreCase("NA")){
			senderLastName.sendKeys(senLName);
		}
		else{
			lastname = getRandomString(5).toLowerCase();
			senderLastName.sendKeys(lastname);Thread.sleep(1000);
		}

		if(!senBirthYear.equalsIgnoreCase("NA")) {
			//selectDdlByText(selectBirthYear, senBirthYear);Thread.sleep(1000);
			selectBirthYear1.sendKeys("1982");
			selectBirthYear1.sendKeys(Keys.ARROW_DOWN);
			selectBirthYear1.sendKeys(Keys.ENTER);Thread.sleep(2000);
			//selectDdlByText(selectBirthMonth, senBirthMonth);Thread.sleep(1000);
			selectBirthMonth1.sendKeys("12");
			selectBirthMonth1.sendKeys(Keys.ARROW_DOWN);
			selectBirthMonth1.sendKeys(Keys.ENTER);Thread.sleep(2000);
			//selectDdlByText(selectBirthDay, senBirthDay);Thread.sleep(1000);
			selectBirthDay1.sendKeys("12");
			selectBirthDay1.sendKeys(Keys.ARROW_DOWN);
			selectBirthDay1.sendKeys(Keys.ENTER);Thread.sleep(2000);
		}

		if(isElementDisplayed(senderAddressField,2)) {
			/*Actions actions = new Actions(driver);
			actions
					.click(senderAddressField)
					.sendKeys(senderAddressField,address)
					.build().perform();
					actions.sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER)
					.build()
					.perform();*/
			senderAddressField.sendKeys(address);
			Thread.sleep(1000);
			senderAddressField.sendKeys(Keys.ARROW_DOWN);
			senderAddressField.sendKeys(Keys.ENTER);
		}
		else{
			driver.findElement(By.xpath("//*[@id='sender_Address_helpText']/ancestor::div[1]/input")).sendKeys(address);
		}

		if(isElementDisplayed(primaryCountryCode,2)) {
			primaryCountryCode.clear();
			primaryCountryCode.sendKeys(countryCode);Thread.sleep(2000);
			primaryCountryCode.sendKeys(Keys.ARROW_DOWN);
			primaryCountryCode.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//actions.build().perform();
		}

		if(isElementDisplayed(senderPrimaryPhoneNumber,2)) {
			senderPrimaryPhoneNumber.sendKeys(phone);Thread.sleep(3000);
		}

		marketingNotificationss.click();Thread.sleep(1000);
		transactionNotificationss.click();Thread.sleep(1000);

		/*if(isElementDisplayed(mobilenumbercheckbox,2)) {
			mobilenumbercheckbox.click();
			Thread.sleep(2000);
		}*/

		if(isElementDisplayed(senderEmail,2)) {
			senderEmail.sendKeys(email);Thread.sleep(1000);
		}

		if(isElementDisplayed(senderPreferredLanguage,2)) {
			senderPreferredLanguage.sendKeys(language);
			senderPreferredLanguage.sendKeys(Keys.ARROW_DOWN);
			senderPreferredLanguage.sendKeys(Keys.ENTER);Thread.sleep(1000);

		}
	}


	public void fillNewSenderInformation(String senFName, String senLName, String senBirthYear, String senBirthMonth, String senBirthDay, String address, String countryCode, String phone, String email, String language) throws AWTException, InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(isElementDisplayed(senderFirstName, timeToWait));

		if(!senFName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			senderFirstName.sendKeys(senFName);
			Thread.sleep(3000);
		}

		else{
			firstname = getRandomString(5).toLowerCase();
			senderFirstName.sendKeys(firstname);
			Thread.sleep(2000);
		}
		Assert.assertTrue(isElementDisplayed(senderLastName, timeToWait));
		if(!senLName.equalsIgnoreCase("NA")){
			senderLastName.sendKeys(senLName);
		}
		else{
			lastname = getRandomString(5).toLowerCase();
			senderLastName.clear();
			senderLastName.sendKeys(lastname);Thread.sleep(1000);
		}

		if(!senBirthYear.equalsIgnoreCase("NA")) {
			/*selectDdlByText(selectBirthYear, senBirthYear);Thread.sleep(1000);
			selectDdlByText(selectBirthMonth, senBirthMonth);Thread.sleep(1000);
			selectDdlByText(selectBirthDay, senBirthDay);Thread.sleep(1000);*/

			selectBirthYear1.sendKeys("1982");
			selectBirthYear1.sendKeys(Keys.ARROW_DOWN);
			selectBirthYear1.sendKeys(Keys.ENTER);Thread.sleep(2000);
			//selectDdlByText(selectBirthMonth, senBirthMonth);Thread.sleep(1000);
			selectBirthMonth1.sendKeys("12");
			selectBirthMonth1.sendKeys(Keys.ARROW_DOWN);
			selectBirthMonth1.sendKeys(Keys.ENTER);Thread.sleep(2000);
			//selectDdlByText(selectBirthDay, senBirthDay);Thread.sleep(1000);
			selectBirthDay1.sendKeys("12");
			selectBirthDay1.sendKeys(Keys.ARROW_DOWN);
			selectBirthDay1.sendKeys(Keys.ENTER);Thread.sleep(2000);
		}

		if(isElementDisplayed(senderAddressField,2)) {
			/*Actions actions = new Actions(driver);
			actions
					.click(senderAddressField)
					.sendKeys(senderAddressField,address)
					.build().perform();
					actions.sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER)
					.build()
					.perform();*/
			senderAddressField.sendKeys(address);
			Thread.sleep(1000);
			senderAddressField.sendKeys(Keys.ARROW_DOWN);
			senderAddressField.sendKeys(Keys.ENTER);
		}
		else{
			driver.findElement(By.xpath("//*[@id='sender_Address_helpText']/ancestor::div[1]/input")).sendKeys(address);
		}

		if(isElementDisplayed(primaryCountryCode,2)) {
			primaryCountryCode.clear();
			primaryCountryCode.sendKeys(countryCode);Thread.sleep(2000);
			primaryCountryCode.sendKeys(Keys.ARROW_DOWN);
			primaryCountryCode.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//actions.build().perform();
		}

		if(isElementDisplayed(senderPrimaryPhoneNumber,2)) {
			senderPrimaryPhoneNumber.clear();
			senderPrimaryPhoneNumber.sendKeys(phone);Thread.sleep(3000);
		}

		/*if(isElementDisplayed(mobilenumbercheckbox,2)) {

			mobilenumbercheckbox.click();
			Thread.sleep(2000);
		}*/

		if(isElementDisplayed(senderEmail,2)) {
			senderEmail.sendKeys(email);Thread.sleep(1000);
		}

		if(isElementDisplayed(senderPreferredLanguage,2)) {
			senderPreferredLanguage.sendKeys(language);
			senderPreferredLanguage.sendKeys(Keys.ARROW_DOWN);
			senderPreferredLanguage.sendKeys(Keys.ENTER);Thread.sleep(1000);

		}
	}

	public void selectplusnumber() throws InterruptedException, AWTException {
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		if(isElementDisplayed(plusnumcheckbox,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", plusnumcheckbox);

			plusnumcheckbox.click();Thread.sleep(2000);
			marketingNotificationss.click();Thread.sleep(1000);
			transactionNotificationss.click();Thread.sleep(1000);
			}
	}

	public void destinationAndAmountusingplusnumberhigh(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		selectplusnumber();
			senderPreferredLanguage.sendKeys("English");
			senderPreferredLanguage.sendKeys(Keys.ARROW_DOWN);
			senderPreferredLanguage.sendKeys(Keys.ENTER);Thread.sleep(1000);

				//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);
		sendMoney.sendKeys(amount);
		Thread.sleep(3000);
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);
				DestinationState.sendKeys(DestState);
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

	public void destAmountforexistingcusthighamount() throws InterruptedException, AWTException {
		//selectplusnumber();
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys("500");
		Thread.sleep(3000);
		/*destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);*/

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys("TX");
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}Thread.sleep(3000);
		}

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}


	public void destAmountforexistingcust() throws InterruptedException, AWTException {
		//selectplusnumber();
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys("10");
		Thread.sleep(3000);
		destCountry.sendKeys("usa");
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys("TX");
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}Thread.sleep(3000);
		}

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

	public void destinationAndAmountexistplusnumHigh(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		selectplusnumber();
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys(amount);
		Thread.sleep(3000);
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys(DestState);
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}Thread.sleep(3000);
		}

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}


	public void destinationAndAmountusingplusnumber(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		//selectplusnumber();
		/*if(isElementDisplayed(senderPreferredLanguage,2)) {
			senderPreferredLanguage.sendKeys("English");
			senderPreferredLanguage.sendKeys(Keys.ARROW_DOWN);
			senderPreferredLanguage.sendKeys(Keys.ENTER);Thread.sleep(1000);

		}
		if(isElementDisplayed(mobilenumbercheckbox,2)) {
			mobilenumbercheckbox.click();
			Thread.sleep(2000);
		}*/
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys(amount);
		Thread.sleep(3000);
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys(DestState);
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}Thread.sleep(3000);
		}

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}


	public void destinationAndAmountexistReceiver(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys(amount);
		Thread.sleep(3000);

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys(DestState);
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}Thread.sleep(3000);
		}

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

public void validationmesgforereceivecurrencies(){
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Not all currencies are available')]"));
	if(isElementDisplayed(ele,2)){
		boolean valmsg=ele.isDisplayed();
		String recCurencyValMsg =ele.getText();
	}
	}
	public void destinationAndAmountexistcust(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys(amount);
		Thread.sleep(3000);
		if(destCountry.isEnabled())
		{
			destCountry.sendKeys(destinationCountry);Thread.sleep(1000);
			destCountry.sendKeys(Keys.ARROW_DOWN);
			destCountry.sendKeys(Keys.ENTER);

		}

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys(DestState);
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}Thread.sleep(3000);
		}

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

	public void destinationAndAmountnoState(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
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

		if(isElementDisplayed(transactionNotifications,2)) {
			transactionNotifications.click();
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

	public void destinationAndAmountforexistingcust(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		//Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sendMoney);

		sendMoney.sendKeys(amount);
		Thread.sleep(3000);

		/*destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);*/

		if(isElementDisplayed(DestinationState,2)) {
			boolean status = DestinationState.isEnabled();
			if(status){
				DestinationState.sendKeys(DestState);
				DestinationState.sendKeys(Keys.ARROW_DOWN);
				DestinationState.sendKeys(Keys.ENTER);}
		}


		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);
	}

	public void Estimatefeenostate(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));
		sendMoney.sendKeys(amount);
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", estimatefee);

		estimatefee.click();
		Thread.sleep(3000);
	}

	public void Estimatefee(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
		Assert.assertTrue(isElementDisplayed(sendMoney, timeToWait));
sendMoney.sendKeys(amount);
		destCountry.sendKeys(destinationCountry);
		destCountry.sendKeys(Keys.ARROW_DOWN);
		destCountry.sendKeys(Keys.ENTER);

			DestinationState.sendKeys(DestState);
			DestinationState.sendKeys(Keys.ARROW_DOWN);
			DestinationState.sendKeys(Keys.ENTER);Thread.sleep(2000);

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", estimatefee);

		estimatefee.click();
		Thread.sleep(3000);
	}

	public void destinationAndAmountforpromocode(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
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

		/*if(isElementDisplayed(transactionNotifications,2)) {
			transactionNotifications.click();
		}*/
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);

		WebElement ele= driver.findElement(By.xpath("(//input[@id='STRKEY_PROMO_CODE'])[1]"));
		ele.sendKeys("JEWELMG2");

		transactionQuote.click();
		Thread.sleep(3000);
	}

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
		/*if(isElementDisplayed(transactionNotifications,2)) {
			transactionNotifications.click();
		}*/
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", transactionQuote);
		transactionQuote.click();
		Thread.sleep(3000);

	}

	public void destinationAndAmountgreaterthan50000(String amount, String destinationCountry,String DestState ) throws InterruptedException, AWTException {
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

		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'Max amount exceeded')]"));
		if(ele.isDisplayed()){

			Assert.assertTrue(true,"Validation message for receiver amount greater than 50000");

		}
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

	public void serviceOption_homedelivery()throws InterruptedException{
		Assert.assertTrue(isElementDisplayed(homedeliveryoption, 2));
		homedeliveryoption.click();Thread.sleep(3000);
		homedeliveryoptiontype.click();Thread.sleep(3000);

	}
	public void selectserviceOptionforplus()throws InterruptedException{
		Assert.assertTrue(isElementDisplayed(tenMinuteService, 2));
		tenMinuteService.click();Thread.sleep(3000);
	}

	public void serviceOptionAccountDeposittoBangldesh(String Serviceoption)throws InterruptedException{
		Assert.assertTrue(isElementDisplayed(accountdeposit, 2));
		accountdeposit.click();Thread.sleep(3000);
		directToAccount1.click();Thread.sleep(1000);
	}
	public void serviceOptionAccountDeposit(String Serviceoption)throws InterruptedException{
		Assert.assertTrue(isElementDisplayed(accountdeposit, 2));
		accountdeposit.click();Thread.sleep(3000);
		directToAccount.click();Thread.sleep(1000);
	}
	public void serviceOption(String Serviceoption)throws InterruptedException{
		Assert.assertTrue(isElementDisplayed(tenMinuteService, 5));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tenMinuteService);

		tenMinuteService.click();Thread.sleep(5000);
	}
	public void selectexistingIDtwoforus() throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId2Choice);

		selectDdlByText(selectId2Choice, "Enter New ID");Thread.sleep(1000);
		selectDdlByText(selectId2Type, "Social Security Number");
		id2Number.clear();
		id2Number.sendKeys("909034642");Thread.sleep(2000);
	}

	public void selectexistingIDtwo(String id2choice, String id2Type,  String id2num) throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId2Choice);
if(selectId2Choice.isDisplayed()){
	selectDdlByText(selectId2Choice, id2choice);Thread.sleep(1000);
	selectDdlByText(selectId2Type, id2Type);
	id2Number.sendKeys(id2num);Thread.sleep(2000);
}
/*
else{
	selectDdlByText(selectId2Type, id2Type);
	id2Number.sendKeys(id2num);Thread.sleep(2000);
}*/

	}
	public void selectIDtwo(String idtwotype, String idtwonumber) throws InterruptedException{
					if(isElementDisplayed(selectId2Type,2)) {
				selectDdlByText(selectId2Type, idtwotype);Thread.sleep(1000);
				id2Number.sendKeys(idtwonumber);                                                                 Thread.sleep(2000);

			}
		}




	public void selectexistingIDoneforus() throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);

		selectDdlByText(selectId1Choice, "Enter New ID");Thread.sleep(1000);
		selectDdlByText(selectIdType, "Drivers License");Thread.sleep(1000);
		idNumber.sendKeys("569321478");
		//verifyidexistingID.sendKeys(idNumonFile);

		idIssueCountry.sendKeys("USA");
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);Thread.sleep(3000);


	}


	public void selectexistingIDoneforIT() throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);

		selectDdlByText(selectId1Choice, "Enter New ID");Thread.sleep(1000);
		selectDdlByText(selectIdType, "Drivers License");Thread.sleep(1000);
		idNumber.sendKeys("910087456");
		//verifyidexistingID.sendKeys(idNumonFile);

		idIssueCountry.sendKeys("ITALY");
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId2Choice);

		selectDdlByText(selectId2Choice, "Enter New ID");Thread.sleep(1000);
		selectDdlByText(selectId2Type, "Codice Fiscale");Thread.sleep(1000);
		id2Number.sendKeys("ABCDEF82B11C234F");
		//verifyidexistingID.sendKeys(idNumonFile);
		Thread.sleep(2000);
	}

	public void selectexistingIDoneforDE() throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);

		selectDdlByText(selectId1Choice, "Enter New ID");Thread.sleep(1000);
		selectDdlByText(selectIdType, "Passport");Thread.sleep(1000);
		idNumber.sendKeys("569321478");
		//verifyidexistingID.sendKeys(idNumonFile);

		idIssueCountry.sendKeys("DEU");
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);Thread.sleep(3000);
	}




	public void selectexistingIDoneEfee(String id1choice, String id1type, String id1num, String id1issuecountry, String idstate) throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);
		if (selectId1Choice.isDisplayed()) {
			selectDdlByText(selectId1Choice, id1choice);
			Thread.sleep(1000);
			selectDdlByText(selectIdType, id1type);
			Thread.sleep(1000);
			idNumber.sendKeys(id1num);
		}
		//verifyidexistingID.sendKeys(idNumonFile);

		//selectDdlByText(selectIdType, id1type);Thread.sleep(1000);
		//idNumber.sendKeys(id1num);
		idIssueCountry.sendKeys(id1issuecountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}


	public void selectexistingIDone(String id1choice, String id1type, String id1num, String id1issuecountry) throws InterruptedException {
		//List id1options = driver.findElements(By.xpath("//select[@id='sender_PersonalId1_Type'] | //select[@id='sender_PersonalId1_Choice']"));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);
if(selectId1Choice.isDisplayed())
{
	selectDdlByText(selectId1Choice, id1choice);Thread.sleep(1000);
	selectDdlByText(selectIdType, id1type);Thread.sleep(1000);
	idNumber.sendKeys(id1num);}
	//verifyidexistingID.sendKeys(idNumonFile);

	//selectDdlByText(selectIdType, id1type);Thread.sleep(1000);
	//idNumber.sendKeys(id1num);
	idIssueCountry.sendKeys(id1issuecountry);
	idIssueCountry.sendKeys(Keys.ARROW_DOWN);
	idIssueCountry.sendKeys(Keys.ENTER);Thread.sleep(3000);


	}


	public void identificationforexisting(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

	}

	public void identificationforUK(String idType, String idNum, String idIssCountry, String idstate, String idcity, String issueAuthority, String issueyear, String issuemonth, String issueday, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);Thread.sleep(1000);
			selectDdlByText(selectExpirationMonth, expMon);Thread.sleep(1000);
			selectDdlByText(selectExpirationDate, expDate);Thread.sleep(1000);
		}

		if(isElementDisplayed(selectId2Type,2)) {
			selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number);                                                                 Thread.sleep(2000);

		}
		if(isElementDisplayed(scanfront,2)) {
			scanfront.click();
			Thread.sleep(2000);
		}

		if(isElementDisplayed(scanback,2)) {
			scanback.click();
			Thread.sleep(2000);

		}




	}

	public void identificationforITlowwscanenabled(String idType, String idNum, String idIssCountry, String idstate, String idcity, String issueAuthority, String issueyear, String issuemonth, String issueday, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectExpirationYear.sendKeys("2025");
			selectExpirationMonth.sendKeys("12");
			selectExpirationDate.sendKeys("12");

		}
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scanfront);

		scanfront.click();Thread.sleep(3000);
		scanback.click();Thread.sleep(3000);

		if(isElementDisplayed(selectId2Type,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId2Type);
			selectId2Type.click();
			selectId2Type.sendKeys(Keys.ARROW_DOWN);
			selectId2Type.sendKeys(Keys.ENTER);

			//selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number); Thread.sleep(1000);                                                                Thread.sleep(2000);

		}


		Thread.sleep(3000);

	}

	public void identificationforITlow(String idType, String idNum, String idIssCountry, String idstate, String idcity, String issueAuthority, String issueyear, String issuemonth, String issueday, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectExpirationYear.sendKeys("2025");
			selectExpirationMonth.sendKeys("12");
			selectExpirationDate.sendKeys("12");

		}
		if(isElementDisplayed(selectId2Type,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId2Type);
			selectId2Type.click();
			selectId2Type.sendKeys(Keys.ARROW_DOWN);
			selectId2Type.sendKeys(Keys.ENTER);

			//selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number); Thread.sleep(1000);                                                                Thread.sleep(2000);

		}


		Thread.sleep(3000);

	}


	public void identificationforIT(String idType, String idNum, String idIssCountry, String idstate, String idcity, String issueAuthority, String issueyear, String issuemonth, String issueday, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		/*if(isElementDisplayed(issueCity,2)) {
			issueCity.sendKeys(idcity);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(issueAuthorityy,2)) {
			selectDdlByText(issueAuthorityy, issueAuthority);
			Thread.sleep(1000);
		}

		if(isElementDisplayed(selectissueyear,2)) {
			selectissueyear.sendKeys("2020");
			selectissuemonth.sendKeys("12");
			selectissuedate.sendKeys("12");
		}*/

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectExpirationYear.sendKeys("2025");
			selectExpirationMonth.sendKeys("12");
			selectExpirationDate.sendKeys("12");
			//selectDdlByText(selectExpirationYear, expYear);Thread.sleep(1000);
			//selectDdlByText(selectExpirationMonth, expMon);Thread.sleep(1000);
			//selectDdlByText(selectExpirationDate, expDate);Thread.sleep(1000);
		}
		Thread.sleep(3000);

		if(isElementDisplayed(selectId2Type,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId2Type);

			selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number); Thread.sleep(1000);                                                                Thread.sleep(2000);

		}

	}


	public void identificationforRO(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);Thread.sleep(1000);
			selectDdlByText(selectExpirationMonth, expMon);Thread.sleep(1000);
			selectDdlByText(selectExpirationDate, expDate);Thread.sleep(1000);
		}

	}
	public void scanID() throws InterruptedException {
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scanback);

		scanback.click();Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scanfront);

		scanfront.click();Thread.sleep(2000);
	}
	public void identificationforFRAnce(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectExpirationYear.sendKeys(expYear);
			selectExpirationMonth.sendKeys(expMon);
			selectExpirationDate.sendKeys(expDate);

		}

	}

	public void identificationforDE(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		if(isElementDisplayed(selectExpirationYear,2)) {
			selectExpirationYear.sendKeys(expYear);
			selectExpirationMonth.sendKeys(expMon);
			selectExpirationDate.sendKeys(expDate);

		}
		/*if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}*/
	}
    public void clickonIDverifybutton() throws InterruptedException {
		WebElement ele =driver.findElement(By.xpath("//button[@class='btn btn-primary btn-verify']"));
		ele.click();
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", verifyimageradiobutton);

		//WebElement ele1 =driver.findElement(By.xpath("//*[@id='Confirm image matches customer ID_radio']/div[1]/label/span"));
		verifyimageradiobutton.click();
		Thread.sleep(3000);


}public void identificationforExistingonfilelow(String id1typeonfile,String id1onfile, String id2typeonfile, String id2onfile) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);
		selectDdlByText(selectId1Choice, id1typeonfile);Thread.sleep(1000);
		id1verify.sendKeys(id1onfile);Thread.sleep(1000);

	}


	public void identificationforExistingonfileloww(String id1typeonfile,String id1onfile) throws InterruptedException {

		if (isElementDisplayed(selectId1Choice, 2)) {
			selectDdlByText(selectId1Choice, id1typeonfile);
			Thread.sleep(1000);
			id1verify.sendKeys(id1onfile);
			Thread.sleep(3000);
		}
	}

	public void identificationforExistingonfilehighh(String id2typeonfile, String id2onfile) throws InterruptedException {

		if (isElementDisplayed(selectId2Choice, 2)) {
			selectDdlByText(selectId2Choice, id2typeonfile);
			Thread.sleep(1000);
			id2verify.sendKeys(id2onfile);
			Thread.sleep(3000);
		}
	}

	public void identificationforExistingonfilehigh(String id1typeonfile,String id1onfile, String id2typeonfile, String id2onfile) throws InterruptedException {

			if (isElementDisplayed(selectId2Choice, 2)) {
		selectDdlByText(selectId2Choice, id2typeonfile);
		Thread.sleep(1000);
		id2verify.sendKeys(id2onfile);
		Thread.sleep(3000);
	}
	}

public void identificationforExistingonfile(String id1typeonfile,String id1onfile, String id2typeonfile, String id2onfile) throws InterruptedException {
	//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectId1Choice);
	selectDdlByText(selectId1Choice, id1typeonfile);
	Thread.sleep(1000);
	id1verify.sendKeys(id1onfile);
	Thread.sleep(1000);

	/*if (isElementDisplayed(selectId2Choice, 2)) {
		selectDdlByText(selectId2Choice, id2typeonfile);
		Thread.sleep(1000);
		id2verify.sendKeys(id2onfile);
		Thread.sleep(3000);
	}*/
}
	public void selectID0ne(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		/*if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);
			selectDdlByText(selectExpirationMonth, expMon);
			selectDdlByText(selectExpirationDate, expDate);
		}*/
		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

	}


	public void identificationefeehigh(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		/*if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);
			selectDdlByText(selectExpirationMonth, expMon);
			selectDdlByText(selectExpirationDate, expDate);
		}*/
		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

		if(isElementDisplayed(selectId2Type,2)) {
			selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number);                                                                 Thread.sleep(2000);

		}
	}
	public void identificationefee(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		/*if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);
			selectDdlByText(selectExpirationMonth, expMon);
			selectDdlByText(selectExpirationDate, expDate);
		}*/
		/*if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}*/

	/*	if(isElementDisplayed(selectId2Type,2)) {
			selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number);                                                                 Thread.sleep(2000);

		}*/
	}


	public void identification(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		/*if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);
			selectDdlByText(selectExpirationMonth, expMon);
			selectDdlByText(selectExpirationDate, expDate);
		}*/
		if(isElementDisplayed(idIssueState,2)) {
			idIssueState.sendKeys(idstate);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}

	/*	if(isElementDisplayed(selectId2Type,2)) {
			selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
			id2Number.sendKeys(id2number);                                                                 Thread.sleep(2000);

		}*/
	}


	public void identificationhigh(String idType, String idNum, String idIssCountry, String idstate, String expYear, String expMon, String expDate, String id2type, String id2number) throws InterruptedException{
		//Assert.assertTrue(isElementDisplayed(selectIdType, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectIdType);

		selectDdlByText(selectIdType, idType);
		idNumber.sendKeys(idNum);
		idIssueCountry.sendKeys(idIssCountry);
		idIssueCountry.sendKeys(Keys.ARROW_DOWN);
		idIssueCountry.sendKeys(Keys.ENTER);

		/*if(isElementDisplayed(selectExpirationYear,2)) {
			selectDdlByText(selectExpirationYear, expYear);
			selectDdlByText(selectExpirationMonth, expMon);
			selectDdlByText(selectExpirationDate, expDate);
		}*/
			if(isElementDisplayed(idIssueState,2)) {
				idIssueState.sendKeys(idstate);
				idIssueState.sendKeys(Keys.ARROW_DOWN);
				idIssueState.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
			}

			if(isElementDisplayed(selectId2Type,2)) {
				selectDdlByText(selectId2Type, id2type);Thread.sleep(1000);
				id2Number.sendKeys(id2number);                                                                 Thread.sleep(2000);

			}
	}

	public void additionalInfoexistforDE()throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", fundssource);

		if(isElementDisplayed(fundssource,2)) {
			selectDdlByText(fundssource, "Loan");Thread.sleep(2000);
		}
		if(isElementDisplayed(transactionpurpose,2)) {
			selectDdlByText(transactionpurpose, "Gift");Thread.sleep(2000);
		}
	}

	public void additionalInformationforexistinghigh(String senderoccupation, String thirdparttype)throws InterruptedException{
		/*((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(1000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);*/

		if(isElementDisplayed(senderoccupationn,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", senderoccupationn);
                 selectDdlByText(senderoccupationn, senderoccupation);Thread.sleep(2000);

		}

		if(isElementDisplayed(thirdpartynone,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", thirdpartynone);
			thirdpartynone.click();

		}
		/*if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("fdgfgfgfdg");
		}*/

	}
	public void additionalInformationfolowamontsusa(String bcountry, String citizencountry, String sourcefunds, String purposeoftransaction)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);
}

	public void receiverinfoforexistingIT()throws InterruptedException{
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);

		receiverFirstName.sendKeys("dffsdf");Thread.sleep(2000);
		receiverLastName.sendKeys("gdfgg");
Thread.sleep(3000);
	}

	public void additionalInfoexistingItaly()throws InterruptedException{
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", fundssource);


		selectDdlByText(fundssource, "Loan");Thread.sleep(1000);
		selectDdlByText(relationtoReceiver, "Family Member");Thread.sleep(1000);
		selectDdlByText(transactionpurpose, "Gift");
		Thread.sleep(3000);
	}

	public void additionalInfoexistingIT()throws InterruptedException{
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthcity);
		birthcity.clear();
		birthcity.sendKeys("Taranto");
		Thread.sleep(3000);
		birthcity.clear();
		birthcity.sendKeys("Taranto");
		Thread.sleep(2000);

		selectDdlByText(fundssource, "Loan");Thread.sleep(1000);
		selectDdlByText(relationtoReceiver, "Family Member");Thread.sleep(1000);
		selectDdlByText(transactionpurpose, "Gift");
		Thread.sleep(3000);
	}

	public void additionalInformationfolowamontsUK(String bcountry, String occuptn, String source, String relation, String purposeoftransaction)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(1000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);
		//birthcity.sendKeys(bcity);
		Thread.sleep(2000);
		//countrycitizen.sendKeys(citizencountry);
		//Thread.sleep(5000);
		//countrycitizen.sendKeys(Keys.ARROW_DOWN);
		//countrycitizen.sendKeys(Keys.ENTER);Thread.sleep(2000);

		//countrycitizen.sendKeys(citizencountry);
		Thread.sleep(5000);
		//countrycitizen.sendKeys(Keys.ARROW_DOWN);
		//countrycitizen.sendKeys(Keys.ENTER);Thread.sleep(2000);
		selectDdlByText(senderoccupationn, occuptn);Thread.sleep(1000);
		selectDdlByText(fundssource, source);Thread.sleep(1000);
		selectDdlByText(relationtoReceiver, relation);Thread.sleep(1000);
		selectDdlByText(transactionpurpose, purposeoftransaction);Thread.sleep(2000);
	}



	public void additionalInformationfolowamontsItaly(String gender, String occuption, String birtcountry,String birthcityy, String nationality, String citizencontry, String fundssourcee, String relatnship, String purposetransa)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sengender);
		//birthCountry.clear();
		selectDdlByText(sengender, gender);Thread.sleep(1000);
		selectDdlByText(senderoccupationn, occuption);Thread.sleep(1000);
		birthCountry.sendKeys(birtcountry);
		Thread.sleep(1000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);
		birthcity.sendKeys(birthcityy);
		Thread.sleep(1000);
		birthcity.sendKeys(Keys.ARROW_DOWN);
		birthcity.sendKeys(Keys.ENTER);Thread.sleep(2000);
		sennationality.sendKeys(nationality);
		Thread.sleep(1000);
		sennationality.sendKeys(Keys.ARROW_DOWN);
		sennationality.sendKeys(Keys.ENTER);Thread.sleep(2000);
		countrycitizen.sendKeys(citizencontry);
		Thread.sleep(5000);
		countrycitizen.sendKeys(Keys.ARROW_DOWN);
		countrycitizen.sendKeys(Keys.ENTER);Thread.sleep(2000);
		selectDdlByText(fundssource, fundssourcee);Thread.sleep(1000);
		selectDdlByText(relationtoReceiver, relatnship);Thread.sleep(1000);
		selectDdlByText(transactionpurpose, purposetransa);Thread.sleep(2000);
	}
	public void additionalInformationfolowamontsIT(String bcountry, String bcity, String citizencountry, String source, String relation, String purposeoftransaction)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(1000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		//birthcity.sendKeys(bcity);
		//Thread.sleep(2000);

		countrycitizen.sendKeys(citizencountry);
		Thread.sleep(5000);
		countrycitizen.sendKeys(Keys.ARROW_DOWN);
		countrycitizen.sendKeys(Keys.ENTER);Thread.sleep(2000);

		selectDdlByText(fundssource, source);Thread.sleep(1000);
		selectDdlByText(relationtoReceiver, relation);Thread.sleep(1000);
		selectDdlByText(transactionpurpose, purposeoftransaction);Thread.sleep(2000);
	}

	public void additionalInformationfolowamontsRO(String bcountry, String citizencountry, String occupatn, String purposeoftransaction, String permaAddress)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		countrycitizen.sendKeys(citizencountry);
		Thread.sleep(2000);
		countrycitizen.sendKeys(Keys.ARROW_DOWN);
		countrycitizen.sendKeys(Keys.ENTER);Thread.sleep(1000);

		permaaddress.sendKeys(permaAddress);
		Thread.sleep(1000);
		permaaddress.sendKeys(Keys.ARROW_DOWN);
		permaaddress.sendKeys(Keys.ENTER);Thread.sleep(1000);

		selectDdlByText(senderoccupationn, occupatn);Thread.sleep(1000);
		selectDdlByText(transactionpurpose, purposeoftransaction);Thread.sleep(2000);
	}

	public void additionalInformationfolowamontsfrance(String bcountry, String citizencountry, String sourcefunds, String purposeoftransaction)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);
		selectDdlByText(fundssource, sourcefunds);Thread.sleep(2000);
		selectDdlByText(transactionpurpose, purposeoftransaction);Thread.sleep(2000);
	}

	public void additionalInformationfolowamontsDE(String bcountry, String citizencountry, String sourcefunds, String purposeoftransaction)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		countrycitizen.sendKeys(citizencountry);
		Thread.sleep(2000);
		countrycitizen.sendKeys(Keys.ARROW_DOWN);
		countrycitizen.sendKeys(Keys.ENTER);Thread.sleep(2000);
		selectDdlByText(fundssource, sourcefunds);Thread.sleep(2000);
		selectDdlByText(transactionpurpose, purposeoftransaction);Thread.sleep(2000);
	}

	public void additionalInformationfolowamontsADInd(String bcountry, String purposeofTransfer)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		selectDdlByText(purposeoffunds, purposeofTransfer);Thread.sleep(2000);


	}

	public void additionalInformationfolowamonts(String bcountry)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

	}

	public void additionalInformation_homeDELlow(String bcountry)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);
		if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("The Alamo—San Antonio, Texas");
		}
	}
	public void additionalInformation_homeDEL(String bcountry, String senderoccupation, String thirdparttype)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		if(isElementDisplayed(senderoccupationn,2)) {
			selectDdlByText(senderoccupationn, senderoccupation);
			Thread.sleep(2000);
		}
		if(isElementDisplayed(thirdpartynone,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", thirdpartynone);

			//selectDdlByText(thirdparty, thirdparttype);
			//Thread.sleep(2000);
			thirdpartynone.click();
		}
		if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("The Alamo—San Antonio, Texas");
		}
	}


	public void additionalInformationnewhigh(String bcountry, String senderoccupation, String thirdparttype)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		//birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		if(senderoccupationn.isDisplayed()) {
			selectDdlByText(senderoccupationn, senderoccupation);Thread.sleep(2000);

		}

		if(thirdpartynone.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", thirdpartynone);

			thirdpartynone.click();
		}
		/*if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("fdgfgfgfdg");
		}*/

	}
	
	public void additionalInformationlow(String bcountry, String senderoccupation, String thirdparttype)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		birthCountry.clear();
		birthCountry.sendKeys(bcountry);
		Thread.sleep(2000);
		birthCountry.sendKeys(Keys.ARROW_DOWN);
		birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		/*if(senderoccupationn.isDisplayed()) {
			selectDdlByText(senderoccupationn, senderoccupation);Thread.sleep(2000);

		}*/

		/*if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("fdgfgfgfdg");
		}*/

	}

	public void additionalInformation(String bcountry, String senderoccupation, String thirdparttype)throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", birthCountry);
		birthCountry.clear();
		birthCountry.sendKeys(bcountry);
			Thread.sleep(2000);
			birthCountry.sendKeys(Keys.ARROW_DOWN);
			birthCountry.sendKeys(Keys.ENTER);Thread.sleep(2000);

		/*if(senderoccupationn.isDisplayed()) {
			selectDdlByText(senderoccupationn, senderoccupation);Thread.sleep(2000);

		}*/
		if(thirdpartynone.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", thirdpartynone);

            thirdpartynone.click();
			//selectDdlByText(thirdparty, thirdparttype);Thread.sleep(2000);
		}
		/*if(isElementDisplayed(direction1,2)) {
			direction1.sendKeys("fdgfgfgfdg");
		}*/

	}


	public void validatebankenrouteNumber(String bankroutenumm) throws InterruptedException {
		WebElement bankroutenum = driver.findElement(By.xpath("//input[@id='accountNumber']"));
		WebElement searchbank = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
		WebElement selectedvalue = driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-valid']"));
		bankroutenum.clear();
		bankroutenum.sendKeys(bankroutenumm);
		searchbank.click();
		Thread.sleep(3000);

	}

	public void EnterbankdetailsInd(String address, String primcountrycode, String phonenum, String accountnumb, String ifsccode) throws InterruptedException {
		if(isElementDisplayed(senderAddressField1,2)) {
			senderAddressField1.sendKeys(address);
			Thread.sleep(1000);
			senderAddressField1.sendKeys(Keys.ARROW_DOWN);
			senderAddressField1.sendKeys(Keys.ENTER);
		}
		if(isElementDisplayed(primaryCountryCode2,2)) {
			primaryCountryCode2.sendKeys(primcountrycode);Thread.sleep(2000);
			primaryCountryCode2.sendKeys(Keys.ARROW_DOWN);
			primaryCountryCode2.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//actions.build().perform();
		}

		if(isElementDisplayed(senderPrimaryPhoneNumber1,2)) {
			senderPrimaryPhoneNumber1.sendKeys(phonenum);Thread.sleep(3000);
		}

		if(isElementDisplayed(ifscinput,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ifscinput);
			//birthCountry.clear();

			ifscinput.sendKeys(ifsccode);Thread.sleep(3000);
			WebElement searchbank = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
			searchbank.click();
		}

		if(isElementDisplayed(accountnum,2)) {
			accountnum.sendKeys(accountnumb);Thread.sleep(3000);
		}

		if(isElementDisplayed(reenteraccountnum,2)) {
			reenteraccountnum.sendKeys(accountnumb);Thread.sleep(3000);
		}

	}


	public void EnterbankdetailsforBangladesh(String primcountrycode, String phonenum, String accountnumb, String bankroutenumber) throws InterruptedException {

		if(isElementDisplayed(primaryCountryCode2,2)) {
			primaryCountryCode2.sendKeys(primcountrycode);Thread.sleep(2000);
			primaryCountryCode2.sendKeys(Keys.ARROW_DOWN);
			primaryCountryCode2.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//actions.build().perform();
		}

		if(isElementDisplayed(senderPrimaryPhoneNumber1,2)) {
			senderPrimaryPhoneNumber1.sendKeys(phonenum);Thread.sleep(3000);
		}

		WebElement selectbank=driver.findElement(By.xpath("//select[@class='form-control ng-valid ng-touched ng-dirty']"));

		WebElement selectdistrict=driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-valid'"));

		selectDdlByText(selectbank, "AL-ARAFAH ISLAMI BANK LTD.");
		selectDdlByText(selectdistrict, "CHITTAGONG");

		/*Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value= '075261724';", bankroutenum);
		Thread.sleep(2000);
		//bankroutenum.sendKeys(bankroutenumber);Thread.sleep(1000);
		if(searchbank.isEnabled()){
			searchbank.click();
			Thread.sleep(3000);

		}
		else{
			bankroutenum.click();
			bankroutenum.clear();
			bankroutenum.sendKeys("075261724");
		}*/

		if(isElementDisplayed(accountnum,2)) {
			accountnum.sendKeys(accountnumb);Thread.sleep(3000);
		}
	}


public void Enterbankdetails(String address, String primcountrycode, String phonenum, String accountnumb) throws InterruptedException {
	if(isElementDisplayed(senderAddressField1,2)) {
					senderAddressField1.sendKeys(address);
		Thread.sleep(1000);
		senderAddressField1.sendKeys(Keys.ARROW_DOWN);
		senderAddressField1.sendKeys(Keys.ENTER);
	}
	if(isElementDisplayed(primaryCountryCode2,2)) {
		primaryCountryCode2.sendKeys(primcountrycode);Thread.sleep(2000);
		primaryCountryCode2.sendKeys(Keys.ARROW_DOWN);
		primaryCountryCode2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//actions.build().perform();
	}

	if(isElementDisplayed(senderPrimaryPhoneNumber1,2)) {
		senderPrimaryPhoneNumber1.sendKeys(phonenum);Thread.sleep(3000);
	}

	if(isElementDisplayed(accountnum,2)) {
		accountnum.sendKeys(accountnumb);Thread.sleep(3000);
	}



}

	public void receiverInformationforAD(String fName, String lName,String state) throws InterruptedException {

		Assert.assertTrue(isElementDisplayed(receiverFirstName, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);
		receiverFirstName.sendKeys(fName);
		Thread.sleep(3000);
		Assert.assertTrue(isElementDisplayed(receiverLastName, 3));
		receiverLastName.sendKeys(lName);
		Thread.sleep(3000);

	}
	public void submitTransaction() throws InterruptedException {

		submitBtn.click();
		Thread.sleep(5000);


	}

	public void receiverInformationforexistingHigh(String fName, String lName,String state) throws InterruptedException {

		//Assert.assertTrue(isElementDisplayed(receiverFirstName, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);
		receiverFirstName.sendKeys(fName);
		Thread.sleep(3000);
		Assert.assertTrue(isElementDisplayed(receiverLastName, 3));
		receiverLastName.sendKeys(lName);
		Thread.sleep(3000);
		submitBtn.click();
		Thread.sleep(5000);

		if(idIssueState.isEnabled()){
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", idIssueState);
Thread.sleep(2000);
			idIssueState.sendKeys(state);Thread.sleep(1000);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		submitBtn.click();
		Thread.sleep(5000);}
	}

	public void receiverInformation_HOmeDel(String fName, String lName,String state) throws InterruptedException {
		Thread.sleep(3000);
		//Assert.assertTrue(isElementDisplayed(receiverFirstName, timeToWait));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);
		receiverFirstName.sendKeys(fName);
		Thread.sleep(3000);
		Assert.assertTrue(isElementDisplayed(receiverLastName, 3));
		receiverLastName.sendKeys(lName);Thread.sleep(3000);
		receivercity.sendKeys("Texas");Thread.sleep(1000);

		receiverphone.sendKeys("9849374635");Thread.sleep(1000);
		Thread.sleep(5000);
		submitBtn.click();
		Thread.sleep(4000);

		if(isElementDisplayed(countrycodeAdtnldetails,2)) {
			countrycodeAdtnldetails.sendKeys("USA");Thread.sleep(2000);
			countrycodeAdtnldetails.sendKeys(Keys.ARROW_DOWN);
			countrycodeAdtnldetails.sendKeys(Keys.ENTER);
		}

		submitBtn.click();
		Thread.sleep(4000);


		/*Assert.assertTrue(isElementDisplayed(idIssueState, 3));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", idIssueState);
		String issuestate = idIssueState.getText();
		boolean stateselected = issuestate.isEmpty();
		if(stateselected){
			idIssueState.sendKeys(state);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

		}*/

		//submitBtn.click();
	}

	public void captureplusnumberr () throws InterruptedException {
		Thread.sleep(4000);
		//backbutton.click();Thread.sleep(4000);


		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", plusnumgeneratedd);
		//String plusnum =plusnumgeneratedd.getText();
		String[] plusnum =plusnumgeneratedd.getText().split(":");
        String plusnummm =plusnum[1];
		plusnummber =plusnummm.trim();
		System.out.println(plusnummber);

		//submitBtn.click();Thread.sleep(4000);


	}

	public void captureplusnumber () throws InterruptedException {
		backbutton.click();Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", plusnumgenerated);
          String plusnum =plusnumgenerated.getText();
		plusnummber =plusnum;
		System.out.println(plusnummber);

		submitBtn.click();Thread.sleep(4000);


	}

	public void receiverInformationefee(String fName, String lName,String state) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);

		if(!fName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			receiverFirstName.sendKeys(fName);
			Thread.sleep(3000);
		}

		else{
			recfirstname = getRandomString(5).toLowerCase();
			receiverFirstName.sendKeys(recfirstname);
			Thread.sleep(2000);
		}

		if(!lName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			receiverLastName.sendKeys(lName);
			Thread.sleep(7000);
		}

		else{
			reclastname = getRandomString(5).toLowerCase();
			receiverLastName.sendKeys(reclastname);
			Thread.sleep(7000);
		}

		submitBtn.click(); Thread.sleep(6000);

		/*((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", idIssueState);

			idIssueState.sendKeys(state);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

		submitBtn.click();Thread.sleep(5000);*/
	}

 	public void receiverInformation(String fName, String lName,String state) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);

		if(!fName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			receiverFirstName.sendKeys(fName);
			Thread.sleep(3000);
		}

		else{
			recfirstname = getRandomString(5).toLowerCase();
			receiverFirstName.sendKeys(recfirstname);
			Thread.sleep(2000);
		}

		if(!lName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			receiverLastName.sendKeys(lName);
			Thread.sleep(7000);
		}

		else{
			reclastname = getRandomString(5).toLowerCase();
			receiverLastName.sendKeys(reclastname);
			Thread.sleep(7000);
		}

		/*if(isElementDisplayed(thirdpartynone,2)) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", thirdpartynone);
			thirdpartynone.click();
			//selectDdlByText(thirdparty, thirdparttype);Thread.sleep(2000);

		}*/

		submitBtn.click(); Thread.sleep(5000);

		if(isElementDisplayed(issueCity,2)) {
			issueCity.sendKeys("dsfsdgd");
			Thread.sleep(3000);
		}

		if(isElementDisplayed(issueAuthorityy,2)) {
			selectDdlByText(issueAuthorityy, "Embassy");
			Thread.sleep(1000);
		}

		if(isElementDisplayed(selectissueyear,2)) {
			selectissueyear.sendKeys("2020");
			selectissuemonth.sendKeys("12");
			selectissuedate.sendKeys("12");

		}

		/*	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", idIssueState);

			idIssueState.sendKeys(state);
			idIssueState.sendKeys(Keys.ARROW_DOWN);
			idIssueState.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

		}*/

		submitBtn.click(); Thread.sleep(5000);

		/*if(isElementDisplayed(fraudalertOK,2)) {

			fraudalertOK.click();


		}*/

		}

	public void ItalyIDissueDetails(String idcity, String issueAuthoriti, String issueyear, String issuemonth, String issueday) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);
		issueCity.sendKeys(idcity);

		selectDdlByText(issueAuthorityy, issueAuthoriti);
		selectissueyear.sendKeys(issueyear);
		selectissuemonth.sendKeys(issuemonth);
		selectissuedate.sendKeys(issueday);

		//input[@id='sender_PersonalId1_Issue_City']
		//select[@id='sender_PersonalId1_Issue_Authority']
		//input[@id='STRKEY_ISSUE_DATE_year']
		//input[@id='STRKEY_ISSUE_DATE_month']
		//input[@id='STRKEY_ISSUE_DATE_day']
		//submitBtn.click(); Thread.sleep(5000);
	}
	public void receiverInformationlow(String fName, String lName,String state) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", receiverFirstName);

		if(!fName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			receiverFirstName.sendKeys(fName);
			Thread.sleep(3000);
		}

		else{
			recfirstname = getRandomString(5).toLowerCase();
			receiverFirstName.sendKeys(recfirstname);
			Thread.sleep(2000);
		}

		if(!lName.equalsIgnoreCase("NA")){
			//senderFirstName.clear();
			receiverLastName.sendKeys(lName);
			Thread.sleep(7000);
		}

		else{
			reclastname = getRandomString(5).toLowerCase();
			receiverLastName.sendKeys(reclastname);
			Thread.sleep(7000);
		}
		submitBtn.click(); Thread.sleep(5000);
	}

	public void validationsforloyaltyIT(HashMap <String, String> teller, String Cus) throws InterruptedException {
		captureplusnumberr();
		Thread.sleep(5000);
		sendMoneyBtn.click();

		Assert.assertTrue(isElementDisplayed(referenceNumber, 4));
		HashMap <String, String> finalPage = new HashMap<>();
		String Referencenumber=referenceNumber.getText();

		finalPage.put("Referencenumber", Referencenumber);
		//finished.click();



	}

	public void validationsforloyalty(HashMap <String, String> teller, String Cus) throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//button[@id='yes']"));

		if(isElementDisplayed(ele,2)) {
			ele.click();

		}
		captureplusnumberr();
		Thread.sleep(5000);
		sendMoneyBtn.click();

		Assert.assertTrue(isElementDisplayed(referenceNumber, 4));
		HashMap <String, String> finalPage = new HashMap<>();
		String Referencenumber=referenceNumber.getText();

		finalPage.put("Referencenumber", Referencenumber);
		finished.click();



	}

	public void validationswithoutfraudalert(HashMap <String, String> teller, String Cus) throws InterruptedException {
		Thread.sleep(5000);
		sendMoneyBtn.click();

		Assert.assertTrue(isElementDisplayed(referenceNumber, 4));
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
		//finished.click();



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

		}*/
WebElement ele = driver.findElement(By.xpath("//button[@id='yes']"));

		if(isElementDisplayed(ele,2)) {
			ele.click();

		}
		Thread.sleep(5000);
		sendMoneyBtn.click();

		Assert.assertTrue(isElementDisplayed(referenceNumber, 4));
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
		//finished.click();



	}



	public void getScreenShotFromPage() throws Exception {
		getScreenShot();
	}


}