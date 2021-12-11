@DynamicProperties
Feature: Test Dynamic Properties element of a webpage

  Scenario: Button enabled after 5 seconds
    Given I go to the elements webpage "dynamic-properties"
    Then I take an elements screenshot with fileName "buttonEnabledStart"
    Then I check the button named "Will enable 5 seconds" is displayed
    Then I check the button named "Will enable 5 seconds" is disabled
    When I wait a "5" seconds
    Then I check the button named "Will enable 5 seconds" is enabled
    And I take an elements screenshot with fileName "buttonEnabledEnd"
    And I quit the elements webpage

  Scenario: Button color change after 5 seconds
    Given I go to the elements webpage "dynamic-properties"
    Then I take an elements screenshot with fileName "buttonColorStart"
    Then I check the button named "Color Change" is displayed
    Then I check the button named "Color Change" is enabled
    Then I check the button named "Color Change" has not color
    When I wait a "5" seconds
    Then I check the button named "Color Change" has changed the color to red
    And I take an elements screenshot with fileName "buttonVisibleEnd"
    And I quit the elements webpage

  Scenario: Button visible after 5 seconds
    Given I go to the elements webpage "dynamic-properties"
    Then I take an elements screenshot with fileName "buttonVisibleStart"
    Then I check the button named "Visible After 5 Seconds" is not displayed
    When I wait a "5" seconds
    Then I check the button named "Visible After 5 Seconds" is displayed
    Then I check the button named "Visible After 5 Seconds" is enabled
    And I take an elements screenshot with fileName "buttonVisibleEnd"
    And I quit the elements webpage
