package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class AddToCartFeature {
    Scenario scenario;
    WebDriver driver;

    @Before("@AddToCart")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the store webpage to add items in the cart")
    public void iGoToTheStoreWebpageToAddItemsInTheCart() {
        driver.get("https://www.saucedemo.com/");
    }

    @Then("I login to the store webpage to add items in the cart")
    public void iLoginToTheStoreWebpageToAddItemsInTheCart() {
        driver.findElement(
            By.id("user-name"))
            .sendKeys("standard_user");

        driver.findElement(
            By.id("password"))
            .sendKeys("secret_sauce");

        driver.findElement(
            By.id("login-button"))
            .click();
    }

    @When("I add to cart the item {string}")
    public void iAddToCartTheItem(String itemDisplayText) {
        List<WebElement> itemsElements = driver.findElements(By.className("inventory_item_description"));

        // get the container of the item description, it contains 2 divs one with the link label and other with the price bar
        List<WebElement> itemElementSingle = itemsElements.stream()
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

        // once we get the button required and click
        itemDescriptionElement.findElement(
            By.tagName("button"))
            .click();
    }

    @Then("I check the button of the item {string} has changed to remove")
    public void iCheckTheButtonOfTheItemHasChangedToRemove(String itemDisplayText) {
        List<WebElement> itemsElements = driver.findElements(
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

        // check the button display text
        WebElement button = itemDescriptionElement.findElement(
            By.tagName("button"));

        assertEquals("REMOVE", button.getText());
    }

    @Then("I check the shopping cart icon displays a badge with value {string}")
    public void iCheckTheShoppingCartIconDisplaysABadgeWithValue(String number) {
        WebElement cartBadge = driver.findElement(
            By.className("shopping_cart_badge"));

        assertEquals(number, cartBadge.getText());
    }

    @When("I click the cart button to see the items I added")
    public void iClickTheCartButtonToSeeTheItemsIAdded() {
        driver.findElement(
            By.className("shopping_cart_link"))
            .click();
    }

    @Then("I check the cart page displays the items:")
    public void iCheckTheCartPageDisplaysTheItems() {
    }

    @Then("I check the cart page displays the items I added:")
    public void iCheckTheCartPageDisplaysTheItemsIAdded(List<String> cartItems) {
        List<WebElement> items = driver.findElements(
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
        driver.findElement(
            By.xpath("//a/div[text()='" + itemDisplayText + "']"))
            .click();
    }

    @Then("I check the web page is the item {string}")
    public void iCheckTheWebPageIsTheItem(String itemDisplayText) {
        WebElement item = driver.findElement(
            By.className("inventory_details_name"));

        assertEquals(itemDisplayText, item.getText());
    }

    @When("I add the item in the cart")
    public void iAddTheItemInTheCart() {
        WebElement descContainerElement = driver.findElement(
            By.className("inventory_details_desc_container"));

        descContainerElement.findElement(
            By.xpath("//button[text()='Add to cart']"))
            .click();
    }

    @Then("I check the button in the item page has changed to remove")
    public void iCheckTheButtonInTheItemPageHasChangedToRemove() {
        WebElement descContainerElement = driver.findElement(
            By.className("inventory_details_desc_container"));

        WebElement button = descContainerElement.findElement(
            By.tagName("button"));

        assertEquals("REMOVE", button.getText());
    }

    @And("I get back to the inventory page clicking the button {string}")
    public void iGetBackToTheInventoryPageClickingTheButton(String buttonText) {
        driver.findElement(
            By.xpath("//button[text()='" + buttonText + "']"))
            .click();
    }

    @And("I take a add to cart screenshot with filename {string}")
    public void iTakeAAddToCartScreenshotWithFilename(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I quit the store webpage to add items in the cart")
    public void iQuitTheStoreWebpageToAddItemsInTheCart() {
        driver.quit();
    }
}
