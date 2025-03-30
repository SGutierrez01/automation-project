package com.globant.automation.web.questions;

import com.globant.automation.web.pages.LoginPage;
import org.testng.Assert;

public class LoginQuestions extends LoginPage {

  public void shouldSeeAnErrorMessageContaining(String message) {
    Assert.assertTrue(getErrorMessage().isDisplayed(), "Fail Message not displayed.");
    String error = getErrorMessage().getText();
    Assert.assertTrue(error.contains(message), "Failing displayed 'locked out'.");
  }
}
