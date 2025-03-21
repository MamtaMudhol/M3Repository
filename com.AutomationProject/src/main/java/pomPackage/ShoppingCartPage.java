package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath="//h1[text()='Shopping cart']/../..//img[@title='Show details for smartphone']") private WebElement smartPhoneCartProduct;
	@FindBy(xpath="//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']/../..//input[@name='removefromcart']")
	                               private WebElement smartPhonecheckbox;
	@FindBy(name="updatecart") private WebElement updateShoppingCartButton;
	@FindBy(name="continueshopping") private WebElement continueShoppingButton;
	@FindBy(id="termsofservice") private WebElement termsofServicescheckbox;
	@FindBy(id="checkout") private WebElement checkoutButton;
	

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSmartPhoneCartProduct() {
		return smartPhoneCartProduct;
	}


	public WebElement getSmartPhonecheckbox() {
		return smartPhonecheckbox;
	}


	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}


	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}


	public WebElement getTermsofServicescheckbox() {
		return termsofServicescheckbox;
	}


	public WebElement getCheckoutButton() {
		return checkoutButton;
	}


	

}
