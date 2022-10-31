package test.java.testScenarios.AgentWorks.FormFree;

import main.java.api.xmlAPI.xmlAPITest;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;
import java.util.Map;

public class FormFree_Send_NoID extends TestBase {

    @Test
    public void FormFree_Send_NoID() throws Exception {

        final xmlAPITest xmlClass = new xmlAPITest();
        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;

        utilities.ExcelUtil write = new utilities.ExcelUtil();
        write.setExcelFile(utilities.Constants.File_Path+"/AWDATA.xlsx", "FormFree");

        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","FormFree", className);

        xmlClass.checkInRequest(teller);
        xmlClass.confirmTokenRequest(teller);
        Map<String, String> feeLookupMap = xmlClass.feeLookupRequest(teller);
        Map<String, String> sendValidationMap = xmlClass.sendValidationRequest(teller, feeLookupMap);
        xmlClass.completeSessionRequest(teller, feeLookupMap);

        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickStageCompletion();
        awCompleteTransaction.selectATransaction(sendValidationMap.get("firstName")+" "+sendValidationMap.get("lastName"));
        awsendPage.getNextBtn().click();
        awsendPage.fraudWarningPopup();
        String refNum = awsendPage.completeSendWithReturnValue();
        write.setCellData(sendValidationMap.get("date"), "FormFree_Receive_NoID", "senBirthDay");
        write.setCellData(refNum, "FormFree_Receive_NoID", "referenceNum");
        awhomePage.logout();
    }

}
