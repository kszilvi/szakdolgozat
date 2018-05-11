@EditEvents
Feature: Edit events
  This feature deals with the delete events functionality of the application

  Background: I log in to Google
    Given I am logged in
    Then I should see the Create Event button

  @current
  Scenario Outline: Editing events with "<name>" name
    When I click on Create button
    Then the creating event page should be displayed

    When I type "<name>" to title field
    And I click on the Save button

    When I click on the Search icon
    And I type the created "<name>" event to the search field
    And I click on the search button
    Then search result page should be displayed
    And searched "<name>" event should appear on search result page

    When I click on the name of the "<name>" event
    Then event preview should be displayed

    When I click on the Edit button on event preview page
    Then the creating event page should be displayed

    When I type "<location>" location to the selected event
    And I type "<description>" description to the selected event
    And I click on the Save button

    When I click on the name of the "<name>" event
    Then event preview should be displayed
    And "<location>" location should be displayed in the preview pane
    And "<description>" description should be displayed in the preview pane

    Examples:
      | name             | location | description             |
      | Multiple day 188 |          | disco disco party party |





