package testScenarios.AW_SinglePage.AWSP_Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_Italy_newsend extends TestBase {

    @Test
    public void AWSP_Italy_newsend() throws Exception {
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

        awsinglePage.identificationforDE(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expirationYear"),teller.get("expirationMonth"),teller.get("expirationDate"),teller.get("secIdType"),teller.get("secIdNumber"));

        //awsinglePage.selectexistingIDone(teller.get("idChoice"), teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
       // awsinglePage.selectexistingIDtwo(teller.get("idChoice"), teller.get("secIdType"), teller.get("secIdNumber"));
        awsinglePage.additionalInformationfolowamontsDE(teller.get("additionalInfoBirthCountry"), teller.get("citizenshipCountry"), teller.get("sourceOfFunds"), teller.get("purposeOfTransaction"));

        //awsinglePage.receiverInformationforexistingHigh(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));

        awsinglePage.receiverInformation(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
        awsinglePage.captureplusnumberr();
        awsinglePage.validations(teller,teller.get("existingCustomer"));
        awsinglePage.verify20percentdiscount();


    }
}



