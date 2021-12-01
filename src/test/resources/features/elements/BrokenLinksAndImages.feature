@BrokenLinksAndImages
Feature: Test Broken Links - Images element of a webpage

  Scenario: Images
    Given I go to the broken links and images web page "https://demoqa.com/broken"
    Then I check valid image is displayed
    Then I check a broken image is not displayed
    And I close the Broken webpage

  Scenario: Valid Link
    Given I go to the broken links and images web page "https://demoqa.com/broken"
    When I click the valid link
    Then I check the web page has changed to "https://demoqa.com/"
    And I close the Broken webpage

  Scenario: Broken Link
    Given I go to the broken links and images web page "https://demoqa.com/broken"
    When I click the broken link
    Then I take a broken page screenshot with fileName "BrokenStart"
    Then I check the web page has changed to "http://the-internet.herokuapp.com/status_codes/500"
    Then I take a broken page screenshot with fileName "BrokenEnd"
    And I close the Broken webpage
