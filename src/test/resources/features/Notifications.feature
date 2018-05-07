@Notifications
Feature: Sending notifications
  This feature deals with the notifications functionality of the application

  Background: I log in to Google
    Given I am logged in
    Then I should see the Create Event button

  @current
  Scenario Outline:
    When I click on the Search icon
    And I type the created "<name>" event to the search field
    And I click on the search button
    Then search result page should be displayed
    And searched "<name>" event should appear on search result page

    When I click on the name of the "<name>" event
    Then event preview should be displayed
    And notification icon should not be displayed on preview page

    When I click on the Edit button on event preview page
    Then the creating event page should be displayed

    When I change the date for the event
    And I select "<notificationType>" from notification dropdown
    And I add "<number>" number to notification
    And I select "<unit>" from unit notification dropdown
    And I click on the Save button
    Then email should be delivered with "<name>" and "<email-address>" before "<number>" "<unit>" of even start

    Examples:
      | name         | notificationType | number | unit    | email-address                  |
      | notification | Email            | 10     | minutes | calendartesting12358@gmail.com |
