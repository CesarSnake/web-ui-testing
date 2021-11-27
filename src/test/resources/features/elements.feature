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
    And I take a screenshot with fileName "TextBox"
    And I close the webpage

  Scenario: Check Box
    Given I go to the Check Box webpage "https://demoqa.com/checkbox"
    Then I click the button "Expand all"
    And I check all check boxes are unselected
    Then I click the check box "tree-node-notes"
    And I check the check box "tree-node-notes" is "rct-icon-check"
    And I check the check box "tree-node-desktop" is "rct-icon-half-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    And I check that the display result contains:
      | commands |
    Then I click the check box "tree-node-notes"
    And I check the check box "tree-node-notes" is "rct-icon-check"
    And I check the check box "tree-node-desktop" is "rct-icon-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    And I check that the display result contains:
      | desktop   |
      | notes     |
      | commands  |
    Then I click the check box "tree-node-workspace"
    And I check the check box "tree-node-workspace" is "rct-icon-check"
    And I check the check box "tree-node-react" is "rct-icon-check"
    And I check the check box "tree-node-angular" is "rct-icon-check"
    And I check the check box "tree-node-veu" is "rct-icon-check"
    And I check the check box "tree-node-documents" is "rct-icon-half-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    And I check that the display result contains:
      | desktop   |
      | notes     |
      | commands  |
      | workspace |
      | react     |
      | angular   |
      | veu       |
    Then I click the check box "tree-node-office"
    And I check the check box "tree-node-office" is "rct-icon-check"
    And I check the check box "tree-node-public" is "rct-icon-check"
    And I check the check box "tree-node-private" is "rct-icon-check"
    And I check the check box "tree-node-classified" is "rct-icon-check"
    And I check the check box "tree-node-general" is "rct-icon-check"
    And I check the check box "tree-node-documents" is "rct-icon-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    And I check that the display result contains:
      | desktop   |
      | notes     |
      | commands  |
      | documents  |
      | workspace |
      | react     |
      | angular   |
      | veu       |
      | office    |
      | public    |
      | private   |
      | classified|
      | general   |
    Then I click the check box "tree-node-wordFile"
    And I check the check box "tree-node-wordFile" is "rct-icon-check"
    And I check the check box "tree-node-downloads" is "rct-icon-half-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    Then I click the check box "tree-node-excelFile"
    And I check the check box "tree-node-excelFile" is "rct-icon-check"
    And I check the check box "tree-node-downloads" is "rct-icon-check"
    And I check the check box "tree-node-home" is "rct-icon-check"
      | home      |
      | desktop   |
      | notes     |
      | commands  |
      | documents |
      | workspace |
      | react     |
      | angular   |
      | veu       |
      | office    |
      | public    |
      | private   |
      | classified|
      | general   |
      | downloads |
      | wordFile  |
      | excelFile |
    Then I take a screenshot with fileName "CheckBox"
    Then I click the check box "tree-node-home"
    And I check all check boxes are unselected
    And I close the webpage