package testScenarios.AW_SinglePage.AWSP_Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_Send_Account_Deposit_Bangladesh extends TestBase {

    @Test
    public void AWSP_Send_Account_Deposit_Bangladesh() throws Exception {
        DataDriven excelFile = new DataDriven();
        ExcelUtil write = new ExcelUtil();
        write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");
        String className = this.getClass().getSimpleName();
        String filePath = Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickSendCard();
        awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("lastname"),teller.get("primaryphonenumber"));
        awsinglePage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));
        awsinglePage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));

        //awsinglePage.serviceOptionAccountDeposit(teller.get("serviceOption"));
        awsinglePage.serviceOptionAccountDeposittoBangldesh(teller.get("serviceOption"));

        awsinglePage.identification(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expYear"),teller.get("expMon"),teller.get("expDay"),teller.get("secIdType"),teller.get("secIdNumber"));

        //awsinglePage.selectexistingIDone(teller.get("idChoice"), teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
        //awsinglePage.additionalInformationforexistinghigh(teller.get("senOccupation"),teller.get("ThirdpartyType"));
        awsinglePage.additionalInformationfolowamonts(teller.get("additionalInfoBirthCountry"));

        awsinglePage.receiverInformationforAD(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
       // awsinglePage.EnterbankdetailsforBangladesh(teller.get("countryCode"),teller.get("recPhone"),teller.get("accountNum"),teller.get("BankroutingNum"));

       // awsinglePage.submitTransaction();

     //awsinglePage.validations(teller,teller.get("existingCustomer"));

    }
}
