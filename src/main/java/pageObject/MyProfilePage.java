package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
public MyProfilePage(WebDriver driver) 
{
PageFactory.initElements(driver, this);
	
}

@FindBy(css= "img[title='Edit Profile']")
public WebElement editProfileButton;

@FindBy(id= "contactInfoContentId")
public WebElement contactInfoContent;

@FindBy(css= "li#aboutTab")
public WebElement aboutTab;

@FindBy(css= "input[id='lastName']")
public WebElement lastNameBox;

@FindBy(css= "input.zen-btn.zen-primaryBtn.zen-pas")
public WebElement saveAllButton;

@FindBy(id= "tailBreadcrumbNode")
public WebElement changedNameText;

@FindBy(id= "publisherAttachTextPost")
public WebElement attachTextPostButton;

@FindBy(css= "iframe.cke_wysiwyg_frame.cke_reset")
public WebElement postTextFrame;

@FindBy(xpath= "//body")
public WebElement postTextFramebody;

@FindBy(id= "publishersharebutton")
public WebElement shareButton;

@FindBy(xpath= "//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")
public WebElement fileButton;

@FindBy(id= "chatterUploadFileAction")
public WebElement uploadFileButton;

@FindBy(id= "chatterFile")
public WebElement fileUploadBox;

@FindBy(id= "publishersharebutton")
public WebElement fileShareButton;

@FindBy(id= "displayBadge")
public WebElement profileImage;

@FindBy(css= "a#uploadLink")
public WebElement imageUploadLink;

@FindBy(css= "iframe#uploadPhotoContentId")
public WebElement photoUploadFrame;

@FindBy(css= "input.fileInput")
public WebElement picFileInputBox;

@FindBy(xpath= "//input[@type='submit'][2]")
public WebElement photoSaveButton;

 @FindBy(css= "div.imgCrop_handle.imgCrop_handleNW")
 public WebElement imageDragLine;

@FindBy(xpath= "//input[@value='Save']")
public WebElement profilePhotoSaveButton;

}
