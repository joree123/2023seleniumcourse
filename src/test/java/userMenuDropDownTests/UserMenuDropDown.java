package userMenuDropDownTests;

	

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.BasePage;
import pageObject.UserMenuPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class UserMenuDropDown extends BasicTest{
		
	@Test
	public void dropDownMenus() throws InterruptedException, IOException {
		//test case 05
		WebDriver driver=BasicTest.getDriver();
		BasicTest.launchUrl();
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
		Assert.assertEquals(actualText, expectedText);
		Boolean flag=CommonUtils.waitForElement(driver, ump.userMenuButton);
		if(flag==true)
		{
			ump.userMenuButton.click();
		}
						
		List<WebElement> menuItems=ump.userMenuItems;
		String[] expectedMenu={"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		int i=0;
	    for(WebElement e:menuItems)
	    {
	    	Assert.assertTrue(e.getText().equalsIgnoreCase(expectedMenu[i++]));
	    }
}}
