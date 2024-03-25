Feature: Access to Authenticated Pages after Logout

  @testcase_#L010
  Scenario Outline: Attempt to Access Login Page with Back Button After Logout
    Given I am on the login page
    When I enter '<email>' and '<password>' to Email and Password fields
    And I click on Sign in button
    And I am logged in
    Then I click on Logout and Yes to confirm logout
    And I logged out
    Then I navigate back with back button
    And Logged-in account page should not be accessible.

    Examples:
      | email                | password    |
      | mboone12@example.com | mbmb.123456 |
