@Buttons
Feature: Test buttons element of a webpage

  @ButtonsDoubleClick
  Scenario: Double Click
    Given I go to Buttons webpage
    Then I take a buttons page screenshot with fileName "DoubleClickStart"
    When I click the Buttons webpage button "doubleClickBtn"
    Then I check the Buttons webpage button has done nothing
    When I do double click on the button "doubleClickBtn"
    Then I check double click button has clicked using double click
    And I take a buttons page screenshot with fileName "DoubleClickEnd"
    And I let the Buttons webpage open

  Scenario: Right Click
    Given The previous Buttons webpage opened
    When I do right click on the button "rightClickBtn"
    Then I check right click button has clicked using right click
    And I take a buttons page screenshot with fileName "DoubleClickEnd"
    And I let the Buttons webpage open

  Scenario: Simple Click
    Given The previous Buttons webpage opened
    When I do a regular click on the dynamic button
    Then I check dynamic button has been clicked
    Then I take a buttons page screenshot with fileName "DynamicEnd"
    And I quit the Buttons webpage
