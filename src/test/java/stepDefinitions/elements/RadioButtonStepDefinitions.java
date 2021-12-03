package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import stepDefinitions.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class RadioButtonStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@RadioButton")
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Before("@RadioButtonChecking or @RadioButtonYes")
    public void before() {
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the RadioButton webpage")
    public void iGoToTheRadioButtonWebpage() {
        driver.get("https://demoqa.com/radio-button");
    }

    @Then("I check the radio button {string} is not selected")
    public void iCheckTheRadioButtonIsNotSelected(String radioButtonDisplayText) {
        boolean found = true;
        try {
            // the result is not displayed if the radio buttons are not selected
            WebElement resultContainer = driver.findElement(
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
        WebElement radioButton = driver.findElement(
            By.id(radioButtonId));

        String classAttribute = radioButton.getAttribute(
            "class");

        assertTrue(classAttribute.contains(
            "disabled"));
    }

    @When("I click the radio button {string}")
    public void iClickTheRadioButton(String radioButtonId) {
        driver.findElement(
            By.xpath("//label[@for='" + radioButtonId + "']"))
            .click();
    }

    @Then("I check the radio button {string} is selected")
    public void iCheckTheRadioButtonIsSelected(String radioButtonDisplayText) {
        WebElement resultContainer = driver.findElement(
            By.className("mt-3"));

        assertTrue(resultContainer
            .getText()
            .contains(radioButtonDisplayText));
    }

    @And("I take a RadioButton screenshot with the name {string}")
    public void iTakeARadioButtonScreenshotWithTheName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I let the RadioButton webpage open")
    public void iLetTheRadioButtonWebpageOpen() {
        assertNotNull(driver);

        TestUtils.SaveWebDriver(driver);
        assertNotNull(TestUtils.GetSavedWebDriver());
    }

    @Given("The previous RadioButton webpage opened")
    public void thePreviousRadioButtonWebpageOpened() {
        assertNull(driver);

        driver = TestUtils.GetSavedWebDriver();
        assertNotNull(driver);
    }

    @And("I quit the RadioButton webpage")
    public void iQuitTheRadioButtonWebpage() {
        driver.quit();
    }
}
