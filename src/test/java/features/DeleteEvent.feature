Feature: Delete events
  This feature deals with the delete events functionality of the application

  Scenario: Login with correct username and password
    Given Calendar page is opened
      | username             | password |
      | calendartesting12358 | _ZD8:t9Q |
    Then I should see the Calendar button
    When I delete an all day event
    Then The removed event should not be displayed in the calendar
