package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import data.Constants;
import genericUtility.CommonUtility;

public class CheckoutOnePage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(xpath = "//select[@name='billing_address_id']")
	private WebElement billingAddress;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']/input[@type='button']")
	private WebElement billingContinue;
	
	@FindBy(xpath = "//select[@id = 'shipping-address-select']")
	private WebElement shippingAddress;
	
	@FindBy(xpath = "//div[@id='shipping-buttons-container']//descendant::input[@class='button-1 new-address-next-step-button']")
	private WebElement shippingContinue;
	
	@FindBy(xpath = "//label[text()='Next Day Air (0.00)']")
	private WebElement shippingMethod;
	
	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
	private WebElement shippingMethodContinue;
	
	@FindBy(xpath = "//label[text()='Cash On Delivery (COD) (7.00)']")
	private WebElement codButton;
	
	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
	private WebElement codContinue;
	
	@FindBy(xpath = "//p[text()='You will pay by COD']")
	private WebElement paymentInfo;
	
	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
	private WebElement paymentContinue;
	
	@FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
	private WebElement confirmOrderContinue;
	
	@FindBy(xpath = "//table[@class = 'cart-total']//tbody//tr[1]//td[2]//span[@class = 'product-price']")
	private WebElement subTotalAmt;
	
	
	public CheckoutOnePage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectBillingAddress(String value)
	{
		commonUtility.selectDropDownByValue(billingAddress, value);
	}
	
	public void selectBillingContinue()
	{
		commonUtility.click(billingContinue);
	}
	
	public void selectShippingAddress(String value)
	{
		commonUtility.selectDropDownByValue(shippingAddress, value);
	}
	
	public void selectShippingContinue()
	{
		commonUtility.click(shippingContinue);
	}
	
	public void selectNextDayAir()
	{
		commonUtility.click(shippingMethod);
	}
	
	public void selectShippingMethodContinue()
	{
		commonUtility.click(shippingMethodContinue);
	}
	
	public void selectCOD()
	{
		commonUtility.click(codButton);
	}
	
	public void selectPaymentMethodContinue()
	{
		commonUtility.click(codContinue);
	}
	
	public String getPaymentInfoText() 
	{
		return commonUtility.getText(paymentInfo);
	}
	
	public void selectPaymentInfoContinue()
	{
		commonUtility.click(paymentContinue);
	}
	
	public void selectConfirmOrderContinue()
	{
		commonUtility.click(confirmOrderContinue);
	}
	
	public String getSubTotalAmtText() {
		return commonUtility.getText(subTotalAmt);
	}
	
	public void shippingAndPaymentDetails(String address) {
		selectBillingAddress(address);
		commonUtility.waitForPageLoad(5);
		selectBillingContinue();
		
		selectShippingAddress(address);
		selectShippingContinue();
		
		selectNextDayAir();
		selectShippingMethodContinue();
		
		selectCOD();
		selectPaymentMethodContinue();
	}
	
	
	

}
