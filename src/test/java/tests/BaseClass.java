package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	
	private String deviceName;
	private String appPath;
	private String platformVersion;
	private String platformName;
	private String automationName;
	
	@BeforeMethod
	@Parameters({"properties"})
	public void setup(String properties) {
		
		loadProperties(properties);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("automationName", automationName);
		cap.setCapability("app", System.getProperty("user.dir") + appPath);
		
		try{
			if(platformName.equals("iOS")) {
				driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			} else {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			}
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// Method to read the test parameters from the .properties file
	
	private void loadProperties(String config) {
		
		FileInputStream propertiesFIS;
		Properties properties = new Properties();
		String propertiesFilePath = String.format("src/test/resources/properties/%s.properties", config);
		
		try {
		  propertiesFIS = new FileInputStream(propertiesFilePath);
		  properties.load(propertiesFIS);
		
		  appPath = properties.getProperty("app");
		  platformVersion = properties.getProperty("platformVersion");
		  platformName = properties.getProperty("platformName");
		  deviceName = properties.getProperty("deviceName");
		  automationName = properties.getProperty("automationName");
		
		} catch (IOException e) {
		  System.out.println("Properties file is missing or invalid! Check path to file: " + propertiesFilePath);
		  System.exit(0);
		}
	    
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
