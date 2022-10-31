package pages.AgentWorks;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.pages.BasePage.Page;

public class AgentWorksTransactPage extends Page {

	//OBJECTS

	@FindBy(name="devicename")
	WebElement deviceField;

	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement deviceBtn;

	@FindBy(xpath="(//button[@type='button' and contains(text(), ' Done')])")
	WebElement doneModalBtn;

	@FindBy(xpath="//div[@id='send']")
	WebElement sendCard;

	@FindBy(xpath="//div[@id='efee']")
	WebElement EFeeCard;

	@FindBy(xpath="//span[contains(text(),' Find your Customer ')]")
	WebElement findcust;

	@FindBy(xpath = "//*[@id='stagedCompletion']")
	WebElement stageCompletion;

	@FindBy(xpath="//div[@id='editTransfer']")
	WebElement editCard;

	@FindBy(id="receive")
	WebElement reciveCard;
	
	@FindBy(id="billPay")
	WebElement billPayCard;

	@FindBy(id="efee")
	WebElement estimateCard;

	@FindBy(xpath = "//span[text()='*** Training Mode ***']")
	WebElement trainingMode;

	@FindBy(xpath = "//Strong[text()='Transaction Dashboard']")
	WebElement trainingModeDashboard;

	@FindBy(xpath = "//span[contains(text(), 'tilities')]/ancestor::div[2]")
	WebElement utilities;

	//CONSTRUCTOR
	public AgentWorksTransactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);  //initialize the page objects declared above
	}

	//METHODS

	public void registerDevice(String text) {
		deviceField.sendKeys(text);
		deviceBtn.click();
		doneModalBtn.click();
	}

	public void clickSendCard() {
		Assert.assertTrue(isElementDisplayed(sendCard, timeToWait));
		sendCard.click();
	}
	public void clickEFeeCard() throws InterruptedException {
		Assert.assertTrue(isElementDisplayed(EFeeCard, timeToWait));
		EFeeCard.click();
		Thread.sleep(2000);
	}
	public void FindyourCustomer() throws InterruptedException {
		//Assert.assertTrue(isElementDisplayed(findcust, timeToWait));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findcust);
		Thread.sleep(5000);
		findcust.click();
	}



	public void clickReceiveCard() {
		Assert.assertTrue(isElementDisplayed(reciveCard, 20));
		reciveCard.click();
	}

	public void clickEditCard() {
		if(isElementDisplayed(editCard, 60)) {
			editCard.click();
		}
	}
	
	public void clickBillPayCard() {
		billPayCard.click();

	}

	public void clickStageCompletion() {
		Assert.assertTrue(isElementDisplayed(stageCompletion, timeToWait));
		stageCompletion.click();
	}

	public void validateTrainingMode(){
		Assert.assertTrue(isElementDisplayed(trainingMode, 60));
		Assert.assertTrue(isElementDisplayed(trainingModeDashboard, 10));
	}

    public void clickEstimateCard() {
		estimateCard.click();
    }
}
