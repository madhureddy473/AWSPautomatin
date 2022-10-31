package test.java.testScenarios.AgentWorks.BillPay;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class BillPay_Higher_Than_AgentLimit extends TestBase{
	@Test
	public void BillPay_Higher_Than_AgentLimit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","BillPay", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.searchForBiller(teller.get("billcode"), teller.get("amount"),teller.get("accountNum"),teller.get("biller"));
		awhomePage.logout();
	}

}
