Feature: Test text box element of a webPage

  Scenario: Text Box
    Given I go to Text Box webpage "https://demoqa.com/text-box"
    Then I check "userName" text box is empty
    And I check "userEmail" text box is empty
    And I check "currentAddress" text box is empty
    And I check "permanentAddress" text box is empty
    And I take a text box page screenshot with fileName "TextBoxStart"
    Then I fill "userName" text box with text "TestName TestSurname"
    And I check "userEmail" text box is displayed as "form-control"
    And I fill "userEmail" text box with text "invalid mail"
    And I click text box page "submit" button
    And I check "userEmail" text box is displayed as "field-error"
    And I clean "userEmail" text box
    And I fill "userEmail" text box with text "testing@testmail.com"
    And I fill "currentAddress" text box with text "Testing current address"
    And I fill "permanentAddress" text box with text "Testing permanent address"
    And I click text box page "submit" button
    And I should see a "output" box with the following text box results test:
      | name              | TestName TestSurname      |
      | email             | testing@testmail.com      |
      | currentAddress    | Testing current address   |
      | permanentAddress  | Testing permanent address |
    And I take a text box page screenshot with fileName "TextBoxEnd"
    And I close the Text Box webpage