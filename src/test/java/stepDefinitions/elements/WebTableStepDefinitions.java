package stepDefinitions.elements;

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

public class WebTableStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@WebTable")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the WebTable webpage")
    public void iGoToTheWebTableWebpage() {
        driver.get("https://demoqa.com/webtables");
    }

    @Then("I check web table contains the elements:")
    public void iCheckWebTableContainsTheElements( List<List<String>> rowsExpected) {
        // Get the webTable
        WebElement tableElement = driver.findElement(
            By.className("rt-tbody"));

        // from the webTable get only the rows (header is not needed)
        List<WebElement> tableRowElements = tableElement.findElements(
            By.className("rt-tr"));

        for (int i = 0; i < tableRowElements.size(); i++) {
            // from each row, let's take each cell
            List<WebElement> cellsInRowDisplayed = tableRowElements
                .get(i)
                .findElements(
                    By.className("rt-td"));

            cellsInRowDisplayed.remove(
            cellsInRowDisplayed.size() - 1); // the last element is the action buttons

            for (int j = 0; j < cellsInRowDisplayed.size(); j++) {
                String cellValueDisplayed = cellsInRowDisplayed
                    .get(j)
                    .getText();

                // As the table displays all the rows that the user wants, the empty rows are filled with "&nbsp;"
                if (cellValueDisplayed.equals(" ")) {
                    continue;
                }

                String cellValueExpected = rowsExpected
                    .get(i)
                    .get(j);

                assertEquals(cellValueExpected, cellValueDisplayed);
            }
        }
    }

    @Then("I check web table displays {string} rows")
    public void iCheckWebTableDisplaysRows(String rowsNumber) {
        WebElement tableElement = driver.findElement(
            By.className("rt-tbody"));

        List<WebElement> tableRowElements = tableElement.findElements(
            By.className("rt-tr"));

        assertEquals(Integer.valueOf(rowsNumber), tableRowElements.size());
    }

    @When("I use the search typing {string}")
    public void iUseTheSearchTyping(String typedSearch) {
        WebElement searchElement = driver.findElement(
            By.id("searchBox"));

        searchElement.clear();
        searchElement.sendKeys(typedSearch);
    }

    @When("I press the web table button {string}")
    public void iPressTheWebTableButton(String buttonId) {
        driver.findElement(
            By.id(buttonId))
            .click();
    }

    @Then("I check the registration form element {string} is {string}")
    public void iCheckTheRegistrationFormElementIs(String inputId, String value) {
        String displayedValue = driver.findElement(
            By.id("userForm"))
            .findElement(
                By.id(inputId))
            .getText();

        assertEquals(value, displayedValue);
    }

    @Then("I check the registration form has not errors")
    public void iCheckTheRegistrationFormHasNotErrors() {
        WebElement userFormElement = driver.findElement(
            By.id("userForm"));

        assertEquals("", userFormElement.getAttribute("class"));
    }

    @Then("I check the registration form has errors")
    public void iCheckTheRegistrationFormHasErrors() {
        WebElement userFormElement = driver.findElement(
            By.id("userForm"));

        assertEquals("was-validated", userFormElement.getAttribute("class"));
    }

    @And("I fill the registration form typing on the element {string} the value {string}")
    public void iFillTheRegistrationFormTypingOnTheElementTheValue(String inputId, String value) {
        WebElement inputElement = driver.findElement(
            By.id("userForm"))
            .findElement(By.id(inputId));

        inputElement.clear();
        inputElement.sendKeys(value);
    }

    @And("I check the edit registration form element {string} is {string}")
    public void iCheckTheEditRegistrationFormElementIs(String inputId, String value) {
        String displayedValue = driver.findElement(
            By.id("userForm"))
            .findElement(By.id(inputId))
            .getAttribute("value");

        assertEquals(value, displayedValue);
    }

    @When("I change the select to option {string} rows")
    public void iChangeTheSelectToOptionRows(String value) {
        WebElement selectElement = driver.findElement(
            By.xpath("//select[@aria-label='rows per page']"));

        Select select = new Select(selectElement);
        select.selectByValue(value);
    }

    @And("I quit the Web Table webpage")
    public void iQuitTheWebTableWebpage() {
        driver.quit();
    }

    @And("I take a web table page screenshot with fileName {string}")
    public void iTakeAWebTablePageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }
}