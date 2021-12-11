package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepDefinitions.utils.TestUtils;


import static org.junit.jupiter.api.Assertions.*;

public class ButtonsStepDefinitions {
    @Before("@Buttons")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
    }

    @Before("@ButtonsDoubleClick")
    public void before() {
        TestUtils.InitializeAndSetWebDriver();
    }

    @When("I click the elements button {string}")
    public void iClickTheElementsButton(String buttonId) {
        TestUtils.GetWebDriver()
            .findElement(
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
        WebElement buttonElement = TestUtils.GetWebDriver()
            .findElement(
                By.id(buttonId));

        // do a double click
        Actions action = new Actions(TestUtils.GetWebDriver());
        action.doubleClick(buttonElement)
            .perform();
    }

    @Then("I check double click button has clicked using double click")
    public void iCheckDoubleClickButtonHasClickedUsingDoubleClick() {
        WebElement doubleClickResult = TestUtils.GetWebDriver()
            .findElement(
                By.id("doubleClickMessage"));

        assertEquals("You have done a double click", doubleClickResult.getText());
    }

    @When("I do right click on the button {string}")
    public void iDoRightClickOnTheButton(String buttonId) {
        WebElement buttonElement = TestUtils.GetWebDriver()
            .findElement(
                By.id(buttonId));

        // do a right click
        Actions action = new Actions(TestUtils.GetWebDriver());
        action.contextClick(buttonElement)
            .perform();
    }

    @Then("I check right click button has clicked using right click")
    public void iCheckRightClickButtonHasClickedUsingRightClick() {
        WebElement rightClickResult = TestUtils.GetWebDriver()
            .findElement(
                By.id("rightClickMessage"));

        assertEquals("You have done a right click", rightClickResult.getText());
    }

    @When("I click the elements button with displayText {string}")
    public void IClickTheElementsButtonWithDisplayText(String buttonText) {
        TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + buttonText + "']"))
            .click();
    }

    @Then("I check dynamic button has been clicked")
    public void iCheckDynamicButtonHasBeenClicked() {
        WebElement rightClickResult = TestUtils.GetWebDriver()
            .findElement(
                By.id("dynamicClickMessage"));

        assertEquals("You have done a dynamic click", rightClickResult.getText());
    }

    private boolean isMessageDisplayed(String messageId)  {
        boolean messageFound = true;
        try {
            TestUtils.GetWebDriver()
                .findElement(
                    By.id(messageId));
        } catch (NoSuchElementException ignored) {
            messageFound = false;
        }

        return messageFound;
    }
}
