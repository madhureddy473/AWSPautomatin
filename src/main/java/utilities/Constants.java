package utilities;

import java.io.File;
import java.time.LocalDate;
import java.time.Year;

public class Constants {
	public static final String url = "https://qalogin.qa.moneygram.com/auth/UI/Login";
	public static final String File_Path = System.getProperty("user.dir") + "/src/test/testResources/testData";
	//	public static final String File_Name = "ExcelRead.xlsx";
	public static final String logsAndReports = System.getProperty("user.dir") + "/projectLogsAndReports";
	public static final String screenshots = System.getProperty("user.dir") + "/screenshots/";


	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}

}

