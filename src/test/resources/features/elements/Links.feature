@Links
Feature: Test Links element of a webpage

  Scenario: Links open a new tab
    Given I go to Links web page "https://demoqa.com/links"
    When I click the link "simpleLink"
    Then I check the web page "https://demoqa.com/" has opened in a new tab
    When I click the link "dynamicLink"
    Then I check the web page "https://demoqa.com/" has opened in a new tab
    And I close the Links webpage

  Scenario: Links send an api call
    Given I go to Links web page "https://demoqa.com/links"
    And I take a Links page screenshot with fileName "LinksStart"
    When I click the link "created"
    Then I check the response was with status "201" and status text "Created"
    And I take a Links page screenshot with fileName "LinksCreated"
    When I click the link "no-content"
    Then I check the response was with status "204" and status text "No Content"
    And I take a Links page screenshot with fileName "LinksNoContent"
    When I click the link "moved"
    Then I check the response was with status "301" and status text "Moved Permanently"
    And I take a Links page screenshot with fileName "LinksMoved"
    When I click the link "bad-request"
    Then I check the response was with status "400" and status text "Bad Request"
    And I take a Links page screenshot with fileName "LinksBadRequest"
    When I click the link "unauthorized"
    Then I check the response was with status "401" and status text "Unauthorized"
    And I take a Links page screenshot with fileName "LinksUnauthorized"
    When I click the link "forbidden"
    Then I check the response was with status "403" and status text "Forbidden"
    And I take a Links page screenshot with fileName "LinksForbidden"
    When I click the link "invalid-url"
    Then I check the response was with status "404" and status text "Not Found"
    And I take a Links page screenshot with fileName "LinksNotFound"
    And I close the Links webpage
