Feature: Filters on Berlin page
  User selects restaurants by filter
  To get a list of restaurants with certain characteristics

  Background:
    Given Open Home page
    Given Navigate to Berlin page

  Scenario: Selection by TopRate on Berlin page
    When Click on TopRate button
    Then Number of restaurants has decreased


  Scenario: Selection by cuisine
    When Set up African checkbox
    Then Number of selected restaurants and African restaurant are equals
    And  All African restaurants are selected

  @firstTest
  Scenario: Search by cuisine
    When Search by word African
    Then African filter is set up
    And All African restaurants are selected