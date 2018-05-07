@CreatingDifferentTypesOfEvents
Feature: Create events
  This feature deals with the create events functionality of the application

  Background: I log in to Google
    Given I am logged in
    Then I should see the Create Event button


  Scenario Outline: Creating multiple events
    When I click on Create button
    Then the creating event page should be displayed

    When I type "<name>" to title field
    And I check the All day check box
    And I check the All day check box
    And I add "<from date>" to from date field
    And I add "<until date>" to until date field
    And I add "<from time>" and "<unit from>" to from time field
    And I add "<until time>" and "<unit until>" to until time field
    And I click on the Save button
    Then I should see the Create Event button
    And message should appear with the following text: "<message>"

    When I click on the Search icon
    And I type the created "<name>" event to the search field
    And I click on the search button
    Then search result page should be displayed
    And created "<name>" event should be displayed in the search result list from "<from date>" to "<until date>"

    Examples:
      | name                        | from date   | from time | unit from | until date  | until time | unit until | message     |
      | Multiple day long event 140 | 10 Jun 2018 | 1:30      | pm        | 13 Jun 2018 | 6:30       | pm         | Event saved |

  Scenario Outline: Trying to create incorrect events
    When I click on Create button
    Then the creating event page should be displayed

    When I type "<name>" to title field
    And I check the All day check box
    And I check the All day check box
    And I add "<from date>" to from date field
    And I add "<from time>" and "<unit from>" to from time field
    And I add "<until time>" and "<unit until>" to until time field
    And I add "<until date>" to until date field
    And I click on the Save button
    Then I should see the Create Event button
    And message should appear with the following text: "<message>"

    When I click on the Search icon
    And I type the created "<name>" event to the search field
    And I click on the search button
    Then search result page should be displayed
    And No results found should be displayed

    Examples:
      | name                        | from date   | from time | unit from | until date  | until time | unit until | message                                                                 |
      | Multiple day long event 141 | 10 Jun 2018 | 1:30      | pm        | 9 Jun 2018  | 1:00       | pm         | Oops, we couldn't create this event. Please try again in a few minutes. |
      | Multiple day long event 138 | 10 Jun 2018 | 1:30      | pm        | 10 Jun 2018 | 1:00       | pm         | Oops, we couldn't create this event. Please try again in a few minutes. |







