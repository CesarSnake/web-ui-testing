 Feature: Login to the book store

   Scenario: Login using empty values
     Given I go to the bookstore webpage
     When I click the button "login"
     Then I check I have gone to the page "https://demoqa.com/login"
     When I press the button "login"
     Then I check input "userName" is displayed as error
     Then I check input "password" is displayed error
     And I take a bookstore screenshot with filename "loginEmpty"
     And I close the bookstore webpage

   Scenario: Login using invalid password
     Given I go to the bookstore webpage
     When I click the button "login"
     Then I check I have gone to the page "https://demoqa.com/login"
     Then I fill the input "userName" with text "test_user"
     When I click the button "login"
     Then I check input "password" displays as error
     And I take a bookstore screenshot with filename "errorPassword"
     Then I fill the input "password" with text "invalid_password"
     When I click the button "login"
     Then I check login error is displayed
     And I take a bookstore screenshot with filename "loginInvalid"
     And I close the bookstore webpage

   Scenario: Login using valid credentials
     Given I go to the bookstore webpage
     When I press the button "login"
     Then I check I have gone to the page "https://demoqa.com/login"

