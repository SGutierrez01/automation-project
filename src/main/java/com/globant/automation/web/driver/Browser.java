package com.globant.automation.web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;
import java.net.URL;

@UtilityClass
public class Browser {

  public static WebDriver createWebDriver(@Optional("chrome") String browser) {
    String browserName = browser == null ? System.getProperty("browser") : browser;
    WebDriver driver = null;

    try {
      String seleniumServerUrl = "http://localhost:4444/wd/hub";

      driver = switch (browserName) {
        case "firefox" -> {
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          yield new RemoteWebDriver(new URL(seleniumServerUrl), firefoxOptions);
        }
        case "edge" -> {
          EdgeOptions edgeOptions = new EdgeOptions();
          yield new RemoteWebDriver(new URL(seleniumServerUrl), edgeOptions);
        }
        default -> {
          ChromeOptions chromeOptions = new ChromeOptions();
          yield new RemoteWebDriver(new URL(seleniumServerUrl), chromeOptions);
        }
      };
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return driver;
  }
}