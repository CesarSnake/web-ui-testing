package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import utils.TestUtils;

import java.util.Map;

public class TextBoxStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to Text Box webpage {string}")
    public void iGoToTextBoxWebpage(String webPage) {
        driver.get(webPage);
    }

    @Then("I fill {string} text box element with text {string}")
    public void iFillTextBoxElementWithText(String textBoxId, String text) {
        driver.findElement(By.id(textBoxId))
            .sendKeys(text);
    }

    @And("I check {string} text box element is displayed as {string}")
    public void iCheckTextBoxElementIsDisplayedAs(String textBoxId, String classCss) {
        WebElement webElement = driver.findElement(By.id(textBoxId));
        String classAttribute = webElement.getAttribute("class");
        Assertions.assertTrue(classAttribute.contains(classCss));
    }

    @And("I click {string} button")
    public void iClickButton(String buttonId) {
        driver.findElement(By.id(buttonId))
            .click();
    }

    @And("I check {string} text box element is displayed as error")
    public void iCheckTextBoxElementIsDisplayedAsError(String textBoxId) {
        WebElement element = driver.findElement(By.id(textBoxId));
        Assertions.assertTrue(element.getAttribute("class").contains("field-error"));

    }

    @And("I clean {string} text box element")
    public void iCleanTextBoxElement(String textBoxId) {
        driver.findElement(By.id(textBoxId))
            .clear();
    }

    @And("I take a screenshot with fileName {string}")
    public void iTakeAScreenshotWithFileName(String fileName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", fileName);
    }

    @And("I close the webpage")
    public void iCloseTheWebpage() {
        driver.close();
    }

    @And("I should see a {string} box with the following text:")
    public void iShouldSeeABoxWithTheFollowingText(String textBoxId, Map<String, String> mapValues) {
        WebElement webElement = driver.findElement(By.id(textBoxId));

        for (Map.Entry<String, String> entry: mapValues.entrySet()) {
            WebElement outputElement = webElement.findElement(By.id(entry.getKey()));
            Assertions.assertTrue(outputElement.getText().contains(entry.getValue()));
        }
    }
}
