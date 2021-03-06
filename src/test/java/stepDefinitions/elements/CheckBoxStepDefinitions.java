package stepDefinitions.elements;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import stepDefinitions.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CheckBoxStepDefinitions {
    @Before("@CheckBox")
    public void before(Scenario scenario) {
        TestUtils.SetScenario(scenario);
    }

    @Before("@CheckingCheckBox")
    public  void before() {
        TestUtils.InitializeAndSetWebDriver();
    }

    @Then("I check all checkboxes are collapsed")
    public void iCheckAllCheckboxesAreCollapsed() {
        WebElement nodeParent = TestUtils.GetWebDriver()
            .findElement(
                By.className("rct-node-parent"));

        String classAttributes = nodeParent.getAttribute(
            "class");

        assertTrue(classAttributes.contains(
            "rct-node-collapsed"));
    }

    @When("I click the checkBox button Expand all")
    public void iClickTheCheckBoxButtonExpandAll() {
        TestUtils.GetWebDriver()
            .findElement(
                By.className("rct-option-expand-all"))
            .click();
    }

    @When("I click the checkBox button Collapse all")
    public void iClickTheCheckBoxButtonCollapseAll() {
        TestUtils.GetWebDriver()
            .findElement(
                By.className("rct-option-collapse-all"))
            .click();
    }

    @Then("I check all checkBoxes are expanded")
    public void iCheckAllCheckBoxesAreExpanded() {
        WebElement nodeParent = TestUtils.GetWebDriver()
            .findElement(
                By.className("rct-node-parent"));

        String classAttributes = nodeParent.getAttribute(
            "class");

        assertTrue(classAttributes.contains(
            "rct-node-expanded"));
    }

    @Then("I check all checkBoxes are unselected")
    public void iCheckAllCheckBoxesAreUnselected() {
        // check the list of checkboxes
        List<WebElement> checkBoxesElements = TestUtils.GetWebDriver()
            .findElements(
                By.xpath("//label[starts-with(@for, 'tree-node-')]"));

        // get all the checkboxes
        List<WebElement> checkBoxesStatus = checkBoxesElements
            .stream()
            .map(webElement -> webElement.findElement(By.className("rct-icon")))
            .collect(Collectors.toList());

        // there are a total of 17 checkboxes on the page
        assertEquals(17, checkBoxesStatus.size());

        // check each checkbox is unchecked
        for (WebElement element: checkBoxesStatus) { // check each of them
            String classAttributes = element.getAttribute(
                "class");

            assertTrue(classAttributes.contains(
                "rct-icon-uncheck"));
        }
    }

    @Then("I check all checkBoxes are selected")
    public void iCheckAllCheckBoxesAreSelected() {
        // check the list of checkboxes
        List<WebElement> checkBoxesElements = TestUtils.GetWebDriver()
            .findElements(
                By.xpath("//label[starts-with(@for, 'tree-node-')]"));

        // get all the checkboxes
        List<WebElement> checkBoxesStatus = checkBoxesElements
            .stream()
            .map(webElement -> webElement.findElement(
                By.className("rct-icon")))
            .collect(Collectors.toList());

        // there are a total of 17 checkboxes on the page
        assertEquals(17, checkBoxesStatus.size());

        // check each checkbox is unchecked
        for (WebElement element: checkBoxesStatus) { // check each of them
            String classAttributes = element.getAttribute(
                "class");

            assertTrue(classAttributes.contains(
                "rct-icon-check"));
        }
    }

    @When("I click the checkBox {string}")
    public void iClickTheCheckBox(String checkBoxId) {
        WebElement checkBoxElement = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//label[@for='" + checkBoxId + "']"));

        checkBoxElement.findElement(
                By.className("rct-checkbox"))
            .click();
    }

    @Then("I check the checkBox {string} is {string}")
    public void iCheckTheCheckBoxIs(String checkBoxId, String cssClass) {
        WebElement checkBoxElement = TestUtils.GetWebDriver()
            .findElement(
                By.xpath("//label[@for='" + checkBoxId + "']"));

        WebElement checkBox = checkBoxElement.findElement(
            By.className("rct-icon"));

        String classAttributes = checkBox.getAttribute(
            "class");

        assertTrue(classAttributes.contains(
                cssClass));
    }

    @Then("I check that the checkBox result box contains:")
    public void iCheckThatTheCheckBoxResultBoxContains(List<String> selectedCheckboxes) {
        // get the result container
        WebElement resultElement = TestUtils.GetWebDriver()
            .findElement(
                By.id("result"));

        // all elements selected are displayed as span -> <span class="text-success">notes</span>
        List<WebElement> resultSelectedElements = resultElement.findElements(
            By.tagName("span"));

        ArrayList<String> resultSelectedValues = new ArrayList<>();
        for (WebElement webElement : resultSelectedElements) {
            resultSelectedValues.add(webElement.getText());
        }

        // the first element of the container's list is <span>You have selected :</span>
        // so the size must be equals as the list provided + 1
        assertTrue(resultSelectedValues.contains("You have selected :"));
        assertEquals(selectedCheckboxes.size() + 1, resultSelectedElements.size());

        for (String selected: selectedCheckboxes) {
            boolean isElementDisplayed = resultSelectedValues
                .stream()
                .anyMatch(selectedValue -> selectedValue.equals(selected));

            assertTrue(isElementDisplayed);
        }
    }
}
