import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class MergeAccount {
	WebDriver driver;
	@BeforeMethod
	public void launch() {
	BasicTest bs=new BasicTest();
	driver=bs.setChromeDriver();
	driver.get("https://netspace-dev-ed.develop.my.salesforce.com/");
	}
	
	@Test
	public void login() throws InterruptedException {
		//test case 05
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#username")).sendKeys("ashu@rediff.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("daivikashvik123");
		driver.findElement(By.cssSelector("#Login")).click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("li#Account_Tab a")).click();
		driver.findElement(By.xpath("//a[text()='Merge Accounts']")).click();
		driver.findElement(By.cssSelector("input#srch")).sendKeys("arun");
		
		driver.findElement(By.cssSelector("input[value='Find Accounts']")).click();
		List<WebElement> ls=driver.findElements(By.cssSelector("table.list tr[class*='dataRow']"));
		int i=0;
		while(i<3 && i<ls.size()) {
		WebElement chk=ls.get(i).findElement(By.cssSelector("input#cid"+i));
		i++;
		if(!chk.isSelected()) {
			chk.click();
		}
	
		}
		driver.findElement(By.xpath("//div[@class='pbTopButtons']/input[@name='goNext']")).click();
		driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"Accounts: Home ~ Salesforce - Developer Edition");
		Assert.assertEquals(driver.findElement(By.cssSelector("tr.dataRow.even.first th a")).getText(),"arun");
}
}