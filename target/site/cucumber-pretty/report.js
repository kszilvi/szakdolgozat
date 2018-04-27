$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CreateEvent.feature");
formatter.feature({
  "line": 1,
  "name": "Create events",
  "description": "This feature deals with the create events functionality of the application",
  "id": "create-events",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Create an all day event",
  "description": "",
  "id": "create-events;create-an-all-day-event",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@current"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Calendar page is opened",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 7
    },
    {
      "cells": [
        "calendartesting12358",
        "_ZD8:t9Q"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I should see the Calendar button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I click on Create button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I create an all day event",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "All day event should be displayed in the calendar",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});