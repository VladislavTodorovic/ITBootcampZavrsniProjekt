package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShoppingTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        swagsLabsSidebar = new SwagsLabsSidebar(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        checkoutStepOnePage = new CheckoutStepOnePage(driver, wait);
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver, wait);
        checkoutCompletePage = new CheckoutCompletePage(driver, wait);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test (priority = 10)
    public void shoppingNoBacksTest(){
        userLogin();
    Assert.assertEquals(inventoryPage.getTitleProducts().getText(), "Products");
    Assert.assertTrue(inventoryPage.getProductSortContainer().isDisplayed());
    Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed());
    //1. Dodavanje 5 proizvoda u korpu:
        inventoryPage.getBackpackAddToCartButton().click();
        inventoryPage.getBikeLightAddToCartButton().click();
        inventoryPage.getBoltTSHirtAddToCartButton().click();
        inventoryPage.getFleeceJacketAddtoCartButton().click();
        inventoryPage.getOnesieAddtoCartButton().click();
        Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "5");
    //2. Uklanjanje 1 proizvoda iz korpe:
        inventoryPage.getBackpackRemoveButton().click();
        Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "4");
    //3. Odlazak na CartPage:
        swagsLabsSidebar.getCartIcon().click();
    //4. Uklanjanje 1 proizvoda iz korpe na CartPage:
        Assert.assertEquals(cartPage.getTitleYourCart().getText(), "Your Cart");
        Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
        cartPage.getBikeLightRemoveCartButton().click();
        Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "3");
    //5. Odlazak na CheckoutStepOnePage:
        cartPage.getCheckoutButton().click();
    //6. Unosenje podataka u polja na CheckoutStepOnePage
        Assert.assertTrue(checkoutStepOnePage.getContinueButton().isDisplayed());
        Assert.assertEquals(checkoutStepOnePage.getTitleCheckoutYourInformation().getText(), "Checkout: Your Information");
        checkoutStepOnePage.inputFirstName("Vlajke");
        checkoutStepOnePage.inputLastName("Vlajkic");
        checkoutStepOnePage.inputZip("123");
    //7. Odlazak na CheckoutStepTwoPage:
        checkoutStepOnePage.getContinueButton().click();
    //8. Odlazak na CheckoutCompletePage:
        Assert.assertEquals(checkOutStepTwoPage.getTitleCheckoutOverview().getText(),"Checkout: Overview");
        Assert.assertTrue(checkOutStepTwoPage.getFinishButton().isDisplayed());
       checkOutStepTwoPage.getFinishButton().click();
    //9. Povratak na InventoryPage:
        Assert.assertTrue(checkoutCompletePage.getGetHomeButton().isDisplayed());
        Assert.assertEquals(checkoutCompletePage.getTitleCheckoutComplete().getText(),"Checkout: Complete!");
        checkoutCompletePage.getGetHomeButton().click();
        Assert.assertTrue(inventoryPage.getProductSortContainer().isDisplayed());
        Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed());
    }

    @Test (priority = 20)
    public void shoppingWithBacksTest() {
        userLogin();
        Assert.assertEquals(inventoryPage.getTitleProducts().getText(), "Products");

//1. Dodavanje 6 proizvoda u korpu:
    Assert.assertEquals(inventoryPage.getTitleProducts().getText(), "Products");
    Assert.assertTrue(inventoryPage.getProductSortContainer().isDisplayed());
   inventoryPage.getBackpackAddToCartButton().click();
   inventoryPage.getBikeLightAddToCartButton().click();
   inventoryPage.getBoltTSHirtAddToCartButton().click();
   inventoryPage.getFleeceJacketAddtoCartButton().click();
   inventoryPage.getOnesieAddtoCartButton().click();
   inventoryPage.gettShirtRedAddtoCartButton().click();
   Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "6");
//2. Uklanjanje 1 proizvoda iz korpe:
   inventoryPage.getBackpackRemoveButton().click();
    Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "5");
//3. Odlazak na CartPage:
    swagsLabsSidebar.getCartIcon().click();
    Assert.assertEquals(cartPage.getTitleYourCart().getText(), "Your Cart");
    Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
//4. Uklanjanje 1 proizvoda iz korpe na CartPage:
    cartPage.getBikeLightRemoveCartButton().click();
    Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "4");
//5. Vracanje sa CartPage na InventoryPage (klik na dugme Continue Shopping):
    cartPage.getContinueShoppingButton().click();
//6. Dodavanje 1 proizvoda u korpu na InventoryPage:
    Assert.assertEquals(inventoryPage.getTitleProducts().getText(), "Products");
    Assert.assertTrue(inventoryPage.getProductSortContainer().isDisplayed());
    inventoryPage.getBackpackAddToCartButton().click();
    Assert.assertEquals(swagsLabsSidebar.getCartIcon().getText(), "5");
//7. Odlazak na CartPage:
    swagsLabsSidebar.getCartIcon().click();
//8. Odlazak na CheckoutStepOnePage (klik na dugme Checkout):
    Assert.assertEquals(cartPage.getTitleYourCart().getText(), "Your Cart");
    Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
    cartPage.getCheckoutButton().click();
    Assert.assertTrue(checkoutStepOnePage.getContinueButton().isDisplayed());
    Assert.assertEquals(checkoutStepOnePage.getTitleCheckoutYourInformation().getText(), "Checkout: Your Information");
//9. Odlazak na Cart Page (klik na dugme Cancel):
    checkoutStepOnePage.getCancelButton().click();
//10. Odlazak na CheckoutStepOnePage (klik na dugme Checkout):
    Assert.assertEquals(cartPage.getTitleYourCart().getText(), "Your Cart");
    Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
    cartPage.getCheckoutButton().click();
//11. Unos podataka na CheskoutStepOnePage:
    Assert.assertTrue(checkoutStepOnePage.getContinueButton().isDisplayed());
    Assert.assertEquals(checkoutStepOnePage.getTitleCheckoutYourInformation().getText(), "Checkout: Your Information");
    checkoutStepOnePage.inputFirstName("Vlajke");
    checkoutStepOnePage.inputLastName("Vlajkic");
    checkoutStepOnePage.inputZip("123");
//12. Odlazak na CheckoutStepTwoPage (klik na dugme Continue):
    checkoutStepOnePage.getContinueButton().click();
    Assert.assertEquals(checkOutStepTwoPage.getTitleCheckoutOverview().getText(),"Checkout: Overview");
    Assert.assertTrue(checkOutStepTwoPage.getFinishButton().isDisplayed());
//13. Odlazak na InventoryPage (klik na dugme Cancel):
    checkOutStepTwoPage.getCancelButton().click();
    Assert.assertEquals(inventoryPage.getTitleProducts().getText(), "Products");
    Assert.assertTrue(inventoryPage.getProductSortContainer().isDisplayed());
//14. Odlazak na CartPage:
    swagsLabsSidebar.getCartIcon().click();
    Assert.assertEquals(cartPage.getTitleYourCart().getText(), "Your Cart");
    Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
//15. Odlazak na CheckoutStepOnePage (klik na dugme Checkout):
    cartPage.getCheckoutButton().click();
    Assert.assertTrue(checkoutStepOnePage.getContinueButton().isDisplayed());
    Assert.assertEquals(checkoutStepOnePage.getTitleCheckoutYourInformation().getText(), "Checkout: Your Information");
//16. Unos podataka na CheckoutStepOnePage:
    checkoutStepOnePage.inputFirstName("Vlajke");
    checkoutStepOnePage.inputLastName("Vlajkic");
    checkoutStepOnePage.inputZip("123");
//17. Odlazak na CheckoutStepTwoPage (klik na dugme Continue):
    checkoutStepOnePage.getContinueButton().click();
    Assert.assertEquals(checkOutStepTwoPage.getTitleCheckoutOverview().getText(),"Checkout: Overview");
    Assert.assertTrue(checkOutStepTwoPage.getFinishButton().isDisplayed());
//18. Odlazak na CheckoutCompletePage (klik na dugme Finish):
    checkOutStepTwoPage.getFinishButton().click();
    Assert.assertTrue(checkoutCompletePage.getGetHomeButton().isDisplayed());
    Assert.assertEquals(checkoutCompletePage.getTitleCheckoutComplete().getText(),"Checkout: Complete!");
//19. Odlazak na InventoryPage (klik na dugme Back Home):
    checkoutCompletePage.getGetHomeButton().click();
    Assert.assertTrue(inventoryPage.getProductSortContainer().isDisplayed());
    Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
    swagsLabsSidebar.clickOnHamburgerMenu();
    wait.until(ExpectedConditions.visibilityOf(swagsLabsSidebar.getResetAppStateLink()));
    swagsLabsSidebar.getResetAppStateLink().click();
    wait.until(ExpectedConditions.visibilityOf(swagsLabsSidebar.getLogoutLink()));
    swagsLabsSidebar.getLogoutLink().click();
    driver.quit();
    }

}
