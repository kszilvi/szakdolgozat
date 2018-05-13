package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CreateEventPage {

    @FindBy(css = "input[aria-label='Title']")
    public WebElement nameOfTheEventTextBox;
    @FindBy(id = "xAlDaCbx")
    public WebElement allDayCheckBox;
    @FindBy(id = "xSaveBu")
    public WebElement saveButton;
    @FindBy(css = "input[aria-label='Start date']")
    private WebElement startDate;
    @FindBy(css = "input[aria-label='End date']")
    private WebElement untilDate;
    @FindBy(css = "input[aria-label='Start time']")
    private WebElement fromTime;
    @FindBy(css = "input[aria-label='End time']")
    private WebElement untilTime;
    @FindBy(css = "input[aria-label='Location']")
    public WebElement whereInputField;
    @FindBy(css = "div[aria-label='Description']")
    public WebElement descriptionField;
    @FindBy(css = "div[aria-label='Notification method']")
    public WebElement notificationOption;
    @FindBy(css = "div[aria-label='Unit of time selection']")
    public WebElement unitOptions;
    @FindBy(className = "OA0qNb ncFHed")
    public WebElement notificationContainer;
    @FindBy(css = "content[class='vRMGwf oJeWuf']")
    private List<WebElement> notificationTypes;
    @FindBy(className = "RFS23b")
    public WebElement addNotificationButton;
    @FindBy(className = "kw5sif")
    private WebElement notificationNum;

    public CreateEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public CreateEventPage addNumtoNotification(String num) {
        //notificationNum.clear();
        notificationNum.sendKeys(num);
        return this;
    }

    public String getNotificationNum() {
        return notificationNum.getAttribute("value");
    }

    public List<String> getDropDownItems() {
        return notificationTypes.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private String getNotificationFieldValue() {
        return notificationOption.getText();
    }

    private String getNotificationUnitFieldValue() {
        return unitOptions.getText();
    }

    private void clickOnNotificationType(String type) {
        notificationTypes.forEach(p -> {
            if (p.getText().equals(type)) {
                p.click();
            }
        });
    }

    private void typeDescription(String description) {
        descriptionField.sendKeys(description);
    }

    public void addLocation(String location) {
        if(!location.equals("")){
            whereInputField.sendKeys(location);
        }
    }

    public void addNameToEvent(String name) {
        nameOfTheEventTextBox.sendKeys(name);
    }

    public CreateEventPage checkAllDayCheckBox() {
        allDayCheckBox.click();
        return this;
    }

    public void saveEvent() {
        saveButton.click();
    }

    public CreateEventPage addStartDate(String start) {
        startDate.clear();
        startDate.sendKeys(start);
        return this;
    }

    public void addUntilDate(String endOfDate) {
        untilDate.clear();
        untilDate.sendKeys(endOfDate);
    }

    public void addFromTime(String startTime) {
        fromTime.clear();
        fromTime.sendKeys(startTime);
    }

    public CreateEventPage addUntilTime(String endTime) {
        untilTime.clear();
        untilTime.sendKeys(endTime);
        return this;
    }

    public void addDescription(String description) {
        if (!description.equals("")) {
            descriptionField.clear();
            typeDescription(description);
        }
    }

    public void selectNotificationType(String notificationType) throws InterruptedException {
        if (!getNotificationFieldValue().equals(notificationType)) {
            notificationOption.click();
            Thread.sleep(2000);
            clickOnNotificationType(notificationType);
        }
    }

    public void selectNotificationUnit(String unit) throws InterruptedException {
        if (!getNotificationUnitFieldValue().equals(unit)) {
            unitOptions.click();
            Thread.sleep(2000);
            clickOnNotificationType(unit);
        }
    }
}
