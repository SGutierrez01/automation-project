package com.globant.automation.web.questions;

import com.globant.automation.web.pages.CheckoutCompletePage;
import org.testng.Assert;

public class CheckoutCompleteQuestions extends CheckoutCompletePage {

  public void shouldSeeTheMessage(String message) {
    Assert.assertEquals(getCompleteHeader().getText(), message, "Message does not match.");
  }
}
