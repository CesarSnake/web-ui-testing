@BrokenLinksAndImages
Feature: Test Broken Links - Images element of a webpage

  Scenario: Images
    Given I go to the elements webpage "broken"
    Then I check valid image is displayed
    Then I check a broken image is not displayed
    And I quit the elements webpage

  Scenario: Valid Link
    Given I go to the elements webpage "broken"
    Then I take an elements screenshot with fileName "validStart"
    When I click the link with text "Click Here for Valid Link"
    Then I check the web page has changed to "https://demoqa.com/"
    Then I take an elements screenshot with fileName "validEnd"
    And I quit the elements webpage

  Scenario: Broken Link
    Given I go to the elements webpage "broken"
    Then I take an elements screenshot with fileName "BrokenStart"
    When I click the link with text "Click Here for Broken Link"
    Then I check the web page has changed to "http://the-internet.herokuapp.com/status_codes/500"
    Then I take an elements screenshot with fileName "BrokenEnd"
    And I quit the elements webpage
