package test.java.testScenarios.AgentWorks.Maas;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.util.HashMap;

public class USNewCusSigueKnwRcvr10Min_NoID extends TestBase {

	@Test
	public void USNewCusSigueKnwRcvr10Min_NoID() throws Exception {

		utilities.DataDriven excelFile = new utilities.DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = utilities.Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath, "AWDATA.xlsx", "Maas", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"), teller.get("DestCountry"), teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"), teller.get("rcvLastName"), teller.get("recCity"), teller.get("recPhone"), teller.get("direction"));
//		awsendPage.fillNewSenderInfo(teller.get("senFirstName"), teller.get("senLastName"), teller.get("senCountry"), teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();
	}
}
