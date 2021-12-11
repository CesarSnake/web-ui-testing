@RemoveFromCart
Feature: Remove items from cart

  Scenario: Remove items from the inventory page
    Given I go to the store webpage
    Then I login in the store webpage
    Then I click the button "ADD TO CART" of the item "Sauce Labs Onesie"
    Then I click the button "ADD TO CART" of the item "Test.allTheThings() T-Shirt (Red)"
    Then I check the shopping cart displays a badge with value "2"
    And I take a screenshot with filename "removeStart"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I take a screenshot with filename "itemsOnCart"
    And I get back to the inventory page clicking the button "Continue Shopping"
    When I click the button "REMOVE" of the item "Sauce Labs Onesie"
    Then I check the button of the item "Sauce Labs Onesie" has changed to "ADD TO CART"
    Then I check the shopping cart displays a badge with value "1"
    And I take a screenshot with filename "removeItem1"
    When I click the button "REMOVE" of the item "Test.allTheThings() T-Shirt (Red)"
    Then I check the button of the item "Test.allTheThings() T-Shirt (Red)" has changed to "ADD TO CART"
    Then I check the cart icon does not display a badge
    And I take a screenshot with filename "removeItem2"
    And I close the store webpage

  Scenario: Remove items from the item page
    Given I go to the store webpage
    Then I login in the store webpage
    Then I click the button "ADD TO CART" of the item "Sauce Labs Bolt T-Shirt"
    Then I click the button "ADD TO CART" of the item "Sauce Labs Backpack"
    Then I check the shopping cart displays a badge with value "2"
    And I take a screenshot with filename "removeStart"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Backpack     |
    Then I click on the item "Sauce Labs Bolt T-Shirt" to see the item page
    When I click the button "REMOVE" in the item page
    Then I check the button in the item page has changed to "ADD TO CART"
    Then I check the shopping cart displays a badge with value "1"
    And I take a screenshot with filename "removeItem1"
    And I get back to the inventory page clicking the button "Back to products"
    When I click on the item "Sauce Labs Backpack" to see the item page
    When I click the button "REMOVE" in the item page
    Then I check the button in the item page has changed to "ADD TO CART"
    Then I check the cart icon does not display a badge
    And I take a screenshot with filename "removeItem2"
    And I close the store webpage

  Scenario: Remove items from the inventory and from the item page
    Given I go to the store webpage
    Then I login in the store webpage
    Then I click the button "ADD TO CART" of the item "Sauce Labs Bike Light"
    Then I click the button "ADD TO CART" of the item "Sauce Labs Fleece Jacket"
    Then I check the shopping cart displays a badge with value "2"
    And I take a screenshot with filename "removeStart"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    And I get back to the inventory page clicking the button "Continue Shopping"
    When I click the button "REMOVE" of the item "Sauce Labs Bike Light"
    Then I check the button of the item "Sauce Labs Bike Light" has changed to "ADD TO CART"
    Then I check the shopping cart displays a badge with value "1"
    And I take a screenshot with filename "removeItem1"
    When I click on the item "Sauce Labs Fleece Jacket" to see the item page
    Then I check the web page is the item "Sauce Labs Fleece Jacket"
    When I click the button "REMOVE" in the item page
    Then I check the button in the item page has changed to "ADD TO CART"
    Then I check the cart icon does not display a badge
    And I take a screenshot with filename "removeItem2"
    And I close the store webpage