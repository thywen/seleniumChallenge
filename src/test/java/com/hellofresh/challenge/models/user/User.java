package com.hellofresh.challenge.models.user;

import java.util.Date;

public class User {
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private Date birthday;

    private User(String name, String email, String password, Gender gender, Date birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
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

    public Gender getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String password;
        private Gender gender = Gender.UNDEFINED;
        private Date birthday;

        public UserBuilder(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public UserBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder withBirthday(Date date) {
            birthday = date;
            return this;
        }

        public User build() {
            return new User(this.name, this.email, this.password, this.gender, this.birthday);
        }
    }
}
