package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuyItemStepDefinitions {

    @Before("@BuyItem")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @When("I click the button {string}")
    public void iClickTheButton(String buttonId) {
        TestUtils.GetWebDriver()
            .findElement(
                By.id(buttonId))
            .click();
    }

    @Then("I check the cart list contains the items:")
    public void iCheckTheCartListContainsTheItems(List<List<String>> itemsInfo) {
        WebElement cartList = TestUtils.GetWebDriver()
            .findElement(
                By.className("cart_list"));

        List<WebElement> cartItems = cartList.findElements(
            By.className("cart_item"));

        // the size of the items in cart must be the same that the list provided
        assertEquals(itemsInfo.size(), cartItems.size());

        // each itemInfo has the info of the item with the order: | qty | item | price |
        for (int i = 0; i < cartItems.size(); i++) {
            WebElement item = cartItems.get(i);
            List<String> itemInfo = itemsInfo.get(i);

            // get the quantity
            String itemQty = item.findElement(
                By.className("cart_quantity"))
                .getText();

            // the quantity is in the first position
            assertEquals(itemInfo.get(0), itemQty);

            // get the item name
            String itemName = item.findElement(
                By.className("inventory_item_name"))
                .getText();

            // the item name is in the second position
            assertEquals(itemInfo.get(1), itemName);

            // get the item price
            String itemPrice = item.findElement(
                By.className("inventory_item_price"))
                .getText();

            // the item price is in the third position
            assertEquals(itemInfo.get(2), itemPrice);
        }
    }

    @Then("I check the page displays the element {string} with text {string}")
    public void iCheckThePageDisplaysTheElementWithText(String elementClass, String textDisplayed) {
        WebElement element = TestUtils.GetWebDriver()
            .findElement(
                By.className(elementClass));

        assertEquals(textDisplayed, element.getText());
    }

    @Then("I check the page displays the image {string} with size width {string} and size height {string}")
    public void iCheckThePageDisplaysTheImageWithSizeWidthAndSizeHeight(String imageSrc, String width, String height) {
        WebElement checkoutContainer = TestUtils.GetWebDriver()
            .findElement(
                By.id("checkout_complete_container"));

        WebElement image = checkoutContainer.findElement(
                By.tagName("img"));

        assertEquals("https://www.saucedemo.com" + imageSrc, image.getAttribute("src"));
        assertEquals(Integer.valueOf(width), image.getSize().width);
        assertEquals(Integer.valueOf(height), image.getSize().height);
    }
}
