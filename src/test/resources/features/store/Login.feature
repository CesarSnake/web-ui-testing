@Login
Feature: Login to the book store

  Scenario: Login using empty values
    Given I go to the store webpage
    Then I check the input "user-name" is empty
    Then I check the input "password" is empty
    Then I check the login error container is empty
    When I click the login button
    Then I check the input "user-name" is displayed as error
    Then I check the input "password" is displayed as error
    Then I check the error container displays the message: "Epic sadface: Username is required"
    And I take a screenshot with filename "loginEmpty"
    And I close the store webpage

  Scenario: Login using invalid password
    Given I go to the store webpage
    Then I check the input "user-name" is empty
    Then I check the input "password" is empty
    Then I check the login error container is empty
    Then I fill the input "user-name" with the value "standard_user"
    Then I fill the input "password" with the value "bad_password"
    When I click the login button
    Then I check the input "user-name" is displayed as error
    Then I check the input "password" is displayed as error
    Then I check the error container displays the message: "Epic sadface: Username and password do not match any user in this service"
    And I take a screenshot with filename "loginBadPassword"
    And I close the store webpage

  Scenario: Login using a locked out user
    Given I go to the store webpage
    Then I check the input "user-name" is empty
    Then I check the input "password" is empty
    Then I check the login error container is empty
    Then I fill the input "user-name" with the value "locked_out_user"
    Then I fill the input "password" with the value "secret_sauce"
    When I click the login button
    Then I check the input "user-name" is displayed as error
    Then I check the input "password" is displayed as error
    Then I check the error container displays the message: "Epic sadface: Sorry, this user has been locked out."
    And I take a screenshot with filename "loginLockedUser"
    And I close the store webpage

  Scenario: Login using valid credentials
    Given I go to the store webpage
    Then I check the input "user-name" is empty
    Then I check the input "password" is empty
    Then I check the login error container is empty
    Then I fill the input "user-name" with the value "standard_user"
    Then I fill the input "password" with the value "secret_sauce"
    When I click the login button
    Then I check the webpage has changed to "https://www.saucedemo.com/inventory.html"
    And I take a screenshot with filename "successLogin"
    And I close the store webpage
