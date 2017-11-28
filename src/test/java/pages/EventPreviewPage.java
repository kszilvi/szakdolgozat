package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventPreviewPage {

    public EventPreviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "neb-date")
    public WebElement date;

    @FindBy (xpath = "//DIV[@role='button'][text()='Edit event']")
    public WebElement editButton;

    public void clickOnEditButton() {
        editButton.click();
    }

}
