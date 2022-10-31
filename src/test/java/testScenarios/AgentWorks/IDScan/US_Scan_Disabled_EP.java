package test.java.testScenarios.AgentWorks.IDScan;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class US_Scan_Disabled_EP extends TestBase{
	@Test
	public void US_Scan_Disabled_EP() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","IDScan", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.searchBiller(teller.get("biller"), teller.get("billcode"));
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
