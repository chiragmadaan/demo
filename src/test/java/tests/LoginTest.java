package tests;

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
	public void loginTest() {
		
		Onboarding onboardingObj = new Onboarding(driver);
		Homepage homepageObj = new Homepage(driver);
		Profile profileObj = new Profile(driver);
		LoginWall loginWallObj = new LoginWall(driver);
		
		onboardingObj.acceptNotificationsAlert();
		
		if(onboardingObj.isDisplayed()) {
			onboardingObj.tapDone();
			homepageObj.goToProfilePage();
			profileObj.tapEmailOption();
			profileObj.enterLoginDetails("test@mybeepr.com", "myBeepr123");
			profileObj.tapLoginButton();
			homepageObj.goToProfilePage();
			AssertJUnit.assertTrue(profileObj.isUserImageDisplayed());
		} else {
			loginWallObj.tapLoginOption();
			loginWallObj.tapEmailButton();
			loginWallObj.dismissSuggestions();
			loginWallObj.enterLoginDetails("test@mybeepr.com", "myBeepr123");
			loginWallObj.tapLoginButton();
			
			AssertJUnit.assertTrue(onboardingObj.isDisplayed());
			
		}
		
		
	}
	
	@Test
	public void signup() {
		
		Onboarding onboardingObj = new Onboarding(driver);
		Homepage homepageObj = new Homepage(driver);
		Profile profileObj = new Profile(driver);
		LoginWall loginWallObj = new LoginWall(driver);
		
		onboardingObj.acceptNotificationsAlert();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		String append = dtf.format(now);
		
		if(onboardingObj.isDisplayed()) {
			onboardingObj.tapDone();
			homepageObj.goToProfilePage();
			profileObj.tapEmailOption();
			profileObj.tapSignupOption();
			profileObj.enterSignupDetails( append + "@mybeepr.com", "myBeepr123");
			profileObj.tapSignupButton();
			homepageObj.goToProfilePage();
			AssertJUnit.assertTrue(profileObj.isUserImageDisplayed());
		} else {
			loginWallObj.tapLoginOption();
			loginWallObj.tapEmailButton();
			loginWallObj.dismissSuggestions();
			loginWallObj.tapSignupButton();
			loginWallObj.enterLoginDetails( append + "@mybeepr.com", "myBeepr123");
			loginWallObj.tapSignupButton();
			
			AssertJUnit.assertTrue(onboardingObj.isDisplayed());
			
		}
		
	}
	

}
