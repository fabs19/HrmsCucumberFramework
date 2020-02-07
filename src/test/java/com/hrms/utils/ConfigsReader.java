package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {//purpose: to read any property file & to return the key value from any property file
	
	private static Properties prop;  //static bc have static method: can access only static variables with static methods
	/*
	 * prop has all data:
	 * browser=chrome
		url=http://166.62.36.207/Syntax_HRM/symfony/web/index.php/auth/login
		username=Admin
		password=Syntax@123
	 */
	//Properties cred=readProperties(credentials.properties);
	//Properties configs=readProperties(configurations.properties)
	
	public static Properties readProperties(String filePath) {  //method returns that file that will be loaded with the data
																//reads any file u pass, return loaded variable
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);//add catch clause. prop variable gets initialized
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	//method returning value based on specified key:
	public static String getProperty(String key) {
		return prop.getProperty(key);  //reading property with variable prop
	}
	

}
