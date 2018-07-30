package com.hellofresh.challenge.uitest.repositories;

import com.github.javafaker.Faker;
import com.hellofresh.challenge.uitest.models.user.Address;

class AddressRepository {

    Address getRandomAddress() {
        Faker faker = new Faker();
        return new Address.AddressBuilder(
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode().substring(0, 5),
                "United States",
                faker.phoneNumber().cellPhone(),
                faker.internet().domainSuffix())
                .withaddress2(faker.address().secondaryAddress())
                .withCompany(faker.company().name())
                .withOther(faker.lorem().sentence(3))
                .withPhone(faker.phoneNumber().cellPhone())
                .build();
    }

}
