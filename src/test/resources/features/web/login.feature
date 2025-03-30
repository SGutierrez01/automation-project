@web @login
Feature: Login to SauceDemo
  As a user of the SauceDemo website
  I want to log in with different users
  So that I can verify login success and error messages

  Background:
    Given I open the SauceDemo login page

  @positive
  Scenario Outline: Successful login with valid user
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should be redirected to the inventory page

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |

  @negative
  Scenario Outline: Login with locked out user
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message containing "locked out"

    Examples:
      | username        | password      |
      | locked_out_user| secret_sauce  |

  @negative
  Scenario Outline: Login with invalid credentials
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message containing "do not match"

    Examples:
      | username      | password   |
      | wrong_user    | wrong_pass |