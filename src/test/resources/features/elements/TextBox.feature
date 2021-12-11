@TextBox
Feature: Test TextBox element of a webPage

  @TextBoxInvalidMail
  Scenario: Fill textBoxes using a invalid email
    Given I go to the elements webpage "text-box"
    Then I check the textBox "userName" is empty
    Then I check the textBox "userEmail" is empty
    Then I check the textBox "currentAddress" is empty
    Then I check the textBox "permanentAddress" is empty
    And I take an elements screenshot with fileName "TextBoxInvalidMailStart"
    Then I check the textBox "userEmail" is displayed as "form-control"
    Then I fill the textBox "userEmail" with the text "invalid mail"
    When I click the elements button "submit"
    Then I check the textBox "userEmail" is displayed as "field-error"
    Then I should not see the textBox results box empty
    And I take an elements screenshot with fileName "TextBoxInvalidMailEnd"
    And I quit the elements webpage

  @TextBoxValidMail
  Scenario: Fill text boxes with valid email
    Given I go to the elements webpage "text-box"
    Then I check the textBox "userName" is empty
    Then I check the textBox "userEmail" is empty
    Then I check the textBox "currentAddress" is empty
    Then I check the textBox "permanentAddress" is empty
    And I take an elements screenshot with fileName "TextBoxStart"
    Then I fill the textBox "userName" with the text "TestName TestSurname"
    Then I fill the textBox "userEmail" with the text "testing@testmail.com"
    Then I fill the textBox "currentAddress" with the text "Testing current address"
    Then I fill the textBox "permanentAddress" with the text "Testing permanent address"
    When I click the elements button "submit"
    Then I should see the textBox results box with:
      | name              | TestName TestSurname      |
      | email             | testing@testmail.com      |
      | currentAddress    | Testing current address   |
      | permanentAddress  | Testing permanent address |
    And I take an elements screenshot with fileName "TextBoxEnd"
    And I let the elements webpage open

  @TextBoxAlreadyFilled
  Scenario: Fill textBoxes already filled
    Given The previous elements webpage opened
    Then I check the textBox "userName" is filled with "TestName TestSurname"
    Then I check the textBox "userEmail" is filled with "testing@testmail.com"
    Then I check the textBox "currentAddress" is filled with "Testing current address"
    Then I check the textBox "permanentAddress" is filled with "Testing permanent address"
    Then  I should see the textBox results box with:
      | name              | TestName TestSurname      |
      | email             | testing@testmail.com      |
      | currentAddress    | Testing current address   |
      | permanentAddress  | Testing permanent address |
    And I take an elements screenshot with fileName "TextBoxFilledStart"
    Then I clean the texBox "userName"
    And  I fill the textBox "userName" with the text "New TestName TestSurname edited"
    Then I clean the texBox "userEmail"
    And I fill the textBox "userEmail" with the text "neweditedtesting@newtestmail.com"
    Then I clean the texBox "currentAddress"
    And I fill the textBox "currentAddress" with the text "New Testing current address edited"
    Then I clean the texBox "permanentAddress"
    And I fill the textBox "permanentAddress" with the text "New Testing permanent address edited"
    When I click the elements button "submit"
    Then  I should see the textBox results box with:
      | name              | New TestName TestSurname edited      |
      | email             | neweditedtesting@newtestmail.com     |
      | currentAddress    | New Testing current address edited   |
      | permanentAddress  | New Testing permanent address edited |
    And I take an elements screenshot with fileName "TextBoxFilledEnd"
    And I quit the elements webpage
