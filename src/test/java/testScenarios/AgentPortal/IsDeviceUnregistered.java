package test.java.testScenarios.AgentPortal;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class IsDeviceUnregistered extends TestBase {
	
	@Test
	public void IsDeviceUnregistered() throws Exception{
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
	//	HashMap<String, String> approve = excelFile.readExcel(filePath,"APDATA.xlsx","APtestData", "IsDeviceUnregistered");
		//String password = approve.get("password");
		loginPage.login(System.getProperty("user.name"),System.getenv("APpassword"));
		System.out.println(System.getenv("APpassword"));
		administrationPage.goToApplicationInfo();
		administrationPage.isUnregistrationDone();
	}
}
