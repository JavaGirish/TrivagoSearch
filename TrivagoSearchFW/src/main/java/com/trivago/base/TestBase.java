package com.trivago.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.trivago.util.BrowserSelection;
import com.trivago.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static WebDriverEventListener eventListener;
	public static EventFiringWebDriver eventfiringdriver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger logger = Logger.getLogger(TestBase.class);	

	public TestBase() {
		logger = Logger.getLogger(this.getClass());
		FileInputStream propfile;
		prop = new Properties();
		try {

			propfile = new FileInputStream(".\\src\\main\\java\\com\\trivago\\config\\config.properties");
			prop.load(propfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initilization() {
		driver = BrowserSelection.selectBrowser(prop.getProperty("browser"));

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}
