package test.java.testScenarios.AgentPortal;

import java.util.HashMap;

import org.testng.annotations.Test;

import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

public class  UnregisterDevice extends TestBase {
	
	@Test
	public void UnregisterDevice() throws Exception{

		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> Unregister = excelFile.readExcel(filePath,"APDATA_singlepage.xlsx","APData", className);
		//String password = Unregister.get("password");
		//loginPage.login(Unregister.get("userId"), excelFile.decodeBase64(password));
		loginPage.login(System.getProperty("user.name"),System.getenv("APpassword"));
		homePage.clickAdministrationTab();
		//administrationPage.unregister(Unregister.get("mainOffice"), Unregister.get("locationId"));
		administrationPage.unregisterTeller(Unregister.get("mainOffice"), Unregister.get("locationId"));


	}
}

