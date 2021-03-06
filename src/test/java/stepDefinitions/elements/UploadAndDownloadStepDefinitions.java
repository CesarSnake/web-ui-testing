package stepDefinitions.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.utils.TestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class UploadAndDownloadStepDefinitions {
    Path workingDirectoryPath;

    @Before("@UploadAndDownload")
    public void before(Scenario scenario) throws IOException {
        workingDirectoryPath = Paths.get(System.getProperty("user.dir"), "target", "downloads");

        // Create download directory
        Files.createDirectory(workingDirectoryPath);

        // use chrome driver with download folder localized
        TestUtils.SetScenario(scenario);
        TestUtils.InitializeAndSetWebDriver(workingDirectoryPath.toString());
    }

    @After("@UploadAndDownload")
    public void after() throws IOException {
        // Clean download folder
        Files.walk(workingDirectoryPath)
            .map(Path::toFile)
            .forEach(File::delete);

        Files.deleteIfExists(workingDirectoryPath);
    }

    @Then("I check it has download the file {string}")
    public void iCheckItHasDownloadTheFile(String fileName) {
        Path downloadFilePath = Paths.get(workingDirectoryPath.toString(), fileName);
        assertTrue(Files.exists(downloadFilePath));
    }

    @And("I wait a {string} seconds")
    public void iWaitASeconds(String seconds) {
        TestUtils.Wait(seconds);
    }

    @When("I upload a file using the upload-download input {string}")
    public void iUploadAFileUsingTheUploadDownloadInput(String inputId) throws IOException {
        // create a random file
        Path filePath = Paths.get(workingDirectoryPath.toString(), "testFile.txt");
        Files.createFile(filePath);

        assertTrue(Files.exists(filePath));

        // upload the file
        TestUtils.GetWebDriver()
            .findElement(
                By.id(inputId))
            .sendKeys(filePath.toString());
    }

    @Then("I check the file has uploaded")
    public void iCheckTheFileHasUploaded() {
        WebElement check = TestUtils.GetWebDriver()
            .findElement(
                By.id("uploadedFilePath"));

        assertEquals("C:\\fakepath\\testFile.txt", check.getText());
    }
}