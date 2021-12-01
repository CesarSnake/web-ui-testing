package stepDefinitions.elements;

import io.cucumber.java.After;
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
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicPropertiesStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@DynamicProperties")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @After("@DynamicProperties")
    public void after() {
        driver.quit();
    }

    @Given("I go to dynamic properties webpage {string}")
    public void iGoToDynamicPropertiesWebpage(String webpage) {
        driver.get(webpage);
    }

    @Then("I check the dynamic page displays button named {string}")
    public void iCheckTheDynamicPageDisplaysButtonNamed(String displayButtonName) {
        WebElement buttonDisabled = driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));

        assertNotNull(buttonDisabled);
        assertEquals("button", buttonDisabled.getAttribute("type"));
    }

    @Then("I check the dynamic page button with text {string} is disabled")
    public void iCheckTheDynamicPageButtonWithTextIsDisabled(String displayButtonName) {
        WebElement buttonDisabled = driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));
        assertEquals("enableAfter", buttonDisabled.getAttribute("id"));
        assertEquals("button", buttonDisabled.getAttribute("type"));
        assertNotNull(buttonDisabled.getAttribute("disabled"));
    }

    @Then("I check the dynamic page button with text {string} has not color")
    public void iCheckTheDynamicPageButtonWithTextHasNotColor(String displayButtonName) {
        WebElement buttonColor = driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));
        assertEquals("colorChange", buttonColor.getAttribute("id"));
        assertEquals("button", buttonColor.getAttribute("type"));
        assertFalse(buttonColor
            .getAttribute("class")
            .contains("text-danger"));
    }

    @Then("I check the dynamic page button with text {string} is not displayed")
    public void iCheckTheDynamicPageButtonWithTextIsNotDisplayed(String displayButtonName) {
        boolean found = true;
        try {
            driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));
        } catch (NoSuchElementException ignored) {
            found = false;
        }

        assertFalse(found);
    }

    @When("I wait a {string} seconds in dynamic page")
    public void iWaitASecondsInDynamicPage(String seconds) {
        TestUtils.Wait(seconds);
    }

    @Then("I check the dynamic page button with text {string} is enabled")
    public void iCheckTheDynamicPageButtonWithTextIsEnabled(String displayButtonName) {
        WebElement buttonEnabled = driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));
        assertEquals("enableAfter", buttonEnabled.getAttribute("id"));
        assertEquals("button", buttonEnabled.getAttribute("type"));
        assertNull(buttonEnabled.getAttribute("disabled"));
    }

    @Then("I check the dynamic page button with text {string} has changed the color to red")
    public void iCheckTheDynamicPageButtonWithTextHasChangedTheColorToRed(String displayButtonName) {
        WebElement buttonColor = driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));
        assertEquals("colorChange", buttonColor.getAttribute("id"));
        assertEquals("button", buttonColor.getAttribute("type"));
        assertTrue(buttonColor
                .getAttribute("class")
                .contains("text-danger"));
    }

    @Then("I check the dynamic page button with text {string} is displayed")
    public void iCheckTheDynamicPageButtonWithTextIsDisplayed(String displayButtonName) {
        WebElement buttonVisible = driver.findElement(By.xpath("//button[text()='" + displayButtonName + "']"));
        assertEquals("button", buttonVisible.getAttribute("type"));
        assertNotNull(buttonVisible);
    }

    @Then("I take a dynamic properties page screenshot with fileName {string}")
    public void iTakeADynamicPropertiesPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Dynamic Properties webpage")
    public void iCloseTheDynamicPropertiesWebpage() {
        driver.close();
    }
}
