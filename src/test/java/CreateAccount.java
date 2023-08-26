import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class CreateAccount {

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
		driver.findElement(By.cssSelector("input[class='btn'][title='New']")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input#acc2")).sendKeys("Suprit Bahl");
		Select s=new Select(driver.findElement(By.cssSelector("select[id='acc6']")));
		s.selectByVisibleText("Technology Partner");
		Select s1=new Select(driver.findElement(By.cssSelector("select[id='00NHu00000PEMti']")));
		s1.selectByVisibleText("High");
		driver.findElement(By.cssSelector("#topButtonRow input[name='save']")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.close();
		
		
}}
