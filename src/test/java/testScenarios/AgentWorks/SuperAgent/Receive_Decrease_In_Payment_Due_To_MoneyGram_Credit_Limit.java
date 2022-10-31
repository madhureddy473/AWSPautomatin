package test.java.testScenarios.AgentWorks.SuperAgent;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Receive_Decrease_In_Payment_Due_To_MoneyGram_Credit_Limit extends TestBase {
	@Test
	public void Receive_Decrease_In_Payment_Due_To_MoneyGram_Credit_Limit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","SuperAgent", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		homePage.clickTransact();
		awtransactPage.clickReceiveCard();
		String amount = awsendPage.paymentAmount();
		float initialDueAmount = Float.parseFloat(amount);
		awreceivePage.enterSenderInfo(teller.get("referenceNum"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"));
		awreceivePage.getNextBtn().click();
		awreceivePage.receiverInformation(teller.get("DestCountry"), teller.get("receiverAddress"), teller.get("recOccupation"), teller.get("relationshipToSender"));
		awreceivePage.receiverContactInformation(teller.get("recPhone"), teller.get("language"));
		awreceivePage.enterReceiverIdentificationOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
		awreceivePage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
		awreceivePage.enterReceiverIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
//		awreceivePage.additionalReceiverPageInfo(teller.get("receiverPurposeOfTransaction"), teller.get("receiverGender"), teller.get("receiverNationality"), teller.get("receiverAdditionalInfoPermanentResidency"), teller.get("citizenshipCountry"));
		awreceivePage.clickPayout();
		awtransactPage.clickReceiveCard();
		String amount1 = awsendPage.paymentAmount();
		float sendDueAmount = Float.parseFloat(amount1);
		Assert.assertTrue(sendDueAmount<initialDueAmount);
		awhomePage.logout();
	}
}