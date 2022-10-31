package test.java.testScenarios.AgentWorks.Error4058;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class EstExistCustomer_Scan_Disabled_Belgium_ID1 extends TestBase{
    @Test
    public void EstExistCustomer_Scan_Disabled_Belgium_ID1() throws Exception {

        DataDriven excelFile = new DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = Constants.File_Path;

        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","4058Error", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));

        String firstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        String lastName = RandomStringUtils.randomAlphabetic(6).toLowerCase();

        awtransactPage.clickEstimateCard();
        awestimatePage.enterAmountCountryAndState(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.getManualSearch().click();
        awestimatePage.selectNewCustomer();
        awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
        awsendPage.fillNewSenderInformation(firstName,lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
        awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
        awsendPage.enterIdOneCity(teller.get("idIssueCity"));
        awsendPage.enterIssueDate(teller.get("issueYear"), teller.get("issueMonth"), teller.get("issueDay"));
        awsendPage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
        awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
        awsendPage.additionalPageInfo(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("nationalityCountry"), teller.get("additionalInfoGender"), teller.get("additionalInfoPermanentResidency"), teller.get("proofOfFunds"));
        awsendPage.completeSend();

        awtransactPage.clickEstimateCard();
        awestimatePage.enterAmountCountryAndState(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.getManualSearch().click();
        awsendPage.searchUsingLastNameAndPhoneNumber(lastName, teller.get("phoneNumber"), firstName+" "+lastName);
        awsendPage.newReceiver();
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
        awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
        awsendPage.getNextBtn().click();
        awsendPage.senderIdentification();
        awsendPage.clickOnSendNext();
        awsendPage.additionalPageInfo(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("nationalityCountry"), teller.get("additionalInfoGender"), teller.get("additionalInfoPermanentResidency"), teller.get("proofOfFunds"));
        awsendPage.completeSend();
        awhomePage.logout();

    }
}