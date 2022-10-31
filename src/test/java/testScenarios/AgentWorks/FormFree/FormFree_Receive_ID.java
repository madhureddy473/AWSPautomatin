package test.java.testScenarios.AgentWorks.FormFree;

import main.java.api.xmlAPI.xmlAPITest;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;
import java.util.Map;

public class FormFree_Receive_ID extends TestBase {

    @Test
    public void FormFree_Receive_ID() throws Exception {

        final xmlAPITest xmlClass = new xmlAPITest();
        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;

        utilities.ExcelUtil write = new utilities.ExcelUtil();
        write.setExcelFile(utilities.Constants.File_Path+"/AWDATA.xlsx", "FormFree");

        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","FormFree", className);

        xmlClass.checkInRequest(teller);
        xmlClass.confirmTokenRequest(teller);
        Map<String, String> tranLookup = xmlClass.tranLookupRequest(teller);
        Map<String, String> receiveValidationMap = xmlClass.receiveValidationRequest(teller, tranLookup);
        xmlClass.receiveCompleteSessionRequest(teller, receiveValidationMap);

        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickReceiveCard();
        awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
        awsendPage.getNextBtn().click();
        awreceivePage.additionalInfoBirthCountry(teller.get("receiverBirthCountry"));
        awreceivePage.getNextBtn().click();
        awreceivePage.clickPayout();
        awhomePage.logout();

    }

}
