package stepDefinitions.bookstore;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.utils.TestUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@CrateUserBookStore")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }


    @Given("I go to the bookstore webpage to create a user")
    public void iGoToTheBookstoreWebpageToCreateAUser() {
        driver.get("https://demoqa.com/books");
    }

    @When("I click the button {string}")
    public void iClickTheButton(String buttonId) {
        driver.findElement(
            By.id(buttonId))
        .click();
    }

    @Then("I check I have gone to the page {string}")
    public void iCheckIHaveGoneToThePage(String webpage) {
        assertEquals(webpage, driver.getCurrentUrl());
    }

    @Then("I check the input {string} is not displayed as error")
    public void iCheckTheInputIsNotDisplayedAsError(String inputId) {
        WebElement inputElement = driver.findElement(
            By.id(inputId));

        String inputClass = inputElement.getAttribute(
            "class");

        assertFalse(inputClass.contains("is-invalid"));
    }

    @Then("I check the input {string} is displayed as error")
    public void iCheckTheInputIsDisplayedAsError(String inputId) {
        WebElement inputElement = driver.findElement(
            By.id(inputId));

        String inputClass = inputElement.getAttribute(
            "class");

        assertTrue(inputClass.contains("is-invalid"));
    }

    @Then("I fill the input {string} with the value {string}")
    public void iFillTheInputWithTheValue(String inputId, String value) {
        WebElement inputElement = driver.findElement(
            By.id(inputId));

        inputElement.clear();
        inputElement.sendKeys(value);
    }


    @Then("I check the error box displays: {string}")
    public void iCheckTheErrorBoxDisplays(String message) {
        WebElement outputElement = driver.findElement(
            By.id("output"));

        WebElement messageDisplayedElement = outputElement.findElement(
            By.id("name"));

        assertEquals(message, messageDisplayedElement.getText());
    }

    @Then("I click the reCaptcha")
    public void iClickTheReCaptcha() {
        // the recaptcha is inside an iframe element, we need to wait to it will be available and then click on it
        new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@title='reCAPTCHA']")));

        // once the iframe is displayed, wait to the checkbox will be available also
        new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@id='recaptcha-anchor']")))
            .click();

        // as the captcha displays a grid with images to select, let's simulate the user has created using the api
    }


    @And("I take a bookstore register screenshot with filename {string}")
    public void iTakeABookstoreRegisterScreenshotWithFilename(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I quit the bookstore register webpage")
    public void iQuitTheBookstoreRegisterWebpage() {
        driver.quit();
    }
}
