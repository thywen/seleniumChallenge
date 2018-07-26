package com.hellofresh.challenge.uitest.userflows;

import com.hellofresh.challenge.uitest.models.user.User;
import com.hellofresh.challenge.uitest.pageObjects.user.LoginPage;
import com.hellofresh.challenge.uitest.pageObjects.user.UserProfilePage;

public class CreateUserFlow {

    public static UserProfilePage createUserFrom(LoginPage loginPage, User user) {
        return loginPage.createUserWith(user.getEmail())
            .selectGender(user.getGender())
            .enterName(user.getFirstName(), user.getLastName())
            .enterPassword(user.getPassword())
            .selectBirthday(user.getBirthday())
            .enterAddress(user.getAddress())
            .confirmRegistration();
    }
}

