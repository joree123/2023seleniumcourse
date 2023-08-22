package testResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest {
WebDriver driver;
/*
 name of the method:setChromeDriver()
 Brief Description:initializing chrome driver
 Arguments:null
 Created by:
 Created Date: 
   
 */
	
public WebDriver setChromeDriver()
{
	WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
	return driver;
}


}
