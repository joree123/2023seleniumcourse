package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPage {
	public AllPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(css= "li#AllTab_Tab a")
public WebElement allTab;

@FindBy(css= "input.btnImportant")
public WebElement customizeMyTabLink;
@FindBy(css= "select#duel_select_0")
public WebElement selectAvailableTabs;
@FindBy(css= "select#duel_select_1")
public WebElement selectSelectedTabs;
@FindBy(css= "a#duel_select_0_left")
public WebElement removeTabButton;
@FindBy(css= "input[title='Save']")
public WebElement saveTabButton;
@FindBy(css= "select#p1")
public WebElement viewTabsDropDown;
}
