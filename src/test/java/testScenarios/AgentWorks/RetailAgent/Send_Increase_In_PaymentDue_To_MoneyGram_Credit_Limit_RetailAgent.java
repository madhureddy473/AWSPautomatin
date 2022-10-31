package test.java.testScenarios.AgentWorks.RetailAgent;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;

public class Send_Increase_In_PaymentDue_To_MoneyGram_Credit_Limit_RetailAgent extends TestBase {
    @Test
    public void Send_Increase_In_PaymentDue_To_MoneyGram_Credit_Limit_RetailAgent() throws Exception {
        utilities.DataDriven excelFile = new utilities.DataDriven();
        utilities.ExcelUtil write = new utilities.ExcelUtil();
        write.setExcelFile(utilities.Constants.File_Path+"/AWDATA.xlsx", "RetailAgent");
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","RetailAgent", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
//        homePage.isTransactEnabled();
        homePage.clickTransact();
        awtransactPage.clickSendCard();
        String amount = awsendPage.paymentAmount();
        float initialDueAmount = Float.parseFloat(amount);
        awsendPage.newCustomer();
        awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
        awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
        awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
        awsendPage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
        awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
        awsendPage.additionalPageInformation(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("additionalInfoBirthCountry"));
        String refNum = awsendPage.completeSendWithReturnValue();
        write.setCellData(refNum, "SendReversal_Refund_Decrease_In_Payment_Due_To_MoneyGram_Credit_Limit_RetailAgent", "referenceNum");
        homePage.getTransactTabAfterSend().click();
        awtransactPage.clickSendCard();
        String amount1 = awsendPage.paymentAmount();
        float sendDueAmount = Float.parseFloat(amount1);
        Assert.assertTrue(sendDueAmount>initialDueAmount);
        awsendPage.newCustomer();
        awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
        awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
        awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
        awsendPage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
        awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
        awsendPage.additionalPageInformation(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("additionalInfoBirthCountry"));
        String refNum1 = awsendPage.completeSendWithReturnValue();
        write.setCellData(refNum1, "Receive_Decrease_In_Payment_Due_To_MoneyGram_Credit_Limit_RetailAgent", "referenceNum");
        write.setCellData(refNum1, "ReceiveReversal_Increase_In_Payment_Due_To_MoneyGram_Credit_Limit_RetailAgent", "referenceNum");
        awhomePage.logout();


    }
}