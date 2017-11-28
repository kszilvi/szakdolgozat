package steps;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainStep extends BaseUtil{

    protected BaseUtil base;

    public MainStep(BaseUtil base){
        this.base = base;
    }

    @Then("^I should see the Calendar button$")
    public void iShouldSeeTheNaptarButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.calendarButton));
        base.main.calendarButtonIsDisplayed();
    }

    @When("^I click on Create button$")
    public void iClickOnCreateButton() throws Throwable {
        base.main.clickOnCtreateButton();
    }
}
