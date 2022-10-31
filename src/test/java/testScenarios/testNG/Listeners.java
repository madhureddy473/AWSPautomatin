package test.java.testScenarios.testNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import main.java.api.restAPI.GetPropertiesFromSysOrConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.Constants;

public class Listeners extends TestListenerAdapter{

	public ExtentReports extent;
	public static ExtentTest test;
	protected static WebDriver driver;

	static String dateFormat = "yyyy" + "_" + "MM" + "_" + "dd" + "_" + "a_hh_mm_ss";
	static DateTimeFormatter dtForm = DateTimeFormatter.ofPattern(dateFormat);
	static LocalDateTime current = LocalDateTime.now();

	GetPropertiesFromSysOrConfig config = new GetPropertiesFromSysOrConfig();

	static String path = Constants.logsAndReports.concat(File.separator+"reports" + File.separator).concat(Year.now() + File.separator).concat(LocalDate.now().getMonthValue() + File.separator).
			concat(LocalDate.now().getDayOfMonth() + File.separator);


	public String returnUnifiedPathToLogs_Reports(){
		String path1 = path+ dtForm.format(current)+ File.separator+ "extentReports"+ File.separator;
		boolean directoryCreated = new File(path1).mkdirs();
		return path1;
	}


	private File createBlankExtentReport(){
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		File generatedExtentReportFile = null;

		try {
			generatedExtentReportFile = new File(new Listeners().returnUnifiedPathToLogs_Reports().concat("ExtentReport_" +dateName+".html"));
			System.out.println("Extent Report File created successfully: " + generatedExtentReportFile.createNewFile());
		} catch (IOException e){
			System.out.println("IO exception thrown while attempting to create extent report HTML file");
			e.printStackTrace();
		}
		return generatedExtentReportFile;
	}


	public void onStart(ITestContext result)
	{
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(createBlankExtentReport()); //creates an object of report

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Hostname", System.getProperty("user.name"));
		extent.setSystemInfo("Browser", config.getPropertyFromSysOrConfig("browser"));

	}

	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());

	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
		test.log(Status.FAIL, "TEST CASE DETAILS ARE " + result.getThrowable());

		try {
			String screenshot = getScreenshot(driver, result.getName());
			test.addScreenCaptureFromBase64String(screenshot);

		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
	
	}

	public void onFinish(ITestContext result)
	{
		extent.flush();
	}

	private static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String baseSixtyFourStringScreenshot = null;
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = path.concat(File.separator)+ dtForm.format(current)+ "/screenshots/" + screenshotName + dateName +" .png";
		FileUtils.copyFile(screenShot, new File(destination));

		baseSixtyFourStringScreenshot = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(screenShot));

		return baseSixtyFourStringScreenshot;

	}

	public void setWebDriver(WebDriver driver) {
		Listeners.driver = driver;
		
	}

	
}
