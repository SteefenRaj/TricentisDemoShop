package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class CartPage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(xpath = "//table[@class='cart']//tr[*]//input[@type='checkbox']")
	private List<WebElement> checkBoxs;
	
	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updateShoppingCart;

	@FindBy(xpath = "//div[@class='order-summary-content']")
	private WebElement emptyShoppingCart;
	
	@FindBy(xpath = "//ul[@class='top-menu']//a[@href='/computers']")
	private WebElement hoverOnComputers;

	@FindBy(xpath = "(//a[@href='/desktops'])[1]")
	private WebElement clickOnDesktops;
	
	@FindBy(xpath = "//td[@class='remove-from-cart']//input[@type='checkbox']")
	private WebElement productCheckBox;
	
	@FindBy(xpath = "//table[@class = 'cart-total']//tbody//tr[1]//td[2]//span[@class='product-price']")
	private WebElement subTotal;
	
	@FindBy(xpath = "//div[@class='terms-of-service']//descendant::input[@id='termsofservice']")
	private WebElement agreeButton;
	
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkOutButton;
	
	@FindBy(xpath = "//td[@class ='product' ]//div[@class = 'attributes']")
	private WebElement extraCharge;
	
	public CartPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getCheckBoxs() {
		return checkBoxs;
	}

	public void setCheckBoxs(List<WebElement> checkBoxs) {
		this.checkBoxs = checkBoxs;
	}
	
	public void clickOnUpdateShoppingKart()
	{
		commonUtility.click(updateShoppingCart);
	}
	
	public String getEmptyShoppingCart() {
		return commonUtility.getText(emptyShoppingCart);
	}
	
	public String getAdditionalCharges() {
		return commonUtility.getText(extraCharge);
	}
	
	public void selectingDesktops()
	{
		commonUtility.click(clickOnDesktops);
	}
	
	public void selectProductCheckBox()
	{
		commonUtility.click(productCheckBox);
	}
	
	public String getSubTotal()
	{
		return commonUtility.getText(subTotal);
	}
	
	public void agreeCheckBox()
	{
		commonUtility.selectCheckbox(agreeButton);
		selectCheckOutButton();
	}
	
	public void selectCheckOutButton()
	{
		commonUtility.click(checkOutButton);
	}

	public WebElement getHoverOnComputers() {
		return hoverOnComputers;
	}

	public void setHoverOnComputers(WebElement hoverOnComputers) {
		this.hoverOnComputers = hoverOnComputers;
	}


}
