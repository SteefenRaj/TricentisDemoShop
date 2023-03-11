package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class HomePage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(xpath = "//div[@class='header-links-wrapper']//a[@class='account']")
	private WebElement userAccountId;
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//a[@class='ico-cart']//span[@class = 'cart-qty']")
	private WebElement shoppingCartItems;
	
	@FindBy(className = "ico-logout")
	private WebElement logOut;
	
	public HomePage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getUserAccountText() {
		return commonUtility.getText(userAccountId);
	}
	
	public void clickOnShoppingKart()
	{
		commonUtility.click(shoppingCart);
	}
	
	public void clickOnLogOut()
	{
		commonUtility.click(logOut);
	}
	
	public String getShoppingCartItemsCount() {
		return commonUtility.getText(shoppingCartItems);
	}
	

}
