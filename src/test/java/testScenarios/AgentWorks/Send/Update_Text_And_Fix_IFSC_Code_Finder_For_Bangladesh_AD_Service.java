package test.java.testScenarios.AgentWorks.Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class Update_Text_And_Fix_IFSC_Code_Finder_For_Bangladesh_AD_Service extends TestBase{
	@Test
	public void Update_Text_And_Fix_IFSC_Code_Finder_For_Bangladesh_AD_Service() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillReceiverInfoAccountDeposit(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("receiverAddress"),teller.get("recPhone"), teller.get("countryCode"), teller.get("senOccupation"));
		awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
//		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"));
//		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.enterAccountDetails(teller.get("IFSCCode"), 12, teller.get("purposeOfFunds"));
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();
		awhomePage.logout();
	}
}
