@CrateUserBookStore
Feature: Create a new user in the book store

  @CreateEmpty
  Scenario: Creating user using empty values
    Given I go to the bookstore webpage to create a user
    When I click the button "login"
    Then I check I have gone to the page "https://demoqa.com/login"
    When I click the button "newUser"
    Then I check I have gone to the page "https://demoqa.com/register"
    Then I check the input "firstname" is not displayed as error
    Then I check the input "lastname" is not displayed as error
    Then I check the input "userName" is not displayed as error
    Then I check the input "password" is not displayed as error
    And I take a bookstore register screenshot with filename "emptyValuesBefore"
    When I click the button "register"
    Then I check the input "firstname" is displayed as error
    Then I check the input "lastname" is displayed as error
    Then I check the input "userName" is displayed as error
    Then I check the input "password" is displayed as error
    And I take a bookstore register screenshot with filename "emptyValuesAfter"
    And I quit the bookstore register webpage

  @CreateBadPassword
  Scenario: Creating user using not accepted password
    Given I go to the bookstore webpage to create a user
    When I click the button "login"
    Then I check I have gone to the page "https://demoqa.com/login"
    When I click the button "newUser"
    Then I check I have gone to the page "https://demoqa.com/register"
    And I take a bookstore register screenshot with filename "badPasswordStart"
    Then I fill the input "firstname" with the value "TestFirstName"
    Then I fill the input "lastname" with the value "TestLastName"
    Then I fill the input "userName" with the value "TestUserName"
    Then I fill the input "password" with the value "invalid_password"
    And I take a bookstore register screenshot with filename "badPasswordFilled"
    When I click the button "register"
    Then I check the error box displays: "Please verify reCaptcha to register!"
    Then I click the reCaptcha
    And I take a bookstore register screenshot with filename "badPasswordReCaptcha"
    When I click the button "register"
    Then I check the error box displays: "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."
    And I take a bookstore register screenshot with filename "badPasswordEnd"
    And I quit the bookstore register webpage

  @CreateOk
  Scenario: Create a user successfully
    Given I go to the bookstore webpage to create a user
    When I click the button "login"
    Then I check I have gone to the page "https://demoqa.com/login"
    When I click the button "newUser"
    Then I check I have gone to the page "https://demoqa.com/register"
    Then I fill the input "firstname" with the value "TestFirstName"
    Then I fill the input "lastname" with the value "TestLastName"
    Then I fill the input "userName" with the value "TestUserName"
    Then I fill the input "password" with the value "P@$w0rd_00"
    Then I click the reCaptcha
    And I take a bookstore register screenshot with filename "loginSuccessfulFill"
    Then I chek the use
    And I quit the bookstore register webpage