Feature: Edit events
  This feature deals with the delete events functionality of the application

  Scenario: Login with correct username and password
    Given Calendar page is opened
      | username             | password |
      | calendartesting12358 | _ZD8:t9Q |
    Then I should see the Calendar button
    When I select a multiple day event
    And I add a location to the selected event
    Then The location should be displayed
