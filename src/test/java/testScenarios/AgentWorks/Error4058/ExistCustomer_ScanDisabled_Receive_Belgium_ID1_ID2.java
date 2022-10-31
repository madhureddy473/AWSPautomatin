package test.java.testScenarios.AgentWorks.Error4058;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;

public class ExistCustomer_ScanDisabled_Receive_Belgium_ID1_ID2 extends TestBase {

    @Test
    public void ExistCustomer_ScanDisabled_Receive_Belgium_ID1_ID2() throws Exception {

        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","4058Error", className);

        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickReceiveCard();
        awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
        awsendPage.getManualSearch().click();
        awreceivePage.getNextBtn().click();
        awreceivePage.receiverInfo(teller.get("senBirthCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"), teller.get("receiverBirthCity"));
        awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
        awreceivePage.enterReceiverIdentificationOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
        awreceivePage.receiverIdOneCity(teller.get("idIssueCity"));
        awsendPage.enterIssueDate(teller.get("issueYear"), teller.get("issueMonth"), teller.get("issueDay"));
        awreceivePage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
        awreceivePage.enterReceiverIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
        awreceivePage.additionalReceiverPageInfo(teller.get("receiverPurposeOfTransaction"), teller.get("receiverGender"), teller.get("receiverNationality"), teller.get("receiverAdditionalInfoPermanentResidency"), teller.get("citizenshipCountry"));
        awreceivePage.clickPayout();
        awhomePage.logout();
    }
}
