package accountsTests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.AccountsPage;
import pageObject.ViewPage;
import testResources.BasicTest;
import utils.CommonUtils;

public class EditNewView extends BasicTest {
	
	
	@Test
	public void editView() throws InterruptedException, IOException {
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
				
		Thread.sleep(5000);
		ViewPage vp=new ViewPage(driver);
		Select s=new Select(vp.accountViewList);
		s.selectByVisibleText("food");
		
		Thread.sleep(5000);
		
		vp.editViewLink.click();
		Thread.sleep(6000);
		vp.changeViewName.clear();;
		vp.changeViewName.sendKeys("food1");
		Select s1=new Select(vp.selectFilter);
		s1.selectByVisibleText("Account Name");
		Select s2=new Select(vp.selectOperator);
		s2.selectByVisibleText("contains");
		vp.selectValue.sendKeys("<a>");
		Thread.sleep(4000);
		vp.saveChangedViewButton.click();
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='pbBottmoButtons']//input[@title='Save']")).click();*/
		
		
}
}