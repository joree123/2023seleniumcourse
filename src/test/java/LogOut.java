import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class LogOut {
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
		//String actualText=driver.findElement(By.id("userNav")).getAttribute("title");
		//String expectedText="User menu for joree Ghosh";
		//Assert.assertEquals(actualText, expectedText);
		
		driver.findElement(By.id("userNav")).click();
		WebElement e=driver.findElement(By.xpath("//div[@id='userNav-menuItems']"));
		List<WebElement> ls1=e.findElements(By.tagName("a"));
		String[] sa={"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
	    String[] actual=new String[5];
	    int i=0;
	for(WebElement ele:ls1) {
		actual[i++]=ele.getText();
	}
	Assert.assertTrue(Arrays.equals(sa, actual));
	//test case 06
	
		ls1.get(4).click();
		Thread.sleep(5000);
		String loginUrl=driver.getCurrentUrl();
		
		System.out.println(loginUrl);
	
	driver.close();
}}
