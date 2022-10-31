package test.java.testScenarios.AgentWorks.Estimate;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;

public class EFUSToIndia_AD_NewCustomer_NewReceiver_NoID extends TestBase {

    @Test
    public void EFUSToIndia_AD_NewCustomer_NewReceiver_NoID() throws Exception {
        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Estimate", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickEstimateCard();
        awsendPage.getIncludingFee().click();
        awestimatePage.enterAmountCountryAndState(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsendPage.validateAmountToBeSent(teller.get("amount"), "includingFee");
        awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
        awsendPage.newCustomer();
        awsendPage.fillReceiverInfoAccountDeposit(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("receiverAddress"),teller.get("recPhone"), teller.get("countryCode"), teller.get("senOccupation"));
        awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
        awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
        awsendPage.enterAccountDetails(teller.get("IFSCCode"), 12, teller.get("purposeOfFunds"));
        awsendPage.fraudWarningPopup();
        awsendPage.completeSend();


    }
}
