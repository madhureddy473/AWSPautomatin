package test.java.testScenarios.AgentWorks.IndicativeCountries;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class USToHaitiNewCusRecReversal_NoID extends TestBase {
	@Test
	public void USToHaitiNewCusRecReversal_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","IndicativeCountry", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickEditCard();
		aweditPage.enterReferenceNumber(teller.get("referenceNum"));
		awreceivePage.taxAmount();
		awreceivePage.validateReceiveTaxes();
		aweditPage.getReversalBtn().click();
		aweditPage.reversalReasonAndClickOnCancel(teller.get("reasonToCancel"));
		aweditPage.getCancelFinishedBtn().click();
		awhomePage.logout();
	}
}