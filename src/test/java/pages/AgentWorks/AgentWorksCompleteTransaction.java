package test.java.pages.AgentWorks;

import org.json.XML;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.pages.BasePage.Page;

public class AgentWorksCompleteTransaction extends Page {

    String selectTransactionXpath = "//strong[contains(text(), '%s')]";

    @FindBy(xpath = "//strong[contains(text(), 'Pay For a Transaction')]")
    WebElement payForTransactionHeader;

    public AgentWorksCompleteTransaction(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectATransaction(String fullName){
        Assert.assertTrue(isElementDisplayed(payForTransactionHeader, timeToWait));
        String destCountry = String.format(selectTransactionXpath, fullName);
        driver.findElement(By.xpath(destCountry)).click();
        
    }

}
