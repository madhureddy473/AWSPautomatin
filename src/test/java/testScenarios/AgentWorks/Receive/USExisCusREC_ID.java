package test.java.testScenarios.AgentWorks.Receive;

import java.util.HashMap;

import org.testng.annotations.Test;


import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class USExisCusREC_ID extends TestBase {
	@Test
	public void USExisCusREC_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Receive", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));

		utilities.ExcelUtil write = new utilities.ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "AmendCancel");
		String refNum = teller.get("referenceNum");

		awtransactPage.clickReceiveCard();
		awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
		awreceivePage.getNextBtn().click();
		awreceivePage.receiverInformation(teller.get("DestCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"));
		awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
		awreceivePage.thirdPartyInfoForHighAmount();
		awreceivePage.enterReceiverIdentificationOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
		awreceivePage.getNextBtn().click();
		awreceivePage.enterReceiverIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awreceivePage.clickPayout();
		write.setCellData(refNum, "RecRev_Higher_Than_AgentLimit", "referenceNum");
		awhomePage.logout();

	}
}