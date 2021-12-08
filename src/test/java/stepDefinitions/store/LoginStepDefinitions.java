package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@Login")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the login store webpage")
    public void iGoToTheLoginStoreWebpage() {
        driver.get("https://www.saucedemo.com/");
    }

    @Then("I check the input {string} is empty")
    public void iCheckTheInputIsEmpty(String inputId) {
        WebElement inputElement = driver.findElement(By.id(inputId));

        assertEquals("", inputElement
            .getText());
    }

    @Then("I check the error container is empty")
    public void iCheckTheErrorContainerIsEmpty() {
        WebElement errorContainerElement = driver.findElement(
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
        driver.findElement(
            By.id("login-button"))
            .click();
    }

    @Then("I check the input {string} is displayed as error")
    public void iCheckTheInputIsDisplayedAsError(String inputId) {
        WebElement inputElement = driver.findElement(
            By.id(inputId));

        assertTrue(inputElement
            .getAttribute("class")
            .contains("error"));
    }

    @Then("I check the error container displays the message: {string}")
    public void iCheckTheErrorContainerDisplaysTheMessage(String message) {
        WebElement errorContainerElement = driver.findElement(
            By.className("error-message-container"));

        WebElement errorMessage = errorContainerElement.findElement(
            By.xpath("//h3[@data-test='error']"));

        assertEquals(message, errorMessage
            .getText());
    }

    @Then("I fill the input {string} with the value {string}")
    public void iFillTheInputWithTheValue(String inputId, String value) {
        WebElement inputElement = driver.findElement(
            By.id(inputId));

        inputElement.clear();
        inputElement.sendKeys(value);
    }

    @Then("I check the webpage has changed to {string}")
    public void iCheckTheWebpageHasChangedTo(String webpage) {
        assertEquals(webpage, driver.getCurrentUrl());
    }

    @And("I take a login store screenshot with filename {string}")
    public void iTakeALoginStoreScreenshotWithFilename(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I quit the login store webpage")
    public void iQuitTheLoginStoreWebpage() {
        driver.quit();
    }
}
