package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "CwaK9")
    public WebElement calendarButton;

    @FindBy(className = "Gw6Zhc")
    public WebElement createButton;

    @FindBy(id = "YPCqFe")
    public WebElement eventsContainer;

    @FindBy(css = "div[aria-label='Next week']")
    public WebElement nextButtonOnWeekView;

    @FindBy(className = "neb-date")
    public WebElement dateInEventPreview;

    @FindBy(className = "rpCPrc")
    public WebElement currentDate;

    @FindBy(className = "JE11kf")
    public WebElement all;

    @FindBy(className = "KaL5Wc")
    public WebElement monthAndYearFromCalendar;

    @FindBy(className = "d6McF")
    public WebElement searchButton;

    @FindBy(css = "button[aria-label='Search']")
    public WebElement searchButton2;

    @FindBy(css = "input[aria-label='Search']")
    public WebElement searchField;

    @FindBy(className = "aGJE1b")
    public WebElement message;

    public MainPage calendarButtonIsDisplayed() {
        Assert.assertEquals(calendarButton.isDisplayed(), true);
        return this;
    }

    public String getMessage(){
        return message.getText();
    }

    public MainPage createEventIsDisplayed() {
        Assert.assertEquals(createButton.isDisplayed(), true);
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

    public MainPage clickOnSearchButton(){
        searchButton.click();
        return this;
    }

    public MainPage clickOnSearchButton2(){
        searchButton2.click();
        return this;
    }

    public MainPage typeToSearchField(String name){
        searchField.sendKeys(name);
        return this;
    }

    public boolean startDateIsOnCurrentPage(String date) throws ParseException, InterruptedException {
        SimpleDateFormat date2 = new SimpleDateFormat("MM/dd/yyyy");
        Date date3 = date2.parse(date);

        String[] dateFromCalendar = monthAndYearFromCalendar.getText().split(" ");

        String fromMonthOnWeekView, fromYearOnWeekView, untilMonthOnWeekView, untilYearOnWeekView;

        boolean isOnPage = false;

        // April 2018
        if(dateFromCalendar.length == 2 ) {
            SimpleDateFormat dt = new SimpleDateFormat("d MMMM yyyy");
            String[] startDate = dt.format(date3).split(" ");

            String startDayFromPropFile = startDate[0];
            String fromMonthFromPropFile = startDate[1];
            String startYearFromPropFile = startDate[2];
            fromMonthOnWeekView = dateFromCalendar[0];
            fromYearOnWeekView = dateFromCalendar[1];

            if(getDaysFromCalendarWeekView().contains(startDayFromPropFile) && fromMonthFromPropFile.equals(fromMonthOnWeekView) && startYearFromPropFile.equals(fromYearOnWeekView)) {
                isOnPage = true;
            }

        }
        // APR - MAY 2018
        else if (dateFromCalendar.length == 4 ){

            SimpleDateFormat dt = new SimpleDateFormat("d MMM yyyy");
            String[] startDate = dt.format(date3).split(" ");

            String startDayFromPropFile = startDate[0];
            String fromMonthFromPropFile = startDate[1];
            String startYearFromPropFile = startDate[2];

            fromMonthOnWeekView = dateFromCalendar[0];
            untilMonthOnWeekView = dateFromCalendar[2];
            fromYearOnWeekView = dateFromCalendar[3];

            if(getDaysFromCalendarWeekView().contains(startDayFromPropFile) && (fromMonthOnWeekView.equals(fromMonthFromPropFile) || untilMonthOnWeekView.equals(fromMonthOnWeekView) && fromYearOnWeekView.equals(startYearFromPropFile))) {
                isOnPage = true;
            }

        }
        // DEC 2018 - JAN 2019
        else if(dateFromCalendar.length == 5){
            SimpleDateFormat dt = new SimpleDateFormat("d MMM yyyy");
            String[] startDate = dt.format(date3).split(" ");

            String startDayFromPropFile = startDate[0];
            String fromMonthFromPropFile = startDate[1];
            String startYearFromPropFile = startDate[2];

            fromMonthOnWeekView = dateFromCalendar[0];
            untilMonthOnWeekView = dateFromCalendar[3];
            fromYearOnWeekView = dateFromCalendar[1];
            untilYearOnWeekView = dateFromCalendar[4];

            if(getDaysFromCalendarWeekView().contains(startDayFromPropFile) && (fromMonthOnWeekView.equals(fromMonthFromPropFile) || untilMonthOnWeekView.equals(fromMonthOnWeekView) && (fromYearOnWeekView.equals(startYearFromPropFile)) || untilYearOnWeekView.equals(startYearFromPropFile))) {
                isOnPage = true;
            }
        }
        return isOnPage;
    }

    public List getDaysFromCalendarWeekView() throws InterruptedException {
        //This wait is needed to avoid stale element
        Thread.sleep(500);
        List<WebElement> days = all.findElements(By.className("rpCPrc"));
        List<String> daysFromCalendarList = new ArrayList<>();

        for(WebElement e: days){
            String dates[] = e.getText().split("\n");
            daysFromCalendarList.add(dates[1]);
        }
        return daysFromCalendarList;
    }

    public boolean isAllDayEventInCalendar(String title) {
        List<WebElement> alldayEventsList = eventsContainer.findElements(By.className("c1wk3e"));
        boolean isPresent = false;
        for(WebElement e: alldayEventsList) {
            if(e.getText().equals(title)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent, "\"" + title + "\" is not present.");
        return isPresent;
    }

    public boolean isShortTimeEventInCalendar(String title) {
        List<WebElement> alldayEventsList = eventsContainer.findElements(By.className("cbrd"));
        boolean isPresent = false;

        for(WebElement e: alldayEventsList) {
            if(e.getText().contains(title)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent, "\"" + title + "\" is not present.");
        return isPresent;
    }

    public MainPage goToParticularEventPage (String title) {
        List<WebElement> eventsList = eventsContainer.findElements(By.className("c1wk3e"));
        eventsList.addAll(eventsContainer.findElements(By.className("FAxxKc")));
        for(WebElement e: eventsList) {
            if(e.getText().equals(title)) {
                e.click();
                break;
            }
        }
        return this;
    }

    public MainPage isMessageMatch(String message){
         Assert.assertEquals(getMessage(), message);
         return this;
    }
}
