package com.globant.automation.web.stepdefinitions;

import com.globant.automation.web.questions.CartQuestions;
import com.globant.automation.web.tasks.CartTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartStepsDefinition {

  private final CartTasks cartTasks = new CartTasks();
  private final CartQuestions cartQuestions = new CartQuestions();

  @And("I proceed to checkout")
  public void proceedToCheckout() {
    cartTasks.clickCheckoutButton();
  }

  @Then("I should see the cheapest product")
  public void shouldSeeTheCheapestProduct() {
    cartQuestions.shouldSeeTheCheapestProduct();
  }
}
