package test.java.testScenarios.AgentWorks.ItalianFiscalCode;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class Existing_Customer_Send_Italy_ID extends TestBase {
	@Test
	public void Existing_Customer_Send_Italy_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","FiscalCode", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"), teller.get("phoneNumber"), teller.get("senFirstName")+" "+teller.get("senLastName"));
		awsendPage.newReceiver();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
//		awsendPage.sendBirthCity(teller.get("senBirthCity"));
		awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.senderIdentification();
		awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.clickOnSendNext();
		awsendPage.additionalPageInfo(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("nationalityCountry"), teller.get("additionalInfoGender"), teller.get("additionalInfoPermanentResidency"), teller.get("proofOfFunds"));
//		awsendPage.enterIdTwoKnownWithError(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.completeSend();
		awhomePage.logout();
	}
}