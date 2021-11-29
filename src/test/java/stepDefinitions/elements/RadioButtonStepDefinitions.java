package stepDefinitions.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import utils.TestUtils;

public class RadioButtonStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("I go to the Radio Button webpage {string}")
    public void i_go_to_the_radio_button_webpage(String webpage) {
        driver.get(webpage);
    }

    @Then("I click the radio button {string}")
    public void iClickTheRadioButton(String radioButtonId) {
        driver.findElement(By.xpath("//*[contains(@for, '" + radioButtonId + "')]"))
            .click();
    }

    @And("I check the radio button {string} is selected")
    public void iCheckTheRadioButtonIsSelected(String radioButton) {
        WebElement resultElement = driver.findElement(By.className("text-success"));
        Assertions.assertEquals(radioButton, resultElement.getText());
    }

    @Then("I check the radio button {string} is disabled")
    public void iCheckTheRadioButtonIsDisabled(String radioButtonId) {
        WebElement radioButton = driver.findElement(By.id(radioButtonId));
        String classAttribute = radioButton.getAttribute("class");
        Assertions.assertTrue(classAttribute.contains("disabled"));
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
