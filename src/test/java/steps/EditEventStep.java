package steps;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditEventStep extends BaseUtil{

    protected BaseUtil base;

    public EditEventStep(base.BaseUtil base){
        this.base = base;
    }

    @Then("^event preview should be displayed$")
    public void eventPreviewShouldBeDisplayed(){
        base.wait.until(ExpectedConditions.elementToBeClickable(base.preview.editButton));
        base.preview.editButtonIsDisplayedOnPreviewPage();
    }

    @When("^I click on the Edit button on event preview page$")
    public void iClickOnTheEditButtonOnEventPreviewPage() {
        base.preview.clickOnEditButton();
    }

    @When("^I type \"([^\"]*)\" location to the selected event$")
    public void iAddLocationToTheSelectedEvent(String location) throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.whereInputField));
        base.create.addLocation(location);
        Thread.sleep(5000);
    }

    @And("^\"([^\"]*)\" location should be displayed in the preview pane$")
    public void shouldBeDisplayedInThePreviewPane(String location) {
        base.preview.locationIsDisplayedOnPreviewPage(location);
    }

    @And("^I type \"([^\"]*)\" description to the selected event$")
    public void iTypeDescriptionToTheSelectedEvent(String description) throws InterruptedException {
        //base.wait.until(ExpectedConditions.elementToBeClickable(base.create.descriptionField));
        base.create.addDescription(description);
    }

    @And("^\"([^\"]*)\" description should be displayed in the preview pane$")
    public void descriptionShouldBeDisplayedInThePreviewPane(String description) throws Throwable {
        base.preview.descriptionIsDisplayedInPreviewPage(description);
    }
}
