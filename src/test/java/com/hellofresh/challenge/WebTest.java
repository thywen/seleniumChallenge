package com.hellofresh.challenge;

import com.hellofresh.challenge.models.Category;
import com.hellofresh.challenge.models.user.User;
import com.hellofresh.challenge.pageObjects.StoreHomePage;
import com.hellofresh.challenge.pageObjects.order.OrderConfirmationPage;
import com.hellofresh.challenge.pageObjects.user.LoginPage;
import com.hellofresh.challenge.pageObjects.user.UserProfilePage;
import com.hellofresh.challenge.repositories.UserRepository;
import com.hellofresh.challenge.userflows.BuyItemFlow;
import com.hellofresh.challenge.userflows.LoginFlow;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest {
    WebDriver driver;
    WebDriverWait wait;

    private UserRepository repository = new UserRepository();
    private StoreHomePage storeHomePage;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
        storeHomePage = PageFactory.initElements(driver, StoreHomePage.class);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void signInTest() {
        User user = repository.createRandomUser();
        LoginPage loginPage = storeHomePage.openLoginPage();
        String expectedHeading = "MY ACCOUNT";
        String expectedWelcomeMessage = "Welcome to your account.";

        UserProfilePage profilePage = loginPage.createUserWith(user.getEmail())
                .selectGender(user.getGender())
                .enterName(user.getFirstName(), user.getLastName())
                .enterPassword(user.getPassword())
                .selectBirthday(user.getBirthday())
                .enterAddress(user.getAddress())
                .confirmRegistration();

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
