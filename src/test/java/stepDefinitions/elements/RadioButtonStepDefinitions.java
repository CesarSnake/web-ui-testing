package stepDefinitions.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class RadioButtonStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@RadioButton")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @After("@RadioButton")
    public void after() {
        driver.quit();
    }

    @Given("I go to the Radio Button webpage {string}")
    public void iGoToTheRadioButtonWebpage(String webpage) {
        driver.get(webpage);
    }

    @When("I click the radio button {string}")
    public void iClickTheRadioButton(String radioButtonId) {
        driver.findElement(By.xpath("//*[contains(@for, '" + radioButtonId + "')]"))
            .click();
    }

    @Then("I check the radio button {string} is selected")
    public void iCheckTheRadioButtonIsSelected(String radioButton) {
        WebElement resultElement = driver.findElement(By.className("text-success"));
        assertEquals(radioButton, resultElement.getText());
    }

    @Then("I check the radio button {string} is disabled")
    public void iCheckTheRadioButtonIsDisabled(String radioButtonId) {
        WebElement radioButton = driver.findElement(By.id(radioButtonId));
        String classAttribute = radioButton.getAttribute("class");
        assertTrue(classAttribute.contains("disabled"));
    }

    @And("I take a radio button screenshot with the name {string}")
    public void iTakeARadioButtonScreenshotWithTheName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Radio button webpage")
    public void iCloseTheRadioButtonWebpage() {
        driver.close();
    }
}
