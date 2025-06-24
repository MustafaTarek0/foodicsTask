@test
Feature: Create a user via API using POST request

  As a QA Automation Engineer
  I want to create a user on https://reqres.in using a POST request
  So that I can verify that user creation works as expected

  Scenario Outline: Successfully create a user with valid JSON payload
    Given the API base URL is set
    And I have the JSON payload from file "<jsonFileName>"
    When I send a "<method>" request to "/api/users"
    Then the response status code should be "<statusCode>"
    And the response should contain a user ID ,email ,firstName ,lastName , avatar , updated At

    Examples:
      | jsonFileName|method|statusCode|
      | postApiData     |post  |201       |


  Scenario Outline: Successfully get all users
    Given the API base URL is set
    When I send a "<method>" request to "/api/users/<userID>"
    Then the response status code should be "<statusCode>"
    And the response should contain a user ID ,email ,firstName ,lastName , avatar , avatar

    Examples:
      |method|statusCode|userID|
      |get  |200       |2      |


  Scenario Outline: Successfully update a user with valid JSON payload
    Given the API base URL is set
    And I have the JSON payload from file "<jsonFileName>"
    When I send a "<method>" request to "/api/users/<userID>"
    Then the response status code should be "<statusCode>"
    And the response should contain a user ID ,email ,firstName ,lastName , avatar , updated At

    Examples:
      | jsonFileName|method|statusCode|userID|
      | putApiData     |put  |200     |2     |
