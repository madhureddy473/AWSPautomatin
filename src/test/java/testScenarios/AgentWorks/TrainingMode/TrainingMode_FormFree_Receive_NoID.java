package test.java.testScenarios.AgentWorks.TrainingMode;

import main.java.api.xmlAPI.xmlAPITest;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;
import java.util.Map;

public class TrainingMode_FormFree_Receive_NoID extends TestBase {

    @Test
    public void TrainingMode_FormFree_Receive_NoID() throws Exception {

        final xmlAPITest xmlClass = new xmlAPITest();
        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;


        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","TrainingMode", className);

        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awtransactPage.clickReceiveCard();
        awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
        awsendPage.getNextBtn().click();
        awreceivePage.clickPayout();
        awhomePage.logout();
    }

}
