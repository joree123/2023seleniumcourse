package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
 public OpportunitiesPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(css= "a[title='Opportunities Tab']")
 public WebElement OpportunitiesLink;
 
 @FindBy(css= "select#fcf")
 public WebElement OpportunitiesDropDown;
 @FindBy(css= "input[name='new']")
 public WebElement newButton;
 @FindBy(css= "input#opp3")
 public WebElement OpportunityName;
 @FindBy(css= "input#opp4")
 public WebElement OpportunityAccName;
 @FindBy(css= "input#opp9")
 public WebElement opCloseDate;
 @FindBy(css= "input#opp10")
 public WebElement opNextStep;
 @FindBy(css= "select#opp11")
 public WebElement opStage;
 @FindBy(css= "input#opp12")
 public WebElement opProbability ;
 @FindBy(css= "input#opp17")
 public WebElement opPrimaryCampaignSrc;
 @FindBy(css= "input[name='save']")
 public WebElement saveButton;
 @FindBy(xpath= "//a[text()='Opportunity Pipeline']")
 public WebElement opPipeLineLink;
 @FindBy(css= "//a[text()='Stuck Opportunities']")
 public WebElement opStuckLink;
 @FindBy(css= "select#quarter_q")
 public WebElement quarterlySummaryInterval;
 @FindBy(css= "select#open")
 public WebElement quarterlySummaryOpportunities;
 
 
 
 
 
}
