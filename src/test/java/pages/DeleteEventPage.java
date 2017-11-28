package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEventPage {

    public DeleteEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//DIV[@role='button'][text()='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//DIV[@class='goog-imageless-button-content'][text()='Delete']")
    public WebElement deleteButtonOnEventDetailedView;

    public DeleteEventPage delete() {
        deleteButtonOnEventDetailedView.click();
        return this;
    }
}
