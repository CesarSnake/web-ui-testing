Feature: Test Dynamic Properties element of a webpage
  Scenario: Dynamic Properties
    Given I go to Dynamic Properties webpage "https://demoqa.com/dynamic-properties"
    Then I take a Dynamic Properties page screenshot with fileName "DynamicStart"
    Then I check the dynamic page button "enableAfter" is disabled
    Then I check the dynamic page button "colorChange" has not color
    Then I check the dynamic page button "visibleAfter" is not displayed
    Then I wait 5 seconds
    And I check the dynamic page button "enableAfter" is enabled
    And I check the dynamic page button "colorChange" has change the color
    And I check the dynamic page button "visibleAfter" is displayed
    And I take a dinamic properties page screenshot with fileName "DynamicEnd"
    And I close the Dynamic Properties webpage
