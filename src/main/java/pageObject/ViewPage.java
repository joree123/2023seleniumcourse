package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPage {
	public ViewPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
 @FindBy(linkText= "Create New View")
 public WebElement createViewLink;
	
 @FindBy(css= "input#fname")
 public WebElement viewNameInput;	
 
 @FindBy(css= "input#devname")
 public WebElement uniqueViewNameInput;

 @FindBy(xpath= "//div[@class='pbHeader']// input[1]")
 public WebElement saveViewButton;
 
 @FindBy(css= "select.title")
 public WebElement showNewViewList;
 
 @FindBy(css= "select#fcf")
 public WebElement accountViewList;
 
 @FindBy(xpath= "//a[text()='Edit']")
 public WebElement editViewLink;
 
 @FindBy(css= "input#fname")
 public WebElement changeViewName;
 
 @FindBy(css= "select#fcol1")
 public WebElement selectFilter;
 @FindBy(css= "select#fop1")
 public WebElement selectOperator;
 @FindBy(css= "input#fval1" )
 public WebElement selectValue;
 @FindBy(xpath= "//div[@class='pbHeader']// input[1]")
 public WebElement saveChangedViewButton; 
 
 @FindBy(xpath= "//input[@value='Cancel']")
 public WebElement cancelViewButton;
 
}
