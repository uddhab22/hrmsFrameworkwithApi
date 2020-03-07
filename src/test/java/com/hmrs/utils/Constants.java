package com.hmrs.utils;

public class Constants {
	
	public static final String CREDENTIAL_FILEPATH = "/Users/uddhabrijal/eclipse-workspace/HrmsCucumberFramework/src/test/resources/Configs/configuration.properties";
	
	//public static final String HRMS_URL ="http://166.62.36.207/Syntax_HRM";
	
	//public static final String Browser = "chrome";
	
	public static final String Xl_DATA_FILEPATH = "/Users/uddhabrijal/eclipse-workspace"
			+ "/HRMS/src/test/resources/TestData/HMRSTestDATA.xlsx";
	
	public static final String Chrome_driver_Path = System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver";
	
	public static final String Gecko_driver_Path = System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver";
	
	public static final int PAGE_LOAD_Time = 30;
	
	public static final int IMPLICIT_LOAD_Time = 30;
	
	public static final int EXPLICIT_LOAD_Time = 30;
	
	public static final String REPORT_FILEPATH = System.getProperty("user.dir")+
			"/target/Report/HRMS.html";
	
	public static final String OS_NAME = System.getProperty("os.name");
	
	public static final String USER_NAME = System.getProperty("user.name");
	
	public static final String SCREENSHOTS_FILEPATH= System.getProperty("user.dir")+
			"/target/screenshots/";
	
}
