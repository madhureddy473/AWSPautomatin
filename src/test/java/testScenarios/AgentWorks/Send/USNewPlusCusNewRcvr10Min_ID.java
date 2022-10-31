package test.java.testScenarios.AgentWorks.Send;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

public class USNewPlusCusNewRcvr10Min_ID extends TestBase {
	@Test
	public void USNewPlusCusNewRcvr10Min_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "receive");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);

		String year = String.valueOf((int) ((Math.random() * (60 - 1)) + 1940));
		String date = String.valueOf((int) ((Math.random() *(19 -1)) + 10));

		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.thirdPartyInfoForHighAmount();
		awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), year, teller.get("senBirthMonth"), date, teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.fraudWarningPopup();
		String refNum = awsendPage.completeSendWithReturnValue();
		write.setCellData(year, "USNewPlusCusREC_ID", "senBirthYear");
		write.setCellData(date, "USNewPlusCusREC_ID", "senBirthDay");
		write.setCellData(refNum, "USNewPlusCusREC_ID", "referenceNum");
		awhomePage.logout();
	}
}