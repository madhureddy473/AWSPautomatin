package test.java.testScenarios.AgentWorks.Loyalty;

import org.junit.Assert;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class USNewCus_Send_PromoCode_NoID extends TestBase{
	@Test
	public void USNewCus_Send_PromoCode_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","LoyaltyAndPromoCode", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationCountryAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"), teller.get("promocode"));
		HashMap<String, String> discountFees = awsendPage.serviceOptionsWithReturn(teller.get("serviceType"), teller.get("receiveType"));
		Assert.assertNotSame("0.00", discountFees.get("discountAmount"));
		awsendPage.fillNewReceiverInfo(teller.get("rcvFirstName"),teller.get("rcvLastName"), teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneUnknown(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.enterIdOneState(teller.get("idIssueState"));
		awsendPage.getNextBtn().click();
		awsendPage.fraudWarningPopup();
		awsendPage.completeSend();
		awhomePage.logout();
	}
}
