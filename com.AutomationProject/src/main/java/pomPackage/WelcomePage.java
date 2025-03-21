package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	@FindBy(linkText="Register") private WebElement registerLink;
	@FindBy(linkText="Log in") private WebElement loginLink;
	@FindBy(xpath="//span[text()='Shopping cart']") private WebElement shoppingCart ;
	@FindBy(xpath="//span[text()='Wishlist']") private WebElement whishlistLink;
	@FindBy(partialLinkText="BOOKS") private WebElement bookLink;
	@FindBy(linkText="COMPUTERS") private WebElement computerLink;
	@FindBy(partialLinkText="ELECTRONICS") private WebElement electronicsLink;
	@FindBy(linkText="Log out") private WebElement logoutLink;
	
	//initialization
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//utilization

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public WebElement getWhishlistLink() {
		return whishlistLink;
	}

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getComputerLink() {
		return computerLink;
	}
	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	//operational method
	public void logout()
	{
		logoutLink.click();
	}
	
}
