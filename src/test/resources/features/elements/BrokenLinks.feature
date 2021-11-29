Feature: Test Broken Links - Images element of a webpage
  Scenario: Images
    Given I go to Broken web page "https://demoqa.com/broken"
    Then I check valid image is displayed
    Then I check broken image is not displayed
    And I close the Broken webpage

  Scenario: Valid Link
  Given I go to Broken web page "https://demoqa.com/broken"
  And I take a buttons page screenshot with fileName "ValidStart"
  And I check the web page has changed to "https://demoqa.com/"
  And I take a buttons page screenshot with fileName "ValidEnd"
  And I close the Broken webpage

  Scenario: Broken Link
  Given I go to Broken web page "https://demoqa.com/broken"
  And I take a buttons page screenshot with fileName "BrokenStart"
  And I check the web page has changed to "http://the-internet.herokuapp.com/status_codes/500"
  And I take a buttons page screenshot with fileName "BrokenEnd"
  And I close the Broken webpage
