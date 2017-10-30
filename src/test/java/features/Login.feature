Feature: Login
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    When I enter the following for email address
      | username |
      | calendartesting12358 |
    And I click on Next button
    Then I should see the password field
    When I enter the following for password
      | password |
      | _ZD8:t9Q |
    And I click on Next button
    Then I should see the Calendar button
    When I click on my picture
    And I click on Sign Out
    Then I should see the password field


  Scenario: Login with invalid username
    Given I navigate to the login page
    When I enter the following for email address
      | username |
      | test |
    And I click on Next button
    Then I should see the Next button

  Scenario: Login with valid username and invalid password
    Given I navigate to the login page
    When I enter the following for email address
      | username |
      | szilvi93 |
    And I click on Next button
    Then I should see the password field
    When I enter the following for password
      | password |
      | invalidpassword |
      | invalidpassword2 |
    And I click on Next button
    Then I should see the Next button

  Scenario: I should not navigate to the password field without entering their email address
    Given I navigate to the login page
    When I click on Next button
    Then I should see the email field



