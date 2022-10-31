package test.java.testScenarios.AgentWorks.TrainingMode;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class TrainingMode_Amend_a_Transaction_NoID extends TestBase {
	@Test
	public void TrainingMode_Amend_a_Transaction_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","TrainingMode", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.validateTrainingMode();
		awtransactPage.clickEditCard();
		aweditPage.enterReferenceNumber(teller.get("referenceNum"));
		aweditPage.amend();
		awhomePage.logout();
	}
}