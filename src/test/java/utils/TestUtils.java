package utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestUtils {
    private static boolean isChromeDriverInstalled = false;
    
    public static WebDriver GetChromeDriver() {
        InstallChromeDriver();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=1280,1080");
        
        return new ChromeDriver(options);
    }

    public static void TakeScreenshot(WebDriver driver, Scenario scenario, String fileName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", fileName);
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
