Feature: Confirm Password must Match

  Background:
    Given the user is on the login page

  @testcase_#L01
  Scenario Outline: Password Confirmation with Wrong Password
    Given I click on registration button
    When I am on registration page
    And I enter '<fName>' to FirstName field
    And I enter '<lName>' to LastName field
    And I enter '<birthdate>' to Birthday field
    And I enter '<email>' to Email field
    And I enter '<password>' to Password field
    And I enter '<wrongPassword>' to ConfirmPassword field
    Then I see error message
    And I retrieve error message to validate

    Examples:
      | fName | lName | birthdate  | email                | password     | wrongPassword |
      | Megan | Boone | 03/23/2000 | mboone35@example.com | mb-mb.123456 | 123456.mb-mb  |
