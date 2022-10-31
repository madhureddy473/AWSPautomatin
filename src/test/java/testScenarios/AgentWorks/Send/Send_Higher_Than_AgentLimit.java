package test.java.testScenarios.AgentWorks.Send;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class Send_Higher_Than_AgentLimit extends TestBase{
	@Test
	public void Send_Higher_Than_AgentLimit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
//		awsendPage.sendTransactionVerifyOverLimit(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.validateThresholdLimitPopup();
		awhomePage.logout();
	}
}
