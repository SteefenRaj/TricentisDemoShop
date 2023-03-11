package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import fileUtilities.PropertyUtility;

public class BaseClass {
	
	BrowserFactory browserFactory = new BrowserFactory();
	public static WebDriver driver;
	public PropertyUtility propertyUtility = new PropertyUtility();
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("Connect to Data Base");
	}
	
	public WebDriver launchBrowser() {
		DriverFactory.getInstance().setDriver(browserFactory.initDriver());
		WebDriver driver = DriverFactory.getInstance().getDriver();
		
		driver.get(propertyUtility.getValue("URL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		
		DriverFactory.getInstance().closeBrowser();
		System.out.println("Browser is closed");
	}
	
	@AfterSuite
	public void closeDB() {
	
		System.out.println("Close Data Base");
		
	}

}