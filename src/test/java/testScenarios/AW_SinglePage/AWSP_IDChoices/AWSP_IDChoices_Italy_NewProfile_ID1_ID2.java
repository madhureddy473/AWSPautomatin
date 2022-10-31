package testScenarios.AW_SinglePage.AWSP_IDChoices;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_IDChoices_Italy_NewProfile_ID1_ID2 extends TestBase{
	@Test
	public void AWSP_IDChoices_Italy_NewProfile_ID1_ID2() throws Exception {

		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "IDChoices");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","IDChoices", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		//awtransactPage.clickSendCard();
		awtransactPage.clickSendCard();
		awsinglePage.searchUsingLastNameAndPhoneNumber(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
		//awsinglePage.destinationAndAmount_Ext(teller.get("destAmt"),teller.get("destCountry"));
		awsinglePage.fillNewSenderInformation(teller.get("senFirstName"),teller.get("senLastName"),teller.get("senBirthYear"),teller.get("senBirthMonth"),teller.get("senBirthDay"),teller.get("senAddress"),teller.get("senPrimaryPhoneCountryCode"),teller.get("senPrimaryPhoneNum"),teller.get("senEmail"),teller.get("senPreferredLanguage"));
		awsinglePage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsinglePage.serviceOption(teller.get("serviceOption"));
		//awsinglePage.selectexistingIDone(teller.get("idTypeonFile"), teller.get("idNumberonFile"), teller.get("idType"), teller.get("idNumber"));
//awsinglePage.serviceOption(teller.get("serviceOption"));

		awsinglePage.identificationforITlowwscanenabled(teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"), teller.get("idIssueState"), teller.get("idIssueCity"),teller.get("idIssueAuthority"),teller.get("issueYear"),teller.get("issueMonth"),teller.get("issueDay"), teller.get("expYear"), teller.get("expMon"), teller.get("expDay"), teller.get("secIdType"), teller.get("secIdNumber"));
		//awsinglePage.identificationforExistingonfileloww(teller.get("id1TypeonFile"), teller.get("id1onFile"));
		//awsinglePage.identificationforExistingonfilehighh(teller.get("id2TypeonFile"), teller.get("id2onFile"));
awsinglePage.additionalInformationfolowamontsItaly(teller.get("additionalInfoGender"),teller.get("senOccupation"),teller.get("additionalInfoBirthCountry"),teller.get("senBirthCity"),teller.get("nationalityCountry"),teller.get("citizenshipCountry"),teller.get("sourceOfFunds"),teller.get("relationshipToReceiver"),teller.get("purposeOfTransaction"));
		//awsinglePage.additionalInformation(teller.get("additionalInfoBirthCountry"),teller.get("senOccupation"),teller.get("ThirdpartyType"));
		//awsinglePage.additionalInformationfolowamonts(teller.get("additionalInfoBirthCountry"));
		//awsinglePage.receiverInformationefee(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		awsinglePage.receiverInformationlow(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		awsinglePage.ItalyIDissueDetails(teller.get("idIssueCity"),teller.get("idIssueAuthority"),teller.get("issueYear"),teller.get("issueMonth"),teller.get("issueDay"));
		awsinglePage.submitTransaction();
		awsinglePage.validations(teller,teller.get("existingCustomer"));

	}
}
