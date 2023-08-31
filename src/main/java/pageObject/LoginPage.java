package pageObject;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtilities;

/**
 * 
 */
public class LoginPage {
 public LoginPage(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
 
    @FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password" )
	public WebElement password;
	
	@FindBy(id = "Login" )
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@id='rememberUn']" )
	public WebElement rememberMe;
	
	@FindBy(id = "error" )
	public WebElement errorMessage;
	
	@FindBy(partialLinkText = "Forgot" )
	public WebElement forgotPassword;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	@FindBy(css= "#continue")
	public WebElement continueButton;
	
	@FindBy(xpath= "//div[@class='message']/p[1]")
	public WebElement message;
	
	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	
	
	public boolean selectRememberMeCheckBox() {
		boolean isSelected = false;
		if (!rememberMe.isSelected()) {
			rememberMe.click();
			isSelected = true;
		}
		return isSelected;
	}

	public void loginToApp(WebDriver driver) throws IOException {
		driver.get(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		driver.manage().window().maximize();
		if (CommonUtils.waitForElement(driver, username)) {
			username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			password.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
			loginButton.click();
		}
	}
	
	
}
