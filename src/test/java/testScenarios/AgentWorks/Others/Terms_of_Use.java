package test.java.testScenarios.AgentWorks.Others;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;
import utilities.Constants;
import utilities.DataDriven;

import java.util.HashMap;

public class Terms_of_Use extends TestBase {
	@Test
	public void Terms_of_Use() throws Exception {

		awloginPage.termsOfUse();
	}
}