package test.java.testScenarios.AgentWorks.Send;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class Send_Transaction_Singlepage extends TestBase {

    @Test
    public void Send_Transaction_Singlepage() throws Exception {
        DataDriven excelFile = new DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath, "AWDATA_Singlepage.xlsx", "Send", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickSendCard();
        awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("lastname"),teller.get("primaryphonenumber"));
        awsinglePage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));
        awsinglePage.destinationAndAmount(teller.get("amount"),teller.get("destCountry"),teller.get("DestState"));
        awsinglePage.serviceOption(teller.get("serviceOption"));
        awsinglePage.identification(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expYear"),teller.get("expMon"),teller.get("expDay"),teller.get("secIdType"),teller.get("secIdNumber"));
        awsinglePage.additionalInformation(teller.get("additionalInfoBirthCountry"),teller.get("senOccupation"),teller.get("ThirdpartyType"));
        awsinglePage.receiverInformation(teller.get("recFirstName"),teller.get("recLastName"),teller.get("issueState"));
        awsinglePage.validations(teller,teller.get("existingCustomer"));

    }
}
