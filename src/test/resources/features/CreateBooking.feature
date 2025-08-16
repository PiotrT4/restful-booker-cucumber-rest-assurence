Feature: Create a new bookings with basic information

  Scenario: The user creates a new booking
    Given Generate "valid" body of booking data
    When The user send POST request with generated body
    Then The response status code should be 200
    And The response should have created booking details

  Scenario: The user tries to create a new booking without booking data
    Given Generate "empty" body of booking data
    When The user send POST request with generated body
    Then The response status code should be 500
    And The response body should have "Internal Server Error" text

  Scenario: The user tries to create a new booking with incorrect booking dates
    Given Generate "invalid" body of booking data
    When The user send POST request with generated body
    Then The response status code should be 500
    And The response body should have "Internal Server Error" text
