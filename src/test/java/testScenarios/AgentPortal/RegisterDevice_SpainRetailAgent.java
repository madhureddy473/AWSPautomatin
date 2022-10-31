package test.java.testScenarios.AgentPortal;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;


public class RegisterDevice_SpainRetailAgent extends TestBase {

    @Test
    public void RegisterDevice_SpainRetailAgent() throws Exception {

        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> register = excelFile.readExcel(filePath,"APDATA.xlsx",System.getProperty("user.name"), className);
        loginPage.login(register.get("userId"),register.get("password"));
        homePage.clickTransact();
        homePage.enterRegisterDeviceRetailAgent();
        homePage.logout();

//        HashMap<String, String> approve = excelFile.readExcel(filePath,"APDATA.xlsx",System.getProperty("user.name"), "ApproveDevice");
//        String password = approve.get("password");
//        loginPage.login(approve.get("userId"),excelFile.decodeBase64(password));
//        homePage.clickAdministrationTab();
//        administrationPage.approveRequest();
//        homePage.logout();

    }
}
