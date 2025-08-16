Feature: Create a new bookings with basic information

  Scenario: The user creates a new booking
    Given Generate booking data
    When The user send POST request with generated data
    Then The response status code should be 200
    And The response should have created booking details

  Scenario: The user tries to create a new booking without booking data
    Given Generate an empty body
    When The user send POST request with generated data
    Then The response status code should be 500
    And The response body should have "Internal Server Error" text
