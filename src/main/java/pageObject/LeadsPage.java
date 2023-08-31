package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
 public LeadsPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(css= "a.brandPrimaryFgr")
 public WebElement leadsLink;
 @FindBy(css= "select#fcf")
 public WebElement viewLeadsDropDown;
 @FindBy(xpath= "//span[@class='fBody']/input[@name='go']" )
 public WebElement goButton;
 @FindBy(css= "input[title='New']")
 public WebElement newButton;
 @FindBy(css= "input#name_lastlea2")
 public WebElement lastName;
 @FindBy(css= "input#lea3")
 public WebElement companyName;
 @FindBy(css= "input[title='Save']")
 public WebElement saveButton;
  
}
