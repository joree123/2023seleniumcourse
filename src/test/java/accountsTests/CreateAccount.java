package accountsTests;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.AccountsPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class CreateAccount extends BasicTest{


	
	@Test
	public void createUserAccount() throws InterruptedException, IOException {
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
		acp.createNewAccountButton.click();
		Thread.sleep(4000);
		acp.accountNameInputBox.sendKeys("Suprit Bahl");
		Select s=new Select(acp.selectAccountType);
		s.selectByVisibleText("Technology Partner");
		Select s1=new Select(acp.selectCumtomerPriority);
		s1.selectByVisibleText("High");
		acp.saveAccountButon.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.close();
		
		
}}
