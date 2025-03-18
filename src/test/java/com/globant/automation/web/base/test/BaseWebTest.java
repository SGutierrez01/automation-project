package com.globant.automation.web.base.test;

import com.globant.automation.core.base.test.BaseTest;
import com.globant.automation.web.utils.ScreenshotUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.qameta.allure.Allure;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseWebTest extends BaseTest {

  protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  protected Properties prop;

  @BeforeClass(alwaysRun = true)
  public void loadProperties() throws IOException {
    prop = new Properties();
    FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
    prop.load(fis);
  }

  @Parameters("browser")
  @BeforeMethod(alwaysRun = true)
  public void setup(@Optional("chrome") String browser) throws IOException {

    if (prop == null) {
      loadProperties();
    }

    String url = prop.getProperty("baseUrl");

    switch (browser.toLowerCase()) {
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
        break;
      case "edge":
        WebDriverManager.edgedriver().setup();
        driver.set(new EdgeDriver());
        break;
      default:
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        break;
    }

    getDriver().manage().window().maximize();
    getDriver().get(url);
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      System.out.println("❌ Failed test: " + result.getName());

      byte[] screenshotBytes = ScreenshotUtils.takeScreenshot(getDriver());

      Allure.getLifecycle().addAttachment(
          "Screenshot fail",
          "image/png",
          "png",
          screenshotBytes
      );
    }

    if (driver != null) {
      getDriver().quit();
    }
  }
  
  protected WebDriver getDriver() {
    return driver.get();
  }
}

