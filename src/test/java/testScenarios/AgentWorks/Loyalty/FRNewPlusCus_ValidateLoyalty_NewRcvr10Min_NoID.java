package test.java.testScenarios.AgentWorks.Loyalty;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.util.Precision;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;
import java.util.Locale;

public class FRNewPlusCus_ValidateLoyalty_NewRcvr10Min_NoID extends TestBase {
	@Test
	public void FRNewPlusCus_ValidateLoyalty_NewRcvr10Min_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "LoyaltyAndPromoCode");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","LoyaltyAndPromoCode", className);
		int loyaltyCount=1;
		awloginPage.login(teller.get("newuser"),teller.get("newpassword"));

//		String feeAmount = "3.90";

		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		HashMap<String, String> loyalty =awsendPage.serviceOptionsWithReturn(teller.get("serviceType"), teller.get("receiveType"));

		String feeAmount = loyalty.get("fees").substring(0, loyalty.get("fees").length()-6);

		String recFirstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
		String recLastName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String firstName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String lastName = RandomStringUtils.randomAlphabetic(6).toLowerCase();

		write.setCellData(recFirstName, className, "rcvFirstName");
		write.setCellData(recLastName, className, "rcvLastName");
		write.setCellData(firstName, className, "senFirstName");
		write.setCellData(lastName, className, "senLastName");

		awsendPage.fillNewReceiverInfo(recFirstName, recLastName, teller.get("recCity"),teller.get("recPhone"), teller.get("direction"));
		awsendPage.fillNewSenderInformation(firstName, lastName,teller.get("senCountry"),teller.get("senAddress"), teller.get("senBirthCountry"), teller.get("senBirthCity"), teller.get("senBirthYear"), teller.get("senBirthMonth"), teller.get("senBirthDay"), teller.get("senOccupation"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awsendPage.enterExpirationDate(teller.get("expirationYear"), teller.get("expirationMonth"), teller.get("expirationDate"));
		awsendPage.enterIDTwoIdentificationUnknown(teller.get("secIdType"), teller.get("secIdNumber"));
		awsendPage.getNextBtn().click();
		awsendPage.confirmContactInformation(teller.get("phoneNumber"), teller.get("primaryEmail"), teller.get("language"), teller.get("plusNumber"));
		awsendPage.additionalPageInformation(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("additionalInfoBirthCountry"));
		awsendPage.completeSend();

		while (loyaltyCount<=5){
			awtransactPage.clickSendCard();
			awsendPage.sendUsingUSExtCust(lastName,teller.get("phoneNumber"));
			awsendPage.sendToExistingReceiver(teller.get("receiveType"), teller.get("DestCountry"));
			awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
			HashMap<String, String> loyalty1 =awsendPage.serviceOptionsWithReturn(teller.get("serviceType"), teller.get("receiveType"));
			switch (loyaltyCount){
				case 1:
					float amount = Precision.round((float) (Float.parseFloat(feeAmount)*(0.2)), 2);
					float amountFee = Precision.round(Float.parseFloat(loyalty1.get("discountAmount").substring(0, loyalty1.get("discountAmount").length()-6)), 2);

					Assert.assertEquals(amount - amountFee, 0);
					break;
				case 5:
					float amount1 = Precision.round((float) (Float.parseFloat(feeAmount)*(0.4)),2);
					float amountFee1 = Precision.round(Float.parseFloat(loyalty1.get("discountAmount").substring(0, loyalty1.get("discountAmount").length()-6)), 2);
					Assert.assertEquals(amount1 - amountFee1, 0);
					break;
			}
			awsendPage.enterIdOneKnown(teller.get("idType"), teller.get("idNumber"));
			awsendPage.getNextBtn().click();
			awsendPage.getNextBtn().click();
			awsendPage.enterIdTwoKnown(teller.get("secIdType"), teller.get("secIdNumber"));
			awsendPage.getNextBtn().click();
			awsendPage.clickOnSendNext();
			awsendPage.additionalPageInformation(teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"), teller.get("whyMoneyGram"), teller.get("citizenshipCountry"), teller.get("additionalInfoBirthCountry"));
			awsendPage.completeSend();
			loyaltyCount++;
		}
		awhomePage.logout();
	}
}