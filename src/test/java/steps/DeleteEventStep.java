package steps;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteEventStep extends BaseUtil {

    protected BaseUtil base;

    public DeleteEventStep(BaseUtil base) {
        this.base = base;
    }

    @When("^I click on delete event icon button$")
    public void iClickOnDeleteEventIconButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.preview.deleteButton));
        base.preview.clickOnDeleteButton();
    }

    @Then("^\"([^\"]*)\" event should not appear on search result page$")
    public void eventShouldNotAppearOnSearchResultPage(String name) {
        base.searchResult.eventIsDisplayedOnSearchResultList(name);
    }


}
