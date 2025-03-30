package com.globant.automation.web.stepdefinitions;

import com.globant.automation.web.questions.ProductsQuestions;
import com.globant.automation.web.tasks.ProductsTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepsDefinition {

  private final ProductsTasks productsTasks = new ProductsTasks();
  private final ProductsQuestions productsQuestions = new ProductsQuestions();

  @When("I add the cheapest product to the cart")
  public void addTheCheapestProductToTheCart() {
    productsTasks.addCheapestProductToCart();
  }

  @And("I open the cart")
  public void openTheCart() {
    productsTasks.goToCartPage();
  }

  @Then("I should be redirected to the inventory page")
  public void shouldBeRedirectedToTheInventoryPage() {
    productsQuestions.shouldBeRedirectedToTheInventoryPage();
  }
}
