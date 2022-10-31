package test.java.testScenarios.AgentWorks.AmendCancel;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class RecRev_ID extends TestBase {
	@Test
	public void RecRev_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","AmendCancel", className);
		HashMap<String, String> teller1 = excelFile.readExcel(filePath,"AWDATA.xlsx","Receive", "USNewCusREC_ID");
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickEditCard();
		aweditPage.editTransferReversal(teller1.get("referenceNum"),teller.get("reasonToCancel"));
		awhomePage.logout();
	}
}