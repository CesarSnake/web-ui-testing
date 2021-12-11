package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import stepDefinitions.utils.TestUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TextBoxStepDefinitions {
    @Before("@TextBox")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
    }

    @Before("@TextBoxInvalidMail or @TextBoxValidMail")
    public void before() {
        TestUtils.InitializeAndSetWebDriver();
    }

    @Given("I go to the elements webpage {string}")
    public void iGoToTheElementsWebpage(String element) {
        TestUtils.GetWebDriver()
            .get("https://demoqa.com/" + element);
    }

    @Then("I check the textBox {string} is empty")
    public void iCheckTheTextBoxIsEmpty(String textBoxId) {
        WebElement textBox = TestUtils.GetWebDriver()
            .findElement(
                By.id(textBoxId));

        assertTrue(textBox
            .getText()
            .isEmpty());
    }

    @And("I check the textBox {string} is filled with {string}")
    public void iCheckTheTextBoxIsFilledWith(String inputId, String value) {
        String displayedValue = TestUtils.GetWebDriver()
            .findElement(
                By.id(inputId))
            .getAttribute("value");

        assertEquals(value, displayedValue);
    }

    @Then("I check the textBox {string} is displayed as {string}")
    public void iCheckTheTextBoxIsDisplayedAs(String textBoxId, String classCss) {
        WebElement textBox = TestUtils.GetWebDriver()
            .findElement(
                By.id(textBoxId));

        String classAttribute = textBox.getAttribute(
            "class");

        assertTrue(classAttribute.contains(classCss));
    }

    @Then("I fill the textBox {string} with the text {string}")
    public void iFillTheTextBoxWithTheText(String textBoxId, String text) {
        TestUtils.GetWebDriver()
            .findElement(
                By.id(textBoxId))
            .sendKeys(text);
    }

    @Then("I clean the texBox {string}")
    public void iCleanTheTexBox(String textBoxId) {
        TestUtils.GetWebDriver()
            .findElement(
                By.id(textBoxId))
            .clear();
    }

    @Then("I should not see the textBox results box empty")
    public void iShouldNotSeeTheTextBoxResultsBoxEmpty() {
        WebElement boxResults = TestUtils.GetWebDriver()
            .findElement(
                By.id("output"));

        int resultElements = boxResults
            .findElements(
                By.tagName("p"))
            .size();

        assertEquals(0, resultElements);
    }

    @Then("I should see the textBox results box with:")
    public void iShouldSeeTheTextBoxResultsBoxWith(Map<String, String> mapValues) {
        WebElement boxResults = TestUtils.GetWebDriver()
            .findElement(
                By.id("output"));

        for (Map.Entry<String, String> entry: mapValues.entrySet()) {
            WebElement outputElement = boxResults.findElement(
                By.id(entry.getKey()));

            assertTrue(outputElement
                .getText()
                .contains(entry.getValue()));
        }
    }

    @And("I let the elements webpage open")
    public void iLetTheElementsWebpageOpen() {
        // this step leave the webpage open, we must check it is not closed
        assertNotNull(TestUtils.GetWebDriver());
    }

    @Given("The previous elements webpage opened")
    public void thePreviousElementsWebpageOpened() {
        // this step expects the page is opened, we must check it was not closed
        assertNotNull(TestUtils.GetWebDriver());
    }

    @And("I take an elements screenshot with fileName {string}")
    public void iTakeAnElementsScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(fileName);
    }

    @And("I quit the elements webpage")
    public void iQuitTheElementsWebpage() {
        TestUtils.GetWebDriver()
            .quit();
    }
}
