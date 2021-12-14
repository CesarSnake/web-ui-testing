package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.utils.TestUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserStepDefinitions {

    @Before("@CrateUserBookStore")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @Then("I check the error box displays: {string}")
    public void iCheckTheErrorBoxDisplays(String message) {
        WebElement outputElement = TestUtils.GetWebDriver()
            .findElement(
                By.id("output"));

        WebElement messageDisplayedElement = outputElement
            .findElement(
                By.id("name"));

        assertEquals(message, messageDisplayedElement.getText());
    }

    @Then("I click the reCaptcha")
    public void iClickTheReCaptcha() {
        // the recaptcha is inside an iframe element, we need to wait to it will be available and then click on it
        new WebDriverWait(TestUtils.GetWebDriver(), Duration.ofSeconds(1))
            .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@title='reCAPTCHA']")));

        // once the iframe is displayed, wait to the checkbox will be available also
        new WebDriverWait(TestUtils.GetWebDriver(), Duration.ofSeconds(2))
            .until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@id='recaptcha-anchor']")))
            .click();

        // as the captcha displays a grid with images to select, let's simulate the user has created using the api
        // give some seconds to the captcha finishes
        TestUtils.Wait("3");
    }

    @Then("I check the reCaptcha displays a grid to choose images")
    public void iCheckTheReCaptchaDisplaysAGridToChooseImages() {
        // if the grid is displayed, the login button is overlapped and cannot be clicked
        try {
            // I use this step due it is the next one after the reCaptcha
            new ButtonsStepDefinitions().iClickTheElementsButton("register");
        } catch (NoSuchElementException exception) {
            assertNotNull(exception.getMessage());
        }
    }

    @Then("I chek the user has been created")
    public void iChekTheUserHasBeenCreated() {
        // when the user is created the webpage launch an alert
        Alert alertDisplayed = TestUtils.GetWebDriver().switchTo().alert();
        assertEquals("User Register Successfully.", alertDisplayed.getText());

        // close the alert
        alertDisplayed.accept();
    }
}
