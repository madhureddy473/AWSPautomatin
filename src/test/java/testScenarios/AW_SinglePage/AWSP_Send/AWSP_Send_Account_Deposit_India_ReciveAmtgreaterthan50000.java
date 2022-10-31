package testScenarios.AW_SinglePage.AWSP_Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_Send_Account_Deposit_India_ReciveAmtgreaterthan50000 extends TestBase {

    @Test
    public void AWSP_Send_Account_Deposit_India_ReciveAmtgreaterthan50000() throws Exception {
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
        //awsinglePage.destinationAndAmountgreaterthan50000(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));

    }
}
