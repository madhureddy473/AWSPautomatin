package test.java.pages.AgentWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.pages.BasePage.Page;

public class AgentWorksEstimatePage extends Page {
    //OBJECTS

    @FindBy(xpath="//input[@type='tel']")
    WebElement sendMoneyField;

    @FindBy(xpath="//app-typeahead[@id='STRKEY_DEST_COUNTRY']/input[@type='text']")
    WebElement destCountryField;

    String countryXpath = "//span[text()='%s']";

    @FindBy(xpath="//app-typeahead[@id='destination_Country_SubdivisionCode']/input[@type='text']")
    WebElement state;

    @FindBy(xpath="//button[@type='button']/span[contains(text(),'Next')]")
    WebElement nextBtn;

    @FindBy(xpath="//div[@id='ActionBarMainNextNewCustomer']")
    WebElement newCustomer;

    //****************************** Unused Objects *********************************

    @FindBy(xpath="//*[contains(text(),' 10 Minute Service ')]")
    WebElement first10MinOption;

    @FindBy(xpath="//app-efee-screen-delivery-options[2]/app-content-body/div/app-layout/div/div/div/div/div/div[2]/div/div[2]/div/app-delivery-option/app-card/div/h5")
    WebElement second10MinOption;

    @FindBy(xpath="//app-efee-screen-delivery-options[2]/app-content-body/div/app-layout/div/div/div/div/div/div[2]/div/div[2]/div/app-delivery-option/app-card/div/h5")
    WebElement second10MinOptionHigh;

    @FindBy(id="mgiRewardsNumber")
    WebElement plusRewardsNumber;

    @FindBy(xpath="(//card-title[contains(text(),' 10 Minute Service ')])")
    WebElement tenMinuteBtn2;

    @FindBy(xpath="(//span[contains(text(), ' None ')])")
    WebElement noneRadioBtn;

    @FindBy(xpath="(//div[contains(text(), ' Name and Phone ')])")
    WebElement nameAndPhoneTab;

    @FindBy(id="consumer_LastName")
    WebElement consumerLastNameField;

    @FindBy(id="consumer_PrimaryPhone")
    WebElement consumerPhoneField;

    @FindBy(xpath="(//span[contains(text(), 'Search')])[1]")
    WebElement searchBtn;

    @FindBy(xpath="(//span[contains(text(), ' New receiver ')])[1]")
    WebElement newRecvrBtn;

    @FindBy(id="ok")
    WebElement sendMoneyBtn;

    @FindBy(id="ok")
    WebElement finishedBtn;

    @FindBy(xpath="//strong[@id='STRKEY_REF_NUM']")
    WebElement referenceId;

    //CONSTRUCTOR
    public AgentWorksEstimatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Methods

    /**
     * Method to enter country and state
     * @param amount
     * @param destCountry
     * @param DestState
     */
    public void enterAmountCountryAndState(String amount, String destCountry, String DestState) throws InterruptedException {
        sendMoneyField.sendKeys(amount);
        destCountryField.clear();

        destCountryField.clear();
        destCountryField.sendKeys(destCountry);
        Thread.sleep(1000);
        String destinationCountry = String.format(countryXpath, destCountry);
        driver.findElement(By.xpath(destinationCountry)).click();

        if(!DestState.equalsIgnoreCase("NA")) {
            state.clear();
            textSuggestAndEnter(state, DestState);
        }
        nextBtn.click();
    }

    /**
     * Method to select new customer
     */
    public void selectNewCustomer() {
        if(isElementDisplayed(newCustomer, 10)){
        newCustomer.click();}
    }

    //****************************************** Unused methods ****************************************

    public void selectSecond10MinOption() {
        second10MinOption.click();
    }

    public void selectServiceOption10Min() {
        first10MinOption.click();
    }

    public void sendUsingUSExtCust(String string, String string2, String fullname) throws InterruptedException {
        nameAndPhoneTab.click();
        consumerLastNameField.sendKeys(string);
        consumerPhoneField.sendKeys(string2);
        searchBtn.click();
        findElementUsingText(fullname).click();
        nextBtn.click();
        newRecvrBtn.click();
        selectSecond10MinOption();
    }

    public void sendUsingUSExtCustExtRec(String string, String string2, String senfullname, String recfullname) {
        nameAndPhoneTab.click();
        consumerLastNameField.sendKeys(string);
        consumerPhoneField.sendKeys(string2);
        searchBtn.click();
        findElementUsingText(senfullname).click();
        nextBtn.click();
        findElementUsingText(recfullname).click();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void justDialogToCompleteLow(){
        sendMoneyBtn.click();
        String refId = referenceId.getText();
        System.out.println("Refrence Number: "+ refId);
        try {
            getScreenShot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finishedBtn.click();
    }

    public void sendUsingPlusCust(String string, String fullname) {
        plusRewardsNumber.sendKeys(string);
        searchBtn.click();
        findElementUsingText(fullname).click();
        clickNextBtn();
        newRecvrBtn.click();
    }

    public void thirdPartyInfoForHighAmount()
    {
        noneRadioBtn.click();
        nextBtn.click();
    }

    public void sendUsingUSExtCust(String string, String string2) {
        nameAndPhoneTab.click();
        consumerLastNameField.sendKeys(string);
        consumerPhoneField.sendKeys(string2);
        searchBtn.click();
    }

    public void sendToExisReceiverHigh(String exsRec) {
        findElementUsingText(exsRec).click();
        second10MinOption.click();
        thirdPartyInfoForHighAmount();
        nextBtn.click();
    }

    public void selectExsSender(String fullname) {
        findElementUsingText(fullname).click();
        nextBtn.click();
    }

    public void sendUsingPlusCustAndExstCus(String string, String fullname) {
        plusRewardsNumber.sendKeys(string);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchBtn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementUsingText(fullname).click();
        nextBtn.click();
    }
}