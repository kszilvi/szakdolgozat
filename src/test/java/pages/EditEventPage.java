package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditEventPage {

    public EditEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//INPUT[@placeholder='Enter a location']")
    public WebElement whereInputField;

    @FindBy (className = "ep-dp-input")
    public WebElement whereLink;

    public EditEventPage clickOnWhereLink() {
        whereLink.click();
        return this;
    }

    public EditEventPage addLocation(String location){
        whereInputField.sendKeys(location);
        return this;
    }

    public boolean assertAndVerifyElement(WebElement element) throws InterruptedException {
        boolean isPresent = false;
            try {
                if (element.isDisplayed()) {
                    isPresent = true;
                }
            } catch (Exception e) {
                Thread.sleep(1000);
            }

        return isPresent;
    }


}
