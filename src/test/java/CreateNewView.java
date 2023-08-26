import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;
public class CreateNewView{
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
		
		driver.findElement(By.linkText("Create New View")).click();
		driver.findElement(By.cssSelector("input#fname")).sendKeys("nature");
		driver.findElement(By.cssSelector("input#devname")).sendKeys("forest");
		driver.findElement(By.xpath("//div[@class='pbHeader']// input[1]")).click();
		Select s=new Select(driver.findElement(By.cssSelector("select.title")));
		Assert.assertEquals(s.getFirstSelectedOption().getText(),"nature");
		
		
	
}
}