package com.globant.automation.api.questions;

import com.globant.automation.api.models.PokemonResponse;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.globant.automation.core.utils.TestContextManager.getTestContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class PokemonQuestions {

  public void validateStatusCode(int expectedStatusCode) {
    Response response = getTestContext().get("pokemonResponse");
    Assert.assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
  }

  public void validatePokemonName(String expectedName) {
    Response response = getTestContext().get("pokemonResponse");
    PokemonResponse pokemon = response.as(PokemonResponse.class);
    Assert.assertEquals("Pokemon name mismatch", expectedName.toLowerCase(), pokemon.getName().toLowerCase());
  }

  public void validatePokemonId(String expectedId) {
    Response response = getTestContext().get("pokemonResponse");
    PokemonResponse pokemon = response.as(PokemonResponse.class);
    Assert.assertEquals("Pokemon ID mismatch", Integer.parseInt(expectedId), pokemon.getId());
  }

  public void validateResponseTimeLessThan(int maxMilliseconds) {
    Long time = getTestContext().get("responseTime");
    assertThat("Response time too high", time, lessThan((long) maxMilliseconds));
    Response response = getTestContext().get("timedResponse");
    Assert.assertEquals(200, response.statusCode());
  }
}