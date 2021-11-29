Feature: Test buttons element of a webpage

  Scenario: Buttons
    Given I go to Buttons web page "https://demoqa.com/buttons"
    And I take a buttons page screenshot with fileName "ButtonsStart"
    Then I do double click on the button "doubleClickBtn"
    And I check double click button has clicked using double click
    Then I do right click on the button "rightClickBtn"
    And I check right click button has clicked using right click
    Then I do a regular click on the dynamic button
    And I check dynamic button has been clicked
    And I take a buttons page screenshot with fileName "ButtonsEnd"
    And I close the Buttons webpage
