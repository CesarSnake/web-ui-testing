package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokenLinksAndImagesStepDefinitions {
    @Before("@BrokenLinksAndImages")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver();
    }

    @Then("I check valid image is displayed")
    public void iCheckValidImageIsDisplayed() {
        // the elements to test are inside a col of the row area
        WebElement workingElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("col-md-6"));

        // the valid image is the first one
        WebElement imageElement = workingElement
            .findElements(
                By.tagName("img"))
            .get(0);

        assertEquals("https://demoqa.com/images/Toolsqa.jpg", imageElement
            .getAttribute("src"));

        assertEquals(347, imageElement
            .getSize()
            .width);

        assertEquals(100, imageElement
            .getSize()
            .height);
    }

    @Then("I check a broken image is not displayed")
    public void iCheckABrokenImageIsNotDisplayed() {
        // the elements to test are inside a col of the row area
        WebElement workingElement = TestUtils.GetWebDriver()
            .findElement(
                By.className("col-md-6"));

        // the invalid image is the second one
        WebElement imageElement = workingElement
            .findElements(
                By.tagName("img"))
            .get(1);

        assertEquals("https://demoqa.com/images/Toolsqa_1.jpg", imageElement
            .getAttribute("src"));

        // when an image is not displayed, the engine shows a broken symbol of 16x16
        assertEquals(16, imageElement
            .getSize()
            .width);

        assertEquals(16, imageElement
            .getSize()
            .height);
    }

    @Then("I check the web page has changed to {string}")
    public void iCheckTheWebPageHasChangedTo(String newWebPage) {
        String currentUrl = TestUtils.GetWebDriver()
            .getCurrentUrl();

        assertEquals(newWebPage, currentUrl);
    }
}
