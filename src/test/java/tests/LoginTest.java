package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginWall;
import pages.Onboarding;
import pages.Profile;

public class LoginTest extends BaseClass {
	
	@Test
	@Parameters({"username", "password"})
	public void loginTest(String username, String password) {
		
		
		//	Creating objects of pages that will be used for this test
		
		Onboarding onboardingObj = new Onboarding(driver);
		Homepage homepageObj = new Homepage(driver);
		Profile profileObj = new Profile(driver);
		LoginWall loginWallObj = new LoginWall(driver);
		
		onboardingObj.acceptNotificationsAlert();
		
		
		//	Two different flows depending on whether the login wall was shown
		//	on the launch screen or was the home page shown on app launch and
		//	user had to navigate the user tab to do the log-in
		
		if(onboardingObj.isDisplayed()) {
			onboardingObj.tapDone();
			homepageObj.goToProfilePage();
			profileObj.tapEmailOption();
			profileObj.enterLoginDetails(username, password);
			profileObj.tapLoginButton();
			homepageObj.goToProfilePage();
			
			// Assert statement to check if the test passed or failed
			
			AssertJUnit.assertTrue(profileObj.isUserImageDisplayed());
			
		} else {
			
			loginWallObj.tapLoginOption();
			loginWallObj.tapEmailButton();
			loginWallObj.dismissSuggestions();
			loginWallObj.enterLoginDetails(username, password);
			loginWallObj.tapLoginButton();
			
			// Assert statement to check if the test passed or failed
			
			AssertJUnit.assertTrue(onboardingObj.isDisplayed());
			
		}
		
	}
	
	@Test
	@Parameters({"password"})
	public void signup(String password) {
		
		
		//	Creating objects of pages that will be used for this test
		
		Onboarding onboardingObj = new Onboarding(driver);
		Homepage homepageObj = new Homepage(driver);
		Profile profileObj = new Profile(driver);
		LoginWall loginWallObj = new LoginWall(driver);
		
		onboardingObj.acceptNotificationsAlert();
		
		
		//	Creating a unique string to be used as user name for sign-up
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		String append = dtf.format(now);
		
		
		//	Two different flows depending on whether the sign-up wall was shown
		//	on the launch screen or was the home page shown on app launch and
		//	user had to navigate the user tab to do the sign up
		
		if(onboardingObj.isDisplayed()) {
			
			onboardingObj.tapDone();
			homepageObj.goToProfilePage();
			profileObj.tapEmailOption();
			profileObj.tapSignupOption();
			profileObj.enterSignupDetails( append + "@mybeepr.com", password);
			profileObj.tapSignupButton();
			homepageObj.goToProfilePage();
			
			// Assert statement to check if the test passed or failed
			
			AssertJUnit.assertTrue(profileObj.isUserImageDisplayed());
			
		} else {
			loginWallObj.tapLoginOption();
			loginWallObj.tapEmailButton();
			loginWallObj.dismissSuggestions();
			loginWallObj.tapSignupButton();
			loginWallObj.enterLoginDetails( append + "@mybeepr.com", password);
			loginWallObj.tapSignupButton();
			
			// Assert statement to check if the test passed or failed
			
			AssertJUnit.assertTrue(onboardingObj.isDisplayed());
			
		}
		
	}
	
	
	
}
