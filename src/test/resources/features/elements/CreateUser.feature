@CrateUserBookStore
Feature: Create a new user in the book store

  @CreateEmpty
  Scenario: Creating user using empty values
    Given I go to the elements webpage "books"
    When I click the elements button "login"
    Then I check the web page has changed to "https://demoqa.com/login"
    When I click the elements button "newUser"
    Then I check the web page has changed to "https://demoqa.com/register"
    Then I check the textBox "firstname" is empty
    Then I check the textBox "lastname" is empty
    Then I check the textBox "userName" is empty
    Then I check the textBox "password" is empty
    Then I check the textBox "firstname" is displayed as "form-control"
    Then I check the textBox "lastname" is displayed as "form-control"
    Then I check the textBox "userName" is displayed as "form-control"
    Then I check the textBox "password" is displayed as "form-control"
    And I take an elements screenshot with fileName "emptyValuesBefore"
    When I click the elements button "register"
    Then I check the textBox "firstname" is displayed as "is-invalid"
    Then I check the textBox "lastname" is displayed as "is-invalid"
    Then I check the textBox "userName" is displayed as "is-invalid"
    Then I check the textBox "password" is displayed as "is-invalid"
    And I take an elements screenshot with fileName "emptyValuesAfter"
    And I quit the elements webpage

  @CreateBadPassword
  Scenario: Creating user using not accepted password
    Given I go to the elements webpage "books"
    When I click the elements button "login"
    Then I check the web page has changed to "https://demoqa.com/login"
    When I click the elements button "newUser"
    Then I check the web page has changed to "https://demoqa.com/register"
    And I take an elements screenshot with fileName "badPasswordStart"
    Then I fill the textBox "firstname" with the text "TestFirstName"
    Then I fill the textBox "lastname" with the text "TestLastName"
    Then I fill the textBox "userName" with the text "TestUserName"
    Then I fill the textBox "password" with the text "invalid_password"
    And I take an elements screenshot with fileName "badPasswordFilled"
    When I click the elements button "register"
    Then I check the error box displays: "Please verify reCaptcha to register!"
    Then I click the reCaptcha
    And I take an elements screenshot with fileName "badPasswordReCaptcha"
    # step created to check the page has launched the reCaptcha images
    Then I check the reCaptcha displays a grid to choose images

    ## I cannot launch those steps due the reCAPTCHA displays a grid to choose images and right now I cannot automatize it
    # When I click the elements button "register"
    # Then I check the error box displays: "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."
    # And I take an elements screenshot with fileName "badPasswordEnd"
    And I quit the elements webpage

  @CreateOk
  Scenario: Create a user successfully
    Given I go to the elements webpage "books"
    When I click the elements button "login"
    Then I check the web page has changed to "https://demoqa.com/login"
    When I click the elements button "newUser"
    Then I check the web page has changed to "https://demoqa.com/register"
    Then I fill the textBox "firstname" with the text "TestFirstTQS"
    Then I fill the textBox "lastname" with the text "TestLastTQS"
    Then I fill the textBox "userName" with the text "test_tqs"
    Then I fill the textBox "password" with the text "P@$w0rd_00"
    Then I click the reCaptcha
    And I take an elements screenshot with fileName "loginSuccessfulFill"
    # step created to check the page has launched the reCaptcha images
    Then I check the reCaptcha displays a grid to choose images

    ## same as previous scenario, # I cannot launch this step due the reCAPTCHA displays a grid to choose images and right now I cannot automatize it
    # When I click the elements button "register"
    # Then I chek the user has been created
    And I quit the elements webpage