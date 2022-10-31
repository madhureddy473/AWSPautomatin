package testScenarios.AW_SinglePage.AWSP_IDChoices;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class AWSP_IDChoices_Italy_ExistingProfile_ID1_ID2 extends TestBase{
	@Test
	public void AWSP_IDChoices_Italy_ExistingProfile_ID1_ID2() throws Exception {

		DataDriven excelFile = new DataDriven();
		ExcelUtil write = new ExcelUtil();
		write.setExcelFile(Constants.File_Path+"/AWDATA.xlsx", "IDChoices");
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","IDChoices", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsinglePage.searchForExistingCustomer(teller.get("senLastName"),teller.get("senPrimaryPhoneNum"));
		//awsinglePage.destinationAndAmount_Ext(teller.get("destAmt"),teller.get("destCountry"));
		awsinglePage.destinationAndAmountexistcust(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));

		awsinglePage.serviceOption(teller.get("serviceOption"));
		awsinglePage.identificationforExistingonfile(teller.get("id1TypeonFile"),teller.get("id1onFile"), teller.get("id2TypeonFile"),teller.get("id2onFile"));
		awsinglePage.clickonIDverifybutton();
		awsinglePage.identificationforExistingonfilehigh(teller.get("id1TypeonFile"),teller.get("id1onFile"), teller.get("id2TypeonFile"),teller.get("id2onFile"));

		//awsinglePage.selectexistingIDtwo(teller.get("idChoice"), teller.get("secIdType"), teller.get("secIdNumber"));
		//awsinglePage.additionalInformationforexistinghigh(teller.get("senOccupation"),teller.get("ThirdpartyType"));
awsinglePage.additionalInfoexistingItaly();
		awsinglePage.receiverInformationlow(teller.get("rcvFirstName"),teller.get("rcvLastName"),teller.get("idIssueState"));
		//awsinglePage.validations(teller,teller.get("existingCustomer"));
awsinglePage.validationswithoutfraudalert(teller,teller.get("existingCustomer"));

		}
	}
