package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    @FindBy(className = "CwaK9")
    public WebElement calendarButton;
    @FindBy(className = "Gw6Zhc")
    public WebElement createButton;
    @FindBy(className = "d6McF")
    public WebElement searchButton;
    @FindBy(css = "button[aria-label='Search']")
    public WebElement searchButton2;
    @FindBy(css = "input[aria-label='Search']")
    public WebElement searchField;
    @FindBy(className = "aGJE1b")
    public WebElement message;
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

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void calendarButtonIsDisplayed() {
        Assert.assertTrue(calendarButton.isDisplayed());
    }

    private String getMessage() {
        return message.getText();
    }

    public void createEventIsDisplayed() {
        Assert.assertTrue(createButton.isDisplayed());
    }

    public void clickOnCtreateButton() {
        createButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnSearchButton2() {
        searchButton2.click();
    }

    public void typeToSearchField(String name) {
        searchField.sendKeys(name);
    }

    public void isMessageMatch(String message) {
        Assert.assertEquals(getMessage(), message);
    }
}
