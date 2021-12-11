package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class AddToCartStepDefinitions {

    @Before("@AddToCart")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @When("I click the button {string} of the item {string}")
    public void iClickTheButtonOfTheItem(String buttonText, String itemDisplayText) {
        WebElement button = GetButtonOfTheItem(itemDisplayText);

        assertEquals(buttonText, button.getText());
        button.click();
    }

    @Then("I check the button of the item {string} has changed to {string}")
    public void iCheckTheButtonOfTheItemHasChangedTo(String itemDisplayText, String buttonText) {
        WebElement button = GetButtonOfTheItem(itemDisplayText);

        assertEquals(buttonText, button.getText());
    }

    @Then("I check the shopping cart displays a badge with value {string}")
    public void iCheckTheShoppingCartDisplaysABadgeWithValue(String number) {
        WebElement cartBadge = TestUtils.GetWebDriver()
            .findElement(
                By.className("shopping_cart_badge"));

        assertEquals(number, cartBadge.getText());
    }

    @When("I click the cart button")
    public void iClickTheCartButton() {
        TestUtils.GetWebDriver()
            .findElement(
                By.className("shopping_cart_link"))
            .click();
    }

    @Then("I check the cart page displays the items:")
    public void iCheckTheCartPageDisplaysTheItems(List<String> cartItems) {
        List<WebElement> items = TestUtils.GetWebDriver()
            .findElements(
                By.className("inventory_item_name"));

        // the size of items must be the same that the list provided
        assertEquals(cartItems.size(), items.size());

        for (int i = 0; i < cartItems.size(); i++) {
            assertEquals(
                cartItems.get(i),
                items.get(i)
                    .getText());
        }
    }

    @When("I click on the item {string} to see the item page")
    public void iClickOnTheItemToSeeTheItemPage(String itemDisplayText) {
        TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//a/div[text()='" + itemDisplayText + "']"))
            .click();
    }

    @Then("I check the web page is the item {string}")
    public void iCheckTheWebPageIsTheItem(String itemDisplayText) {
        WebElement item = TestUtils.GetWebDriver()
            .findElement(
                By.className("inventory_details_name"));

        assertEquals(itemDisplayText, item.getText());
    }

    @When("I click the button {string} in the item page")
    public void iClickTheButtonInTheItemPage(String buttonText) {
        WebElement descContainerElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("inventory_details_desc_container"));

        WebElement button = descContainerElement.findElement(
            By.tagName("button"));

        assertEquals(buttonText, button.getText());
        button.click();
    }

    @Then("I check the button in the item page has changed to {string}")
    public void iCheckTheButtonInTheItemPageHasChangedTo(String buttonText) {
        WebElement descContainerElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("inventory_details_desc_container"));

        WebElement button = descContainerElement.findElement(
            By.tagName("button"));

        assertEquals(buttonText, button.getText());
    }

    @And("I get back to the inventory page clicking the button {string}")
    public void iGetBackToTheInventoryPageClickingTheButton(String buttonText) {
        TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + buttonText + "']"))
            .click();
    }

    private WebElement GetButtonOfTheItem(String itemDisplayText) {
        List<WebElement> itemsElements = TestUtils.GetWebDriver()
                .findElements(
                        By.className("inventory_item_description"));

        // same of the previous step, the item description contains 2 divs one with the link label and other with the price bar
        List<WebElement> itemElementSingle = itemsElements
                .stream()
                .filter(webElement -> webElement.findElement(
                                By.className("inventory_item_name"))
                        .getText()
                        .equals(itemDisplayText))
                .collect(Collectors.toList());

        // check we have found the item provided and save it
        assertEquals(1, itemElementSingle.size());

        WebElement itemDescriptionElement = itemElementSingle.get(0);
        assertEquals(
                itemDisplayText,
                itemDescriptionElement.findElement(
                                By.className("inventory_item_name"))
                        .getText());

        // get the button and return
        return itemDescriptionElement.findElement(
            By.tagName("button"));
    }
}
