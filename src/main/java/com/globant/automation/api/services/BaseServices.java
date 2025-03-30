package com.globant.automation.api.services;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseServices {

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
}
