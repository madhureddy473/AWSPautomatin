package testScenarios.AgentWorks.BillPay;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class BP_UBP_Max_Limit_tobeDeleted extends TestBase{
	@Test
	public void BP_UBP_Max_Limit() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","BillPay", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickBillPayCard();
		awbillPayPage.billerDetails(teller.get("biller"), teller.get("billers"),teller.get("amount"),teller.get("accountNum"),teller.get("biller"));
		awbillPayPage.verifyMaxLimit();
		awhomePage.logout();
	}
}
