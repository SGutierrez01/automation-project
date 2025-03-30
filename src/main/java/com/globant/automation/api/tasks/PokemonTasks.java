package com.globant.automation.api.tasks;

import com.globant.automation.api.models.PokemonResponse;
import com.globant.automation.api.services.PokemonServices;
import io.restassured.response.Response;

import static com.globant.automation.core.utils.TestContextManager.getTestContext;


public class PokemonTasks extends PokemonServices {

  public void sendGetRequestForPokemon(String pokemonName) {
    Response response = sendGetRequest("/" + pokemonName);
    getTestContext().set("pokemonResponse", response);
  }

  public void measureResponseTimeFor(String pokemonName) {
    long start = System.currentTimeMillis();
    Response response = sendGetRequest("/" + pokemonName);
    long end = System.currentTimeMillis();
    long time = end - start;
    getTestContext().set("responseTime", time);
    getTestContext().set("timedResponse", response);
  }
}
