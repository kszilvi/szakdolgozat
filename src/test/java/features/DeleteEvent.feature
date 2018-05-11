@DeleteEvents
Feature: Delete events
  This feature deals with the delete events functionality of the application

  Background: I log in to Google
    Given I am logged in
    Then I should see the Create Event button

  Scenario Outline: Deleting events with "<name>"
    When I click on Create button
    Then the creating event page should be displayed

    When I type "<name>" to title field
    And I click on the Save button
    And I click on the Search icon
    And I type the created "<name>" event to the search field
    And I click on the search button
    Then search result page should be displayed
    And searched "<name>" event should appear on search result page

    When I click on the name of the "<name>" event
    Then event preview should be displayed

    When I click on delete event icon button
    Then "<name>" event should not appear on search result page

    Examples:
      | name                          |
      | Multiple day long event 142__ |

