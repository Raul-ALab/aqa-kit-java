Feature: Identical Error Messages

  Scenario Outline: User Attempts to Login with Invalid Email
    Given The login page is accessed
    When I input invalid '<invalid email>' email and valid '<password>' password
    And I click Sign in button
    Then I should get an invalid credentials error for invalid email
    And I switch to a new tab to reopen login page
    When I input correct '<email>' email and invalid '<invalid password>' password
    And I click Sign in button
    Then I should get an invalid credentials error for invalid password
    And Error messages similarity from both cases is verified

    Examples:
      | invalid email          | password    | email                | invalid password |
      | mboone1200@example.com   | mbmb.123456 | mboone12@example.com | 654.mbmb.123456  |




