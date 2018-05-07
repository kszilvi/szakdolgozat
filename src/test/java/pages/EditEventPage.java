package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditEventPage {

    public EditEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[aria-label='Location']")
    public WebElement whereInputField;

    //what
    @FindBy(className = "Sz0nN b4sm0d")
    public WebElement descriptionInputField;

    @FindBy (className = "ep-dp-input")
    public WebElement whereLink;

    public EditEventPage clickOnWhereLink() {
        whereLink.click();
        return this;
    }

    public EditEventPage addDescription(String description){
        descriptionInputField.clear();
        descriptionInputField.sendKeys(description);
        return this;
    }

    public EditEventPage addLocation(String location){
        whereInputField.clear();
        whereInputField.sendKeys(location);
        return this;
    }

    public boolean assertAndVerifyElement(WebElement element) {
        boolean isPresent = false;
            try {
                if (element.isDisplayed()) {
                    isPresent = true;
                }
            } catch (Exception e) {
                System.out.println(element + "is not displayed");
            }

        return isPresent;
    }

    public EditEventPage verifyLocation(String locationFromPropFile) {
        boolean equal = locationFromPropFile.equals(whereInputField.getAttribute("value"));
        Assert.assertTrue(equal, " locations don't match from prop file and from calendar");
        return this;
    }

    public EditEventPage verifyDescriptions(String descriptionFromPropFile) {
        boolean equal = descriptionFromPropFile.equals(descriptionInputField.getAttribute("value"));
        Assert.assertTrue(equal, " locations don't match from prop file and from calendar");
        return this;
    }
}
