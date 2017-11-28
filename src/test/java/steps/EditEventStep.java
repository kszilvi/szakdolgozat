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
        boolean running = true;
        while(running) {
            base.main.clickNextButtonOnWeekView();
            if(base.main.startDateIsOnCurrentPage(base.prop.getProperty("startDateOfTheMultipleDayEvent"))) {
                running = false;
            }
        }
        base.main.goToParticularEventPage("(" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent") + ") " + base.prop.getProperty("nameOfTheMultipleDayEvent"));
        if(base.edit.assertAndVerifyElement(base.preview.date)) {
            base.preview.clickOnEditButton();
        }
    }

    @And("^I add a location to the selected event$")
    public void iAddALocationToTheSelectedEvent() throws InterruptedException {
        if(base.edit.assertAndVerifyElement(base.edit.whereLink)) {
            base.edit.clickOnWhereLink();
        }
        base.wait.until(ExpectedConditions.elementToBeClickable(base.edit.whereInputField));
        base.edit.addLocation(base.prop.getProperty("locationOfTheMultipleDayEvent"));
        base.create.saveEvent();
    }

    @Then("^The location should be displayed$")
    public void theLocationShouldBeDisplayed() throws InterruptedException {
        base.main.goToParticularEventPage("(" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent") + ") " + base.prop.getProperty("nameOfTheMultipleDayEvent") + " - " + base.prop.getProperty("locationOfTheMultipleDayEvent"));
    }
}
