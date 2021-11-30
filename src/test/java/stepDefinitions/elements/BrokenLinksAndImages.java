package stepDefinitions.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokenLinksAndImages {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("I go to the broken links and images web page {string}")
    public void iGoToTheBrokenLinksAndImagesWebPage(String webpage) {
        driver.get(webpage);
    }

    @Then("I check valid image is displayed")
    public void iCheckValidImageIsDisplayed() {
        // the elements to test are inside a col of the row area
        WebElement workingElement = driver.findElement(By.className("col-md-6"));

        // the valid image is the first one
        WebElement imageElement = workingElement.findElements(By.tagName("img"))
                .get(0);

        assertEquals("https://demoqa.com/images/Toolsqa.jpg", imageElement.getAttribute("src"));
        assertEquals(347, imageElement.getSize().width);
        assertEquals(100, imageElement.getSize().height);
    }

    @Then("I check a broken image is not displayed")
    public void iCheckABrokenImageIsNotDisplayed() {
        // the elements to test are inside a col of the row area
        WebElement workingElement = driver.findElement(By.className("col-md-6"));

        // the invalid image is the second one
        WebElement imageElement = workingElement.findElements(By.tagName("img"))
            .get(1);

        assertEquals("https://demoqa.com/images/Toolsqa_1.jpg", imageElement.getAttribute("src"));

        // when an image is not displayed, the engine shows a broken symbol of 16x16
        assertEquals(16, imageElement.getSize().width);
        assertEquals(16, imageElement.getSize().height);
    }


    @Then("I click the valid link")
    public void iClickTheValidLink() {
        // the elements to test are inside a col of the row area
        WebElement workingElement = driver.findElement(By.className("col-md-6"));

        WebElement linkElement = workingElement.findElement(By.linkText("Click Here for Valid Link"));
        assertEquals("http://demoqa.com/", linkElement.getAttribute("href"));
        linkElement.click();
    }


    @And("I check the web page has changed to {string}")
    public void iCheckTheWebPageHasChangedTo(String newWebPage) {
        assertEquals(newWebPage, driver.getCurrentUrl());
    }

    @Then("I click the broken link")
    public void iClickTheBrokenLink() {
        // the elements to test are inside a col of the row area
        WebElement workingElement = driver.findElement(By.className("col-md-6"));

        WebElement linkElement = workingElement.findElement(By.linkText("Click Here for Broken Link"));
        assertEquals("http://the-internet.herokuapp.com/status_codes/500", linkElement.getAttribute("href"));
        linkElement.click();
    }

    @And("I take a broken page screenshot with fileName {string}")
    public void iTakeABrokenPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Broken webpage")
    public void iCloseTheBrokenWebpage() {
        driver.close();
    }
}
