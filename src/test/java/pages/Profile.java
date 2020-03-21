package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Profile {

	IOSDriver<MobileElement> driver;
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
	
	public void tapEmailOption() {
		driver.findElement(emailOption).click();
	}
	
	public void tapSignupOption() {
		driver.findElement(signupOption).click();
	}
	
	public void enterLoginDetails(String email, String password) {
		
		driver.findElement(emailTextField).sendKeys(email);
		driver.findElement(passwordTextField).sendKeys(password);
		
	}
	
	public void enterSignupDetails(String email, String password) {
		
		driver.findElement(emailTextField).sendKeys(email);
		driver.findElement(passwordTextField).sendKeys(password);
		driver.findElement(confirmPasswordTextField).sendKeys(password);
		
	}
	
	public void tapLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void tapSignupButton() {
		driver.findElement(signupButton).click();
	}
	
	public boolean isUserImageDisplayed() {
		try {
			return driver.findElement(userimage).isEnabled();
		}catch(Exception e) {
			return false;
		}
	}
}
