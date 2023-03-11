package endToEnd;

import java.math.BigDecimal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.Constants;
import fileUtilities.PropertyUtility;
import genericUtility.BaseClass;
import genericUtility.CommonUtility;
import pages.CartPage;
import pages.CompletedPage;
import pages.DesktopPage;
import pages.DesktopProductPage;
import pages.HomePage;
import pages.LoginPage;
import pages.CheckoutOnePage;

public class PlaceTheOrder extends BaseClass {
	
	PropertyUtility propertyUtility = new PropertyUtility();
	ThreadLocal<WebDriver> driver =new ThreadLocal<>();
	
	@BeforeMethod
	public void init() 
	{
		driver.set(launchBrowser());
	}


	@Test(description = "Login - Select Item - Add To Cart - CheckOut - Billing Address - Payment as COD - Confirmation Message - Printing the Order Number")
	public void placeTheOrderwithCODPayment()
	{
		CommonUtility commonUtility = new CommonUtility(driver.get());
		LoginPage loginPage = new LoginPage(driver.get());
		HomePage homePage = new HomePage(driver.get());
		CartPage cartPage = new CartPage(driver.get());
		DesktopPage desktopPage = new DesktopPage(driver.get());
		DesktopProductPage desktopProductPage = new DesktopProductPage(driver.get());
		CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver.get());
		CompletedPage completedPage = new CompletedPage(driver.get());
		int quantity = 3;
		
		loginPage.loginWithCredentials(propertyUtility.getValue("EMAIL"), propertyUtility.getValue("PASSWORD"));
		Assert.assertEquals(homePage.getUserAccountText(), propertyUtility.getValue("EMAIL"));

		String cartItemsCount = homePage.getShoppingCartItemsCount();
		homePage.clickOnShoppingKart();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("CART_URL")));
		
		if(cartItemsCount.equalsIgnoreCase("0")) {
			Assert.assertEquals(cartPage.getEmptyShoppingCart(), Constants.EMPTY_CART_MSG);
		} else {
			for(WebElement checkbox: cartPage.getCheckBoxs()) {
				checkbox.click();
				cartPage.clickOnUpdateShoppingKart();
				Assert.assertEquals(cartPage.getEmptyShoppingCart(), Constants.EMPTY_CART_MSG);
			}
		}
		
		commonUtility.mouseHover(driver.get(), cartPage.getHoverOnComputers());
		cartPage.selectingDesktops();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("DESKTOP_URL")));
		
		desktopPage.selectingProduct();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("PRODUCT_URL")));
		
		double priceDetails = Double.parseDouble(desktopProductPage.getPriceDetails());
		System.out.println("Product Price Details : "+priceDetails);

		desktopProductPage.enterQuantity(quantity);
		Assert.assertEquals(desktopProductPage.getSuccessMessage(), Constants.PRODUCT_ADDED_SUCCESS);

		
		desktopProductPage.clickOnShoppingKart();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("CART_URL")));
		
		String[] data = cartPage.getAdditionalCharges().split(" ");
		double extra = Double.parseDouble(data[2].substring(2, 7));
		
		BigDecimal finalSubTotal = commonUtility.roundDownTwoScale((priceDetails + extra) * quantity);
		System.out.println("finalSubTotal: " + finalSubTotal);
		
		BigDecimal subTotal = commonUtility.roundDownTwoScale(cartPage.getSubTotal());
		Assert.assertEquals(subTotal, finalSubTotal);
		
		cartPage.agreeCheckBox();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("CHECKOUT_URL")));
		
		checkoutOnePage.shippingAndPaymentDetails(Constants.MY_ADDRESS);
		Assert.assertEquals(checkoutOnePage.getPaymentInfoText(), Constants.COD_PAYMENT_MSG);
		
		checkoutOnePage.selectPaymentInfoContinue();
		BigDecimal desiredSubTotal = commonUtility.roundDownTwoScale(checkoutOnePage.getSubTotalAmtText());
		System.out.println("Total product price final: " + desiredSubTotal);
		Assert.assertEquals(subTotal, desiredSubTotal);
		
		checkoutOnePage.selectConfirmOrderContinue();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("COMPLETED_URL")));
		
		Assert.assertEquals(completedPage.getOrderSuccessMessage(), Constants.ORDER_CONFIRM_MSG);
		System.out.println(completedPage.getOrderNumber());
		
		completedPage.selectOrderComplete();
		homePage.clickOnLogOut();
		Assert.assertTrue(commonUtility.validateUrl(propertyUtility.getValue("URL")));
	}

}
