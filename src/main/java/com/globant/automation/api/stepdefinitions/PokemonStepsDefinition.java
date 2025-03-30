package com.globant.automation.api.stepdefinitions;

import com.globant.automation.api.questions.PokemonQuestions;
import com.globant.automation.api.tasks.PokemonTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.globant.automation.core.utils.TestContextManager.getTestContext;

public class PokemonStepsDefinition {

  private final PokemonTasks pokemonTasks = new PokemonTasks();
  private final PokemonQuestions pokemonQuestions = new PokemonQuestions();

  @When("I send a GET request with name {string}")
  public void sendAGETRequestWithName(String pokemonName) {
    getTestContext().set("pokemonName", pokemonName);
    pokemonTasks.sendGetRequestForPokemon(pokemonName);
  }

  @Then("the response should return status code {int}")
  public void theResponseShouldReturnStatusCode(int statusCode) {
    pokemonQuestions.validateStatusCode(statusCode);
  }

  @And("the response should contain the name {string}")
  public void theResponseShouldContainTheName(String name) {
    pokemonQuestions.validatePokemonName(name);
  }

  @And("the response should contain the expected id {string}")
  public void theResponseShouldContainTheExpectedId(String id) {
    pokemonQuestions.validatePokemonId(id);
  }

  @Then("the response time should be less than {int} milliseconds")
  public void theResponseTimeShouldBeLessThanMilliseconds(int milliseconds) {
    pokemonTasks.measureResponseTimeFor(getTestContext().get("pokemonName"));
    pokemonQuestions.validateResponseTimeLessThan(milliseconds);
  }
}
