Feature: Retrieve a specific booking based on the booking ID provided

  Scenario: User get the specific booking based on the booking ID
    Given Select one existing booking ID
    When The user sends the GET request for booking with the existing booking ID
    Then The response status code be 200
