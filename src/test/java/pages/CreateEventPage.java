package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(css = "input[aria-label='Location']")
    public WebElement whereInputField;

    @FindBy (id = "hInySc0")
    public WebElement descriptionField;

    @FindBy(css = "div[aria-label='Notification method']")
    public WebElement notificationOption;

    @FindBy(css = "div[aria-label='Unit of time selection']")
    public WebElement unitOptions;

    @FindBy(className = "OA0qNb ncFHed")
    public WebElement notificationContainer;

    @FindBy(css = "content[class='vRMGwf oJeWuf']")
    public List<WebElement> notificationTypes;

    @FindBy(className = "RFS23b")
    public WebElement addNotificationButton;

    @FindBy(className = "kw5sif")
    public WebElement notificationNum;

    public CreateEventPage addNumtoNotification(String num){
        //notificationNum.clear();
        notificationNum.sendKeys(num);
        return this;
    }

    public CreateEventPage clickOnAddNotification(){
        addNotificationButton.click();
        return this;
    }

    public String getNotificationNum(){
        return notificationNum.getAttribute("value");
    }

    public List<String> getDropDownItems(){
        return notificationTypes.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getNotificationFieldValue(){
        return notificationOption.getText();
    }

    public String getNotificationUnitFieldValue(){
        return unitOptions.getText();
    }

    public void clickOnNotificationType(String type){
        notificationTypes.forEach(p ->{
            if(p.getText().equals(type)){
                p.click();
            }
        });
    }

    public CreateEventPage typeDescription(String description){
        descriptionField.sendKeys(description);
        return this;

    }

    public String getTimestampValueFromName(String name){
        String[] nameWithTimestamp = nameOfTheEventTextBox.getText().split("-");
        return nameWithTimestamp[1];
    }

    public CreateEventPage addLocation(String location){
        whereInputField.sendKeys(location);
        return this;
    }

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

    public String getTimestampFromNameFieldValue(){
       return nameOfTheEventTextBox.getText();
        //return Arrays.stream(name.split(" - "))
         //      .reduce((first, second) -> second).get();
    }

    public CreateEventPage addDescription(String description){
        if(!description.equals("")){
            descriptionField.clear();
            typeDescription(description);
        }
        return this;
    }

    public CreateEventPage selectNotificationType(String notificationType) throws InterruptedException {
        if(!getNotificationFieldValue().equals(notificationType)){
            notificationOption.click();
            Thread.sleep(2000);
            clickOnNotificationType(notificationType);
        }
        return this;
    }

    public CreateEventPage selectNotificationUnit(String unit) throws InterruptedException {

        if(!getNotificationUnitFieldValue().equals(unit)){
            unitOptions.click();
            Thread.sleep(2000);
            clickOnNotificationType(unit);
        }
        return this;
    }
}
