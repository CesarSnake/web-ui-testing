@TextBox
Feature: Test TextBox element of a webPage

  @TextBoxInvalidMail
  Scenario: Fill textBoxes using a invalid email
    Given I go to the TextBox webpage
    Then I check the TextBox "userName" is empty
    Then I check the TextBox "userEmail" is empty
    Then I check the TextBox "currentAddress" is empty
    Then I check the TextBox "permanentAddress" is empty
    And I take a TextBox screenshot with fileName "TextBoxInvalidMailStart"
    Then I check the TextBox "userEmail" is displayed as "form-control"
    Then I fill the TextBox "userEmail" with text "invalid mail"
    When I click the TextBox button Submit
    Then I check the TextBox "userEmail" is displayed as "field-error"
    Then I should not see the TextBox results box empty
    Then I take a TextBox screenshot with fileName "TextBoxInvalidMailEnd"
    And I quit the TextBox webpage

  @TextBoxValidMail
  Scenario: Fill text boxes with valid email
    Given I go to the TextBox webpage
    Then I check the TextBox "userName" is empty
    Then I check the TextBox "userEmail" is empty
    Then I check the TextBox "currentAddress" is empty
    Then I check the TextBox "permanentAddress" is empty
    And I take a TextBox screenshot with fileName "TextBoxStart"
    Then I fill the TextBox "userName" with text "TestName TestSurname"
    Then I fill the TextBox "userEmail" with text "testing@testmail.com"
    Then I fill the TextBox "currentAddress" with text "Testing current address"
    Then I fill the TextBox "permanentAddress" with text "Testing permanent address"
    When I click the TextBox button Submit
    Then I should see the TextBox results box with:
      | name              | TestName TestSurname      |
      | email             | testing@testmail.com      |
      | currentAddress    | Testing current address   |
      | permanentAddress  | Testing permanent address |
    And I take a TextBox screenshot with fileName "TextBoxEnd"
    And I let the TextBox webpage open

  @TextBoxAlreadyFilled
  Scenario: Fill textBoxes already filled
    Given The previous TextBox webpage opened
    Then I check the TextBox "userName" is not empty
    Then I check the TextBox "userEmail" is not empty
    Then I check the TextBox "currentAddress" is not empty
    Then I check the TextBox "permanentAddress" is not empty
    Then  I should see the TextBox results box with:
      | name              | TestName TestSurname      |
      | email             | testing@testmail.com      |
      | currentAddress    | Testing current address   |
      | permanentAddress  | Testing permanent address |
    And I take a TextBox screenshot with fileName "TextBoxFilledStart"
    Then I clean the TexBox "userName"
    And  I fill the TextBox "userName" with text "New TestName TestSurname edited"
    Then I clean the TexBox "userEmail"
    And I fill the TextBox "userEmail" with text "neweditedtesting@newtestmail.com"
    Then I clean the TexBox "currentAddress"
    And I fill the TextBox "currentAddress" with text "New Testing current address edited"
    Then I clean the TexBox "permanentAddress"
    And I fill the TextBox "permanentAddress" with text "New Testing permanent address edited"
    When I click the TextBox button Submit
    Then  I should see the TextBox results box with:
      | name              | New TestName TestSurname edited      |
      | email             | neweditedtesting@newtestmail.com     |
      | currentAddress    | New Testing current address edited   |
      | permanentAddress  | New Testing permanent address edited |
    And I take a TextBox screenshot with fileName "TextBoxFilledEnd"
    And I quit the TextBox webpage
