package test.java.testScenarios.AgentWorks;

import main.java.api.xmlAPI.xmlAPITest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;
import java.util.Map;

public class DummyClassFile extends TestBase {

    @Test
    public void DummyClassFile() throws Exception {

        final xmlAPITest xmlClass = new xmlAPITest();
        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;

        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","FormFree", className);

        xmlClass.checkInRequest(teller);
        xmlClass.confirmTokenRequest(teller);
        Map<String, String> feeLookupMap = xmlClass.feeLookupRequest(teller);
        Map<String, String> sendValidationMap = xmlClass.sendValidationRequest(teller, feeLookupMap);
        xmlClass.completeSessionRequest(teller, feeLookupMap);

        awloginPage.login("tusaa012", "Tester1#");
        awtransactPage.clickStageCompletion();
        awCompleteTransaction.selectATransaction(sendValidationMap.get("firstName")+" "+sendValidationMap.get("lastName"));
        awsendPage.getNextBtn().click();
        awsendPage.fraudWarningPopup();
        awsendPage.completeSend();
        awhomePage.logout();
    }

}
