package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginWall {

	IOSDriver<MobileElement> driver;
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
	
	public void tapLoginOption() {
		driver.findElement(loginOption).click();
	}
	
	public void tapLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void tapSignupButton() {
		driver.findElement(signupButton).click();
	}
	
	public void tapCreateAccountButton() {
		driver.findElement(createAccountButton).click();
	}
	
	public void tapEmailButton() {
		driver.findElement(emailButton).click();
	}
	
	public void dismissSuggestions() {
		try{
			if(driver.findElement(closeButton).isDisplayed())
				driver.findElement(closeButton).click();
			System.out.println("close tapped");
		}catch(Exception e) {
//			e.printStackTrace();
			System.out.println(driver.getPageSource());
		}
	}
	
	public void enterLoginDetails(String email, String password) {
		
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		
	}
}
