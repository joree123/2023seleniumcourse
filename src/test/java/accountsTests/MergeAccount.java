package accountsTests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.AccountsPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class MergeAccount extends BasicTest {
	
	
	@Test
	public void mergeUserAccounts() throws InterruptedException, IOException {
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
		acp.mergeAccountsLink.click();
		acp.findAccountInputBox.sendKeys("suprit");
		
		acp.findAccountsButton.click();
		List<WebElement> ls=acp.foundAccountsList;
		int i=0;
		while(i<3 && i<ls.size()) {
		WebElement chk=ls.get(i).findElement(By.cssSelector("input#cid"+i));
		i++;
		if(!chk.isSelected()) {
			chk.click();
		}
	
		}
		acp.nextButton.click();
		acp.mergeAccountsButton.click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"Accounts: Home ~ Salesforce - Developer Edition");
		Assert.assertEquals(acp.mergedAccountName.getText(),"suprit");
}
}