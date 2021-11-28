package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxStepDefinitions {
    Scenario scenario;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        driver = TestUtils.GetChromeDriver();
    }

    @Given("I go to the Check Box webpage {string}")
    public void iGoToTheCheckBoxWebpage(String webPage) {
        driver.get(webPage);
    }

    @Then("I check all check boxes are collapsed")
    public void iCheckAllCheckBoxesAreCollapsed() {
        WebElement nodeParent = driver.findElement(By.className("rct-node-parent"));
        String classAttributes = nodeParent.getAttribute("class");

        Assertions.assertTrue(classAttributes.contains("rct-node-collapsed"));
    }

    @Then("I click the button {string}")
    public void iClickTheButton(String buttonClassName) {
        driver.findElement(By.className(buttonClassName))
            .click();
    }

    @And("I check all check boxes are expanded")
    public void iCheckAllCheckBoxesAreExpanded() {
        List<WebElement> checkBoxesElements = driver.findElements(By.xpath("//*[starts-with(@for, 'tree-node-')]"));
        List<WebElement> checkBoxesStatus = checkBoxesElements
            .stream()
            .map(webElement -> webElement.findElement(By.className("rct-icon")))
            .collect(Collectors.toList());

        for (WebElement element: checkBoxesStatus) { // check each of them
            String classAttributes = element.getAttribute("class");
            Assertions.assertTrue(classAttributes.contains("rct-icon-uncheck"));
        }
    }

    @And("I check all check boxes are unselected")
    public void iCheckAllCheckBoxesAreUnselected() {
        WebElement nodeParent = driver.findElement(By.className("rct-node-parent"));
        String classAttributes = nodeParent.getAttribute("class");

        Assertions.assertTrue(classAttributes.contains("rct-node-expanded"));
    }

    @Then("I click the check box {string}")
    public void iClickTheCheckBox(String checkBoxId) {
        WebElement checkBoxElement = driver.findElement(By.xpath("//*[contains(@for, '" + checkBoxId + "')]"));
        checkBoxElement.findElement(By.className("rct-checkbox"))
            .click();
    }

    @And("I check the check box {string} is {string}")
    public void iCheckTheCheckBoxIs(String checkBoxId, String checkBoxClass) {
        WebElement checkBoxElement = driver.findElement(By.xpath("//*[contains(@for, '" + checkBoxId + "')]"));
        WebElement checkBox = checkBoxElement.findElement(By.className("rct-icon"));
        String classAttributes = checkBox.getAttribute("class");

        Assertions.assertTrue(classAttributes.contains(checkBoxClass));
    }

    @And("I check that the result box contains:")
    public void iCheckThatTheResultBoxContains(List<String> selectedCheckboxes) {
        WebElement resultElement = driver.findElement(By.id("result"));
        List<WebElement> resultSelectedElements = resultElement.findElements(By.tagName("span"));

        ArrayList<String> resultSelectedValues = new ArrayList<>();
        for (WebElement webElement : resultSelectedElements) {
            String text = webElement.getText();
            resultSelectedValues.add(text);
        }

        Assertions.assertTrue(resultSelectedValues.contains("You have selected :"));

        for (String selected: selectedCheckboxes) {
            boolean check = resultSelectedValues
                .stream()
                .anyMatch(selectedValue -> selectedValue.equals(selected));

            Assertions.assertTrue(check);
        }
    }

    @Then("I take a screenshot with fileName {string}")
    public void iTakeAScreenshotWithFileName(String fileName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", fileName);
    }

    @And("I close the CheckBox webpage")
    public void iCloseTheCheckBoxWebpage() {
        driver.close();
    }


}
