package stepDefinitions.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinksStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before("@Links")
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @After("@Links")
    public void after() {
        driver.quit();
    }

    @Given("I go to Links web page {string}")
    public void iGoToLinksWebPage(String webpage) {
        driver.get(webpage);
    }

    @When("I click the link {string}")
    public void iClickTheLink(String linkId) {
        driver.findElement(By.id(linkId))
            .click();

        // Wait to load the webpage
        TestUtils.Wait("1");
    }

    @Then("I check the web page {string} has opened in a new tab")
    public void iCheckTheWebPageHasOpenedInANewTab(String webUrl) {
        // Get current page
        String currentPageHandle = driver.getWindowHandle();

        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<>(driver.getWindowHandles());

        // Move opened tab
        driver.switchTo().window(tabHandles.get(1));

        // Check new page was opened
        assertEquals(webUrl, driver.getCurrentUrl());

        // Close the tab
        driver.close();

        // Switch focus to main tab
        driver.switchTo().window(currentPageHandle);
    }

    @Then("I check the response was with status {string} and status text {string}")
    public void iCheckTheResponseWasWithStatusAndStatusText(String status, String statusText) {
        WebElement response = driver.findElement(By.id("linkResponse"));
        List<WebElement> responseResult = response.findElements(By.tagName("b"));

        assertEquals(status, responseResult.get(0).getText());
        assertEquals(statusText, responseResult.get(1).getText());
    }

    @And("I take a Links page screenshot with fileName {string}")
    public void iTakeALinksPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Links webpage")
    public void iCloseTheLinksWebpage() {
        driver.close();
    }
}