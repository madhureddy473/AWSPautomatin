package test.java.testScenarios.AgentWorks.Estimate;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class USEFSend_Higher_Than_AgentLimit extends TestBase{
	@Test
	public void USEFSend_Higher_Than_AgentLimit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Estimate", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickEstimateCard();
		awestimatePage.enterAmountCountryAndState(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.validateThresholdLimitPopup();
		awhomePage.logout();
	}
}
