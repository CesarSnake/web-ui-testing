@RemoveFromCart
Feature: Remove items from cart

  Scenario: Remove items from the inventory page
    Given I go to the store webpage to remove items from the cart
    Then I login to the store webpage to remove items from the cart
    Then I add to the cart the item "Sauce Labs Onesie"
    Then I add to the cart the item "Test.allTheThings() T-Shirt (Red)"
    Then I check the remove shopping cart icon displays a badge with value "2"
    And I take a remove screenshot with filename "removeStart"
    When I click the shopping cart button to see the items
    Then I check the shopping cart page displays the items:
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I take a remove screenshot with filename "itemsOnCart"
    And I get back to the inventory page
    When I click the remove button from the item "Sauce Labs Onesie"
    Then I check the remove shopping cart icon displays a badge with value "1"
    And I take a remove screenshot with filename "removeItem1"
    When I click the remove button from the item "Test.allTheThings() T-Shirt (Red)"
    Then I check the remove shopping cart icon does not display a badge
    And I take a remove screenshot with filename "removeItem2"
    And I quit the store webpage to remove items from the cart

  Scenario: Remove items from the item page
    Given I go to the store webpage to remove items from the cart
    Then I login to the store webpage to remove items from the cart
    Then I add to the cart the item "Sauce Labs Bolt T-Shirt"
    Then I add to the cart the item "Sauce Labs Backpack"
    Then I check the remove shopping cart icon displays a badge with value "2"
    And I take a remove screenshot with filename "removeStart"
    When I click the shopping cart button to see the items
    Then I check the shopping cart page displays the items:
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Backpack     |
    Then I go the item page "Sauce Labs Bolt T-Shirt"
    When I remove the item from the shopping cart
    Then I check the remove shopping cart icon displays a badge with value "1"
    And I take a remove screenshot with filename "removeItem1"
    When I go to the item page "Sauce Labs Backpak"
    When I remove the item from the shopping cart
    Then I check the remove shopping cart icon does not display a badge
    And I take a remove screenshot with filename "removeItem2"
    And I quit the store webpage to remove items from the cart

  Scenario: Remove items from the inventory and from the item page
    Given I go to the store webpage to remove items from the cart
    Then I login to the store webpage to remove items from the cart
    Then I add to the cart the item "Sauce Labs Bike Light"
    Then I add to the cart the item "Sauce Labs Fleece Jacket"
    Then I check the remove shopping cart icon displays a badge with value "2"
    And I take a remove screenshot with filename "removeStart"
    When I click the shopping cart button to see the items
    Then I check the shopping cart page displays the items:
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    And I get back to the inventory page
    When I click the remove button from the item "Sauce Labs Bike Light"
    Then I check the remove shopping cart icon displays a badge with value "1"
    And I take a remove screenshot with filename "removeItem1"
    When I go to the item page "Sauce Labs Fleece Jacket"
    When I remove the item from the shopping cart
    Then I check the remove shopping cart icon does not display a badge
    And I take a remove screenshot with filename "removeItem2"
    And I quit the store webpage to remove items from the cart