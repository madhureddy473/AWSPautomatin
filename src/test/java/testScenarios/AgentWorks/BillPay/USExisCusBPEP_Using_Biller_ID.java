package test.java.testScenarios.AgentWorks.BillPay;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class USExisCusBPEP_Using_Biller_ID extends TestBase{
	@Test
	public void USExisCusBPEP_Using_Biller_ID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","BillPay", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.searchBiller(teller.get("billcode"), teller.get("billcode"));
		awbillPayPage.searchForCustomer("accountNumber", teller.get("accountNum"));
		awbillPayPage.paymentDetails(teller.get("amount"),teller.get("accountNum"));
//		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("DestCountry"), teller.get("DestState"));
//		awbillPayPage.enterDateOfBirth(teller.get("senBirthYear"),teller.get("senBirthMonth"), teller.get("senBirthDay"));
//		awsendPage.getNextBtn().click();
		awbillPayPage.submitButton();
		awbillPayPage.getFinishedBtn().click();
		awhomePage.logout();


	}
}
