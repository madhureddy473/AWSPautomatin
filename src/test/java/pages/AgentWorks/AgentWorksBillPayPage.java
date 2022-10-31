package pages.AgentWorks;


import java.awt.AWTException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import test.java.pages.BasePage.Page;

public class AgentWorksBillPayPage extends Page{

	//OBJECTS
	@FindBy(id="STRKEY_BILLER_NAME_CODE_KEYWORD")
	WebElement searchBiller;
	
	@FindBy(xpath="//button[@type='button']/span[contains(text(),'Next')]")
	WebElement nextBtn;

	public WebElement getNewCustomer() {
		return newCustomer;
	}

	@FindBy(xpath="(//span[contains(text(), 'New customer')])")
	WebElement newCustomer; 
	
	@FindBy(xpath="(//input[@type='tel'])[5]")
	WebElement paymentAmountField;
	
	@FindBy(xpath="(//input[@id='biller_AccountNumber'])")
	WebElement customerAcctNumberField; 
	
	@FindBy(id="STRKEY_ACCOUNT_NUMBER")
	WebElement acctNumberField; 
	
	@FindBy(id="sender_FirstName")
	WebElement senderFirstName;
	
	@FindBy(id="sender_LastName")
	WebElement senderLastName;
	
	@FindBy(xpath="//input[@placeholder='Enter a location']")
	WebElement senderAddressField;
	
	@FindBy(id="sender_PersonalId1_Type")
	WebElement secondaryIdType;
	
	@FindBy(id="sender_PersonalId1_Number")
	WebElement secondaryIdNumber;
	
	@FindBy(xpath="//div/div/select")
	WebElement selectBirthYear;
	
	@FindBy(xpath="//div[2]/select")
	WebElement selectBirthMonth;
	
	@FindBy(xpath="//div[3]/select")
	WebElement selectBirthDay;
	
	@FindBy(id="ok")
	WebElement sendMoneyBtn;

	public WebElement getFinishedBtn() {
		return finishedBtn;
	}

	@FindBy(xpath="//button[contains(text(),' Finished ')]")
	WebElement finishedBtn;
	
	@FindBy(xpath="//strong[@id='STRKEY_REF_NUM']")
	WebElement referenceId;
	
	@FindBy(xpath="//span[contains(text(),'Amount')]")
	WebElement maxAmountModalText;
	
	@FindBy(id="btnErrorModalSubmit")
	WebElement maxAmountModalBtn;

	public WebElement getFraudAlertMsgYes() {
		return fraudAlertMsgYes;
	}

	@FindBy(id="yes")
	WebElement fraudAlertMsgYes;

	@FindBy(xpath = "//div[@class='table-borders cursor-pointer p-d3125 mb-d625 highlight-border mg-button-shadow']/div/div[1]/div/strong[@class='text-uppercase']")
	WebElement senderSearchResults;

	@FindBy(xpath = "/html/body/app-root/div/app-bill-pay-container/aw-wizard/div/app-bill-pay-screen-customer-search/app-content-body/div/app-layout/div/div/div/div/div[2]/form/div[1]/div/app-field/section/div/div/app-number-field/div/div/input")
	WebElement phoneNumber;

//	@FindBy(xpath = "//span[contains(text(), 'Phone number')]/ancestor::div[2]/app-number-field/div/div/input[@class='form-control ng-untouched ng-pristine ng-invalid']")
//	WebElement phoneNumber;

	@FindBy(xpath = "//span[contains(text(), 'Plus number')]/ancestor::div[2]/app-number-field/div/div/input[@class='form-control ng-untouched ng-pristine ng-invalid']")
	WebElement plusNumber;

	@FindBy(xpath = "//span[contains(text(), 'Account number')]/ancestor::div[2]/app-text-field/div/div/input[@class='form-control ng-untouched ng-pristine ng-invalid']")
	WebElement accountNumber;

	@FindBy(xpath = "//*[@id='validateAccountNumber']")
	WebElement validateAccountNumber;

	//CONSTRUCTOR
	public AgentWorksBillPayPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}

	//METHODS

	/**
	 * Method to search for biller
	 * @param biller
	 * @param amounttopay
	 * @param accctnumber
	 * @param selectbiller
	 * @throws InterruptedException
	 */
	public void searchForBiller(String biller, String amounttopay, String accctnumber, String selectbiller) throws InterruptedException {
		searchBiller.sendKeys(biller);
		nextBtn.click();
		findElementUsingText(selectbiller).click();
		newCustomer.click();
		paymentAmountField.sendKeys(amounttopay);
		customerAcctNumberField.sendKeys(accctnumber);
		nextBtn.click();Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cannot complete')]")));
		act.moveToElement(warning).perform();
		String threshold  = driver.findElement(By.xpath("//*[contains(text(),'Cannot complete')]")).getText();
		System.out.println(threshold);
		driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
	}

	/**
	 *
	 * @param senFName
	 * @param senLName
	 * @param address
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void enterSenderInfo(String senFName, String senLName, String address) throws AWTException, InterruptedException {
		if(!senFName.equalsIgnoreCase("NA")) {
			senderFirstName.sendKeys(senFName);
		}
		else{
			senderFirstName.sendKeys(getRandomString(7));
		}
		if(!senLName.equalsIgnoreCase("NA")) {
			senderLastName.sendKeys(senLName);
		}
		else{
			senderLastName.sendKeys(getRandomString(8));
		}
		robotPageDownAndEnter(senderAddressField,address);
		Thread.sleep(2000);
		nextBtn.click();
	}

	/**
	 * Method to enter date of birth
	 * @param birthYear
	 * @param birthMonth
	 * @param birthDay
	 */
	public void enterDateOfBirth(String birthYear, String birthMonth, String birthDay){
		selectDdlByText(selectBirthYear, birthYear);
		selectDdlByText(selectBirthMonth, birthMonth);
		selectDdlByText(selectBirthDay, birthDay);
	}

	/**
	 * Method to search for biller
	 * @param billerName
	 * @param selectBiller
	 */
	public void searchBiller(String billerName, String selectBiller){
		searchBiller.sendKeys(billerName);
		nextBtn.click();
		findElementUsingText(selectBiller).click();
	}

	/**
	 * Method to enter amount to pay and account number
	 * @param amountToPay
	 * @param acctNumber
	 */
	public void paymentDetails(String amountToPay, String acctNumber){
		paymentAmountField.sendKeys(amountToPay);
		if(acctNumber.equalsIgnoreCase("NA")){
			customerAcctNumberField.sendKeys(RandomStringUtils.randomNumeric(10));
		}
		else {
			customerAcctNumberField.sendKeys(acctNumber);
		}
		nextBtn.click();
	}

	/**
	 * Method to enter account number for validation
	 * @param accountNo
	 */
	public void additionalAccountNumber(String accountNo){
		if(!accountNo.equalsIgnoreCase("NA")){
			validateAccountNumber.sendKeys(accountNo);
			nextBtn.click();
		}
	}

	/**
	 * Method to click on send money button
	 */
	public void submitButton(){
		if(isElementDisplayed(sendMoneyBtn, 90)) {
			sendMoneyBtn.click();
		}
		isElementDisplayed(finishedBtn, 30);
		ifElementIsClickable(finishedBtn, 10);
		try {
			getScreenShot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to search for existing customer
	 * @param consumerSearchNumber
	 */
	public void searchForCustomer(String type, String consumerSearchNumber){
		switch (type) {
			case "phoneNumber":
				phoneNumber.sendKeys(consumerSearchNumber);
				nextBtn.click();
				break;
			case "plusNumber":
				plusNumber.sendKeys(consumerSearchNumber);
				nextBtn.click();
				break;
			case "accountNumber":
				accountNumber.sendKeys(consumerSearchNumber);
				nextBtn.click();
				break;
		}
		isElementDisplayed(senderSearchResults, 15);
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='table-borders cursor-pointer p-d3125 mb-d625 highlight-border mg-button-shadow']/div/div[1]/div/strong[@class='text-uppercase']"));
		for(int i=0; i<searchResults.size(); i++){
			searchResults.get(i).click();
			break;
		}
	}

	//********************************* Unused Methods *****************************************

	public String payAndVerifyHigh() throws AWTException, InterruptedException {
		fraudAlertMsgYes.click();
		sendMoneyBtn.click();
		String refId = referenceId.getText();
		System.out.println("Refrence Number: "+ refId);
		try {
			getScreenShot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finishedBtn.click();
		return refId;
	}

	public void verifyMaxLimit() {
		String expectedText = "Amount exceeds the maximum amount for the product type of a Bill Payment (AC Error 344)";
		String max_error_text = maxAmountModalText.getText();
		Assert.assertEquals(max_error_text, expectedText);
		maxAmountModalBtn.click();
	}

	public String payAndVerify() throws AWTException, InterruptedException {
		sendMoneyBtn.click();
		String refId = referenceId.getText();
		System.out.println("Refrence Number: "+ refId);
		try {
			getScreenShot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		finishedBtn.click();
		return refId;
	}

	public void exstCusPaymentDetails(String biller, String billers,String amounttopay, String accctnumber, String selectbiller) throws InterruptedException {
		searchBiller.sendKeys(biller);
		nextBtn.click();
		findElementUsingText(billers).click();
		//driver.findElement(By.xpath("//div[2]/div/div/div")).click();
		//driver.findElement(By.xpath("//div[@id='prevBillersTable']/div/div/div/div[2]/div[2]/strong")).click();

		findElementUsingText(selectbiller).click();
		newCustomer.click();
		paymentAmountField.sendKeys(amounttopay);
		customerAcctNumberField.sendKeys(accctnumber);
		nextBtn.click();
	}

	public void verifyOverLimitWarning(String biller, String amounttopay, String accctnumber, String selectbiller) throws InterruptedException {
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cannot complete')]")));
		act.moveToElement(warning).perform();
		String threshold  = driver.findElement(By.xpath("//*[contains(text(),'Cannot complete')]")).getText();
		System.out.println(threshold);
		driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
	}

	public void newCusPaymentDetails(String biller, String amounttopay, String accctnumber, String selectbiller) throws InterruptedException {
		acctNumberField.sendKeys(accctnumber);
		nextBtn.click();
		findElementUsingText(selectbiller).click();
		newCustomer.click();
		paymentAmountField.sendKeys(amounttopay);
		customerAcctNumberField.sendKeys(accctnumber);
		nextBtn.click();
	}

	public void billerDetails(String biller, String billers, String amounttopay, String accctnumber, String selectbiller) throws InterruptedException {
		driver.findElement(By.id("STRKEY_BILLER_NAME_CODE_KEYWORD")).sendKeys(biller);
		nextBtn.click();
		findElementUsingText(billers).click();
		newCustomer.click();
		paymentAmountField.sendKeys(amounttopay);
		customerAcctNumberField.sendKeys(accctnumber);
		nextBtn.click();
	}

}