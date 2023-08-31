package testResources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.FileUtilities;

public class BasicTest {
//	Requirements
//	Cross browser support
//	Parallel support -
//	Proper reporting - Accurate Assertion, Screenshots
//	Support of Logs in the framework
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	@BeforeTest
	public static void setDriver() {
		WebDriver driver = BasicTest.getBrowserType("chrome", true);
		threadLocalDriver.set(driver);
	}
	
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	
	@AfterTest
	public static void removeDriver() {
		
		getDriver().close();
		threadLocalDriver.remove();
	}
	
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		WebDriver driver;
		String browserType = browserName.toLowerCase();
		switch (browserType) {
		case "chrome":
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;	
			
		case "egde":
			driver = new EdgeDriver();
			break;
					
		default:
			driver = null;
			break;
		}
		
		return driver;
	}
    //will remove later launchUrl
	public static void launchUrl() throws IOException
	{
		WebDriver driver=BasicTest.getDriver();
		driver.get(FileUtilities.readPropertiesFile("/src/main/resources/testdata/file1.properties", "prod.url"));
	}
	
}

