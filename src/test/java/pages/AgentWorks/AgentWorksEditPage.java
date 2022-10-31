package pages.AgentWorks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.pages.BasePage.Page;

public class AgentWorksEditPage extends Page{

	//OBJECTS	
	@FindBy(xpath="//input[@type='tel']")
	WebElement referenceField; 
	
	@FindBy(xpath="//button[@id='edittransfernext']")
	WebElement nextBtn;

	public WebElement getRefundBtn() {
		return refundBtn;
	}

	@FindBy(xpath="//span[contains(text(),' Refund ')]")
	WebElement refundBtn;
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	WebElement amendBtn;
	
	@FindBy(xpath="//select[@id='receive_ReversalReason']")
	WebElement refundTransactionReason;
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement nextNextBtn;

	public WebElement getAmendNextBtn() {
		return amendNextBtn;
	}

	@FindBy(xpath = "//span[contains(text(),' Amend ')]")
	WebElement amendNextBtn;
	
	@FindBy(xpath="(//button[contains(text(),' Yes, continue ')])")
	WebElement yesBtn;
	
	@FindBy(id="ok")
	WebElement amendFinishedBtn;

	public WebElement getCancelFinishedBtn() {	return cancelFinishedBtn; 	}

	@FindBy(xpath="(//button[contains(text(), ' Finished ')])")
	WebElement cancelFinishedBtn;
	
	@FindBy(id="receiver_MiddleName")
	WebElement middleName;

	public WebElement getReversalBtn() { 	return reversalBtn;  }

	public WebElement getReferenceField() {		return referenceField;	}

	@FindBy(xpath="//span[contains(text(),' Reversal ')]")
	WebElement reversalBtn;

	@FindBy(xpath="(//span[contains(text(),' Next ')])[2]")
	WebElement reversalNextBtn;

	@FindBy(xpath = "//button[contains(text(), 'Yes, continue ')]")
	WebElement confirmationYes;

	@FindBy(xpath = "//*[@id='ActionBarMainNextAmendTranDetails']/button")
	WebElement nextButtonAmend;

	@FindBy(xpath = "//*[@id='ActionBarMainNextRefundTranDetails']/button")
	WebElement nextButtonRefund;

	@FindBy(xpath = "//*[@id='ActionBarMainEditTransferTranDetailsRefund']/button")
	WebElement refundButton;

	@FindBy(xpath = "//*[@id='send_ReversalReason']")
	WebElement reversalButton;

	@FindBy(xpath = "//button[contains(text(), 'Finished')]")
	WebElement finishButton;

	@FindBy(xpath = "//span[contains(text(), 'Yes, refund amount is')]")
	WebElement refundAmountRadioButton;

	String refundReasonXpath = "//*[@id='send_ReversalReason']/option[contains(text(), '%s')]";
	
	//CONST
	public AgentWorksEditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}

	//*********************************** Edit a Transfer **************************

	/**
	 * Method to search using reference number
	 * @param referenceNumber Data sheet reference number
	 */
	public void enterReferenceNumber(String referenceNumber){
		Assert.assertTrue(isElementDisplayed(referenceField, 60));
		referenceField.sendKeys(referenceNumber);
		nextBtn.click();
	}

	//************************************ Transaction Details **************************

	/**
	 * Method to amend the transaction
	 */
	public void amend(){
		Assert.assertTrue(isElementDisplayed(amendNextBtn, timeToWait));
		amendNextBtn.click();
		Assert.assertTrue(isElementDisplayed(middleName, timeToWait));
		middleName.click();
		middleName.clear();
		middleName.sendKeys(getRandomString(6));
		Assert.assertTrue(isElementDisplayed(nextButtonAmend, timeToWait));
		nextButtonAmend.click();
		Assert.assertTrue(isElementDisplayed(confirmationYes, timeToWait));
		confirmationYes.click();
		if(isElementDisplayed(amendFinishedBtn, 30)) {
			amendFinishedBtn.click();
		}
	}

	/**
	 * Method to select refund and reason
	 * @param reason Data sheet reason
	 */
	public void refund(String reason){
		Assert.assertTrue(isElementDisplayed(refundButton, 60));
		refundButton.click();
		Assert.assertTrue(isElementDisplayed(reversalButton, 60));
		reversalButton.click();
		String refundReason = String.format(refundReasonXpath, reason);
		driver.findElement(By.xpath(refundReason)).click();
		if(isElementDisplayed(refundAmountRadioButton, 2)){
			refundAmountRadioButton.click();
		}
	}

	public void reversal(){
		Assert.assertTrue(isElementDisplayed(reversalBtn, timeToWait));
		reversalBtn.click();
	}

	/**
	 * Method to complete refund
	 */
	public void completedRefund(){
		nextButtonRefund.click();
		confirmationYes.click();
		if(isElementDisplayed(finishButton, 20)){
			finishButton.click();
		}
	}

	/**
	 * Method to edit transfer and cancel
	 * @param ref_num
	 * @param reason
	 * @throws Exception
	 */
	public void editTransferCancel(String ref_num, String reason) throws Exception {
		referenceField.sendKeys(ref_num);
		nextBtn.click();
		moveToElementDoubleClick(refundBtn);
		selectDdlByText(refundTransactionReason, reason);
		nextNextBtn.click();
		yesBtn.click();
		cancelFinishedBtn.click();
		getScreenShot();
	}

	/**
	 * Method to do receive reversal
	 * @param ref_num
	 * @param reason
	 * @throws Exception
	 */
	public void editTransferReversal(String ref_num, String reason) throws Exception {
		referenceField.sendKeys(ref_num);
		nextBtn.click();
		reversalBtn.click();
		selectDdlByText(refundTransactionReason, reason);
		reversalNextBtn.click();
		yesBtn.click();
		cancelFinishedBtn.click();
		getScreenShot();
	}

	public void clickReversal(String refNum){
		referenceField.sendKeys(refNum);
		nextBtn.click();
		reversalBtn.click();
	}

	public void selectReason(String reason){
		selectDdlByText(refundTransactionReason, reason);
		reversalNextBtn.click();
		yesBtn.click();
		cancelFinishedBtn.click();
	}

	/**
	 * Method to enter reversal reason and cancel
	 * @param reason
	 */
	public void reversalReasonAndClickOnCancel(String reason){
		selectDdlByText(refundTransactionReason, reason);
		reversalNextBtn.click();
		yesBtn.click();
	}

	public void clickCancelFinishButton(){
		Assert.assertTrue(isElementDisplayed(cancelFinishedBtn, timeToWait));
		cancelFinishedBtn.click();
	}

	/**
	 * Method to validate alert message
	 */
	public void validateAlertMessage(){
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cannot complete')]")));
		act.moveToElement(warning).perform();
		String threshold  = driver.findElement(By.xpath("//*[contains(text(),'Cannot complete')]")).getText();
		System.out.println(threshold);
		driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
	}

}
