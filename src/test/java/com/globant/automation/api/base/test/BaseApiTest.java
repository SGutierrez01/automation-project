package com.globant.automation.api.base.test;

import com.globant.automation.core.base.test.BaseTest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseApiTest extends BaseTest {

  @BeforeClass(alwaysRun = true)
  public void setupApi() throws IOException {
    loadProperties("src/test/resources/config.properties");

    RestAssured.baseURI = getProperty("apiUrl");
  }

  @Step("Send GET request to endpoint: {endpoint}")
  protected Response sendGetRequest(String endpoint) {
    return given()
        .log().uri()
        .when()
        .get(endpoint)
        .then()
        .log().body()
        .extract()
        .response();
  }

  @Step("Send POST request to endpoint: {endpoint}")
  protected Response sendPostRequest(String endpoint, Object body) {
    return given()
        .log().uri()
        .body(body)
        .when()
        .post(endpoint)
        .then()
        .log().body()
        .extract()
        .response();
  }

  @Step("Validate status code: {expectedStatusCode}")
  protected void validateStatusCode(Response response, int expectedStatusCode) {
    int actualStatusCode = response.statusCode();
    if (actualStatusCode != expectedStatusCode) {
      throw new AssertionError("Expected status code: " + expectedStatusCode + " but got: " + actualStatusCode);
    }
  }

  @Step("Set Base URI dynamically: {baseUri}")
  protected void setBaseUri(String baseUri) {
    RestAssured.baseURI = baseUri;
  }
}

