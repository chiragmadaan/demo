package pages;

import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Homepage {

	IOSDriver<MobileElement> driver;
	
	//	setting up all the accessibility IDs of the page
	
	MobileBy homeTab = (MobileBy) MobileBy.AccessibilityId("TabBar Home");
	MobileBy searchTab = (MobileBy) MobileBy.AccessibilityId("TabBar Search");
	MobileBy playerTab = (MobileBy) MobileBy.AccessibilityId("TabBar Player");
	MobileBy browseTab = (MobileBy) MobileBy.AccessibilityId("TabBar Browse");
	MobileBy userTab = (MobileBy) MobileBy.AccessibilityId("TabBar User");
	
	public Homepage(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}
	
	
	// Following are the methods to interact with the page
	
	public void goToProfilePage() {
		Util.element(userTab, driver).click();
	}
}
