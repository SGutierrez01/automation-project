package com.globant.automation.web.base.page;

import com.globant.automation.web.utils.PropertiesUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static com.globant.automation.web.driver.Browser.createWebDriver;

public abstract class BasePage {

  protected static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  /**
   * Returns the WebDriver instance associated with the current thread.
   *
   * @return the WebDriver instance
   */
  public static WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  /**
   * Sets the WebDriver instance for the current thread.
   *
   * @param driver the WebDriver instance to set
   */
  public static void setDriver(WebDriver driver) {
    driverThreadLocal.set(driver);
  }

  /**
   * Quits the WebDriver instance and removes it from the current thread.
   */
  public static void removeDriver() {
    WebDriver driver = driverThreadLocal.get();
    if (driver != null) {
      driver.quit();
      driverThreadLocal.remove();
    }
  }

  protected WebDriverWait wait;

  protected BasePage() {
    if (getDriver() == null) {
      setDriver(createWebDriver(PropertiesUtils.getProperty("browser")));
    }
    PageFactory.initElements(getDriver(), this);
  }

  /**
   * Opens the specified URL in the browser and maximizes the window.
   *
   * @param url the URL to open
   */
  public void openPage(String url) {
    getDriver().get(url);
  }

}
