import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class AccountReport {
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
		driver.findElement(By.xpath("//div[@class='lbBody']//li[2]/a")).click();
		
		driver.findElement(By.cssSelector("input#ext-gen20")).click();
		driver.findElement(By.xpath("//div[@class='x-combo-list-item'][2]")).click();
		Date date=new Date();
		SimpleDateFormat sdate=new SimpleDateFormat("M/d/yyyy");
		driver.findElement(By.cssSelector("input#ext-comp-1042")).sendKeys(sdate.format(date));
		driver.findElement(By.cssSelector("input#ext-comp-1045")).clear();
		driver.findElement(By.cssSelector("input#ext-comp-1045")).sendKeys(sdate.format(date));
		driver.findElement(By.cssSelector("button#ext-gen49")).click();
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("input#saveReportDlg_reportNameField")).sendKeys("savings");
		driver.findElement(By.cssSelector("input#saveReportDlg_DeveloperName")).sendKeys("2000");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='dlgSaveReport']//button[text()='Save']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@class=' x-btn-text run-report-btn-icon']")).click();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "savings ~ Salesforce - Developer Edition");
		
		
}
}