package com.hellofresh.challenge.uitest;

import com.hellofresh.challenge.uitest.driver.Driver;
import com.hellofresh.challenge.uitest.driver.DriverService;
import com.hellofresh.challenge.uitest.listener.ScreenshotListener;
import com.hellofresh.challenge.uitest.models.Category;
import com.hellofresh.challenge.uitest.models.user.User;
import com.hellofresh.challenge.uitest.pageObjects.StoreHomePage;
import com.hellofresh.challenge.uitest.pageObjects.order.OrderConfirmationPage;
import com.hellofresh.challenge.uitest.pageObjects.user.LoginPage;
import com.hellofresh.challenge.uitest.pageObjects.user.UserProfilePage;
import com.hellofresh.challenge.uitest.repositories.UserRepository;
import com.hellofresh.challenge.uitest.userflows.BuyItemFlow;
import com.hellofresh.challenge.uitest.userflows.CreateUserFlow;
import com.hellofresh.challenge.uitest.userflows.LoginFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({ScreenshotListener.class})
public class WebTest {
    private DriverService driverService = DriverService.getInstance();
    private UserRepository repository = new UserRepository();
    private StoreHomePage storeHomePage;
    private String driverName = System.getenv("DRIVER");

    @BeforeMethod
    public void setUp() {
        WebDriver driver = driverService.getDriver(Driver.valueOf(driverName));
        driver.get("http://automationpractice.com/index.php");
        storeHomePage = PageFactory.initElements(driver, StoreHomePage.class);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driverService.removeDriver(Driver.valueOf(driverName));
    }

    @Test
    public void createUserTest() {
        User user = repository.createRandomUser();
        LoginPage loginPage = storeHomePage.openLoginPage();
        String expectedHeading = "MY ACCOUNT";
        String expectedWelcomeMessage = "Welcome to your account.";

        UserProfilePage profilePage = CreateUserFlow.createUserFrom(loginPage, user);

        assertThat(profilePage.getHeading()).isEqualTo(expectedHeading);
        assertThat(profilePage.getAccountName()).isEqualTo(user.getName());
        assertThat(profilePage.getWelcomeText()).contains(expectedWelcomeMessage);
        assertThat(profilePage.logoutVisible()).isTrue();
        assertThat(profilePage.isCorrectUrl()).isTrue();
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
        String expectedHeading = "ORDER CONFIRMATION";
        String expectedConfirmation = "Your order on My Store is complete.";

        UserProfilePage profilePage = LoginFlow.loginUserFrom(storeHomePage, user);

        OrderConfirmationPage orderConfirmationPage = BuyItemFlow.buyItemFrom(profilePage, Category.WOMAN, itemToBuy);

        assertThat(orderConfirmationPage.getHeading()).isEqualTo(expectedHeading);
        assertThat(orderConfirmationPage.isPaymentStepActive()).isTrue();
        assertThat(orderConfirmationPage.shippingTabVisible()).isTrue();
        assertThat(orderConfirmationPage.getConfirmationText()).contains(expectedConfirmation);
        assertThat(orderConfirmationPage.isCorrectUrl()).isTrue();
    }
}
