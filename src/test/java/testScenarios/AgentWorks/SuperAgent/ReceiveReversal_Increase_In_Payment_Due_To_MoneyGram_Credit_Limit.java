package test.java.testScenarios.AgentWorks.SuperAgent;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class ReceiveReversal_Increase_In_Payment_Due_To_MoneyGram_Credit_Limit extends TestBase {
	@Test
	public void ReceiveReversal_Increase_In_Payment_Due_To_MoneyGram_Credit_Limit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","SuperAgent", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		homePage.clickTransact();
		awtransactPage.clickEditCard();
		aweditPage.enterReferenceNumber(teller.get("referenceNum"));
		aweditPage.reversal();
		String amount = awsendPage.paymentAmount();
		float initialDueAmount = Float.parseFloat(amount);
		aweditPage.reversalReasonAndClickOnCancel(teller.get("reasonToCancel"));
		aweditPage.clickCancelFinishButton();
		awtransactPage.clickReceiveCard();
		String amount1 = awsendPage.paymentAmount();
		float sendDueAmount = Float.parseFloat(amount1);
		Assert.assertTrue(sendDueAmount>initialDueAmount);
		awhomePage.logout();
	}
}