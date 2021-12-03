@CheckBox
Feature: Test CheckBox element of a webpage

  @CheckingCheckBox
  Scenario: Checking CheckBox
    Given I go to the CheckBox webpage
    Then I check all checkboxes are collapsed
    When I click the checkBox button Expand all
    Then I check all checkBoxes are expanded
    When I click the checkBox button Collapse all
    Then I check all checkboxes are collapsed
    When I click the checkBox button Expand all
    Then I check all checkBoxes are unselected
    Then I take a checkBox screenshot with fileName "checkBoxStart"
    And I let the CheckBox webpage open

  Scenario: Check Desktop CheckBox group
    Given The previous CheckBox webpage opened
    When I click the checkBox "tree-node-notes"
    Then I check the checkBox "tree-node-notes" is "rct-icon-check"
    Then I check the checkBox "tree-node-desktop" is "rct-icon-half-check"
    Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
    Then I check that the checkBox result box contains:
      | notes |
    When I click the checkBox "tree-node-commands"
    Then I check the checkBox "tree-node-commands" is "rct-icon-check"
    Then I check the checkBox "tree-node-desktop" is "rct-icon-check"
    Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
    Then I check that the checkBox result box contains:
      | desktop   |
      | notes     |
      | commands  |
    And I let the CheckBox webpage open

  Scenario: Check Documents workspace CheckBox group
    Given The previous CheckBox webpage opened
    When I click the checkBox "tree-node-workspace"
    Then I check the checkBox "tree-node-workspace" is "rct-icon-check"
    Then I check the checkBox "tree-node-react" is "rct-icon-check"
    Then I check the checkBox "tree-node-angular" is "rct-icon-check"
    Then I check the checkBox "tree-node-veu" is "rct-icon-check"
    Then I check the checkBox "tree-node-documents" is "rct-icon-half-check"
    Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
    Then I check that the checkBox result box contains:
      | desktop   |
      | notes     |
      | commands  |
      | workspace |
      | react     |
      | angular   |
      | veu       |
    And I let the CheckBox webpage open

  Scenario: Check Documents office CheckBox group
    Given The previous CheckBox webpage opened
    When I click the checkBox "tree-node-office"
    Then I check the checkBox "tree-node-office" is "rct-icon-check"
    Then I check the checkBox "tree-node-public" is "rct-icon-check"
    Then I check the checkBox "tree-node-private" is "rct-icon-check"
    Then I check the checkBox "tree-node-classified" is "rct-icon-check"
    Then I check the checkBox "tree-node-general" is "rct-icon-check"
    Then I check the checkBox "tree-node-documents" is "rct-icon-check"
    Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
    Then I check that the checkBox result box contains:
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
    And I let the CheckBox webpage open

    Scenario: Check Downloads CheckBoxGroup
      Given The previous CheckBox webpage opened
      When I click the checkBox "tree-node-wordFile"
      Then I check the checkBox "tree-node-wordFile" is "rct-icon-check"
      Then I check the checkBox "tree-node-downloads" is "rct-icon-half-check"
      Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
      When I click the checkBox "tree-node-excelFile"
      Then I check the checkBox "tree-node-excelFile" is "rct-icon-check"
      Then I check the checkBox "tree-node-downloads" is "rct-icon-check"
      Then I check the checkBox "tree-node-home" is "rct-icon-check"
      Then I check that the checkBox result box contains:
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
      Then I take a checkBox screenshot with fileName "checkBoxEnd"
      And I let the CheckBox webpage open

  Scenario: Uncheck Download CheckBoxGroup
    Given The previous CheckBox webpage opened
    When I click the checkBox "tree-node-downloads"
    Then I check the checkBox "tree-node-downloads" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-wordFile" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-excelFile" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
    Then I check that the checkBox result box contains:
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
    Then I take a checkBox screenshot with fileName "checkBoxUnCheckDownload"
    And I let the CheckBox webpage open

  Scenario: Uncheck Documents CheckBoxGroup
    Given The previous CheckBox webpage opened
    When I click the checkBox "tree-node-documents"
    Then I check the checkBox "tree-node-documents" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-react" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-angular" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-veu" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-office" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-public" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-private" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-classified" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-general" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-home" is "rct-icon-half-check"
    Then I check that the checkBox result box contains:
      | desktop   |
      | notes     |
      | commands  |
    Then I take a checkBox screenshot with fileName "checkBoxUnCheckDocuments"
    And I let the CheckBox webpage open

  Scenario: Uncheck Desktop CheckBoxGroup
    Given The previous CheckBox webpage opened
    When I click the checkBox "tree-node-desktop"
    Then I check the checkBox "tree-node-desktop" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-notes" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-commands" is "rct-icon-uncheck"
    Then I check the checkBox "tree-node-home" is "rct-icon-uncheck"
    Then I take a checkBox screenshot with fileName "checkBoxUnCheckDesktop"
    And I let the CheckBox webpage open

  Scenario: Deselect all CheckBoxes
    Given The previous CheckBox webpage opened
    Then I click the checkBox "tree-node-home"
    Then I check all checkBoxes are selected
    And I quit the CheckBox webpage
