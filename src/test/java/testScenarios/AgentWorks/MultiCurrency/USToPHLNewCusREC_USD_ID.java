package test.java.testScenarios.AgentWorks.MultiCurrency;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class USToPHLNewCusREC_USD_ID extends TestBase {
	@Test
	public void USToPHLNewCusREC_USD_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","MultiCurrency", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickReceiveCard();
		awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
		awreceivePage.getNextBtn().click();
		awreceivePage.receiverInformation(teller.get("DestCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"));
		awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
		awreceivePage.thirdPartyInfoForHighAmount();
		awreceivePage.enterReceiverIdentificationOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
		awreceivePage.getNextBtn().click();
		awreceivePage.additionalReceiverPageInfo(teller.get("receiverPurposeOfTransaction"), teller.get("receiverGender"), teller.get("receiverNationality"), teller.get("receiverAdditionalInfoPermanentResidency"), teller.get("citizenshipCountry"));
		awreceivePage.clickPayout();
		awhomePage.logout();
	}
}