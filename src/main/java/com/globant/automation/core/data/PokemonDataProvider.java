package com.globant.automation.core.data;

import org.testng.annotations.DataProvider;

public class PokemonDataProvider {

  @DataProvider(name = "validPokemonNames")
  public static Object[][] validPokemonNames() {
    return new Object[][]{
        {"pikachu", 25},
        {"charmander", 4},
        {"squirtle", 7}
    };
  }

  @DataProvider(name = "invalidPokemonNames")
  public static Object[][] invalidPokemonNames() {
    return new Object[][]{
        {"invalidpokemon"},
        {"missingno"},
        {"12345"}
    };
  }
}
