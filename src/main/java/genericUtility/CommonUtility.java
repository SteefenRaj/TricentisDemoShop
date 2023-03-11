package genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtility {

	WebDriverWait wait = null;
	private WebDriver webDriver;

	public CommonUtility(WebDriver driver) {

		if ((driver != null)) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(100l));
			webDriver = driver;
		}
	}

	public void selectByvisibleText(WebElement element, String vistext) {
		Select s = new Select(element);
		s.selectByVisibleText(vistext);
	}

	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int num) {
		Select s = new Select(element);
		s.selectByIndex(num);
	}

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20l));
	}

	public void waitForElementtobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20l));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void maximiseWin(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dissmisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point p = element.getLocation();
		js.executeScript("window.scrollBy(" + p + ")");
	}

	public void pressEnter() {
		Robot rc = null;
		try {
			rc = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}


	public void sendKeys(WebElement textBox, String value, WebDriver driver, String id, String data) {
		if (textBox.isEnabled()) {
			textBox.sendKeys(value);
		} else {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(" + id + ").value(" + data + ")");
		}
	}

	public int generateRandomInteger() {
		int randomNum = 999 + (int) (Math.random() * 1000);
		return randomNum;
	}

	public void selectDropDownByVisibleText(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	public void selectDropDownByValue(WebElement element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void selectDropDownByIndex(WebElement element, int index) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public void selectCheckbox(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		boolean checkstatus;
		checkstatus = element.isSelected();
		if (checkstatus != true) {
			element.click();
		}
	}

	public boolean validateUrl(String url) {
		boolean status = wait.until(ExpectedConditions.urlContains(url));
		return status;
	}

	public void unselectCheckbox(WebElement element) {
		boolean checkstatus;
		wait.until(ExpectedConditions.elementToBeClickable(element));
		checkstatus = element.isSelected();
		if (checkstatus == true) {
			element.click();
		}
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void sendKeys(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	public boolean isEnabled(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Boolean state = false;
		state = element.isEnabled();
		return state;
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void sendKeysWithoutClear(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public void sendKeys(WebElement element, int value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(String.valueOf(value));
	}

	public void sendKeys(WebElement element, boolean value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(String.valueOf(value));
	}

	public String getAttribute(WebElement element, String attributeName) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute(attributeName);
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public String getTitle() {
		return webDriver.getTitle();

	}

	public void explicitWait(String input, WebDriver driver, long second) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.urlContains(input));
	}

	public String getAlertText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public boolean isElementPresent(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	/**
	 * Method to wait for page load
	 *
	 * @param timeInSeconds
	 */
	public final boolean waitForPageLoad(int timeInSeconds) {
		boolean flag = false;
		String strBrowserState = "";
		int intTime = 0;
		try {
			while (!flag && intTime < timeInSeconds) {
				try {
					while (!((JavascriptExecutor) webDriver).executeScript("return navigator.onLine").toString()
							.toLowerCase().equals("true") && intTime <= timeInSeconds) {
						Thread.sleep(1000);
						intTime += 1;
					}
					flag = true;
				} catch (Exception e) {
					Thread.sleep(1000);
					intTime += 1;
					flag = false;
				}
			}
			flag = false;
			intTime = 0;
			while (!strBrowserState.toLowerCase().equals("complete") && intTime <= timeInSeconds) {
				Thread.sleep(1000);
				strBrowserState = ((JavascriptExecutor) webDriver).executeScript("return window.document.readyState")
						.toString();
				intTime += 1;
			}
			String strBrowserNavigatorState = "";
			strBrowserNavigatorState = ((JavascriptExecutor) webDriver).executeScript("return navigator.onLine")
					.toString().toLowerCase();
			if (!strBrowserState.toLowerCase().equals("complete") || !strBrowserNavigatorState.equals("true")) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementClickable(WebElement element) {
		try {
			element.click();
			return true;
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public BigDecimal roundDownTwoScale(String value) {
		BigDecimal bigValue = new BigDecimal(value);
		return bigValue.setScale(2);
	}
	
	public BigDecimal roundDownTwoScale(double value) {
		BigDecimal bigValue = new BigDecimal(value);
		return bigValue.setScale(2);
	}
}
