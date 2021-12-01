package stepDefinitions.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import utils.TestUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TextBoxStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@TextBox")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @After("@TextBox")
    public void after() {
        driver.quit();
    }

    @Given("I go to Text Box webpage {string}")
    public void iGoToTextBoxWebpage(String webPage) {
        driver.get(webPage);
    }

    @Then("I check {string} text box is empty")
    public void iCheckTextBoxIsEmpty(String textBoxId) {
        WebElement textElement = driver.findElement(By.id(textBoxId));
        assertTrue(textElement.getText().isEmpty());
    }

    @Then("I fill {string} text box with text {string}")
    public void iFillTextBoxWithText(String textBoxId, String text) {
        driver.findElement(By.id(textBoxId))
            .sendKeys(text);
    }

    @And("I check {string} text box is displayed as {string}")
    public void iCheckTextBoxIsDisplayedAs(String textBoxId, String classCss) {
        WebElement webElement = driver.findElement(By.id(textBoxId));
        String classAttribute = webElement.getAttribute("class");
        assertTrue(classAttribute.contains(classCss));
    }

    @And("I click text box page {string} button")
    public void iClickTextBoxPageButton(String buttonId) {
        driver.findElement(By.id(buttonId))
            .click();
    }

    @And("I check {string} text box element is displayed as error")
    public void iCheckTextBoxIsDisplayedAsError(String textBoxId) {
        WebElement element = driver.findElement(By.id(textBoxId));
        assertTrue(element.getAttribute("class").contains("field-error"));
    }

    @And("I clean {string} text box")
    public void iCleanTextBox(String textBoxId) {
        driver.findElement(By.id(textBoxId))
            .clear();
    }

    @And("I should see a {string} box with the following text box results test:")
    public void iShouldSeeABoxWithTheFollowingTextBoxResultsTest(String textBoxId, Map<String, String> mapValues) {
        WebElement webElement = driver.findElement(By.id(textBoxId));

        for (Map.Entry<String, String> entry: mapValues.entrySet()) {
            WebElement outputElement = webElement.findElement(By.id(entry.getKey()));
            assertTrue(outputElement.getText().contains(entry.getValue()));
        }
    }

    @And("I take a text box page screenshot with fileName {string}")
    public void iTakeATextBoxPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Text Box webpage")
    public void iCloseTheTextBoxWebpage()  {
        driver.close();
    }
}
