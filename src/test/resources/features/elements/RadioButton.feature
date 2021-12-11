@RadioButton
Feature: Test RadioButton element of a webPage

  @RadioButtonChecking
  Scenario: Checking Radio Button
    Given I go to the elements webpage "radio-button"
    Then I check the radio button "Yes" is not selected
    Then I check the radio button "Impressive" is not selected
    Then I check the radio button "noRadio" is disabled
    And I quit the elements webpage

  @RadioButtonYes
  Scenario: Radio Button Yes
    Given I go to the elements webpage "radio-button"
    Then I check the radio button "Yes" is not selected
    Then I check the radio button "Impressive" is not selected
    Then I check the radio button "noRadio" is disabled
    When I click the radio button "yesRadio"
    Then I check the radio button "Yes" is selected
    Then I check the radio button "Impressive" is not selected
    And I take an elements screenshot with fileName "radioYes"
    And I let the elements webpage open

  Scenario: Radio Button Impressive
    Given The previous elements webpage opened
    Then I check the radio button "Yes" is selected
    Then I check the radio button "Impressive" is not selected
    Then I check the radio button "noRadio" is disabled
    When I click the radio button "impressiveRadio"
    Then I check the radio button "Yes" is not selected
    Then I check the radio button "Impressive" is selected
    And I take an elements screenshot with fileName "radioImpressive"
    And I quit the elements webpage