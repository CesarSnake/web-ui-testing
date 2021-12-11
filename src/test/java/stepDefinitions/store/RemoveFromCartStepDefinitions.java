package stepDefinitions.store;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import stepDefinitions.utils.TestHelper;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveFromCartStepDefinitions {
    @Before("@RemoveFromCart")
    public void before(Scenario scenario) {
        TestHelper.SetScenario(scenario);
        TestHelper.InitializeAndSetWebDriver();
    }

    @Then("I check the cart icon does not display a badge")
    public void iCheckTheCartIconDoesNotDisplayABadge() {
        boolean found = true;
        try {
            TestHelper.GetWebDriver()
                .findElement(
                        By.className("shopping_cart_badge"));
        } catch (NoSuchElementException ignored) {
            found = false;
        } finally {
            assertFalse(found);
        }
    }
}
