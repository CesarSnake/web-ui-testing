@RadioButton
Feature: Test radio button element of a webPage

  Scenario: Radio Button
    Given I go to the Radio Button webpage "https://demoqa.com/radio-button"
    And I take a radio button screenshot with the name "radioButtonStart"
    When I click the radio button "yesRadio"
    Then I check the radio button "Yes" is selected
    And I take a radio button screenshot with the name "radioYes"
    When I click the radio button "impressiveRadio"
    Then I check the radio button "Impressive" is selected
    And I take a radio button screenshot with the name "radioImpressive"
    Then I check the radio button "noRadio" is disabled
    And I close the Radio button webpage