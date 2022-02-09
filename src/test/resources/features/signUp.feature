Feature: Sign up
  I am registering on the site
  To create an account

  Scenario: Successful sign up
    Given Open Home page
    When Open Registration page
    And Fill registration form with valid data
    Then New account is created
    And It is possible to log in to this account