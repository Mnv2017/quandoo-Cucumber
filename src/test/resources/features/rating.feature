Feature: Rating of Restaurants

  Scenario: Equality of restaurant ratings

    Given Open Home page
    Given Navigate to Berlin page
    When Save a restaurant rating value in the list
    And Click on the restaurant
    Then Ratings on restaurant view card are equal to rating value

