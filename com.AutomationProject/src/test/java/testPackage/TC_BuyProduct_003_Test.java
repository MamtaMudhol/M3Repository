package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomPackage.CheckoutPage;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListener.class)

public class TC_BuyProduct_003_Test extends BaseTest {
  @Test
  public void buyProductMethod() throws EncryptedDocumentException, IOException {
	 WelcomePage wp = new WelcomePage(driver);
	 wp.getElectronicsLink().click();
	 
	ElectronicsPage ep = new ElectronicsPage(driver);
	ep.getCellPhoneLink().click();
	ep.getSmartPhoneAddtocartButton().click();
	wp.getShoppingCart().click();
	
	ShoppingCartPage sp = new ShoppingCartPage(driver);
	sp.getSmartPhonecheckbox().click();
	sp.getTermsofServicescheckbox().click();
	sp.getCheckoutButton().click();
	
	CheckoutPage cp = new CheckoutPage(driver);
	cp.buyProduct();
	
	
	
	  
  }
}
