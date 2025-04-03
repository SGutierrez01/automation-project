package com.globant.automation.web.hooks;

import com.globant.automation.web.base.page.BasePage;
import com.globant.automation.web.driver.Browser;
import com.globant.automation.web.utils.PropertiesUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

@Slf4j
public class Hooks {

  @BeforeClass(alwaysRun = true)
  public void loadProperties() throws IOException {
    PropertiesUtils.loadProperties();
  }

  @Before("@web")
  public void startWebScenario(Scenario scenario) {
    Allure.label("layer", "web");
    Allure.feature("Web Scenario");
    Allure.epic("UI Automation");
  }

  @Before(value = "@web", order = 0)
  public void setUpWebDriver(Scenario scenario) {
    log.info("[WEB] Starting scenario: {}", scenario.getName());
    WebDriver driver = Browser.createWebDriver("chrome");
    BasePage.setDriver(driver);
  }

  @After(value = "@web", order = 1)
  public void tearDownWebDriver(Scenario scenario) {
    log.info("[WEB] Ending scenario: {}", scenario.getName());

    WebDriver driver = BasePage.getDriver();

    if (scenario.isFailed() && driver != null) {
      byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      Allure.getLifecycle().addAttachment(
          "Screenshot on Failure",
          "image/png",
          "png",
          screenshot
      );
    }
    if (driver != null) {
      driver.quit();
      BasePage.removeDriver();
    }
  }
}