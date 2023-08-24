import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testResources.BasicTest;

public class UserMenuDropDown1 {
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
		String actualText=driver.findElement(By.id("userNav")).getAttribute("title");
		String expectedText="User menu for joree Ghosh";
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
	
		ls1.get(0).click();
	
	
	//String actualTitle=driver.getTitle();
	//String expectedTitle="User: joree Ghosh ~ Salesforce - Developer Edition";
	//Assert.assertEquals(actualTitle, expectedTitle);
	driver.findElement(By.cssSelector("img[title='Edit Profile']")).click();
	
	WebElement profileWindow=driver.findElement(By.id("contactInfoContentId"));
	driver.switchTo().frame(profileWindow);
	driver.findElement(By.cssSelector("li#aboutTab")).click();
	
	driver.findElement(By.cssSelector("input[id='lastName']")).clear();
	driver.findElement(By.cssSelector("input[id='lastName']")).sendKeys("Banerjee");
	driver.findElement(By.cssSelector("input.zen-btn.zen-primaryBtn.zen-pas")).click();

	String fullName=driver.findElement(By.id("tailBreadcrumbNode")).getText();
	if(fullName.contains("Banerjee"))
	{
		System.out.println("last name updated");
	}
	
	
		driver.findElement(By.id("publisherAttachTextPost")).click();
		WebElement postFrame=driver.findElement(By.cssSelector("iframe.cke_wysiwyg_frame.cke_reset"));
		driver.switchTo().frame(postFrame);
		driver.findElement(By.xpath("//body")).sendKeys("done it");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("publishersharebutton")).click();
		Thread.sleep(7000);
		
		//uploading a file
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		driver.findElement(By.id("chatterUploadFileAction")).click();
		System.out.println("choose file from computer");
		
		driver.findElement(By.id("chatterFile")).sendKeys("C:\\Users\\ashvi\\OneDrive\\Documents\\book 2.xlsx");
		driver.findElement(By.id("publishersharebutton")).click();
		
		//uploading the image
		WebElement image=driver.findElement(By.id("displayBadge"));
		Actions a=new Actions(driver);
		a.moveToElement(image).build().perform();
		
		
		
		//driver.findElement(By.id("chatterUploadFileAction")).click()
		//driver.findElement(By.id("chatterUploadFileAction")).click()
	}
	

	
	
	
	
	
	//@AfterMethod
	//public void close() {
	//	driver.close();	
	//}
	
}
