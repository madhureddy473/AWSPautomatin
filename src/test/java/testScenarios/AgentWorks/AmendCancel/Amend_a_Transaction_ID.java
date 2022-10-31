package test.java.testScenarios.AgentWorks.AmendCancel;

import java.util.HashMap;

import org.testng.annotations.Test;


import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class Amend_a_Transaction_ID extends TestBase {
	@Test
	public void Amend_a_Transaction_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","AmendCancel", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickEditCard();
		aweditPage.enterReferenceNumber(teller.get("referenceNum"));
		aweditPage.amend();
		awhomePage.logout();
	}
}