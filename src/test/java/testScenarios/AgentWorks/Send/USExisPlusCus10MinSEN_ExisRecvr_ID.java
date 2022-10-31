package test.java.testScenarios.AgentWorks.Send;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class USExisPlusCus10MinSEN_ExisRecvr_ID extends TestBase {
	@Test
	public void USExisPlusCus10MinSEN_ExisRecvr_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;

		utilities.ExcelUtil write = new utilities.ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");

		utilities.ExcelUtil write1 = new utilities.ExcelUtil();
		write1.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "AmendCancel");

		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();

		String recFirstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
		String recLastName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
		String firstName = RandomStringUtils.randomAlphabetic(7).toLowerCase();
		String lastName = RandomStringUtils.randomAlphabetic(8).toLowerCase();

		write.setCellData(recFirstName, className, "rcvFirstName");
		write.setCellData(recLastName, className, "rcvLastName");
		write.setCellData(firstName, className, "senFirstName");
		write.setCellData(lastName, className, "senLastName");

		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(recFirstName,recLastName, teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.thirdPartyInfoForHighAmount();
		awsendPage.fillNewSenderInformation(firstName,lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();

		awtransactPage.clickSendCard();
		awsendPage.searchUsingLastNameAndPhoneNumber(lastName, teller.get("phoneNumber"), firstName+" "+lastName);
		awsendPage.sendToExistingReceiver(teller.get("receiveType"), teller.get("DestCountry"));
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.thirdPartyInfoForHighAmount();
//		awsendPage.fillNewReceiverInfo(recFirstName,recLastName, teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.clickOnSendNext();
		awsendPage.fraudWarningPopup();
		String refNum = awsendPage.completeSendWithReturnValue();
		write1.setCellData(refNum, "Amend_a_Transaction_ID", "referenceNum");
		awhomePage.logout();

	}
}