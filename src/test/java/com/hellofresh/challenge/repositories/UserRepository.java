package com.hellofresh.challenge.repositories;

import com.hellofresh.challenge.models.User;

public class UserRepository {

    public User getExistingUser() {
        String existingUserEmail = "hf_challenge_123456@hf12345.com";
        String existingUserPassword = "12345678";
        String existingUserName = "Joe Black";

        return new User(existingUserName, existingUserEmail, existingUserPassword);
    }
}
