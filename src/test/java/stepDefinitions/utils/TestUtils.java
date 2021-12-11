package stepDefinitions.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class TestUtils {
    private static boolean isChromeDriverInstalled = false;
    private static WebDriver webDriver = null;
    private static Scenario scenario = null;

    // TestUtils is a static class, default constructor it is not needed
    private TestUtils () {}

    // Helper methods to share the scenario and the webDriver between StepDefinitions
    public static void InitializeAndSetWebDriver() {
        webDriver = GetChromeDriver();
    }

    public static void InitializeAndSetWebDriver(String downloadDirectoryPath) {
        webDriver = GetChromeDriver(downloadDirectoryPath);
    }

    public static WebDriver GetWebDriver() {
        return webDriver;
    }

    public static void SetScenario(Scenario sc) {
        scenario = sc;
    }

    public static Scenario Scenario() {
        return scenario;
    }

    public static void TakeScreenshot(String fileName) {
        byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", fileName);
    }

    public static void Wait(String seconds) {
        try {
            TimeUnit.SECONDS.sleep(Integer.parseInt(seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // End Helper methods

    // Chrome webDriver
    private static ChromeDriver GetChromeDriver() {
        InstallChromeDriver();

        return new ChromeDriver(GetChromeOptions());
    }

    private static ChromeDriver GetChromeDriver(String downloadDirectoryPath) {
        InstallChromeDriver();

        // it uses the chrome driver with a custom download directory path provided
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadDirectoryPath);

        ChromeOptions options = GetChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    private static ChromeOptions GetChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
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
    // End chrome web driver
}
