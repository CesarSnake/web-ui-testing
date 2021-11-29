Feature: Test web table element of a webpage

  Scenario: Checking on Web Table
    Given I go to the Web Table webpage "https://demoqa.com/webtables"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000  | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I check web table display "10" rows
    And I take a web table page screenshot with fileName "webTableStart"
    Then I use the search Typing "Cierra"
    And I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000  | Insurance  |
    And I take a web table page screenshot with fileName "webTableSearchCierra"
    Then I use the search Typing "45"
    And I check web table contains the elements:
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
    And I take a web table page screenshot with fileName "webTableSearch45"
    Then I use the search Typing "legal"
    And I check web table contains the elements:
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I take a web table page screenshot with fileName "webTableSearchLegal"
    Then I use the search Typing "2000"
    And I check web table contains the elements:
      | Alden  | Cantrell | 45 | alden@example.com  | 12000  | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000   | Legal      |
    And I take a web table page screenshot with fileName "webTableSearch2000"
    And I close the Web Table webpage

  Scenario: Adding Elements on Web Table
    Given I go to the Web Table webpage "https://demoqa.com/webtables"
    Then I press the web table button "addNewRecordButton"
    And I check the registration form element "firstName" is ""
    And I check the registration form element "lastName" is ""
    And I check the registration form element "userEmail" is ""
    And I check the registration form element "age" is ""
    And I check the registration form element "salary" is ""
    And I check the registration form element "department" is ""
    And I check the registration form has not errors
    And I take a web table page screenshot with fileName "webTableRegistrationFormEmpty"
    Then I press the web table button "submit"
    And I check the registration form has errors
    And I take a web table page screenshot with fileName "webTableRegistrationFormError"
    And I fill the registration form typing on the element "firstName" the value "First Name Test"
    And I fill the registration form typing on the element "lastName" the value "Last Name Test"
    And I fill the registration form typing on the element "userEmail" the value "testing@test.com"
    And I fill the registration form typing on the element "age" the value "31"
    And I fill the registration form typing on the element "salary" the value "3600"
    And I fill the registration form typing on the element "department" the value "TQS"
    And I take a web table page screenshot with fileName "webTableRegistrationFormFill"
    And I press the web table button "submit"
    And I check web table contains the elements:
      | Cierra          | Vega           | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden           | Cantrell       | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra          | Gentry         | 29 | kierra@example.com | 2000  | Legal      |
      | First Name Test | Last Name Test | 31 | testing@test.com   | 3600  | TQS        |
    And I take a web table page screenshot with fileName "webTableAddedElement"
    And I close the Web Table webpage

  Scenario: Editing Elements on Web table
    Given I go to the Web Table webpage "https://demoqa.com/webtables"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000  | Legal      |
    Then I press the web table button "edit-record-2"
    And I check the edit registration form element "firstName" is "Alden"
    And I check the edit registration form element "lastName" is "Cantrell"
    And I check the edit registration form element "userEmail" is "alden@example.com"
    And I check the edit registration form element "age" is "45"
    And I check the edit registration form element "salary" is "12000"
    And I check the edit registration form element "department" is "Compliance"
    And I take a web table page screenshot with fileName "webTableRegistrationFormEditStart"
    And I fill the registration form typing on the element "firstName" the value "Edited First Name"
    And I fill the registration form typing on the element "lastName" the value "Edited Last Name"
    And I fill the registration form typing on the element "userEmail" the value "edited@test.com"
    And I fill the registration form typing on the element "age" the value "99"
    And I fill the registration form typing on the element "salary" the value "9999"
    And I fill the registration form typing on the element "department" the value "edited"
    And I take a web table page screenshot with fileName "webTableRegistrationFormEditEnd"
    And I press the web table button "submit"
    And I check web table contains the elements:
      | Cierra            | Vega             | 39 | cierra@example.com | 10000 | Insurance |
      | Edited First Name | Edited Last Name | 99 | edited@test.com    | 9999  | edited    |
      | Kierra            | Gentry           | 29 | kierra@example.com | 2000  | Legal     |
    And I take a web table page screenshot with fileName "webTableEditedElement"
    And I close the Web Table webpage

  Scenario: Deleting Elements Web table
    Given I go to the Web Table webpage "https://demoqa.com/webtables"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
      | Kierra | Gentry   | 29 | kierra@example.com | 2000  | Legal      |
    And I take a web table page screenshot with fileName "webTableDeleteStart"
    Then I press the web table button "delete-record-3"
    Then I check web table contains the elements:
      | Cierra | Vega     | 39 | cierra@example.com | 10000 | Insurance  |
      | Alden  | Cantrell | 45 | alden@example.com  | 12000 | Compliance |
    And I take a web table page screenshot with fileName "webTableDeleteEnd"
    And I close the Web Table webpage

  Scenario: Modifying rows size on Web table
    Given I go to the Web Table webpage "https://demoqa.com/webtables"
    And I check web table display "10" rows
    Then I change the select to option "5" rows
    And I check web table display "5" rows
    Then I change the select to option "20" rows
    And I check web table display "20" rows
    And I take a web table page screenshot with fileName "webTableSelectRow20"
    Then I change the select to option "25" rows
    And I check web table display "25" rows
    Then I change the select to option "50" rows
    And I check web table display "50" rows
    And I take a web table page screenshot with fileName "webTableSelectRow50"
    Then I change the select to option "100" rows
    And I check web table display "100" rows
    And I close the Web Table webpage