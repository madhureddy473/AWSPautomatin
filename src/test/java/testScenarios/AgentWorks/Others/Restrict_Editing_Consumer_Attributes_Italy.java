package test.java.testScenarios.AgentWorks.Others;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Restrict_Editing_Consumer_Attributes_Italy extends TestBase{
	@Test

	public void Restrict_Editing_Consumer_Attributes_Italy() throws Exception {
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Others", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.searchForExisting(teller.get("senLastName"), teller.get("phoneNumber"), teller.get("senFirstName")+" "+teller.get("senLastName"));
		awsendPage.validateAttributesAreDisabled();

	}
}
