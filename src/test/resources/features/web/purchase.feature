@web @purchase
Feature: Purchase a product on SauceDemo
  As a logged-in user
  I want to buy the cheapest product
  So that I can complete the purchase successfully

  Background:
    Given I open the SauceDemo login page

  @positive
  Scenario Outline: Complete purchase flow with valid client data
    And I am logged in as "<username>" with password "<password>"
    When I add the cheapest product to the cart
    And I open the cart
    Then I should see the cheapest product
    And I proceed to checkout
    And I fill in first name "<firstName>", last name "<lastName>", and postal code "<postalCode>"
    And I proceed to overview
    And I complete the purchase
    Then I should see the message "Thank you for your order!!!"

    Examples:
      | username       | password      | firstName | lastName | postalCode |
      | standard_user  | secret_sauce  | John      | Doe      | 12345      |