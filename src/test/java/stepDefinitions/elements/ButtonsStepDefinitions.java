package stepDefinitions.elements;

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
import org.openqa.selenium.interactions.Actions;
import utils.TestUtils;


import static org.junit.jupiter.api.Assertions.*;

public class ButtonsStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@Buttons")
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Before("@ButtonsDoubleClick")
    public void before() {
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to Buttons webpage")
    public void iGoToButtonsWebpage() {
        driver.get("https://demoqa.com/buttons");
    }

    @When("I click the Buttons webpage button {string}")
    public void iClickTheButtonsWebpageButton(String buttonId) {
        driver.findElement(
            By.id(buttonId))
            .click();
    }

    @Then("I check the Buttons webpage button has done nothing")
    public void iCheckTheButtonsWebpageButtonHasDoneNothing() {
        boolean doubleClickMessageFound = isMessageDisplayed("doubleClickMessage");
        boolean rightClickMessageFound = isMessageDisplayed("rightClickMessage");
        boolean dynamicClickMessageFound = isMessageDisplayed("dynamicClickMessage");

        assertFalse(doubleClickMessageFound);
        assertFalse(rightClickMessageFound);
        assertFalse(dynamicClickMessageFound);
    }

    @When("I do double click on the button {string}")
    public void iDoDoubleClickOnTheButton(String buttonId) {
        WebElement buttonElement = driver.findElement(
            By.id(buttonId));

        // do a double click
        Actions action = new Actions(driver);
        action.doubleClick(buttonElement)
            .perform();
    }

    @Then("I check double click button has clicked using double click")
    public void iCheckDoubleClickButtonHasClickedUsingDoubleClick() {
        WebElement doubleClickResult = driver.findElement(
            By.id("doubleClickMessage"));

        assertEquals("You have done a double click", doubleClickResult.getText());
    }

    @When("I do right click on the button {string}")
    public void iDoRightClickOnTheButton(String buttonId) {
        WebElement buttonElement = driver.findElement(
            By.id(buttonId));

        // do a right click
        Actions action = new Actions(driver);
        action.contextClick(buttonElement)
            .perform();
    }

    @Then("I check right click button has clicked using right click")
    public void iCheckRightClickButtonHasClickedUsingRightClick() {
        WebElement rightClickResult = driver.findElement(
            By.id("rightClickMessage"));

        assertEquals("You have done a right click", rightClickResult.getText());
    }

    @When("I do a regular click on the dynamic button")
    public void iDoARegularClickOnTheDynamicButton() {
        WebElement dynamicButton = driver.findElement(
            By.xpath("//button[text()='Click Me']"));

        assertNotNull(dynamicButton);
        assertEquals("button", dynamicButton.getAttribute("type"));
        assertNotEquals("doubleClickBtn", dynamicButton.getAttribute("id"));
        assertNotEquals("rightClickBtn", dynamicButton.getAttribute("id"));

        dynamicButton.click();
    }

    @Then("I check dynamic button has been clicked")
    public void iCheckDynamicButtonHasBeenClicked() {
        WebElement rightClickResult = driver.findElement(
            By.id("dynamicClickMessage"));

        assertEquals("You have done a dynamic click", rightClickResult.getText());
    }

    @Then("I take a buttons page screenshot with fileName {string}")
    public void iTakeAButtonsPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I let the Buttons webpage open")
    public void iLetTheButtonsWebpageOpen() {
        assertNotNull(driver);

        TestUtils.SaveWebDriver(driver);
        assertNotNull(TestUtils.GetSavedWebDriver());
    }

    @Given("The previous Buttons webpage opened")
    public void thePreviousButtonsWebpageOpened() {
        assertNull(driver);

        driver = TestUtils.GetSavedWebDriver();
        assertNotNull(driver);
    }

    @And("I quit the Buttons webpage")
    public void iQuitTheButtonsWebpage() {
        driver.quit();
    }

    private boolean isMessageDisplayed(String messageId)  {
        boolean messageFound = true;
        try {
            driver.findElement(By.id(messageId));
        } catch (NoSuchElementException ignored) {
            messageFound = false;
        }

        return messageFound;
    }
}
