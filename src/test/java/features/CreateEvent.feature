Feature: Create events
  This feature deals with the create events functionality of the application

  Scenario: Create an all day event
    Given Calendar page is opened
      | username             | password |
      | calendartesting12358 | _ZD8:t9Q |
    Then I should see the Calendar button
    When I click on Create button
    And I create an all day event
    Then All day event should be displayed in the calendar

  Scenario: Create a short time event
    Given Calendar page is opened
      | username             | password |
      | calendartesting12358 | _ZD8:t9Q |
    Then I should see the Calendar button
    When I click on Create button
    And I create a short time event
    Then The short time event should be displayed in the calendar

  Scenario: Create a multiple day event
    Given Calendar page is opened
      | username             | password |
      | calendartesting12358 | _ZD8:t9Q |
    Then I should see the Calendar button
    When I click on Create button
    And I create a multiple day event
    Then The multiple day event should be displayed in the calendar







