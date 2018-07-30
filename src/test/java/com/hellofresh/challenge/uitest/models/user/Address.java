package com.hellofresh.challenge.uitest.models.user;

public class Address {
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String other;
    private String phone;
    private String mobilePhone;
    private String addressAlias;

    public Address(String company, String address1, String address2, String city, String state, String postcode,
                   String country, String other, String phone, String mobilePhone, String addressAlias) {
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.other = other;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;


    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getOther() {
        return other;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (company != null ? !company.equals(address.company) : address.company != null) return false;
        if (address1 != null ? !address1.equals(address.address1) : address.address1 != null) return false;
        if (address2 != null ? !address2.equals(address.address2) : address.address2 != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (other != null ? !other.equals(address.other) : address.other != null) return false;
        if (phone != null ? !phone.equals(address.phone) : address.phone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(address.mobilePhone) : address.mobilePhone != null) return false;
        return addressAlias != null ? addressAlias.equals(address.addressAlias) : address.addressAlias == null;
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (addressAlias != null ? addressAlias.hashCode() : 0);
        return result;
    }

    public static class AddressBuilder {
        private String company;
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String postcode;
        private String country;
        private String other;
        private String phone;
        private String mobilePhone;
        private String addressAlias;

        public AddressBuilder(String address1, String city, String state, String postcode, String country, String mobilePhone, String addressAlias) {
            this.address1 = address1;
            this.city = city;
            this.state = state;
            this.postcode = postcode;
            this.country = country;
            this.mobilePhone = mobilePhone;
            this.addressAlias = addressAlias;
        }

        public AddressBuilder withCompany(String company) {
            this.company = company;
            return this;
        }

        public AddressBuilder withaddress2(String address2) {
            this.address2 = address2;
            return this;
        }

        public AddressBuilder withOther(String other) {
            this.other = other;
            return this;
        }

        public AddressBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Address build() {
            return new Address(company, address1, address2, city, state, postcode, country, other, phone, mobilePhone, addressAlias);
        }
    }
}
