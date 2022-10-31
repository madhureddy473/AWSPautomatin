package testScenarios.AW_SinglePage.AWSP_Loyalty;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_USA_LoyaltyEnrollment extends TestBase {

    @Test
    public void AWSP_USA_LoyaltyEnrollment() throws Exception {
        DataDriven excelFile = new DataDriven();
        ExcelUtil write = new ExcelUtil();
        write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");
        String className = this.getClass().getSimpleName();
        String filePath = Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickSendCard();
        awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
        awsinglePage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));

        // awsinglePage.searchForExistingCustomer(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
        awsinglePage.destinationAndAmountexistplusnumHigh(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsinglePage.serviceOption(teller.get("serviceOption"));

        //awsinglePage.identificationforDE(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expirationYear"),teller.get("expirationMonth"),teller.get("expirationDate"),teller.get("secIdType"),teller.get("secIdNumber"));
        awsinglePage.identification(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expYear"),teller.get("expMon"),teller.get("expDay"),teller.get("secIdType"),teller.get("secIdNumber"));

        //awsinglePage.selectexistingIDone(teller.get("idChoice"), teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
        // awsinglePage.selectexistingIDtwo(teller.get("idChoice"), teller.get("secIdType"), teller.get("secIdNumber"));
        awsinglePage.additionalInformationfolowamontsusa(teller.get("additionalInfoBirthCountry"), teller.get("citizenshipCountry"), teller.get("sourceOfFunds"), teller.get("purposeOfTransaction"));

        //awsinglePage.receiverInformationforexistingHigh(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));

        awsinglePage.receiverInformationlow(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
       // awsinglePage.captureplusnumberr();
        awsinglePage.validationsforloyalty(teller,teller.get("existingCustomer"));
        //awsinglePage.verify20percentdiscountUSA();
    }
}



