package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public SwagsLabsSidebar swagsLabsSidebar;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutStepOnePage checkoutStepOnePage;
    public CheckOutStepTwoPage checkOutStepTwoPage;
    public CheckoutCompletePage checkoutCompletePage;


    /*
    Napisati test kejseve,
    pa zatim napraviti automatske testove za https://www.saucedemo.com/
     */

    @BeforeClass
    public void setUp() {
    /*
    WebDriverManager.chromedriver().setup();
    OVO VISE NE TREBA DA SE KUCA ZATO STO JE od Seleniuma 4.0.0 pa na dalje
    WebDriverManager implementiran u Selenium. NE KUCATI VISE:
    WebDriverManager.chromedriver().setup();
     */
    }

    @AfterClass
    public void end(){
    }



    public void userLogin() {
        homePage.inputUsername("standard_user");
        homePage.inputPassword("secret_sauce");
        homePage.clickOnLoginButton();
    }
}






