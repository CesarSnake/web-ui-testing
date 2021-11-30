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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UploadAndDownloadStepDefinitions {
    Scenario scenario;
    WebDriver driver;
    Path downloadPath;

    @Before
    public void before(Scenario scenario) throws IOException {
        this.scenario = scenario;

        // Creates download directory
        downloadPath = Paths.get(System.getProperty("user.dir"), "target", "downloads");
        Files.createDirectory(downloadPath);

        driver = TestUtils.GetChromeDriver(downloadPath.toString());
    }

    @After
    public void after() throws IOException {
        driver.quit();

        // Delete download folder
        Files.walk(downloadPath)
            .map(Path::toFile)
            .forEach(File::delete);

        Files.deleteIfExists(downloadPath); 
    }

    @Given("I go to Upload and Download webpage {string}")
    public void iGoToUploadAndDownloadWebpage(String webpage) {
        driver.get(webpage);
    }

    @Then("I click the upload-download webpage {string} button")
    public void iClickTheUploadDownloadWebpageButton(String buttonId) {
        driver.findElement(By.id(buttonId))
            .click();
    }

    @Then("I check it has download the file {string}")
    public void iCheckItHasDownloadTheFile(String fileName) {
        Path downloadFilePath = Paths.get(downloadPath.toString(), fileName);
        assertTrue(Files.exists(downloadFilePath));
    }

    @And("I wait a {string} seconds")
    public void iWaitASeconds(String seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(Integer.parseInt(seconds));
    }

    @Then("I upload a file using the upload-download input {string}")
    public void iUploadAFileUsingTheUploadDownloadInput(String inputId) throws IOException {
        // create a random file
        Path filePath = Paths.get(downloadPath.toString(), "testFile.txt");
        Files.createFile(filePath);

        assertTrue(Files.exists(filePath));

        // upload the file
        driver.findElement(By.id(inputId))
            .sendKeys(filePath.toString());
    }

    @Then("I check the file has uploaded")
    public void iCheckTheFileHasUploaded() {
        WebElement check = driver.findElement(By.id("uploadedFilePath"));
        assertEquals("C:\\fakepath\\testFile.txt", check.getText());
    }

    @And("I take a upload-download page screenshot with fileName {string}")
    public void iTakeAUploadDownloadPageScreenshotWithFileName(String fileName) {
        TestUtils.TakeScreenshot(driver, scenario, fileName);
    }

    @And("I close the Upload-Download webpage")
    public void iCloseTheUploadDownloadWebpage() {
        driver.close();
    }
}