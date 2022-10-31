package main.java.api.restAPI;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesFromSysOrConfig {

	public String getPropertyFromSysOrConfig(String propertyToGet){
		String propertyValue = System.getProperty(propertyToGet);
		if(propertyValue == null){
			propertyValue = new Properties().getProperty(propertyToGet);
		}
		return propertyValue;
	}


	public String getPropertyFromConfig(String propertyToGet) {
		InputStream is = null;
		Properties prop = null;

		try {
			is = new FileInputStream("config.properties");
			prop = new Properties();
			prop.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String propertyValue = (String) prop.get(propertyToGet);
		return propertyValue;
	}
}
