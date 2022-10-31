package test.java.testScenarios.AgentWorks.Others;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Find_A_Location extends TestBase {

    @Test
    public void Find_A_Location() throws IOException, InterruptedException, AWTException {

        utilities.DataDriven excelFile = new utilities.DataDriven();
        String className = this.getClass().getSimpleName();
        String filePath = utilities.Constants.File_Path;
        HashMap<String, String> teller = excelFile.readExcel(filePath,"AWDATA.xlsx","Others", className);
        awloginPage.login(teller.get("newuser"), teller.get("newpassword"));
        awloginPage.findALocation();
//        awhomePage.logout();
    }
}
