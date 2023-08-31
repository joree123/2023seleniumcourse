package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
 public AccountsPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(css= "li#Account_Tab a")
 public WebElement accountsLink;
 
 @FindBy(css= "input[class='btn'][title='New']")
 public WebElement createNewAccountButton;
 
 @FindBy(css= "input#acc2")
 public WebElement accountNameInputBox;
 
 @FindBy(css= "select[id='acc6']")
 public WebElement selectAccountType;
 
 @FindBy(css= "select[id='00NHu00000PEMti']")
 public WebElement selectCumtomerPriority;
 
 @FindBy(css= "#topButtonRow input[name='save']")
 public WebElement saveAccountButon;
 
 
 @FindBy(xpath= "//a[text()='Merge Accounts']")
 public WebElement mergeAccountsLink;
 @FindBy(css= "input#srch" )
 public WebElement findAccountInputBox;
 @FindBy(css= "input[value='Find Accounts']")
 public WebElement findAccountsButton;
 @FindBy(css= "table.list tr[class*='dataRow']")
 public List<WebElement> foundAccountsList;
 
 @FindBy(xpath= "//div[@class='pbTopButtons']/input[@name='goNext']")
 public WebElement nextButton;
 @FindBy(xpath= "//div[@class='pbTopButtons']//input[@title='Merge']")
 public WebElement mergeAccountsButton;
 @FindBy(css= "tr.dataRow.even.first th a")
 public WebElement mergedAccountName;
 
 

}
