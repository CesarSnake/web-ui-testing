@WebTable
Feature: Test WebTable element of a webpage

  Scenario: Searching on Web Table
    Given I go to the elements webpage "webtables"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000  | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I check web table displays "10" rows
    And I take an elements screenshot with fileName "webTableStart"
    When I fill the textBox "searchBox" with the text "Cierra"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000  | Insurance  |
    And I take an elements screenshot with fileName "webTableSearchCierra"
    Then I clean the texBox "searchBox"
    When I fill the textBox "searchBox" with the text "45"
    Then I check web table contains the elements:
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
    And I take an elements screenshot with fileName "webTableSearch45"
    Then I clean the texBox "searchBox"
    When I fill the textBox "searchBox" with the text "legal"
    Then I check web table contains the elements:
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I take an elements screenshot with fileName "webTableSearchLegal"
    Then I clean the texBox "searchBox"
    When I fill the textBox "searchBox" with the text "2000"
    Then I check web table contains the elements:
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I take an elements screenshot with fileName "webTableSearch2000"
    And I quit the elements webpage

  Scenario: Adding Elements on Web Table
    Given I go to the elements webpage "webtables"
    When I click the elements button "addNewRecordButton"
    Then I check the textBox "firstName" is empty
    Then I check the textBox "lastName" is empty
    Then I check the textBox "userEmail" is empty
    Then I check the textBox "age" is empty
    Then I check the textBox "salary" is empty
    Then I check the textBox "department" is empty
    Then I check the registration form has not errors
    Then I take an elements screenshot with fileName "webTableRegistrationFormEmpty"
    When I click the elements button "submit"
    Then I check the registration form has errors
    Then I take an elements screenshot with fileName "webTableRegistrationFormError"
    And I fill the textBox "firstName" with the text "First Name Test"
    And I fill the textBox "lastName" with the text "Last Name Test"
    And I fill the textBox "userEmail" with the text "testing@test.com"
    And I fill the textBox "age" with the text "31"
    And I fill the textBox "salary" with the text "3600"
    And I fill the textBox "department" with the text "TQS"
    And I take an elements screenshot with fileName "webTableRegistrationFormFill"
    When I click the elements button "submit"
    Then I check web table contains the elements:
      | Cierra          | Vega           | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden           | Cantrell       | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra          | Gentry         | 29 | kierra@example.com | 2000  | Legal      |
      | First Name Test | Last Name Test | 31 | testing@test.com   | 3600  | TQS        |
    And I take an elements screenshot with fileName "webTableAddedElement"
    And I quit the elements webpage

  Scenario: Editing Elements on Web table
    Given I go to the elements webpage "webtables"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000  | Legal      |
    When I click the elements button "edit-record-2"
    Then I check the textBox "firstName" is filled with "Alden"
    Then I check the textBox "lastName" is filled with "Cantrell"
    Then I check the textBox "userEmail" is filled with "alden@example.com"
    Then I check the textBox "age" is filled with "45"
    Then I check the textBox "salary" is filled with "12000"
    Then I check the textBox "department" is filled with "Compliance"
    Then I take an elements screenshot with fileName "webTableRegistrationFormEditStart"
    Then I clean the texBox "firstName"
    And I fill the textBox "firstName" with the text "Edited First Name"
    Then I clean the texBox "lastName"
    And I fill the textBox "lastName" with the text "Edited Last Name"
    Then I clean the texBox "userEmail"
    And I fill the textBox "userEmail" with the text "edited@test.com"
    Then I clean the texBox "age"
    And I fill the textBox "age" with the text "99"
    Then I clean the texBox "salary"
    And I fill the textBox "salary" with the text "8888"
    Then I clean the texBox "department"
    And I fill the textBox "department" with the text "edited"
    And I take an elements screenshot with fileName "webTableRegistrationFormEditEnd"
    When I click the elements button "submit"
    Then I check web table contains the elements:
      | Cierra            | Vega             | 39 | cierra@example.com | 10000 | Insurance |
      | Edited First Name | Edited Last Name | 99 | edited@test.com    | 8888  | edited    |
      | Kierra            | Gentry           | 29 | kierra@example.com | 2000  | Legal     |
    And I take an elements screenshot with fileName "webTableEditedElement"
    And I quit the elements webpage

  Scenario: Deleting Elements on Web table
    Given I go to the elements webpage "webtables"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000  | Legal      |
    And I take an elements screenshot with fileName "webTableDeleteStart"
    When I click the elements button "delete-record-3"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
    And I take an elements screenshot with fileName "webTableDeleteEnd"
    And I quit the elements webpage

  Scenario: Modifying rows size on Web table
    Given I go to the elements webpage "webtables"
    Then I check web table displays "10" rows
    When I change the select to option "5" rows
    Then I check web table displays "5" rows
    And I take an elements screenshot with fileName "webTableSelectRow5"
    When I change the select to option "20" rows
    Then I check web table displays "20" rows
    And I take an elements screenshot with fileName "webTableSelectRow20"
    When I change the select to option "25" rows
    Then I check web table displays "25" rows
    When I change the select to option "50" rows
    Then I check web table displays "50" rows
    When I change the select to option "100" rows
    Then I check web table displays "100" rows
    And I quit the elements webpage