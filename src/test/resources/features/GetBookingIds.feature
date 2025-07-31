Feature: Retrieve all existing booking IDs

  Scenario: User gets the IDs of all bookings
    When User sends the GET request for booking
    Then The response status code should be 200
    And The response should contain a list of the booking IDs

  Scenario: User gets the IDs of bookings filtered by first name and second name
    When User sends the GET request for booking with name filter "John" "Smith"
    Then The response status code should be 200
    And The response should contain a list of the booking IDs

  Scenario: User does not get the IDs of booking filtered by empty first name and empty second name
    When User sends the GET request for booking with name filter "" ""
    Then The response status code should be 200
    And The response body should have empty JSON array

  Scenario: User gets the IDs of bookings filtered by an incorrect first name and second name
    When User sends the GET request for booking with an incorrect name filter "Rock!" "20200112"
    Then The response status code should be 200
    And The response body should have empty JSON array

  Scenario: User gets the IDs of all booking filtered by check in date
    When User sends the GET request booking with the check in date filter "2018-01-01"
    Then The response status code should be 200
    And The response should contain a list of the booking IDs

  Scenario: User gets the IDs of all booking filtered by check out date
    When User sends the GET request for booking with the check in date filter "2019-01-01"
    Then The response status code should be 200
    And The response should contain a list of the booking IDs

  Scenario: User gets the IDs of all booking filtered by check in and check out dates
    When User sends the GET request for booking with filters: check in "2000-01-01" and check out "2019-01-01"
    Then The response status code should be 200
    And The response should contain a list of the booking IDs

  Scenario: User gets the IDs of all booking filtered by empty check in and check out dates
    When User sends the GET request for booking with filters: check in "" and check out ""
    Then The response status code should be 500
    And The response body should have "Internal Server Error" text

  Scenario: User does not get the IDs of booking filtered by incorrect check in and check out dates
    When User sends the GET request for booking with filters: check in "20000101" and check out "2019.01.01"
    Then The response status code should be 500
    And The response body should have "Internal Server Error" text

  Scenario: User does not get the IDs of booking filtered by incorrect check in and check out dates
    When User sends the GET request for booking with filters: check in "20000101" and check out "2019.01.01"
    Then The response status code should be 500
    And The response body should have "Internal Server Error" text
