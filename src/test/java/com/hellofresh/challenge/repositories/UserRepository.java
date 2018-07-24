package com.hellofresh.challenge.repositories;

import com.github.javafaker.Faker;
import com.hellofresh.challenge.models.user.Gender;
import com.hellofresh.challenge.models.user.User;

import java.util.Date;
import java.util.Random;

public class UserRepository {
    private Faker faker;

    public User getExistingUser() {
        String existingUserEmail = "hf_challenge_123456@hf12345.com";
        String existingUserPassword = "12345678";
        String existingUserName = "Joe Black";

        return new User.UserBuilder(existingUserName, existingUserEmail, existingUserPassword)
                .build();
    }

    public User createRandomUser() {
        faker = new Faker();
        String name = faker.name().fullName();
        String password = faker.internet().password();
        String email = getTimestampedEmail();
        Date birthdate = faker.date().birthday();
        return new User.UserBuilder(name, email, password)
                .withGender(getRandomGender())
                .build();
    }

    private String getTimestampedEmail() {
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }

    private Gender getRandomGender() {
        Gender[] genders = Gender.values();
        Random random = new Random();
        return genders[random.nextInt(genders.length -1)];
    }

}
