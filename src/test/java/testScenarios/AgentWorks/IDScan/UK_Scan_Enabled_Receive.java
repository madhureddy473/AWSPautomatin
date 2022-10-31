package test.java.testScenarios.AgentWorks.IDScan;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class UK_Scan_Enabled_Receive extends TestBase {
	@Test
	public void UK_Scan_Enabled_Receive() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","IDScan", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickReceiveCard();
		awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
		awreceivePage.getNextBtn().click();
		awreceivePage.receiverInformation(teller.get("DestCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"));
		awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
		awreceivePage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
		awreceivePage.enterReceiverIdentificationOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("DestCountry"), teller.get("DestState"));
		awreceivePage.getNextBtn().click();
		awreceivePage.clickPayout();
		awsendPage.selectImageScan();
		awsendPage.selectUpload();
		awhomePage.logout();

	}
}