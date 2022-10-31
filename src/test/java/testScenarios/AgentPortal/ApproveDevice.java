package test.java.testScenarios.AgentPortal;
import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;
public class ApproveDevice extends TestBase {
	
	@Test(alwaysRun = true)
	public void ApproveDevice() throws Exception{	
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> approve = excelFile.readExcel(filePath,"APDATA.xlsx",System.getProperty("user.name"), className);
		String password = approve.get("password");
		loginPage.login(approve.get("userId"),excelFile.decodeBase64(password));
		homePage.clickAdministrationTab();
		administrationPage.approveRequest();
		homePage.logout();
	}
}
