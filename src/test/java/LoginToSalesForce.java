import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class LoginToSalesForce  {
	WebDriver driver;
	

	@Test(enabled=false)
	public void login() {
							
		driver.findElement(By.cssSelector("#username")).sendKeys("ashu@rediff.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("daivikashvik123");
		driver.findElement(By.cssSelector("#Login")).click();
		System.out.println(driver.getCurrentUrl());
		
	}
	@Test(enabled=false)
	public void loginErrorMessage()
	{
						
		driver.findElement(By.cssSelector("#username")).sendKeys("ashu@rediff.com");
		driver.findElement(By.cssSelector("#password")).clear();
		driver.findElement(By.cssSelector("#Login")).click();
		String actual=driver.findElement(By.cssSelector("#error")).getText();
		Assert.assertEquals(actual, "Please enter your password.");
		
	}
	@Test(enabled=false)
	public void checkRememberMe() throws InterruptedException {
		
		driver.findElement(By.cssSelector("#username")).sendKeys("ashu@rediff.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("daivikashvik123");
		driver.findElement(By.cssSelector("#rememberUn")).click();
		driver.findElement(By.cssSelector("#Login")).click();
		driver.findElement(By.cssSelector("#userNavLabel")).click();
		
		driver.findElement(By.cssSelector("*[title='Logout']")).click();
		Thread.sleep(2000);
		String userName=driver.findElement(By.cssSelector("#idcard-identity")).getText();
		Assert.assertEquals(userName, "ashu@rediff.com");
		
				
	}
	@Test
	public void forgotPassword() {
		driver.findElement(By.cssSelector("*[id*='forgot_password']")).click();
		driver.findElement(By.cssSelector("#un")).sendKeys("ashu@rediff.com");
		driver.findElement(By.cssSelector("#continue")).click();
		String message=driver.findElement(By.cssSelector("div.message")).getText();
		System.out.println(message);
		
		
	}
	@Test
	public void forgotUnamePass() {
		
driver.findElement(By.cssSelector("#username")).sendKeys("ashu@rediff1.com");
driver.findElement(By.cssSelector("#password")).sendKeys("acd");
driver.findElement(By.cssSelector("#Login")).click();
String actual=driver.findElement(By.cssSelector("#error")).getText();
Assert.assertEquals(actual, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}
	
	@BeforeMethod
	public void launch() {
	BasicTest bs=new BasicTest();
	driver=bs.setChromeDriver();
	driver.get("https://netspace-dev-ed.develop.my.salesforce.com/");
	}
	@AfterMethod
	public void close() {
		driver.close();
			

}
	}
