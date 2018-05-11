package steps;

import base.BaseUtil;
import cucumber.api.PendingException;
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

    String latestTimestamp;

    @Then("^the creating event page should be displayed$")
    public void theCreatingNewEventPageShouldBeDisplayed() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox));
    }

    @Then("^I should see the Create Event button$")
    public void iShouldSeeTheCreateEventButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.createButton));
        base.main.createEventIsDisplayed();
    }

    @When("^I add \"([^\"]*)\" to from date field$")
    public void iAddToFromDateField(String fromDate) {
        base.create.addStartDate(fromDate);
    }

    @When("^I add \"([^\"]*)\" and \"([^\"]*)\" to from time field$")
    public void iAddToFromTimeField(String fromTime, String fromUnit) {
        base.create.addFromTime(fromTime + fromUnit);
    }

    @When("^I add \"([^\"]*)\" to until date field$")
    public void iAddToUntilDateField(String untilDate) {
        base.create.addUntilDate(untilDate);
    }

    @When("^I add \"([^\"]*)\" and \"([^\"]*)\" to until time field$")
    public void iAddToUntilTimeField(String untilTime, String untilUnit) {
        base.create.addUntilTime(untilTime + untilUnit);
    }

    @When("^I type \"([^\"]*)\" to title field$")
    public void iTypeToTitleField(String title) {
        latestTimestamp = base.helper.getCurrentTimestampForDate2();
        base.create.addNameToEvent(title + " - " + latestTimestamp);
    }

    @And("^I click on Edit button$")
    public void iClickOnEditButton() {
        base.preview.clickOnEditButton();
    }

    @When("^I click on the Save button$")
    public void iClickOnTheSaveButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.saveButton));
        base.create.saveEvent();
    }

    @Then("^message should appear with the following text: \"([^\"]*)\"$")
    public void messageShouldAppearWithTheFollowingText(String message) {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.message));
        base.main.isMessageMatch(message);
    }

    @Then("^search result page should be displayed$")
    public void searchResultPageShouldBeDisplayed() {
        base.searchResult.searchResulPageIsDisplayed();
    }

    @When("^I check the All day check box$")
    public void iCheckTheAllDayCheckBox() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.allDayCheckBox));
        base.create.checkAllDayCheckBox();
    }

    @Then("^created \"([^\"]*)\" event should be displayed in the search result list from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void createdEventShouldBeDisplayedInTheSearchResultListFromTo(String eventName, String fromDate, String untilDate) {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.searchResult.eventContainer));
        Assert.assertEquals((base.searchResult.datesWithCreatedName2(eventName + " - " + latestTimestamp)), base.searchResult.getDatesBetween(base.helper.dateConverterFromStringToLocalDate(fromDate),
                base.helper.dateConverterFromStringToLocalDate(untilDate)));
    }

    @And("^No results found should be displayed$")
    public void noResultsFoundShouldBeDisplayed() {
        base.searchResult.noResultsFoundIsDisplayed();
    }

    @When("^I type the created \"([^\"]*)\" event to the search field$")
    public void iTypeTheCreatedEventToTheSearchField(String name) throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.searchField));
        base.main.typeToSearchField(name + " - " + latestTimestamp);
    }

    @Then("^searched \"([^\"]*)\" event should appear on search result page$")
    public void searchedEventShouldAppearOnSearchResultPage(String name) {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.searchResult.eventContainer));
        base.searchResult.searchedEventIsDisplayedinSearchResultList(name + " - " + latestTimestamp);
    }

    @When("^I click on the name of the \"([^\"]*)\" event$")
    public void iClickOnTheNameOfTheEvent(String eventName){
        base.searchResult.clickOnTheNameOfTheEvent(eventName, latestTimestamp);
    }

    @Then("^\"([^\"]*)\" event should not appear on search result page$")
    public void eventShouldNotAppearOnSearchResultPage(String name) {
        base.searchResult.eventIsDisplayedOnSearchResultList(name + " - " +latestTimestamp);
    }

}
