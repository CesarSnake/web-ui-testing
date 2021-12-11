package stepDefinitions.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class TestHelper {
    private static WebDriver webDriver;
    private static Scenario scenario;

    private TestHelper() {}

    public static void InitializeAndSetWebDriver() {
        webDriver = TestUtils.GetChromeDriver();
    }

    public static WebDriver GetWebDriver() {
        return webDriver;
    }

    public static void SetScenario(Scenario s) {
        scenario = s;
    }

    public static Scenario Scenario() {
        return scenario;
    }
}
