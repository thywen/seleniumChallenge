package com.hellofresh.challenge.integrationtest;

import com.hellofresh.challenge.integrationtest.model.Country;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;


public class SimpleRestAssuredTest {
    RequestSpecification requestSpecification;

    @BeforeClass
    public void setUp() throws Exception {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://services.groupkt.com");
        builder.setBasePath("country");
        requestSpecification = builder.build();
    }

    @Test
    public void testGetAllCountriesHasGermanyUkAndUS() throws Exception {
        String[] expectedCountries = {"United States of America", "United Kingdom of Great Britain and Northern Ireland", "Germany"};
        String[] expectedalpha2Codes = {"US", "GB", "DE"};
        String basePath = "RestResponse.result.findAll";
        given()
            .spec(requestSpecification)
        .when()
            .get("get/all")
        .then()
            .statusCode(200)
            .body(basePath + " {it}.name ", hasItems(expectedCountries))
            .body(basePath + " {it}.alpha2_code ", hasItems(expectedalpha2Codes));
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

        given()
            .spec(requestSpecification)
        .when()
            .get("get/iso2code/" + wrongAlpha2Code)
        .then()
            .statusCode(200)
            .body("RestResponse.messages[0]", is(equalTo(expectedError)));

    }

    @Test
    public void testPostNotPossible() {
        Country testcountry = new Country("Test Country", "TC", "TCY");
        given()
            .contentType("application/json")
            .body(testcountry)
            .spec(requestSpecification)
        .when()
            .post("/")
        .then().statusCode(400);
    }


    private void checkCountryInformation(Country country) {
        String path = "http://services.groupkt.com/country/get/iso2code/" + country.getAlpha2Code();
        String basePath = "RestResponse.result";
        when()
            .get(path)
        .then()
            .statusCode(200)
            .body(basePath + ".name", is(equalTo(country.getName())))
            .body(basePath + ".alpha2_code", is(equalTo(country.getAlpha2Code())))
            .body(basePath + ".alpha3_code", is(equalTo(country.getAlpha3Code())));
        }
}
