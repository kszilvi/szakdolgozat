package steps;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;

public class CreateStep extends BaseUtil{

    protected BaseUtil base;

    public CreateStep(BaseUtil base){
        this.base = base;
    }

    @And("^I create an all day event$")
    public void iCreateAnAllDayEvent() throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox));
        base.create.addNameToEvent(base.prop.getProperty("nameOfTheAllDayEvent")).checkAllDayCheckBox();
        base.create.addStartDate(base.prop.getProperty("dateOfTheAllDayEvent")).addUntilDate(base.prop.getProperty("dateOfTheAllDayEvent"));
        base.create.saveEvent();
    }

    @Then("^All day event should be displayed in the calendar$")
    public void allDayEventShouldBeDisplayedInTheCalendar() throws ParseException, InterruptedException {

        do{
            base.main.clickNextButtonOnWeekView();
        }
        while(!base.main.startDateIsOnCurrentPage(base.prop.getProperty("dateOfTheAllDayEvent")));

        /*boolean running = true;
        while(running) {
            base.main.clickNextButtonOnWeekView();
            if(base.main.startDateIsOnCurrentPage(base.prop.getProperty("dateOfTheAllDayEvent"))) {
                running = false;
            }
        }*/

        base.main.isAllDayEventInCalendar(base.prop.getProperty("nameOfTheAllDayEvent"));
        Thread.sleep(5000);
        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheAllDayEvent"));

        if(base.edit.assertAndVerifyElement(base.preview.date)) {
            base.preview.clickOnEditButton();
        }
        base.wait.until((ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox)));
        base.create.verifyEventDates(base.prop.getProperty("dateOfTheAllDayEvent"), base.prop.getProperty("dateOfTheAllDayEvent"));
    }

    @And("^I create a short time event$")
    public void iCreateAShortTimeEvent() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox));
        base.create.addNameToEvent(base.prop.getProperty("nameOfTheShortTimeEvent"));
        base.create.addStartDate(base.prop.getProperty("startDateOfTheShortTimeEvent")).addFromTime(base.prop.getProperty("fromTimeOfTheShortTimeEvent"));
        base.create.addUntilTime(base.prop.getProperty("untilTimeOfTheShortTimeEvent")).addUntilDate(base.prop.getProperty("untilDateOfTheShortTimeEvent"));
        base.create.saveEvent();
    }

    @Then("^The short time event should be displayed in the calendar$")
    public void theShortTimeEventShouldBeDisplayedInTheCalendar() throws Throwable {

        do{
            base.main.clickNextButtonOnWeekView();
        }
        while(!base.main.startDateIsOnCurrentPage(base.prop.getProperty("startDateOfTheShortTimeEvent")));

        base.main.isShortTimeEventInCalendar(base.prop.getProperty("nameOfTheShortTimeEvent"));
        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheShortTimeEvent"));
        if(base.edit.assertAndVerifyElement(base.preview.date)) {
            base.preview.clickOnEditButton();
        }
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.startDate));
        base.create.verifyEventDates(base.prop.getProperty("startDateOfTheShortTimeEvent"), base.prop.getProperty("untilDateOfTheShortTimeEvent"));
        base.create.verifyEventTimes(base.prop.getProperty("fromTimeOfTheShortTimeEvent"), base.prop.getProperty("untilTimeOfTheShortTimeEvent"));
    }

    @And("^I create a multiple day event$")
    public void iCreateANotAllDayEvent() throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.nameOfTheEventTextBox));
        base.create.addNameToEvent(base.prop.getProperty("nameOfTheMultipleDayEvent"));
        //base.wait.until(ExpectedConditions.elementToBeClickable(base.create.startDate));
        base.create.addStartDate(base.prop.getProperty("startDateOfTheMultipleDayEvent")).addFromTime(base.prop.getProperty("fromTimeOfTheMultipleDayEvent"));
        base.create.addUntilTime(base.prop.getProperty("untilTimeOfTheMultipleDayEvent")).addUntilDate(base.prop.getProperty("untilDateOfTheMultipleDayEvent"));
        base.create.saveEvent();
    }

    @Then("^The multiple day event should be displayed in the calendar$")
    public void theEventShouldBeDisplayedInTheCalendar() throws ParseException, InterruptedException {

        do{
            base.main.clickNextButtonOnWeekView();
        }
        while(!base.main.startDateIsOnCurrentPage(base.prop.getProperty("startDateOfTheMultipleDayEvent")));

        base.main.isAllDayEventInCalendar("(" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent") + ") " + base.prop.getProperty("nameOfTheMultipleDayEvent"));
        base.main.goToParticularEventPage("(" + base.prop.getProperty("fromTimeOfTheMultipleDayEvent") + ") " + base.prop.getProperty("nameOfTheMultipleDayEvent"));
        if(base.edit.assertAndVerifyElement(base.preview.date)) {
            base.preview.clickOnEditButton();
        }
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.startDate));
        base.create.verifyEventDates(base.prop.getProperty("startDateOfTheMultipleDayEvent"), base.prop.getProperty("untilDateOfTheMultipleDayEvent"));
        base.create.verifyEventTimes(base.prop.getProperty("fromTimeOfTheMultipleDayEvent"), base.prop.getProperty("untilTimeOfTheMultipleDayEvent"));
    }
}
