package steps;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;

public class EditEventStep extends BaseUtil{

    protected BaseUtil base;

    public EditEventStep(base.BaseUtil base){
        this.base = base;
    }

    @When("^I select a multiple day event$")
    public void iSelectAMultipleDayEvent() throws ParseException, InterruptedException {
        do{
            base.main.clickNextButtonOnWeekView();
        }
        while(!base.main.startDateIsOnCurrentPage(base.prop.getProperty("startDateOfTheMultipleDayEvent")));

        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheMultipleDayEvent") + "\n" + ", " + "\n" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent"));
        base.preview.clickOnEditButton();
    }

    @And("^I add a location to the selected event$")
    public void iAddALocationToTheSelectedEvent() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.edit.whereInputField));
        base.edit.addLocation(base.prop.getProperty("locationOfTheMultipleDayEvent"));
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.saveButton));
        base.create.saveEvent();
    }

    @Then("^The location should be displayed$")
    public void theLocationShouldBeDisplayed() {
        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheMultipleDayEvent") + "\n" + ", " + "\n" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent"));
        base.preview.clickOnEditButton();
        base.edit.verifyLocation(base.prop.getProperty("locationOfTheMultipleDayEvent"));
    }

    @When("^I select an event$")
    public void iSelectAnEvent() throws Throwable {
        do{
            base.main.clickNextButtonOnWeekView();
        }
        while(!base.main.startDateIsOnCurrentPage(base.prop.getProperty("startDateOfTheMultipleDayEvent")));

        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheMultipleDayEvent") + "\n" + ", " + "\n" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent"));
        base.preview.clickOnEditButton();
    }

    @And("^I add a description to the selected event$")
    public void iAddADescriptionToTheSelectedEvent() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.edit.descriptionInputField));
        base.edit.addDescription(base.prop.getProperty("description"));
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.saveButton));
        base.create.saveEvent();
    }

    @Then("^The description should be displayed$")
    public void theDescriptionShouldBeDisplayed() throws Throwable {
        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheMultipleDayEvent") + "\n" + ", " + "\n" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent"));
        base.preview.clickOnEditButton();
        base.edit.verifyDescriptions(base.prop.getProperty("description"));
    }
}
