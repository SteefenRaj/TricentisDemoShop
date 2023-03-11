package genericUtility;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//singleton design pattern
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
	}
	
	//factory design pattern
	ThreadLocal<WebDriver> tcdriver = new ThreadLocal();

	public void setDriver(WebDriver driver) {
		tcdriver.set(driver);
	} 
	
	public WebDriver getDriver() {
		return tcdriver.get();
	}
	
	public void closeBrowser() {
		tcdriver.get().quit();
		tcdriver.remove();
	}
}
