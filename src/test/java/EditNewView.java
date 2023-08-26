import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class EditNewView {
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
		Thread.sleep(5000);
		Select s=new Select(driver.findElement(By.cssSelector("select#fcf")));
		s.selectByVisibleText("nature");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='bFilterView']// a[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("input#fname")).clear();
		driver.findElement(By.cssSelector("input#fname")).sendKeys("food");
		Select s1=new Select(driver.findElement(By.cssSelector("select#fcol1")));
		s1.selectByVisibleText("Account Name");
		Select s2=new Select(driver.findElement(By.cssSelector("select#fop1")));
		s2.selectByVisibleText("contains");
		driver.findElement(By.cssSelector("input#fval1")).sendKeys("<a>");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='pbHeader']// input[1]")).click();
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='pbBottmoButtons']//input[@title='Save']")).click();*/
		
		
}
}