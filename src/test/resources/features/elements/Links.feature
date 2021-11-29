Feature: Test Links element of a webpage
  Scenario: Links open a new tab
    Given I go to Links web page "https://demoqa.com/links"
    Then I click the link "simpleLink"
    And I check the web page "https://demoqa.com/" has opened in a new tab
    Then I click the link "dynamicLink"
    And I check the web page "https://demoqa.com/" has opened in a new tab
    And I close the Links webpage

  Scenario: Links send an api call
    Given I go to Links web page "https://demoqa.com/links"
    Then I take a Links page screenshot with fileName "LinksStart"
    Then I click the link "created"
    And I check the response was with status "201" and status text "Created"
    And I take a Links page screenshot with fileName "LinksCreated"
    Then I click the link "no-content"
    And I check the response was with status "204" and status text "No Content"
    And I take a Links page screenshot with fileName "LinksNoContent"
    Then I click the link "moved"
    And I check the response was with status "301" and status text "Moved Permanently"
    And I take a Links page screenshot with fileName "LinksMoved"
    Then I click the link "bad-request"
    And I check the response was with status "400" and status text "Bad Request"
    And I take a Links page screenshot with fileName "LinksBadRequest"
    Then I click the link "unauthorized"
    And I check the response was with status "401" and status text "Unauthorized"
    And I take a Links page screenshot with fileName "LinksUnauthorized"
    Then I click the link "forbidden"
    And I check the response was with status "403" and status text "Forbidden"
    And I take a Links page screenshot with fileName "LinksForbidden"
    Then I click the link "invalid-url"
    And I check the response was with status "404" and status text "Not Found"
    And I take a Links page screenshot with fileName "LinksNotFound"
    And I close the Links webpage
