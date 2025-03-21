package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import genericLibrary.SelectUtility;

public class CheckoutPage extends BaseTest {
	
	@FindBy(xpath = "//select[@name='BillingNewAddress.CountryId']")
	private WebElement countrydropdown;
	
	@FindBy(xpath = "//input[@name='BillingNewAddress.City']")
	private WebElement cityTB;
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1TB;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement pincodeTB;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phonenoTB;
	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement billingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement shippingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement paymentInformationContinueButton;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement ConfirmOrderButton;
	@FindBy(xpath="//strong[text()='Your order has been successfully processed!']") private WebElement orderProcessText;
	@FindBy(id="billing-address-select") private WebElement billingAddressOldAddressDD;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCountrydropdown() {
		return countrydropdown;
	}



	public WebElement getCityTB() {
		return cityTB;
	}

	public WebElement getAddress1TB() {
		return address1TB;
	}

	public WebElement getPincodeTB() {
		return pincodeTB;
	}

	public WebElement getPhonenoTB() {
		return phonenoTB;
	}

	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}

	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInformationContinueButton() {
		return paymentInformationContinueButton;
	}

	public WebElement getConfirmOrderButton() {
		return ConfirmOrderButton;
	}

	public WebElement getOrderProcessText() {
		return orderProcessText;
	}

	public WebElement getBillingAddressOldAddressDD() {
		return billingAddressOldAddressDD;
	}

	// operational method
	public void buyProduct() throws EncryptedDocumentException, IOException {
		SelectUtility su = new SelectUtility();
		try
		{
		   if(billingAddressOldAddressDD.isDisplayed()==true)
		    {
		 	su.selectByVisibleTextMethod(billingAddressOldAddressDD, "New Address");
	     	}
		}
		catch(Exception e)
		{
		su.selectByVisibleTextMethod(countrydropdown, "India");
		}
		Flib flib = new Flib();
		int rn = flib.randomNumber();
		String city = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 0);
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 1);
		 long pin=flib.readExcelData1(EXCEL_PATH_MAIN,"buyproductdetails",1,2 );
		 long phone=flib.readExcelData1(EXCEL_PATH_MAIN,"buyproductdetails" , 1, 3);
		//String pin = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 2);
		//String phone = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);
        String phoneNo = phone + ""+ rn;
        
        cityTB.sendKeys(city);
        address1TB.sendKeys(address1);
        pincodeTB.sendKeys(String.valueOf(pin));
        phonenoTB.sendKeys(String.valueOf(phoneNo));
        billingAddressContinueButton.click();
        shippingAddressContinueButton.click();
        shippingMethodContinueButton.click();
        paymentMethodContinueButton.click();
        paymentInformationContinueButton.click();
        ConfirmOrderButton.click();
        
       SoftAssert sa = new SoftAssert();
       sa.assertEquals(orderProcessText.isDisplayed(), true, "order is not placed!!");
       sa.assertAll();
       
	}

}

	
	
	