package com.hellofresh.challenge.models.user;

import org.joda.time.DateTime;

public class User {
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private DateTime birthday;
    private Address address;

    private User(String name, String firstName, String lastName, String email, String password, Gender gender, DateTime birthday, Address address) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String password;
        private Gender gender = Gender.UNDEFINED;
        private DateTime birthday;
        private Address address;
        private String firstName;
        private String lastName;

        public UserBuilder(String firstName, String lastName, String email, String password) {
            this.name = firstName + " " + lastName;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
        }

        public UserBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder withBirthday(DateTime date) {
            birthday = date;
            return this;
        }

        public UserBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this.name, this.firstName, this.lastName, this.email, this.password, this.gender, this.birthday, this.address);
        }
    }
}
