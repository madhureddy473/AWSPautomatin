package test.java.pages.AgentWorks;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.pages.BasePage.Page;


public class AgentWorksUtilitiesPage extends Page {

    public AgentWorksUtilitiesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'tilities')]/ancestor::div[2]")
    WebElement utilities;

    @FindBy(xpath = "//*[@id='selectPeripheral']")
    WebElement peripheral;

    @FindBy(xpath = "//*[@id='image-scan']")
    WebElement imageScan;

    @FindBy(xpath = "//span[contains(text(), 'Edit')]")
    WebElement scanEdit;

    @FindBy(xpath = "//span[contains(text(), 'Finish')]")
    WebElement scanFinish;

    public void selectUtility(){
        Assert.assertTrue(isElementDisplayed(utilities, timeToWait));
        utilities.click();
    }

    public void selectPeripheral(){
        Assert.assertTrue(isElementDisplayed(peripheral, timeToWait));
        peripheral.click();
    }

    public void selectImageScan(){
        Assert.assertTrue(isElementDisplayed(imageScan, timeToWait));
        imageScan.click();
    }

    public void editScan() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(isElementDisplayed(scanEdit, timeToWait));
        scanEdit.click();
    }

    public void finishScan(){
        Assert.assertTrue(isElementDisplayed(scanFinish, timeToWait));
        scanFinish.click();
    }


}
