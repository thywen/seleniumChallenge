package com.hellofresh.challenge;

import com.hellofresh.challenge.models.Category;
import com.hellofresh.challenge.models.User;
import com.hellofresh.challenge.pageObjects.StoreHomePage;
import com.hellofresh.challenge.pageObjects.order.BasketPageObject;
import com.hellofresh.challenge.pageObjects.order.OrderConfirmationPage;
import com.hellofresh.challenge.pageObjects.order.ShippingPageObject;
import com.hellofresh.challenge.pageObjects.store.AddedToCartPage;
import com.hellofresh.challenge.pageObjects.store.ProductDetailPage;
import com.hellofresh.challenge.pageObjects.store.ProductsOverviewPage;
import com.hellofresh.challenge.pageObjects.user.UserProfilePage;
import com.hellofresh.challenge.repositories.UserRepository;
import com.hellofresh.challenge.userflows.LoginFlow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class WebTest {
    WebDriver driver;
    WebDriverWait wait;

    private UserRepository repository = new UserRepository();
    private StoreHomePage storeHomePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
        storeHomePage = PageFactory.initElements(driver, StoreHomePage.class);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void signInTest() {
        storeHomePage.openLoginPage();
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
        driver.findElement(By.id("passwd")).sendKeys("Qwerty");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        driver.findElement(By.id("company")).sendKeys("Company");
        driver.findElement(By.id("address1")).sendKeys("Qwerty, 123");
        driver.findElement(By.id("address2")).sendKeys("zxcvb");
        driver.findElement(By.id("city")).sendKeys("Qwerty");
        select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("Colorado");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).sendKeys("Qwerty");
        driver.findElement(By.id("phone")).sendKeys("12345123123");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345123123");
        driver.findElement(By.id("alias")).sendKeys("hf");
        driver.findElement(By.id("submitAccount")).click();
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

        assertEquals(heading.getText(), "MY ACCOUNT");
        assertEquals(driver.findElement(By.className("account")).getText(), name + " " + surname);
        assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
        assertTrue(driver.findElement(By.className("logout")).isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    @Test
    public void logInTest() {
        User user = repository.getExistingUser();
        String expectedHeading = "MY ACCOUNT";
        String expectedWelcomeMessage = "Welcome to your account.";

        UserProfilePage profilePage = LoginFlow.loginUserFrom(storeHomePage, user);

        assertThat(profilePage.getHeading()).isEqualTo(expectedHeading);
        assertThat(profilePage.getAccountName()).isEqualTo(user.getName());
        assertThat(profilePage.getWelcomeText()).contains(expectedWelcomeMessage);
        assertThat(profilePage.logoutVisible()).isTrue();
        assertThat(profilePage.isCorrectUrl()).isTrue();
    }

    @Test
    public void checkoutTest() {
        User user = repository.getExistingUser();
        String itemToBuy = "Faded Short Sleeve T-shirts";

        UserProfilePage profilePage = LoginFlow.loginUserFrom(storeHomePage, user);

        ProductsOverviewPage overviewPage = profilePage.selectCategory(Category.WOMAN);

        overviewPage.selectItem(itemToBuy);
        ProductDetailPage addedToCartPage = overviewPage.openItem(itemToBuy);
        ShippingPageObject shippingPageObject = addedToCartPage
                .addItemToCart()
                .goToBasket()
                .continueToAddressPage()
                .goToShippingPage();
        shippingPageObject.toggleTermsAndConditionsBox();
        OrderConfirmationPage orderConfirmationPage = shippingPageObject
                .processToPayment()
                .payByBankwire()
                .confirmOrder();
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

        assertEquals("ORDER CONFIRMATION", heading.getText());
        assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
    }
}
