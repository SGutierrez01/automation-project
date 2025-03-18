package com.globant.automation.api.tests;

import com.globant.automation.api.base.test.BaseApiTest;
import com.globant.automation.api.data.PokemonDataProvider;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.automation.api.models.PokemonResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

@Epic("API Testing")
@Feature("Pokémon Endpoint Tests")
public class PokemonApiTest extends BaseApiTest {

  private static final long MAX_RESPONSE_TIME_MS = 2000;

  @Test(dataProvider = "validPokemonNames", dataProviderClass = PokemonDataProvider.class,
      description = "GET Pokémon by valid name")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Verify that the API returns correct Pokémon details for valid names")
  public void testGetPokemonByValidName(String pokemonName, int expectedId) {

    PokemonResponse pokemon = getPokemonByName(pokemonName.toLowerCase());

    Allure.step("Asserting Pokémon name and ID match the expected values");

    Assert.assertEquals(pokemon.getName().toLowerCase(), pokemonName.toLowerCase(),
        "Pokemon name mismatch.");
    Assert.assertEquals(pokemon.getId(), expectedId,
        "Pokemon ID mismatch.");
  }

  @Test(dataProvider = "invalidPokemonNames", dataProviderClass = PokemonDataProvider.class,
      description = "GET Pokémon by invalid name")
  @Severity(SeverityLevel.NORMAL)
  @Description("Verify that the API returns 404 for non-existent Pokémon")
  public void testGetPokemonByInvalidName(String pokemonName) {

    Response response = sendGetRequest("/" + pokemonName);

    validateStatusCode(response, 404);

    Allure.step("Asserting response is 404 Not Found for invalid Pokémon: " + pokemonName);
  }

  @Test(dataProvider = "validPokemonNames", dataProviderClass = PokemonDataProvider.class,
      description = "Validate response time for Pokémon API")
  @Severity(SeverityLevel.MINOR)
  @Description("Verify that response time is within acceptable limits")
  public void testResponseTime(String pokemonName, int expectedId) {

    long startTime = System.currentTimeMillis();

    Response response = sendGetRequest("/" + pokemonName.toLowerCase());

    long endTime = System.currentTimeMillis();
    long responseTime = endTime - startTime;

    Allure.step("Measured response time: " + responseTime + "ms");

    assertThat("API response time should be under " + MAX_RESPONSE_TIME_MS + "ms",
        responseTime, lessThan(MAX_RESPONSE_TIME_MS));

    validateStatusCode(response, 200);
  }

  @Step("GET Pokémon by name: {pokemonName}")
  private PokemonResponse getPokemonByName(String pokemonName) {
    Response response = sendGetRequest("/" + pokemonName);
    validateStatusCode(response, 200);

    return response.as(PokemonResponse.class);
  }
}

