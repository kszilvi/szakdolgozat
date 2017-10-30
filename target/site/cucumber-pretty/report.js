$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "This feature deals with the login functionality of the application",
  "id": "login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2914018000,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login with correct username and password",
  "description": "",
  "id": "login;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter the following for email address",
  "rows": [
    {
      "cells": [
        "username"
      ],
      "line": 7
    },
    {
      "cells": [
        "calendartesting12358"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I should see the password field",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I enter the following for password",
  "rows": [
    {
      "cells": [
        "password"
      ],
      "line": 12
    },
    {
      "cells": [
        "_ZD8:t9Q"
      ],
      "line": 13
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I should see the Calendar button",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I click on my picture",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I click on Sign Out",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I should see the password field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1263593533,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterTheFollowingForEmailAddress(DataTable)"
});
formatter.result({
  "duration": 295038197,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnNextButton()"
});
formatter.result({
  "duration": 158719988,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeThePasswordField()"
});
formatter.result({
  "duration": 5058433644,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterTheFollowingForPassword(DataTable)"
});
formatter.result({
  "duration": 102911649,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnNextButton()"
});
formatter.result({
  "duration": 100603877,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheNaptarButton()"
});
formatter.result({
  "duration": 5047836654,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnMyPicture()"
});
formatter.result({
  "duration": 222543820,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnSignOut()"
});
formatter.result({
  "duration": 1600703247,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeThePasswordField()"
});
formatter.result({
  "duration": 5055145477,
  "status": "passed"
});
formatter.after({
  "duration": 80244761,
  "status": "passed"
});
formatter.before({
  "duration": 1744926567,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Login with invalid username",
  "description": "",
  "id": "login;login-with-invalid-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I enter the following for email address",
  "rows": [
    {
      "cells": [
        "username"
      ],
      "line": 24
    },
    {
      "cells": [
        "test"
      ],
      "line": 25
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I should see the Next button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1215554508,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterTheFollowingForEmailAddress(DataTable)"
});
formatter.result({
  "duration": 311330181,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnNextButton()"
});
formatter.result({
  "duration": 148006023,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheNextButton()"
});
formatter.result({
  "duration": 51862150,
  "status": "passed"
});
formatter.after({
  "duration": 77213164,
  "status": "passed"
});
formatter.before({
  "duration": 2585315756,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Login with valid username and invalid password",
  "description": "",
  "id": "login;login-with-valid-username-and-invalid-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I enter the following for email address",
  "rows": [
    {
      "cells": [
        "username"
      ],
      "line": 32
    },
    {
      "cells": [
        "szilvi93"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "I click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I should see the password field",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "I enter the following for password",
  "rows": [
    {
      "cells": [
        "password"
      ],
      "line": 37
    },
    {
      "cells": [
        "invalidpassword"
      ],
      "line": 38
    },
    {
      "cells": [
        "invalidpassword2"
      ],
      "line": 39
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "I click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I should see the Next button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1058541395,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterTheFollowingForEmailAddress(DataTable)"
});
formatter.result({
  "duration": 176891036,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnNextButton()"
});
formatter.result({
  "duration": 124000141,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeThePasswordField()"
});
formatter.result({
  "duration": 5053629581,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterTheFollowingForPassword(DataTable)"
});
formatter.result({
  "duration": 255289222,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnNextButton()"
});
formatter.result({
  "duration": 105846523,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheNextButton()"
});
formatter.result({
  "duration": 37547414,
  "status": "passed"
});
formatter.after({
  "duration": 74829184,
  "status": "passed"
});
formatter.before({
  "duration": 1321420804,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "I should not navigate to the password field without entering their email address",
  "description": "",
  "id": "login;i-should-not-navigate-to-the-password-field-without-entering-their-email-address",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 44,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "I click on Next button",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I should see the email field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1079588842,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickOnNextButton()"
});
formatter.result({
  "duration": 152100981,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheEmailField()"
});
formatter.result({
  "duration": 55574827,
  "status": "passed"
});
formatter.after({
  "duration": 73325133,
  "status": "passed"
});
});