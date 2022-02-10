Feature: Enquiry
  I create an enquiry
  To order to make a special request

  @negative
  Scenario Outline: Create a enquiry with invalid data
    Given Open Berlin page
    And Click on the first restaurant
    When Click on Make an enquiry button
    And Fill Enquiry form fields with invalid data
      | email   | firstName   | lastName   | phone   |
      | <email> | <firstName> | <lastName> | <phone> |
    And Click on Send enquiry button
    Then Error message <num> appears
    """
    <errorMsg>
    """
    Examples: This is an invalid data
      | email         | firstName | lastName | phone      | num | errorMsg                                        |
      | abb21@        | Martin    | King     | 1621623456 | 1   | Wrong format. Please enter valid email address. |
      | abb21@mail.ru |           | King     | 1621623456 | 2   | Enter first name                                |
      | abb21@mail.ru | Martin    |          | 1621623456 | 3   | Enter last name                                 |
      | abb21@mail.ru | Martin    | King     | 1234phon   | 4   | This field must contain digits only             |
      | abb21@mail.ru | Martin    | King     | 1234567    | 5   | Enter valid phone number                        |
