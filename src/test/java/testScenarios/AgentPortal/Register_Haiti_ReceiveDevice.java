package test.java.testScenarios.AgentPortal;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;


public class Register_Haiti_ReceiveDevice extends TestBase {

    @Test
    public void Register_Haiti_ReceiveDevice() throws Exception {

        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> register = excelFile.readExcel(filePath,"APDATA.xlsx","APtestData", className);
        loginPage.login(register.get("userId"),register.get("password"));
        homePage.clickTransact();
        homePage.enterRegisterDevice();

        HashMap<String, String> approve = excelFile.readExcel(filePath,"APDATA.xlsx","APtestData", "ApproveDevice");
        //String password = approve.get("password");
        loginPage.login(System.getProperty("user.name"),System.getenv("APpassword"));
        homePage.clickAdministrationTab();
        administrationPage.approveRequest();
        homePage.logout();

    }
}
