package com.hellofresh.challenge.userflows;

import com.hellofresh.challenge.models.user.User;
import com.hellofresh.challenge.pageObjects.user.LoginPage;
import com.hellofresh.challenge.pageObjects.user.UserProfilePage;

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

