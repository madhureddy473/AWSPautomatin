package test.java.testScenarios.AgentWorks.Estimate;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;

public class USEFNewCusNewRcvr10Min_NoID extends TestBase{
    @Test
    public void USEFNewCusNewRcvr10Min_NoID() throws Exception {
        utilities.DataDriven excelFile = new utilities.DataDriven();
        utilities.ExcelUtil write = new utilities.ExcelUtil();
        write.setExcelFile(utilities.Constants.File_Path + "/AWDATA.xlsx", "Estimate");
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath, "AWDATA.xlsx", "Estimate", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickEstimateCard();
        awestimatePage.enterAmountCountryAndState(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awestimatePage.selectNewCustomer();
        awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
        awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
        awsendPage.enterIDOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
        awsendPage.getNextBtn().click();
        awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusMemNum"));
        awsendPage.enterIdOneState(teller.get("idIssueState"));
        awsendPage.getNextBtn().click();
        awsendPage.fraudWarningPopup();
        awsendPage.completeSend();
        awhomePage.logout();

    }
}
