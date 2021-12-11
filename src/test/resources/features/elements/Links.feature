@Links
Feature: Test Links element of a webpage

  Scenario: Static Link open a new tab
    Given I go to the elements webpage "links"
    When I click the link with text "Home"
    Then I check the web page "https://demoqa.com/" has opened in a new tab
    And I quit the elements webpage

  Scenario: Dynamic Link open a new tab
    Given I go to the elements webpage "links"
    When I click the dynamic link that contains "Home"
    Then I check the web page "https://demoqa.com/" has opened in a new tab
    And I quit the elements webpage

  Scenario: Links send an api call
    Given I go to the elements webpage "links"
    And I take an elements screenshot with fileName "LinksStart"

    When I click the link "created"
    Then I check the response was with status "201" and status text "Created"
    And I take an elements screenshot with fileName "LinksCreated"

    When I click the link "no-content"
    Then I check the response was with status "204" and status text "No Content"
    And I take an elements screenshot with fileName "LinksNoContent"

    When I click the link "moved"
    Then I check the response was with status "301" and status text "Moved Permanently"
    And I take an elements screenshot with fileName "LinksMoved"

    When I click the link "bad-request"
    Then I check the response was with status "400" and status text "Bad Request"
    And I take an elements screenshot with fileName "LinksBadRequest"

    When I click the link "unauthorized"
    Then I check the response was with status "401" and status text "Unauthorized"
    And I take an elements screenshot with fileName "LinksUnauthorized"

    When I click the link "forbidden"
    Then I check the response was with status "403" and status text "Forbidden"
    And I take an elements screenshot with fileName "LinksForbidden"

    When I click the link "invalid-url"
    Then I check the response was with status "404" and status text "Not Found"
    And I take an elements screenshot with fileName "LinksNotFound"
    And I quit the elements webpage
