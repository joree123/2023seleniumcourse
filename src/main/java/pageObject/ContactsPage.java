package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
public ContactsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(css= "a[title='Contacts Tab']")
public WebElement contactsTab;

@FindBy(css= "input[name='new']")
public WebElement newButton;

@FindBy(css= "input[id='name_lastcon2']")
public WebElement lastNameInput;

@FindBy(css= "input#con4")
public WebElement accountNameInput;

@FindBy(css= "input[title='Save']")
public WebElement saveContactsButton;

@FindBy(css= "select#hotlist_mode")
public WebElement selectRecentlyContacts;

@FindBy(css= "select#fcf")
public WebElement selectContacts;

@FindBy(css= "th.dataCell  ")
public WebElement contactUnderName;

@FindBy(css= "input[value='Save & New']")
public WebElement saveAndNewButton;

}
