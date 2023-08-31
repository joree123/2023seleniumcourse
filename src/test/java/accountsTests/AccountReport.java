package accountsTests;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.AccountsPage;
import pageObject.AccountsReportPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class AccountReport extends BasicTest{
	
	@Test
	public void createAccountReport() throws InterruptedException, IOException {
		//test case 05
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
		
		AccountsReportPage arp=new AccountsReportPage(driver);
		arp.accountsLinkGreaterThan30Days.click();
		
		arp.dateFieldDropDown.click();
		arp.createDateOPtion.click();
		Date date=new Date();
		SimpleDateFormat sdate=new SimpleDateFormat("M/d/yyyy");
		arp.fromDateField.sendKeys(sdate.format(date));
		arp.toDateField.clear();
		arp.toDateField.sendKeys(sdate.format(date));
		arp.saveAccountReportButton.click();
		Thread.sleep(6000);
		arp.savedReportName.sendKeys("savings");
		arp.savedReportUniqueName.sendKeys("2000");
		Thread.sleep(5000);
		arp.saveReportPopupWinButton.click();
		Thread.sleep(6000);
		arp.runReportPopupWinButton.click();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "savings ~ Salesforce - Developer Edition");
		
		
}
}