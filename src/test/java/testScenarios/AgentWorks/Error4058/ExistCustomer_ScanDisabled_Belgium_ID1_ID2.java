package test.java.testScenarios.AgentWorks.Error4058;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class ExistCustomer_ScanDisabled_Belgium_ID1_ID2 extends TestBase{
	@Test

	public void ExistCustomer_ScanDisabled_Belgium_ID1_ID2() throws Exception {

		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "4058Error");

		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","4058Error", className);

		String firstName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String lastName = RandomStringUtils.randomAlphabetic(5).toLowerCase();

		write.setCellData(firstName, className, "senFirstName");
		write.setCellData(lastName, className, "senLastName");

		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.getManualSearch().click();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.fillNewSenderInformation(firstName,lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.enterIdOneCity(teller.get("idIssueCity"));
		awsendPage.enterIssueDate(teller.get("issueYear"), teller.get("issueMonth"), teller.get("issueDay"));
		awsendPage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
		awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.additionalPageInfo(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("nationalityCountry"), teller.get("additionalInfoGender"), teller.get("additionalInfoPermanentResidency"), teller.get("proofOfFunds"));
		String refNum = awsendPage.completeSendWithReturnValue();
		write.setCellData(refNum, "ExistCustomer_ScanDisabled_Receive_Belgium_ID1_ID2", "referenceNum");

		awtransactPage.clickSendCard();
		awsendPage.getManualSearch().click();
		awsendPage.searchUsingLastNameAndPhoneNumber(lastName, teller.get("phoneNumber"), firstName+" "+lastName);
		awsendPage.newReceiver();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.senderIdentification();
		awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.clickOnSendNext();
		awsendPage.additionalPageInfo(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("nationalityCountry"), teller.get("additionalInfoGender"), teller.get("additionalInfoPermanentResidency"), teller.get("proofOfFunds"));
		awsendPage.completeSend();
		awhomePage.logout();


	}
}
