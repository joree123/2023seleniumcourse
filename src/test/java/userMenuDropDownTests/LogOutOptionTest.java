package userMenuDropDownTests;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.BasePage;
import pageObject.UserMenuPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class LogOutOptionTest extends BasicTest {
	
	@Test
	public void logOut() throws InterruptedException, IOException {
		WebDriver driver=BasicTest.getDriver();
		BasicTest.launchUrl();
		driver.manage().window().maximize();
		CommonUtils.waitForAllElements(driver);
		LoginToSalesForce loginTo=new LoginToSalesForce();
		loginTo.login();
		BasePage bp=new BasePage(driver);
		String fullName=bp.fullNameOfUser.getText();
		String[] name=fullName.split(" ");
		String firstName=name[0].trim();
		String lastName=name[1].trim();
		
		Thread.sleep(6000);
		UserMenuPage ump=new UserMenuPage(driver);
		String actualText=ump.userMenuText.getAttribute("title");
		String expectedText="User menu for "+firstName+" "+lastName;
		AssertJUnit.assertEquals(actualText, expectedText);
		Boolean flag=CommonUtils.waitForElement(driver, ump.userMenuButton);
		if(flag==true)
		{
			ump.userMenuButton.click();
		}
						
		List<WebElement> menuItems=ump.userMenuItems;
		//logout option click
		menuItems.get(4).click();
		
		Thread.sleep(5000);
		String loginUrl=driver.getCurrentUrl();
		
		System.out.println(loginUrl);
	
	driver.close();
}}
