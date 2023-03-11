package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class CompletedPage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(xpath = "//div[@class='title']")
	private WebElement orderPlacedSuccessMessage;
	
	@FindBy(xpath = "//ul[@class='details']//li[1]")
	private WebElement orderNumber;
	
	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
	private WebElement orderComplete;
	
	
	
	public CompletedPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getOrderSuccessMessage() 
	{
		return commonUtility.getText(orderPlacedSuccessMessage);
	}
	
	public String getOrderNumber() 
	{
		return commonUtility.getText(orderNumber);
	}
	
	public void selectOrderComplete()
	{
		commonUtility.click(orderComplete);
	}

}
