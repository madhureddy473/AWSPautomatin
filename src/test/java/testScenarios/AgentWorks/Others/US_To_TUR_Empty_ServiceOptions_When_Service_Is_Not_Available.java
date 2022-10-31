package test.java.testScenarios.AgentWorks.Others;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class US_To_TUR_Empty_ServiceOptions_When_Service_Is_Not_Available extends TestBase {
	@Test
	public void US_To_TUR_Empty_ServiceOptions_When_Service_Is_Not_Available() throws Exception {

		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;

		HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Others", className);
		awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
		awtransactPage.clickSendCard();
		awsendPage.newCustomer();
		awsendPage.destinationAndAmount(teller.get("amount"),teller.get("DestCountry"),teller.get("DestState"));
		awsendPage.validateMaxAmount();
		awhomePage.logout();

	}
}