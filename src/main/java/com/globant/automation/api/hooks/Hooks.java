package com.globant.automation.api.hooks;

import com.globant.automation.web.utils.PropertiesUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Hooks {

  @Before("@api")
  public void startApiScenario(Scenario scenario) {
    Allure.label("layer", "api");
    Allure.feature("API Scenario");
    Allure.epic("API Testing");
  }

  @Before(value = "@api", order = 0)
  public void beforeApiScenario(Scenario scenario) throws IOException {
    log.info("[API] Starting scenario: {}", scenario.getName());
    // Load config and set baseURI for RestAssured
    PropertiesUtils.loadProperties();
    RestAssured.baseURI = PropertiesUtils.getProperty("apiUrl");
    log.info("[API] Base URI set to: {}", RestAssured.baseURI);
  }

  @After(value = "@api", order = 1)
  public void afterApiScenario(Scenario scenario) {
    log.info("[API] Finished scenario: {}", scenario.getName());
  }
}
