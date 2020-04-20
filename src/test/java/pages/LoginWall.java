package pages;

import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginWall {

	IOSDriver<MobileElement> driver;
	
	//	setting up all the accessibility IDs of the page
	
	MobileBy createAccountButton = (MobileBy) MobileBy.AccessibilityId("Create an Account");
	MobileBy loginOption = (MobileBy) MobileBy.AccessibilityId("Or Log In to an existing Saavn account");
	MobileBy emailButton = (MobileBy) MobileBy.AccessibilityId("email");
	MobileBy closeButton = (MobileBy) MobileBy.AccessibilityId("Close Green");
	MobileBy emailField = (MobileBy) MobileBy.AccessibilityId("email");
	MobileBy passwordField = (MobileBy) MobileBy.AccessibilityId("password");
	MobileBy loginButton = (MobileBy) MobileBy.AccessibilityId("Log In");
	MobileBy signupButton = (MobileBy) MobileBy.AccessibilityId("Sign Up");
	
	public LoginWall(AppiumDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}
	
	
	// Following are the methods to interact with the page
	
	public void tapLoginOption() {
		Util.element(loginOption, driver).click();
	}
	
	public void tapLoginButton() {
		Util.element(loginButton, driver).click();
	}
	
	public void tapSignupButton() {
		Util.element(signupButton, driver).click();
	}
	
	public void tapCreateAccountButton() {
		Util.element(createAccountButton, driver).click();
	}
	
	public void tapEmailButton() {
		Util.element(emailButton, driver).click();
	}
	
	public void dismissSuggestions() {
		try{
			if(Util.element(closeButton, driver).isDisplayed())
				Util.element(closeButton, driver).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterLoginDetails(String email, String password) {
		Util.element(emailField, driver).sendKeys(email);
		Util.element(passwordField, driver).sendKeys(password);
	}
}
