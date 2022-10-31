package test.java.testScenarios.AgentWorks.BillPay;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Use_Agent_Currency_For_BillPay_Fees extends TestBase{
	@Test
	public void Use_Agent_Currency_For_BillPay_Fees() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","BillPay", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.searchBiller(teller.get("billcode"), teller.get("billcode"));
		awbillPayPage.getNewCustomer().click();
		awbillPayPage.paymentDetails(teller.get("amount"),teller.get("accountNum"));
		awbillPayPage.enterSenderInfo(teller.get("senFirstName"), teller.get("senLastName"), teller.get("senAddress"));
		awsendPage.enterIDOneIdentificationUnknown(teller.get("idType"), teller.get("idNumber"),teller.get("idIssueCountry"), teller.get("idIssueState"));
		awbillPayPage.enterDateOfBirth(teller.get("senBirthYear"),teller.get("senBirthMonth"), teller.get("senBirthDay"));
		awsendPage.getNextBtn().click();
		awbillPayPage.additionalAccountNumber(teller.get("accountNum"));
		awbillPayPage.submitButton();
		awbillPayPage.getFinishedBtn().click();
		awhomePage.logout();

	}
}
