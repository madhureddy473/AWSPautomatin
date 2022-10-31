package test.java.testScenarios.AgentWorks.CorrectID;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Italy_Profile_In_Canada_Show_Correct_ID_Options_Canada_Send extends TestBase {
	@Test
	public void Italy_Profile_In_Canada_Show_Correct_ID_Options_Canada_Send() throws Exception {
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
		awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.clickOnSendNext();
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();
		awhomePage.logout();
	}
}