package test.java.testScenarios.AgentWorks.Receive;

import java.util.HashMap;

import org.testng.annotations.Test;


import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class USNewCusREC_ID extends TestBase {
	@Test
	public void USNewCusREC_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Receive", className);
		utilities.ExcelUtil write = new utilities.ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "AmendCancel");
		String refNum = teller.get("referenceNum");
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
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
		write.setCellData(refNum, "RecRev_ID", "referenceNum");
		awhomePage.logout();
	}
}