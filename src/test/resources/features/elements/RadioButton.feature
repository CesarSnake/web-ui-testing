Feature: Test radio button element of a webPage

  Scenario: Radio Button
    Given I go to the Radio Button webpage "https://demoqa.com/radio-button"
    And I take a radio button page screenshot with the name "radioButtonStart"
    Then I click the radio button "yesRadio"
    And I check the radio button "yesRadio" is selected
    And I take a radio button screenshot with the name "radioYes"
    Then I click the radio button "impressiveRadio"
    And I check the radio button "impressiveRadio" is selected
    And I take a radio button screenshot with the name "radioImpressive"
    Then I check the radio button "noRadio" is disabled
