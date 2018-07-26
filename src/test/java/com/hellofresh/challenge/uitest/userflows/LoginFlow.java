package com.hellofresh.challenge.uitest.userflows;

import com.hellofresh.challenge.uitest.models.user.User;
import com.hellofresh.challenge.uitest.pageObjects.StoreHomePage;
import com.hellofresh.challenge.uitest.pageObjects.user.UserProfilePage;

public class LoginFlow {
    public static UserProfilePage loginUserFrom(StoreHomePage homePage, User user) {
        return homePage.openLoginPage().logInUser(user);
    }
}
