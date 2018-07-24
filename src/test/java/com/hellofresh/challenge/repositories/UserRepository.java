package com.hellofresh.challenge.repositories;

import com.github.javafaker.Faker;
import com.hellofresh.challenge.models.user.Address;
import com.hellofresh.challenge.models.user.Gender;
import com.hellofresh.challenge.models.user.User;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Random;

public class UserRepository {

    public User getExistingUser() {
        String existingUserEmail = "hf_challenge_123456@hf12345.com";
        String existingUserPassword = "12345678";
        String existingUserFirstname = "Joe";
        String existingUserLastname = "Black";

        return new User.UserBuilder(existingUserFirstname, existingUserLastname, existingUserEmail, existingUserPassword)
                .build();
    }

    public User createRandomUser() {
        Faker faker = new Faker();
        AddressRepository addressRepository = new AddressRepository();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String email = getTimestampedEmail();
        DateTime birthday = new DateTime(faker.date().birthday());
        Address address = addressRepository.getRandomAddress();
        return new User.UserBuilder(firstName, lastName, email, password)
                .withGender(getRandomGender())
                .withBirthday(birthday)
                .withAddress(address)
                .build();
    }

    private String getTimestampedEmail() {
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }

    private Gender getRandomGender() {
        Gender[] genders = Gender.values();
        Random random = new Random();
        return genders[random.nextInt(genders.length - 1)];
    }

}
