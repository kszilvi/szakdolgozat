package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EventPreviewPage {

    @FindBy(className = "neb-date")
    public WebElement date;
    @FindBy(css = "div[aria-label='Edit event']")
    public WebElement editButton;
    @FindBy(id = "xDetDlgDelBu")
    public WebElement deleteButton;
    @FindBy(id = "xDetDlgNot")
    public WebElement notification;
    @FindBy(className = "AP8Kec")
    private WebElement location;
    @FindBy(id = "xDetDlgDesc")
    private WebElement description;

    public EventPreviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnEditButton() {
        editButton.click();
    }

    private String getLocationFromPreview() {
        return location.getText();
    }

    private String getDescription() {
        return description.getText();
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }

    public void editButtonIsDisplayedOnPreviewPage() {
        Assert.assertTrue(editButton.isDisplayed(), "Edit button isn't displayed");
    }

    public void locationIsDisplayedOnPreviewPage(String location) {
        if (!location.equals("")) {
            Assert.assertEquals(getLocationFromPreview(), location, "location doesn't appear on preview page");
        }
    }

    public void descriptionIsDisplayedInPreviewPage(String description) {
        if (!description.equals("")) {
            Assert.assertEquals(getDescription(), "Description:" + "\n" + description, "description doesn't appear with correct description text on preview page");
        }
    }
}
