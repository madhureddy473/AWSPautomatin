package test.java.testScenarios.AgentWorks.Estimate;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class USEFExisCusExisRcvr10Min_ID extends TestBase{
    @Test
    public void USEFExisCusExisRcvr10Min_ID() throws Exception {
        DataDriven excelFile = new DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = Constants.File_Path;

        utilities.ExcelUtil write = new utilities.ExcelUtil();
        write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Estimate");

        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Estimate", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));

        String recFirstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        String recLastName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        String firstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        String lastName = RandomStringUtils.randomAlphabetic(6).toLowerCase();

        write.setCellData(recFirstName, className, "rcvFirstName");
        write.setCellData(recLastName, className, "rcvLastName");
        write.setCellData(firstName, className, "senFirstName");
        write.setCellData(lastName, className, "senLastName");

        awtransactPage.clickEstimateCard();
        awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.newCustomer();
        awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"), teller.get("rcvLastName"), teller.get("recCity"), teller.get("recPhone"), teller.get("direction"));
        awsendPage.thirdPartyInfoForHighAmount();
        awsendPage.fillNewSenderInformation(firstName,lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
        awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
        awsendPage.getNextBtn().click();
        awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
        awsendPage.getNextBtn().click();
        awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
        awsendPage.fraudWarningPopup();
        awsendPage.completeSend();

        awtransactPage.clickEstimateCard();
        awestimatePage.enterAmountCountryAndState(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.validateAmountToBeSent(teller.get("amount"), "excludingFee");
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.searchUsingLastNameAndPhoneNumber(lastName, teller.get("phoneNumber"), firstName+" "+lastName);
        awsendPage.sendToExistingReceiver(teller.get("receiveType"), teller.get("DestCountry"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.thirdPartyInfoForHighAmount();
        awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
        awsendPage.getNextBtn().click();
        awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
        awsendPage.getNextBtn().click();
        awsendPage.clickOnSendNext();
        awsendPage.fraudWarningPopup();
        awsendPage.completeSend();
        awhomePage.logout();

    }
}
