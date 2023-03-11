package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class DesktopPage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	

	
	@FindBy(xpath = "//h2[@class='product-title']//a[@href='/build-your-cheap-own-computer']")
	private WebElement clickOnProduct;
	
	public DesktopPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectingProduct()
	{
		commonUtility.click(clickOnProduct);
	}
	

}
