@WebTable
Feature: Test WebTable element of a webpage

  Scenario: Searching on Web Table
    Given I go to the WebTable webpage
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000  | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I check web table displays "10" rows
    And I take a web table page screenshot with fileName "webTableStart"
    When I use the search typing "Cierra"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000  | Insurance  |
    And I take a web table page screenshot with fileName "webTableSearchCierra"
    When I use the search typing "45"
    Then I check web table contains the elements:
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
    And I take a web table page screenshot with fileName "webTableSearch45"
    When I use the search typing "legal"
    Then I check web table contains the elements:
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I take a web table page screenshot with fileName "webTableSearchLegal"
    When I use the search typing "2000"
    Then I check web table contains the elements:
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I take a web table page screenshot with fileName "webTableSearch2000"
    And I quit the Web Table webpage

  Scenario: Adding Elements on Web Table
    Given I go to the WebTable webpage
    When I press the web table button "addNewRecordButton"
    Then I check the registration form element "firstName" is ""
    Then I check the registration form element "lastName" is ""
    Then I check the registration form element "userEmail" is ""
    Then I check the registration form element "age" is ""
    Then I check the registration form element "salary" is ""
    Then I check the registration form element "department" is ""
    Then I check the registration form has not errors
    Then I take a web table page screenshot with fileName "webTableRegistrationFormEmpty"
    When I press the web table button "submit"
    Then I check the registration form has errors
    Then I take a web table page screenshot with fileName "webTableRegistrationFormError"
    And I fill the registration form typing on the element "firstName" the value "First Name Test"
    And I fill the registration form typing on the element "lastName" the value "Last Name Test"
    And I fill the registration form typing on the element "userEmail" the value "testing@test.com"
    And I fill the registration form typing on the element "age" the value "31"
    And I fill the registration form typing on the element "salary" the value "3600"
    And I fill the registration form typing on the element "department" the value "TQS"
    And I take a web table page screenshot with fileName "webTableRegistrationFormFill"
    When I press the web table button "submit"
    Then I check web table contains the elements:
      | Cierra          | Vega           | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden           | Cantrell       | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra          | Gentry         | 29 | kierra@example.com | 2000  | Legal      |
      | First Name Test | Last Name Test | 31 | testing@test.com   | 3600  | TQS        |
    And I take a web table page screenshot with fileName "webTableAddedElement"
    And I quit the Web Table webpage

  Scenario: Editing Elements on Web table
    Given I go to the WebTable webpage
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000  | Legal      |
    When I press the web table button "edit-record-2"
    Then I check the edit registration form element "firstName" is "Alden"
    Then I check the edit registration form element "lastName" is "Cantrell"
    Then I check the edit registration form element "userEmail" is "alden@example.com"
    Then I check the edit registration form element "age" is "45"
    Then I check the edit registration form element "salary" is "12000"
    Then I check the edit registration form element "department" is "Compliance"
    Then I take a web table page screenshot with fileName "webTableRegistrationFormEditStart"
    And I fill the registration form typing on the element "firstName" the value "Edited First Name"
    And I fill the registration form typing on the element "lastName" the value "Edited Last Name"
    And I fill the registration form typing on the element "userEmail" the value "edited@test.com"
    And I fill the registration form typing on the element "age" the value "99"
    And I fill the registration form typing on the element "salary" the value "9999"
    And I fill the registration form typing on the element "department" the value "edited"
    And I take a web table page screenshot with fileName "webTableRegistrationFormEditEnd"
    When I press the web table button "submit"
    Then I check web table contains the elements:
      | Cierra            | Vega             | 39 | cierra@example.com | 10000 | Insurance |
      | Edited First Name | Edited Last Name | 99 | edited@test.com    | 9999  | edited    |
      | Kierra            | Gentry           | 29 | kierra@example.com | 2000  | Legal     |
    And I take a web table page screenshot with fileName "webTableEditedElement"
    And I quit the Web Table webpage

  Scenario: Deleting Elements on Web table
    Given I go to the WebTable webpage
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000  | Legal      |
    And I take a web table page screenshot with fileName "webTableDeleteStart"
    When I press the web table button "delete-record-3"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
    And I take a web table page screenshot with fileName "webTableDeleteEnd"
    And I quit the Web Table webpage

  Scenario: Modifying rows size on Web table
    Given I go to the WebTable webpage
    Then I check web table displays "10" rows
    When I change the select to option "5" rows
    Then I check web table displays "5" rows
    And I take a web table page screenshot with fileName "webTableSelectRow5"
    When I change the select to option "20" rows
    Then I check web table displays "20" rows
    And I take a web table page screenshot with fileName "webTableSelectRow20"
    When I change the select to option "25" rows
    Then I check web table displays "25" rows
    When I change the select to option "50" rows
    Then I check web table displays "50" rows
    When I change the select to option "100" rows
    Then I check web table displays "100" rows
    And I quit the Web Table webpage