package test.java.testScenarios.AgentWorks.BillPay;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class USNewCusBPUBP_NoID_tobeDeleted extends TestBase{
	@Test
	public void USNewCusBPUBP_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","BillPay", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.exstCusPaymentDetails(teller.get("biller"),teller.get("billers"), teller.get("amount"),teller.get("accountNum"),teller.get("biller"));
		awbillPayPage.enterSenderInfo(teller.get("senFirstName"), teller.get("senLastName"), teller.get("senAddress"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awbillPayPage.enterDateOfBirth(teller.get("senBirthYear"),teller.get("senBirthMonth"), teller.get("senBirthDay"));
		awsendPage.getNextBtn().click();
		awbillPayPage.payAndVerify();
		awhomePage.logout();
	}
}
