package com.hellofresh.challenge.models;

public class User {
    private String name;
    private String email;
    private String password;
    private Gender gender;

    private User(String name, String email, String password, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return gender == user.gender;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String password;
        private Gender gender = Gender.UNDEFINED;

        public UserBuilder(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public UserBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(this.name, this.email, this.password, this.gender);
        }
    }
}
