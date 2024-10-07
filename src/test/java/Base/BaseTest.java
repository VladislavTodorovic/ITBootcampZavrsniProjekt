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
    Write test cases, and then create automated tests for: https://www.saucedemo.com/
     */

    @BeforeClass
    public void setUp() {
    /*
    WebDriverManager.chromedriver().setup();
    This should not be typed anymore, because from version Selenium 4.0.0
    WebDriverManager is implemented into Selenium.
    DON'T TYPE ANYMORE:
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






