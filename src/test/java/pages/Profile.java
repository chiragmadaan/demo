package pages;

import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Profile {

	IOSDriver<MobileElement> driver;
	
	//	setting up all the accessibility IDs of the page
	
	MobileBy emailOption = (MobileBy) MobileBy.AccessibilityId("use email");
	MobileBy emailTextField = (MobileBy) MobileBy.AccessibilityId("email");
	MobileBy passwordTextField = (MobileBy) MobileBy.AccessibilityId("password");
	MobileBy confirmPasswordTextField = (MobileBy) MobileBy.AccessibilityId("confirmpassword");
	MobileBy loginButton = (MobileBy) MobileBy.AccessibilityId("Log In");
	MobileBy signupButton = (MobileBy) MobileBy.AccessibilityId("Sign Up");
	MobileBy signupOption = (MobileBy) MobileBy.AccessibilityId("Don't have an account? Sign up free.");
	MobileBy userimage = (MobileBy) MobileBy.AccessibilityId("My Music");
	
	public Profile(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}
	
	
	// Following are the methods to interact with the page
	
	public void tapEmailOption() {
		Util.element(emailOption, driver).click();
	}
	
	public void tapSignupOption() {
		Util.element(signupOption, driver).click();
	}
	
	public void enterLoginDetails(String email, String password) {
		Util.element(emailTextField, driver).sendKeys(email);
		Util.element(passwordTextField, driver).sendKeys(password);
	}
	
	public void enterSignupDetails(String email, String password) {
		Util.element(emailTextField, driver).sendKeys(email);
		Util.element(passwordTextField, driver).sendKeys(password);
		Util.element(confirmPasswordTextField, driver).sendKeys(password);
	}
	
	public void tapLoginButton() {
		Util.element(loginButton, driver).click();
	}
	
	public void tapSignupButton() {
		Util.element(signupButton, driver).click();
	}
	
	public boolean isUserImageDisplayed() {
		try {
			return Util.element(userimage, driver).isEnabled();
		}catch(Exception e) {
			return false;
		}
	}
}
