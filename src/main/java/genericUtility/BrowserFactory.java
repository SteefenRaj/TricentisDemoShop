package genericUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {


	private WebDriver driver = null;

	public WebDriver initDriver() {

		String BROWSER = "chrome";
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			setCapabilitiesForChrome(BROWSER);
			
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			setCapabilitiesForFirefox(BROWSER);
			System.out.println(BROWSER + " browser is opened");
			
		} else {
			System.out.println("Please Enter Proper Browser Name");
		}
		
		return driver;
	}

	private void setCapabilitiesForChrome(String browser) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		driver = new ChromeDriver(options);
		System.out.println(browser + " browser is opened");
	}
	
	private void setCapabilitiesForFirefox(String browser) {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private");

		driver = new FirefoxDriver(options);
		System.out.println(browser + " browser is opened");
	}

}
