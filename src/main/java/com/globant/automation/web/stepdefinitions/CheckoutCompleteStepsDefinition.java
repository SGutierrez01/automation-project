package com.globant.automation.web.stepdefinitions;

import com.globant.automation.web.questions.CheckoutCompleteQuestions;
import io.cucumber.java.en.Then;

public class CheckoutCompleteStepsDefinition {

  private final CheckoutCompleteQuestions checkoutCompleteQuestions = new CheckoutCompleteQuestions();

  @Then("I should see the message {string}")
  public void shouldSeeTheMessage(String message) {
    checkoutCompleteQuestions.shouldSeeTheMessage(message);
  }
}
