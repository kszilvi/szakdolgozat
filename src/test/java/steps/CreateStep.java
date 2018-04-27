package steps;

import base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.text.ParseException;

public class CreateStep extends BaseUtil{

    private BaseUtil base;

    public CreateStep(BaseUtil base){
        this.base = base;
    }

    @Then("^\"([^\"]*)\" event should be displayed in the calendar from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void eventShouldBeDisplayedInTheCalendarFromTo(String arg0, String arg1, String arg2) throws Throwable {

    }

    @Then("^The creating new event page should be displayed$")
    public void theCreatingNewEventPageShouldBeDisplayed() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox));
    }

    @And("^Check the \"([^\"]*)\" check box$")
    public void checkTheCheckBox(String arg0) {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.allDayCheckBox));
        base.create.checkAllDayCheckBox();
    }

    @And("^I click on \"([^\"]*)\" button$")
    public void iClickOnButton(String arg0) {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.saveButton));
        base.create.saveEvent();
    }

    @Then("^I should see the Create Event button$")
    public void iShouldSeeTheCreateEventButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.createButton));
        base.main.createEventIsDisplayed();
    }

    @And("^I add \"([^\"]*)\" to from date field$")
    public void iAddToFromDateField(String arg0) {
        base.create.addStartDate(arg0);
    }

    @And("^I add \"([^\"]*)\" to from time field$")
    public void iAddToFromTimeField(String arg0) {
        base.create.addFromTime(arg0);
    }

    @And("^I add \"([^\"]*)\" to until date field$")
    public void iAddToUntilDateField(String arg0) {
        base.create.addUntilDate(arg0);
    }

    @And("^I add \"([^\"]*)\" to until time field$")
    public void iAddToUntilTimeField(String arg0) {
        base.create.addUntilTime(arg0);
    }

    @When("^I type \"([^\"]*)\" to title field$")
    public void iTypeToTitleField(String arg0) {
        base.create.addNameToEvent(arg0/* + base.main.getCurrentTimestamp()*/);
    }

    @And("^I click on the name of the \"([^\"]*)\" event$")
    public void iClickOnTheNameOfTheEvent(String arg0) {
        if(base.main.isAllDayEventInCalendar(arg0)) {
            base.main.goToParticularEventPage(arg0 + "\n" + ", " + "\n" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent"));
        }
        base.main.goToParticularEventPage(arg0);
    }

    @And("^I click on Edit button$")
    public void iClickOnEditButton() {
        base.preview.clickOnEditButton();
    }

    @Then("^Event should appear from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void eventShouldAppearFromTo(String arg0, String arg1) throws ParseException, InterruptedException {
        base.create.verifyEventDates(arg0, arg1);
    }

    @And("^I click on the name of the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" event$")
    public void iClickOnTheNameOfTheEvent(String arg0, String arg1, String arg2) throws Throwable {
        if(base.main.isAllDayEventInCalendar(arg0)) {
            base.main.goToParticularEventPage(arg0 + "\n" + ", " + "\n" + arg1);
        }
        base.main.goToParticularEventPage(arg0);
    }

    @And("^I click on the Save button$")
    public void iClickOnTheSaveButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.saveButton));
        base.create.saveEvent();
    }

    @And("^Message should appear with the following text: \"([^\"]*)\"$")
    public void messageShouldAppearWithTheFollowingText(String arg0) {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.main.message));
        Assert.assertEquals(base.main.getMessage(), arg0);
    }

    @Then("^Search result page should be displayed$")
    public void searchResultPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(base.searchResult.goBackButton.isDisplayed(), "Go back button isn't visible");
    }

    @And("^I check the All day check box$")
    public void iCheckTheAllDayCheckBox() throws Throwable {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.allDayCheckBox));
        base.create.checkAllDayCheckBox();
    }

    @When("^I click on the created \"([^\"]*)\" event$")
    public void iClickOnTheCreatedEvent(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click on the Edit button$")
    public void iClickOnTheEditButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Event editing page should be displayed$")
    public void eventEditingPageShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
