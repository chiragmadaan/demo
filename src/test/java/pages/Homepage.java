package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Homepage {

	IOSDriver<MobileElement> driver;
	MobileBy userTab = (MobileBy) MobileBy.AccessibilityId("TabBar User");
	
	public Homepage(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}
	
	public void goToProfilePage() {
		driver.findElement(userTab).click();
	}
}
