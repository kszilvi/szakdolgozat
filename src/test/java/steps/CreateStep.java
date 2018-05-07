package steps;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CreateStep extends BaseUtil {

    private BaseUtil base;

    public CreateStep(BaseUtil base) {
        this.base = base;
    }

    @Then("^the creating event page should be displayed$")
    public void theCreatingNewEventPageShouldBeDisplayed() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox));
    }

    @Then("^I should see the Create Event button$")
    public void iShouldSeeTheCreateEventButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.createButton));
        base.main.createEventIsDisplayed();
    }

    @And("^I add \"([^\"]*)\" to from date field$")
    public void iAddToFromDateField(String fromDate) {
        base.create.addStartDate(fromDate);
    }

    @And("^I add \"([^\"]*)\" and \"([^\"]*)\" to from time field$")
    public void iAddToFromTimeField(String fromTime, String fromUnit) {
        base.create.addFromTime(fromTime + fromUnit);
    }

    @And("^I add \"([^\"]*)\" to until date field$")
    public void iAddToUntilDateField(String untilDate) {
        base.create.addUntilDate(untilDate);
    }

    @And("^I add \"([^\"]*)\" and \"([^\"]*)\" to until time field$")
    public void iAddToUntilTimeField(String untilTime, String untilUnit) {
        base.create.addUntilTime(untilTime + untilUnit);
    }

    @When("^I type \"([^\"]*)\" to title field$")
    public void iTypeToTitleField(String title) throws InterruptedException {
        base.create.addNameToEvent(title);
    }

    @And("^I click on Edit button$")
    public void iClickOnEditButton() {
        base.preview.clickOnEditButton();
    }

    @And("^I click on the name of the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" event$")
    public void iClickOnTheNameOfTheEvent(String arg0, String arg1, String arg2) throws Throwable {
        if (base.main.isAllDayEventInCalendar(arg0)) {
            base.main.goToParticularEventPage(arg0 + "\n" + ", " + "\n" + arg1);
        }
        base.main.goToParticularEventPage(arg0);
    }

    @And("^I click on the Save button$")
    public void iClickOnTheSaveButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.saveButton));
        base.create.saveEvent();
    }

    @And("^message should appear with the following text: \"([^\"]*)\"$")
    public void messageShouldAppearWithTheFollowingText(String message) throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.message));
        base.main.isMessageMatch(message);
    }

    @Then("^search result page should be displayed$")
    public void searchResultPageShouldBeDisplayed() {
        base.searchResult.searchResulPageIsDisplayed();
    }

    @And("^I check the All day check box$")
    public void iCheckTheAllDayCheckBox() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.allDayCheckBox));
        base.create.checkAllDayCheckBox();
    }

    @And("^created \"([^\"]*)\" event should be displayed in the search result list from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void createdEventShouldBeDisplayedInTheSearchResultListFromTo(String eventName, String fromDate, String untilDate) {
        Assert.assertEquals((base.searchResult.datesWithCreatedName2(eventName)), base.searchResult.getDatesBetween(base.helper.dateConverterFromStringToLocalDate(fromDate),
                base.helper.dateConverterFromStringToLocalDate(untilDate)));
    }

    @And("^No results found should be displayed$")
    public void noResultsFoundShouldBeDisplayed() {
        base.searchResult.noResultsFoundIsDisplayed();
    }


}
