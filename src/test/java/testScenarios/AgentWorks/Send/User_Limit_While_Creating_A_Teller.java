package test.java.testScenarios.AgentWorks.Send;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class User_Limit_While_Creating_A_Teller extends TestBase {

	@Test
	public void User_Limit_While_Creating_A_Teller() throws Exception{
		DataDriven excelFile = new DataDriven();
		String className = this.getClass().getSimpleName();
		String filePath = Constants.File_Path;
		HashMap<String, String> login = excelFile.readExcel(filePath,"APDATA.xlsx",System.getProperty("user.name"), className);
		String password = login.get("password");
		loginPage.login(login.get("userId"), excelFile.decodeBase64(password));
		homePage.clickAdministrationTab();
		administrationPage.newUserInfo(login.get("firstName"), login.get("lastName"), login.get("email"), login.get("language"));
		administrationPage.selectAgentWorksCheckBox();
		administrationPage.enterMainOfficeAndLocation(login.get("mainOffice"),login.get("locationId"));
		administrationPage.getNextButton().click();
		administrationPage.selectRole();
		administrationPage.enterAmountThreshold(login.get("sendAmount"), login.get("receiveAmount"), login.get("amendAmount"), login.get("refundAmount"), login.get("billPayAmount"), login.get("receiveReversalAmount"), login.get("moneyOrderAmount"), login.get("vendorPaymentAmount"));
	}
}