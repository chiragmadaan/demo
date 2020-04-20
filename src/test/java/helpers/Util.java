package helpers;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Util {

	public static MobileElement element( MobileBy locator, AppiumDriver<MobileElement> driver ) {
		return driver.findElement(locator);
	}
	
	public static List<MobileElement> elements( MobileBy locator, AppiumDriver<MobileElement> driver ){
		return driver.findElements(locator);
	}
}
