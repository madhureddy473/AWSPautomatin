package test.java.testScenarios.AgentWorks.AmendCancel;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Refund_Higher_Than_AgentLimit extends TestBase {
	@Test
	public void Refund_Higher_Than_AgentLimit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","AmendCancel", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickEditCard();
		aweditPage.enterReferenceNumber(teller.get("referenceNum"));
		aweditPage.getReversalBtn().click();
		aweditPage.validateAlertMessage();
		awhomePage.logout();

//		aweditPage.editCancelHigherThanAgentLimit(teller.get("referenceNum"),teller.get("reasonToCancel"));
//		awhomePage.logout();
	}
}