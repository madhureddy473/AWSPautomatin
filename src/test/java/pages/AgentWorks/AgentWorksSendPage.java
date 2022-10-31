package pages.AgentWorks;

import static org.testng.Assert.assertEquals;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import test.java.pages.BasePage.Page;

public class AgentWorksSendPage extends Page{

	//OBJECTS

	//*************************** Customer Search *******************************

	public WebElement getManualSearch() {	return manualSearch;	}

	@FindBy(xpath = "//*[@id='manualSearch']")
	WebElement manualSearch;

	@FindBy(xpath="//div[@id='ActionBarMainNextNewCustomer']")
	WebElement newCustomer;

	@FindBy(xpath="(//div[contains(text(), ' Name and Phone ')])")
	WebElement nameAndPhoneTab;

	@FindBy(id="consumer_LastName")
	WebElement consumerLastNameField;

	@FindBy(id="consumer_PrimaryPhone")
	WebElement consumerPhoneField;

	@FindBy(xpath="(//span[contains(text(), 'Search')])[1]")
	WebElement searchBtn;

	@FindBy(id="mgiRewardsNumber")
	WebElement plusRewardsNumber;

	@FindBy(xpath = "//span[contains(text(), 'Payment Due to MoneyGram')]/ancestor::div[3]/div[2]/div")
	WebElement amountDueToMoneyGram;

	public WebElement getAmountDueToMoneyGram() {	return amountDueToMoneyGram; 	}

	//***************************** Sender Profile Page ****************************

	@FindBy(xpath = "//strong[text()='Name:']")
	WebElement senderProfileName;

	@FindBy(xpath = "//strong[text()='Name:']/ancestor::div[1]/div")
	WebElement senderProfileNameText;

	@FindBy(xpath = "//strong[text()='Address:']")
	WebElement senderProfileAddress;

	@FindBy(xpath = "//strong[text()='Address:']/ancestor::div[1]/div[1]")
	WebElement senderProfileAddressText;

	@FindBy(xpath = "//strong[text()=' Contact Information: ']")
	WebElement senderProfileContactInformation;

	@FindBy(xpath = "//span[contains(text(), 'Email')]")
	WebElement senderProfileEmail;

	@FindBy(xpath = "//span[contains(text(), 'Phone number')]")
	WebElement senderProfilePhoneNumber;

	@FindBy(xpath = "//span[contains(text(), 'Phone number')]/ancestor::div[2]/div[2]/span[1]")
	WebElement senderProfilePhoneNumberText;

	@FindBy(xpath = "//div[contains(text(), 'Receive Transaction Status')]")
	WebElement senderProfileReceiverTransactionStatus;

	@FindBy(xpath = "//div[contains(text(), 'Receive Transaction Status')]/ancestor::div[1]/div[2]")
	WebElement senderProfileReceiverTransactionStatusText;

	@FindBy(xpath = "//div[contains(text(), 'Receive Offers')]")
	WebElement senderProfileReceiveOffers;

	@FindBy(xpath = "//div[contains(text(), 'Receive Offers')]/ancestor::div[1]/div[2]")
	WebElement senderProfileReceiveOffersText;

	@FindBy(xpath = "//strong[text()='Other:']")
	WebElement senderProfileOther;

	@FindBy(xpath = "//div[text()=' Date of Birth: ']")
	WebElement senderProfileDob;

	@FindBy(xpath = "//div[contains(text(), 'Date of Birth')]/ancestor::div[1]/div[2]")
	WebElement senderProfileDobText;

	@FindBy(xpath = "//*[@class='editOther float-right']")
	WebElement othersEditButton;

	@FindBy(xpath = "//span[text()=' Date of birth ']/ancestor::div[1]/div/div[1]/select")
	WebElement othersDateOfBirthYearField;

	String othersDateOfBirthYearFieldXpath = "//span[text()=' Date of birth ']/ancestor::div[1]/div/div[1]/select";

	String othersBirthCountryFieldXpath = "//*[@id='sender_Birth_Country']/input";

	String othersBirthCityFieldXpath = "//*[@id='sender_Birth_City']";



	//***************************** Destination and Amount ***********************
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement sendMoneyField; 
	
	@FindBy(xpath="//app-typeahead[@id='STRKEY_DEST_COUNTRY']/input[@type='text']")
	WebElement destCountryField;

	String destinationCountryXpath = "//*[@id='STRKEY_DEST_COUNTRY']/ngb-typeahead-window/button/ngb-highlight/span[contains(text(), '%s')]";
	
	@FindBy(xpath="//app-typeahead[@id='destination_Country_SubdivisionCode']/input[@type='text']")
	WebElement state;

	@FindBy(xpath = "//*[@id='STRKEY_PROMO_CODE'][1]")
	WebElement promoCode;

	@FindBy(xpath = "//*[@id='STRKEY_FEE_TYPE_2']/following-sibling::div")
	WebElement receiveAmountField;

	public WebElement getNextBtn() {
		Assert.assertTrue(isElementDisplayed(nextBtn, timeToWait));
		return nextBtn;
	}

	@FindBy(xpath="//button[@type='button']/span[contains(text(),'Next')]")
	WebElement nextBtn;

	public WebElement getIncludingFee() {
		return includingFee;
	}

	@FindBy(xpath = "//div[contains(text(), 'Send amount including fee')]")
	WebElement includingFee;


    //******************************  Service Options ********************************


	@FindBy(xpath = "//strong[contains(text(), 'Service Options')]")
	WebElement serviceOptionsHeader;

	@FindBy(xpath = "//div[contains(text(), 'The maximum receive amount for this delivery option is')]")
	WebElement maximumAmountMessage;


	//************************************** Receiver Info *******************************

	@FindBy(xpath = "//strong[text()= ' Receiver information ']")
	WebElement receiverInformationHeader;

	@FindBy(xpath = "//strong[contains(text(), 'Previous Recipients')]")
	WebElement receiverPreviousRecipient;

	@FindBy(xpath="(//span[contains(text(), ' New receiver ')])[1]")
	WebElement newRecvrBtn;

	@FindBy(id="receiver_FirstName")
	WebElement receiverFirstName;

	@FindBy(id="receiver_LastName")
	WebElement receiverLastName;

	@FindBy(id="receiver_City")
	WebElement receiverCity;

	@FindBy(id="receiver_PrimaryPhone")
	WebElement receiverPhone;

	@FindBy(id="direction1")
	WebElement directionField;

	@FindBy(xpath="(//app-typeahead[@id='Primary Phone Country Code']/input[@type='text'])[1]")
	WebElement countryCode;

	//*************************************** Sender Info ***********************************

	@FindBy(id="sender_FirstName")
	WebElement senderFirstName;

	@FindBy(id="sender_LastName")
	WebElement senderLastName;

	@FindBy(xpath="//app-typeahead[@id='sender_Country']/input[@type='text']")
	WebElement senderCountryField;

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

	@FindBy(xpath = "//span[contains(text(), 'Birth City')]/ancestor::div[1]/input")
	WebElement birthCityField;

	@FindBy(xpath="//div[10]/div/app-field/section/div/div/app-dropdown-field/div/select")
	WebElement occupation;

	@FindBy(xpath = "//strong[contains(text(), 'Collect Funds')]")
	WebElement collectFundsHeader;


	//**************************************** Identification ***************************************


	@FindBy(id="sender_PersonalId1_Type")
	WebElement idTypeField;

	@FindBy(id="sender_PersonalId1_Number")
	WebElement idNumberField;

	@FindBy(xpath="//app-typeahead[@id='sender_PersonalId1_Issue_Country']/input")
	WebElement idIssueCountryField;

	@FindBy(xpath="//app-typeahead[@id='sender_PersonalId1_Issue_Country_SubdivisionCode']/input")
	WebElement idIssueStateField;

	@FindBy(id="sender_PersonalId1_Issue_City")
	WebElement idIssueCity;

	@FindBy(id="sender_PersonalId1_Issue_Authority")
	WebElement idIssueAuthority;

	@FindBy(id="sender_PersonalId2_Type")
	WebElement secondaryIdType;

	@FindBy(id="sender_PersonalId2_Number")
	WebElement secondaryIdNumber;

	@FindBy(xpath = "//*[@id='sender_PersonalId1_VerificationStr']")
	WebElement idOneTextField;

	@FindBy(xpath = "//*[@id='sender_PersonalId2_VerificationStr' or @id='sender_PersonalId2_Number']")
	WebElement idTwoTextFiled;

	@FindBy(id="sender_PersonalId1_Choice")
	WebElement idChoiceField;

	@FindBy(xpath = "//*[@id='sender_PersonalId2_Type' or @id='sender_PersonalId2_Choice']")
	WebElement idSecChoiceField;

	@FindBy(xpath = "//label[@class='mg-text-color-red text-bold']/span[contains(text(), 'ID Choice')]")
	WebElement idChoiceErrorMessage;

	String idChoiceDropDown = "//*[@id='sender_PersonalId1_Choice']/option[contains(text(), '%s')]";

	String idChoiceTwoDropDown = "//*[@id='sender_PersonalId2_Choice' or @id='sender_PersonalId2_Type']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]")
	WebElement expirationYear;

	String expirationYearNumber = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[1]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]")
	WebElement expirationMonth;

	String expirationMonthNumber = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[2]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]")
	WebElement expirationDate;

	String expirationDateNumber = "//span[contains(text(), 'Expiration')]/ancestor::div[1]/div[1]/div[3]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Issue Date')]/ancestor::div[1]/div[1]/div[1]")
	WebElement issueYear;

	String issueYearXpath = "//span[contains(text(), 'Issue Date')]/ancestor::div[1]/div[1]/div[1]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Issue Date')]/ancestor::div[1]/div[1]/div[2]")
	WebElement issueMonth;

	String issueMonthXpath = "//span[contains(text(), 'Issue Date')]/ancestor::div[1]/div[1]/div[2]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Issue Date')]/ancestor::div[1]/div[1]/div[3]")
	WebElement issueDate;

	String issueDateXpath = "//span[contains(text(), 'Issue Date')]/ancestor::div[1]/div[1]/div[3]/select/option[contains(text(), '%s')]";

	@FindBy(xpath = "//strong[contains(text(), ' Identification - Primary Photo ID ')]")
	WebElement senderIdentification;

	@FindBy(xpath = "//span[contains(text(), 'Expiration')]")
	WebElement expirationText;


	//************************************ Additional Info **************************************

	@FindBy(xpath = "//strong[contains(text(), 'Additional data collection')]")
	WebElement additionalDataFieldHeader;

	@FindBy(xpath = "//*[@id='sourceOfFunds']")
	WebElement sourceOfFunds;

	String sourceOfFundsXpath = "//*[@id='sourceOfFunds']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='proofOfFunds']")
	WebElement proofOfFunds;

	String proofOfFundsXpath = "//*[@id='proofOfFunds']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='sender_Residence_Country']/input")
	WebElement permanentResidency;

	String permanentResidencyXpath = "//*[@id='sender_Residence_Country']/ngb-typeahead-window/button/ngb-highlight/span[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='relationshipToReceiver']")
	WebElement relationshipToReceiver;

	String relationshipToReceiverXpath = "//*[@id='relationshipToReceiver']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='send_PurposeOfTransaction']")
	WebElement purposeOfTransactionAdditionData;

	String purposeOfTransactionAdditionalDataXpath = "//*[@id='send_PurposeOfTransaction']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='sender_IntendedUseOfMGIServices']")
	WebElement useOfMGIServices;

	@FindBy(xpath = "//*[@id='sender_CitizenshipCountry']/input")
	WebElement citizenShipCountry;

	@FindBy(xpath = "//*[@id='sender_Nationality']/input")
	WebElement nationality;

	String useOfMGIServicesXpath = "//*[@id='sender_IntendedUseOfMGIServices']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//*[@id='sender_Gender']")
	WebElement additionalInformationGender;

	String genderXpath = "//*[@id='sender_Gender']/option[contains(text(), '%s')]";

	//*********************************** Third Party Information ********************************************

	@FindBy(xpath = "//strong[contains(text(), ' Third party information ')]")
	WebElement thirdPartyPageHeader;


	//*********************************** Account Number Information *****************************************

	@FindBy(xpath = "//*[@id='accountNumber']")
	WebElement accountNumberTextField;

	@FindBy(xpath = "//span[contains(text(), 'Account Information')]")
	WebElement accountInformationHeader;

	@FindBy(xpath = "//*[@id='accountNumberVerification']")
	WebElement accountNumberVerificationField;

	@FindBy(xpath = "//*[@id='bankIdentifier_WithLookup']")
	WebElement bankIFSCField;

	@FindBy(xpath = "//*[@id='bankIdentifier_WithLookup']/ancestor::div[6]/div[2]/button/span[contains(text(), 'Search')]")
	WebElement bankSearch;

	@FindBy(xpath = "//span[text()=' Bank ']/ancestor::div[1]/select")
	WebElement bankNameField;

	@FindBy(xpath = "//span[text()=' District ']/ancestor::div[1]/select")
	WebElement districtNameField;

	@FindBy(xpath = "//span[text()=' Branch ']/ancestor::div[1]/select")
	WebElement branchNameField;

	@FindBy(xpath = "//*[@id='sendPurposeOfTransactionPartnerField']")
	WebElement purposeOfTransaction;

	@FindBy(xpath = "//strong[contains(text(), 'Additional data collection')]")
	WebElement additionalDataCollection;

	//********************************** Proof of address ******************************

	@FindBy(xpath = "//span[contains(text(), 'Proof of Address')]")
	WebElement proofOfAddressTitle;

	@FindBy(xpath = "//span[contains(text(),'Document issue date')]/ancestor::div[1]/div/div[1]/select")
	WebElement proofOfAddressYear;

	@FindBy(xpath = "//span[contains(text(),'Document issue date')]/ancestor::div[1]/div/div[2]/select")
	WebElement proofOfAddressMonth;

	@FindBy(xpath = "//span[contains(text(),'Document issue date')]/ancestor::div[1]/div/div[3]/select")
	WebElement proofOfAddressDay;


	//***************************** Sender Contact Information *************************

	@FindBy(xpath="(//span[@class='checkmark'])[2]")
	WebElement plusProgramChkbox;

	@FindBy(id="sender_PrimaryPhone")
	WebElement primaryPhoneNumber;

	@FindBy(id="sender_Email")
	WebElement primaryEmail;

	@FindBy(id="sender_PreferredLanguage")
	WebElement preferredLanguage;

	@FindBy(id="yes")
	WebElement fraudAlertMsgYes;

	@FindBy(id="ok")
	WebElement finishedBtn;

	@FindBy(xpath="//strong[@id='STRKEY_REF_NUM']")
	WebElement referenceId;

	@FindBy(xpath="//div[@id='Receive Offers_radio']/ul/li[4]/label/span")
	WebElement receiveOffersRadioBtn;

	@FindBy(xpath="(//span[contains(text(), ' None ')])")
	WebElement noneRadioBtn;

	@FindBy(xpath="//span[contains(text(), ' Organization ')]")
	WebElement organizationRadioButton;

	@FindBy(xpath = "(//span[text()=' Address '])[1]")
	WebElement organizationAddressFieldHeader;

	@FindBy(xpath = "(//span[text()=' Address '])[1]/ancestor::div[1]/input")
	WebElement organizationAddressField;

	@FindBy(xpath = "//*[@id='thirdParty_Sender_Organization']")
	WebElement organizationName;

	@FindBy(xpath = "//*[@id='thirdParty_Sender_PersonalId2_Type']")
	WebElement organizationSenderPersonalId2;

	@FindBy(xpath = "//*[@id='thirdParty_Sender_PersonalId2_Number']")
	WebElement organizationSenderPersonalId2Text;

	@FindBy(xpath="//*[contains(text(),'Email')]")
	WebElement receiveOffersRadioBtnEmail;

	@FindBy(xpath = "(//span[contains(text(), ' Text & Email ')])[1]")
	WebElement textAndEmailRadioButton;

	@FindBy(xpath = "(//span[contains(text(), 'Tax')])[2]")
	WebElement collectFunds_TaxField;

	@FindBy(xpath = "(//span[contains(text(), 'Fees')])[2]")
	WebElement collectFunds_FeesField;

	@FindBy(xpath = "//span[contains(text(), 'Other taxes')]")
	WebElement collectFunds_OtherTaxes;

	@FindBy(xpath = "//span[contains(text(), 'Other fees')]")
	WebElement collectFunds_OtherFees;

	public WebElement getSendMoneyBtn() {	return sendMoneyBtn; }

	@FindBy(id="ok")
	WebElement sendMoneyBtn;

	String sendMoneyXpath = "//*[@id='ok']";

	@FindBy(xpath = "//h4[contains(text(), ' Please authenticate this transaction by touching the MoneyGram token ')]")
	WebElement mfaPopup;

	@FindBy(xpath = "//*[@id='txtOtp']")
	WebElement otpText;

	@FindBy(xpath = "//h4[contains(text(), ' MoneyGram token authentication failed. Contact MoneyGram for assistance. ')]")
	WebElement authenticationFailedText;

	@FindBy(xpath = "//span[contains(text(), 'System error (AC Error 434)')]")
	WebElement invalidToken;


	//************************************ Scan Receipts and Image  **************************


	@FindBy(xpath= "//button[contains(text(), 'Scan Receipts')]")
	WebElement scanReceipts;

	String scanReceiptsXpath = "//button[contains(text(), 'Scan Receipts')]";

	@FindBy(xpath = "//*[@id='image-scan']")
	WebElement imageScan;

	@FindBy(xpath = "//*[@id='action-bar-finish-scan-receipt']/button")
	WebElement upload;

	@FindBy(xpath = "//strong[text()=' Success ']")
	WebElement success;

	@FindBy(xpath = "//*[@id='btnMessageModalSubmit']")
	WebElement finishScanButton;

	@FindBy(xpath = "//button[contains(text(), 'Scan Front')]")
	WebElement idOneScanFront;

	@FindBy(xpath = "//button[contains(text(), 'Scan Back')]")
	WebElement idOneScanBack;

	//*********************************** Unused objects ****************************

	@FindBy(xpath="//div[@id='ActionBarMainNextSenderContactInfo']/button")
	WebElement nextBtnn; 
	
	@FindBy(xpath="//card-footer[contains(text(),'Select')]")
	WebElement tenMinuteBtn;
	
	@FindBy(xpath="(//card-title[contains(text(),' 10 Minute Service ')])")
	WebElement tenMinuteBtn2;
	
	@FindBy(xpath="(//span[contains(text(),' USD ')])")
	WebElement tenMinuteBtn3;
	
	@FindBy(xpath="(//span[contains(text(),'USD')])[2]")
	WebElement tenMinuteBtn4;
	
	@FindBy(id="accountNumber")
	WebElement accountInfoField;
	
	@FindBy(id="accountNumberVerification")
	WebElement accountInfoVerifyField;
	
	@FindBy(xpath="(//input[@type='text'])[33]")
	WebElement idIssueCountryFieldF;
	
	@FindBy(xpath="(//input[@type='text'])[34]")
	WebElement idIssueStateFieldF;
	
	@FindBy(id="no")
	WebElement fraudAlertMsgNo;
	
	@FindBy(xpath="(//input[@role='combobox'])[5]")
	WebElement countryCode1;
	
	@FindBy(xpath="//div/div/div/div/ul/li[3]")
	WebElement homeDeliveryTab;
	
	@FindBy(xpath="//div[2]/app-delivery-option/app-card/div/div[2]/card-footer")
	WebElement selectHomeDeliveryUSD;
	
	@FindBy(xpath="(//card-footer[contains(text(), ' Select ')])[1]")
	WebElement exstngCustomer;
	
	@FindBy(xpath="(//span[contains(text(),' Tony TestU ')])")
	WebElement exstngCustomerSendToForeign;
	
	@FindBy(xpath="(//span[contains(text(),' Tony TestU ')])")
	WebElement exstngCusTestU;
	
	@FindBy(xpath="(//span[contains(text(),' Tony Senda ')])")
	WebElement exstngCusTestSenda;
	
	@FindBy(xpath="(//card-title[contains(text(),' JACKIE CHAN ')])")
	WebElement exstngRecipientForeign;
	
	@FindBy(xpath="(//card-title[contains(text(),' LARRY REIKO ')])")
	WebElement exstngRecipient;
	
	@FindBy(xpath="(//span[contains(text(),' 10 Minute Service ')])")
	WebElement tenMinuteSerciceExsCus;
	
	@FindBy(xpath="(//span[contains(text(),' Danny Pluso ')])")
	WebElement plusRewardsMember;
	
	@FindBy(xpath="(//span[contains(text(),' James Sendala ')])")
	WebElement plusRewardsMember2;
	
	@FindBy(xpath="(//card-title[contains(text(),' Bank Deposit - UnionPay Cards ')])")
	WebElement sendToBankCard;

	@FindBy(xpath = "//*[@class='nav nav-pills sdo']/li[contains(text(),'Account Deposit')]")
	WebElement accountDepositBtn;

	@FindBy(xpath = "//*[@class='row']/div/app-delivery-option/app-card/div/h5/card-title")
	WebElement deliveryType;
	
	@FindBy(xpath="//li[contains(text(),' Home Delivery ')]")
	WebElement homeDelBtn;
	
	@FindBy(xpath="//card-title[contains(text(),' Home Delivery USD ')]")
	WebElement homeDelCard;
	
	@FindBy(xpath="(//div[@class='wordwrap']/span[2])")
	WebElement moneygramPlusNum;

	String purposeOfTransactionXpath= "//*[@id='sendPurposeOfTransactionPartnerField']/option[contains(text(), '%s')]";

	@FindBy(xpath = "//span[contains(text(), 'Previous Credit')]")
	WebElement previousCredit;


	//*************************** End of objects **********************************************
	
	//CONSTRUCTOR
	public AgentWorksSendPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}
	
	//METHODS

	// ********************************* Search customer ****************************************


	/**
	 * Method to get the agent amount due to MoneyGram
	 * @return
	 * @throws InterruptedException
	 */
	public String paymentAmount() throws InterruptedException {
		String amount = null;
		Thread.sleep(5000);
			String amount1 = amountDueToMoneyGram.getText().replace(",", "");
			amount = amount1.substring(0, amount1.length()-3);
			amount = amount.replace(" ", "");
		return amount;
	}

	/**
	 * Method to enter plusNumber to search consumer
	 * @param plusNumber Data sheet plus number
	 * @param fullName Data sheet full name
	 */
	public void sendUsingPlusNumber(String plusNumber, String fullName) {
		Assert.assertTrue(isElementDisplayed(plusRewardsNumber, timeToWait));
		plusRewardsNumber.sendKeys(plusNumber);
		Assert.assertTrue(isElementDisplayed(searchBtn, timeToWait));
		searchBtn.click();
		findElementUsingText(fullName).click();
		Assert.assertTrue(isElementDisplayed(nextBtn, timeToWait));
		nextBtn.click();
	}

	/**
	 * Method to search customer based on name and phone number
	 * @param lastName excel last name
	 * @param phoneNumber excel phone Number
	 * @param fullName combination of first name and last name from excel
	 */
	public void searchUsingLastNameAndPhoneNumber(String lastName, String phoneNumber, String fullName){
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		searchBtn.click();
		findElementUsingText(fullName).click();
		nextBtn.click();
	}

	public void sendUsingUSExtCust(String lastName, String phoneNumber) throws InterruptedException { // need to update by adding feelookup call
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		searchBtn.click();
		Thread.sleep(2000);
		exstngCustomer.click();
		nextBtn.click();
	}

	/**
	 * Method to click on new customer
	 */
	public void newCustomer(){
		if (isElementDisplayed(newCustomer, 10)) {
			newCustomer.click();
		}
	}

	public void searchForExistingCustomerAndValidateDetails(String lastName, String phoneNumber, String fullName){

		searchForExisting(lastName, phoneNumber, fullName);
		Assert.assertTrue(isElementDisplayed(senderProfileName, timeToWait));
		Assert.assertFalse(senderProfileNameText.getText().isEmpty());
		Assert.assertTrue(isElementDisplayed(senderProfileAddress, 0));
		Assert.assertFalse(senderProfileAddressText.getText().isEmpty());
		Assert.assertTrue(isElementDisplayed(senderProfileContactInformation, 0));
		Assert.assertTrue(isElementDisplayed(senderProfileEmail, 0));
		Assert.assertTrue(isElementDisplayed(senderProfilePhoneNumber, 0));
		Assert.assertFalse(senderProfilePhoneNumberText.getText().isEmpty());
		Assert.assertTrue(isElementDisplayed(senderProfileReceiverTransactionStatus, 0));
		Assert.assertFalse(senderProfileReceiverTransactionStatusText.getText().isEmpty());
		Assert.assertTrue(isElementDisplayed(senderProfileReceiveOffers, 0));
		Assert.assertFalse(senderProfileReceiveOffersText.getText().isEmpty());
		Assert.assertTrue(isElementDisplayed(senderProfileOther,0));
		Assert.assertTrue(isElementDisplayed(senderProfileDob, 0));
		Assert.assertFalse(senderProfileDobText.getText().isEmpty());

	}

	public void searchForExisting(String lastName, String phoneNumber, String fullName){
		nameAndPhoneTab.click();
		consumerLastNameField.sendKeys(lastName);
		consumerPhoneField.sendKeys(phoneNumber);
		searchBtn.click();
		findElementUsingText(fullName).click();
	}

	public void validateAttributesAreDisabled() throws AWTException, InterruptedException {
		Assert.assertTrue(isElementDisplayed(senderProfileName, timeToWait));
		othersEditButton.click();
		Assert.assertTrue(isElementDisplayed(othersDateOfBirthYearField, timeToWait));
		Assert.assertFalse(driver.findElement(By.xpath(othersDateOfBirthYearFieldXpath)).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath(othersBirthCountryFieldXpath)).isEnabled());
	}



	//**************************************** Destination *****************************************

	/**
	 * Method to enter amount and destination country
	 * Note : country need to be in CAPS
	 * @param amount data sheet send amount
	 * @param destinationCountry receiver country from data sheet
	 * @param desState destination state from data sheet
	 */
	public void destinationAndAmount(String amount, String destinationCountry, String desState) throws InterruptedException {
		Assert.assertTrue(isElementDisplayed(sendMoneyField, timeToWait));
		sendMoneyField.sendKeys(amount);
		Assert.assertTrue(isElementDisplayed(destCountryField , timeToWait));
		destCountryField.clear();
		destCountryField.sendKeys(destinationCountry);
		Thread.sleep(1000);
		String destCountry = String.format(destinationCountryXpath, destinationCountry);
		driver.findElement(By.xpath(destCountry)).click();
		if(!desState.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(state , timeToWait));
			state.clear();
			textSuggestAndEnter(state, desState);
		}
		validateReceiveAmountField(destinationCountry);
		Assert.assertTrue(isElementDisplayed(nextBtn, timeToWait));
		nextBtn.click();
	}

	/** Duplicate method for above
	 * Method to enter amount, destination country and promo code
	 * @param amount
	 * @param destinationCountry
	 * @param desState
	 * @param promoCod
	 * @throws InterruptedException
	 */
	public void destinationCountryAndAmount(String amount, String destinationCountry, String desState, String promoCod) throws InterruptedException {
		sendMoneyField.sendKeys(amount);
		destCountryField.clear();
		destCountryField.sendKeys(destinationCountry);
		Thread.sleep(1000);
		String destCountry = String.format(destinationCountryXpath, destinationCountry);
		driver.findElement(By.xpath(destCountry)).click();
		if(!desState.equalsIgnoreCase("NA")){
			state.clear();
			textSuggestAndEnter(state, desState);
		}
		validateReceiveAmountField(destinationCountry);
		if(!promoCod.equalsIgnoreCase("NA")){
			promoCode.sendKeys(promoCod);
		}

		nextBtn.click();
	}

	/**
	 * Method to validate receive amount is disable or enabled based on the receiver country
	 * @param destinationCountry destination country
	 */
	public void validateReceiveAmountField(String destinationCountry){
		switch (destinationCountry.toUpperCase()){
			case "ETH":
			case "BRA":
			case "LBY":
			case "NAM":
			case "ZAF":
			case "VEN":
				Assert.assertTrue(receiveAmountField.getAttribute("class").contains("disabled"));
		}

	}

	//************************************** Receiver page *************************************

	/**
	 * Method to select existing receiver
	 * @param existingReceiver combination of receiver first and last name from excel
	 */
	public void selectExistingReceiver(String existingReceiver){
		findElementUsingText(existingReceiver).click();
	}

	/**
	 * Method to click on new receiver
	 */
	public void newReceiver(){
		if(isElementDisplayed(newRecvrBtn, 10)){
			newRecvrBtn.click();
		}
	}

	/**
	 *
	 * @param recFName
	 * @param recLName
	 * @param city
	 * @param phoneNumber
	 * @param direction
	 */
	public void fillNewReceiverInfo(String recFName, String recLName, String city, String phoneNumber, String direction) {
		Assert.assertTrue(isElementDisplayed(receiverFirstName , timeToWait));
		if(!recFName.equalsIgnoreCase("NA")){
			receiverFirstName.sendKeys(recFName);
		}
		else{
			receiverFirstName.sendKeys(getRandomString(5).toLowerCase());
		}
		Assert.assertTrue(isElementDisplayed(receiverLastName , timeToWait));
		if(!recLName.equalsIgnoreCase("NA")){
			receiverLastName.sendKeys(recLName);
		}
		else{
			receiverLastName.sendKeys(getRandomString(5).toLowerCase());
		}
		if(!city.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(receiverCity, timeToWait));
			receiverCity.sendKeys(city);
		}
		if(!phoneNumber.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(receiverPhone, timeToWait));
			receiverPhone.sendKeys(phoneNumber);
		}
		if(!direction.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(directionField, timeToWait));
			directionField.sendKeys(direction);
		}
		Assert.assertTrue(isElementDisplayed(nextBtn, timeToWait));
		nextBtn.click();
	}

	/**
	 * Method to fill receiver info for account deposit
	 * @param recFName
	 * @param recLName
	 * @param address
	 * @param phoneNumber
	 * @param countryCodes
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void fillReceiverInfoAccountDeposit(String recFName, String recLName, String address, String phoneNumber, String countryCodes, String senOccupation) throws AWTException, InterruptedException { // have to merge with above code
		if(!recFName.equalsIgnoreCase("NA")){
			receiverFirstName.sendKeys(recFName);
		}
		else{
			receiverFirstName.sendKeys(getRandomString(6).toLowerCase());
		}
		if(!recLName.equalsIgnoreCase("NA")){
			receiverLastName.sendKeys(recLName);
		}
		else{
			receiverLastName.sendKeys(getRandomString(5).toLowerCase());
		}

		if(!address.equalsIgnoreCase("NA")) {
			senderAddressField.sendKeys(address);
			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			senderAddressField.sendKeys(Keys.ENTER);
		}
		if(!countryCodes.equalsIgnoreCase("NA")){
			countryCode.sendKeys(countryCodes);
			String countries = String.format(countryXpath, countryCodes);
			driver.findElement(By.xpath(countries)).click();
		}
		if(!phoneNumber.equalsIgnoreCase("NA")){
			receiverPhone.sendKeys(phoneNumber);
		}
		if(!senOccupation.equalsIgnoreCase("NA")){
			scrollPage("DOWN");
		}
		nextBtn.click();
	}

	/** See if method can be updated to more dynamic
	 * Method for find a existing receiver based on the country and service type
	 * @param receiveType
	 * @param receiverCountry
	 */
	public void sendToExistingReceiver(String receiveType, String receiverCountry){

		if(isElementDisplayed(receiverPreviousRecipient, timeToWait)) {
			List<WebElement> paymentType = driver.findElements(By.xpath("//div[@class='card-text']/span[1]"));
			List<WebElement> receiveCountry = driver.findElements(By.xpath("//div[@class='card-text']/preceding-sibling::div"));

			String country = null;

			if (receiverCountry.equalsIgnoreCase("USA")) {
				country = "United States of America";
			}
			if (receiverCountry.equalsIgnoreCase("CHN")) {
				country = "China";
			}
			if (receiverCountry.equalsIgnoreCase("PHL")) {
				country = "Philippines";
			}
			if(receiverCountry.equalsIgnoreCase("FRA")){
				country = "France";
			}

			for (int i = 0; i < paymentType.size(); i++) {
				if (paymentType.get(i).getText().equalsIgnoreCase(receiveType.substring(0, receiveType.length()-8))) {
					if(receiveCountry.size()>2){
						if (receiveCountry.get(i + 2).getText().equalsIgnoreCase(country)) {
							paymentType.get(i).click();
							break;
						}
					}
					else {
						if (receiveCountry.get(i + 1).getText().equalsIgnoreCase(country)) {
							paymentType.get(i).click();
							break;
						}
					}
				}
				if (paymentType.get(i).getText().equalsIgnoreCase(receiveType)){
					if(receiveCountry.size()>2){
						if (receiveCountry.get(i + 2).getText().equalsIgnoreCase(country)) {
							paymentType.get(i).click();
							break;
						}
					}
					else {
						if (receiveCountry.get(i + 1).getText().equalsIgnoreCase(country)) {
							paymentType.get(i).click();
							break;
						}
					}
				}
			}
		}
	}


	//************************************** Sender info confirmation page *******************
	/**
	 * Method to check fraudWarning Popup
	 */
	public void fraudWarningPopup(){
		if(isElementDisplayed(fraudAlertMsgYes, 30)){
			fraudAlertMsgYes.click();
		}
	}

	/**
	 * Method to click on send
	 */
	public void clickOnSendNext(){
		Assert.assertTrue(isElementDisplayed(receiveOffersRadioBtn , timeToWait));
		receiveOffersRadioBtn.click();
		Assert.assertTrue(isElementDisplayed(nextBtn , timeToWait));
		nextBtn.click();
	}

	/**
	 * Method to click on send
	 * @throws InterruptedException
	 */
	public void send() throws InterruptedException {
		if(isElementDisplayed(collectFundsHeader, 15)) {
			Thread.sleep(2000);
			sendMoneyBtn.click();
		}
	}

	/**
	 * Method to complete send
	 */
	public void completeSend() throws Exception {
		Assert.assertTrue(isElementDisplayed(collectFundsHeader, 90));
		waitForElementToBeVisibleAndClick(sendMoneyXpath);
		String refId = referenceId.getText();
		getScreenShot();
		System.out.println("Reference Number "+ refId);
		Thread.sleep(3000);
		Assert.assertTrue(ifElementIsClickable(finishedBtn, 30));
		finishedBtn.click();
	}

	public void completeFinishButton(){
//		Assert.assertTrue(ifElementIsClickable(finishedBtn, 15));
		finishedBtn.click();
	}

	/**
	 * Method to validate tax fields during send
	 */
	public void validateCollectFunds(){
		if(isElementDisplayed(collectFundsHeader, 60)){
			Assert.assertTrue(isElementDisplayed(collectFunds_TaxField, 0));
			Assert.assertTrue(isElementDisplayed(collectFunds_FeesField, 0));
			Assert.assertTrue(isElementDisplayed(collectFunds_OtherFees,0));
			Assert.assertTrue(isElementDisplayed(collectFunds_OtherTaxes,0));
		}
	}

	/**
	 * Method to complete Send
	 * @return reference Number
	 */
	public String completeSendWithReturnValue() throws Exception {
		Assert.assertTrue(isElementDisplayed(sendMoneyBtn, 90));
		waitForElementToBeVisibleAndClick(sendMoneyXpath);
		Assert.assertTrue(isElementDisplayed(referenceId , timeToWait));
		String refId = referenceId.getText();
		getScreenShot();
		System.out.println("Reference Number "+ refId);
		Assert.assertTrue(isElementDisplayed(finishedBtn , timeToWait));
		finishedBtn.click();
		return refId;
	}

	/**
	 * Method to enter and confirm sender contact info
	 * @param phone Data sheet phone number
	 * @param email Data sheet email id
	 * @param preferredLang Data sheet language
	 * @param plusNumber Data sheet
	 */
	public void confirmContactInformation(String phone, String email, String preferredLang, String plusNumber){
		if(!phone.equalsIgnoreCase("NA")) {
			Assert.assertTrue(isElementDisplayed(primaryPhoneNumber, timeToWait));
			primaryPhoneNumber.clear();
			primaryPhoneNumber.sendKeys(phone);
		}
		if(!email.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(primaryEmail, timeToWait));
			primaryEmail.clear();
			primaryEmail.sendKeys(email);
		}
		if(!preferredLang.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(preferredLanguage, timeToWait));
			selectDdlByText(preferredLanguage, preferredLang);
		}
		Assert.assertTrue(isElementDisplayed(receiveOffersRadioBtn, timeToWait));
		receiveOffersRadioBtn.click();
		if(!plusNumber.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(plusProgramChkbox, timeToWait));
			plusProgramChkbox.click();
			Assert.assertTrue(isElementDisplayed(textAndEmailRadioButton, timeToWait));
			textAndEmailRadioButton.click();
		}
		nextBtn.click();
	}

	/**
	 * Method to enter random mfa token
	 * @param length
	 * @throws AWTException
	 */
	public void mfa(int length) throws AWTException, InterruptedException {
		Assert.assertTrue(isElementDisplayed(mfaPopup, 5));
		otpText.sendKeys(RandomStringUtils.randomNumeric(length));
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void validateMFAInvalidTokenErrorMessage(){
		Assert.assertTrue(isElementDisplayed(invalidToken, 10));
	}

	public void validateAuthenticationFailed(){
		Assert.assertTrue(isElementDisplayed(authenticationFailedText, 10));
	}


	//****************************************** ID Scan *************************************/

	public void  selectImageScan(){
		Assert.assertTrue(isElementDisplayed(imageScan, timeToWait));
		imageScan.click();
	}

	public void selectUpload(){
		Assert.assertTrue(isElementDisplayed(upload, timeToWait));
		Assert.assertTrue(ifElementIsClickable(upload, timeToWait));
		upload.click();
		isElementDisplayed(success, timeToWait);
		finishScanButton.click();

	}

	public void idScanFrontAndBack() throws InterruptedException {
		idOneScanFront.click();
		Thread.sleep(3000);
		idOneScanBack.click();
		Thread.sleep(3000);
		nextBtn.click();
	}


	//**************************************** Identification Page ***************************************

	/** Not been used
	 * Method to enter expiration date
	 */
	public void identification(){
		if(isElementDisplayed(expirationText, 15)){
			selectDdlByText(expirationYear, "2030");
			selectDdlByText(selectBirthMonth, "12");
			selectDdlByText(selectBirthDay, "12");
			nextBtn.click();
		}
		if(isElementDisplayed(senderIdentification, 10)){
			nextBtn.click();
		}

	}


	//**************************************** Service options Page ****************************

	/**
	 * Method to select send type and payment type
	 * @param sendType data sheet send type
	 * @param deliveryType data sheet delivery type
	 */
	public void serviceOptions(String sendType, String deliveryType){

		if(isElementDisplayed(serviceOptionsHeader, 10)){
			Assert.assertTrue(serviceOptionsHeader.getText().equalsIgnoreCase("Service Options"));
		}
		List<WebElement> paymentType = driver.findElements(By.xpath("//ul[@class='nav nav-pills sdo']/li"));

		for(int i=0; i<paymentType.size(); i++){
			if(!paymentType.get(i).getText().equalsIgnoreCase("Cash Options")){
				if(paymentType.get(i).getText().equalsIgnoreCase(sendType)){
					paymentType.get(i).click();
					break;
				}
			}
		}

		List<WebElement> deliveryTypeXpath= driver.findElements(By.xpath("//*[@class='row']/div/app-delivery-option/app-card/div/h5/card-title"));

		for(int i=0; i<deliveryTypeXpath.size(); i++){
			if(deliveryTypeXpath.get(i).getText().equalsIgnoreCase(deliveryType)){
				deliveryTypeXpath.get(i).click();
				break;
			}
		}
	}

	/**
	 * Method to select send type and payment type with return type
	 * @param sendType
	 * @param deliveryType
	 * @return Map with fees and discount amount
	 */
	public HashMap<String, String> serviceOptionsWithReturn(String sendType, String deliveryType){
		String discountAmount = null;
		String feesAmount = null;
		if(isElementDisplayed(serviceOptionsHeader, 10)){
			Assert.assertTrue(serviceOptionsHeader.getText().equalsIgnoreCase("Service Options"));
		}
		List<WebElement> paymentType = driver.findElements(By.xpath("//ul[@class='nav nav-pills sdo']/li"));

		for(int i=0; i<paymentType.size(); i++){
			if(!paymentType.get(i).getText().equalsIgnoreCase("Cash Options")){
				if(paymentType.get(i).getText().equalsIgnoreCase(sendType)){
					paymentType.get(i).click();
					break;
				}
			}
		}

		List<WebElement> deliveryTypeXpath= driver.findElements(By.xpath("//*[@class='row']/div/app-delivery-option/app-card/div/h5/card-title"));
		List<WebElement> discountFeeXpath = driver.findElements(By.xpath("//span[contains(text(), 'Discount')]/ancestor::div[2]/div[3]"));
		List<WebElement> feeAmount = driver.findElements(By.xpath("//span[contains(text(), 'Fees')]/ancestor::div[1]/div[1]"));

		for(int i=0; i<deliveryTypeXpath.size(); i++){
			if(deliveryTypeXpath.get(i).getText().equalsIgnoreCase(deliveryType)){
				discountAmount = discountFeeXpath.get(i).getText().replace("   USD", "");
				feesAmount = feeAmount.get(i).getText().replace("   USD", "");
				deliveryTypeXpath.get(i).click();
				break;
			}
		}

		HashMap<String, String> returnMap = new HashMap<>();
		returnMap.put("fees", feesAmount);
		returnMap.put("discountAmount", discountAmount);
		return returnMap;
	}

	/**
	 * Method to validate amount sent
	 * @param sendAmount data sheet send amount
	 * @param type fee type
	 */
	public void validateAmountToBeSent(String sendAmount, String type){

		isElementDisplayed(serviceOptionsHeader, 10);
		List<WebElement> amount = driver.findElements(By.xpath("//*[@class='row']/div/app-delivery-option/app-card/div/div[1]/card-body/div[4]/div"));
		String amountOne= amount.get(0).getText();
		String totalAmount = amountOne.substring(0, amountOne.length()-9);
		switch(type){
			case "excludingFee":
				Assert.assertTrue(Integer.parseInt(totalAmount)>Integer.parseInt(sendAmount));
				break;
			case "includingFee":
				assertEquals(Integer.parseInt(sendAmount), Integer.parseInt(totalAmount));
		}

	}

	public void validateMaxAmount(){
		Assert.assertTrue(isElementDisplayed(maximumAmountMessage, timeToWait));
	}


	//****************************************** Additional Info page ********************************


	/**
	 * Method to enter additional information
	 * Note : all country fields in data sheet should be in CAPS
	 *
	 * @param sourceOfFund Data sheet sourceOfFunds
	 * @param relationShipToRec Data sheet relation ship to receiver
	 * @param purposeOfTran Data sheet purpose of transaction
	 * @param reason Data sheet reason why moneyGram
	 * @param citizenShip Data sheet citizenship country
	 * @param national Data sheet nationality
	 */
	public void additionalPageInformation(String sourceOfFund, String relationShipToRec, String purposeOfTran, String reason, String citizenShip, String national){

		if(isElementDisplayed(additionalDataFieldHeader, 60)){
			if(!sourceOfFund.equalsIgnoreCase("NA")) {
				sourceOfFunds.click();
				String source = String.format(sourceOfFundsXpath, sourceOfFund);
				driver.findElement(By.xpath(source)).click();
			}
			if(!relationShipToRec.equalsIgnoreCase("NA")) {
				relationshipToReceiver.click();
				String relation = String.format(relationshipToReceiverXpath, relationShipToRec);
				driver.findElement(By.xpath(relation)).click();
			}
			if(!purposeOfTran.equalsIgnoreCase("NA")) {
				purposeOfTransactionAdditionData.click();
				String purpose = String.format(purposeOfTransactionAdditionalDataXpath, purposeOfTran);
				driver.findElement(By.xpath(purpose)).click();
			}
			if(!reason.equalsIgnoreCase("NA")){
				useOfMGIServices.click();
				String reasons = String.format(useOfMGIServicesXpath, reason);
				driver.findElement(By.xpath(reasons)).click();
			}
			if(!citizenShip.equalsIgnoreCase("NA")){
				citizenShipCountry.sendKeys(citizenShip);
				String countries = String.format(countryXpath, citizenShip);
				driver.findElement(By.xpath(countries)).click();
			}
			if(!national.equalsIgnoreCase("NA")){
				nationality.sendKeys(national);
				String countries = String.format(countryXpath, national);
				driver.findElement(By.xpath(countries)).click();
			}
			nextBtn.click();
		}
	}

	/** Need to update as gender field shows up only for italy and Permanent Residence
	 * Method to enter additional information
	 * Note : all country fields in data sheet should be in CAPS
	 *
	 * @param sourceOfFund Data sheet sourceOfFunds
	 * @param relationShipToRec Data sheet relation ship to receiver
	 * @param purposeOfTran Data sheet purpose of transaction
	 * @param reason Data sheet reason why moneyGram
	 * @param citizenShip Data sheet citizenship country
	 * @param national Data sheet nationality
	 * @param gender Data sheet gender
	 */
	public void additionalPageInfo(String sourceOfFund, String relationShipToRec, String purposeOfTran, String reason, String citizenShip, String national, String gender, String perResidency,  String proofOfFund){

		if(isElementDisplayed(additionalDataFieldHeader, 60)){
			if(!sourceOfFund.equalsIgnoreCase("NA")) {
				sourceOfFunds.click();
				String source = String.format(sourceOfFundsXpath, sourceOfFund);
				driver.findElement(By.xpath(source)).click();
			}
			if(!relationShipToRec.equalsIgnoreCase("NA")) {
				relationshipToReceiver.click();
				String relation = String.format(relationshipToReceiverXpath, relationShipToRec);
				driver.findElement(By.xpath(relation)).click();
			}
			if(!purposeOfTran.equalsIgnoreCase("NA")) {
				purposeOfTransactionAdditionData.click();
				String purpose = String.format(purposeOfTransactionAdditionalDataXpath, purposeOfTran);
				driver.findElement(By.xpath(purpose)).click();
			}
			if(!reason.equalsIgnoreCase("NA")){
				useOfMGIServices.click();
				String reasons = String.format(useOfMGIServicesXpath, reason);
				driver.findElement(By.xpath(reasons)).click();
			}
			if(!gender.equalsIgnoreCase("NA")){
				additionalInformationGender.click();
				String gen = String.format(genderXpath, gender);
				driver.findElement(By.xpath(gen)).click();
			}
			if(!citizenShip.equalsIgnoreCase("NA")){
				citizenShipCountry.clear();
				citizenShipCountry.sendKeys(citizenShip);
				String countries = String.format(countryXpath, citizenShip);
				driver.findElement(By.xpath(countries)).click();
			}
			if(!national.equalsIgnoreCase("NA")){
				nationality.clear();
				nationality.sendKeys(national);
				String countries = String.format(countryXpath, national);
				driver.findElement(By.xpath(countries)).click();
			}
			if(!perResidency.equalsIgnoreCase("NA")){
				permanentResidency.clear();
				permanentResidency.sendKeys(perResidency);
				String countries = String.format(permanentResidencyXpath, perResidency);
				driver.findElement(By.xpath(countries)).click();
			}
			if(!proofOfFund.equalsIgnoreCase("NA")){
				proofOfFunds.click();
				String proof = String.format(proofOfFundsXpath, proofOfFund);
				driver.findElement(By.xpath(proof));
			}
			nextBtn.click();
		}

	}


	//******************************************* Sender details **********************************


	// Method updated due to countries like Belgium need birth city field
	/**
	 * Method to enter new sender information
	 * Note: All country fields should be in CAPS
	 * @param senFName Data sheet sender firstname
	 * @param senLName Data sheet sender lastname
	 * @param country Data sheet country
	 * @param address Data sheet address
	 * @param birthCountry Data sheet birth Country
	 * @param birthCity Data sheet birth city
	 * @param birthYear Data sheet birth year
	 * @param birthMonth Data sheet birth month
	 * @param birthDay Data sheet birth day
	 * @param sen_occupation Data sheet occupation
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void fillNewSenderInformation(String senFName, String senLName, String country, String address, String birthCountry, String birthCity, String birthYear, String birthMonth, String birthDay, String sen_occupation) throws AWTException, InterruptedException {
		Assert.assertTrue(isElementDisplayed(senderFirstName, timeToWait));
		if(!senFName.equalsIgnoreCase("NA")){
			senderFirstName.sendKeys(senFName);}
		else{
			String firstname = getRandomString(5).toLowerCase();
			senderFirstName.sendKeys(firstname);
		}
		Assert.assertTrue(isElementDisplayed(senderLastName, timeToWait));
		if(!senLName.equalsIgnoreCase("NA")){
			senderLastName.sendKeys(senLName);
		}
		else{
			String lastname = getRandomString(5).toLowerCase();
			senderLastName.sendKeys(lastname);
		}
		if(!country.equalsIgnoreCase("NA")) {
			Assert.assertTrue(isElementDisplayed(senderCountryField, timeToWait));
			senderCountryField.sendKeys(country);
		}
		if(isElementDisplayed(senderAddressField,2)) {
			senderAddressField.sendKeys(address);
		}
		else{
			driver.findElement(By.xpath("//*[@id='sender_Address_helpText']/ancestor::div[1]/input")).sendKeys(address);
		}
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		if(!birthCity.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(birthCityField, timeToWait));
			birthCityField.sendKeys(birthCity);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		else{
			if(!birthCountry.equalsIgnoreCase("NA")){
				Assert.assertTrue(isElementDisplayed(birthCountryField, timeToWait));
				birthCountryField.sendKeys(birthCountry);
				String countries = String.format(countryXpath, birthCountry);
				driver.findElement(By.xpath(countries)).click();
				birthCountryField.sendKeys(Keys.ENTER);
			}
		}
		if(!birthYear.equalsIgnoreCase("NA")) {
			selectDdlByText(selectBirthYear, birthYear);
			selectDdlByText(selectBirthMonth, birthMonth);
			selectDdlByText(selectBirthDay, birthDay);
		}
		if(!sen_occupation.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(occupation, timeToWait));
			selectDdlByText(occupation, sen_occupation);
		}
		Assert.assertTrue(isElementDisplayed(nextBtn, timeToWait));
		nextBtn.click();
	}

	/**
	 * Method to enter send birth city
	 * @param birthCity
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void sendBirthCity(String birthCity) throws InterruptedException, AWTException {
		if(!birthCity.equalsIgnoreCase("NA")){
			birthCityField.sendKeys(birthCity);
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}



	/** Update the test cases with individual steps
	 * Method to validate threshold popup
	 */
	public void validateThresholdLimitPopup(){
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cannot complete')]")));
		act.moveToElement(warning).perform();
		String threshold  = driver.findElement(By.xpath("//*[contains(text(),'Cannot complete')]")).getText();
		System.out.println(threshold);
		driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
	}

	//****************************************** ID Info Page ***************************************

	/**
	 * Method to enter Id one details for known customer
	 * @param idChoice Data sheet Id1
	 * @param idNumber Data sheet Id1number
	 */
	public void enterIdOneKnown(String idChoice, String idNumber){
		idChoiceField.click();
		String idChoiceOne = String.format(idChoiceDropDown, idChoice);
		driver.findElement(By.xpath(idChoiceOne)).click();
		int idValue = idNumber.length()-4;
		idOneTextField.sendKeys(idNumber.substring(idValue));
	}

	/**
	 * Method to enter Id two details for known customer
	 * @param secondaryId Data sheet Id2
	 * @param secondaryIdNumber Data sheet Id2number
	 */
	public void enterIdTwoKnown(String secondaryId, String secondaryIdNumber){
		if(!secondaryId.equalsIgnoreCase("NA")) {
			idSecChoiceField.click();
			String idChoiceTwo = String.format(idChoiceTwoDropDown, secondaryId);
			driver.findElement(By.xpath(idChoiceTwo)).click();
			int idValue = secondaryIdNumber.length()-4;
			idTwoTextFiled.sendKeys(secondaryIdNumber.substring(idValue));
		}
	}

	/**
	 * Method to enter ID two details again after receiving error
	 * @param secondaryId
	 * @param secondaryIdNum
	 */
	public void enterIdTwoKnownWithError(String secondaryId, String secondaryIdNum){
		if(isElementDisplayed(idChoiceErrorMessage, 20)){
			getNextBtn().click();
			if(!secondaryId.equalsIgnoreCase("NA")) {
				Assert.assertTrue(isElementDisplayed(secondaryIdType, timeToWait));
				secondaryIdType.click();
				List<WebElement> secondaryIdTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId2_Type']/option"));

				for(int i=0; i<secondaryIdTypes.size(); i++){
					if(secondaryIdTypes.get(i).getText().equalsIgnoreCase(secondaryId)){
						secondaryIdTypes.get(i).click();
						break;
					}
				}
				Assert.assertTrue(isElementDisplayed(secondaryIdNumber, timeToWait));
				secondaryIdNumber.sendKeys(secondaryIdNum);
				getNextBtn().click();
			}
		}

	}


	/**
	 * Method to enter Id one details
	 * @param idChoice Data sheet Id choice
	 * @param idNumber Data sheet Id number
	 * @param country Data sheet country
	 * @param State Data sheet state
	 */
	public void enterIDOneIdentificationUnknown(String idChoice, String idNumber, String country, String State){
		idTypeField.click();
		List<WebElement> idTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId1_Type']/option"));

		for(int i=0; i<idTypes.size(); i++){
			if(idTypes.get(i).getText().equalsIgnoreCase(idChoice)){
				idTypes.get(i).click();
				break;
			}
		}
		Assert.assertTrue(isElementDisplayed(idNumberField, timeToWait));
		idNumberField.sendKeys(idNumber);
		Assert.assertTrue(isElementDisplayed(idIssueCountryField, timeToWait));
		idIssueCountryField.sendKeys(country);
		String countries = String.format(countryXpath, country);
		driver.findElement(By.xpath(countries)).click();
//		textSuggestAndEnter(idIssueCountryField, country);
		if(!State.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(idIssueStateField, timeToWait));
			textSuggestAndEnter(idIssueStateField, State);
		}
	}

	public void enterIDOneUnknown(String idChoice, String idNumber, String country){
		idTypeField.click();
		List<WebElement> idTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId1_Type']/option"));

		for(int i=0; i<idTypes.size(); i++){
			if(idTypes.get(i).getText().equalsIgnoreCase(idChoice)){
				idTypes.get(i).click();
				break;
			}
		}
		Assert.assertTrue(isElementDisplayed(idNumberField, timeToWait));
		idNumberField.sendKeys(idNumber);
		Assert.assertTrue(isElementDisplayed(idIssueCountryField, timeToWait));
		idIssueCountryField.sendKeys(country);
		String countries = String.format(countryXpath, country);
		driver.findElement(By.xpath(countries)).click();
	}

	public void enterIdOneState(String state) {
		if(!state.equalsIgnoreCase("NA")){
			Assert.assertTrue(isElementDisplayed(idIssueStateField, timeToWait));
			textSuggestAndEnter(idIssueStateField, state);
		}
	}

	/**
	 * Method to enter Id one city
	 * @param city Data sheet city
	 */
	public void enterIdOneCity(String city){
		idIssueCity.sendKeys(city);
	}

	public void enterIdIssueAuthority(String authority){
		idIssueAuthority.click();
		List<WebElement> authorityIdTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId1_Issue_Authority']/option"));

		for(int i=0; i<authorityIdTypes.size(); i++){
			if(authorityIdTypes.get(i).getText().equalsIgnoreCase(authority)){
				authorityIdTypes.get(i).click();
				break;
			}
		}
	}

	/**
	 * Method to enter Id two details
	 * @param secondaryId Data sheet secondary Id type
	 * @param secondaryIdNum Data sheet secondary Id number
	 */
	public void enterIDTwoIdentificationUnknown(String secondaryId, String secondaryIdNum){
		Assert.assertTrue(isElementDisplayed(secondaryIdType, timeToWait));
		secondaryIdType.click();
		List<WebElement> secondaryIdTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId2_Type']/option"));

		for(int i=0; i<secondaryIdTypes.size(); i++){
			if(secondaryIdTypes.get(i).getText().equalsIgnoreCase(secondaryId)){
				secondaryIdTypes.get(i).click();
				break;
			}
		}
		Assert.assertTrue(isElementDisplayed(secondaryIdNumber, timeToWait));
		secondaryIdNumber.sendKeys(secondaryIdNum);
	}

	/**
	 * Method to enter expiration Date
	 * @param year Data sheet expiry year
	 * @param month Data sheet expiry month
	 * @param date Data sheet expiry date
	 */
	public void enterExpirationDate(String year, String month, String date) {

		if(!year.equalsIgnoreCase("NA")) {
			Assert.assertTrue(isElementDisplayed(expirationYear, 60));
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
		if(isElementDisplayed(senderIdentification, 10)){
			nextBtn.click();
		}
	}

	/**
	 * Method to validate sender Identification page
	 */
	public void senderIdentification(){
		if(isElementDisplayed(senderIdentification, 10)){
			nextBtn.click();
		}
	}

	/**
	 * Method to enter issue date
	 * @param year Data sheet issue year
	 * @param month Data sheet issue month
	 * @param date Data sheet issue date
	 */
	public void enterIssueDate(String year, String month, String date) {

		if(!year.equalsIgnoreCase("NA")) {
			issueYear.click();
			String year1 = String.format(issueYearXpath, year);
			driver.findElement(By.xpath(year1)).click();

		}
		if(!month.equalsIgnoreCase("NA")){
			issueMonth.click();
			String month1 = String.format(issueMonthXpath, month);
			driver.findElement(By.xpath(month1)).click();
		}
		if(!date.equalsIgnoreCase("NA")){
			issueDate.click();
			String date1 = String.format(issueDateXpath, date);
			driver.findElement(By.xpath(date1)).click();
		}
	}

	/**
	 * Method to enter receiver country code
	 * @param receiverCountryCode Data sheet receiver country code
	 * @throws InterruptedException
	 */
	public void receiverCountryCode(String receiverCountryCode) throws InterruptedException, AWTException {

		if(!receiverCountryCode.equalsIgnoreCase("NA")){
			Thread.sleep(5000);
			Assert.assertTrue(isElementDisplayed(receiverInformationHeader, timeToWait));
			scrollPage("UP");
			Assert.assertTrue(isElementDisplayed(countryCode, 15));
			countryCode.sendKeys(receiverCountryCode);
			String countries = String.format(countryXpath, receiverCountryCode);
			driver.findElement(By.xpath(countries)).click();
			nextBtn.click();
		}
	}

	//**************************************** Third party Info Page *************************
	/**
	 * Method to validate third party page and click on next
	 */
	public void thirdPartyInfoForHighAmount()
	{
		if(isElementDisplayed(thirdPartyPageHeader, 5)) {
			noneRadioBtn.click();
			nextBtn.click();
		}
	}

	public void thirdPartyInfoOrganization(String address, String idType, String number) throws AWTException, InterruptedException {
		if(isElementDisplayed(thirdPartyPageHeader, 10)) {
			organizationRadioButton.click();
			Assert.assertTrue(isElementDisplayed(organizationAddressFieldHeader, 2));
			organizationName.sendKeys(RandomStringUtils.randomAlphabetic(4));
			organizationAddressField.sendKeys(address);
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			organizationSenderPersonalId2.click();
			List<WebElement> secondaryIdTypes = driver.findElements(By.xpath("//*[@id='thirdParty_Sender_PersonalId2_Type']/option"));

			for(int i=0; i<secondaryIdTypes.size(); i++){
				if(secondaryIdTypes.get(i).getText().equalsIgnoreCase(idType)){
					secondaryIdTypes.get(i).click();
					break;
				}
			}
			Assert.assertTrue(isElementDisplayed(organizationSenderPersonalId2Text, timeToWait));
			organizationSenderPersonalId2Text.sendKeys(number);
			nextBtn.click();

		}
	}


	//**************************************** Proof of Address ************************************


	/**
	 * Method to enter proof of address date along with year and month, this method selects the first shown date Eg: Today's date
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void proofOfAddress() throws AWTException, InterruptedException {
		isElementDisplayed(proofOfAddressTitle, 10);
			proofOfAddressYear.click();
			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			proofOfAddressMonth.click();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			proofOfAddressDay.click();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			nextBtn.click();

	}

	//************************************** Account Details *****************************************

	/**
	 * Method to enter account Number
	 */
	public void enterAccountNumber(){
		if(isElementDisplayed(accountNumberTextField, 5)) {
			accountNumberTextField.sendKeys(RandomStringUtils.randomNumeric(10));
			nextBtn.click();
		}
	}

	/**
	 * Method to enter IFSC code, account number and purpose of transaction
	 * @param iFSCCode Data sheet iFSCCode
	 * @param accountNumber Data sheet account Number
	 * @param purposeOfFunds Data sheet purpose of funds
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void enterAccountDetails(String iFSCCode, int accountNumber, String purposeOfFunds) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		if(isElementDisplayed(accountInformationHeader, 20)){
			if(!iFSCCode.equalsIgnoreCase("NA")){
				bankIFSCField.sendKeys(iFSCCode);
				bankSearch.click();
			}
			else{
				bankNameField.click();
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				districtNameField.click();
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				branchNameField.click();
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
			}
			String randomAccountNumber = RandomStringUtils.randomNumeric(accountNumber);
			accountNumberTextField.sendKeys(randomAccountNumber);
			if (!purposeOfFunds.equalsIgnoreCase("NA")) {
				if(isElementDisplayed(purposeOfTransaction, 3));
				Thread.sleep(2000);
				scrollPage("DOWN");
				purposeOfTransaction.click();
				String purpose = String.format(purposeOfTransactionXpath, purposeOfFunds);
				driver.findElement(By.xpath(purpose)).click();
			}
			nextBtn.click();
			if (isElementDisplayed(additionalDataCollection, 10)) {
				accountNumberVerificationField.sendKeys(randomAccountNumber);
				nextBtn.click();
			}
		}
	}


	//************************************** Unused Methods *****************************************

//	/**
//	 * Method to enter Id details for unknown consumer
//	 * @param idChoice Data sheet Id1
//	 * @param idNumber Data sheet Id1number
//	 * @param country Data sheet country
//	 * @param State Data sheet state
//	 * @param secondaryId Data sheet Id2
//	 * @param secondaryIdNum Data sheet Id2number
//	 */
//	public void enterIdentificationUnknown(String idChoice, String idNumber, String country, String State, String secondaryId, String secondaryIdNum){
//		idTypeField.click();
//		List<WebElement> idTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId1_Type']/option"));
//
//		for(int i=0; i<idTypes.size(); i++){
//			if(idTypes.get(i).getText().equalsIgnoreCase(idChoice)){
//				idTypes.get(i).click();
//				break;
//			}
//		}
//		idNumberField.sendKeys(idNumber);
//		textSuggestAndEnter(idIssueCountryField, country);
//		if(!State.equalsIgnoreCase("NA")){
//			textSuggestAndEnter(idIssueStateField, State);
//		}
//		nextBtn.click();
//		List<WebElement> secondaryIdTypes = driver.findElements(By.xpath("//*[@id='sender_PersonalId2_Type']/option"));
//
//		for(int i=0; i<secondaryIdTypes.size(); i++){
//			if(secondaryIdTypes.get(i).getText().equalsIgnoreCase(secondaryId)){
//				secondaryIdTypes.get(i).click();
//				break;
//			}
//		}
//		secondaryIdNumber.sendKeys(secondaryIdNum);
//		nextBtn.click();
//	}
//
//
//
//	/** This method is broken down into two, need to update in all the class files
//	 * Method to enter Id details for known customer
//	 * @param idChoice Data sheet Id1
//	 * @param idNumber Data sheet Id1number
//	 * @param secondaryId Data sheet Id2
//	 * @param secondaryIdNumber Data sheet Id2number
//	 */
//	public void enterIdentificationKnown(String idChoice, String idNumber, String secondaryId, String secondaryIdNumber){
//		idChoiceField.click();
//		String idChoiceOne = String.format(idChoiceDropDown, idChoice);
//		driver.findElement(By.xpath(idChoiceOne)).click();
//		idOneTextField.sendKeys(idNumber.substring(5));
//		nextBtn.click();
//		if(!secondaryId.equalsIgnoreCase("NA")) {
//			idSecChoiceField.click();
//			String idChoiceTwo = String.format(idChoiceTwoDropDown, secondaryId);
//			driver.findElement(By.xpath(idChoiceTwo)).click();
//			idTwoTextFiled.sendKeys(secondaryIdNumber.substring(5));
//			nextBtn.click();
//		}
//	}
//
//	/**
//	 * Need to update this method
//	 * @param amount
//	 * @param DestCountry
//	 * @param DestState
//	 */
//	public void sendTransactionVerifyOverLimit(String amount, String DestCountry, String DestState) {
//		if (newCustomer.isDisplayed()) {
//			newCustomer.click();
//		}
//		else {
//			newRecvrBtn.click();
//		}
//		sendMoneyField.sendKeys(amount);
//		destCountryField.sendKeys(DestCountry);
//		destCountryField.sendKeys(Keys.ENTER);
//		state.sendKeys(DestState);
//		state.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		validateThresholdLimitPopup();
//	}
//
//
//
//	/**
//	 * Method to fill sender Info
//	 * @param senFName Data sheet sender firstname
//	 * @param senLName Data sheet sender lastname
//	 * @param country Data sheet country
//	 * @param address Data sheet address
//	 * @param birthCountry Data sheet birth Country
//	 * @param birthYear Data sheet birth year
//	 * @param birthMonth Data sheet birth month
//	 * @param birthDay Data sheet birth day
//	 * @param sen_occupation Data sheet occupation
//	 * @throws AWTException
//	 * @throws InterruptedException
//	 */
//
//	public void fillNewSenderInfo(String senFName, String senLName, String country, String address, String birthCountry, String birthYear, String birthMonth, String birthDay, String sen_occupation) throws AWTException, InterruptedException {
//		if(!senFName.equalsIgnoreCase("NA")){
//			senderFirstName.sendKeys(senFName);}
//		else{
//			senderFirstName.sendKeys(getRandomString(5));
//		}
//		if(!senLName.equalsIgnoreCase("NA")){
//			senderLastName.sendKeys(senLName);
//		}
//		else{
//			senderLastName.sendKeys(getRandomString(5));
//		}
//		if(!country.equalsIgnoreCase("NA")) {
//			senderCountryField.sendKeys(country);
//		}
//		if(isElementDisplayed(senderAddressField,2)) {
//			senderAddressField.sendKeys(address);
//		}
//		else{
//			driver.findElement(By.xpath("//*[@id='sender_Address_helpText']/ancestor::div[1]/input")).sendKeys(address);
//		}
//		Robot robot = new Robot();
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		if(!birthCountry.equalsIgnoreCase("NA")){
//			birthCountryField.sendKeys(birthCountry);
//			String countries = String.format(countryXpath, birthCountry);
//			driver.findElement(By.xpath(countries)).click();
//			birthCountryField.sendKeys(Keys.ENTER);
//		}
//		selectDdlByText(selectBirthYear, birthYear);
//		selectDdlByText(selectBirthMonth, birthMonth);
//		selectDdlByText(selectBirthDay, birthDay);
//		if(!sen_occupation.equalsIgnoreCase("NA")){
//			selectDdlByText(occupation, sen_occupation);
//		}
//		nextBtn.click();
//	}
//
//
//	/**
//	 *
//	 * @param sourceOfFund Data sheet sourceOfFunds
//	 * @param relationShipToRec Data sheet relation ship to receiver
//	 * @param purposeOfTran Data sheet purpose of transaction
//	 * @param reason Data sheet reason
//	 */
//	public void additionPageInfo(String sourceOfFund, String relationShipToRec, String purposeOfTran, String reason){
//
//		if(isElementDisplayed(additionalDataFieldHeader, 60)){
//			if(!sourceOfFund.equalsIgnoreCase("NA")) {
//				sourceOfFunds.click();
//				String source = String.format(sourceOfFundsXpath, sourceOfFund);
//				driver.findElement(By.xpath(source)).click();
//			}
//			if(!relationShipToRec.equalsIgnoreCase("NA")) {
//				relationshipToReceiver.click();
//				String relation = String.format(relationshipToReceiverXpath, relationShipToRec);
//				driver.findElement(By.xpath(relation)).click();
//			}
//			if(!purposeOfTran.equalsIgnoreCase("NA")) {
//				purposeOfTransactionAdditionData.click();
//				String purpose = String.format(purposeOfTransactionAdditionalDataXpath, purposeOfTran);
//				driver.findElement(By.xpath(purpose)).click();
//			}
//			if(!reason.equalsIgnoreCase("NA")){
//				useOfMGIServices.click();
//				String reasons = String.format(useOfMGIServicesXpath, reason);
//				driver.findElement(By.xpath(reasons)).click();
//			}
//			nextBtn.click();
//		}
//
//	}
//
//	/**
//	 *
//	 * @param selectPrimaryId
//	 * @param personalId
//	 * @param idCountry
//	 * @param idState
//	 * @param selectSecId
//	 * @param secIdNumber
//	 * @param phone
//	 * @param selectPrefferedLanguage
//	 * @param countryNameForCode
//	 * @param text
//	 * @throws Exception
//	 */
//	public void enterJustIdentificationAndContactInfo(String selectPrimaryId, String personalId, String idCountry, String idState, String selectSecId, String secIdNumber, String phone, String selectPrefferedLanguage, String countryNameForCode, String text) throws Exception {
//		selectDdlByText(idTypeField, selectPrimaryId);
//		idNumberField.sendKeys(personalId);
//		idIssueCountryField.sendKeys(idCountry);
//		idIssueCountryField.sendKeys(Keys.ENTER);
//		idIssueStateField.sendKeys(idState);
//		idIssueStateField.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		selectDdlByText(secondaryIdType, selectSecId);
//		secondaryIdNumber.sendKeys(secIdNumber);
//		nextBtn.click();
//		primaryPhoneNumber.sendKeys(phone);
//		selectDdlByText(preferredLanguage, selectPrefferedLanguage);
//		receiveOffersRadioBtn.click();
//		nextBtnn.click();
//		Thread.sleep(4000);
//	}
//
//
//
//	public void sendAmountToForeignDestination(String amount, String DestCountry) {
//		if (newCustomer.isDisplayed()) {
//			newCustomer.click();
//		}
//		else {
//			newRecvrBtn.click();
//		}
//		sendMoneyField.sendKeys(amount);
//		destCountryField.sendKeys(DestCountry);
//		destCountryField.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		homeDeliveryTab.click();
//		selectHomeDeliveryUSD.click();
//	}
//
//
//	public void sendToExisReceiver(String amount, String DestState) {
//		tenMinuteSerciceExsCus.click();
//		sendMoneyField.sendKeys(amount);
//		textSuggestAndEnter(state, DestState);
//		nextBtn.click();
//		tenMinuteBtn2.click();
//	}
//
//
//	public void fillForeignReceiverInfo(String recFName, String recLName, String recCity, String recPhone, String directionMsg) {
//		receiverFirstName.sendKeys(recFName);
//		receiverLastName.sendKeys(recLName);
//		receiverCity.sendKeys(recCity);
//		receiverPhone.sendKeys(recPhone);
//		directionField.sendKeys(directionMsg);
//		nextBtn.click();
//	}
//
//	public void fillForeignReceiverInfoHigh(String recFName, String recLName, String recCity, String recPhone, String directionMsg) { //merge with fillForeignReceiverInfo
//		receiverFirstName.sendKeys(recFName);
//		receiverLastName.sendKeys(recLName);
//		receiverCity.sendKeys(recCity);
//		receiverPhone.sendKeys(recPhone);
//		directionField.sendKeys(directionMsg);
//		nextBtn.click();
//		noneRadioBtn.click();
//		nextBtn.click();
//	}
//
//	public void enterIdentificationAndContact(String phone, String selectPrefferedLanguage) throws Exception {
//		primaryPhoneNumber.clear();
//		primaryPhoneNumber.sendKeys(phone);
//		selectDdlByText(preferredLanguage, selectPrefferedLanguage);
//		receiveOffersRadioBtn.click();
//		nextBtn.click();
////		if (fraudAlertMsgYes.isDisplayed()) {
////			fraudAlertMsgYes.click();}
//		Thread.sleep(4000);
//		//waitElementIsClickable(sendMoneyBtn);
//		sendMoneyBtn.click();
//		String refId = referenceId.getText();
//		System.out.println("Refrence Number "+ refId);
//		getScreenShot();
//		finishedBtn.click();
//
//	}
//
//	public String enterIdentificationAndContact1(String phone, String selectPrefferedLanguage) throws Exception {	 //merged with new code
//		primaryPhoneNumber.clear();
//		primaryPhoneNumber.sendKeys(phone);
//		selectDdlByText(preferredLanguage, selectPrefferedLanguage);
//		receiveOffersRadioBtn.click();
//		nextBtn.click();
//		if (fraudAlertMsgYes.isDisplayed()) {
//			fraudAlertMsgYes.click();}
//		Thread.sleep(4000);
//		//waitElementIsClickable(sendMoneyBtn);
//		sendMoneyBtn.click();
//		String refId = referenceId.getText();
//		System.out.println("Refrence Number "+ refId);
//		getScreenShot();
//		finishedBtn.click();
//		return refId;
//
//	}
//
//
//	public void addIdForHigherAmount(String selectPrimaryId, String personalId, String idCountry, String idState, String selectSecId, String secIdNumber) {
//		selectDdlByText(idTypeField, selectPrimaryId);
//		idNumberField.sendKeys(personalId);
//		textSuggestAndEnter(idIssueCountryField, idCountry);
//		textSuggestAndEnter(idIssueStateField, idState);;
//		nextBtn.click();
//		selectDdlByText(secondaryIdType, selectSecId);
//		secondaryIdNumber.sendKeys(secIdNumber);
//		nextBtn.click();
//	}
//
//
//	public void enterIdentificationAndContactForeign(String selectPrimaryId, String personalId, String idCountry, String idState, String selectSecId, String secIdNumber, String phone, String selectPrefferedLanguage, String countryNameForCode, String text) throws Exception {
//		selectDdlByText(idTypeField, selectPrimaryId);
//		idNumberField.sendKeys(personalId);
//		idIssueCountryField.sendKeys(idCountry);
//		idIssueCountryField.sendKeys(Keys.ENTER);
//		idIssueStateField.sendKeys(idState);
//		idIssueStateField.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		selectDdlByText(secondaryIdType, selectSecId);
//		secondaryIdNumber.sendKeys(secIdNumber);
//		nextBtn.click();
//		primaryPhoneNumber.sendKeys(phone);
//		selectDdlByText(preferredLanguage, selectPrefferedLanguage);
//		receiveOffersRadioBtn.click();
//		nextBtnn.click();
//		Thread.sleep(4000);
//		receiverCity.click();
//		receiverCity.sendKeys(Keys.TAB);
//		countryCode.sendKeys(countryNameForCode);
//		countryCode.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		fraudAlertMsgYes.click();
//		sendMoneyBtn.click();
//		String refId = referenceId.getText();
//		System.out.println("Refrence Number: "+ refId);
//		getScreenShot();
//		finishedBtn.click();
//	}
//
//	public void enterIdentificationAndContactForeignLow(String phone, String selectPrefferedLanguage, String countryNameForCode, String text) throws Exception {
//		primaryPhoneNumber.sendKeys(phone);
//		selectDdlByText(preferredLanguage, selectPrefferedLanguage);
//		receiveOffersRadioBtn.click();
//		nextBtnn.click();
//		Thread.sleep(4000);
//		receiverCity.click();
//		receiverCity.sendKeys(Keys.TAB);
//		countryCode.sendKeys(countryNameForCode);
//		countryCode.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		if (fraudAlertMsgYes.isDisplayed()) {
//			fraudAlertMsgYes.click();
//			sendMoneyBtn.click();
//			String refId = referenceId.getText();
//			System.out.println("Refrence Number: "+ refId);
//			getScreenShot();
//			finishedBtn.click();
//		}
//		else {
//		//fraudAlertMsgYes.click();
//		sendMoneyBtn.click();
//		String refId = referenceId.getText();
//		System.out.println("Refrence Number: "+ refId);
//		getScreenShot();
//		finishedBtn.click();
//		}
//	}
//
//
//
//	public void sendUsingUSExtCustAndRecipient(String string, String string2, String amount, String code) {
//		nameAndPhoneTab.click();
//		consumerLastNameField.sendKeys(string);
//		consumerPhoneField.sendKeys(string2);
//		searchBtn.click();
//		exstngCustomerSendToForeign.click();
//		nextBtn.click();
//		exstngRecipientForeign.click();
//		sendMoneyField.sendKeys(amount);
//		nextBtn.click();
//		accountDepositBtn.click();
//		sendToBankCard.click();
//		nextBtn.click();
//		nextBtn.click();
//		accountInfoField.sendKeys("258963321456987");
//		nextBtn.click();
//		accountInfoVerifyField.sendKeys("258963321456987");
//		nextBtn.click();
//		countryCode.sendKeys(code);
//		countryCode.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		nextBtn.click();
//		sendMoneyBtn.click();
//		String refId = referenceId.getText();
//		System.out.println("Refrence Number: "+ refId);
//		try {
//			getScreenShot();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finishedBtn.click();
//	}
//
//	public void sendUsingPlusCust(String string, String string2) {
//		plusRewardsNumber.sendKeys(string);
//		searchBtn.click();
//		plusRewardsMember.click();
//		nextBtn.click();
//	}
//
//
//	public void thirdPartyInfoForHighAmount(String sen_occupation)
//	{
//		noneRadioBtn.click();
//		nextBtn.click();
//	}
//
//	public void enterIdentificationExsRcvHigh(String selectChoiceId, String selectPrimaryId, String personalId, String idCountry, String idState, String selectSecChoiceId, String selectSecId, String secIdNumber) throws Exception {
//		selectDdlByText(idChoiceField, selectChoiceId);
//		selectDdlByText(idTypeField, selectPrimaryId);
//		idNumberField.sendKeys(personalId);
//		idIssueCountryField.sendKeys(idCountry);
//		idIssueCountryField.sendKeys(Keys.ENTER);
//		idIssueStateField.sendKeys(idState);
//		idIssueStateField.sendKeys(Keys.ENTER);
//		nextBtn.click();
//		selectDdlByText(idSecChoiceField, selectSecChoiceId);
//		selectDdlByText(secondaryIdType, selectSecId);
//		secondaryIdNumber.sendKeys(secIdNumber);
//		nextBtn.click();
//		nextBtnn.click();
//		Thread.sleep(4000);
//		fraudAlertMsgYes.click();
//		sendMoneyBtn.click();
//		String refId = referenceId.getText();
//		System.out.println("Refrence Number: "+ refId);
//		getScreenShot();
//		finishedBtn.click();
//	}

	public void getScreenShotFromPage() throws Exception {
		getScreenShot();
	}


}