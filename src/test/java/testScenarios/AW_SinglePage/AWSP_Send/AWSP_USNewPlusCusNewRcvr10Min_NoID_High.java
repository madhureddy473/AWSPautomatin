package testScenarios.AW_SinglePage.AWSP_Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_USNewPlusCusNewRcvr10Min_NoID_High extends TestBase {

    @Test
    public void AWSP_USNewPlusCusNewRcvr10Min_NoID_High() throws Exception {
        DataDriven excelFile = new DataDriven();
        ExcelUtil write = new ExcelUtil();
        write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");
        String className = this.getClass().getSimpleName();
        String filePath = Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickSendCard();
        awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
        //awsinglePage.destinationAndAmount_Ext(teller.get("destAmt"),teller.get("destCountry"));
        awsinglePage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));
        //awsinglePage.destinationAndAmountusingplusnumber(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsinglePage.destinationAndAmountusingplusnumberhigh(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));

        //awsinglePage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
        awsinglePage.serviceOption(teller.get("serviceOption"));
        //awsinglePage.selectexistingIDone(teller.get("idTypeonFile"), teller.get("idNumberonFile"), teller.get("idType"), teller.get("idNumber"));

        awsinglePage.identificationhigh(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expYear"),teller.get("expMon"),teller.get("expDay"),teller.get("secIdType"),teller.get("secIdNumber"));
        //awsinglePage.selectIDtwo(teller.get("secIdType"),teller.get("secIdNumber"));
        awsinglePage.additionalInformationnewhigh(teller.get("additionalInfoBirthCountry"),teller.get("senOccupation"),teller.get("ThirdpartyType"));
        awsinglePage.receiverInformationlow(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
        //awsinglePage.receiverInformation(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));

        awsinglePage.validations(teller,teller.get("existingCustomer"));
    }
}
