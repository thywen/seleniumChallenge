package com.hellofresh.challenge.uitest.userflows;

import com.hellofresh.challenge.uitest.models.Category;
import com.hellofresh.challenge.uitest.pageObjects.order.OrderConfirmationPage;
import com.hellofresh.challenge.uitest.pageObjects.order.ShippingPage;
import com.hellofresh.challenge.uitest.pageObjects.store.ProductDetailPage;
import com.hellofresh.challenge.uitest.pageObjects.store.ProductsOverviewPage;
import com.hellofresh.challenge.uitest.pageObjects.user.UserProfilePage;

public class BuyItemFlow {
    public static OrderConfirmationPage buyItemFrom(UserProfilePage profilePage, Category category, String item) {
        ProductsOverviewPage productsOverviewPage = profilePage.selectCategory(category);
        ShippingPage shippingPageObject = selectItemFrom(productsOverviewPage, item)
                .addItemToCart()
                .goToBasket()
                .continueToAddressPage()
                .goToShippingPage();
        shippingPageObject.acceptTermsAndConditions();
        return shippingPageObject
                .processToPayment()
                .payByBankwire()
                .confirmOrder();
    }


    private static ProductDetailPage selectItemFrom(ProductsOverviewPage overviewPage, String item) {
        overviewPage.selectItem(item);
        return overviewPage.openItem(item);
    }
}
