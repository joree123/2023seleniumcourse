package userMenuDropDownTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constants.FileConstants;
import pageObject.LoginPage;
import pageObject.UserMenuPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class MyProfileOptionTset extends BasicTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BasicTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	@Test ()
	public void userMenuDropDown_TC06() throws IOException, InterruptedException {
		
		
		
		WebDriver driver = BasicTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
		Assert.assertTrue(ump.selectMyProfile(), "");
		CommonUtils.waitForElement(driver, ump.profilePage);
		Assert.assertTrue(ump.isProfilePageVisible(), "");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyEditContactPopUp(driver), "");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "Tekarch"), "");
		Assert.assertTrue(ump.verifyCreatePost(driver, "Hello welcome to java"));
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.LOGIN_TESTDATA_FILE_PATH));
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PROFILE_PHOTO_FILE_PATH));
		
//		Assert.assertEquals(ump.selectRandomOption(), "My profile", "Failed");
		
	}

}

				
		
		


