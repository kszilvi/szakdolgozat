package steps;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainStep extends BaseUtil {

    private BaseUtil base;

    public MainStep(BaseUtil base) {
        this.base = base;
    }

    @Then("^I should see the Calendar button$")
    public void iShouldSeeTheNaptarButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.calendarButton));
        base.main.calendarButtonIsDisplayed();
    }

    @When("^I click on Create button$")
    public void iClickOnCreateButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.createButton));
        base.main.clickOnCtreateButton();
    }

    @When("^I click on the Search icon$")
    public void iClickOnTheSearchIcon() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.searchButton));
        base.main.clickOnSearchButton();
    }



    @When("^I click on the search button$")
    public void iClickOnTheSearchButton() throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.searchButton2));
        base.main.clickOnSearchButton2();
    }
}
