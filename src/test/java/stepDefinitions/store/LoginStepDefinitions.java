package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStepDefinitions {

    @Before("@Login")
    public void before(Scenario scenario) {
        TestUtils.InitializeAndSetWebDriver();
        TestUtils.SetScenario(scenario);
    }

    @Given("I go to the store webpage")
    public void iGoToTheStoreWebpage() {
        TestUtils.GetWebDriver()
            .get("https://www.saucedemo.com/");
    }

    @Then("I check the input {string} is empty")
    public void iCheckTheInputIsEmpty(String inputId) {
        WebElement inputElement = TestUtils.GetWebDriver()
            .findElement(
                By.id(inputId));

        assertEquals("", inputElement.getText());
    }

    @Then("I check the error container is empty")
    public void iCheckTheErrorContainerIsEmpty() {
        WebElement errorContainerElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("error-message-container"));

        boolean found = true;
        try {
            errorContainerElement.findElement(
                By.xpath("//h3[@data-test='error']"));
        } catch (NoSuchElementException ignored) {
            found = false;
        } finally {
            assertFalse(found);
        }
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        TestUtils.GetWebDriver()
            .findElement(
                By.id("login-button"))
            .click();
    }

    @Then("I check the input {string} is displayed as error")
    public void iCheckTheInputIsDisplayedAsError(String inputId) {
        WebElement inputElement = TestUtils.GetWebDriver()
            .findElement(
                By.id(inputId));

        assertTrue(inputElement
            .getAttribute("class")
            .contains("error"));
    }

    @Then("I check the error container displays the message: {string}")
    public void iCheckTheErrorContainerDisplaysTheMessage(String message) {
        WebElement errorContainerElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("error-message-container"));

        WebElement errorMessage = errorContainerElement.findElement(
            By.xpath("//h3[@data-test='error']"));

        assertEquals(message, errorMessage.getText());
    }

    @Then("I fill the input {string} with the value {string}")
    public void iFillTheInputWithTheValue(String inputId, String value) {
        WebElement inputElement = TestUtils.GetWebDriver()
            .findElement(
                By.id(inputId));

        inputElement.clear();
        inputElement.sendKeys(value);
    }

    @Then("I check the webpage has changed to {string}")
    public void iCheckTheWebpageHasChangedTo(String webpage) {
        assertEquals(webpage, TestUtils.GetWebDriver().getCurrentUrl());
    }

    @And("I take a screenshot with filename {string}")
    public void iTakeAScreenshotWithFilename(String fileName) {
        TestUtils.TakeScreenshot(fileName);
    }

    @And("I close the store webpage")
    public void iCloseTheStoreWebpage() {
        TestUtils.GetWebDriver()
            .close();
    }
}
