package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class DesktopProductPage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(className = "price-value-72")
	private WebElement priceDetail;
	
	@FindBy(xpath = "//div[@class='add-to-cart-panel']//descendant::input[@id='addtocart_72_EnteredQuantity']")
	private WebElement quantity;
	
	@FindBy(xpath =  "//div[@class='add-to-cart-panel']//descendant::input[@id='add-to-cart-button-72']")
	private WebElement cart;
	
	@FindBy(xpath = "//p[text()='The product has been added to your ']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//label[@for = 'product_attribute_72_5_18_53']")
	private WebElement productMedium;
	
	public DesktopProductPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getProductMediumText() {
		return commonUtility.getText(productMedium);
	}
	
	public String getPriceDetails() {
		return commonUtility.getText(priceDetail);
	}
	
	public void enterQuantity(int input)
	{
		commonUtility.sendKeys(quantity, input);
		commonUtility.click(cart);
	}
	
	public String getSuccessMessage()
	{
		return commonUtility.getText(successMessage);
	}
	
	public void clickOnShoppingKart()
	{
		commonUtility.scrollToTop();
		commonUtility.click(shoppingCart);
	}

}
