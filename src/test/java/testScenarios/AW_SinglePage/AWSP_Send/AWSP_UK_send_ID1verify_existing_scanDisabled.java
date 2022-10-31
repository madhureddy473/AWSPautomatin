package testScenarios.AW_SinglePage.AWSP_Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_UK_send_ID1verify_existing_scanDisabled extends TestBase{
	@Test
	public void AWSP_UK_send_ID1verify_existing_scanDisabled() throws Exception {

		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "Send");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Send", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsinglePage.searchForExistingCustomer(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
		//awsinglePage.destinationAndAmount_Ext(teller.get("destAmt"),teller.get("destCountry"));
		//awsinglePage.selectexistreceiver();
		awsinglePage.destinationAndAmountexistplusnumHigh(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));

		// awsinglePage.searchForExistingCustomer(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
		awsinglePage.serviceOption(teller.get("serviceOption"));
		//awsinglePage.identificationforIT(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("idIssueCity"), teller.get("idIssueAuthority"),teller.get("issueYear"),teller.get("issueMonth"),teller.get("issueDay"), teller.get("expirationYear"),teller.get("expirationMonth"),teller.get("expirationDate"),teller.get("secIdType"),teller.get("secIdNumber"));
		//awsinglePage.identificationforUK(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"),teller.get("idIssueState"),teller.get("idIssueCity"), teller.get("idIssueAuthority"),teller.get("issueYear"),teller.get("issueMonth"),teller.get("issueDay"), teller.get("expirationYear"),teller.get("expirationMonth"),teller.get("expirationDate"),teller.get("secIdType"),teller.get("secIdNumber"));
		awsinglePage.identificationforExistingonfile(teller.get("id1TypeonFile"),teller.get("id1onFile"), teller.get("id2TypeonFile"),teller.get("id2onFile"));

		//awsinglePage.selectexistingIDone(teller.get("idChoice"), teller.get("idType"), teller.get("idNumber"), teller.get("idIssueCountry"));
		// awsinglePage.selectexistingIDtwo(teller.get("idChoice"), teller.get("secIdType"), teller.get("secIdNumber"));
		// awsinglePage.additionalInformationfolowamontsIT(teller.get("additionalInfoBirthCountry"),teller.get("senBirthCity"), teller.get("citizenshipCountry"), teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"));
		awsinglePage.additionalInformationfolowamontsUK(teller.get("additionalInfoBirthCountry"),teller.get("senOccupation"), teller.get("sourceOfFunds"), teller.get("relationshipToReceiver"), teller.get("purposeOfTransaction"));

		//awsinglePage.receiverInformationforexistingHigh(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));

		awsinglePage.receiverInformation(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		awsinglePage.validations(teller,teller.get("existingCustomer"));

	}
}
