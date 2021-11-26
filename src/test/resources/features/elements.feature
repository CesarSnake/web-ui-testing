Feature: Test Elements of a WebPage

  Scenario: Text Box
    Given I go to Text Box webpage "https://demoqa.com/text-box"
    Then I fill "userName" text box element with text "TestName TestSurname"
    And I check "userEmail" text box element is displayed as "form-control"
    And I fill "userEmail" text box element with text "invalid mail"
    And I click "submit" button
    And I check "userEmail" text box element is displayed as "field-error"
    And I clean "userEmail" text box element
    And I fill "userEmail" text box element with text "testing@testmail.com"
    And I fill "currentAddress" text box element with text "Testing current address"
    And I fill "permanentAddress" text box element with text "Testing permanent address"
    And I click "submit" button
    And I should see a "output" box with the following text:
      | name              | TestName TestSurname      |
      | email             | testing@testmail.com      |
      | currentAddress    | Testing current address   |
      | permanentAddress  | Testing permanent address |
#    Then I should see a "output" box with the following textBox keys |"TestName TestSurname", "test@testmail.com", "Testing n00, address", "Super permanent address"|
    And I take a screenshot with fileName "TextBox"
    And I close the webpage