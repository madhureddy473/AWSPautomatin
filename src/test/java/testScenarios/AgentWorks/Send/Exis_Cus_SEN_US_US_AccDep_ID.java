package test.java.testScenarios.AgentWorks.Send;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class Exis_Cus_SEN_US_US_AccDep_ID extends TestBase {
	@Test
	public void Exis_Cus_SEN_US_US_AccDep_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;

		utilities.ExcelUtil write = new utilities.ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");

		utilities.ExcelUtil write1 = new utilities.ExcelUtil();
		write1.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Receive");

		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();

		String firstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
		String lastName = RandomStringUtils.randomAlphabetic(6).toLowerCase();

		write.setCellData(firstName, className, "senFirstName");
		write.setCellData(lastName, className, "senLastName");

		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillReceiverInfoAccountDeposit(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("receiverAddress"),teller.get("recPhone"), teller.get("countryCode"), teller.get("recOccupation"));
		awsendPage.thirdPartyInfoForHighAmount();
		awsendPage.fillNewSenderInformation(firstName,lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.enterAccountNumber();
		awsendPage.fraudWarningPopup();
		String refNum = awsendPage.completeSendWithReturnValue();
		write1.setCellData(refNum, "Receive_Higher_Than_AgentLimit", "referenceNum");

		awtransactPage.clickSendCard();
		awsendPage.searchUsingLastNameAndPhoneNumber(lastName, teller.get("phoneNumber"), firstName+" "+lastName);
		awsendPage.newReceiver();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillReceiverInfoAccountDeposit(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("receiverAddress"),teller.get("recPhone"), teller.get("countryCode"), teller.get("recOccupation"));
		awsendPage.thirdPartyInfoForHighAmount();
		awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.clickOnSendNext();
		awsendPage.enterAccountNumber();
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();
		awhomePage.logout();

	}
}