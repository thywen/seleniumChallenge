package com.hellofresh.challenge.integrationtest;

import com.hellofresh.challenge.integrationtest.api.CountryApi;
import com.hellofresh.challenge.integrationtest.model.Country;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;


public class SimpleRestAssuredTest {

    @Test
    public void testGetAllCountriesContainsGermanyUkAndUS() throws Exception {
        String[] expectedCountries = {"United States of America", "United Kingdom of Great Britain and Northern Ireland", "Germany"};
        String basePath = "RestResponse.result.findAll";

        Response allCountriesResponse = CountryApi.getAllCountries();

        allCountriesResponse.then()
                .statusCode(200)
                .body(basePath + " {it}.name ", hasItems(expectedCountries));
    }

    @Test
    public void testGermanyDataIsCorrect() {
        String expectedName = "Germany";
        String expectedAlpha2Code = "DE";
        String expectedAlpha3Code = "DEU";

        Country germany = new Country(expectedName, expectedAlpha2Code, expectedAlpha3Code);
        checkCountryInformation(germany);
    }

    @Test
    public void testUSDataIsCorrect() {
        String expectedName = "United States of America";
        String expectedAlpha2Code = "US";
        String expectedAlpha3Code = "USA";

        Country unitedStates = new Country(expectedName, expectedAlpha2Code, expectedAlpha3Code);
        checkCountryInformation(unitedStates);
    }

    @Test
    public void testUKDataIsCorrect() {
        String expectedName = "United Kingdom of Great Britain and Northern Ireland";
        String expectedAlpha2Code = "GB";
        String expectedAlpha3Code = "GBR";

        Country germany = new Country(expectedName, expectedAlpha2Code, expectedAlpha3Code);
        checkCountryInformation(germany);
    }

    @Test
    public void testNonExistingCountry() {
        String wrongAlpha2Code = "NK";

        String expectedError = String.format("No matching country found for requested code [%s].", wrongAlpha2Code);

        Response countryResponse = CountryApi.getSpecificCountry(wrongAlpha2Code);

        countryResponse
                .then()
                .statusCode(200)
                .body("RestResponse.messages[0]", is(equalTo(expectedError)));

    }

    @Test
    public void testPostNotPossible() {
        Country payload = new Country("Test Country", "TC", "TCY");
        Response countryPostResponse = CountryApi.postCountry(payload);

        countryPostResponse
                .then()
                .statusCode(200);
    }


    private void checkCountryInformation(Country country) {
        String basePath = "RestResponse.result";
        Response countryResponse = CountryApi.getSpecificCountry(country.getAlpha2Code());

        countryResponse.then()
                .statusCode(200)
                .body(basePath + ".name", is(equalTo(country.getName())))
                .body(basePath + ".alpha2_code", is(equalTo(country.getAlpha2Code())))
                .body(basePath + ".alpha3_code", is(equalTo(country.getAlpha3Code())));
    }
}
