package loginToSalesForce;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Constants.FileConstants;
import pageObject.LoginPage;
import testResources.BasicTest;
import utils.FileUtilities;







public class LoginToSalesForce extends BasicTest {
	@Test
	public void loginTest1() throws InvalidFormatException, IOException {
		WebDriver driver = BasicTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com");
//		String[] creds = ExcelUtils.readLoginTestData(1);
		lp.username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		lp.password.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		
		Assert.assertEquals(lp.selectRememberMeCheckBox(), "");
		
		lp.loginButton.click();
		
		
	}
	
	
	@Test
	public void loginTest2() {
		
		WebDriver driver = BasicTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		lp.username.sendKeys("mithun");
		lp.password.clear();
		lp.loginButton.click();
		
	}
	
	
	
}
		
	
	
	