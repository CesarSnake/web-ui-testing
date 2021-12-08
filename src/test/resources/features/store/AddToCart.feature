@AddToCart
Feature: Add items to cart

  Scenario: Add items from the inventory page
    Given I go to the store webpage to add items in the cart
    Then I login to the store webpage to add items in the cart
    When I add to cart the item "Sauce Labs Onesie"
    Then I check the button of the item "Sauce Labs Onesie" has changed to remove
    Then I check the shopping cart icon displays a badge with value "1"
    And I take a add to cart screenshot with filename "itemsAddedFromInventory1"
    When I add to cart the item "Test.allTheThings() T-Shirt (Red)"
    Then I check the button of the item "Test.allTheThings() T-Shirt (Red)" has changed to remove
    Then I check the shopping cart icon displays a badge with value "2"
    And I take a add to cart screenshot with filename "itemsAddedFromInventory2"
    When I click the cart button to see the items I added
    Then I check the cart page displays the items I added:
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I take a add to cart screenshot with filename "itemsAddedFromInventoryCart"
    And I quit the store webpage to add items in the cart

  Scenario: Add items from the item page
    Given I go to the store webpage to add items in the cart
    Then I login to the store webpage to add items in the cart
    And I take a add to cart screenshot with filename "itemsAddedFromItemPageStart"
    When I click on the item "Sauce Labs Bolt T-Shirt" to see the item page
    Then I check the web page is the item "Sauce Labs Bolt T-Shirt"
    When I add the item in the cart
    Then I check the button in the item page has changed to remove
    Then I check the shopping cart icon displays a badge with value "1"
    And I take a add to cart screenshot with filename "itemAddedFromItemPage1"
    And I get back to the inventory page clicking the button "Back to products"
    When I click on the item "Sauce Labs Backpack" to see the item page
    Then I check the web page is the item "Sauce Labs Backpack"
    When I add the item in the cart
    Then I check the button in the item page has changed to remove
    Then I check the shopping cart icon displays a badge with value "2"
    And I take a add to cart screenshot with filename "itemAddedFromItemPage2"
    When I click the cart button to see the items I added
    Then I check the cart page displays the items I added:
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Backpack     |
    And I take a add to cart screenshot with filename "itemsAddedFromItemPageCart"
    And I quit the store webpage to add items in the cart

  Scenario: Add items from the inventory and from the item page
    Given I go to the store webpage to add items in the cart
    Then I login to the store webpage to add items in the cart
    And I take a add to cart screenshot with filename "itemsAddedMixStart"
    When I click on the item "Sauce Labs Bike Light" to see the item page
    Then I check the web page is the item "Sauce Labs Bike Light"
    When I add the item in the cart
    Then I check the button in the item page has changed to remove
    Then I check the shopping cart icon displays a badge with value "1"
    And I take a add to cart screenshot with filename "itemAdded1"
    And I get back to the inventory page clicking the button "Back to products"
    When I add to cart the item "Sauce Labs Fleece Jacket"
    Then I check the button of the item "Sauce Labs Fleece Jacket" has changed to remove
    Then I check the shopping cart icon displays a badge with value "2"
    And I take a add to cart screenshot with filename "itemAdded2"
    When I click the cart button to see the items I added
    Then I check the cart page displays the items I added:
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    And I take a add to cart screenshot with filename "itemsAddedMixCart"
    And I quit the store webpage to add items in the cart