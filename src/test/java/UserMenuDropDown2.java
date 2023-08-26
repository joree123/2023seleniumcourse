import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class UserMenuDropDown2 {
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
			
		ls1.get(1).click();
		
	driver.findElement(By.cssSelector("#PersonalInfo a.header.setupFolder")).click();
	driver.findElement(By.cssSelector("a[id=LoginHistory_font]")).click();
	driver.findElement(By.cssSelector("div.pShowMore a")).click();
	System.out.println("login history is displayed");
	Thread.sleep(6000);
	//display and layout link
	driver.findElement(By.cssSelector("#DisplayAndLayout a.header.setupFolder")).click();
	driver.findElement(By.cssSelector("a[id=CustomizeTabs_font]")).click();
	
	WebElement s1=driver.findElement(By.cssSelector("select#p4"));
	Select select1=new Select(s1);
	select1.selectByVisibleText("Salesforce Chatter");
	//Select select2=new Select(driver.findElement(By.cssSelector("select#duel_select_0")));
	//select2.selectByVisibleText("Reports");
	driver.findElement(By.id("duel_select_0_right")).click();

	
	/*Select select3=new Select(driver.findElement(By.cssSelector("select#duel_select_1")));
	if(select3.equals(driver.findElement(By.cssSelector("option[value='report']"))))
	{
		System.out.println("Report displayed in List");
	}*/
	driver.findElement(By.cssSelector("input.btn.primary")).click();
	//email link;
	Thread.sleep(6000);
	driver.findElement(By.cssSelector("[id='EmailSetup'] a[class='header setupFolder']")).click();
	driver.findElement(By.cssSelector("a[id='EmailSettings_font']")).click();
	
	driver.findElement(By.cssSelector("input[id='sender_name']")).clear();
	driver.findElement(By.cssSelector("input[id='sender_name']")).sendKeys("Joree Ghosh");
		
	driver.findElement(By.cssSelector("input[id='sender_email']")).clear();
	driver.findElement(By.cssSelector("input[id='sender_email']")).sendKeys("joree123@gmail.com");
	driver.findElement(By.cssSelector("input#auto_bcc1")).click();
	driver.findElement(By.cssSelector("input.btn.primary")).click();
	String actualMessage=driver.findElement(By.cssSelector("div.messageText")).getText();
	Assert.assertEquals(actualMessage,"Your settings have been successfully saved." );
	System.out.println(driver.getTitle());
	
	//calender and remainder link
	driver.findElement(By.cssSelector("[id='CalendarAndReminders'] a.header.setupFolder")).click();
	driver.findElement(By.cssSelector("a[id='Reminders_font']")).click();
	driver.findElement(By.id("testbtn")).click();
	Thread.sleep(3000);
	Set<String> win=driver.getWindowHandles();
	java.util.Iterator<String> is=win.iterator();
	String parentId=is.next();
	String childId=is.next();
	driver.switchTo().window(childId);
	Thread.sleep(5000);
	System.out.println(driver.getCurrentUrl());
	
	driver.switchTo().window(parentId);
	Thread.sleep(5000);
	
	driver.quit();
	
	}
}