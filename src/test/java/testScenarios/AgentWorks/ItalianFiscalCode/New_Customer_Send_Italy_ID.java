package test.java.testScenarios.AgentWorks.ItalianFiscalCode;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class New_Customer_Send_Italy_ID extends TestBase{
	@Test

	public void New_Customer_Send_Italy_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","FiscalCode", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.enterIdOneCity(teller.get("idIssueCity"));
		awsendPage.enterIdIssueAuthority(teller.get("idIssueAuthority"));
		awsendPage.enterIssueDate(teller.get("issueYear"), teller.get("issueMonth"), teller.get("issueDay"));
		awsendPage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
		awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.additionalPageInformation(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("nationalityCountry"));
		awsendPage.completeSend();
		awhomePage.logout();
	}
}
