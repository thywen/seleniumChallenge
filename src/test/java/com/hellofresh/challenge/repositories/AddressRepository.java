package com.hellofresh.challenge.repositories;

import com.github.javafaker.Faker;
import com.hellofresh.challenge.models.user.Address;

public class AddressRepository {

    Address getRandomAddress() {
        Faker faker = new Faker();
        return new Address.AddressBuilder(
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                "United States",
                faker.phoneNumber().cellPhone(),
                faker.internet().domainSuffix())
                .withaddress2(faker.address().secondaryAddress())
                .withCompany(faker.company().name())
                .withOther(faker.lorem().sentence(3))
                .withPhone(faker.phoneNumber().phoneNumber())
                .build();
    }

}
