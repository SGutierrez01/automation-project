package com.globant.automation.web.stepdefinitions;

import com.globant.automation.web.tasks.CheckoutInformationTasks;
import io.cucumber.java.en.And;

public class CheckoutInformationStepsDefinition {

  private final CheckoutInformationTasks checkoutInformationTasks = new CheckoutInformationTasks();

  @And("I fill in first name {string}, last name {string}, and postal code {string}")
  public void fillInFirstNameLastNameAndPostalCode(String firstName,
                                                   String lastName,
                                                   String postalCode) {
    checkoutInformationTasks.fillCheckoutInfo(firstName, lastName, postalCode);
  }

  @And("I proceed to overview")
  public void proceedToOverview() {
    checkoutInformationTasks.continueToOverview();
  }
}
