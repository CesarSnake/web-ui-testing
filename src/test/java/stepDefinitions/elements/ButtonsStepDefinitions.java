package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestUtils;

import java.util.List;

public class ButtonsStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to Buttons web page {string}")
    public void iGoToButtonsWebPage(String webpage) {
        driver.get(webpage);
    }

    @Then("I do double click on the button {string}")
    public void iDoDoubleClickOnTheButton(String buttonId) {
        WebElement buttonElement = driver.findElement(By.id(buttonId));
        Actions action = new Actions(driver);

        action.doubleClick(buttonElement)
            .perform();
    }

    @And("I check double click button has clicked using double click")
    public void iCheckDoubleClickButtonHasClickedUsingDoubleClick() {
        WebElement doubleClickResult = driver.findElement(By.id("doubleClickMessage"));
        Assertions.assertEquals("You have done a double click", doubleClickResult.getText());
    }

    @Then("I do right click on the button {string}")
    public void iDoRightClickOnTheButton(String buttonId) {
        WebElement buttonElement = driver.findElement(By.id(buttonId));
        Actions action = new Actions(driver);

        action.contextClick(buttonElement)
            .perform();
    }

    @And("I check right click button has clicked using right click")
    public void iCheckRightClickButtonHasClickedUsingRightClick() {
        WebElement rightClickResult = driver.findElement(By.id("rightClickMessage"));
        Assertions.assertEquals("You have done a right click", rightClickResult.getText());
    }

    @Then("I do a regular click on the dynamic button")
    public void iDoARegularClickOnTheDynamicButton() {
        List<WebElement> buttonsList = driver.findElements(By.xpath("//button[contains(@type, 'button')]"));
        WebElement dynamicButton = null;

        // search the dynamic button, it has a random id like 'VQSqm'
        for (WebElement button: buttonsList) {
            String id = button.getAttribute("id");

            if (id.contains("Btn")) { // button with static id
               continue;
            }

            dynamicButton = button;
        }

        Assertions.assertNotNull(dynamicButton);
        dynamicButton.click();
    }

    @And("I check dynamic button has been clicked")
    public void iCheckDynamicButtonHasBeenClicked() {
        WebElement rightClickResult = driver.findElement(By.id("dynamicClickMessage"));
        Assertions.assertEquals("You have done a dynamic click", rightClickResult.getText());
    }

    @And("I take a buttons page screenshot with fileName {string}")
    public void iTakeAButtonsPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Buttons webpage")
    public void iCloseTheButtonsWebpage() {
        driver.close();
    }
}
