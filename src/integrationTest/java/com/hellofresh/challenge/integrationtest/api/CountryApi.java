package com.hellofresh.challenge.integrationtest.api;

import com.hellofresh.challenge.integrationtest.model.Country;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CountryApi extends BaseApi {
    private static final String API_URL = BASE_URL + "/country";

    public static Response getAllCountries() {
        return when().get(API_URL + "/get/all");
    }

    public static Response getSpecificCountry(String countryCode) {
        return when().get(API_URL + "/get/iso2code/" + countryCode);
    }

    public static Response postCountry(Country payload) {
        return given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post(API_URL);
    }
}
