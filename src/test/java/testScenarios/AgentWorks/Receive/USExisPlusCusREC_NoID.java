package test.java.testScenarios.AgentWorks.Receive;

import java.util.HashMap;

import org.testng.annotations.Test;


import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class USExisPlusCusREC_NoID extends TestBase {
	@Test
	public void USExisPlusCusREC_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Receive", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickReceiveCard();
		awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
		awreceivePage.getNextBtn().click();
		awreceivePage.receiverInformation(teller.get("DestCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"));
//		awreceivePage.receiverInfo(teller.get("DestCountry"), teller.get("senAddress"), teller.get("senOccupation"));
		awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
		awreceivePage.clickPayout();
		awhomePage.logout();

	}
}