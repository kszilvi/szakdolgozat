package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EventPreviewPage {

    public EventPreviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "neb-date")
    public WebElement date;

    @FindBy(css = "div[aria-label='Edit event']")
    public WebElement editButton;

    @FindBy(className = "AP8Kec")
    public WebElement location;

    @FindBy(id = "xDetDlgDesc")
    public WebElement description;

    @FindBy(id = "xDetDlgDelBu")
    public WebElement deleteButton;

    @FindBy(id = "xDetDlgNot")
    public WebElement notification;

    public void clickOnEditButton() {
        editButton.click();
    }

    public String getLocationFromPreview(){
        return location.getText();
    }

    public String getDescription(){
        return description.getText();
    }

    public void clickOnDeleteButton(){
        deleteButton.click();
    }

    public EventPreviewPage editButtonIsDisplayedOnPreviewPage(){
        Assert.assertTrue(editButton.isDisplayed(), "Edit button isn't displayed");
        return this;
    }

    public EventPreviewPage locationIsDisplayedOnPreviewPage(String location){
        if(!location.equals("")){
            Assert.assertEquals(getLocationFromPreview(), location, "location doesn't appear on preview page");
        }
        return this;
    }

    public EventPreviewPage descriptionIsDisplayedInPreviewPage(String description){
        if(!description.equals("")){
            Assert.assertEquals(getDescription(), "Description:" + "\n" + description, "description doesn't appear with correct description text on preview page");
        }
        return this;
    }

}
