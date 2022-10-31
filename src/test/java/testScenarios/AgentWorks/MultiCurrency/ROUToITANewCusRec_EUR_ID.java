package test.java.testScenarios.AgentWorks.MultiCurrency;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class ROUToITANewCusRec_EUR_ID extends TestBase {
	@Test
	public void ROUToITANewCusRec_EUR_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","MultiCurrency", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickReceiveCard();
		awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
		awreceivePage.getNextBtn().click();
		awreceivePage.receiverInfo(teller.get("DestCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"), teller.get("receiverBirthCity"));
		awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
		awreceivePage.enterReceiverIdentificationOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
		awreceivePage.receiverIdOneCity(teller.get("idIssueCity"));
		awreceivePage.receiverIdOneIssueAuthority(teller.get("idIssueAuthority"));
		awsendPage.enterIssueDate(teller.get("issueYear"), teller.get("issueMonth"), teller.get("issueDay"));
		awreceivePage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
		awreceivePage.enterReceiverIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awreceivePage.additionalReceiverPageInfo(teller.get("receiverPurposeOfTransaction"), teller.get("receiverGender"), teller.get("receiverNationality"), teller.get("receiverAdditionalInfoPermanentResidency"), teller.get("citizenshipCountry"));
		awreceivePage.clickPayout();
		awhomePage.logout();
	}
}