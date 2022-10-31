package test.java.testScenarios.AgentWorks.RetailAgent;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class ReceiveReversal_Increase_In_Payment_Due_To_MoneyGram_Credit_Limit_RetailAgent extends TestBase {
	@Test
	public void ReceiveReversal_Increase_In_Payment_Due_To_MoneyGram_Credit_Limit_RetailAgent() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","RetailAgent", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
//		homePage.isTransactEnabled();
		awtransactPage.clickEditCard();
		aweditPage.clickReversal(teller.get("referenceNum"));
		String amount = awsendPage.paymentAmount();
		float initialDueAmount = Float.parseFloat(amount);
		aweditPage.selectReason(teller.get("reasonToCancel"));
		awtransactPage.clickSendCard();
		String amount1 = awsendPage.paymentAmount();
		float sendDueAmount = Float.parseFloat(amount1);
		Assert.assertTrue(sendDueAmount>initialDueAmount);
		awhomePage.logout();
	}
}