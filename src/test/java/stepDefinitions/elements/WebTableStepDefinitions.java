package stepDefinitions.elements;

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

public class WebTableStepDefinitions {
    @Before("@WebTable")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @Then("I check web table contains the elements:")
    public void iCheckWebTableContainsTheElements(List<List<String>> rowsExpected) {
        // Get the webTable
        WebElement tableElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("rt-tbody"));

        // from the webTable get only the rows (header is not needed)
        List<WebElement> tableRowElements = tableElement
            .findElements(
                By.className("rt-tr"));

        for (int i = 0; i < tableRowElements.size(); i++) {
            // from each row, let's take each cell
            List<WebElement> cellsInRowDisplayed = tableRowElements
                .get(i)
                .findElements(
                    By.className("rt-td"));

            cellsInRowDisplayed.remove(
            cellsInRowDisplayed.size() - 1); // the last element is the cell with the action buttons

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
        WebElement tableElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("rt-tbody"));

        List<WebElement> tableRowElements = tableElement
            .findElements(
                By.className("rt-tr"));

        assertEquals(Integer.valueOf(rowsNumber), tableRowElements.size());
    }

    @Then("I check the registration form has not errors")
    public void iCheckTheRegistrationFormHasNotErrors() {
        WebElement userFormElement = TestUtils.GetWebDriver()
            .findElement(
                By.id("userForm"));

        assertTrue(userFormElement.getAttribute("class").isEmpty());
    }

    @Then("I check the registration form has errors")
    public void iCheckTheRegistrationFormHasErrors() {
        WebElement userFormElement = TestUtils.GetWebDriver()
            .findElement(
                By.id("userForm"));

        assertEquals("was-validated", userFormElement.getAttribute("class"));
    }

    @When("I change the select to option {string} rows")
    public void iChangeTheSelectToOptionRows(String value) {
        WebElement selectElement = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//select[@aria-label='rows per page']"));

        Select select = new Select(selectElement);
        select.selectByValue(value);
    }
}