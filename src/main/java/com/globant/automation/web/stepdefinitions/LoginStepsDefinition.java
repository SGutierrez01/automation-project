package com.globant.automation.web.stepdefinitions;

import com.globant.automation.web.questions.LoginQuestions;
import com.globant.automation.web.tasks.LoginTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition {

  private final LoginTasks loginTasks = new LoginTasks();
  private final LoginQuestions loginQuestions = new LoginQuestions();

  @Given("I open the SauceDemo login page")
  public void openTheSauceDemoLoginPage() {
    loginTasks.openTheSauceDemoLoginPage();
  }

  @When("I enter username {string} and password {string}")
  public void enterUsernameAndPassword(String username, String password) {
    loginTasks.enterUsername(username);
    loginTasks.enterPassword(password);
  }

  @And("I click the login button")
  public void clickLoginButton() {
    loginTasks.clickLoginButton();
  }

  @Then("I should see an error message containing {string}")
  public void shouldSeeAnErrorMessageContaining(String message) {
    loginQuestions.shouldSeeAnErrorMessageContaining(message);
  }

  @Given("I am logged in as {string} with password {string}")
  public void loggedInAsWithPassword(String username, String password) {
    loginTasks.enterUsername(username);
    loginTasks.enterPassword(password);
    loginTasks.clickLoginButton();
  }
}
