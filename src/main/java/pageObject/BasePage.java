package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
public BasePage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}

@FindBy(css= "div#userNavButton")
public WebElement userMenuButton;

@FindBy(id= "userNavLabel")
public WebElement fullNameOfUser;




}
