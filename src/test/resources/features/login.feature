Feature: Login
  I have an account and sign in
  To book the table in the restaurant

  Background:
    Given  Open Home page
    When Open Login page

  Scenario Outline: Login with valid data
    And Fill the login form with email <email> and password <password>
    Then Log in is complete
    Examples: This is a valid data
      | email           | password    |
      | nnn123@mail.com |  Qwerty123$ |

    @negative
  Scenario Outline: Login with invalid data
    And Fill the login form with email <email> and password <password>
    Then Error message appears
    """
    <errorMesage>
    """
    Examples: This is an invalid data
      | email           | password    | errorMesage                       |
      | nnn123@mail     |  Qwerty123$ | Enter valid username or password  |
      | nnn123@mail.com |  erty123$   | Enter valid username or password  |
      | nnn123@mail.com |             | Enter valid username or password  |
      |                 |  erty123$   | Enter valid username or password  |
