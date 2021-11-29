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
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

public class LinksStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to Links web page {string}")
    public void iGoToLinksWebPage(String webpage) {
        driver.get(webpage);
    }

    @Then("I click the link {string}")
    public void iClickTheLink(String linkId) {
        driver.findElement(By.id(linkId))
            .click();
    }

    @And("I check the web page {string} has opened in a new tab")
    public void iCheckTheWebPageHasOpenedInANewTab(String webUrl) {
        // Get current page
        String currentPageHandle = driver.getWindowHandle();

        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<>(driver.getWindowHandles());

        // Move opened tab
        driver.switchTo().window(tabHandles.get(1));

        // Check new page was opened
        Assertions.assertEquals(webUrl, driver.getCurrentUrl());

        // Close the tab
        driver.close();

        // Switch focus to main tab
        driver.switchTo().window(currentPageHandle);
    }

    @And("I check the response was with status {string} and status text {string}")
    public void iCheckTheResponseWasWithStatusAndStatusText(String status, String statusText) {
        WebElement response = driver.findElement(By.id("linkResponse"));
        List<WebElement> responseResult = response.findElements(By.tagName("b"));

        Assertions.assertEquals(status, responseResult.get(0).getText());
        Assertions.assertEquals(statusText, responseResult.get(1).getText());
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