package test.java.testScenarios.Base;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AgentWorks.*;
import test.java.pages.AgentWorks.AgentWorksCompleteTransaction;
import test.java.pages.AgentWorks.AgentWorksUtilitiesPage;
import test.java.pages.BasePage.Page;
import pages.AgentPortal.AgentPortalAdministrationPage;
import pages.AgentPortal.AgentPortalHomePage;
import pages.AgentPortal.AgentPortalLoginPage;
import pages.AgentPortal.AgentPortalNewsPage;
import test.java.pages.AgentWorks.AgentWorksEstimatePage;
import test.java.testScenarios.testNG.Listeners;

public class TestBase {
	public static String browserName = null;
	public static String url = null;
	public static String baseUrl = null;
	public static int waitTime =0;
	public static String adminuserid = null;
	public static String adminpassword = null;
	public static String userid = null;
	public static String password = null;
	private static WebDriver driver;
	protected static Page basePage;
	protected static Listeners listen;



//	private static Logger logger = LogManager.getLogger(TestBase.class.getName());

	public AgentPortalLoginPage loginPage;
	public AgentPortalHomePage homePage;
	public AgentPortalNewsPage newsPage;
	public AgentPortalAdministrationPage administrationPage;

	public AgentWorksLoginPage awloginPage;
	public AgentWorksHomePage awhomePage;
	public AgentWorksNewsPage awnewsPage;
	public AgentWorksAdministrationPage awadministrationPage;
	public AgentWorksTransactPage awtransactPage;
	public AgentWorksCompleteTransaction awCompleteTransaction;
	public AgentWorksSendPage awsendPage;
	public AgentWorksEditPage aweditPage;
	public AgentWorksReceivePage awreceivePage;
	public AgentWorksBillPayPage awbillPayPage;
	public AgentWorksEstimatePage awestimatePage;
	public AgentWorksUtilitiesPage awutilitiesPage;
	public AgentWorksSinglePage awsinglePage;


	@BeforeClass
	public void start() throws Exception {
		initialize();
		basePage = new Page();
		basePage.setTimeToWait(waitTime);
		basePage.setWebDriver(driver);
		listen = new Listeners();
		listen.setWebDriver(driver);
		loginPage = new AgentPortalLoginPage(driver);
		homePage = new AgentPortalHomePage(driver);
		newsPage = new AgentPortalNewsPage(driver);
		administrationPage = new AgentPortalAdministrationPage(driver);

		awloginPage = new AgentWorksLoginPage(driver);
		awhomePage = new AgentWorksHomePage(driver);
		awnewsPage = new AgentWorksNewsPage(driver);
		awtransactPage = new AgentWorksTransactPage(driver);
		awCompleteTransaction = new AgentWorksCompleteTransaction(driver);
		awsendPage = new AgentWorksSendPage(driver);
		aweditPage = new AgentWorksEditPage(driver);
		awreceivePage = new AgentWorksReceivePage(driver);
		awbillPayPage = new AgentWorksBillPayPage(driver);
		awestimatePage = new AgentWorksEstimatePage(driver);
		awutilitiesPage = new AgentWorksUtilitiesPage(driver);
		awsinglePage = new AgentWorksSinglePage(driver);
	}

	@AfterClass
	public void tearDown() {
		System.out.println("Test Done");
		driver.quit();
	}

	public static void initialize() {
		PropertiesFile.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
	}


}
