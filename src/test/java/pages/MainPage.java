package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "goog-imageless-button-content")
    public WebElement calendarButton;

    @FindBy(xpath = "//DIV[@class='goog-imageless-button-content'][text()='Create']")
    public WebElement createButton;

    @FindBy(id = "gridcontainer")
    public WebElement eventsContainer;

    @FindBy(className = "neb-date")
    public WebElement dateOfTheEvent;

    @FindBy(id = "currentDate:2")
    public WebElement currentDate;

    @FindBy(id = "navForward:2")
    public WebElement nextButtonOnWeekView;

    @FindBy(className = "neb-date")
    public WebElement dateInEventPreview;

    public MainPage calendarButtonIsDisplayed() {
        Assert.assertEquals(calendarButton.isDisplayed(), true);
        return this;
    }

    public MainPage clickOnCtreateButton() {
        createButton.click();
        return this;
    }

    public MainPage clickNextButtonOnWeekView() {
        nextButtonOnWeekView.click();
        return this;
    }

    public boolean startDateIsOnCurrentPage(String date) throws ParseException {
        SimpleDateFormat date2 = new SimpleDateFormat("MM/dd/yyyy");
        Date date3 = date2.parse(date);
        SimpleDateFormat dt = new SimpleDateFormat("d MMM yyyy");

        String[] dateFromCalendar = currentDate.getText().split(" ");
        String[] startDate = dt.format(date3).split(" ");

        int startDayFromPropFile = Integer.parseInt(startDate[0]);
        String fromMonthFromPropFile = startDate[1];
        String startYearFromPropFile = startDate[2];

        int fromDayOnWeekView, untilDayOnWeekView;
        String fromMonthOnWeekView, fromYearOnWeekView, untilMonthOnWeekView, untilYearOnWeekView;

        boolean isOnPage = false;

        fromDayOnWeekView = Integer.parseInt(dateFromCalendar[0]);

        if(dateFromCalendar.length == 5 ) {
            untilDayOnWeekView = Integer.parseInt(dateFromCalendar[2]);
            fromMonthOnWeekView = dateFromCalendar[3];
            fromYearOnWeekView = dateFromCalendar[4];

            if( ((startDayFromPropFile >= fromDayOnWeekView && startDayFromPropFile <= untilDayOnWeekView) && (fromMonthOnWeekView.equals(fromMonthFromPropFile)) && (fromYearOnWeekView.equals(startYearFromPropFile)) ) ){
                isOnPage = true;
            }
        }
        else if (dateFromCalendar.length == 6 ){
            untilDayOnWeekView = Integer.parseInt(dateFromCalendar[3]);
            fromMonthOnWeekView = dateFromCalendar[1];
            untilMonthOnWeekView = dateFromCalendar[4];
            fromYearOnWeekView = dateFromCalendar[5];

            if( (startDayFromPropFile >= fromDayOnWeekView && startDayFromPropFile <= untilDayOnWeekView) && (fromMonthOnWeekView.equals(fromMonthFromPropFile) || untilMonthOnWeekView.equals(fromMonthOnWeekView) && fromYearOnWeekView.equals(startYearFromPropFile)) ) {
                isOnPage = true;
            }
        }
        else if(dateFromCalendar.length == 7){
            fromMonthOnWeekView = dateFromCalendar[1];
            untilMonthOnWeekView = dateFromCalendar[5];
            untilDayOnWeekView = Integer.parseInt(dateFromCalendar[4]);
            fromYearOnWeekView = dateFromCalendar[2];
            untilYearOnWeekView = dateFromCalendar[6];

            if((startDayFromPropFile >= fromDayOnWeekView || startDayFromPropFile <= untilDayOnWeekView) && ((fromMonthOnWeekView.equals(fromMonthFromPropFile) || untilMonthOnWeekView.equals(fromMonthFromPropFile)) && ((fromYearOnWeekView.equals(startYearFromPropFile) ||  untilYearOnWeekView.equals(startYearFromPropFile))))){
                isOnPage = true;
            }
        }
        return isOnPage;
    }

    public MainPage isAllDayEventInCalendar(String title) {
        List<WebElement> alldayEventsList = eventsContainer.findElements(By.className("rb-ni"));
        boolean isPresent = false;
        for(WebElement e: alldayEventsList) {
            if(e.getText().equals(title)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent, "\"" + title + "\" is not present.");
        return this;
    }

    public MainPage isShortTimeEventInCalendar(String title) {
        List<WebElement> alldayEventsList = eventsContainer.findElements(By.className("cbrd"));
        boolean isPresent = false;

        for(WebElement e: alldayEventsList) {
            if(e.getText().contains(title)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent, "\"" + title + "\" is not present.");
        return this;
    }

    public MainPage goToParticularEventPage (String title) throws InterruptedException {
        List<WebElement> eventsList = eventsContainer.findElements(By.className("rb-ni"));
        eventsList.addAll(eventsContainer.findElements(By.className("cpchip")));
        for(WebElement e: eventsList) {
            if(e.getText().equals(title)) {
                e.click();
                break;
            }
        }
        return this;
    }
}
