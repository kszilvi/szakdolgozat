package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateEventPage {

    public CreateEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[aria-label='Title']")
    public WebElement nameOfTheEventTextBox;

    @FindBy(id = "xAlDaCbx")
    public WebElement allDayCheckBox;

    @FindBy (id = "xSaveBu")
    public WebElement saveButton;

    @FindBy(css = "input[aria-label='Start date']")
    public WebElement startDate;

    @FindBy(css = "input[aria-label='End date']")
    public WebElement untilDate;

    @FindBy(css = "input[aria-label='Start time']")
    public WebElement fromTime;

    @FindBy(css = "input[aria-label='End time']")
    public WebElement untilTime;

    public CreateEventPage addNameToEvent(String name){
        nameOfTheEventTextBox.sendKeys(name);
        return this;
    }

    public CreateEventPage checkAllDayCheckBox(){
        allDayCheckBox.click();
        return this;
    }

    public CreateEventPage saveEvent() {
        saveButton.click();
        return this;
    }

    public CreateEventPage addStartDate(String start) {
        startDate.clear();
        startDate.sendKeys(start);
        return this;
    }

    public CreateEventPage addUntilDate(String endOfDate) {
        untilDate.clear();
        untilDate.sendKeys(endOfDate);
        return this;
    }

    public CreateEventPage addFromTime(String startTime) {
        fromTime.clear();
        fromTime.sendKeys(startTime);
        return this;
    }

    public CreateEventPage addUntilTime(String endTime) {
        untilTime.clear();
        untilTime.sendKeys(endTime);
        return this;
    }

    public String dateFormatterFromPropFileToCalendarDateFormat(String dateFromPropFile) throws ParseException {
        SimpleDateFormat date2 = new SimpleDateFormat("M/d/yyyy");
        Date date3 = date2.parse(dateFromPropFile);
        SimpleDateFormat dt = new SimpleDateFormat("d MMM yyyy");
        return dt.format(date3);
    }

    public CreateEventPage verifyEventDates(String fromDate, String endOfDate) throws InterruptedException, ParseException {
        fromDate = dateFormatterFromPropFileToCalendarDateFormat(fromDate);
        endOfDate = dateFormatterFromPropFileToCalendarDateFormat(endOfDate);
        boolean equal = fromDate.equals(startDate.getAttribute("value")) && (untilDate.getAttribute("value").equals(endOfDate));
        Assert.assertTrue(equal, " dates are different");
        return this;
    }

    public CreateEventPage verifyEventTimes(String startTime, String endOfTime) {
        boolean equal = startTime.equals(fromTime.getAttribute("value")) && (untilTime.getAttribute("value").equals(endOfTime));
        Assert.assertTrue(equal, " dates are different");
        return this;
    }
}
