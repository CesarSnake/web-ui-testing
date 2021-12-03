package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import stepDefinitions.utils.TestUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TextBoxStepDefinitions {
    Scenario scenario;
    WebDriver driver;


    @Before("@TextBox")
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Before("@TextBoxInvalidMail or @TextBoxValidMail")
    public void before() {
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the TextBox webpage")
    public void iGoToTheTextBoxWebpage() {
        driver.get("https://demoqa.com/text-box");
    }

    @Then("I check the TextBox {string} is empty")
    public void iCheckTheTextBoxIsEmpty(String textBoxId) {
        WebElement textBox = driver.findElement(
            By.id(textBoxId));

        assertTrue(textBox
            .getText()
            .isEmpty());
    }

    @Then("I check the TextBox {string} is not empty")
    public void iCheckTheTextBoxIsNotEmpty(String textBoxId) {
        WebElement textBox = driver.findElement(
            By.id(textBoxId));

        assertEquals("", textBox
            .getText());
    }

    @And("I take a TextBox screenshot with fileName {string}")
    public void iTakeATextBoxScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @Then("I check the TextBox {string} is displayed as {string}")
    public void iCheckTheTextBoxIsDisplayedAs(String textBoxId, String classCss) {
        WebElement textBox = driver.findElement(
            By.id(textBoxId));

        String classAttribute = textBox.getAttribute(
            "class");

        assertTrue(classAttribute.contains(classCss));
    }

    @Then("I fill the TextBox {string} with text {string}")
    public void iFillTheTextBoxWithText(String textBoxId, String text) {
        driver.findElement(
            By.id(textBoxId))
            .sendKeys(text);
    }

    @Then("I clean the TexBox {string}")
    public void iCleanTheTexBox(String textBoxId) {
        driver.findElement(
            By.id(textBoxId))
            .clear();
    }

    @Then("I should not see the TextBox results box empty")
    public void iShouldNotSeeTheTextBoxResultsBoxEmpty() {
        WebElement boxResults = driver.findElement(
            By.id("output"));

        int resultElements = boxResults
            .findElements(By.tagName("p"))
            .size();

        assertEquals(0, resultElements);
    }

    @Then("I should see the TextBox results box with:")
    public void iShouldSeeTheTextBoxResultsBoxWith(Map<String, String> mapValues) {
        WebElement boxResults = driver.findElement(
            By.id("output"));

        for (Map.Entry<String, String> entry: mapValues.entrySet()) {
            WebElement outputElement = boxResults.findElement(
                By.id(entry
                    .getKey()));

            assertTrue(outputElement
                .getText()
                .contains(entry
                    .getValue()));
        }
    }

    @When("I click the TextBox button Submit")
    public void iClickTheTextBoxButtonSubmit() {
        driver.findElement(
            By.id("submit"))
            .click();
    }

    @And("I let the TextBox webpage open")
    public void iLetTheTextBoxWebpageOpen() {
        assertNotNull(driver);

        TestUtils.SaveWebDriver(driver);
        assertNotNull(TestUtils.GetSavedWebDriver());
    }

    @Given("The previous TextBox webpage opened")
    public void thePreviousTextBoxWebpageOpened() {
        assertNull(driver);

        driver = TestUtils.GetSavedWebDriver();
        assertNotNull(driver);
    }

    @And("I quit the TextBox webpage")
    public void iQuitTheTextBoxWebpage() {
        driver.quit();
    }
}
