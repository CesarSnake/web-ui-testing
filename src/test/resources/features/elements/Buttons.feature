@Buttons
Feature: Test buttons element of a webpage

  Scenario: Buttons
    Given I go to Buttons web page "https://demoqa.com/buttons"
    Then I take a buttons page screenshot with fileName "ButtonsStart"
    When I do double click on the button "doubleClickBtn"
    Then I check double click button has clicked using double click
    When I do right click on the button "rightClickBtn"
    Then I check right click button has clicked using right click
    When I do a regular click on the dynamic button
    Then I check dynamic button has been clicked
    Then I take a buttons page screenshot with fileName "ButtonsEnd"
    And I close the Buttons webpage
