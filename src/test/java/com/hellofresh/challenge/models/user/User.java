package com.hellofresh.challenge.models.user;

import java.util.Date;

public class User {
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private Date birthday;
    private Address address;

    private User(String name, String email, String password, Gender gender, Date birthday, Address address) {
        this.name = name;
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

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (gender != user.gender) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        return address != null ? address.equals(user.address) : user.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String password;
        private Gender gender = Gender.UNDEFINED;
        private Date birthday;
        private Address address;

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

        public UserBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this.name, this.email, this.password, this.gender, this.birthday, this.address);
        }
    }
}
