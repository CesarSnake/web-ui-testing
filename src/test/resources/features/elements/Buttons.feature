@Buttons
Feature: Test buttons element of a webpage

  @ButtonsDoubleClick
  Scenario: Double Click
    Given I go to the elements webpage "buttons"
    Then I take an elements screenshot with fileName "DoubleClickStart"
    When I click the elements button "doubleClickBtn"
    Then I check the Buttons webpage button has done nothing
    When I do double click on the button "doubleClickBtn"
    Then I check double click button has clicked using double click
    And I take an elements screenshot with fileName "DoubleClickEnd"
    And I let the elements webpage open

  Scenario: Right Click
    Given The previous elements webpage opened
    And I take an elements screenshot with fileName "rightClickStart"
    When I do right click on the button "rightClickBtn"
    Then I check right click button has clicked using right click
    And I take an elements screenshot with fileName "rightClickEnd"
    And I let the elements webpage open

  Scenario: Simple Click on dynamic id button
    Given The previous elements webpage opened
    Then I take an elements screenshot with fileName "dynamicStart"
    When I click the elements button with displayText "Click Me"
    Then I check dynamic button has been clicked
    Then I take an elements screenshot with fileName "dynamicEnd"
    And I quit the elements webpage
