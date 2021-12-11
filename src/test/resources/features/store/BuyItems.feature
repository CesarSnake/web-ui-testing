@BuyItem
Feature: Buy items from the shop

  Scenario: Buy items using empty values on the checkout
    Given I go to the store webpage
    Then I login in the store webpage
    Then I click the button "ADD TO CART" of the item "Sauce Labs Onesie"
    Then I click the button "ADD TO CART" of the item "Sauce Labs Backpack"
    Then I check the shopping cart displays a badge with value "2"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Onesie   |
      | Sauce Labs Backpack |
    And I take a screenshot with filename "itemsOnCart"
    When I click the button "checkout"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-one.html"
    Then I check the input "first-name" is empty
    Then I check the input "last-name" is empty
    Then I check the input "postal-code" is empty
    Then I check the error container is empty
    When I click the button "continue"
    Then I check the input "first-name" is displayed as error
    Then I check the input "last-name" is displayed as error
    Then I check the input "postal-code" is displayed as error
    Then I check the error container displays the message: "Error: First Name is required"
    And I take a screenshot with filename "customerInfoErrorFirst"
    Then I fill the input "first-name" with the value "FirstNameNoError"
    When I click the button "continue"
    Then I check the error container displays the message: "Error: Last Name is required"
    And I take a screenshot with filename "customerInfoErrorLast"
    Then I fill the input "last-name" with the value "LastNameNoError"
    When I click the button "continue"
    Then I check the error container displays the message: "Error: Postal Code is required"
    And I take a screenshot with filename "customerInfoErrorPostal"
    Then I fill the input "postal-code" with the value "12345"
    When I click the button "continue"
    And I take a screenshot with filename "customerInfoSuccess"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-two.html"
    And I close the store webpage

  Scenario: Buy items from the inventory page
    Given I go to the store webpage
    Then I login in the store webpage
    Then I click the button "ADD TO CART" of the item "Sauce Labs Onesie"
    Then I click the button "ADD TO CART" of the item "Test.allTheThings() T-Shirt (Red)"
    Then I click the button "ADD TO CART" of the item "Sauce Labs Backpack"
    Then I check the shopping cart displays a badge with value "3"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |
    And I take a screenshot with filename "itemsOnCart"
    When I click the button "checkout"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-one.html"
    Then I fill the input "first-name" with the value "TestFirstName"
    Then I fill the input "last-name" with the value "TestLastName"
    Then I fill the input "postal-code" with the value "00000"
    And I take a screenshot with filename "customerInfo"
    When I click the button "continue"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-two.html"
    Then I check the cart list contains the items:
    # | qty | item                              | price |
      | 1   | Sauce Labs Onesie                 | $7.99 |
      | 1   | Test.allTheThings() T-Shirt (Red) | $15.99 |
      | 1   | Sauce Labs Backpack               | $29.99 |
    Then  I check the page displays the element "summary_subtotal_label" with text "Item total: $53.97"
    Then  I check the page displays the element "summary_tax_label" with text "Tax: $4.32"
    Then  I check the page displays the element "summary_total_label" with text "Total: $58.29"
    And I take a screenshot with filename "cartSummary"
    When I click the button "finish"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-complete.html"
    Then I check the page displays the element "complete-header" with text "THANK YOU FOR YOUR ORDER"
    Then I check the page displays the element "complete-text" with text "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
    Then I check the page displays the image "/static/media/pony-express.46394a5d.png" with size width "523" and size height "381"
    And I take a screenshot with filename "checkoutEnd"
    When I click the button "back-to-products"
    Then I check the webpage has changed to "https://www.saucedemo.com/inventory.html"
    Then I check the cart icon does not display a badge
    And I take a screenshot with filename "buyItemFinish"
    And I close the store webpage

  Scenario: Buy items from the item page
    Given I go to the store webpage
    Then I login in the store webpage
    When I click on the item "Sauce Labs Bolt T-Shirt" to see the item page
    Then I check the web page is the item "Sauce Labs Bolt T-Shirt"
    When I click the button "ADD TO CART" in the item page
    And I get back to the inventory page clicking the button "Back to products"
    When I click on the item "Sauce Labs Fleece Jacket" to see the item page
    Then I check the web page is the item "Sauce Labs Fleece Jacket"
    When I click the button "ADD TO CART" in the item page
    And I get back to the inventory page clicking the button "Back to products"
    When I click on the item "Sauce Labs Bike Light" to see the item page
    Then I check the web page is the item "Sauce Labs Bike Light"
    When I click the button "ADD TO CART" in the item page
    Then I check the shopping cart displays a badge with value "3"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Bike Light    |
    And I take a screenshot with filename "itemsOnCart"
    When I click the button "checkout"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-one.html"
    Then I fill the input "first-name" with the value "TestFirstName1"
    Then I fill the input "last-name" with the value "TestLastName1"
    Then I fill the input "postal-code" with the value "00001"
    And I take a screenshot with filename "customerInfo"
    When I click the button "continue"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-two.html"
    Then I check the cart list contains the items:
    # | qty | item                     | price |
      | 1   | Sauce Labs Bolt T-Shirt  | $15.99 |
      | 1   | Sauce Labs Fleece Jacket | $49.99 |
      | 1   | Sauce Labs Bike Light    | $9.99 |
    Then  I check the page displays the element "summary_subtotal_label" with text "Item total: $75.97"
    Then  I check the page displays the element "summary_tax_label" with text "Tax: $6.08"
    Then  I check the page displays the element "summary_total_label" with text "Total: $82.05"
    And I take a screenshot with filename "cartSummary"
    When I click the button "finish"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-complete.html"
    Then I check the page displays the element "complete-header" with text "THANK YOU FOR YOUR ORDER"
    Then I check the page displays the element "complete-text" with text "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
    Then I check the page displays the image "/static/media/pony-express.46394a5d.png" with size width "523" and size height "381"
    And I take a screenshot with filename "checkoutEnd"
    When I click the button "back-to-products"
    Then I check the webpage has changed to "https://www.saucedemo.com/inventory.html"
    Then I check the cart icon does not display a badge
    And I take a screenshot with filename "buyItemFinish"
    And I close the store webpage

  Scenario: Buy items from the inventory and from the item page
    Given I go to the store webpage
    Then I login in the store webpage
    Then I click the button "ADD TO CART" of the item "Sauce Labs Bolt T-Shirt"
    Then I click the button "ADD TO CART" of the item "Sauce Labs Fleece Jacket"
    Then I check the shopping cart displays a badge with value "2"
    When I click on the item "Sauce Labs Onesie" to see the item page
    Then I check the web page is the item "Sauce Labs Onesie"
    When I click the button "ADD TO CART" in the item page
    And I get back to the inventory page clicking the button "Back to products"
    When I click on the item "Test.allTheThings() T-Shirt (Red)" to see the item page
    Then I check the web page is the item "Test.allTheThings() T-Shirt (Red)"
    When I click the button "ADD TO CART" in the item page
    Then I check the shopping cart displays a badge with value "4"
    When I click the cart button
    Then I check the cart page displays the items:
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I take a screenshot with filename "itemsOnCart"
    When I click the button "checkout"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-one.html"
    Then I fill the input "first-name" with the value "TestFirstName4"
    Then I fill the input "last-name" with the value "TestLastName4"
    Then I fill the input "postal-code" with the value "00004"
    And I take a screenshot with filename "customerInfo"
    When I click the button "continue"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-step-two.html"
    Then I check the cart list contains the items:
    # | qty | item                              | price |
      | 1   | Sauce Labs Bolt T-Shirt           | $15.99 |
      | 1   | Sauce Labs Fleece Jacket          | $49.99 |
      | 1   | Sauce Labs Onesie                 | $7.99 |
      | 1   | Test.allTheThings() T-Shirt (Red) | $15.99 |
    Then  I check the page displays the element "summary_subtotal_label" with text "Item total: $89.96"
    Then  I check the page displays the element "summary_tax_label" with text "Tax: $7.20"
    Then  I check the page displays the element "summary_total_label" with text "Total: $97.16"
    And I take a screenshot with filename "cartSummary"
    When I click the button "finish"
    Then I check the webpage has changed to "https://www.saucedemo.com/checkout-complete.html"
    Then I check the page displays the element "complete-header" with text "THANK YOU FOR YOUR ORDER"
    Then I check the page displays the element "complete-text" with text "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
    Then I check the page displays the image "/static/media/pony-express.46394a5d.png" with size width "523" and size height "381"
    And I take a screenshot with filename "checkoutEnd"
    When I click the button "back-to-products"
    Then I check the webpage has changed to "https://www.saucedemo.com/inventory.html"
    Then I check the cart icon does not display a badge
    And I take a screenshot with filename "buyItemFinish"
    And I close the store webpage