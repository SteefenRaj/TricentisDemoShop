package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class LoginPage 
	{
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(className = "ico-login")
	private WebElement loginLink;
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginLink()
	{
		commonUtility.click(loginLink);
	}
	
	public void setEmail(String input)
	{
		commonUtility.sendKeys(email, input);
	}
	
	public void setPassword(String input)
	{
		commonUtility.sendKeys(password, input);
	}
	
	public void clickOnLoginButton()
	{
		commonUtility.click(loginButton);
	}
	
	public void loginWithCredentials(String email, String pwd) {
		clickOnLoginLink();
		setEmail(email);
		setPassword(pwd);
		clickOnLoginButton();
	}
	

}
