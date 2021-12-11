package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class LinksStepDefinitions {
    @Before("@Links")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @When("I click the link with text {string}")
    public void iClickTheLinkWithText(String displayedText) {
        TestUtils.GetWebDriver()
            .findElement(
                By.linkText(displayedText))
            .click();

        // Wait a bit to load the webpage
        TestUtils.Wait("2");
    }

    @When("I click the dynamic link that contains {string}")
    public void iClickTheDynamicLinkThatContains(String partialDisplayedText) {
        // the dynamic link contains the "partialDisplayedText" but cannot be "partialDisplayedText" itself
        List<WebElement> linksList = TestUtils.GetWebDriver()
            .findElements(
                By.tagName("a"));

        List<WebElement> singleLinkInList = linksList
            .stream()
            .filter(webElement -> webElement
                .getText()
                .contains(partialDisplayedText))
            .filter(webElement -> {
                int linkSize = webElement.getText().length();
                return linkSize > partialDisplayedText.length();
            })
            .collect(Collectors.toList());

        assertEquals(1, singleLinkInList.size());
        singleLinkInList
            .get(0)
            .click();
    }

    @When("I click the link {string}")
    public void iClickTheLink(String linkId) {
        TestUtils.GetWebDriver()
            .findElement(
                By.id(linkId))
            .click();

        // Wait a bit to load the webpage
        TestUtils.Wait("2");
    }

    @Then("I check the web page {string} has opened in a new tab")
    public void iCheckTheWebPageHasOpenedInANewTab(String webUrl) {
        WebDriver driver = TestUtils.GetWebDriver();

        // Get current page
        String currentPageHandle = TestUtils.GetWebDriver()
            .getWindowHandle();

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
        WebElement linkResponse = TestUtils.GetWebDriver()
            .findElement(
                By.id("linkResponse"));

        /* linkResponse is an element with 2 child elements of type <b>: <p id="linkResponse"></p>
         * <p id="linkResponse">
         *   <b>404</b>
         *   some text
         *   <b>Not Found</b>
         * </p>
         */
        List<WebElement> responseResult = linkResponse.findElements(
            By.tagName("b"));

        assertEquals(status, responseResult.get(0)
            .getText());

        assertEquals(statusText, responseResult.get(1)
            .getText());
    }
}