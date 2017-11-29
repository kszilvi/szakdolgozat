package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateEventPage {

    public CreateEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //@FindBy(xpath = "//INPUT[@title='Event title']")
    //public WebElement nameOfTheEventTextBox;

    @FindBy(css = "input[title='Event title']")
    public WebElement nameOfTheEventTextBox;

    @FindBy(className = "checkbox")
    public WebElement allDayCheckBox;

    @FindBy (xpath = "//DIV[@class='goog-imageless-button-content'][text()='Save']")
    public WebElement saveButton;

    @FindBy(css = "input[title='From date']")
    public WebElement startDate;

    @FindBy(css = "input[title='Until date']")
    public WebElement untilDate;

    @FindBy(css = "input[title='From time']")
    public WebElement fromTime;

    @FindBy(css = "input[title='Until time']")
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

    public CreateEventPage verifyEventDates(String fromDate, String endOfDate) throws InterruptedException {
        boolean equal = fromDate.equals(startDate.getAttribute("value")) && (untilDate.getAttribute("value").equals(endOfDate));
        Assert.assertTrue(equal, " dates are different");
        return this;
    }

    public CreateEventPage verifyEventTimes(String startTime, String endOfTime) throws InterruptedException {
        boolean equal = startTime.equals(fromTime.getAttribute("value")) && (untilTime.getAttribute("value").equals(endOfTime));
        Assert.assertTrue(equal, " dates are different");
        return this;
    }
}
