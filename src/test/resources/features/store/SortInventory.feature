@SortStoreInventory
Feature: Sort inventory Items

  Scenario: Name (A to Z)
    Given I go to the store webpage
    Then I login in the store webpage
    When I change the sort select to option "Name (A to Z)"
    Then I check the order of the inventory is:
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I take a screenshot with filename "sortAZ"
    And I close the store webpage

  Scenario: Name (Z to A)
    Given I go to the store webpage
    Then I login in the store webpage
    When I change the sort select to option "Name (Z to A)"
    Then I check the order of the inventory is:
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Onesie                 |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
    And I take a screenshot with filename "sortZA"
    And I close the store webpage

  Scenario: Price (low to high)
    Given I go to the store webpage
    Then I login in the store webpage
    When I change the sort select to option "Price (low to high)"
    Then I check the order of the inventory is:
      | Sauce Labs Onesie                 |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |
      | Sauce Labs Fleece Jacket          |
    And I take a screenshot with filename "sortLoHi"
    And I close the store webpage

  Scenario: Price (high to low)
    Given I go to the store webpage
    Then I login in the store webpage
    When I change the sort select to option "Price (high to low)"
    Then I check the order of the inventory is:
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Bike Light             |
      | Sauce Labs Onesie                 |
    And I take a screenshot with filename "sortHiLo"
    And I close the store webpage