package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Onboarding {
	
	IOSDriver<MobileElement> driver;
	MobileBy donebutton = (MobileBy) MobileBy.AccessibilityId("Done");
	MobileBy allowbutton = (MobileBy) MobileBy.AccessibilityId("Allow");
	MobileBy languageVC = (MobileBy) MobileBy.AccessibilityId("LanguageVC");
	
	public Onboarding(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}
	
	public void tapDone() {
		driver.findElement(donebutton).click();
	}
	
	public void acceptNotificationsAlert() {
		try {
			driver.findElement(allowbutton).click();
		}catch(Exception e) {
			
		}
	}
	
	public boolean isDisplayed() {
		try {
			return driver.findElement(languageVC).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	
}
