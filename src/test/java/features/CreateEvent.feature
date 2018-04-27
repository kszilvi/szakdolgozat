@CreatingDifferentTypesOfEvents
Feature: Create events
  This feature deals with the create events functionality of the application

  Background: I log in to Google
    Given I am logged in
    Then I should see the Create Event button

  @current
  Scenario Outline: Creating multiple events
    When I click on Create button
    Then The creating new event page should be displayed

    When I type "<name>" to title field
    And I check the All day check box
    And I check the All day check box
    And I add "<from date>" to from date field
    And I add "<until date>" to until date field
    And I add "<from time>" to from time field
    And I add "<until time>" to until time field
    And I click on the Save button
    Then I should see the Create Event button
    And Message should appear with the following text: "<message>"

    When I click on the Search icon
    And I type the created "<name>" event to the search field
    And I click on the search button
    Then Search result page should be displayed

    When I click on the created "<name>" event
    And I click on the Edit button
    Then Event editing page should be displayed

    Examples:
      | name                       | from date   | from time | until date  | until time | message                                                                 |
      | Multiple day long event 66 | 13 Jun 2018 | 1:30pm    | 15 Jun 2018 | 6:30pm     | Event saved                                                             |
      | Multiple day long event 70 | 20 Jun 2018 | 13:30pm   | 15 Jun 2018 | 6:30pm     | Oops, we couldn't create this event. Please try again in a few minutes. |





