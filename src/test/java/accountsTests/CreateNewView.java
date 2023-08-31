package accountsTests;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.AccountsPage;
import pageObject.ViewPage;
import testResources.BasicTest;
import utils.CommonUtils;
public class CreateNewView extends BasicTest{
	
	
	@Test
	public void login() throws InterruptedException, IOException {
		
		WebDriver driver=BasicTest.getDriver();
		BasicTest.launchUrl();
		driver.manage().window().maximize();
		CommonUtils.waitForAllElements(driver);
		LoginToSalesForce loginTo=new LoginToSalesForce();
		loginTo.login();
				
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(6000);
		AccountsPage acp=new AccountsPage(driver);
		acp.accountsLink.click();
		ViewPage vp=new ViewPage(driver);
		vp.createViewLink.click();
		vp.viewNameInput.sendKeys("nature1");
		vp.uniqueViewNameInput.sendKeys("forest1");
		vp.saveViewButton.click();
		Select s=new Select(vp.showNewViewList);
		Assert.assertEquals(s.getFirstSelectedOption().getText(),"nature1");
		
		
	
}
}