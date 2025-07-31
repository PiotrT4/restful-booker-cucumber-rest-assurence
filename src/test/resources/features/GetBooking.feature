Feature: Retrieve a specific booking based on the booking ID provided

  Scenario: User get the specific booking based on the booking ID
    Given Select one existing booking ID
    When The user sends the GET request for booking with the existing booking ID
    Then The response status code should be 200
    And The response should have booking details

  Scenario: User gets the details of booking by ID
    Given Select one existing booking ID
    When The user sends the GET request for booking with the existing booking ID
    Then The response status code should be 200
    And The response should have booking details

  Scenario: User does not get the details of booking by incorrect ID
    When User sends the GET request for booking with ID -200
    Then The response status code should be 404
    And The response body should have "Not Found" text
