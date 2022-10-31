package test.java.testScenarios.AgentPortal;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class UnregisterDevice_TrainingMode extends TestBase {
	
	@Test
	public void UnregisterDevice_TrainingMode() throws Exception{
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> Unregister = excelFile.readExcel(filePath,"APDATA.xlsx",System.getProperty("user.name"), className);
		String password = Unregister.get("password");
		loginPage.login(Unregister.get("userId"), excelFile.decodeBase64(password));
		homePage.clickAdministrationTab();
		administrationPage.unregister(Unregister.get("mainOffice"), Unregister.get("locationId"));
	}
}
