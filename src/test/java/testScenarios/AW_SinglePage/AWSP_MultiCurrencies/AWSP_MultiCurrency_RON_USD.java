package testScenarios.AW_SinglePage.AWSP_MultiCurrencies;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_MultiCurrency_RON_USD extends TestBase{
	@Test
	public void AWSP_MultiCurrency_RON_USD() throws Exception {

		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
		//awsinglePage.destinationAndAmount_Ext(teller.get("destAmt"),teller.get("destCountry"));
		awsinglePage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));
		awsinglePage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsinglePage.serviceOption(teller.get("serviceOption"));
		//awsinglePage.selectexistingIDone(teller.get("idTypeonFile"), teller.get("idNumberonFile"), teller.get("idType"), teller.get("idNumber"));
		//awsinglePage.selectIDtwo(teller.get("secIdType"),teller.get("secIdNumber"));

		awsinglePage.identificationforRO(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("expirationYear"),teller.get("expirationMonth"),teller.get("expirationDate"),teller.get("secIdType"),teller.get("secIdNumber"));
		//awsinglePage.additionalInformation(teller.get("additionalInfoBirthCountry"),teller.get("senOccupation"),teller.get("ThirdpartyType"));
		awsinglePage.additionalInformationfolowamontsRO(teller.get("additionalInfoBirthCountry"), teller.get("citizenshipCountry"), teller.get("senOccupation"), teller.get("purposeOfTransaction"), teller.get("additionalInfoPermanentResidency"));
		awsinglePage.receiverInformation(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		//awsinglePage.receiverInformation(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		awsinglePage.validations(teller,teller.get("existingCustomer"));
	}
}
