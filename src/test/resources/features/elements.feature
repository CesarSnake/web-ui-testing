Feature: Test Elements of a WebPage

  Scenario: Text Box
    Given I go to Text Box webpage
    Then I fill "userName" text box element with text "TestName TestSurname"
    And I fill "userEmail" text box element with text "test@testmail.com"
    And I fill "currentAddress" text box element with text "Testing n00, address"
    And I fill "permanentAddress" text box element with text "Super permanent address"
    And I click "submit" button
#    Then I should see a "output" box with the following textBox keys |"TestName TestSurname", "test@testmail.com", "Testing n00, address", "Super permanent address"|
    And I take a screenshot with fileName "TextBox"
    And I close the webpage