package test.java.testScenarios.AgentWorks.IDScan;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
import utilities.ExcelUtil;

import java.util.HashMap;

public class US_Peripheral_Testing_Using_TwainScanner extends TestBase{
	@Test
	public void US_Peripheral_Testing_Using_TwainScanner() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();

		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","IDScan", className);

		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awutilitiesPage.selectUtility();
		awutilitiesPage.selectPeripheral();
		awutilitiesPage.selectImageScan();
		awutilitiesPage.editScan();
		awutilitiesPage.finishScan();
		awhomePage.logout();
	}
}
