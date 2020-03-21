package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "iPhone 11 Pro Max");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "13.3");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("fullReset", true);
		cap.setCapability("app", "/Users/user/Downloads/Saavn.app");
		
		try{
			driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
