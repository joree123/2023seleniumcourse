package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsReportPage {
	public AccountsReportPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	@FindBy(xpath= "//div[@class='lbBody']//li[2]/a")
	 public WebElement accountsLinkGreaterThan30Days;
	 @FindBy(css= "input#ext-gen20")
	 public WebElement dateFieldDropDown;
	 @FindBy(xpath= "//div[@class='x-combo-list-item'][2]")
	 public WebElement createDateOPtion;
	 @FindBy(css= "input#ext-comp-1042")
	 public WebElement fromDateField;
	 @FindBy(css= "input#ext-comp-1045")
	 public WebElement toDateField;
	 @FindBy(css= "button#ext-gen49" )
	 public WebElement saveAccountReportButton;
	 @FindBy(css= "input#saveReportDlg_reportNameField")
	 public WebElement savedReportName;
	 @FindBy(css= "input#saveReportDlg_DeveloperName")
	 public WebElement savedReportUniqueName;
	 @FindBy(xpath= "//table[@id='dlgSaveReport']//button[text()='Save']")
	 public WebElement saveReportPopupWinButton;
	 @FindBy(xpath= "//button[@class=' x-btn-text run-report-btn-icon']")
	 public WebElement runReportPopupWinButton;

	
	
	
	
	
	
	
	
	
	
	
	
	
}
