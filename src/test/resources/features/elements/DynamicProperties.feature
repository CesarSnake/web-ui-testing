Feature: Test Dynamic Properties element of a webpage
  Scenario: Dynamic Properties
    Given I go to dynamic properties webpage "https://demoqa.com/dynamic-properties"
    Then I take a dynamic properties page screenshot with fileName "DynamicStart"
    Then I check the dynamic page displays button named "Will enable 5 seconds"
    Then I check the dynamic page displays button named "Color Change"
    Then I check the dynamic page button with text "Will enable 5 seconds" is disabled
    Then I check the dynamic page button with text "Color Change" has not color
    Then I check the dynamic page button with text "Visible After 5 Seconds" is not displayed
    When I wait a "5" seconds in dynamic page
    Then I check the dynamic page button with text "Will enable 5 seconds" is enabled
    Then I check the dynamic page button with text "Color Change" has changed the color to red
    Then I check the dynamic page button with text "Visible After 5 Seconds" is displayed
    And I take a dynamic properties page screenshot with fileName "DynamicEnd"
    And I close the Dynamic Properties webpage
