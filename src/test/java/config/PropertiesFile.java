package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.annotations.Test;
import test.java.testScenarios.Base.TestBase;


public class PropertiesFile {
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	
	
	public static void main(String[] args) {
		getProperties();
//		setProperties();
	}
	
	
	public static void getProperties() {
		try {

			String projectPath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			prop.load(input);
			
			String browser = prop.getProperty("browser");
			TestBase.browserName = prop.getProperty("browser");
			TestBase.waitTime = Integer.parseInt(prop.getProperty("waitTime"));
			
			String url = prop.getProperty("url");
			TestBase.url = prop.getProperty("url");
			TestBase.baseUrl = prop.getProperty("xmlBaseUrl");
			
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	public static void setProperties() {
		try {
		OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
		prop.setProperty("browser", "chrome");
		prop.store(output, null);
		
		}
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
