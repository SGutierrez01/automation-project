package com.globant.automation.core.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.Assert;
import org.testng.SkipException;

public class CustomException extends RuntimeException {
  public CustomException(String message) {
    super(message);
    Allure.addAttachment("Error Message", message);
    Assert.fail(message);
  }

  /**
   * Constructs a CustomException with a message and status.
   * Invoking this exception will change the test case state to {@code BROKEN}
   * For any other status, it throws a CustomException.
   *
   * @param message The error message.
   * @param status  The status indicating the outcome.
   */
  public CustomException(String message, Status status) {
    super(message);
    switch (status) {
      case FAILED -> throw new CustomException(message);
      case SKIPPED -> throw new SkipException(message);
      default -> {
        //default class exception
      }
    }
  }
}
