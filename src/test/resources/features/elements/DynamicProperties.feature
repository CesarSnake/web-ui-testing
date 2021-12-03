@DynamicProperties
Feature: Test Dynamic Properties element of a webpage

  Scenario: Button enabled after 5 seconds
    Given I go to dynamic properties webpage
    Then I take a dynamic properties page screenshot with fileName "buttonEnabledStart"
    Then I check the dynamic page displays button named "Will enable 5 seconds"
    Then I check the dynamic page button with text "Will enable 5 seconds" is disabled
    When I wait a "5" seconds in dynamic page
    Then I check the dynamic page button with text "Will enable 5 seconds" is enabled
    And I take a dynamic properties page screenshot with fileName "buttonEnabledEnd"
    And I quit the Dynamic Properties webpage

  Scenario: Button color change after 5 seconds
    Given I go to dynamic properties webpage
    Then I take a dynamic properties page screenshot with fileName "buttonColorStart"
    Then I check the dynamic page displays button named "Color Change"
    Then I check the dynamic page button with text "Color Change" is enabled
    Then I check the dynamic page button with text "Color Change" has not color
    When I wait a "5" seconds in dynamic page
    Then I check the dynamic page button with text "Color Change" has changed the color to red
    And I take a dynamic properties page screenshot with fileName "buttonVisibleEnd"
    And I quit the Dynamic Properties webpage

  Scenario: Button visible after 5 seconds
    Given I go to dynamic properties webpage
    Then I take a dynamic properties page screenshot with fileName "buttonVisibleStart"
    Then I check the dynamic page button with text "Visible After 5 Seconds" is not displayed
    When I wait a "5" seconds in dynamic page
    Then I check the dynamic page button with text "Visible After 5 Seconds" is displayed
    Then I check the dynamic page button with text "Visible After 5 Seconds" is enabled
    And I take a dynamic properties page screenshot with fileName "buttonVisibleEnd"
    And I quit the Dynamic Properties webpage