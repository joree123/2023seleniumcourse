import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class DeveloperConsole {
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
		
		
		
		driver.findElement(By.id("userNav")).click();
		WebElement e=driver.findElement(By.xpath("//div[@id='userNav-menuItems']"));
		List<WebElement> ls1=e.findElements(By.tagName("a"));
			
		ls1.get(2).click();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> is=s.iterator();
		String main=is.next();
		String dconsole=is.next();
		driver.switchTo().window(dconsole);
		Thread.sleep(5000);
		driver.close();
		
		
	}}

