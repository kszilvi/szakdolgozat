package steps;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class NotificationStep extends BaseUtil {

    private BaseUtil base;

    public NotificationStep(BaseUtil base){
        this.base = base;
    }

    @When("^I select \"([^\"]*)\" from notification dropdown$")
    public void iSelectFromNotificationDropdown(String notificationType) throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.notificationOption));
        base.create.selectNotificationType(notificationType);
    }


    @When("^I add \"([^\"]*)\" number to notification$")
    public void iAddNumberToNotification(String num) throws Throwable {
        //base.wait.until(ExpectedConditions.elementToBeClickable(base.create.notificationNum));
        /*System.out.println("before "+ base.create.getNotificationNum());
        base.create.addNumtoNotification(num);
        Thread.sleep(3000);
        System.out.println("after "+ base.create.getNotificationNum());
        //base.create.addNumtoNotification(num);
        Thread.sleep(3000);*/
    }

    @When("^I select \"([^\"]*)\" from unit notification dropdown$")
    public void iSelectFromUnitNotificationDropdown(String unit) throws InterruptedException {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.create.unitOptions));
        base.create.selectNotificationUnit(unit);
    }


    @Then("^email should be delivered with \"([^\"]*)\" and \"([^\"]*)\" before \"([^\"]*)\" \"([^\"]*)\" of even start$")
    public void emailShouldBeDeliveredWithAndBeforeOfEvenStart(String name, String emailAddress, String num, String unit) throws MessagingException, InterruptedException, IOException {
        System.out.println(base.helper.subject(name, emailAddress));
        base.helper.isEmailMatch(base.prop, name, emailAddress);

    }



    @When("^I change the date for the event$")
    public void iChangeTheDateForTheEvent()  {
        base.create.checkAllDayCheckBox().checkAllDayCheckBox();
        base.create.addStartDate(base.helper.getCurrentDay()).addFromTime(base.helper.convertLocalDateTimeToStringOnlyHours(base.helper.getTimeStampPlusXMinutes(10)));
        base.create.addUntilTime(base.helper.convertLocalDateTimeToStringOnlyHours(base.helper.getTimeStampPlusXMinutes(10))).addUntilDate(base.helper.getCurrentDay());
    }
}
