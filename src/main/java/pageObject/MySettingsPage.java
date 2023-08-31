package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySettingsPage {
 
	public MySettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	}
	
	@FindBy(css= "#PersonalInfo a.header.setupFolder")
	public WebElement personalInfo;
	
	@FindBy(css= "a[id=LoginHistory_font]")
	public WebElement loginHistoryInfo;
	
	@FindBy(css= "div.pShowMore a")
	public WebElement downloadLoginHistory;
	
	
	@FindBy(css= "#DisplayAndLayout a.header.setupFolder")
	public WebElement dispalayAndLayout;
	
	
	@FindBy(css= "a[id=CustomizeTabs_font]")
	public WebElement customizeTab;
	
	@FindBy(css= "select#p4")
	public WebElement selectOptions;
	
	
	@FindBy(id="duel_select_0_right" )
	public WebElement selectReportsTab;
	
	
	@FindBy(css="input.btn.primary" )
	public WebElement addOption;
	
	@FindBy(css="[id='EmailSetup'] a[class='header setupFolder']" )
	public WebElement emailLink;
	
	@FindBy(css="a[id='EmailSettings_font']" )
	public WebElement myEmailSettings;
	
	@FindBy(css= "input[id='sender_name']")
	public WebElement setEmailName;
	
	@FindBy(css= "input[id='sender_email']" )
	public WebElement setEmailAddress;
		
	@FindBy(css= "input#auto_bcc1" )
	public WebElement bccRadioButton;
	
	@FindBy(css= "input.btn.primary" )
	public WebElement saveEmailButton;
	
	@FindBy(css="div.messageText" )
	public WebElement changeSettingMessage;
	
	@FindBy(css= "[id='CalendarAndReminders'] a.header.setupFolder" )
	public WebElement calendersAndReminders;
	
	@FindBy(css= "a[id='Reminders_font']" )
	public WebElement activityRemindersLink;
	
	@FindBy(id= "testbtn" )
	public WebElement testReminderButton;
	
	
	
	
	
	
}
