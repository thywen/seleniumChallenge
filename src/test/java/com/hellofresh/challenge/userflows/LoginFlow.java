package com.hellofresh.challenge.userflows;

import com.hellofresh.challenge.models.User;
import com.hellofresh.challenge.pageObjects.StoreHomePage;
import com.hellofresh.challenge.pageObjects.user.UserProfilePage;

public class LoginFlow {
    public static UserProfilePage loginUserFrom(StoreHomePage homePage, User user) {
        return homePage.openLoginPage().logInUser(user);
    }
}
