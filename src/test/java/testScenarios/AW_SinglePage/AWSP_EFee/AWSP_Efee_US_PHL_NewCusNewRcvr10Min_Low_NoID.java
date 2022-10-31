package testScenarios.AW_SinglePage.AWSP_EFee;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_Efee_US_PHL_NewCusNewRcvr10Min_Low_NoID extends TestBase{
	@Test
	public void AWSP_Efee_US_PHL_NewCusNewRcvr10Min_Low_NoID() throws Exception {

		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Estimate");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Estimate", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		//awtransactPage.clickSendCard();
		awtransactPage.clickEFeeCard();
		awsinglePage.Estimatefeenostate(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsinglePage.serviceOption(teller.get("serviceOption"));
		awtransactPage.FindyourCustomer();
		awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));


		//awsinglePage.searchForExistingCustomer(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
		//awsinglePage.selectexistreceiver();
		//awsinglePage.destinationAndAmount_Ext(teller.get("destAmt"),teller.get("destCountry"));
		awsinglePage.fillNewSenderInformationefee(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));
		//awsinglePage.destinationAndAmountforpromocode(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));

		//awsinglePage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		//awsinglePage.serviceOption(teller.get("serviceOption"));
		awsinglePage.selectID0ne(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expYear"),teller.get("expMon"),teller.get("expDay"),teller.get("secIdType"),teller.get("secIdNumber"));
		//awsinglePage.selectIDtwo(teller.get("secIdType"),teller.get("secIdNumber"));
//awsinglePage.identificationforExistingonfilehighh(teller.get("id2TypeonFile"), teller.get("id2onFile"));

		//awsinglePage.additionalInformation(teller.get("additionalInfoBirthCountry"),teller.get("senOccupation"),teller.get("ThirdpartyType"));
		awsinglePage.additionalInformationfolowamonts(teller.get("additionalInfoBirthCountry"));

		awsinglePage.receiverInformationefee(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		//awsinglePage.receiverInformation(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		awsinglePage.validations(teller,teller.get("existingCustomer"));

	}
}
