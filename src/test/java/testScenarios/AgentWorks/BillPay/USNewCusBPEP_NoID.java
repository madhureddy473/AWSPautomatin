package test.java.testScenarios.AgentWorks.BillPay;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class USNewCusBPEP_NoID extends TestBase{
	@Test
	public void USNewCusBPEP_NoID() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","BillPay", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.searchBiller(teller.get("biller"), teller.get("billers"));
		awbillPayPage.getNewCustomer().click();
		awbillPayPage.paymentDetails(teller.get("amount"),teller.get("accountNum"));
		awbillPayPage.enterSenderInfo(teller.get("senFirstName"), teller.get("senLastName"), teller.get("senAddress"));
		awbillPayPage.enterDateOfBirth(teller.get("senBirthYear"),teller.get("senBirthMonth"), teller.get("senBirthDay"));
		awsendPage.getNextBtn().click();
		awbillPayPage.submitButton();
		awbillPayPage.getFinishedBtn().click();
		awhomePage.logout();

	}
}
