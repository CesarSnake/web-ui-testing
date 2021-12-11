package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.utils.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortInventoryStepDefinitions {

    @Before("@SortStoreInventory")
    public void before(Scenario scenario) {
        TestUtils.InitializeAndSetWebDriver();
        TestUtils.SetScenario(scenario);
    }

    @Then("I login in the store webpage")
    public void iLoginInTheStoreWebpage() {
        TestUtils.GetWebDriver()
            .findElement(
                By.id("user-name"))
            .sendKeys("standard_user");

        TestUtils.GetWebDriver()
            .findElement(
                By.id("password"))
            .sendKeys("secret_sauce");

        TestUtils.GetWebDriver()
            .findElement(
                By.id("login-button"))
            .click();
    }

    @When("I change the sort select to option {string}")
    public void iChangeTheSortSelectToOption(String displayText) {
        WebElement selectElement = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//select[@data-test='product_sort_container']"));

        Select select = new Select(selectElement);
        select.selectByVisibleText(displayText);
    }

    @Then("I check the order of the inventory is:")
    public void iCheckTheOrderOfTheInventoryIs(List<String> elements) {
        WebElement inventoryContainerElement = TestUtils.GetWebDriver()
            .findElement(
                By.id("inventory_container"));

        List<WebElement> inventoryElements = inventoryContainerElement.findElements(
            By.xpath("//div[@class='inventory_item_name']"));

        // the inventory must have the same elements that the list provided
        assertEquals(elements.size(), inventoryElements.size());

        // also, the order of the display elements must be the order of the list provided
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(
                elements.get(i),
                inventoryElements.get(i)
                    .getText());
        }
    }
}
