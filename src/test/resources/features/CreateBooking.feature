Feature: Create a new bookings with basic information

  Scenario: User positive creates a new booking
    Given Generate booking data
    When The user send POST request with generated data
    Then The response status code should be 200
    And The response should have created booking details
