package test.java.testScenarios.AgentWorks.Send;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class ExisCus_SEN_US_PHL_NoID extends TestBase{

	@Test
	public void ExisCus_SEN_US_PHL_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;

		utilities.ExcelUtil write = new utilities.ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");

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
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"), teller.get("rcvLastName"), teller.get("recCity"), teller.get("recPhone"), teller.get("direction"));
		awsendPage.fillNewSenderInformation(firstName,lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.enterIdOneState(teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();

		awtransactPage.clickSendCard();
		awsendPage.searchUsingLastNameAndPhoneNumber(lastName, teller.get("phoneNumber"), firstName+" "+lastName);
		awsendPage.newReceiver();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.enterIDOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
		awsendPage.getNextBtn().click();
		awsendPage.clickOnSendNext();
		awsendPage.enterIdOneState(teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();
		awhomePage.logout();

	}
}
