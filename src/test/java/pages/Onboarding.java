package pages;


import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Onboarding {
	
	IOSDriver<MobileElement> driver;
	
	//	setting up all the accessibility IDs of the page
	
	MobileBy donebutton = (MobileBy) MobileBy.AccessibilityId("Done");
	MobileBy allowbutton = (MobileBy) MobileBy.AccessibilityId("Allow");
	MobileBy languageVC = (MobileBy) MobileBy.AccessibilityId("LanguageVC");
	
	public Onboarding(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}
	
	
	// Following are the methods to interact with the page
	
	public void tapDone() {
		Util.element(donebutton, driver).click();
	}
	
	public void acceptNotificationsAlert() {
		try {
			Util.element(allowbutton, driver).click();
		}catch(Exception e) {
			
		}
	}
	
	public boolean isDisplayed() {
		try {
			return Util.element(languageVC, driver).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	
}
