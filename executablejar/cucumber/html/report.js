$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Example.feature");
formatter.feature({
  "line": 1,
  "name": "Example feature",
  "description": "",
  "id": "example-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 36179677968,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Add New Email",
  "description": "",
  "id": "example-feature;add-new-email",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "prospective user with email \"user@example.com\" pre-exists",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "email \"user@example.com\" is not pre-registered",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "user submits add \"user@example.com\" form",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "email \"user@example.com\" is registered",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "user@example.com",
      "offset": 29
    }
  ],
  "location": "ExampleSteps.prospective_user_with_email_pre_exists(String)"
});
formatter.result({
  "duration": 1332125923,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user@example.com",
      "offset": 7
    }
  ],
  "location": "ExampleSteps.email_is_not_pre_registered(String)"
});
formatter.result({
  "duration": 762080,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user@example.com",
      "offset": 18
    }
  ],
  "location": "ExampleSteps.user_submits_add_form(String)"
});
formatter.result({
  "duration": 692372,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user@example.com",
      "offset": 7
    }
  ],
  "location": "ExampleSteps.email_is_registered(String)"
});
formatter.result({
  "duration": 1236347,
  "status": "passed"
});
formatter.after({
  "duration": 4104744008,
  "status": "passed"
});
});