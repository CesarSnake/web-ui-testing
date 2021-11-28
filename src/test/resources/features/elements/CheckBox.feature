Feature: Test check box element of a webpage
  Scenario: Check Box
    Given I go to the Check Box webpage "https://demoqa.com/checkbox"
    Then I check all check boxes are collapsed
    Then I click the button "rct-option-expand-all"
    And I check all check boxes are expanded
    And I check all check boxes are unselected
    And I take a check box page screenshot with fileName "checkBoxStart"
    Then I click the check box "tree-node-notes"
    And I check the check box "tree-node-notes" is "rct-icon-check"
    And I check the check box "tree-node-desktop" is "rct-icon-half-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    And I check that the result box contains:
      | notes |
    Then I click the check box "tree-node-commands"
    And I check the check box "tree-node-commands" is "rct-icon-check"
    And I check the check box "tree-node-desktop" is "rct-icon-check"
    And I check the check box "tree-node-home" is "rct-icon-half-check"
    And I check that the result box contains:
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
    And I check that the result box contains:
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
    And I check that the result box contains:
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
    And I check that the result box contains:
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
    Then I take a check box page screenshot with fileName "checkBoxEnd"
    Then I click the check box "tree-node-home"
    And I check all check boxes are unselected
    And I close the CheckBox webpage