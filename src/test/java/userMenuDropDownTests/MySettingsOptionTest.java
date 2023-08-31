package userMenuDropDownTests;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import loginToSalesForce.LoginToSalesForce;
import pageObject.BasePage;
import pageObject.MySettingsPage;
import pageObject.UserMenuPage;
import testResources.BasicTest;
import utils.CommonUtils;


public class MySettingsOptionTest extends BasicTest {
 
	@Test	
	public void checkMySettings() throws InterruptedException, IOException {
		
		WebDriver driver=BasicTest.getDriver();
		BasicTest.launchUrl();
		driver.manage().window().maximize();
		CommonUtils.waitForAllElements(driver);
		LoginToSalesForce loginTo=new LoginToSalesForce();
		loginTo.login();
		BasePage bp=new BasePage(driver);
		String fullName=bp.fullNameOfUser.getText();
		String[] name=fullName.split(" ");
		String firstName=name[0].trim();
		String lastName=name[1].trim();
		
		Thread.sleep(6000);
		UserMenuPage ump=new UserMenuPage(driver);
		String actualText=ump.userMenuText.getAttribute("title");
		String expectedText="User menu for "+firstName+" "+lastName;
		AssertJUnit.assertEquals(actualText, expectedText);
		Boolean flag=CommonUtils.waitForElement(driver, ump.userMenuButton);
		if(flag==true)
		{
			ump.userMenuButton.click();
		}
						
		List<WebElement> menuItems=ump.userMenuItems;
		
		//clicking "My Settings " 2nd  option
		menuItems.get(1).click();
		
		Thread.sleep(6000);
		MySettingsPage msp=new MySettingsPage(driver);
		
	msp.personalInfo.click();
	msp.loginHistoryInfo.click();
	msp.downloadLoginHistory.click();
	System.out.println("login history is displayed");
	Thread.sleep(6000);
	//display and layout link
	msp.dispalayAndLayout.click();
	msp.customizeTab.click();
	
	WebElement s1=msp.selectOptions;
	Select select1=new Select(s1);
	select1.selectByVisibleText("Salesforce Chatter");
	//Select select2=new Select(driver.findElement(By.cssSelector("select#duel_select_0")));
	//select2.selectByVisibleText("Reports");
	msp.selectReportsTab.click();

	
	/*Select select3=new Select(driver.findElement(By.cssSelector("select#duel_select_1")));
	if(select3.equals(driver.findElement(By.cssSelector("option[value='report']"))))
	{
		System.out.println("Report displayed in List");
	}*/
	msp.addOption.click();
	//email link;
	Thread.sleep(6000);
	msp.emailLink.click();
	msp.myEmailSettings.click();
	
	msp.setEmailName.clear();;
	msp.setEmailName.sendKeys("Joree Ghosh");
		
	msp.setEmailAddress.clear();
	msp.setEmailAddress.sendKeys("joree123@gmail.com");
	msp.bccRadioButton.click();
	msp.saveEmailButton.click();
	String actualMessage=msp.changeSettingMessage.getText();
	Assert.assertEquals(actualMessage,"Your settings have been successfully saved." );
	System.out.println(driver.getTitle());
	
	//calender and remainder link
	msp.calendersAndReminders.click();
	msp.activityRemindersLink.click();
	msp.testReminderButton.click();
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