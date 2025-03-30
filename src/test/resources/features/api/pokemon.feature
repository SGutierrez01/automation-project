@api @pokemon
Feature: Pokémon API search
  As a user of the Pokémon API
  I want to search Pokémon by name
  So that I can verify valid and invalid results

  @positive
  Scenario Outline: Get Pokémon by valid name
    When I send a GET request with name "<name>"
    Then the response should return status code 200
    And the response should contain the name "<name>"
    And the response should contain the expected id "<id>"

    Examples:
      | name       | id |
      | pikachu    | 25 |
      | charmander | 4  |
      | squirtle   | 7  |

  @negative
  Scenario Outline: Get Pokémon by invalid name
    When I send a GET request with name "<name>"
    Then the response should return status code 404

    Examples:
      | name           |
      | invalidpokemon|
      | missingno      |
      | 12345          |

  @performance
  Scenario Outline: Validate response time for Pokémon endpoint
    When I send a GET request with name "<name>"
    Then the response time should be less than 2000 milliseconds

    Examples:
      | name       |
      | pikachu    |
      | squirtle   |
      | charmander |
