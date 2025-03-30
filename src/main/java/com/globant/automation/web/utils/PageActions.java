package com.globant.automation.web.utils;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

@UtilityClass
public class PageActions {

  /**
   * Clicks on the given web element. This method performs a click action on the specified {@link
   * WebElement}. The action is accompanied by a description for logging or reporting purposes.
   *
   * @param element     The {@link WebElement} to be clicked.
   * @param description A text description of the element to be clicked, used for logging.
   */
  @Step("Click on '{description}'")
  public static void click(WebElement element, String description) {
    element.click();
  }

  /**
   * Clears the text content of the given web element and logs the action using Allure reporting.
   *
   * @param element The WebElement whose text content needs to be cleared.
   */
  public static void clear(WebElement element) {
    element.clear();
  }

  /**
   * Sends keys to the given web element and logs the action using Allure reporting.
   *
   * @param element The WebElement to send keys to.
   * @param text    The keys to be sent.
   * @param description A text description of the element to be clicked, used for logging.
   */
  public static void sendKeys(WebElement element, String text, String description) {
    element.sendKeys(text);
  }
}
