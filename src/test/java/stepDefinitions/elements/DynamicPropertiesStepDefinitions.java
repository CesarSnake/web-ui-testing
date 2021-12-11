package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicPropertiesStepDefinitions {
    @Before("@DynamicProperties")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @Then("I check the button named {string} is displayed")
    public void iCheckTheButtonNamedIsDisplayed(String displayButtonName) {
        WebElement buttonDisabled = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + displayButtonName + "']"));

        assertNotNull(buttonDisabled);
        assertEquals("button", buttonDisabled.getAttribute("type"));
    }

    @Then("I check the button named {string} is disabled")
    public void iCheckTheButtonNamedIsDisabled(String displayButtonName) {
        WebElement buttonDisabled = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + displayButtonName + "']"));

        assertEquals("button", buttonDisabled.getAttribute("type"));
        assertNotNull(buttonDisabled.getAttribute("disabled"));
    }

    @Then("I check the button named {string} has not color")
    public void iCheckTheButtonNamedHasNotColor(String displayButtonName) {
        WebElement buttonColor = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + displayButtonName + "']"));

        assertEquals("colorChange", buttonColor.getAttribute("id"));
        assertEquals("button", buttonColor.getAttribute("type"));
        assertFalse(buttonColor
            .getAttribute("class")
            .contains("text-danger"));
    }

    @Then("I check the button named {string} is not displayed")
    public void iCheckTheButtonNamedIsNotDisplayed(String displayButtonName) {
        boolean found = true;
        try {
            TestUtils.GetWebDriver()
                .findElement(
                    By.xpath("//button[text()='" + displayButtonName + "']"));
        } catch (NoSuchElementException ignored) {
            found = false;
        } finally {
            assertFalse(found);
        }
    }

    @Then("I check the button named {string} is enabled")
    public void iCheckTheButtonNamedIsEnabled(String displayButtonName) {
        WebElement buttonEnabled = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + displayButtonName + "']"));

        assertEquals("button", buttonEnabled.getAttribute("type"));
        assertNull(buttonEnabled.getAttribute("disabled"));
    }

    @Then("I check the button named {string} has changed the color to red")
    public void iCheckTheButtonNamedHasChangedTheColorToRed(String displayButtonName) {
        WebElement buttonColor = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//button[text()='" + displayButtonName + "']"));

        assertEquals("button", buttonColor.getAttribute("type"));
        assertTrue(buttonColor
            .getAttribute("class")
            .contains("text-danger"));
    }
}
