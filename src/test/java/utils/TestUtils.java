package utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class TestUtils {
    private static boolean isChromeDriverInstalled = false;
    private static WebDriver savedWebDriver = null;

    public static ChromeDriver GetChromeDriver() {
        InstallChromeDriver();

        return new ChromeDriver(GetChromeOptions());
    }

    public static ChromeDriver GetChromeDriver(String downloadDirectoryPath) {
        InstallChromeDriver();

        // it uses the chrome driver with a custom download directory path provided
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadDirectoryPath);

        ChromeOptions options = GetChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    public static void TakeScreenshot(WebDriver driver, Scenario scenario, String fileName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", fileName);
    }

    public static void Wait(String seconds) {
        try {
            TimeUnit.SECONDS.sleep(Integer.parseInt(seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void SaveWebDriver(WebDriver webDriver) {
        savedWebDriver = webDriver;
    }

    public static WebDriver GetSavedWebDriver() {
        if (savedWebDriver == null) {
            throw new NullPointerException("The web driver was not saving previously using the method 'SaveWebDriver'");
        }

        return savedWebDriver;
    }

    private static ChromeOptions GetChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        return options;
    }

    private static void InstallChromeDriver() {
        // it is only needed to install the ChromeDriver once
        if (isChromeDriverInstalled) {
            System.out.println("INFO: Chrome Driver was installed, skip");
            return;
        }

        // install chromedriver
        System.out.println("INFO: Installing Chrome Driver...");
        WebDriverManager.chromedriver().setup();
        isChromeDriverInstalled = true;
    }
}
