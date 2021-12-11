package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import stepDefinitions.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class RadioButtonStepDefinitions {
    @Before("@RadioButton")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
    }

    @Before("@RadioButtonChecking or @RadioButtonYes")
    public void before() {
        TestUtils.InitializeAndSetWebDriver();
    }

    @Then("I check the radio button {string} is not selected")
    public void iCheckTheRadioButtonIsNotSelected(String radioButtonDisplayText) {
        boolean found = true;
        try {
            // the result is not displayed if the radio buttons are not selected
            WebElement resultContainer = TestUtils.GetWebDriver()
                .findElement(
                    By.className("mt-3"));

            // if it is displayed, check if the radio button is unselected
            found = resultContainer
                .getText()
                .contains(radioButtonDisplayText);

        } catch (NoSuchElementException ignored) {
            found = false;
        } finally {
            assertFalse(found);
        }
    }

    @Then("I check the radio button {string} is disabled")
    public void iCheckTheRadioButtonIsDisabled(String radioButtonId) {
        WebElement radioButton = TestUtils.GetWebDriver()
            .findElement(
                By.id(radioButtonId));

        String classAttribute = radioButton.getAttribute(
            "class");

        assertTrue(classAttribute
            .contains(
                "disabled"));
    }

    @When("I click the radio button {string}")
    public void iClickTheRadioButton(String radioButtonId) {
        TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//label[@for='" + radioButtonId + "']"))
            .click();
    }

    @Then("I check the radio button {string} is selected")
    public void iCheckTheRadioButtonIsSelected(String radioButtonDisplayText) {
        WebElement resultContainer = TestUtils.GetWebDriver()
            .findElement(
                By.className("mt-3"));

        assertTrue(resultContainer
            .getText()
            .contains(radioButtonDisplayText));
    }
}
