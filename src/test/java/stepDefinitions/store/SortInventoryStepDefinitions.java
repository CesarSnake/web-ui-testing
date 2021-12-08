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
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.utils.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortInventoryStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@SortStoreInventory")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the store webpage to sort inventory")
    public void iGoToTheStoreWebpageToSortInventory() {
        driver.get("https://www.saucedemo.com/");
    }

    @Then("I login to the store webpage to sort inventory")
    public void iLoginToTheStoreWebpageToSortInventory() {
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

    @When("I change the sort select to option {string}")
    public void iChangeTheSortSelectToOption(String displayText) {
        WebElement selectElement = driver.findElement(
            By.xpath("//select[@data-test='product_sort_container']"));

        Select select = new Select(selectElement);
        select.selectByVisibleText(displayText);
    }

    @Then("I check the order of the inventory is:")
    public void iCheckTheOrderOfTheInventoryIs(List<String> elements) {
        WebElement inventoryContainerElement = driver.findElement(
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

    @And("I take a sort store screenshot with filename {string}")
    public void iTakeASortStoreScreenshotWithFilename(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I quit the sort store webpage")
    public void iQuitTheSortStoreWebpage() {
        driver.quit();
    }
}
