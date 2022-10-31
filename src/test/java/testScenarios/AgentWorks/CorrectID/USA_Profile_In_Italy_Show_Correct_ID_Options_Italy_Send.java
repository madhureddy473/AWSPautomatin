package test.java.testScenarios.AgentWorks.CorrectID;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class USA_Profile_In_Italy_Show_Correct_ID_Options_Italy_Send extends TestBase {
	@Test
	public void USA_Profile_In_Italy_Show_Correct_ID_Options_Italy_Send() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","CorrectID", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"), teller.get("phoneNumber"), teller.get("senFirstName")+" "+teller.get("senLastName"));
		awsendPage.newReceiver();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.serviceOptions(teller.get("serviceType"), teller.get("receiveType"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.thirdPartyInfoForHighAmount();
		awsendPage.sendBirthCity(teller.get("senBirthCity"));
		awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
		awsendPage.getNextBtn().click();
		Thread.sleep(3000);
		awsendPage.getNextBtn().click();
		awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();

	}
}