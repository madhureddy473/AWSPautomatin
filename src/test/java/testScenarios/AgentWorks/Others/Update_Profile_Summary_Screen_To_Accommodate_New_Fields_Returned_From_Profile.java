package test.java.testScenarios.AgentWorks.Others;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Update_Profile_Summary_Screen_To_Accommodate_New_Fields_Returned_From_Profile extends TestBase {

	@Test
	public void Update_Profile_Summary_Screen_To_Accommodate_New_Fields_Returned_From_Profile() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Others", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.searchForExistingCustomerAndValidateDetails(teller.get("senLastName"), teller.get("phoneNumber"), teller.get("senFirstName")+" "+teller.get("senLastName"));
		awhomePage.logout();

	}
}