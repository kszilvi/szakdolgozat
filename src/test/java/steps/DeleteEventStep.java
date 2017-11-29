package steps;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;

public class DeleteEventStep extends BaseUtil{

    protected BaseUtil base;

    public DeleteEventStep(BaseUtil base) {
        this.base = base;
    }

    @When("^I delete an all day event$")
    public void iDeleteAnAllDayEventOnToday() throws InterruptedException, ParseException {

        do{
            base.main.clickNextButtonOnWeekView();
        }
        while(!base.main.startDateIsOnCurrentPage(base.prop.getProperty("dateOfTheAllDayEvent")));

        base.main.goToParticularEventPage(base.prop.getProperty("nameOfTheAllDayEvent"));
        if(base.edit.assertAndVerifyElement(base.main.dateInEventPreview)) {
            base.delete.deleteButton.click();
        }
        else {
            base.wait.until(ExpectedConditions.elementToBeClickable(base.delete.deleteButtonOnEventDetailedView));
            base.delete.delete();
        }
    }

    @Then("^The removed event should not be displayed in the calendar$")
    public void theRemovedEventShouldNotBeDisplayedInTheCalendar() {
        base.main.isAllDayEventInCalendar(base.prop.getProperty("nameOfTheAllDayEvent"));
    }
}
