Feature: Create a new user in the book store

  Scenario: Creating user using empty values
    Given I go to the bookstore webpage
    When I click the button "login"
    Then I check I have gone to the page "https://demoqa.com/login"
    When I click the button "newUser"
    Then I check I have gone to the page "https://demoqa.com/register"
    When I click the button "register"
    Then I check the input "firstname" is displayed as error
    Then I check the input "lastname" is displayed as error
    Then I check the input "userName" is displayed as error
    Then I check the input "password" is displayed as error
    And I close the bookstore webpage

    Scenario: Creating user using not accepted password
      Given I go to the bookstore webpage
      When I click the button "login"
      Then I check I have gone to the page "https://demoqa.com/login"
      When I click the button "newUser"
      Then I check I have gone to the page "https://demoqa.com/register"
      Then I fill the input "firstname" with the value "TestFirstName"
      Then I fill the input "lastname" with the value "TestLastName"
      Then I fill the input "userName" with the value "TestUserName"
      Then I fill the input "password" with the value "invalid_password"
      When I click the button "register"
      Then I check the error box displays "Please verify reCaptcha to register!"
      Then I click the reCaptcha
      When I click the button "register"
      Then I check the error box displays: "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."
      And I take a bookstore screenshot with filename "NotAcceptedPassword"
      And I close the bookstore webpage

    Scenario: Create a user successfully
      Given I go to the bookstore webpage
      When I click the button "login"
      Then I check I have gone to the page "https://demoqa.com/login"
      When I click the button "newUser"
      Then I check I have gone to the page "https://demoqa.com/register"
      Then I fill the input "firstname" with the value "TestFirstName"
      Then I fill the input "lastname" with the value "TestLastName"
      Then I fill the input "userName" with the value "TestUserName"
      Then I fill the input "password" with the value "09AZaz#$"
      When I click the button "register"
      Then I check alert is displayed with text "User Register Successfully."
      Then I click OK on the alert
