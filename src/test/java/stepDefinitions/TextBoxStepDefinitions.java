package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TextBoxStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Given("I go to Text Box webpage {string}")
    public void iGoToTextBoxWebpage(String webPage) {
        driver.get(webPage);
    }

    @Then("I fill {string} text box element with text {string}")
    public void iFillTextBoxElementWithText(String textBoxId, String text) {
        driver.findElement(By.id(textBoxId)).sendKeys(text);
    }

    @And("I click {string} button")
    public void iClickButton(String buttonId) {
        driver.findElement(By.id(buttonId)).click();
    }

    @And("I take a screenshot with fileName {string}")
    public void iTakeAScreenshotWithFileName(String fileName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", fileName);
    }

    @And("I close the webpage")
    public void iCloseTheWebpage() {
        driver.close();
    }
}
